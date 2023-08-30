package com.vote.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class Candidate extends User {
	
	@Column(length = 20, nullable = false, unique = true)
	private String voterId;

	@Column(length = 20, nullable = false)
	private LocalDate dateOfBirth;

	@Column(length = 20, nullable = false, unique = true)
	private int contact;

	@OneToOne
	private Address address; // one candidate can have only one address

	@ManyToOne
	private ElectionMember electionMember; // Many candidate can vote one member
	
	

	public ElectionMember getElectionMember() {
		return electionMember;
	}

	public void setElectionMember(ElectionMember electionMember) {
		this.electionMember = electionMember;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
