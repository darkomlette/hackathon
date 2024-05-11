package com.hcl.hackathon;

import com.hcl.hackathon.entity.BeneficiaryEntity;
import com.hcl.hackathon.repo.BeneficiaryRepo;
import com.hcl.hackathon.request.BeneficiaryAddRequest;
import com.hcl.hackathon.response.BeneficiaryResponse;
import com.hcl.hackathon.service.BeneficiaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class HackathonApplicationTests {

	@Mock
	private BeneficiaryRepo beneficiaryRepo;

	@InjectMocks
	private BeneficiaryService beneficiaryService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddBeneficiary_Success() {
		// Mock BeneficiaryAddRequest
		BeneficiaryAddRequest request = new BeneficiaryAddRequest();
		request.setAccountNumber(1234567890L);
		request.setJwtKey(""+1234567890L);
		request.setBeneficaryAccountNumber(4324324L);
		request.setFirstName("John");
		request.setLastName("Doe");


		// Mock BeneficiaryEntity
		BeneficiaryEntity mockedBeneficiary = new BeneficiaryEntity();
		mockedBeneficiary.setAccountNumber(request.getAccountNumber());
		mockedBeneficiary.setBeneficiaryFirstName(request.getFirstName());
		mockedBeneficiary.setBeneficiaryAccountNumber(request.getBeneficaryAccountNumber());
		mockedBeneficiary.setBeneficiaryLastName(request.getLastName());

		// Mock beneficiaryRepo.save
		when(beneficiaryRepo.save(any(BeneficiaryEntity.class))).thenReturn(mockedBeneficiary);

		// Perform service call
		BeneficiaryResponse response = beneficiaryService.addBeneficiaryResponse(request);

		// Verify beneficiaryRepo.save is called once
		verify(beneficiaryRepo, times(1)).save(any(BeneficiaryEntity.class));

		// Assert the response
		assertEquals(HttpStatus.ACCEPTED, response.getStatus());
		assertEquals("Success", response.getMessage());
	}


	public void testAllBeneficiary(){
		BeneficiaryAddRequest request = new BeneficiaryAddRequest();
		request.setAccountNumber(1234567890L);
		request.setBeneficaryAccountNumber(4324324L);
		request.setFirstName("John");
		request.setLastName("Doe");

		// Mock BeneficiaryEntity
		BeneficiaryEntity mockedBeneficiary = new BeneficiaryEntity();
		mockedBeneficiary.setAccountNumber(request.getAccountNumber());
		mockedBeneficiary.setBeneficiaryFirstName(request.getFirstName());
		mockedBeneficiary.setBeneficiaryAccountNumber(request.getBeneficaryAccountNumber());
		mockedBeneficiary.setBeneficiaryLastName(request.getLastName());
	}
	// Add more test cases for edge cases and error scenarios
}
