package com.tarea.api.tarea233.models;

import java.util.Date;
import java.util.Set;

public class Tags {
	private Integer id;
	private String label;
	private Date date;
	private Set<Article> articles;
	private Set<Project> projects;
	
	
	public Tags(Integer id, String label, Date date, Set<Article> articles, Set<Project> projects) {
		this.id = id;
		this.label = label;
		this.date = date;
		this.articles = articles;
		this.projects = projects;
	}
	
	
	public Tags(Integer id, String label) {
		this.id = id;
		this.label = label;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
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


	public Set<Project> getProjects() {
		return projects;
	}


	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	
	
	
}
