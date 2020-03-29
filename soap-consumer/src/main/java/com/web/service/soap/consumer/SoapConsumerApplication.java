package com.web.service.soap.consumer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.service.soap.consumer.service.CountryService;

@SpringBootApplication
public class SoapConsumerApplication {

	@Autowired
	private CountryService service;

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumerApplication.class, args);
	}

	@PostConstruct
	private void serviceCall() {
		service.getCountry("Spain");
	}
}
