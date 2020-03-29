package com.web.service.soap.bindings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.roytuts.jaxb.GetCountryRequest;
import com.roytuts.jaxb.GetCountryResponse;
import com.web.service.soap.repository.CountryRepository;

@Endpoint
public class WebServiceBinding {

	private static final Logger logger = LoggerFactory.getLogger(WebServiceBinding.class);

	private final String NAMESPACE = "http://spring.io/guides/gs-producing-web-service";

	@Autowired
	private CountryRepository repository;

	@PayloadRoot(namespace = NAMESPACE, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {

		if (request == null || request.getName().isEmpty())
			return new GetCountryResponse();

		logger.info(">>>>>>> Request Received >>>>>>> " + request);
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(repository.findCountry(request.getName()));

		return response;
	}
}
