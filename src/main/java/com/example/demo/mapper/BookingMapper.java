package com.example.demo.mapper;

import com.example.demo.dto.BookingDTO;
import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.model.User;

public class BookingMapper {

	public static BookingDTO toDTO(Booking booking) {
		return new BookingDTO(booking.getId(), booking.getUser().getId(), booking.getRoom().getRoomId(),
				booking.getCheckInDate(), booking.getCheckOutDate(), booking.getTotalPrice(),
				booking.getPaymentMethod(), booking.getStatus());
	}

	public static Booking toEntity(BookingDTO dto, User user, Room room) {
		Booking booking = new Booking();
		booking.setId(dto.getId());
		booking.setUser(user);
		booking.setRoom(room);
		booking.setCheckInDate(dto.getCheckInDate());
		booking.setCheckOutDate(dto.getCheckOutDate());
		booking.setTotalPrice(dto.getTotalPrice());
		booking.setPaymentMethod(dto.getPaymentMethod());
		booking.setStatus(dto.getStatus());
		return booking;
	}
}
