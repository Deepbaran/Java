package com.deepbarankar.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.deepbarankar.data.api.TodoService;
import com.deepbarankar.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingStub() {
		TodoService todoServiceStub = new TodoServiceStub(); //Using the stub rather than the real class
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size());
	}

}
