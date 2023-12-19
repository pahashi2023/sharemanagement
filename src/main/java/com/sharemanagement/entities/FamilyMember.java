package com.sharemanagement.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the family database table.
 * 
 */
@Entity
@Table(name="family_member")
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

	public FamilyMember() {
	}

	

	public long getMemberId() {
		return memberId;
	}



	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}



	public BigInteger getFamilyId() {
		return familyId;
	}



	public String getAadharNo() {
		return this.aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigInteger getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setFamilyId(BigInteger familyId) {
		this.familyId = familyId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigInteger getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(BigInteger pinCode) {
		this.pinCode = pinCode;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public BigInteger getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(BigInteger updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}