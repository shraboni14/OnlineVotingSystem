package com.vote.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vote.dto.CandidateDTO;
import com.vote.entity.Candidate;
import com.vote.repository.CandidateRepository;
import com.vote.service.CandidateService;
import com.vote.util.CandidateConverter;

public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	CandidateRepository candidateRepository;	// we will use the functions of jpa repository 
	
	@Autowired
	CandidateConverter candidateConverter;

	@Override
	public String createCandidate(Candidate candidate) {
		
		String user = candidate.getName();
		candidate.setUserName(user);

		String pass = candidate.getName().substring(0, 4).toLowerCase();
		candidate.setPassword(pass + "123");
		
		candidateRepository.save(candidate);
		
		return "Candidate record saved successfully";
	}

	@Override
	public CandidateDTO getCandidateById(int canId) {
		
		Candidate candidate = candidateRepository.findById(canId).get();
		return candidateConverter.convertEntityToDto(candidate);
	}

}
