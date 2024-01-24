package com.sharemanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDetailRequestDto {

    private long userId;

    private List<AccountDetailDTO> AccountDetailDto;
}
