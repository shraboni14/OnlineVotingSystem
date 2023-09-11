package com.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.entity.Candidate;
import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

//	custom method for searching candidates using name
	List<Candidate> findByName(String name);

//	custom method for searching candidates using voterId	
	List<Candidate> findByVoterId(String voterId);

//	custom method to count how many candidates are available with a particular name
	long countByName(String name);

}
