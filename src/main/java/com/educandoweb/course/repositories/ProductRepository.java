package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

// @Repository 		opcional pq herda do Jpa										// entity, primary key
public interface ProductRepository extends JpaRepository<Product,Long> {

	// ja tem implmentacao padrao da interface com o Jpa...
	
	
}
