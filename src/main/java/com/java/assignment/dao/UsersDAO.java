package com.java.assignment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.assignment.model.Users;

@Repository
public class UsersDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Users> findUsersByCriteriaAndCount(String searchCriteria, String searchValue, int count) {

		return jdbcTemplate.query("SELECT * FROM users WHERE "+searchCriteria+" = '"+ searchValue+ "' LIMIT "+count, 
				new BeanPropertyRowMapper<Users>(Users.class));
	}
}