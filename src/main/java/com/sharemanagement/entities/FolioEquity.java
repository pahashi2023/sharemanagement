package com.sharemanagement.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
//@Table(name = "folio_equity")
public class FolioEquity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="equityId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long equityId;
    @Column(name="equityCount")
    private String equityCount;
    @Column(name="equityCertificateNumber")
    private String equityCertificateNumber;
    @Column(name="equityDestNumberFrom")
    private String equityDestNumberFrom;
    @Column(name="equityDestNumberTo")
    private String equityDestNumberTo;
    @Column(name="enterFVRs")
    private String enterFVRs;
    @Column(name="enterPurchaseDate")
    private String enterPurchaseDate;
    @ManyToOne
    @JoinColumn(name = "isr1_id")
    private Isr1 isr1;
    @Transient
    private Long isr1Id;

}
