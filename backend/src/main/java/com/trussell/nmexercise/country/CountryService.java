package com.trussell.nmexercise.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

	private final CountryRepository countryRepository;

	@Autowired
	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public List<CountryView> findAll() {
		List<CountryEntity> countryEntities = countryRepository.findAll();
		return countryEntities.stream()
		                      .map(CountryMapper.INSTANCE::entityToView)
		                      .collect(Collectors.toList());
	}
}
