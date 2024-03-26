package com.tarea.api.tarea233.models;


public class User {
	private Integer id;
	private String nick;
	private String name;
	private Phone phone;
	
	public User(Integer id, String nick, String name, Phone phone) {
		this.id = id;
		this.nick = nick;
		this.name = name;
		this.phone = phone;
	}
	
	

	public User(Integer id, String nick) {
		this.id = id;
		this.nick = nick;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	
	
	
}
