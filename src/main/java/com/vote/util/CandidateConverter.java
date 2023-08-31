package com.vote.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vote.dto.CandidateDTO;
import com.vote.entity.Candidate;

@Component
public class CandidateConverter {
	
//	method to convert dto to candidate entity

	public Candidate convertDtoToCandidateEntity(CandidateDTO cDto) {
		Candidate can = new Candidate();

		if (cDto != null) {
			BeanUtils.copyProperties(cDto, can);
		}
		return can;
	}

//	method to convert candidate entity to dto

	public CandidateDTO convertEntityToDto(Candidate can) {

		CandidateDTO cDto = new CandidateDTO();

		if (can != null) {
			BeanUtils.copyProperties(can, cDto);
		}
		return cDto;
	}

}
