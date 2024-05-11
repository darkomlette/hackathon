package com.hcl.hackathon.response;


import com.hcl.hackathon.entity.BeneficiaryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class BeneficiaryResponse extends Response {

    List<BeneficiaryEntity> beneficiaryEntities;
    public BeneficiaryResponse(HttpStatus status,String desc){
        super(status,desc);
    }

}
