package com.sharemanagement.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.sharemanagement.dto.FamilyDto;
import com.sharemanagement.dto.FamilyRequestDto;
import com.sharemanagement.entities.FamilyMember;
import com.sharemanagement.repositories.FamilyRepo;
import com.sharemanagement.utils.StringHelperUtils;

@Service
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	FamilyRepo familyRepo;
	
	@Autowired
	StringHelperUtils stringHelperUtils;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	@Transactional
	public String createFamily(FamilyRequestDto familyRequestDto) throws Exception {
		
		try {
			
			com.sharemanagement.entities.Family familyData = new com.sharemanagement.entities.Family();
			familyData.setCreatedBy(new BigInteger(String.valueOf(familyRequestDto.getUserId())));
			familyData.setStatus(1);
			Long familyId = familyRepo.createFamilyId(familyData);
			
		familyRequestDto.getFamilyDto().stream().forEach(family -> {
			
			FamilyMember families = new FamilyMember();
			families.setAadharNo(stringHelperUtils.handleString(family.getAadharNo()));
			families.setAddress(stringHelperUtils.handleString(family.getAddress()));
			families.setEmailId(stringHelperUtils.handleString(family.getEmailId()));
			families.setFirstName(stringHelperUtils.handleString(family.getFirstName()));
			families.setMiddleName(stringHelperUtils.handleString(family.getMiddleName()));
			families.setLastName(stringHelperUtils.handleString(family.getLastName()));
			families.setPanNo(stringHelperUtils.handleString(family.getPanNO()));
			families.setPhone(stringHelperUtils.handleString(family.getPhone()));
			families.setRelation(stringHelperUtils.handleString(family.getRelation()));
			families.setFamilyId(new BigInteger(String.valueOf(familyId)));
			families.setStatus(1);
			families.setCreatedBy(new BigInteger(String.valueOf(familyRequestDto.getUserId())));
			families.setPinCode(family.getPinCode());
			familyRepo.createFamily(families);
		});
		
		     return "success";
		
		}catch(Exception e) {
			
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	@Transactional
	public List<FamilyDto> getAllFamily(int pageCount) {
		
		
		int firstResult = 10;
		int pgCount = (pageCount-1)* firstResult;
		
		List<FamilyMember> result = familyRepo.getAllFamily(pgCount);
		
		try {
		
			List<FamilyDto> mapData = result.stream().map(data -> {
	        	
				FamilyDto familyDto = mapper.map(data, FamilyDto.class);
				return familyDto;
				
			}).toList();
			
			return mapData;
			
		}catch(Exception e) {
			
			return new ArrayList<FamilyDto>();
		}
		
        
        
	}

	@Override
	@Transactional
	public long getFamiltTotalCount() {
		
		return familyRepo.getFamilyTotalCount();
	}

	@Override
	@Transactional
	public String deleteMemberFromFamily(Long memberId,BigInteger userId) {
	
		FamilyMember familyMember = familyRepo.getFamilyMemberById(memberId);
		familyMember.setStatus(0);
		familyMember.setUpdatedBy(userId);
		familyMember.setUpdatedDate(new Date());
		try {
			
			familyRepo.deleteMemberFromFamily(familyMember);
			return "success";
			
		}catch(Exception e) {
			
			return "error";
		}
		
		
	}

	@Override
	@Transactional
	public String updateFamilyMember(FamilyDto familyDto,BigInteger userId) {
		
		FamilyMember familyMember = familyRepo.getFamilyMemberById(familyDto.getMemberId().longValue());
		familyMember.setAadharNo(familyDto.getAadharNo());
		familyMember.setAddress(familyDto.getAddress());
		familyMember.setEmailId(familyDto.getEmailId());
		familyMember.setFirstName(familyDto.getFirstName());
		familyMember.setLastName(familyDto.getLastName());
		familyMember.setMiddleName(familyDto.getMiddleName());
		familyMember.setPanNo(familyDto.getPanNO());
		familyMember.setPhone(familyDto.getPhone());
		familyMember.setPinCode(familyDto.getPinCode());
		familyMember.setRelation(familyDto.getRelation());
		familyMember.setUpdatedBy(userId);
		familyMember.setUpdatedDate(new Date());
		try {
			
			familyRepo.deleteMemberFromFamily(familyMember);
			
			return "success";
			
		}catch(Exception e) {
			
			return "error";
		}
		
	}

	@Override
	@Transactional
	public String getIndividualMember(Long memberId) {
		
		FamilyMember familyMember = familyRepo.getFamilyMemberByIdActive(memberId);
		try {
			
		FamilyDto familyDto = mapper.map(familyMember,FamilyDto.class);		
		return new Gson().toJson(familyDto);
		
		}catch(Exception e) {
			
			Map<String,String> res = new HashMap<>();
			res.put("message", "User not exist!");
			return new Gson().toJson(res);
		}
	}

}
