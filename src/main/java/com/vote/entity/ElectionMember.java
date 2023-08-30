package com.vote.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ElectionMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberId;

	@Column(length = 30, nullable = false)
	private String memberName;

	@Column(length = 30, nullable = false)
	private String memberParty;

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
	
	
	
	

}