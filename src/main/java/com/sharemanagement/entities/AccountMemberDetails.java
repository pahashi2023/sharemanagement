package com.sharemanagement.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Setter
@Getter
@Entity
@Table(name = "account_member_details")
public class AccountMemberDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_detail_id")
    private long memberDetailId;

    @ManyToOne
    @JoinColumn(name = "acc_det_id")
    private AccountDetail accountDetail;

    @Column(name = "member_id")
    private BigInteger memberId;

    @Transient
    private Long accDetId;

    @Column(name = "account_holder_name")
    private String accountHolderName;
}
