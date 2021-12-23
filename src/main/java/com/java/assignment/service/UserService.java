package com.java.assignment.service;

import org.springframework.http.ResponseEntity;

import com.java.assignment.api.response.pojo.UserResponse;
import com.java.assignment.dto.CreateUserDTO;

public interface UserService {

	ResponseEntity<UserResponse> createAUser(CreateUserDTO createUserObj);

	ResponseEntity<UserResponse> searchAUser(String searchCriteria, String searchValue, int result);
}
