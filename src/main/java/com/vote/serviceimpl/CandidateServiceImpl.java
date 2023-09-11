package com.vote.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.dto.CandidateDTO;
import com.vote.entity.Address;
import com.vote.entity.Candidate;
import com.vote.entity.ElectionMember;
import com.vote.entity.Role;
import com.vote.exception.ResourceNotFoundException;
import com.vote.repository.AddressRepository;
import com.vote.repository.CandidateRepository;
import com.vote.repository.ElectionMemberRepository;
import com.vote.repository.RoleRepository;
import com.vote.service.CandidateService;
import com.vote.util.CandidateConverter;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepository; // we will use the functions of jpa repository

	@Autowired
	CandidateConverter candidateConverter;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ElectionMemberRepository eMemberRepository;

//	method to create candidate
	@Override
	public CandidateDTO createCandidate(Candidate candidate) {

		String user = candidate.getName().substring(0, candidate.getName().indexOf(" "));
		candidate.setUserName(user);

		String pass = candidate.getName().substring(0, 4).toLowerCase();
		candidate.setPassword(pass + "123");

//		setting the role
		Role role = roleRepository.findById(2).get();
		candidate.setRole(role);

		addressRepository.save(candidate.getAddress());	// saving the address of the candidate

		candidateRepository.save(candidate); // saving the candidate object to the database

		CandidateDTO cDto = candidateConverter.convertEntityToDto(candidate);
		return cDto;
	}

//	method to get candidate by id
	@Override
	public CandidateDTO getCandidateById(int canId) throws ResourceNotFoundException {

		Candidate candidate = candidateRepository.findById(canId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate", "id", canId));
//		using lambda expression for throwing my custom exception
		return candidateConverter.convertEntityToDto(candidate);
	}

//	method to get all candidates in a list

	@Override
	public List<CandidateDTO> getAllCandidate() {

		List<Candidate> candidates = candidateRepository.findAll();

		List<CandidateDTO> cDtos = new ArrayList<>();

		for (Candidate c : candidates) {

			CandidateDTO cDto = candidateConverter.convertEntityToDto(c);

			cDtos.add(cDto);
		}
		return cDtos;
	}
	
	
//	method to update candidate
	@Override
	public CandidateDTO updateCandidate(int canId, Candidate candidate) throws ResourceNotFoundException {

		Candidate existingCandidate = candidateRepository.findById(canId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate ", " ID", canId));

//		update existing candidate details with new updated details
		existingCandidate.setName(candidate.getName());
		existingCandidate.setVoterId(candidate.getVoterId());
		existingCandidate.setAddress(candidate.getAddress());
		existingCandidate.setDateOfBirth(candidate.getDateOfBirth());
		existingCandidate.setContact(candidate.getContact());

//		saving the changes made
		candidateRepository.save(existingCandidate);

		return candidateConverter.convertEntityToDto(existingCandidate);
	}

	
//	method to delete a single candidate by id
	@Override
	public void deleteCandidateById(int canId) throws ResourceNotFoundException {

		Candidate candidate = candidateRepository.findById(canId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate ", " ID", canId));

		Address address = candidate.getAddress();

		ElectionMember eMember = candidate.getElectionMember();

		if (address != null) {
			candidate.setAddress(null);
			addressRepository.delete(address);
		}

		if (eMember != null) {
			eMember.setNoOfTotalVote(eMember.getNoOfTotalVote() - 1);
		}

		candidateRepository.delete(candidate);
	}

	
//	method to delete all candidates
	@Override
	public void deleteAll() {

		candidateRepository.deleteAll();
	}

	
//	custom method to find candidate by name
	@Override
	public List<CandidateDTO> findByName(String name) {

		List<Candidate> candidates = candidateRepository.findByName(name);

		List<CandidateDTO> canDtos = new ArrayList<>();

		for (Candidate c : candidates) {
			canDtos.add(candidateConverter.convertEntityToDto(c));
		}

		return canDtos;
	}

	
//	custom method to find candidate by their voter id
	@Override
	public List<CandidateDTO> findByVoterId(String voterId) {

		List<Candidate> candidates = candidateRepository.findByVoterId(voterId);

		List<CandidateDTO> candidateDTOs = new ArrayList<>();

		for (Candidate c : candidates) {
			candidateDTOs.add(candidateConverter.convertEntityToDto(c));
		}
		return candidateDTOs;
	}

	@Override
	public long countByName(String name) {
		
		long canNo = candidateRepository.countByName(name);
		return canNo;
	}

}
