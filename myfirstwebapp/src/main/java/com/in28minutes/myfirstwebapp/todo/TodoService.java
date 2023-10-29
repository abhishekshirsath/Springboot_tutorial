package com.in28minutes.myfirstwebapp.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount,"in28Mins", "Learn aws1",
				"10/2023",true));
		todos.add(new Todo(++todosCount,"in28Mins", "Full Stackc Java1",
				"11/2023",false));
		todos.add(new Todo(++todosCount,"in28Mins", "Learn hibernate1",
				"12/2023",false));
		todos.add(new Todo(++todosCount,"in28Mins", "Learn Spring boot1",
				"10/2023",true));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
		
	}
	
	public void addTodo(String username, String description, String localDate, boolean done) {
		
		Todo todo = new Todo(++todosCount, username , description, localDate, done);
		todos.add(todo);
		
	}
	
	public void deleteById(int id) {
		// todo.getId() == id
		// todo->todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		
		deleteById(todo.getId());
		todos.add(todo);
	}

}
