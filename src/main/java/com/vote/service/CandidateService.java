package com.vote.service;

import java.util.List;

import com.vote.dto.CandidateDTO;
import com.vote.entity.Candidate;

public interface CandidateService {
	
	String createCandidate(Candidate candidate);
	
	CandidateDTO getCandidateById(int canId);
	
	List<CandidateDTO> getAllCandidate();

}
