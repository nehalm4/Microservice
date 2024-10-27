package com.auth.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.auth.pojo.User;
import com.auth.repository.UserRepository;

/**
 * @author Nehal Mahajan
 * @apiNote Auto Load Utility class to load the data on application start
 */
@Component
public class AutoLoadUtility {

	@Autowired
	private UserRepository userRepository;

	private final PasswordEncoder encoder = new BCryptPasswordEncoder();

	public void autoLoad() {


		User user1 = new User();
		user1.setUsername("nehal");
		user1.setPassword(encoder.encode("pass"));
		user1.setEmail("nehalm4@gmail.com");
//		Set<Role> roles1 = new HashSet<>();
//		roles1.add(Role.ROLE_ADMIN);
//		user1.setAuthorities(roles1);
//		userRepository.save(user1);

		User user2 = new User();
		user2.setUsername("swati");
		user2.setPassword(encoder.encode("pass"));
		user2.setEmail("swati@gmail.com");
//		Set<Role> roles2 = new HashSet<>();
//		roles2.add(Role.ROLE_USER);
//		user2.setAuthorities(roles2);
//		userRepository.save(user2);
	}

}
