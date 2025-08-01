package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.enums.UserType;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Configuration
public class DataInitializer {

	@Bean
	CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			User existingUserAdmin = userRepository.findByUsername("admin");
			if (existingUserAdmin == null) {
			    User admin = new User();
			    admin.setUsername("admin");
			    admin.setPassword(passwordEncoder.encode("admin123"));
			    admin.setRole(UserType.ADMIN);
			    admin.setBalance(0.0);
			    userRepository.save(admin);
			}

			User existingUseCustomerr = userRepository.findByUsername("customer");
			if (existingUseCustomerr == null) {
				User customer = new User();
				customer.setUsername("customer");
				customer.setPassword(passwordEncoder.encode("cust123"));
				customer.setRole(UserType.CUSTOMER);
				customer.setBalance(5000.0);
				userRepository.save(customer);
			}
		};
	}
}
