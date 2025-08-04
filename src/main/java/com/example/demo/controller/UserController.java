package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRegistrationDTO;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/public/users") // public endpoint. /register will work with auth, but /me needs auth
@Tag(name = "User Controller")
public class UserController {

	@Autowired
	private UserService userService;

	// Get currently logged-in user
	@GetMapping("/me")
	public UserDTO getCurrentUser(Authentication authentication) {
		String username = authentication.getName();
		return userService.findByUsername(username);
	}

	@PostMapping("/register")
	public UserRegistrationDTO registerUser(@RequestBody UserRegistrationDTO user) {
		return userService.saveUser(user);
	}
}
