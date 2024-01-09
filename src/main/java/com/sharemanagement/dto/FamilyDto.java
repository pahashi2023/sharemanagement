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
	private BigInteger memberId;
	
	@Override
	public String toString() {
		return "FamilyDto [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", phone=" + phone + ", emailId=" + emailId + ", aadharNo=" + aadharNo + ", panNO=" + panNO
				+ ", relation=" + relation + ", pinCode=" + pinCode + ", address=" + address + ", status=" + status
				+ ", familyId=" + familyId + ", memberId=" + memberId + "]";
	}
	
	
	
	
	

}
