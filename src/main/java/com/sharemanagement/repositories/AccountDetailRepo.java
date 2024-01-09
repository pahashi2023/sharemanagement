package com.sharemanagement.repositories;

import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.entities.FamilyMember;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailRepo {
//    void saveAccountDetail(AccountDetail accountDetail);
    void saveAccountDetail(List<AccountDetail> accountDetails);

    public List<AccountDetail> getAllAccountDetails(int familyId);

    void deleteAccountdetails(int accDetId);

}
