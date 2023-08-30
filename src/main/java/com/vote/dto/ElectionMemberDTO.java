package com.vote.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.vote.entity.Candidate;

public class ElectionMemberDTO {
	
	@NotNull(message = "Member id is required")
	private int memberId;

	@NotNull(message = "Member Name is required")
	private String memberName;

	@NotNull(message = "Member Party is required")
	private String memberParty;

	@OneToMany
	private List<Candidate> candidates;	// one member can get multiple candidates vote

}
