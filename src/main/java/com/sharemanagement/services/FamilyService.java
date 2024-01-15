package com.sharemanagement.services;

import java.math.BigInteger;
import java.util.List;

import com.sharemanagement.dto.FamilyDto;
import com.sharemanagement.dto.FamilyRequestDto;

public interface FamilyService {
	
	public String createFamily(FamilyRequestDto familyRequestDto) throws Exception;
	
	public List<FamilyDto> getAllFamily(int pageCount);
	
	public List<FamilyDto> getFamilyById(BigInteger familyId);
	
	public long getFamiltTotalCount();
	
	public String deleteMemberFromFamily(Long memberId,BigInteger userId);
	
	public String updateFamilyMember(FamilyDto familyDto,BigInteger userId);
	
	public String getIndividualMember(Long memberId);

}
