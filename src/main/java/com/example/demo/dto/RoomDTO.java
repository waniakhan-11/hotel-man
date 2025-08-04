package com.example.demo.dto;

import com.example.demo.enums.OccupancyType;

public class RoomDTO {
	private Long roomId;
	private String roomNumber;
	private OccupancyType occupancyType;
	private Double ratePerNight;
	private Double discountPercent;
	private String description;
	private boolean available;

	public RoomDTO() {
	}

	public RoomDTO(Long roomId, String roomNumber, OccupancyType occupancyType, Double ratePerNight,
			Double discountPercent, String description, boolean available) {
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.occupancyType = occupancyType;
		this.ratePerNight = ratePerNight;
		this.discountPercent = discountPercent;
		this.description = description;
		this.available = available;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
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

	@Override
	public String toString() {
		return "RoomDTO [roomId=" + roomId + ", roomNumber=" + roomNumber + ", occupancyType=" + occupancyType
				+ ", ratePerNight=" + ratePerNight + ", discountPercent=" + discountPercent + ", description="
				+ description + ", available=" + available + "]";
	}

}
