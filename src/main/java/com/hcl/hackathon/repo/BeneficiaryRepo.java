package com.hcl.hackathon.repo;

import com.hcl.hackathon.entity.BeneficiaryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeneficiaryRepo extends CrudRepository<BeneficiaryEntity, Long> {

  List<BeneficiaryEntity> findAllByAccountNumber(Long accountNumber);
}
