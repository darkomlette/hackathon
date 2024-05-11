package com.hcl.hackathon.entity;


import com.hcl.hackathon.constant.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "amount_transaction")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AmountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "beneficiary_schema_id")
    private BeneficiaryEntity beneficiaryAccount;
}
