package com.sharemanagement.services;

import com.sharemanagement.dto.SignupRequest;

public interface AuthService {

	boolean createCustomer(SignupRequest signupRequest);

}
