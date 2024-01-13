package com.sharemanagement.services;

import com.sharemanagement.dto.AccountDetailDTO;

import java.util.List;

public interface AccountDetailService {
    void saveAccountDetail(List<AccountDetailDTO> accountDetailDTO);

    public List<AccountDetailDTO> getAllAccountDetails(int familyId,String accountType);

    void deleteAccountdetails(int accDetId);
}


