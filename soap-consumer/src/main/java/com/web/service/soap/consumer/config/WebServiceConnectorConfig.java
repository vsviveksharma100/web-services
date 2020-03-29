package com.web.service.soap.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.web.service.soap.consumer.binding.SoapConnector;

@Configuration
public class WebServiceConnectorConfig {

	@Value("${webservice.endpoint-url}")
	private String endPointUrl;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this is the package name specified in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.example.consumingwebservice.wsdl");
		return marshaller;
	}

	@Bean
	public SoapConnector soapConnector(Jaxb2Marshaller marshaller) {
		SoapConnector client = new SoapConnector();
		client.setDefaultUri(endPointUrl);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	public String getEndPointUrl() {
		return endPointUrl;
	}

	public void setEndPointUrl(String endPointUrl) {
		this.endPointUrl = endPointUrl;
	}

}
