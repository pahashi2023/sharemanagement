package com.sharemanagement.services;

import com.sharemanagement.dto.AccountDetailDTO;
import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.repositories.AccountDetailRepo;

import com.sharemanagement.utils.StringHelperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    @Autowired
    private  AccountDetailRepo accountDetailRepo;

    @Autowired
    private StringHelperUtils stringHelperUtils;

    @Autowired
    ModelMapper mapper;

    @Override
    @Transactional
    public void saveAccountDetail(List<AccountDetailDTO> accountDetailDTO) {
        List<AccountDetail> accountDetails = accountDetailDTO.stream()
                .map(dto -> {
                    AccountDetail accountDetail = new AccountDetail();
                    accountDetail.setCreatedBy(stringHelperUtils.handleBigInt(dto.getUserId()));
                    accountDetail.setMemberId(stringHelperUtils.handleBigInt(dto.getMemberId()));
                    accountDetail.setAccountType(stringHelperUtils.handleString(dto.getAccountType()));
                    accountDetail.setBankName(stringHelperUtils.handleString(dto.getBankName()));
                    accountDetail.setAccountHolderName(stringHelperUtils.handleString(dto.getAccountHolderName()));
                    accountDetail.setAccountNumber(stringHelperUtils.handleString(dto.getAccountNumber()));
                    accountDetail.setIfscCode(stringHelperUtils.handleString(dto.getIfscCode()));
                    accountDetail.setBankAddress(stringHelperUtils.handleString(dto.getBankAddress()));
                    accountDetail.setFamilyId(new BigInteger(String.valueOf(dto.getFamilyId())));
                    accountDetail.setStatus(1);

                    if (dto.getAccDetId() != 0) {
                        accountDetail.setAccDetId(dto.getAccDetId());

                    } else {
                        accountDetail.setAccDetId(0);
                    }
                    return accountDetail;
                })
                .collect(Collectors.toList());
        accountDetailRepo.saveAccountDetail(accountDetails);

    }

    @Override
    @Transactional
    public List<AccountDetailDTO> getAllAccountDetails(int familyId) {



        List<AccountDetail> result = accountDetailRepo.getAllAccountDetails(familyId);

        try {

            return result.stream().map(data -> mapper.map(data, AccountDetailDTO.class)).toList();

        }catch(Exception e) {

            return new ArrayList<>();
        }
    }


}