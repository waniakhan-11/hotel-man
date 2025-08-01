package com.example.demo.mapper;

import com.example.demo.dto.RoomDTO;
import com.example.demo.model.Room;

public class RoomMapper {

	public static RoomDTO toDTO(Room room) {

		return new RoomDTO(room.getRoomId(), room.getRoomNumber(), room.getOccupancyType(), room.getRatePerNight(),
				room.getDiscountPercent(), room.getDescription(), room.isAvailable());
	}

	public static Room toEntity(RoomDTO dto) {
		Room room = new Room();
		room.setRoomId(dto.getRoomId());
		room.setRoomNumber(dto.getRoomNumber());
		room.setOccupancyType(dto.getOccupancyType());
		room.setRatePerNight(dto.getRatePerNight());
		room.setDiscountPercent(dto.getDiscountPercent());
		room.setDescription(dto.getDescription());
		room.setAvailable(dto.isAvailable());
		return room;
	}
}
