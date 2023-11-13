package com.sharemanagement.services;

import org.springframework.stereotype.Service;

import com.sharemanagement.dto.SignupRequest;

@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public boolean createCustomer(SignupRequest signupRequest) {
		return false;
	}

}
