package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//login --> Hello World
@Controller
public class LoginController {
	
	
	@RequestMapping("/login")
	public String loginMessage()
	{
		return "login";
	}

}
