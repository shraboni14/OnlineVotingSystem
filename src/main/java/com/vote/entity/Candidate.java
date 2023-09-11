package com.vote.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@AllArgsConstructor
public class Candidate extends User {

	@Column(length = 20, nullable = false, unique = true)
	private String voterId;

	@Column(length = 20, nullable = false)
	private LocalDate dateOfBirth;

	@Column(length = 20, nullable = false, unique = true)
	private String contact;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Builder
	public Candidate(int id, String name, String userName, String password, Role role, String voterId,
			LocalDate dateOfBirth, String contact, Address address, ElectionMember electionMember) {
		super(id, name, userName, password, role);
		this.voterId = voterId;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.address = address;
		this.electionMember = electionMember;
	}

	public Candidate() {
		super();
	}

}
