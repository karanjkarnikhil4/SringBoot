package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

// login --> Hello World
@Controller
@SessionAttributes(names = "name")
public class WelcomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showLoginPage(ModelMap modelMap) {

    modelMap.put("name", "nikhil");
    return "welcome";
  }
  
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logOut(HttpServletRequest servletRequest, HttpServletResponse response) {
     Authentication authentication=  SecurityContextHolder.getContext().getAuthentication();
     if(authentication!=null)
     {
       new SecurityContextLogoutHandler().logout(servletRequest, response, authentication);
     }
     
     return "redirect:/";
  }

}
