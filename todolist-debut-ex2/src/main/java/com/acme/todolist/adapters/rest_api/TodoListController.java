package com.acme.todolist.adapters.rest_api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;
import com.acme.todolist.application.port.in.AddTodoItems;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	// A compléter
	private AddTodoItem addTodoItemQuery;
	
	
	@Inject
	//A compléter
	public TodoListController(GetTodoItems getTodoItemsQuery, AddTodoItem addTodoItemQuery) {
		this.getTodoItemsQuery = getTodoItemsQuery;
		this.addTodoItemQuery = addTodoItemQuery;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	// Endpoint de type POST vers "/todos"
	// A compléter
	@PostMapping("/todos")
	@ResponseStatus(HttpStatus.CREATED)
	public void ajouterItem(@RequestBody TodoItem item) {
		// A compléter	
		this.addTodoItemQuery.addTodoItem(item);		
	}
	
	
}
