package com.eliezerrb.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliezerrb.dslearnbds.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
