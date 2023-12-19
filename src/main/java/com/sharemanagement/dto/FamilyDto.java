package com.sharemanagement.dto;

import java.math.BigInteger;

import lombok.Data;

@Data
public class FamilyDto {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String phone;
	private String emailId;
	private String aadharNo;
	private String panNO;
	private String relation;
	private BigInteger pinCode;
	private String address;
	

}
