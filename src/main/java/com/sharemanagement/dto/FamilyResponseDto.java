package com.sharemanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FamilyResponseDto {
	
	public String message;
	public Object Data;
	public long totalPage;
}
