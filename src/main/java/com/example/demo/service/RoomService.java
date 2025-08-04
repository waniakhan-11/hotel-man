package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoomDTO;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.UserRepository;

@Service
public class RoomService {

	private final UserRepository userRepository;

	@Autowired
	RoomRepository roomRepository;

	RoomService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<RoomDTO> getAvailableRooms() {
		List<Room> roomList = roomRepository.findByAvailableTrue();
		return roomList.stream().map(RoomMapper::toDTO).collect(Collectors.toList());
	}

	public RoomDTO addRoom(RoomDTO room) {
		Room roomentity = roomRepository.save(RoomMapper.toEntity(room));
		return RoomMapper.toDTO(roomentity);
	}

	public RoomDTO findById(Long id) {
		return RoomMapper.toDTO(roomRepository.findById(id).get());

	}

	public RoomDTO updateRoom(RoomDTO room) {
		return RoomMapper.toDTO(roomRepository.save(RoomMapper.toEntity(room)));
	}

	public void deleteRoom(Long id) {
		roomRepository.deleteById(id);
	}

	public List<RoomDTO> getAllRooms() {
		List<Room> roomList = roomRepository.findAll();
		return roomList.stream().map(RoomMapper::toDTO).collect(Collectors.toList());
	}

}
