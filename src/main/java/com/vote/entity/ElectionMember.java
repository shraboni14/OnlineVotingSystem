package com.vote.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElectionMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberId;

	@Column(length = 30, nullable = false)
	private String memberName;

	@Column(length = 30, nullable = false)
	private String memberParty;
	
	@Column(nullable = false)
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

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public int getNoOfTotalVote() {
		return noOfTotalVote;
	}

	public void setNoOfTotalVote(int noOfTotalVote) {
		this.noOfTotalVote = noOfTotalVote;
	}
	
	
	
	

}
