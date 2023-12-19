package com.sharemanagement.repositories;

import org.springframework.security.core.userdetails.User;

public interface UserRepo {

	User findUserByEmail(String email);
	
	com.sharemanagement.entities.User getUserIdByEmail(String email);
}
