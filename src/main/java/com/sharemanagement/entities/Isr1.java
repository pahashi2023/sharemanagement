package com.sharemanagement.entities;

import com.sharemanagement.dto.FolioEquityDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
//@Table(name = "isr1")
public class Isr1 implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="isr1Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isr1Id;
    @Column(name="isrName")
    private String isrName;
    @Column(name="familyId")
    private String familyId;
    @Column(name = "memberIds")
    @ElementCollection
    private List<String> memberIds;
    @Column(name="folioNumber")
    private String folioNumber;
    @Column(name="companyName")
    private String companyName;
    @Column(name="companyFullName")
    private String companyFullName;
    @OneToMany(mappedBy = "isr1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FolioEquity> folioEquityList;
    @ManyToOne
    @JoinColumn(name = "folio_id")
    private Folio folioEntity;
    @Column(name="type")
    private String type;
    @Column(name="BankId")
    private String bankId;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="status")
    private int status;

}
