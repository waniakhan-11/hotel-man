package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.BookingDTO;
import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import com.example.demo.model.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByUser(User user);
	List<Booking> findByRoomAndCheckOutDateAfterAndCheckInDateBefore(Room room, LocalDate checkInDate, LocalDate checkOutDate);

}