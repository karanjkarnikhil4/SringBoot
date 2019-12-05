package com.nikhilkaranjkar.springprojects.sprintbootwebapplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.nikhilkaranjkar.springprojects.sprintbootwebapplication.model.Todo;;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "nikhil", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "nikhil", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "nikhil", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    
    
    
    
    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }
    
    public void updateTodo(Todo todo)
    {
     todos.remove(todo);
     todos.add(todo);
    }
    
    public Optional<Todo> getTodo(int id) {
    return todos.stream().filter(todo->todo.getId()==id).findFirst();
}

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}
