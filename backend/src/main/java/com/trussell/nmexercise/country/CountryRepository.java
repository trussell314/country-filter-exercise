package com.trussell.nmexercise.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository // Not a repository in the database sense, but serves as a front to the underlying API
public class CountryRepository {

	private final RestTemplate restTemplate;

	@Autowired
	public CountryRepository(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public List<CountryEntity> findAll() {
		ParameterizedTypeReference<Map<String, CountryEntity>> parameterizedTypeReference = new ParameterizedTypeReference<Map<String, CountryEntity>>() {};
		Map<String, CountryEntity> countriesByCode = restTemplate.exchange("https://api.ipgeolocationapi.com/countries",
		                                                                   HttpMethod.GET,
		                                                                   null,
		                                                                   parameterizedTypeReference)
		                                                         .getBody();
		return countriesByCode.values()
		                      .stream()
		                      .collect(Collectors.toList());
	}
}
