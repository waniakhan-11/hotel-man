package com.example.demo.dto;

import com.example.demo.enums.PaymentMethod;

public class BookingRequestDTO {
    private Long roomId;
    private String checkInDate;
    private String checkOutDate;
    private PaymentMethod paymentMethod;

    
    
    public BookingRequestDTO() {
		super();
	}
	public BookingRequestDTO(Long roomId, String checkInDate, String checkOutDate, PaymentMethod paymentMethod) {
		super();
		this.roomId = roomId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.paymentMethod = paymentMethod;
	}
	// Getters and Setters
    public Long getRoomId() { return roomId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }

    public String getCheckInDate() { return checkInDate; }
    public void setCheckInDate(String checkInDate) { this.checkInDate = checkInDate; }

    public String getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(String checkOutDate) { this.checkOutDate = checkOutDate; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }
	@Override
	public String toString() {
		return "BookingRequestDTO [roomId=" + roomId + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", paymentMethod=" + paymentMethod + "]";
	}

    
}
