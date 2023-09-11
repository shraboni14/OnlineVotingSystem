package com.vote.dto;

import java.time.LocalDate;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.vote.entity.Address;
import com.vote.entity.ElectionMember;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CandidateDTO extends UserDTO{

	@NotNull(message = "VoterId is required")
	@Size(min = 10, max = 10)
	private String voterId;

	@NotNull(message = "Date Of Birth is required")
	private LocalDate dateOfBirth;

	@NotNull(message = "Contact is required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "Invalid contact details")	//[starting should me from 6,7,8,9,]{position}[range of number]{how much number it will take}
	@Size(min = 10, max = 10)
	private int contact;

	@OneToOne
	private Address address;
	
	private ElectionMember electionMember; // Many candidate can vote one member

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

	public ElectionMember getElectionMember() {
		return electionMember;
	}

	public void setElectionMember(ElectionMember electionMember) {
		this.electionMember = electionMember;
	}
	

}
