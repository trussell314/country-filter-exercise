package com.trussell.nmexercise.country;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class CountryControllerTest {

	@Mock
	private CountryService countryService;

	@InjectMocks
	private CountryController target;

	public CountryControllerTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getAllCountries_hitsService() {
		List<CountryView> expectedResults = mock(List.class);
		doReturn(expectedResults).when(countryService).findAll();
		List<CountryView> results = target.getAllCountries();
		Assert.assertEquals(expectedResults, results);
	}

}
