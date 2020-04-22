package com.trussell.nmexercise.country;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CountryRepositoryIntegrationTest {

	@Autowired
	private CountryRepository target;

	@Test
	void search() {
		List<CountryEntity> countryEntities = target.findAll();
		Assert.assertTrue(countryEntities.size() > 0);
	}
}
