package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.dto.LoginDto;
import com.auth.service.CustomUserDetailService;

/**
 * @author Nehal Mahajan
 * @apiNote RestController class for Authentication operation
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@GetMapping("/token")
	private String authenticateUser(@RequestBody LoginDto loginDto) {
		return customUserDetailService.authenticateUser(loginDto);
	}

}
