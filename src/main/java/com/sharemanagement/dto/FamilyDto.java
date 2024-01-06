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
	private int status;
	private BigInteger familyId;
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("{'firstName':"+firstName).append(",'middleName':"+middleName).append(",'lastName':"+lastName)
		.append(",'phone':"+phone).append(",'emailId':"+emailId).append(",'aadharNo':"+aadharNo).append(",'panNO':"+panNO)
		.append(",'relation':"+relation).append(",'pinCode':"+pinCode).append(",'address':"+address);
		return sb.toString();
	}
	
	
	

}
