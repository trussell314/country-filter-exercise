package com.trussell.nmexercise.country;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class CountryServiceTest {

	@Mock
	private CountryRepository countryRepository;

	@InjectMocks
	private CountryService target;

	public CountryServiceTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void findAll_hitsRepositoryAndMapsResults() {
		CountryEntity entity1 = mock(CountryEntity.class);
		CountryEntity entity2 = mock(CountryEntity.class);
		doReturn(Arrays.asList(entity1, entity2)).when(countryRepository).findAll();
		List<CountryView> views = target.findAll();
		Assert.assertEquals(2, views.size());
	}


}
