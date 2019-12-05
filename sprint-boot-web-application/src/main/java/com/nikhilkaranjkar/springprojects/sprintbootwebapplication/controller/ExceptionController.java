package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ExceptionController {
  
  private Log logger = LogFactory.getLog(ExceptionController.class);
  
  @ExceptionHandler(Exception.class)
  public ModelAndView handleError(HttpServletRequest request, HttpServletResponse response,Exception ex)
  {
    logger.error("Request: "+request.getRequestURI() +" raised"+ex);
    ModelAndView mav = new ModelAndView();
    mav.addObject("exception",ex);
    mav.addObject("url",request.getRequestURI());
    mav.setViewName("customerror");
    return mav;
  }
  
}
