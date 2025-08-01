package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	List<Room> findByAvailableTrue();

//	@Query(value = """
//	        SELECT * FROM rooms r
//	        WHERE r.available = true AND r.id NOT IN (
//	            SELECT b.room_id FROM bookings b
//	            WHERE b.check_out > :checkIn AND b.check_in < :checkOut
//	        )
//	    """, nativeQuery = true)
//	    List<Room> findAvailableRoomsByDates(LocalDate checkIn, LocalDate checkOut);

}
