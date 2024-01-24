package com.sharemanagement.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the account_detail database table.
 *
 */
@Setter
@Getter
@Entity
@Table(name="account_detail")
public class AccountDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="acc_det_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accDetId;


    @Column(name="account_number")
    private String accountNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name="bank_name")
    private String bankName;

    @Column(name="bank_address")
    private String bankAddress;

    @Column(name="created_by")
    private BigInteger createdBy;

    @Transient
    @Temporal(TemporalType.DATE)
    @Column(name="created_date")
    private Date createdDate;

    @Column(name="ifsc_code")
    private String ifscCode;

    @OneToMany(mappedBy = "accountDetail", cascade = CascadeType.ALL)
    private List<AccountMemberDetails> accountMemberDetails;

    @Column(name="updated_by")
    private BigInteger updatedBy;

    @Temporal(TemporalType.DATE)
    @Column(name="updated_date")
    private Date updatedDate;

    @Column(name="family_id")
    private BigInteger familyId;

    @Column(name="status")
    private int status;

    @Column(name="account_member_address")
    private String accountMemberAddress;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="account_opening_date")
    private Date accountOpeningDate;

    @Column(name = "bank_branch_name")
    private String bankBranchName;

    @Column(name="executive_email")
    private String executiveEmail;

    @Column(name="executive_number")
    private String executivePhone;

    @Column(name="bank_pincode")
    private BigInteger bankPinCode;

    public AccountDetail() {
    }

}