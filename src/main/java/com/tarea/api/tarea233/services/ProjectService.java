package com.tarea.api.tarea233.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tarea.api.tarea233.models.Project;

@Service
public class ProjectService {
	
	
	public Set<Project> getAllProjects(){
		Set<Project> test = new HashSet<>();
		test.add(new Project(44, "test"));
		test.add(new Project(77, "test2"));
		test.add(new Project(1, "test3"));
		return test;
	}
	
	public Project findById() {
		return new Project(2, "test7");
	}

}
