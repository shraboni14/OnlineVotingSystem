package com.vote.service;

import com.vote.dto.CandidateDTO;
import com.vote.entity.Candidate;

public interface CandidateService {
	
	String createCandidate(Candidate candidate);
	
	CandidateDTO getCandidateById(int canId);

}
