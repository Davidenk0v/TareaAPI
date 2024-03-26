package com.tarea.api.tarea233.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tarea.api.tarea233.models.Project;
import com.tarea.api.tarea233.models.Tags;
import com.tarea.api.tarea233.models.User;

@Service
public class UserService {
	
	
	public Set<User> getAllUser(){
		Set<User> test = new HashSet<>();
		test.add(new User(44, "test"));
		test.add(new User(77, "test2"));
		test.add(new User(1, "test3"));
		return test;
	}
	
	public User findById() {
		return new User(2, "test7");
	}

}
