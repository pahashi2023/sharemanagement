package com.sharemanagement.restcontroller;

import com.google.gson.Gson;
import com.sharemanagement.dto.AccountDetailDTO;
import com.sharemanagement.dto.FamilyDto;
import com.sharemanagement.dto.FamilyResponseDto;
import com.sharemanagement.dto.ResponseDto;
import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.services.AccountDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class AccountDetailController {

    public static final Logger logger = LoggerFactory.getLogger(AccountDetailController.class);

    @Autowired
    private AccountDetailService accountDetailService;



    @PostMapping(value="/account-detail/save",produces = "application/json",consumes = "application/json",headers="Accept=application/json")
    public ResponseEntity<String> saveAccountDetail(@RequestBody List<AccountDetailDTO> accountDetailDTO) {
        accountDetailService.saveAccountDetail(accountDetailDTO);

        ResponseDto dto = new ResponseDto();
        dto.setMessage("success");
        return ResponseEntity.ok(new Gson().toJson(dto));
    }

    @PostMapping(value = "/get-all-accountdetails",produces = "application/json",headers="Accept=application/json")
    public ResponseEntity<String> getAllAccountDetails(@RequestParam(name = "familyId") int familyId ){

        List<AccountDetailDTO> result = accountDetailService.getAllAccountDetails(familyId);
        ResponseDto dto = new ResponseDto();
        dto.setMessage("success");
        dto.setData(result);
        return ResponseEntity.ok(new Gson().toJson(dto));
    }
}
