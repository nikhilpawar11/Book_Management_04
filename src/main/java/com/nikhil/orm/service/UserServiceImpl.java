package com.nikhil.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.orm.entity.User;
import com.nikhil.orm.exception.ResourceNotFoundException;
import com.nikhil.orm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public User createUser(User user) {
		
		User savedUser = userRepo.save(user);
		
		return savedUser;
	}

	@Override
	public User updateUser(User user, int id) {
		
		//find user with the help of id
		User userById = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found by given id !!"));
		
		//update user
		userById.setName(user.getName());
		userById.setEmail(user.getEmail());
		userById.setAge(user.getAge());
		
		//save updated user
		User updatedUser = userRepo.save(userById);
		
		return updatedUser;
	}

	@Override
	public void deleteUser(int id) {
		
		User userById = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found by given id !!"));
		
		userRepo.delete(userById);
		
	}

	@Override
	public List<User> getAllUser() {
		
		List<User> allUser = userRepo.findAll();
		
		return allUser;
	}

	@Override
	public User getUserById(int id) {
		
		User userById = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found by given id !!"));
		
		return userById;
	}

	@Override
	public User findByEmail(String email) {
		
		User userByEmail = userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found by given email !!"));
		
		return userByEmail;
	}

}
