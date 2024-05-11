package com.hcl.hackathon.controller;

import com.hcl.hackathon.request.RequestWO;
import com.hcl.hackathon.service.BeneficiaryService;
import com.hcl.hackathon.response.BeneficiaryResponse;
import com.hcl.hackathon.exception.InvalidRequest;
import com.hcl.hackathon.request.BeneficiaryAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeneficiaryController {


    @Autowired
    BeneficiaryService beneficiaryService;

    @PostMapping("addBeneficiary")
    ResponseEntity<BeneficiaryResponse> addBeneficiary(@RequestBody BeneficiaryAddRequest beneficiaryRequestAdd) throws InvalidRequest {

        if (validateUser(beneficiaryRequestAdd)==null) {
            throw new InvalidRequest("Invalid request");
        }

        BeneficiaryResponse beneficiaryResponse = beneficiaryService.addBeneficiaryResponse(beneficiaryRequestAdd);

        return new ResponseEntity<>(beneficiaryResponse, HttpStatus.ACCEPTED);
    }


    @GetMapping("viewBeneficiary")
    ResponseEntity<BeneficiaryResponse> viewBeneficiary(@RequestBody RequestWO requestWO) throws InvalidRequest {

        Long userid;
        BeneficiaryResponse beneficiaryResponse =null;
        if ((userid = validateUser(requestWO)) ==null) {
            return new ResponseEntity<>(beneficiaryResponse, HttpStatus.FAILED_DEPENDENCY);
        }


         beneficiaryResponse = beneficiaryService.viewBeneficiary(userid);

        return new ResponseEntity<>(beneficiaryResponse, HttpStatus.ACCEPTED);
    }

    Long validateUser(RequestWO beneficiaryRequestAdd) throws InvalidRequest {

        if(beneficiaryRequestAdd.getJwtKey()==null){
            throw new InvalidRequest("Invalid user");
        }
        return Long.valueOf(beneficiaryRequestAdd.getJwtKey());
    }
}
