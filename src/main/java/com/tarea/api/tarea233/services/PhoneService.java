package com.tarea.api.tarea233.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.tarea.api.tarea233.models.Phone;

@Service
public class PhoneService {
	
	String movil = "Móvil";
	String fijo = "Teléfono fijo";
	
	public Set<Phone> getAllPhones(){
		Set<Phone> test = new HashSet<>();
		test.add(new Phone(movil, "test"));
		test.add(new Phone(fijo, "test2"));
		test.add(new Phone(movil, "test3"));
		return test;
	}
	
	public Phone findById() {
		return new Phone(fijo, "test7");
	}

}
