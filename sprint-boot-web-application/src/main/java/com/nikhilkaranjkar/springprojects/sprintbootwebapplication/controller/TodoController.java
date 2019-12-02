package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nikhilkaranjkar.springprojects.sprintbootwebapplication.service.LoginService;
import com.nikhilkaranjkar.springprojects.sprintbootwebapplication.service.TodoService;

//login --> Hello World
@Controller
@SessionAttributes(names  = "name")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value ="/list-todos",method = RequestMethod.GET)
	public String listTodos(ModelMap model)
	{
		String name = (String) model.get("name");
		model.put("todoList", todoService.retrieveTodos(name));
		return "Todo";
	}
	
	
	@RequestMapping(value ="/addTodo",method = RequestMethod.GET)
	public String addTodos(ModelMap model)
	{
		return "addTodo";
	}
	
	
	@RequestMapping(value ="/addTodo",method = RequestMethod.POST)
	public String addNewTodo(ModelMap model,@RequestParam String description)
	{
		todoService.addTodo(model.get("name").toString(), description, new Date(), false);
		return "redirect:/list-todos";
	}
	
	
}
