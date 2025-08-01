package com.example.demo.dto;

import com.example.demo.enums.UserType;

public class UserRegistrationDTO {

	private Long id;

	private String username;

	private String password;

	private UserType role;

	private Double balance;

	public UserRegistrationDTO() {
	}

	public UserRegistrationDTO(Long id, String username, String password, UserType role, Double balance) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.balance = balance;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
