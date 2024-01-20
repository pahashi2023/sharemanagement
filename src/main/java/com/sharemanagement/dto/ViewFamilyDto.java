package com.sharemanagement.dto;

import java.math.BigInteger;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewFamilyDto {
	
	private BigInteger familyId;
	private List<FamilyDto> family;
}
