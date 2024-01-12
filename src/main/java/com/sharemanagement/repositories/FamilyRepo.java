package com.sharemanagement.repositories;

import java.math.BigInteger;
import java.util.List;

import com.sharemanagement.entities.Family;
import com.sharemanagement.entities.FamilyMember;

public interface FamilyRepo {
	
	public Long createFamily(FamilyMember obj);
	
	public Long createFamilyId(Family family);
	
	public List<FamilyMember> getAllFamily(int pageCount);
	
	public long getFamilyTotalCount();
	
	public FamilyMember getFamilyMemberById(Long memberId);
	
	public FamilyMember getFamilyMemberByIdActive(Long memberId);
	
	public void deleteMemberFromFamily(FamilyMember familyMember);

}
