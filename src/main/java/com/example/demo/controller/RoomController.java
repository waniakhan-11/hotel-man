package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDTO;
import com.example.demo.service.RoomService;
import com.example.demo.util.NullFieldChecker;

@RestController
@RequestMapping("/api/admin/rooms")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping
	@ResponseBody
	public List<RoomDTO> getAllRooms() {
		return roomService.getAllRooms();
	}

	@GetMapping("/available")
	@ResponseBody
	public List<RoomDTO> getAvailableRooms() {
		return roomService.getAvailableRooms();
	}

	@PostMapping
	@ResponseBody
	public RoomDTO createRoom(@RequestBody RoomDTO room) {
		return roomService.addRoom(room);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public RoomDTO updateRoom(@PathVariable("id") Long id, @RequestBody RoomDTO roomDetails) {
//        logger.info("Inside put controller");
		RoomDTO roomDb = roomService.findById(id);
		System.out.println(roomDb + "--------before-----------" + roomDetails);
		NullFieldChecker.copyNonNullFields(roomDetails, roomDb, "roomId");
		System.out.println(roomDb+"----------after---------"+roomDetails);
		return roomService.updateRoom(roomDb);
	}

	@PatchMapping("/{id}")
	@ResponseBody
	public RoomDTO updateRoomAttribut(@PathVariable("id") Long id, @RequestBody RoomDTO roomDetails) {
		System.out.println("---------room patch---"+roomDetails);
		RoomDTO roomDb = roomService.findById(id);
		return roomService.updateRoom(roomDb);
	}

	@DeleteMapping("/{id}")
	public void deleteRoom(@PathVariable("id") Long id) {
		roomService.deleteRoom(id);
	}
}
