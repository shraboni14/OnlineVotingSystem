package com.vote.service;

import java.util.List;

import com.vote.dto.ElectionMemberDTO;
import com.vote.entity.ElectionMember;

public interface ElectionMemberService {

//	method for adding election member into the database
	ElectionMemberDTO createElectionMember(ElectionMember member);

//	method for fetch election member from the database
	ElectionMemberDTO getMemberById(int id);

//	method for fetch all members from the database
	List<ElectionMemberDTO> getAllElectionMembers();

//	method for update a single member
	ElectionMemberDTO updateElectionMember(int memberId, ElectionMember member);

//	method for deleting a particular member
	void deleteElectionMemberById(int eMemberId);
}
