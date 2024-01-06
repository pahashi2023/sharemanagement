package com.sharemanagement.restcontroller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharemanagement.dto.AuthenticationRequest;
import com.sharemanagement.dto.AuthenticationResponse;
import com.sharemanagement.services.UserService;
import com.sharemanagement.services.jwt.UserDetailServiceImpl;
import com.sharemanagement.utils.JwtUtil;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/home")
@Slf4j
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailServiceImpl userDetailService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping(value = "/index")
	@ResponseBody
	public AuthenticationResponse createAuthenticaionToken(@RequestBody AuthenticationRequest authenticationRequest,HttpServletResponse response) throws BadCredentialsException,DisabledException,UsernameNotFoundException,IOException, java.io.IOException {
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
			
		}catch(BadCredentialsException e) {
			
			throw new BadCredentialsException("Incorrect username or Password");
			
		}catch(DisabledException e) {
			
			//response.sendError(HttpServletResponse.SC_NOT_FOUND,"User not Found");
			//return null;
			throw new DisabledException("User not Found");
		}
		
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getEmail());
		
		com.sharemanagement.entities.User user = userService.getUserIdByEmail(userDetails.getUsername());
		
		final String jwt = jwtUtil.generateToken(userDetails.getUsername());
		
		return new AuthenticationResponse(jwt,userDetails.getUsername(),user.getUserId(),user.getName(),user.getMiddleName(),user.getLastName(),user.getPhone());
		
	}

}
