package com.panshi.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootCRUDMain {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootCRUDMain.class, args);

	}

}
