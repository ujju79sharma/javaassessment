package com.java.assignment;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.assignment.api.response.pojo.UserResponse;
import com.java.assignment.controller.UserController;
import com.java.assignment.dao.UsersDAO;
import com.java.assignment.dto.CreateUserDTO;
import com.java.assignment.dto.UserRequestPayload;
import com.java.assignment.model.Users;
import com.java.assignment.repository.UsersRepository;
import com.java.assignment.service.UsersServiceImpl;
import com.java.assignment.util.UserResponseWithErrors;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class) 
class JavaAssignmentApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UsersServiceImpl userService;
	@Mock
	private UsersRepository usersRepository;
	@Mock
	private UsersDAO usersDAO;
	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {

		this.userService = new UsersServiceImpl(this.usersRepository, this.usersDAO);
	}
	
	@Test
	public void createAUser() throws Exception {

		Users user1 = new Users("Ujjwal", "Sharma", "ujjwal@gmail.com", "+919149616173", null, null, null, 180005);
		Users user2 = new Users("Dravid", "Ujjwal", "dravid@gmail.com", "+919149616131", null, null, null, 180004);

		UserResponseWithErrors userResponseWithErrors = new UserResponseWithErrors();

		Map<String, UserRequestPayload> emailErrors = new HashMap<>();
		Map<String, UserRequestPayload> firstNameErrors = new HashMap<>();
		Map<String, UserRequestPayload> mobileErrors = new HashMap<>();
		Map<Integer, UserRequestPayload> pinCodeErrors = new HashMap<>();
		List<Users> users = new ArrayList<>();

		List<UserRequestPayload> userRequestPayloads = new ArrayList<>();

		users.add(user1);
		users.add(user1);

		userResponseWithErrors.setCreatedUsers(users);
		
		userResponseWithErrors.setFirstNameErrors(0, firstNameErrors);
		
		mobileErrors.put("919149616", new UserRequestPayload("Pavan", "Ravat", "pavan@gmail.com", "919149616", null, null,null, 180004));
		userResponseWithErrors.setMobileErrors(1, firstNameErrors);
		
		emailErrors.put("pavan.com", new UserRequestPayload("Ujjwal","Sharma", "pavan.com", "919149616132", null, null, null, 180004));
		emailErrors.put("aman.com", new UserRequestPayload("Ujjwal","Sharma", "pavan.com", "919149616132", null, null, null, 180004));
		userResponseWithErrors.setEmailErrors(2, emailErrors);

		pinCodeErrors.put(18000, new UserRequestPayload("Ujjwal","Sharma", "ujjwal@gmail.com", "9191496", null, null, null, 18000));
		userResponseWithErrors.setPinCodeErrors(1, pinCodeErrors);

		userRequestPayloads.add(UserObjectConversion.convertObject(user1));
		userRequestPayloads.add(UserObjectConversion.convertObject(user2));
		CreateUserDTO createUserDTO = new CreateUserDTO();
		createUserDTO.setUserRequestPayloads(userRequestPayloads);

		Mockito.when(userService.createAUser(createUserDTO)).thenReturn(ResponseEntity.ok(new UserResponse(true, userResponseWithErrors,
				"2 user(s) created with 2 email error(s) occured, 1 mobile error(s) occured, 0 first name error(s) occured, 1 pin code error(s) occured.", 200)));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users/create")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createUserDTO));

		@SuppressWarnings("unused")
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().is(200))
				.andExpect(content().string(objectMapper.writeValueAsString(userResponseWithErrors))).andReturn();

	}

	@Test
	public void searchAUser() {

		UsersServiceImpl mainModel =  Mockito.mock(UsersServiceImpl.class);
	    ResponseEntity<UserResponse> response = ResponseEntity.ok(new UserResponse(true, null, "No user found.", 200));
	    Mockito.when(mainModel.searchAUser("first_name", "Ujjwal", 1)).thenReturn(response);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/find?first_name=Ujjwal?result=1")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);

		try {
			@SuppressWarnings("unused")
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().is(200))
				.andExpect(content().string("{\n"
							+ "    \"success\": true,\n"
							+ "    \"data\": null,\n"
							+ "    \"message\": \"No user found.\",\n"
							+ "    \"statusCode\": 200\n"
							+ "}")).andReturn();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class UserObjectConversion {

	public static UserRequestPayload convertObject(Users user) {

		UserRequestPayload userRequestPayload = new UserRequestPayload(
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getMobile(), user.getAddress(),
				user.getCity(), user.getState(), user.getPinCode());

		return userRequestPayload;
	}
}