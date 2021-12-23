package com.java.assignment.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.java.assignment.api.response.pojo.UserResponse;
import com.java.assignment.dao.UsersDAO;
import com.java.assignment.dto.CreateUserDTO;
import com.java.assignment.dto.UserRequestPayload;
import com.java.assignment.model.Users;
import com.java.assignment.repository.UsersRepository;
import com.java.assignment.util.EmailRegex;
import com.java.assignment.util.UserResponseWithErrors;

@Service
@Transactional
public class UsersServiceImpl implements UserService {

	@Autowired
	private UsersRepository userRepository;
	@Autowired
	public UsersDAO usersDAO;

	public UsersServiceImpl() {
		super();
	}

	public UsersServiceImpl(UsersRepository userRepository, UsersDAO usersDAO) {
		super();
		this.userRepository = userRepository;
		this.usersDAO = usersDAO;
	}

	public Map<String, UserRequestPayload> emailErrors = new HashMap<>();
	public Map<String, UserRequestPayload> firstNameErrors = new HashMap<>();
	public Map<String, UserRequestPayload> mobileErrors = new HashMap<>();
	public Map<Integer, UserRequestPayload> pinCodeErrors = new HashMap<>();

	@Override
	public ResponseEntity<UserResponse> createAUser(CreateUserDTO payloadObject) {

		if (payloadObject.getUserRequestPayload() != null && payloadObject.getUserRequestPayload().size() > 0) {

			List<Users> users = new ArrayList<Users>();

			for (UserRequestPayload createUserObj :payloadObject.getUserRequestPayload()) {
				
				if (createUserObj.getFirstName() != null && createUserObj.getFirstName().length() > 1) {

					if (String.valueOf(createUserObj.getPinCode()).length() == 6) {

						if (createUserObj.getMobile() != null && createUserObj.getMobile().length() > 10) {
							
							
							if (createUserObj.getEmail() != null && EmailRegex.patternMatches(createUserObj.getEmail())) {
								
								Users user = new Users();
								
								user.setFirstName(createUserObj.getFirstName());
								user.setLastName(createUserObj.getLastName());
								user.setEmail(createUserObj.getEmail());
								user.setMobile(createUserObj.getMobile());
								user.setPinCode(createUserObj.getPinCode());
								user.setCreatedOn(LocalDate.now());
								user.setVersion(1);
			
								userRepository.save(user);

								users.add(user);

							}else
								emailErrors.put(createUserObj.getEmail(), createUserObj);
						}else
							mobileErrors.put(createUserObj.getMobile(), createUserObj);
					}else
						
						pinCodeErrors.put(createUserObj.getPinCode(), createUserObj);
				}else
					firstNameErrors.put(createUserObj.getFirstName(), createUserObj);
			}

			if (emailErrors.size() == 0 && mobileErrors.size() == 0 && pinCodeErrors.size() == 0 && firstNameErrors.size() == 0)
				return ResponseEntity.status(200).body(new UserResponse(true, users, "User(s) created successfully", 200));
			else {

					UserResponseWithErrors userResponseWithErrors = new UserResponseWithErrors();

					userResponseWithErrors.setCreatedUsers(users);
					if (emailErrors != null)
						userResponseWithErrors.setEmailErrors(emailErrors.size(), emailErrors);
					else
						userResponseWithErrors.setEmailErrors(0, null);
					if (mobileErrors != null)
						userResponseWithErrors.setMobileErrors(mobileErrors.size(), mobileErrors);
					else
						userResponseWithErrors.setMobileErrors(0, null);
					if (firstNameErrors != null)
						userResponseWithErrors.setFirstNameErrors(firstNameErrors.size(), firstNameErrors);
					else
						userResponseWithErrors.setFirstNameErrors(0, null);
					if (pinCodeErrors != null)
						userResponseWithErrors.setPinCodeErrors(pinCodeErrors.size(), pinCodeErrors);
					else
						userResponseWithErrors.setPinCodeErrors(0, null);

					String message = users.size()+" user(s) created with "+emailErrors.size()+" email error(s) occured, "+
							mobileErrors.size()+" mobile error(s) occured, "+
							firstNameErrors.size()+ " first name error(s) occured, "+
							pinCodeErrors.size()+ " pin code error(s) occured.";

					return ResponseEntity.status(200).body(new UserResponse(true, userResponseWithErrors, message, 200));
			}
		}else
			return ResponseEntity.status(400).body(new UserResponse(false, null, "Please provide user(s) details", 400));
	}

	@Override
	public ResponseEntity<UserResponse> searchAUser(String searchCriteria, String searchValue, int result) {

		if (searchCriteria != null && searchCriteria.length() > 0) {

			if (searchValue != null && searchValue.length() > 0) {

				List<Users> users = usersDAO.findUsersByCriteriaAndCount(searchCriteria, searchValue, result);
			
				if (users != null && users.size() > 0)
					return ResponseEntity.status(200).body(new UserResponse(true, users, users.size() + " user(s) found.", 200));
				else
					return ResponseEntity.status(200).body(new UserResponse(true, null, "No user found.", 200));
			}else
				return ResponseEntity.status(400).body(new UserResponse(false, null, "Please provide valid criteria", 400));
		}else
			return ResponseEntity.status(400).body(new UserResponse(false, null, "Please provide valid criteria", 400));
	}
}
