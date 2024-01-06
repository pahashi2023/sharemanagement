package com.sharemanagement.services;

import com.sharemanagement.dto.AccountDetailDTO;
import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.repositories.AccountDetailRepo;

import com.sharemanagement.utils.StringHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    @Autowired
    private  AccountDetailRepo accountDetailRepo;

    @Autowired
    private StringHelperUtils stringHelperUtils;

    @Override
    @Transactional
    public void saveAccountDetail(AccountDetailDTO accountDetailDTO) {
        // Convert DTO to Entity and save
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setMemberId(stringHelperUtils.handleBigInt(accountDetailDTO.getMemberId()));
        accountDetail.setAccountType(stringHelperUtils.handleString(accountDetail.getAccountType()));
        accountDetail.setBankName(stringHelperUtils.handleString(accountDetail.getBankName()));
        accountDetail.setAccountHolderName(stringHelperUtils.handleString(accountDetailDTO.getAccountHolderName()));
        accountDetail.setAccountNumber(stringHelperUtils.handleString(accountDetail.getAccountNumber()));
        accountDetail.setIfscCode(stringHelperUtils.handleString(accountDetail.getIfscCode()));
        accountDetail.setBankAddress(stringHelperUtils.handleString(accountDetail.getBankAddress()));
        accountDetailRepo.saveAccountDetail(accountDetail);
    }


}