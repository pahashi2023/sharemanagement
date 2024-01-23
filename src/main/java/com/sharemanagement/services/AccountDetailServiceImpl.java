package com.sharemanagement.services;

import com.sharemanagement.dto.AccountDetailDTO;
import com.sharemanagement.dto.AccountMemberDetailsDto;
import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.entities.AccountMemberDetails;
import com.sharemanagement.repositories.AccountDetailRepo;

import com.sharemanagement.utils.StringHelperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
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
    public void saveAccountDetail(List<AccountDetailDTO> accountDetailDTOList) {
        List<AccountDetail> accountDetails = accountDetailDTOList.stream()
                .map(dto -> {
                    AccountDetail accountDetail = new AccountDetail();
                    accountDetail.setCreatedBy(stringHelperUtils.handleBigInt(dto.getUserId()));
                    accountDetail.setAccountType(stringHelperUtils.handleString(dto.getAccountType()));
                    accountDetail.setBankName(stringHelperUtils.handleString(dto.getBankName()));
                    accountDetail.setAccountNumber(stringHelperUtils.handleString(dto.getAccountNumber()));
                    accountDetail.setIfscCode(stringHelperUtils.handleString(dto.getIfscCode()));
                    accountDetail.setBankAddress(stringHelperUtils.handleString(dto.getBankAddress()));
                    accountDetail.setFamilyId(new BigInteger(String.valueOf(dto.getFamilyId())));
                    accountDetail.setAccountMemberAddress(stringHelperUtils.handleString(dto.getAccountMemberAddress()));
                    accountDetail.setEmail(stringHelperUtils.handleString(dto.getEmail()));
                    accountDetail.setPhone(stringHelperUtils.handleString(dto.getPhone()));
                    accountDetail.setAccountOpeningDate(dto.getAccountOpeningDate());
                    accountDetail.setBankBranchName(dto.getBankBranchName());
                    accountDetail.setStatus(1);

                    // Check if accDetId exists, then update;
                    if (dto.getAccDetId() != 0) {
                        accountDetail.setAccDetId(dto.getAccDetId());
                    }

                    List<AccountMemberDetails> memberDetails = dto.getAccountMemberDetailDtos().stream()
                            .map(memberDto -> {
                                AccountMemberDetails memberDetail = new AccountMemberDetails();
                                memberDetail.setAccountDetail(accountDetail);  // Set the relationship
                                memberDetail.setMemberId(stringHelperUtils.handleBigInt(memberDto.getMemberId()));
                                memberDetail.setAccountHolderName(stringHelperUtils.handleString(memberDto.getAccountHolderName()));

                                // Check if memberDetailId exists, then update;
                                if (memberDto.getMemberDetailId() != 0) {
                                    memberDetail.setMemberDetailId(memberDto.getMemberDetailId());
                                }

                                return memberDetail;
                            })
                            .collect(Collectors.toList());

                    accountDetail.setAccountMemberDetails(memberDetails);
                    return accountDetail;
                })
                .collect(Collectors.toList());

        accountDetailRepo.saveAccountDetail(accountDetails);
    }

    @Override
    @Transactional
    public List<AccountDetailDTO> getAllAccountDetails(int familyId, String accountType) {
        List<AccountDetail> result = accountDetailRepo.getAllAccountDetails(familyId,accountType);

        try {
            return result.stream().map(data -> {
                AccountDetailDTO accountDetailDTO = mapper.map(data, AccountDetailDTO.class);

                // Map AccountMemberDetails to AccountMemberDetailDTO
                List<AccountMemberDetailsDto> memberDetailDTOs = data.getAccountMemberDetails().stream()
                        .map(memberDetail -> mapper.map(memberDetail, AccountMemberDetailsDto.class))
                        .collect(Collectors.toList());

                accountDetailDTO.setAccountMemberDetailDtos(memberDetailDTOs);
                return accountDetailDTO;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void deleteAccountdetails(int accDetId) {
        accountDetailRepo.deleteAccountdetails(accDetId);
    }


}