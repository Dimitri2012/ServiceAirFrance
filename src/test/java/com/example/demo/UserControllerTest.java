package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import fr.airfrance.ServiceApplication;
import fr.airfrance.controller.UserController;
import fr.airfrance.dao.UserRepository;
import fr.airfrance.model.Response;
import fr.airfrance.model.User;
import fr.airfrance.service.Service;

import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
class UserControllerTest {
	
	@MockBean
	private Service service;
	@MockBean
	private UserRepository userRepository;
	@Autowired
	private UserController userController;
	
	
	
	@Test
	void getAllUserTest() throws Exception {
		
		List<User> listUser=new ArrayList<User>();
		listUser.add(new User("Dim","Dimitri","Arches",26,"France"));
		listUser.add(new User("Melissa","Arches",26,"France"));
		listUser.add(new User("Morgane","Blom",26,"France"));
		
		
		
		ResponseEntity<List<User>> result=ResponseEntity.status(HttpStatus.OK).body(listUser);
		int age= 26;
		Mockito.when(service.findAllUsersByAge(26)).thenReturn(listUser);
		
		ResponseEntity<List<User>> result1=userController.getAllUserByAge(age);
				
				
		assertEquals(result,result1);
		
		
	}
	
	@Test
	void getUserTest() throws Exception {
		
		List<User> listUser=new ArrayList<User>();
	
		
		
		User dim= new User("Dim","Dimitri","Arches",26,"France");
		

		ResponseEntity<User> result=ResponseEntity.status(HttpStatus.OK).body(dim);
		Mockito.when(service.findById(1)).thenReturn(dim);
		ResponseEntity<?> result1=userController.getUser(1);
		
		Response response = new Response("Nobody has this id", HttpStatus.NOT_FOUND.toString());
		ResponseEntity<Response> result2=ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		
		Mockito.when(service.findById(12)).thenThrow(Exception.class);
		ResponseEntity<?> result3=userController.getUser(12);
		
		assertEquals(result,result1);			
		assertEquals(result2,result3);
		
	}
	
	@Test
	void postUserTest() throws Exception {
		
	
		User dim=new User("Dim","Dimitri","Arches",26,"France");
		
		Response response=new Response("New user saved",HttpStatus.OK.toString());
		ResponseEntity<Response> result=ResponseEntity.status(HttpStatus.OK).body(response);
		
		ResponseEntity<Response> result1=userController.postUser(dim);
		
			assertEquals(result,result1);
		
	}
	
	
}
