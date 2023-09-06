package com.vote.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vote.dto.ElectionMemberDTO;
import com.vote.entity.ElectionMember;

@Component
public class ElecMemberConverter {

//	method to convert DTO to Member entity

	public ElectionMember convertDtoToEntity(ElectionMemberDTO eDto) {

//		instantiating Member class
		ElectionMember eMember = new ElectionMember();

		if (eDto != null) {
			BeanUtils.copyProperties(eDto, eMember);
		}
		return eMember;
	}

//	Method to convert Member entity to DTO

	public ElectionMemberDTO convertEntityToDto(ElectionMember eMember) {

//		instantiating MemberDTO class
		ElectionMemberDTO eDto = new ElectionMemberDTO();

		if (eMember != null) {
			BeanUtils.copyProperties(eMember, eDto);
		}
		return eDto;
	}

}
