package com.udemy.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static int todoCount = 0;
	
	public static List<Todo> todos = new ArrayList<>();
	
	static{
		todos.add( new Todo(++todoCount,"Nikhil","Get DevOps Certified",LocalDate.now().plusYears(1)
							,false) );
		
		todos.add( new Todo(++todoCount,"Nikhil","Get AWS Certified",LocalDate.now().plusYears(2)
				,false) );
		todos.add( new Todo(++todoCount,"Nikhil","Full Stack Development",LocalDate.now().plusYears(3)
				,false) );
	}
	
	public List<Todo> findByUsername(String username)
	{
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username) ;
		return todos.stream().filter(predicate).toList();
	 
	}
	
	public void addTodo(String username,String description,LocalDate targetDate,boolean isCompleted)
	{
		Todo todo = new Todo(++todoCount,username,description,targetDate,isCompleted);
		todos.add(todo);
	}
	
	public void deleteTodobyId(int id)
	{
	 	 
		Predicate<? super Todo> predicate = todo -> todo.getId() == id ;
		todos.removeIf(predicate);
	}

	public Todo findTodobyId(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get() ;
		
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		 deleteTodobyId(todo.getId());
		 todos.add(todo);		
	}

}
