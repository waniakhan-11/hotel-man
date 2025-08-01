package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.enums.PaymentMethod;

public class BookingDTO {

	private Long id;
	private Long userId; // Avoid exposing full User
	private Long roomId; // Avoid exposing full Room
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private Double totalPrice;
	private PaymentMethod paymentMethod;
	private String status;

	public BookingDTO() {
	}

	public BookingDTO(Long id, Long userId, Long roomId, LocalDate checkInDate, LocalDate checkOutDate,
			Double totalPrice, PaymentMethod paymentMethod, String status) {
		this.id = id;
		this.userId = userId;
		this.roomId = roomId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
