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

import com.tarea.api.tarea233.services.TagService;
import com.tarea.api.tarea233.models.Tags;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Gestión de etiquetas", description = "Operaciones para el registro de etiquetas")
public class TagController {
	
	@Autowired
	TagService service;

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra todos las etiquetas del sistema")
	@GetMapping("/tags")
	public ResponseEntity<Set<Tags>> getTags() {
		Set<Tags> tag = this.service.getAllTags();
		if(tag.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}
	
	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra la etiqueta con el ID seleccionado")
	@GetMapping("/tags/{id}")
	public ResponseEntity<Tags> getTagById(@PathVariable Integer id) {	
	Tags tag = this.service.findById();
		if(tag == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}
	
	@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "409", description = "THAT ID ALREADY EXISTS", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Crea una nueva etiqueta")
	@PostMapping("/tags")
	public ResponseEntity<Tags> createTag(@RequestBody Tags tag) {	
		if(tag == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(tag, HttpStatus.CREATED);
	}
	
	@ApiResponse(responseCode = "200", description = "MODIFIED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Edita la etiqueta con el id seleccionado")
	@PutMapping("/tags/{id}")
	public ResponseEntity<Tags> editTags(@PathVariable Integer id, @RequestBody Tags tag) {	
		if(tag == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}
	
	@ApiResponse(responseCode = "200", description = "ELIMINATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Elimina la etiqueta con el ID seleccionado")
	@DeleteMapping("/tags/{id}")
	public ResponseEntity<Tags> deleteTags(@PathVariable Integer id) {
		Tags tag = this.service.findById();
		if(tag == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}
}
