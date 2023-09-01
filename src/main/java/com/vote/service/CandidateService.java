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

//	method to update saved student details which is present in the database
	CandidateDTO updateCandidate(int canId, Candidate candidate);

//	method to delete one student details
	void deleteCandidateById(int canId);

//	method to delete all the student
	void deleteAll();
}
