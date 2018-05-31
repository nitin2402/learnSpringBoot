package com.example.crudRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
@Autowired
private TodoService todoService;

@GetMapping("users/{name}/todos")
public List<Todo> retrieveTodos(@PathVariable String name){
	return todoService.retrieveTodos(name);
}
}
