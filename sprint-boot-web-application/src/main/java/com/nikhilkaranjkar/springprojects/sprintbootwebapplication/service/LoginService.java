package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean validate(String userName, String password)
	{
		//nikhil
		//karanjkar
		return userName.equals("nikhil") && password.equals("karanjkar");
	}

}
