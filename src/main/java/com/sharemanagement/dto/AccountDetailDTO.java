package com.sharemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class AccountDetailDTO {
    private BigInteger userId;
    private BigInteger memberId;
    private String accountType;
    private String bankName;
    private String accountHolderName;
    private String accountNumber;
    private String ifscCode;
    private String bankAddress;
}
