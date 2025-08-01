package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

@Component
public class UserMapper {

	public static UserDTO toDTO(User user) {
		return new UserDTO(user.getId(), user.getUsername(), user.getRole());
	}

	public static User toEntity(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setRole(dto.getRole());
		return user;
	}
}
