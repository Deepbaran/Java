package com.deepbarankar.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.deepbarankar.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock1() {
		// Using mocking we can create multiple tests easily.
		
		TodoService todoServiceMock = mock(TodoService.class); // Created a mock object of a class
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		//When the retrieveTodos method in the todoServiceMock is called using the "Dummy" argument, return allTodos
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(allTodos); // Created a stub for a method of the mock object or Stubbing a method of the mock object
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, todos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock2() {
		TodoService todoServiceMock = mock(TodoService.class); // Created a mock object of a class
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy2")).thenReturn(allTodos); // Created a stub for a method of the mock object
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy2");
		
		assertEquals(1, todos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		// Verify on methods that returns nothing
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
//		when(todoServiceMock.retrieveTodos("Dummy3")).thenReturn(allTodos);
		given(todoServiceMock.retrieveTodos("Dummy3")).willReturn(allTodos); // Using BDD
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy3");
		
		//Then
//		assertEquals(2, todos.size());
		assertThat(filteredTodos.size(), is(2)); // Using BDD and is() is part of org.hamcrest.Matcher
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance", "Learn to Sing");
		
		given(todoServiceMock.retrieveTodos("Dummy4")).willReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy4");
		
		//Then
		//Check that the deleteTodo method in the todoServiceMock is called with the parameter "Learn to Dance"
//		verify(todoServiceMock).deleteTodo("Learn to Dance"); // Verify a Method of a Mock object is called which returns nothing.
		then(todoServiceMock).should().deleteTodo("Learn to Dance"); // Using BDD
		
		verify(todoServiceMock, times(1)).deleteTodo("Learn to Sing"); // Verify how many times a Method is called.

		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Sing"); // Verify if a Method is called at least once.
		
		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Sing"); // Verify at least how many times a Method is called.
		
		// deleteTodo() should never be called with the "Learn Spring MVC" argument.
//		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC"); // Verifying a method is never called.
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC"); // Using BDD
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {
		// Capturing Arguments passed to the Mocks
		
		//Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//Define Argument captor on specific method call
		//Capture the argument
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy5")).willReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy5");
		
		//Then
		//Capture the argument passed to deleteTodo method in the todoServiceMock
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {
		// Capturing Arguments passed to the Mocks when the method is called multiple times.
		
		//Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//Define Argument captor on specific method call
		//Capture the argument
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> allTodos = Arrays.asList("Learn to Rock and Roll",
				"Learn Spring", "Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy5")).willReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy5");
		
		//Then
		//deleteTodo method should have been called 2 times
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
	}
}


/*
 * mock() - mock crates a mock object of a class or an interface.
 * 
 * when(m).thenReturn(v) - When when() is called with m method, then v value id returned. With this we can assign return values to methods in the mock class.
 * It is used to stub a method.
 * We can also do a chain of thenReturn
 * when().thenReturn().thenReturn()...
 * If we want a stubbed mock to throw Exception, use this: when().thenThrow(new RuntimeException("Exception"))
*/