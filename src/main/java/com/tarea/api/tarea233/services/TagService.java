package com.tarea.api.tarea233.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tarea.api.tarea233.models.Project;
import com.tarea.api.tarea233.models.Tags;

@Service
public class TagService {
	
	
	public Set<Tags> getAllTags(){
		Set<Tags> test = new HashSet<>();
		test.add(new Tags(44, "test"));
		test.add(new Tags(77, "test2"));
		test.add(new Tags(1, "test3"));
		return test;
	}
	
	public Tags findById() {
		return new Tags(2, "test7");
	}

}
