package com.udemy.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	 
	private TodoRepository repository;
	
	public TodoController(TodoService todoservice,TodoRepository repository) {
		super();
		 
		this.repository = repository;
	}
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("list-todos")
	public String gotolistTodos(ModelMap model)
	{
		
		String username = getLoggedInUsername(model);
		List<Todo> todos = repository.findByUsername(username);
		//List<Todo> todos = todoservice.findByUsername(username); 
		model.addAttribute("todos",todos);
		return "listTodo";
	}
	
	
	@RequestMapping(value = "add-todos",method = RequestMethod.GET )
	public String addTodos(ModelMap model)
	{		
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0,username,"descr",LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		
		logger.debug( "The binded old todo is " +todo);
		return "addTodo";
	}


	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping(value = "add-todos",method = RequestMethod.POST )
	public String newlistTodos( ModelMap model,@Valid Todo todo,BindingResult result)
	{		 
		if(result.hasErrors())
		{
			return "addTodo";
		}
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		repository.save(todo);
//		todoservice.addTodo(username, todo.getDescription(),todo.getTargetDate(), false);
	
		logger.debug( "The added new todo is " +todo);
		return  "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		//DELETE TODO
		repository.deleteById(id);
		return  "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.GET)
	public String showTodoPage(@RequestParam int id,ModelMap model)
	{
		//GET  TODO
		Todo todo = repository.findById(id).get();
		model.addAttribute("todo", todo);
		return  "addTodo";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.POST )
	public String updateTodo( ModelMap model,@Valid Todo todo,BindingResult result)
	{		 
		if(result.hasErrors())
		{
			return "addTodo";
		}
		String username = getLoggedInUsername(model);
		
		todo.setUsername(username);
		 
		repository.save(todo);
		
		logger.debug( "The added new todo is " +todo);
		return  "redirect:list-todos";
	}
	
}
