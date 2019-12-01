package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//login --> Hello World
@Controller
public class LoginController {
	
	
	@RequestMapping(value ="/login",method = RequestMethod.GET)
	public String showLoginPage()
	{
		
		return "login";
	}
	
	
	@RequestMapping(value ="/login",method = RequestMethod.POST)
	public String loginMessage(@RequestParam String name, ModelMap model)
	{
		model.put("name", name);
		return "welcome";
	}

}
