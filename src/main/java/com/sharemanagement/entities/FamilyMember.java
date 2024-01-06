package com.sharemanagement.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the family database table.
 * 
 */
@Entity
@Table(name="family_member")
@Data
public class FamilyMember implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberId;

	@Column(name="aadhar_no")
	private String aadharNo;

	@Column(name="address")
	private String address;

	@Column(name="created_by")
	private BigInteger createdBy;

	@Transient
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="email_id")
	private String emailId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="pan_no")
	private String panNo;

	@Column(name="phone")
	private String phone;

	@Column(name="pin_code")
	private BigInteger pinCode;

	@Column(name="relation")
	private String relation;

	@Column(name="updated_by")
	private BigInteger updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;
	
	@Column(name="family_id")
	private BigInteger familyId;
	
	@Column(name="status")
	private int status;
	
	public FamilyMember() {
		
	}
	public FamilyMember(long memberId) {
		
		this.memberId = memberId;
	}

	

}