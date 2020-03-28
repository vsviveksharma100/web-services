package com.web.service.soap.repository;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.roytuts.jaxb.Country;
import com.roytuts.jaxb.Currency;

@Component
public class CountryRepository {

	private static HashMap<String, Country> countries = new HashMap<>();;

	@PostConstruct
	private void populateCountries() {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		countries.put(spain.getName(), spain);

		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		countries.put(poland.getName(), poland);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		countries.put(uk.getName(), uk);
	}

	/**
	 * Return's Country for the Country Repository
	 * 
	 * @param name
	 * @return
	 */
	public Country findCountry(String name) {
		Assert.notNull(name, "Country's name must not be null");
		return countries.get(name);
	}

}
