package com.sharemanagement.restcontroller;

import com.google.gson.Gson;
import com.sharemanagement.dto.AccountDetailDTO;
import com.sharemanagement.dto.ResponseDto;
import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.services.AccountDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class AccountDetailController {

    public static final Logger logger = LoggerFactory.getLogger(AccountDetailController.class);

    @Autowired
    private AccountDetailService accountDetailService;



    @PostMapping(value="/account-detail/save",produces = "application/json",consumes = "application/json",headers="Accept=application/json")
    public ResponseEntity<String> saveAccountDetail(@RequestBody AccountDetailDTO accountDetailDTO) {
        accountDetailService.saveAccountDetail(accountDetailDTO);

        ResponseDto dto = new ResponseDto();
        dto.setMessage("success");
        return ResponseEntity.ok(new Gson().toJson(dto));
    }
}
