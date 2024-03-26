package com.tarea.api.tarea233.models;

import java.util.Set;

public class Article {

	private Integer id;
	private String title;
	private String summary;
	private String content;
	private Set<Tags> tags;
	
	
	public Article(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public Article(Integer id, String title, String summary, String content, Set<Tags> tags) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.tags = tags;
	}

	public int getId() {
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id + '\'' +
				", title=" + title + 
				", summary=" + summary + 
				", content=" + content + 
				", tags=" + tags + 
				"}";
	}
	

	
	
	
}
