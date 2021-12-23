package com.java.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignment.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	public List<Users> findAllByFirstName(String firstName);
}
