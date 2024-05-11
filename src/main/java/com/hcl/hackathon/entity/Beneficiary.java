package com.hcl.hackathon.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "beneficiaries")
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private List<Transactions> transactions;

    private Long accountId;
    private String accountNumber;
    private String ifscCode;
    private String firstName;
    private String lastName;
    private Date createdDate;
    private Date updatedDate;
    private String status;

}
