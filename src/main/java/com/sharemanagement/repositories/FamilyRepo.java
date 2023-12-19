package com.sharemanagement.repositories;

import com.sharemanagement.entities.Family;
import com.sharemanagement.entities.FamilyMember;

public interface FamilyRepo {
	
	public Long createFamily(FamilyMember obj);
	
	public Long createFamilyId(Family family);

}
