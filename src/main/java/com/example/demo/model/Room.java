package com.example.demo.model;

import com.example.demo.enums.OccupancyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Long roomId;

	private String roomNumber;

	@Enumerated(EnumType.STRING)
	private OccupancyType occupancyType;

	private Double ratePerNight;

	private Double discountPercent;

	private String description;

	private boolean available;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long id) {
		this.roomId = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public OccupancyType getOccupancyType() {
		return occupancyType;
	}

	public void setOccupancyType(OccupancyType occupancyType) {
		this.occupancyType = occupancyType;
	}

	public Double getRatePerNight() {
		return ratePerNight;
	}

	public void setRatePerNight(Double ratePerNight) {
		this.ratePerNight = ratePerNight;
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
