package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// testar de rest esta funcionando, disponiboliza recurso web relacionado à entidade user

	@Autowired   // injetado automaticamente
	private UserService service;
	
	// recurperar cenas do banco de dados - get
	
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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {  // para o objeto chegar no modo Json e esse objeto ser desserializado para o objeto do tipo User tenho de por a anotaçao 
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); // espera objeto URI - endereço do novo recurso inserido - ver melhor!! , no POSTMAN tem de dar 201 Created!!
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); // resposta sem conteudo -> 204 no postman
	}
	
	
	
}
