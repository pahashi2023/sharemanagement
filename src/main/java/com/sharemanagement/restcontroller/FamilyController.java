package com.sharemanagement.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sharemanagement.dto.FamilyRequestDto;
import com.sharemanagement.dto.ResponseDto;
import com.sharemanagement.services.FamilyService;

@RestController
@RequestMapping("/api/v1")
public class FamilyController {
	
       public static final Logger logger = LoggerFactory.getLogger(FamilyController.class);
       
       @Autowired
       FamilyService familyService;
       
       @PostMapping(value = "/create-family",produces = "application/json",consumes = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> createFamily(@RequestBody FamilyRequestDto familyRequestDto) throws Exception{
    	   
    	   String result = familyService.createFamily(familyRequestDto);
    	   
    	   ResponseDto dto = new ResponseDto();
    	   dto.setMessage(result);
    	   return ResponseEntity.ok(new Gson().toJson(dto));
       }
	
	
}
