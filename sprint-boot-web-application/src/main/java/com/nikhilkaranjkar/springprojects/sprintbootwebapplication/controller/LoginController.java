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
public class LoginController {

  @Autowired
  private LoginService loginService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String showLoginPage() {

    return "login";
  }


  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String loginMessage(@RequestParam String name, @RequestParam String password,
      ModelMap model) {
    if (loginService.validate(name, password)) {
      model.put("name", name);
      return "welcome";
    }

    else {
      model.put("errorMessage", "invalid credentials");
      return "login";
    }
  }

}
