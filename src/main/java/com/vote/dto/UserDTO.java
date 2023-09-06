package com.vote.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vote.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	private int id;

	@NotNull
	@Size(min = 2 , max = 30, message = "Minimum 2 and maximum 30 charracters allowed")
	@NotBlank(message = "Please enter correct name")
	private String name;

	private String userName;

	private String password;

	@OneToOne
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
