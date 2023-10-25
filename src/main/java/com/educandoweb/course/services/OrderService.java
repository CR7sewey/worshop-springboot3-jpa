package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;

// registar a classe como componente do Spring
@Service
public class OrderService {

	@Autowired  // spring faca a injecao de dependecia transparente ao programador
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
		
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); // retonra um user dentro do opcional
	}
	
}
