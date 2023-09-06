package com.vote.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.dto.ElectionMemberDTO;
import com.vote.entity.Candidate;
import com.vote.entity.ElectionMember;
import com.vote.exception.ResourceNotFoundException;
import com.vote.repository.CandidateRepository;
import com.vote.repository.ElectionMemberRepository;
import com.vote.service.ElectionMemberService;
import com.vote.util.ElecMemberConverter;

@Service
public class ElectionMemberServiceImpl implements ElectionMemberService {

	@Autowired
	ElectionMemberRepository eMemberRepository;

	@Autowired
	ElecMemberConverter eMemberConverter;

	@Autowired
	CandidateRepository canRepository;

	
//	Method for creating election member
	@Override
	public ElectionMemberDTO createElectionMember(ElectionMember member) {
		eMemberRepository.save(member);
		return eMemberConverter.convertEntityToDto(member);
	}

//	method for getting election member details by their id
	@Override
	public ElectionMemberDTO getMemberById(int id) throws ResourceNotFoundException {

		ElectionMember electionMember = eMemberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Election Member ", "Id ", id));

		return eMemberConverter.convertEntityToDto(electionMember);
	}

//	method for getting all election member
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

//	method for delete election member by id
	@Override
	public void deleteElectionMemberById(int eMemberId) {

		ElectionMember existingMember = eMemberRepository.findById(eMemberId)
				.orElseThrow(() -> new ResourceNotFoundException("Election Member", "id", eMemberId));

		eMemberRepository.delete(existingMember);

	}

	
//	method for assigning for vote candidates to election member
	@Override
	public void assignCandidateToMember(int canId, int memId) {

		Candidate can = canRepository.findById(canId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidate", "id", canId));

		ElectionMember eMember = eMemberRepository.findById(memId)
				.orElseThrow(() -> new ResourceNotFoundException("Member", "id", memId));

//		foreign key present in candidate table side

//		setting the election member corresponding a candidate
		can.setElectionMember(eMember);

//		at first we are fetching existing total number of vote and update by increase it by one
		eMember.setNoOfTotalVote(eMember.getNoOfTotalVote() + 1);

		canRepository.save(can);
	}

//	method for fetching election member details by their name
	@Override
	public List<ElectionMemberDTO> findByMemberName(String memberName) {
		
		List<ElectionMember> electionMembers = eMemberRepository.findByMemberName(memberName);
		
		List<ElectionMemberDTO> electionMemberDTOs = new ArrayList<>();
		
		for(ElectionMember em : electionMembers) {
			electionMemberDTOs.add(eMemberConverter.convertEntityToDto(em));
		}
		return electionMemberDTOs;
	}
	
	

}
