package com.vote.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vote.dto.ElectionMemberDTO;
import com.vote.entity.ElectionMember;
import com.vote.exception.ResourceNotFoundException;
import com.vote.repository.ElectionMemberRepository;
import com.vote.service.ElectionMemberService;
import com.vote.util.ElecMemberConverter;

public class ElectionMemberServiceImpl implements ElectionMemberService {

	@Autowired
	ElectionMemberRepository eMemberRepository;

	@Autowired
	ElecMemberConverter eMemberConverter;

	@Override
	public ElectionMemberDTO createElectionMember(ElectionMember member) {
		eMemberRepository.save(member);
		return eMemberConverter.convertEntityToDto(member);
	}

	@Override
	public ElectionMemberDTO getMemberById(int id) throws ResourceNotFoundException {

		ElectionMember electionMember = eMemberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Election Member ", "Id ", id));

		return eMemberConverter.convertEntityToDto(electionMember);
	}

	@Override
	public List<ElectionMemberDTO> getAllElectionMembers() {

		List<ElectionMember> memberList = eMemberRepository.findAll();

		List<ElectionMemberDTO> memberListDto = new ArrayList<>();

		for (ElectionMember em : memberList) {

			ElectionMemberDTO convertDto = eMemberConverter.convertEntityToDto(em);

			memberListDto.add(convertDto);
		}

		return memberListDto;
	}

	@Override
	public ElectionMemberDTO updateElectionMember(int memberId, ElectionMember member)
			throws ResourceNotFoundException {

		ElectionMember existingMember = eMemberRepository.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("Election Member", "id", memberId));

		existingMember.setMemberName(member.getMemberName());
		existingMember.setMemberParty(member.getMemberParty());

		eMemberRepository.save(existingMember);

		return eMemberConverter.convertEntityToDto(existingMember);
	}

	@Override
	public void deleteElectionMemberById(int eMemberId) {

		ElectionMember existingMember = eMemberRepository.findById(eMemberId)
				.orElseThrow(() -> new ResourceNotFoundException("Election Member", "id", eMemberId));

		eMemberRepository.delete(existingMember);

	}

}
