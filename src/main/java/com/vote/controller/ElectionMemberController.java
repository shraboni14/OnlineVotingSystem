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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vote.dto.ElectionMemberDTO;
import com.vote.entity.ElectionMember;
import com.vote.service.ElectionMemberService;
import com.vote.util.ElecMemberConverter;

@RestController
public class ElectionMemberController {

	@Autowired
	ElectionMemberService eMemberService;

	@Autowired
	ElecMemberConverter eMemberConverter;

//	controller for creating member
	@PostMapping("/createMember")
	public ElectionMemberDTO createMember(@Valid @RequestBody ElectionMemberDTO eMemberDTO) {
		final ElectionMember eMember = eMemberConverter.convertDtoToEntity(eMemberDTO);
		return eMemberService.createElectionMember(eMember);
	}

//	controller for getting member details by id
	@GetMapping("/getMember/{id}")
	public ElectionMemberDTO getMember(@PathVariable("id") int eMemberId) {
		return eMemberService.getMemberById(eMemberId);
	}

//	controller for getting all members in a list format
	@GetMapping("/getAllMember")
	public List<ElectionMemberDTO> getAllMember() {
		return eMemberService.getAllElectionMembers();
	}

//	controller for deleting by id
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> delById(@PathVariable("id") int mId) {
		eMemberService.deleteElectionMemberById(mId);

		return new ResponseEntity<String>("Member Record deleted successfully", HttpStatus.OK);
	}

//	controller for assigning vote to election member
	@PostMapping("/assignCandidate/{cId}/toMem/{mId}")
	public ResponseEntity<String> assignedToMember(@PathVariable("cId") int canId, @PathVariable("mId") int memId) {
		eMemberService.assignCandidateToMember(canId, memId);
		return new ResponseEntity<String>("Candidate with id " + canId + " Give vote to Election Member id " + memId,
				HttpStatus.OK);
	}

//	controller for fetching election member details by their name
	@GetMapping("/findByMemberName/{name}")
	public List<ElectionMemberDTO> findByMemberName(@PathVariable("name") String memberName) {
		return eMemberService.findByMemberName(memberName);
	}

}
