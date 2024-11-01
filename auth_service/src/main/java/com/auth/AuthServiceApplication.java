package com.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.auth.utility.AutoLoadUtility;

@SpringBootApplication
public class AuthServiceApplication implements CommandLineRunner {

	@Autowired
	private AutoLoadUtility autoLoadUtility;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		autoLoadUtility.autoLoad();

	}

}
