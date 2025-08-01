package com.example.demo.dto;

import com.example.demo.enums.UserType;

public class UserDTO {
	private Long id;
	private String username;
	private UserType role;

	public UserDTO() {
	}

	public UserDTO(Long id, String username, UserType role) {
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", role=" + role + "]";
	}
	
	
}
