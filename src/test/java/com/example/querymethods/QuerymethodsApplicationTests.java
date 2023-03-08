package com.example.querymethods;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.querymethods.controller.PersonController;
import com.example.querymethods.model.Person;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class QuerymethodsApplicationTests {
	@Mock
	PersonController personController;
  
	public static List<Person> expected;
	Person p1 = new Person();
	Person p2 = new Person();
  
	@Test
	public void allTest() {
  
	  expected = Arrays.asList(p1, p2);
	  System.out.println("expected:"+expected);
	  ResponseEntity<List<Person>> actual = personController.getAll();
	  System.out.println("actual:" + actual);
	  System.out.println("expected:" + expected);
	  assertEquals(expected, actual.getBody());
	  assertEquals(HttpStatus.OK, actual.getStatusCode());
	}

	@Test
	public void  getTeamByIdtest(){
		int id = 1;
    // when(bookService.findByBookId(id)).thenReturn(null);
    	ResponseEntity<Person> actual = personController.getTeamById(id);
    	// assertNotNull(actual);
		System.out.println("actual:"+actual);
	}

	@Test
	public void createTeamTest(){
		personController.createTeam(p1);

	}

	@Test
	public void updateUserTest(){
		int id = 1;
		// when(bookService.updateBook(id, book1)).thenReturn(book1);
		ResponseEntity<Person> actual = personController.updateUser(id, p1);
		// assertNotNull(actual);
		// System.out.println("Actual is  "+actual.getBody());
		System.out.println("expected-->" + expected);
	}
	

}
