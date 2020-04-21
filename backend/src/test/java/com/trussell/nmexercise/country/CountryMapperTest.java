package com.trussell.nmexercise.country;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class CountryMapperTest {

	@Test
	void entityToView_testNormalCase() {
		final String CONTINENT = "Antarctica";
		final String ISO_CODE = "QQ";
		final String NAME = "ParkaLand";
		final String NATIONALITY = "ParkaPeople";
		final String CURRENCY_CODE = "USD";

		CountryEntity mockEntity = mock(CountryEntity.class);
		doReturn(CONTINENT).when(mockEntity).getContinent();
		doReturn(ISO_CODE).when(mockEntity).getAlpha2();
		doReturn(NAME).when(mockEntity).getName();
		doReturn(NATIONALITY).when(mockEntity).getNationality();
		doReturn(CURRENCY_CODE).when(mockEntity).getCurrencyCode();

		CountryView view = CountryMapper.INSTANCE.entityToView(mockEntity);

		Assert.assertEquals(CONTINENT, view.getContinent());
		Assert.assertEquals(ISO_CODE, view.getIsoCode());
		Assert.assertEquals(NAME, view.getName());
		Assert.assertEquals(NATIONALITY, view.getNationality());
		Assert.assertEquals(CURRENCY_CODE, view.getCurrencyCode());
	}
}
