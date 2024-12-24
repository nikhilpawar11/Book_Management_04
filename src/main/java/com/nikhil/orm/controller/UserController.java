package com.nikhil.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.orm.entity.User;
import com.nikhil.orm.exception.ApiResponseMessage;
import com.nikhil.orm.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User savedUser = userService.createUser(user);
		
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id){
		
		User updatedUser = userService.updateUser(user, id);
		
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable int id){
		
		ApiResponseMessage response = ApiResponseMessage
				.builder()
				.message("User deleted successfully !!")
				.success(true)
				.status(HttpStatus.OK)
				.build();
		
		userService.deleteUser(id);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> allUsers = userService.getAllUser();
		
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
		
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		
		User userById = userService.getUserById(id);
		
		return new ResponseEntity<>(userById, HttpStatus.OK);
		
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		
		User userByEmail = userService.findByEmail(email);
		
		return new ResponseEntity<>(userByEmail, HttpStatus.OK);
		
	}
	

}
