package com.acme.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodolistApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
    void justCreatedTodoItem() {
    	todoItem = new TodoItem("1", Instant.now(),"todoiItem 1 créé");
    	assertFalse(todoiItem.finalContent().contains("[LATE!] "));
    }
    
    @Test
    void Created48hAgoTodoItem() {
    	todoItem = new TodoItem("2",Instant.now().minus(48,ChronoUnit.HOURS),"todoItem 2 créé il y a 48H");
    	assertTrue(todoItem.finalContent().contains("[LATE!] ");
    }
    
    @Test
    void TwoDaysOldIsLate() {
    	todoItem = new TodoItem("7", Instant.now().minus(1, ChronoUnit.DAYS), "todoItem créé il y a un jour");
    	assertFalse(todoItem.isLate());
    }
}
