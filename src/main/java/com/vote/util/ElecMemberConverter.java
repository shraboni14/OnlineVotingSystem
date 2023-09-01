package com.vote.util;

import org.springframework.beans.BeanUtils;

import com.vote.dto.ElectionMemberDTO;
import com.vote.entity.ElectionMember;

public class ElecMemberConverter {

//	method to convert DTO to Member entity

	public ElectionMember convertDtoToEntity(ElectionMemberDTO eDto) {

		ElectionMember eMember = new ElectionMember();

		if (eDto != null) {
			BeanUtils.copyProperties(eDto, eMember);
		}
		return eMember;
	}

//	Method to convert Member entity to DTO

	public ElectionMemberDTO convertEntityToDto(ElectionMember eMember) {

		ElectionMemberDTO eDto = new ElectionMemberDTO();

		if (eMember != null) {
			BeanUtils.copyProperties(eMember, eDto);
		}
		return eDto;
	}

}
