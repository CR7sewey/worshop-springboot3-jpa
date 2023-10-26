package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

// registar a classe como componente do Spring
@Service
public class UserService {

	@Autowired // spring faca a injecao de dependecia transparente ao programador
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // retonra um user dentro do opcional
	// tenta get, se nao der retorna excecao
	}

	public User insert(User obj) {

		return repository.save(obj); // ja salva, do repository

	}

	public void delete(Long id) {
		repository.deleteById(id); // ja salva, do repository

	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); // instancia o usuario sem ir ao banco de dados, monitorado pelo jpa!!
		updateData(entity,obj);
		return repository.save(entity);
	}
	
	private void updateData(User entity,User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone()); // nao atualizo id nem semnha
	}

}
