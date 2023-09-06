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
	
	@NotNull(message = "Field is required")
	private int noOfTotalVote;

	@OneToMany
	private List<Candidate> candidates;	// one member can get multiple candidates vote

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberParty() {
		return memberParty;
	}

	public void setMemberParty(String memberParty) {
		this.memberParty = memberParty;
	}

	public int getNoOfTotalVote() {
		return noOfTotalVote;
	}

	public void setNoOfTotalVote(int noOfTotalVote) {
		this.noOfTotalVote = noOfTotalVote;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	

}
