package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// testar de rest esta funcionando, disponiboliza recurso web relacionado à entidade user

	@Autowired   // injetado automaticamente
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // aceitar id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id) { // para aceitar o Path
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		// http://localhost:8080/users/1 retorna a maria no postman
	}
	
	
	
}
