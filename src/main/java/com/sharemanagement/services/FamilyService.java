package com.sharemanagement.services;

import java.util.List;

import com.sharemanagement.dto.FamilyDto;
import com.sharemanagement.dto.FamilyRequestDto;

public interface FamilyService {
	
	public String createFamily(FamilyRequestDto familyRequestDto) throws Exception;
	
	public List<FamilyDto> getAllFamily(int pageCount);
	
	public long getFamiltTotalCount();

}
