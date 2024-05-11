package com.hcl.hackathon.request;

import com.hcl.hackathon.annotation.RemoveInvalidCharacters;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryAddRequest extends RequestWO {

    @NotEmpty(message = "Account number cannot be empty")
    Long beneficaryAccountNumber;
    @NotEmpty(message = "Account number cannot be empty")
    Long accountNumber;
    @RemoveInvalidCharacters
    String ifscCode;
    @RemoveInvalidCharacters
    String firstName;
    @RemoveInvalidCharacters
    String lastName;

}
