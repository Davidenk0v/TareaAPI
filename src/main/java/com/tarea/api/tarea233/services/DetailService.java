package com.tarea.api.tarea233.services;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tarea.api.tarea233.models.Detail;

@Service
public class DetailService {
	
	Date hoy = new Date();
	
	public Set<Detail> getAllDetails(){
		Set<Detail> test = new HashSet<>();
		test.add(new Detail(hoy, "test"));
		test.add(new Detail(hoy, "test2"));
		test.add(new Detail(hoy, "test3"));
		return test;
	}
	
	public Detail findById() {
		return new Detail(hoy, "test7");
	}

}
