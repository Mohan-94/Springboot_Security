package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.GenricException;
import com.app.domain.SuccessResponse;
import com.app.model.UserInfo;
import com.app.service.UserInfoService;

@RestController
class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping("/user")
	public ResponseEntity<Object> createEmployee(@RequestBody final UserInfo user) throws GenricException {
		try {
			userInfoService.createUser(user);
		} catch (Exception ex) {
			throw new GenricException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<Object> createEmployee(@PathVariable("id") final Integer id,
			@RequestBody final UserInfo user) throws GenricException {
		try {
//			user.setId(id);
			userInfoService.updateUser(user);
		} catch (Exception ex) {
			throw new GenricException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") final Integer id) throws GenricException {
		try {
			userInfoService.deleteUser(id);
		} catch (Exception ex) {
			throw new GenricException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return new ResponseEntity<>(new SuccessResponse("Deleted"), HttpStatus.OK);
	}
	@GetMapping("/hello")
	public String welcomeUser() {
		return "Hello , Welcome Muadh!!";
		
	}

}