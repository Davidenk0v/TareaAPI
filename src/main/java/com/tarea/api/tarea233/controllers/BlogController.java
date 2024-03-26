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

import com.tarea.api.tarea233.models.Blog;
import com.tarea.api.tarea233.services.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Gestión de blogs", description = "Operaciones para el registro de blogs")
public class BlogController {

	@Autowired
	BlogService service;

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra todos los blogs del sistema")
	@GetMapping("/blogs")
	public ResponseEntity<Set<Blog>> getBlogs() {
		Set<Blog> blog = this.service.getAllArticles();
		if (blog.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(blog, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra el blog con el ID seleccionado")
	@GetMapping("/blogs/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable Integer id) {
		Blog blog = this.service.findById(id);
		if (blog == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(blog, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "409", description = "THAT ID ALREADY EXISTS", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Crea un nuevo blog")
	@PostMapping("/blogs")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		if (blog == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(blog, HttpStatus.CREATED);
	}

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Edita el blog con el id seleccionado")
	@PutMapping("/blogs/{id}")
	public ResponseEntity<Blog> editBlog(@PathVariable Integer id, @RequestBody Blog blog) {
		if (blog == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(blog, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "ELIMINATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Elimina el blog con el ID seleccionado")
	@DeleteMapping("/blogs/{id}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable Integer id) {
		Blog blog = this.service.findById(id);
		if (blog == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(blog, HttpStatus.OK);
	}
}
