package com.sharemanagement.exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.Gson;
import com.sharemanagement.dto.ResponseDto;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestException {
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> credentialError(BadCredentialsException e){
		
		 ResponseDto err = new ResponseDto();
		 err.setMessage("error");
		 err.setData(e.getMessage());
		 log.error(e.getMessage());
		 return new ResponseEntity<>(new Gson().toJson(err),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DisabledException.class)
	public ResponseEntity<String> userNotFound(DisabledException e){
		
		 ResponseDto err = new ResponseDto();
		 err.setMessage("error");
		 err.setData(e.getMessage());
		 log.error(e.getMessage());
		 return new ResponseEntity<>(new Gson().toJson(err),HttpStatus.UNAUTHORIZED);
	}
	

	 @ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorException(Exception e){
		
		 ResponseDto err = new ResponseDto();
		 err.setMessage("error");
		 err.setData(e.getMessage());
		 log.error(e.getMessage());
		 return new ResponseEntity<>(new Gson().toJson(err),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 
	
}
