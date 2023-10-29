package com.in28minutes.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		boolean isValidUserName = username.equalsIgnoreCase("Abhishek");
		boolean isValidPassword = password.equalsIgnoreCase("Admin");
		return isValidUserName && isValidPassword;
	}
}
