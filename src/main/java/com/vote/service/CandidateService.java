package com.vote.service;

import java.util.List;

import com.vote.dto.CandidateDTO;
import com.vote.entity.Candidate;

public interface CandidateService {

//	method used to create and save candidate details
	CandidateDTO createCandidate(Candidate candidate);

//	method to get all  details of the candidates
	CandidateDTO getCandidateById(int canId);

//	method to get all details in a loop
	List<CandidateDTO> getAllCandidate();

//	method to update saved candidate details which is present in the database
	CandidateDTO updateCandidate(int canId, Candidate candidate);

//	method to delete one candidate details
	void deleteCandidateById(int canId);

//	method to delete all the candidate
	void deleteAll();
	
//	custom method to search candidate by using name
	List<CandidateDTO> findByName(String name);
	
//	custom method to search candidate by using voterId
	List<CandidateDTO> findByVoterId(String voterId);
	
	long countByName(String name);
}
