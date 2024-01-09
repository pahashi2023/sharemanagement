package com.sharemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
public class AccountDetailDTO {
    private long accDetId;
    private BigInteger userId;
    private BigInteger memberId;
    private String accountType;
    private String bankName;
    private String accountHolderName;
    private String accountNumber;
    private String ifscCode;
    private String bankAddress;
    private int status;
    private BigInteger familyId;
}
