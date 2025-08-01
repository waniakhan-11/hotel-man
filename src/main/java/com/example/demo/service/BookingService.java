package com.example.demo.service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.BookingRequestDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.enums.PaymentMethod;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class BookingService {

    private final RoomRepository roomRepository;

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	RoomService roomService;
	@Autowired
	UserService userService;

    BookingService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

	public boolean isRoomAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
		List<Booking> overlapping = bookingRepository.findByRoomAndCheckOutDateAfterAndCheckInDateBefore(room,
				checkInDate, checkOutDate);
		return overlapping.isEmpty();
	}

	public BookingDTO bookRoom(BookingRequestDTO bookingRequestDTO, Principal principal) {
		
		User user = UserMapper.toEntity(userService.findByUsername(principal.getName()));
		Room room = RoomMapper.toEntity(roomService.findById(bookingRequestDTO.getRoomId()));
		LocalDate checkInDateFormatted = LocalDate.parse(bookingRequestDTO.getCheckInDate());
		LocalDate checkOutDateFormatted = LocalDate.parse(bookingRequestDTO.getCheckOutDate());
		PaymentMethod paymentMethod = bookingRequestDTO.getPaymentMethod();
		
		if (!room.isAvailable()) {
			throw new IllegalStateException("Room is not Available.");
		}
		
		if (!isRoomAvailable(room, checkInDateFormatted, checkOutDateFormatted) ) {
			throw new IllegalStateException("Room is already booked for the selected dates.");
		}

		long days = checkOutDateFormatted.toEpochDay() - checkInDateFormatted.toEpochDay();
		if (days <= 0) {
			throw new IllegalArgumentException("Invalid check-in/check-out dates.");
		}

		double rate = room.getRatePerNight();
		double discount = room.getDiscountPercent();
		double total = rate * days * (1 - discount / 100);

		if (paymentMethod == PaymentMethod.ACCOUNT) {
			userService.deductFromAccount(user, total);
		}

		Booking booking = new Booking(checkInDateFormatted, checkOutDateFormatted, total, paymentMethod, room, user);
		
		return BookingMapper.toDTO(bookingRepository.save(booking));

	}

	public List<BookingDTO> getUserBookings(UserDTO user) {
		User u = UserMapper.toEntity(user);
		List<Booking> userList = bookingRepository.findByUser(u);

		return (List<BookingDTO>) userList.stream().map(BookingMapper::toDTO).collect(Collectors.toList());
	}
}
