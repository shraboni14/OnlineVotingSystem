package com.vote.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vote.dto.CandidateDTO;
import com.vote.entity.Candidate;
import com.vote.repository.CandidateRepository;
import com.vote.service.CandidateService;
import com.vote.util.CandidateConverter;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepository; // we will use the functions of jpa repository

	@Autowired
	CandidateConverter candidateConverter;

	@Override
	public String createCandidate(Candidate candidate) {

		String user = candidate.getName().substring(0, candidate.getName().indexOf(" "));
		candidate.setUserName(user);

		String pass = candidate.getName().substring(0, 4).toLowerCase();
		candidate.setPassword(pass + "123");

		candidateRepository.save(candidate);

		return "Candidate record saved successfully";
	}

	@Override
	public CandidateDTO getCandidateById(int canId) {

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

}
