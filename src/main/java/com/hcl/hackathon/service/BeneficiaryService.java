package com.hcl.hackathon.service;


import com.hcl.hackathon.entity.BeneficiaryEntity;
import com.hcl.hackathon.repo.BeneficiaryRepo;
import com.hcl.hackathon.request.RequestWO;
import com.hcl.hackathon.response.BeneficiaryResponse;
import com.hcl.hackathon.request.BeneficiaryAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BeneficiaryService {


    @Autowired
    BeneficiaryRepo beneficiaryRepo;

    public BeneficiaryResponse addBeneficiaryResponse(BeneficiaryAddRequest beneficiaryRequestAdd) {

        BeneficiaryEntity beneficiary = new BeneficiaryEntity();
        beneficiary.setIfscCode(beneficiaryRequestAdd.getIfscCode());
        beneficiary.setBeneficiaryAccountNumber(beneficiaryRequestAdd.getBeneficaryAccountNumber());
        beneficiary.setAccountNumber(beneficiaryRequestAdd.getAccountNumber());
        beneficiary.setBeneficiaryFirstName(beneficiaryRequestAdd.getFirstName());
        beneficiary.setBeneficiaryLastName(beneficiaryRequestAdd.getLastName());
        beneficiary.setCreatedDate(LocalDateTime.now());
        beneficiary.setUpdateDate(LocalDateTime.now());
        beneficiaryRepo.save(beneficiary);


        BeneficiaryResponse response = new BeneficiaryResponse(HttpStatus.ACCEPTED, "Success");


        return response;
    }

    public BeneficiaryResponse viewBeneficiary(long id) {


        List<BeneficiaryEntity> beneficiaryEntities = beneficiaryRepo.findAllByAccountNumber(id);

        BeneficiaryResponse response = new BeneficiaryResponse(HttpStatus.ACCEPTED, "Success");
        response.setBeneficiaryEntities(beneficiaryEntities);

        return response;
    }
}
