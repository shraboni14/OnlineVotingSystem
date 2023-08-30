package com.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
