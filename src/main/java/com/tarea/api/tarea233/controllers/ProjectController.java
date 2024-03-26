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

import com.tarea.api.tarea233.models.Project;
import com.tarea.api.tarea233.services.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Gestión de proyectos", description = "Operaciones para el registro de proyectos")
public class ProjectController {

	@Autowired
	ProjectService service;

	@ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra todos los proyectos del sistema")
	@GetMapping("/projects")
	public ResponseEntity<Set<Project>> getProjects() {
		Set<Project> project = this.service.getAllProjects();
		if (project.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(project, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra el proyecto con el ID seleccionado")
	@GetMapping("/projects/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable Integer id) {
		Project project = this.service.findById();
		if (project == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(project, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "409", description = "THAT ID ALREADY EXIST", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Crea un nuevo proyecto")
	@PostMapping("/projects")
	public ResponseEntity<Project> createDetail(@RequestBody Project project) {
		if (project == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(project, HttpStatus.CREATED);
	}

	@ApiResponse(responseCode = "200", description = "MODIFIED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "THAT ID DOES NOT EXIST", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Edita el proyecto con el id seleccionado")
	@PutMapping("/projects/{id}")
	public ResponseEntity<Project> editProject(@PathVariable Integer id, @RequestBody Project project) {
		if (project == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(project, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "ELIMINATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Elimina el proyecto con el ID seleccionado")
	@DeleteMapping("/projects/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable Integer id) {
		Project project = this.service.findById();
		if (project == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(project, HttpStatus.OK);
	}
}
