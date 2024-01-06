package com.sharemanagement.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;
import java.math.BigInteger;

@Entity
@Table(name="family")
@Data
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
	
	@Column(name="status")
	private int status;

}