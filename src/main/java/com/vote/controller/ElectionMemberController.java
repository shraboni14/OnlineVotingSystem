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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vote.dto.ElectionMemberDTO;
import com.vote.entity.ElectionMember;
import com.vote.service.ElectionMemberService;
import com.vote.util.ElecMemberConverter;

public class ElectionMemberController {

	@Autowired
	ElectionMemberService eMemberService;

	@Autowired
	ElecMemberConverter eMemberConverter;

	@PutMapping("/createMember")
	public ElectionMemberDTO createMember(@Valid @RequestBody ElectionMember eMember) {

		return eMemberService.createElectionMember(eMember);
	}

	@PostMapping("/getMapping/{id}")
	public ElectionMemberDTO getMember(@PathVariable("id") int eMemberId) {
		return eMemberService.getMemberById(eMemberId);
	}

	@GetMapping("/getAllMember")
	public List<ElectionMemberDTO> getAllMember() {
		return eMemberService.getAllElectionMembers();
	}

	@PutMapping("updateElectionMember/{id}")
	public ElectionMemberDTO updateElecMember(@PathVariable("id") int memberId, @Valid @RequestBody ElectionMemberDTO eMemberDto) {
		
		final ElectionMember eMember = eMemberConverter.convertDtoToEntity(eMemberDto);
		
		return eMemberService.updateElectionMember(memberId, eMember);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> delById(@PathVariable("id") int mId) {
		eMemberService.deleteElectionMemberById(mId);

		return new ResponseEntity<String>("Member Record deleted successfully", HttpStatus.OK);
	}

}
