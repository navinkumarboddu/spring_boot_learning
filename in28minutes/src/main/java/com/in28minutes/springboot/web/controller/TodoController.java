package com.in28minutes.springboot.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.springboot.web.model.Todo;
import com.in28minutes.springboot.web.repository.TodoRepository;
import com.in28minutes.springboot.web.service.TodoService;

import jakarta.validation.Valid;

@Controller
public class TodoController {

	@Autowired
	TodoService service;
	
	@Autowired
	TodoRepository todoRepository;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName();
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodosPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(), "Default desc", new Date(), false));
		return "todo";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		if(id == 1) {
			throw new RuntimeException("Something went wrong");
		}
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		service.addTodo(getLoggedInUserName(), todo.getDesc(), new Date(), false);
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName());
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}

}