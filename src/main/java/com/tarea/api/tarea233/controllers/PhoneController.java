package com.tarea.api.tarea233.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarea.api.tarea233.models.Phone;
import com.tarea.api.tarea233.services.PhoneService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Gestión de teléfonos", description = "Operaciones para el registro de teléfonos")
public class PhoneController {

	@Autowired
	PhoneService service;

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra todos los teléfonos en el sistema")
	@GetMapping("/phones")
	public ResponseEntity<Set<Phone>> getPhones() {
		Set<Phone> phone = this.service.getAllPhones();
		if (phone.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(phone, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra el detalle con el ID seleccionado")
	@GetMapping("/phones/{id}")
	public ResponseEntity<Phone> getPhoneById(@PathVariable Integer id) {
		Phone phone = this.service.findById();
		if (phone == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(phone, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "THAT ID ALREADY EXISTS", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Crea un nuevo teléfono")
	@PostMapping("/phones")
	public ResponseEntity<Phone> createDetail(@RequestBody Phone phone) {
		if (phone == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(phone, HttpStatus.CREATED);
	}

	@ApiResponse(responseCode = "200", description = "MODIFIED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Edita el télefono con el id seleccionado")
	@PutMapping("/phones/{id}")
	public ResponseEntity<Phone> editPhone(@PathVariable Integer id, @RequestBody Phone phone) {
		if (phone == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(phone, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "ELIMINATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Elimina el teléfono con el ID seleccionado")
	@DeleteMapping("/phones/{id}")
	public ResponseEntity<Phone> deletePhone(@PathVariable Integer id) {
		Phone phone = this.service.findById();
		if (phone == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(phone, HttpStatus.ACCEPTED);
	}
}
