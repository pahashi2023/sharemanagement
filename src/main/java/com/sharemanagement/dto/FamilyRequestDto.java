package com.sharemanagement.dto;

import java.util.List;

import lombok.Data;

@Data
public class FamilyRequestDto {
	
	private long userId;
	
	private List<FamilyDto> familyDto;

}
