package com.hcl.hackathon.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "beneficiary")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BeneficiaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private long accountNumber;
    @Column(name = "beneficiary_account_number")
    private long beneficiaryAccountNumber;

    @Column(name = "ifsc_code", length = 50)
    private String ifscCode;

    @Column(name = "beneficiary_first_name", length = 50)
    private String beneficiaryFirstName;

    @Column(name = "beneficiary_last_name", length = 50)
    private String beneficiaryLastName;

    @OneToMany(mappedBy = "beneficiaryAccount", fetch = FetchType.LAZY)
    private List<AmountTransaction> amountTransactions;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updateDate;

    @Column(name = "status")
    private String status;

}
