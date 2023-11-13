package com.sharemanagement.repositories;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo {

	@Override
	public User findUserByEmail(String email) {
		
		User det  = new User(email, "1234", new ArrayList<>());
		return det;
	}

}
