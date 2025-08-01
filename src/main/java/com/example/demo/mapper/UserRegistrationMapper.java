package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.model.User;

@Component
public class UserRegistrationMapper {

	public static UserRegistrationDTO toDTO(User user) {
		return new UserRegistrationDTO(user.getId(), user.getUsername(), user.getPassword(), user.getRole(),
				user.getBalance());
	}

	public static User toEntity(UserRegistrationDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setRole(dto.getRole());
		user.setBalance(dto.getBalance());
		return user;
	}
}
