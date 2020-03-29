package com.web.service.soap.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.consumingwebservice.wsdl.GetCountryRequest;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import com.web.service.soap.consumer.binding.SoapConnector;

@Service
public class CountryService {

	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

	@Value("${webservice.endpoint-url}")
	private String endpoint;

	@Autowired
	private SoapConnector client;

	public void getCountry(String country) {
		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		GetCountryResponse response = (GetCountryResponse) client.callWebService(endpoint + "/countries", request);
		logger.info(">>>>>>> Response Received >>>>>> " + response.getCountry().getCapital());
	}

}
