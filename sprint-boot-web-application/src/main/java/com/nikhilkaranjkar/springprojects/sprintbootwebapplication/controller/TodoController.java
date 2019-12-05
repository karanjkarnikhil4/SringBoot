package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.nikhilkaranjkar.springprojects.sprintbootwebapplication.model.Todo;
import com.nikhilkaranjkar.springprojects.sprintbootwebapplication.service.TodoService;

// login --> Hello World
@Controller
@SessionAttributes(names = "name")
public class TodoController {

  
  
  @Autowired
  private TodoService todoService;
  
  
  @InitBinder
  protected void initBinder(WebDataBinder binder) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      binder.registerCustomEditor(Date.class, new CustomDateEditor(
              dateFormat, false));
  }
  

  @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
  public String listTodos(ModelMap model) {
    String name = getUserName(model);
    model.put("todoList", todoService.retrieveTodos(name));
    return "Todo";
  }

  @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
  public String addTodos(ModelMap model) {
    model.addAttribute("todo",
        new Todo(0, getUserName(model), "Default desc", new Date(), false));
    return "addTodo";
  }


  private String getUserName(ModelMap model) {
    return (String) model.get("name");
  }

  @RequestMapping(value = "/updateTodo", method = RequestMethod.GET)
  public String getTobeUpdatedTodo(@RequestParam int id, ModelMap model) {
    Todo todo = todoService.getTodo(id).get();
    model.addAttribute(todo);
    return "addTodo";
  }
  
  @RequestMapping(value = "/updateTodo", method = RequestMethod.POST)
  public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
    Todo existingTodo = todo;
    if (todoService.getTodo(todo.getId()).isPresent()) {
      existingTodo = todoService.getTodo(todo.getId()).get();
      existingTodo.setDone(todo.getIsDone());
      existingTodo.setDesc(todo.getDesc());
      existingTodo.setTargetDate(todo.getTargetDate());
      existingTodo.setUser(todo.getUser());
      todoService.updateTodo(existingTodo);
    }
    return "redirect:/list-todos";
  }

  @RequestMapping(value = "/deleteTodo", method = RequestMethod.GET)
  public String deleteTodo(@RequestParam int id) {
    todoService.deleteTodo(id);
    return "redirect:/list-todos";
  }

  @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
  public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
     
        todoService.addTodo(todo.getUser(), todo.getDesc(), todo.getTargetDate(), todo.getIsDone());
      return "redirect:/list-todos";
    }

    else {
      return "addTodo";
    }
  }

}
