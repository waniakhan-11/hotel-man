package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserRegistrationMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	private final DaoAuthenticationProvider authenticationProvider;

	@Autowired
	UserRepository userRepository;

	UserService(DaoAuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	public UserDTO findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new RuntimeException("User not found: " + username);
		}
		return UserMapper.toDTO(user);
	}

	public UserRegistrationDTO saveUser(UserRegistrationDTO user) {
		return UserRegistrationMapper.toDTO(userRepository.save(userRegistrationDTOToUser(user)));
	}

	public void deductFromAccount(User user, double amount) {
		double balance = user.getBalance();
		if (balance >= amount) {
			user.setBalance(balance - amount);
			userRepository.save(user);
		} else {
			throw new IllegalArgumentException("Insufficient account balance.");
		}
	}

	private User userRegistrationDTOToUser(UserRegistrationDTO userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setBalance(userDto.getBalance());

		return user;
	}
}
