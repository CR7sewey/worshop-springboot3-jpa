package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

// @Repository 		opcional pq herda do Jpa										// entity, primary key
public interface UserRepository extends JpaRepository<User,Long> {

	// ja tem implmentacao padrao da interface com o Jpa...
	
	
}
