package com.tarea.api.tarea233.models;

import java.util.Set;

public class Project {

	private Integer id;
	private String description;
	private String language;
	private Boolean open;
	
	private Set<Code> codes;
	private Set<Detail> details;
	private Set<User> users;
	private Set<Tags> tags;
	
	public Project(Integer id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public Project(Integer id, String description, String language, Boolean open, Set<Code> codes,
			Set<Detail> details, Set<User> users, Set<Tags> tags) {
		this.id = id;
		this.description = description;
		this.language = language;
		this.open = open;
		this.codes = codes;
		this.details = details;
		this.users = users;
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Set<Code> getCodes() {
		return codes;
	}

	public void setCodes(Set<Code> codes) {
		this.codes = codes;
	}

	public Set<Detail> getDetails() {
		return details;
	}

	public void setDetails(Set<Detail> details) {
		this.details = details;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}
	
	
	
	
}
