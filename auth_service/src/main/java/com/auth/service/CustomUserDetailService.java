package com.auth.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.dto.LoginDto;
import com.auth.pojo.User;
import com.auth.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found....."));
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

		return org.springframework.security.core.userdetails.User.builder().username(user.getUsername())
				.password(user.getPassword()).build();
	}

	public String authenticateUser(LoginDto userDto) throws UsernameNotFoundException {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails authenticatedUser = loadUserByUsername(userDto.getUsername());
		String jwtToken = jwtService.generateToken(authenticatedUser);
		return jwtToken;
	}

}
