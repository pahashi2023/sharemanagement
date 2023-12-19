package com.sharemanagement.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;

@Entity
@Table(name="family")
public class Family implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="family_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long familyId;

	@Column(name="created_by")
	private BigInteger createdBy;

	@Transient
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="updated_by")
	private BigInteger updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	public Family() {
	}

	public long getFamilyId() {
		return this.familyId;
	}

	public void setFamilyId(long familyId) {
		this.familyId = familyId;
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