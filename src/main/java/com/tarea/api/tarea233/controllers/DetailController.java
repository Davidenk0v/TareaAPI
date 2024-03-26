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

import com.tarea.api.tarea233.models.Detail;
import com.tarea.api.tarea233.services.DetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Gestión de detalles", description = "Operaciones para el registro de detalles")
public class DetailController {

	@Autowired
	DetailService service;

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra todos los detalles")
	@GetMapping("/details")
	public ResponseEntity<Set<Detail>> getDetails() {
		Set<Detail> detail = this.service.getAllDetails();
		if (detail.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(detail, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra el detalle con el ID seleccionado")
	@GetMapping("/details/{id}")
	public ResponseEntity<Detail> getDetailById(@PathVariable Integer id) {
		Detail detail = this.service.findById();
		if (detail == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(detail, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "409", description = "THAT ID ALREADY EXISTS", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Crea un nuevo detalle")
	@PostMapping("/details")
	public ResponseEntity<Detail> createDetail(@RequestBody Detail detail) {
		if (detail == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(detail, HttpStatus.CREATED);
	}

	@ApiResponse(responseCode = "200", description = "MODIFIED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Edita el codigo con el id seleccionado")
	@PutMapping("/details/{id}")
	public ResponseEntity<Detail> editDetail(@PathVariable Integer id, @RequestBody Detail detail) {
		if (detail == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(detail, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "ELIMINATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Elimina los detalles con el ID seleccionado")
	@DeleteMapping("/details/{id}")
	public ResponseEntity<Detail> deleteDetail(@PathVariable Integer id) {
		Detail detail = this.service.findById();
		if (detail == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(detail, HttpStatus.OK);
	}
}
