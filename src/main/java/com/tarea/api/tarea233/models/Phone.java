package com.tarea.api.tarea233.models;

public class Phone {

	private String value;
	private String type;
	private User idUser;
	
	public Phone(String value, String type) {
		this.value = value;
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	
	
	
	
	
}
