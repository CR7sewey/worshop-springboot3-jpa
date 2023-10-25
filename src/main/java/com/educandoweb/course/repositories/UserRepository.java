package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;
														// entity, primary key
public interface UserRepository extends JpaRepository<User,Long> {

	// ja tem implmentacao padrao da interface com o Jpa...
	
	
}
