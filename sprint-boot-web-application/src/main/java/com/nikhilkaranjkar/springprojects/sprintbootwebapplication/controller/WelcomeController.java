package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.nikhilkaranjkar.springprojects.sprintbootwebapplication.service.LoginService;

// login --> Hello World
@Controller
@SessionAttributes(names = "name")
public class WelcomeController {

  @Autowired
  private LoginService loginService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showLoginPage(ModelMap modelMap) {

    modelMap.put("name","nikhil");
    return "welcome";
  }

}
