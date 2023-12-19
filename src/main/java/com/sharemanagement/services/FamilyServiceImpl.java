package com.sharemanagement.services;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	@Transactional
	public String createFamily(FamilyRequestDto familyRequestDto) throws Exception {
		
		try {
			
			com.sharemanagement.entities.Family familyData = new com.sharemanagement.entities.Family();
			familyData.setCreatedBy(new BigInteger(String.valueOf(familyRequestDto.getUserId())));
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
			familyRepo.createFamily(families);
		});
		
		     return "success";
		
		}catch(Exception e) {
			
			throw new Exception(e.getMessage());
		}
		
	}

}
