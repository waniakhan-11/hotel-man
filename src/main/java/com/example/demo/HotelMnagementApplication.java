package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
	    info = @Info(title = "Hotel Booking API", version = "1.0"),
	    tags = {
	        @Tag(name = "User Controller"),
	        @Tag(name = "Room Controller"),
	        @Tag(name = "Booking Controller")
	    }
	)
@SpringBootApplication
public class HotelMnagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HotelMnagementApplication.class, args);

	}

}
