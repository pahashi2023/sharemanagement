package com.sharemanagement.repositories;

import com.sharemanagement.entities.AccountDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailRepo {
    void saveAccountDetail(AccountDetail accountDetail);


}
