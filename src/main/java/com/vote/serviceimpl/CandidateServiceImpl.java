package com.vote.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.dto.CandidateDTO;
import com.vote.entity.Address;
import com.vote.entity.Candidate;
import com.vote.entity.Role;
import com.vote.exception.ResourceNotFoundException;
import com.vote.repository.AddressRepository;
import com.vote.repository.CandidateRepository;
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

	@Override
	public CandidateDTO createCandidate(Candidate candidate) {

		String user = candidate.getName().substring(0, candidate.getName().indexOf(" "));
		candidate.setUserName(user);

		String pass = candidate.getName().substring(0, 4).toLowerCase();
		candidate.setPassword(pass + "123");

//		setting the role
		Role role = roleRepository.findById(2).get();
		candidate.setRole(role);

		addressRepository.save(candidate.getAddress());

		candidateRepository.save(candidate); // saving the candidate object to the database

		CandidateDTO cDto = candidateConverter.convertEntityToDto(candidate);
		return cDto;
	}

	@Override
	public CandidateDTO getCandidateById(int canId) throws ResourceNotFoundException {

		Candidate candidate = candidateRepository.findById(canId)
				.orElseThrow(() -> new com.vote.exception.ResourceNotFoundException("Candidate", "id", canId));
//		using lambda expression for throwing my custom exception
		return candidateConverter.convertEntityToDto(candidate);
	}

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

	@Override
	public void deleteCandidateById(int canId) throws ResourceNotFoundException {

		Candidate candidate = candidateRepository.findById(canId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate ", " ID", canId));

		Address address = candidate.getAddress();

		if (address != null) {
			candidate.setAddress(null);
			addressRepository.delete(address);
		}

		candidateRepository.delete(candidate);
	}

	@Override
	public void deleteAll() {

		candidateRepository.deleteAll();
	}

}
