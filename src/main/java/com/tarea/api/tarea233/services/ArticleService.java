package com.tarea.api.tarea233.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tarea.api.tarea233.models.Article;

@Service
public class ArticleService {
	
	public Set<Article> getAllArticles(){
		Set<Article> test = new HashSet<>();
		test.add(new Article(7, "test"));
		test.add(new Article(8, "test2"));
		test.add(new Article(10, "test3"));
		return test;
	}
	
	public Article findById(Integer id) {
		return new Article(44, "test7");
	}

}
