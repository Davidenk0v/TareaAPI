package com.tarea.api.tarea233.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tarea.api.tarea233.models.Article;
import com.tarea.api.tarea233.models.Blog;

@Service
public class BlogService {
	
	public Set<Blog> getAllArticles(){
		Set<Blog> test = new HashSet<>();
		test.add(new Blog(7, "test"));
		test.add(new Blog(8, "test2"));
		test.add(new Blog(10, "test3"));
		return test;
	}
	
	public Blog findById(Integer id) {
		return new Blog(44, "test7");
	}

}
