package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

// @Repository 		opcional pq herda do Jpa										// entity, primary key
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

	// ja tem implmentacao padrao da interface com o Jpa...
	
	
}
