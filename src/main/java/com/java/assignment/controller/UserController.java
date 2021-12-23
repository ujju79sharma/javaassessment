package com.java.assignment.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.assignment.api.response.pojo.UserResponse;
import com.java.assignment.dto.CreateUserDTO;
import com.java.assignment.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping(path = "/create")
	public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserDTO createUserObj) {

		return userService.createAUser(createUserObj);
	}

	@GetMapping(path = "/find")
	public ResponseEntity<UserResponse> searchUser(@RequestParam Map<String, String> filterNameAndValue) {

		String searchField = filterNameAndValue != null && filterNameAndValue.size() > 0 ? new ArrayList<>(filterNameAndValue.keySet()).get(0) : null;
		String fieldValue = filterNameAndValue != null && filterNameAndValue.size() > 0 ? new ArrayList<>(filterNameAndValue.values()).get(0) : null;

		return userService.searchAUser(searchField, fieldValue, filterNameAndValue != null && filterNameAndValue.size() > 0 && filterNameAndValue.get("result") != null? Integer.parseInt(filterNameAndValue.get("result")) : 1);
	}
}
