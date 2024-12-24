package com.nikhil.orm.service;

import java.util.List;

import com.nikhil.orm.entity.User;

public interface UserService {
	
	//create new user
	public User createUser(User user);
	
	//update user by id
	public User updateUser(User user, int id);
	
	//delete user by id
	public void deleteUser(int id);
	
	//get all user
	public List<User> getAllUser();
	
	//get single user by id
	public User getUserById(int id);
	
	//get user by email
	public User findByEmail(String email);

}
