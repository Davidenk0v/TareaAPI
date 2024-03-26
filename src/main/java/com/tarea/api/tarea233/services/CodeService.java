package com.tarea.api.tarea233.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tarea.api.tarea233.models.Article;
import com.tarea.api.tarea233.models.Blog;
import com.tarea.api.tarea233.models.Code;

@Service
public class CodeService {
	
	public Set<Code> getAllCodes(){
		Set<Code> test = new HashSet<>();
		test.add(new Code(7, "test"));
		test.add(new Code(8, "test2"));
		test.add(new Code(10, "test3"));
		return test;
	}
	
	public Code findById() {
		return new Code(44, "test7");
	}

}
