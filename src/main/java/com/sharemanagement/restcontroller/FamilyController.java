package com.sharemanagement.restcontroller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sharemanagement.dto.FamilyDto;
import com.sharemanagement.dto.FamilyRequestDto;
import com.sharemanagement.dto.FamilyResponseDto;
import com.sharemanagement.dto.ResponseDto;
import com.sharemanagement.dto.ViewFamilyDto;
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
       
       @PostMapping(value = "/get-all-family",produces = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> getAllFamily(@RequestParam(name = "pageCount",required=false,defaultValue = "1") int pageCount ){
    	  
    	   List<FamilyDto> result = familyService.getAllFamily(pageCount);
    	   FamilyResponseDto dto = new FamilyResponseDto();
    	   dto.setMessage("success");
    	   dto.setData(result);
    	   dto.setTotalPage(familyService.getFamiltTotalCount());
    	   return ResponseEntity.ok(new Gson().toJson(dto));
       }
       
       @PostMapping(value = "get-family",produces = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> getFamilyById(@RequestParam(name = "familyId",required = true) BigInteger familyId){
    	   
    	   List<FamilyDto> familyDto = familyService.getFamilyById(familyId);
    	   FamilyResponseDto dto = new FamilyResponseDto();
    	   if(familyDto.size() == 0) {
    		   
        	   dto.setMessage("success");
        	   dto.setData("No Data");
        	   return ResponseEntity.ok(new Gson().toJson(dto));
        	   
    	   }else {
    		   
        	   dto.setMessage("success");
        	   dto.setData(familyDto);
        	   return ResponseEntity.ok(new Gson().toJson(dto));
    	   }
       }
       
       
       @PostMapping(value = "/delete-member",produces = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> deleteMemberById(@RequestParam(name = "memberId", required=true) Long memberId,@RequestParam(name = "userId", required=true) BigInteger userId){
    	   
    	   String result = familyService.deleteMemberFromFamily(memberId,userId);

    	   ResponseDto dto = new ResponseDto();
    	   dto.setMessage(result);
    	   return ResponseEntity.ok(new Gson().toJson(dto));
       }
       
       @PostMapping(value = "/update-member",produces = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> updateFamilyMember(@RequestParam(name = "userId", required=true) BigInteger userId,@RequestBody FamilyDto familyDto){
    	   
    	   String result =  familyService.updateFamilyMember(familyDto,userId);
    	   ResponseDto dto = new ResponseDto();
    	   dto.setMessage(result);
    	   return ResponseEntity.ok(new Gson().toJson(dto));
       }
       
       @PostMapping(value = "/get-individual-member",produces = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> getIndividualMember(@RequestParam(name = "memberId", required=true) Long memberId){
    	   
    	   return ResponseEntity.ok(familyService.getIndividualMember(memberId));
       }
       
       @PostMapping(value = "/delete-family",produces = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> deleteFamilyById(@RequestParam(name = "familyId",required = true) long familyId){
    	   
    	   String result = familyService.deleteFamilyById(familyId);
    	   ResponseDto dto = new ResponseDto();
    	   dto.setMessage(result);
    	   return ResponseEntity.ok(new Gson().toJson(dto));
       }
       
       @PostMapping(value = "/view-family",produces = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> viewFamily(@RequestParam(name = "pageCount",required=false,defaultValue = "1") int pageCount){
    	   
    	   List<ViewFamilyDto> result =  familyService.viewFamily(pageCount);
    	   FamilyResponseDto dto = new FamilyResponseDto();
    	   dto.setMessage("success");
    	   dto.setData(result);
    	   dto.setTotalPage(familyService.getFamiltTotalCount());
    	   return ResponseEntity.ok(new Gson().toJson(dto));
       }
       
       @PostMapping(value = "/add-member",produces = "application/json",consumes = "application/json",headers="Accept=application/json")
       public ResponseEntity<String> addMemberInFamily(@RequestBody FamilyRequestDto familyRequestDto){
    	   
           String result = familyService.addMemberInFamily(familyRequestDto);
    	   ResponseDto dto = new ResponseDto();
    	   dto.setMessage(result);
    	   return ResponseEntity.ok(new Gson().toJson(dto));
       }
	
}
