package com.sharemanagement.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {

	private String token;
	private String userName;
	private BigInteger userId;
	private String name;
	private String middleName;
	private String lastName;
	private String phone;
	
	public AuthenticationResponse(String token,String userName,BigInteger userId,String name,String middleName,String lastName,String phone){
		
		this.token = token;
		this.userName = userName;
		this.userId = userId;
		this.name = name;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phone = phone;
	}
	
}
