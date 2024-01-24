package com.sharemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AccountDetailDTO {
    private long accDetId;
    private BigInteger userId;
    private String accountType;
    private String bankName;
    private List<AccountMemberDetailsDto> accountMemberDetailDtos;
    private String accountNumber;
    private String ifscCode;
    private String bankAddress;
    private int status;
    private BigInteger familyId;
    private String accountMemberAddress;
    private String email;
    private String phone;
    private Date accountOpeningDate;
    private String bankBranchName;
    private String executiveEmail;
    private String executivePhone;
    private BigInteger bankPinCode;

}
