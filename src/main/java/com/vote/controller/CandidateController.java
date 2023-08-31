package com.vote.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vote.dto.CandidateDTO;
import com.vote.entity.Candidate;
import com.vote.service.CandidateService;
import com.vote.util.CandidateConverter;

@RestController
public class CandidateController {

	@Autowired
	CandidateService candidateService;

	@Autowired
	CandidateConverter candidateConverter;

	@PostMapping("/createCandidate")
	public String createCandidate(@Valid @RequestBody Candidate candidate) {
		return candidateService.createCandidate(candidate);
	}

	@GetMapping("/getCandidate/{canId}")
	public CandidateDTO getCandidate(@PathVariable("canId") int id) {
		return candidateService.getCandidateById(id);
	}

	@GetMapping("getAllCandidates")
	public List<CandidateDTO> getAllCandidates() {

		return candidateService.getAllCandidate();
	}

}
