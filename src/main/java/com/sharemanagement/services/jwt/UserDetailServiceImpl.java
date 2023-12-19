package com.sharemanagement.services.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharemanagement.repositories.UserRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findUserByEmail(username);
		if(user == null) {
			
			throw new UsernameNotFoundException("User not Found");
		}
		
		return  new User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}

}
