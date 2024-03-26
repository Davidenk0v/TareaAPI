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

import com.tarea.api.tarea233.models.Code;

import com.tarea.api.tarea233.services.CodeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Gestión de codigos", description = "Operaciones para el registro de codigos")
public class CodeController {

	@Autowired
	CodeService service;

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra todos los codigos del sistema")
	@GetMapping("/codes")
	public ResponseEntity<Set<Code>> getBlogs() {
		Set<Code> code = this.service.getAllCodes();
		if (code.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(code, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra el code con el ID seleccionado")
	@GetMapping("/codes/{id}")
	public ResponseEntity<Code> getCodeById(@PathVariable Integer id) {
		Code code = this.service.findById();
		if (code == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(code, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "409", description = "THAT ID ALREADY EXISTS", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Crea un nuevo codigo")
	@PostMapping("/codes")
	public ResponseEntity<Code> createBlog(@RequestBody Code code) {
		if (code == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(code, HttpStatus.CREATED);
	}

	@ApiResponse(responseCode = "200", description = "MODIFIED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Edita el codigo con el id seleccionado")
	@PutMapping("/codes/{id}")
	public ResponseEntity<Code> editCode(@PathVariable Integer id, @RequestBody Code code) {
		if (code == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(code, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "201", description = "ELIMINATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Elimina el codigo con el ID seleccionado")
	@DeleteMapping("/codes/{id}")
	public ResponseEntity<Code> deleteBlog(@PathVariable Integer id) {
		Code code = this.service.findById();
		if (code == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(code, HttpStatus.OK);
	}
}
