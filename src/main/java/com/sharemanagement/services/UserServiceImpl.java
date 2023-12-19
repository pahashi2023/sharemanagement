package com.sharemanagement.services;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemanagement.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	@Transactional
	public com.sharemanagement.entities.User getUserIdByEmail(String email) {
		
		return userRepo.getUserIdByEmail(email);
	}

}
