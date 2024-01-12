package com.sharemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class AccountMemberDetailsDto {

    private BigInteger memberId;
    private long memberDetailId;
    private String accountHolderName;
}
