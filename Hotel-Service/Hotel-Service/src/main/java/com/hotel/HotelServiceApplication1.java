package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //it is optional in newer version after 2020
public class HotelServiceApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication1.class, args);
	}

}
