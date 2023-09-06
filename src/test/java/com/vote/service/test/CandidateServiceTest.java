package com.vote.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vote.entity.Address;
import com.vote.entity.Candidate;
import com.vote.repository.CandidateRepository;
import com.vote.service.CandidateService;

@SpringBootTest
class CandidateServiceTest {

	@Autowired
	CandidateService canService;

	@MockBean
	CandidateRepository canRepository;

//	testcase for testing create candidate method by using candidate name property
	@Test
	@DisplayName("CreateCandideTest")
	void testCreateCandidate() {
		Address add = Address.builder().locality("New Barrackpur").city("Kolkata").state("WestBengal").pincode(700131)
				.build();

		Candidate can = Candidate.builder().name("Shraboni Sinha").voterId("XMV123765")
				.dateOfBirth(LocalDate.of(1996, 8, 5)).contact("8697588053").address(add).build();

		Mockito.when(canRepository.save(can)).thenReturn(can);

		assertEquals("Shraboni Sinha", canService.createCandidate(can).getName());
	}

	@Test
	@DisplayName("Positive Testcase")
	void testPositiveGetCandidateById() {
		Address add = Address.builder().locality("New Barrackpur").city("Kolkata").state("WestBengal").pincode(700131)
				.build();

		Candidate can = Candidate.builder().name("Shraboni Sinha").voterId("XMV123765")
				.dateOfBirth(LocalDate.of(1996, 8, 5)).contact("8697588053").address(add).build();

		Optional<Candidate> opCan = Optional.of(can);
		Mockito.when(canRepository.findById(can.getId())).thenReturn(opCan);
		
		String voterId = canService.getCandidateById(can.getId()).getVoterId();
		
		assertTrue(voterId.equals("XMV123765"));
	}
	
	
	@Test
	@DisplayName("Negative Testcase")
	void testNegGetCandidateById() {
		Address add = Address.builder().locality("New Barrackpur").city("Kolkata").state("WestBengal").pincode(700131)
				.build();

		Candidate can = Candidate.builder().name("Shraboni Sinha").voterId("XMV123765")
				.dateOfBirth(LocalDate.of(1996, 8, 5)).contact("8697588053").address(add).build();

		Optional<Candidate> opCan = Optional.of(can);
		Mockito.when(canRepository.findById(can.getId())).thenReturn(opCan);
		
		String voterId = canService.getCandidateById(can.getId()).getVoterId();
		
		assertTrue(voterId.equals("XMV123760"));
	}

}
