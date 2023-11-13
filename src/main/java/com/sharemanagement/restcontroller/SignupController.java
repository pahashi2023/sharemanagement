package com.sharemanagement.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharemanagement.dto.SignupRequest;
import com.sharemanagement.services.AuthService;

@RestController
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	public AuthService authService;
	
	public ResponseEntity<String> signUser(@RequestBody SignupRequest signupRequest){
		
		boolean isUserCreated = authService.createCustomer(signupRequest);
		
		return null;
		
	}
}
