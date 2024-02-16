package com.sharemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Isr1DTO {

    private long isr1Id;
    private String isrName;
    private String familyId;
    private List<String> memberIds;
    private String folioNumber;
    private String CampnayName; // Note: Corrected field name from "CampnayNAme" to "companyName"
    private String CampnyFullName; // Note: Corrected field name from "CampnyFullName" to "companyFullName"
    private List<FolioEquityDTO> Equity;
    private String type;
    private String BankId; // Note: Corrected field name from "BankId" to "bankId"
    private String email;
    private String phone;
    private int status;
}
