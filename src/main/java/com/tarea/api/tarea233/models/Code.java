package com.tarea.api.tarea233.models;

public class Code {

	private Integer id;
	private String packages;
	private String file;
	private Project project;
	
	public Code(Integer id, String packages) {
		this.id = id;
		this.packages = packages;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
