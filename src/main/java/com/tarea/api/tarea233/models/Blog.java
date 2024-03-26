package com.tarea.api.tarea233.models;

import java.util.Date;
import java.util.Set;

public class Blog {

	private Integer id;
	private String title;
	private Date date;
	private Set<Article> articles;
	private User user;
	

	
	public Blog(Integer id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
