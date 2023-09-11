package com.vote.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//	rest api for creating candidate
	@PostMapping("/createCandidate")
	public CandidateDTO createCandidate(@Valid @RequestBody Candidate candidate) {
		return candidateService.createCandidate(candidate);
	}

//	controller for getting single candidate details by their id
	@GetMapping("/getCandidate/{canId}")
	public CandidateDTO getCandidate(@PathVariable("canId") int id) {
		return candidateService.getCandidateById(id);
	}

//	controller for getting all candidate details 
	@GetMapping("getAllCandidates")
	public List<CandidateDTO> getAllCandidates() {

		return candidateService.getAllCandidate();
	}

//	controller for updating all details of a particular candidate
	@PutMapping("updateCandidate/{id}") // when we want to update every details
	public CandidateDTO updateStudent(@PathVariable("id") int canId, @Valid @RequestBody CandidateDTO canDto) {

		final Candidate can = candidateConverter.convertDtoToCandidateEntity(canDto);
		return candidateService.updateCandidate(canId, can);
	}

//	controller for delete particular candidate by it's id
	@DeleteMapping("/deleteCandidateById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int canId) {
		candidateService.deleteCandidateById(canId);
		return new ResponseEntity<String>("Candidate with id " + canId + " Deleted successfully", HttpStatus.OK);
	}

//	controller for delete all candidates
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		candidateService.deleteAll();
		return new ResponseEntity<String>("All Candidate details deleted successfully", HttpStatus.OK);
	}

//	Controller for getting candidate details by their name
	@GetMapping("/findByName/{name}")
	public List<CandidateDTO> findByName(@PathVariable("name") String name) {
		return candidateService.findByName(name);
	}

//	Controller for getting candidate details by their voterId

	@GetMapping("/findByVoterId/{voterId}")
	public List<CandidateDTO> findByVoterId(@PathVariable("voterId") String voterId) {
		return candidateService.findByVoterId(voterId);
	}

//	Controller for getting number of candidate details present by their name
	@GetMapping("/countByName/{name}")
	public long countByName(@PathVariable("name") String name) {
		return candidateService.countByName(name);
	}

}
