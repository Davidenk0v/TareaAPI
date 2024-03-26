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

import com.tarea.api.tarea233.models.Article;
import com.tarea.api.tarea233.services.ArticleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Gestión de articulos", description = "Operaciones para el registro de articulos")
public class ArticleController {

	@Autowired
	ArticleService service;

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra todos los articulos del sistema")
	@GetMapping("/articles")
	public ResponseEntity<Set<Article>> getArticles() {
		Set<Article> article = this.service.getAllArticles();
		if (article.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Muestra el articulo con el ID seleccionado")
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable Integer id) {
		Article article = this.service.findById(id);
		if (article == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "409", description = "THAT ID ALREADY EXISTS", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Crea un nuevo articulo")
	@PostMapping("/articles")
	public ResponseEntity<Article> createArticle(@RequestBody Article article) {
		if (article == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(article, HttpStatus.CREATED);
	}

	@ApiResponse(responseCode = "202", description = "MODIFIED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Edita el articulo con el id seleccionado")
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> editArticle(@PathVariable Integer id, @RequestBody Article article) {
		if (article == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(article, HttpStatus.ACCEPTED);
	}

	@ApiResponse(responseCode = "202", description = "ELIMINATED", content = @Content(mediaType = "application/json"))
	@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(mediaType = "application/json"))
	@Operation(summary = "Elimina el articulo con el ID seleccionado")
	@DeleteMapping("/articles/{id}")
	public ResponseEntity<Article> deleteArticle(@PathVariable Integer id) {
		Article article = this.service.findById(id);
		if (article == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(article, HttpStatus.OK);
	}
}
