package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.BookingRequestDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.BookingService;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/public/bookings")
@Tag(name = "Booking Controller")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private UserService userService;

	// Book a room
	@PostMapping("/book")
	@ResponseBody
	public BookingDTO bookRoom(@RequestBody BookingRequestDTO bookingRequest, Principal principal) {
		return bookingService.bookRoom(bookingRequest, principal);
	}

	// View user's bookings
	@GetMapping("/my")
	public List<BookingDTO> getUserBookings(Principal principal) {
		UserDTO user = userService.findByUsername(principal.getName());
		return bookingService.getUserBookings(user);
	}
}
