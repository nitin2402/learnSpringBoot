package com.example.crudRest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos=new ArrayList<Todo>();
	private static int todoCount=3;
	static {
		todos.add(new Todo(1,"Nitin","Learn Python",new Date(),false));
		todos.add(new Todo(2,"Sabarna","Learn Angular5",new Date(),false));
		todos.add(new Todo(3,"Jack","Learn Spring MVC",new Date(),false));
	}
	
	public List<Todo> retrieveTodos(String user){
		List<Todo> filteredTodos=new ArrayList<Todo>();
		for(Todo todo:todos) {
			if(todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public Todo addTodo(String name,String desc,Date targetDate,boolean isDone) {
		Todo todo=new Todo(++todoCount, name, desc, targetDate, isDone);
		todos.add(todo);
		return todo;
	}
	
	public Todo retrieveTodo(int id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
			
		}
		return null;
	}
}
