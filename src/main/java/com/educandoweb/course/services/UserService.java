package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

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
		return obj.get(); // retonra um user dentro do opcional
	}

	public User insert(User obj) {

		return repository.save(obj); // ja salva, do repository

	}

	public void delete(Long id) {
		repository.deleteById(id); // ja salva, do repository

	}

}
