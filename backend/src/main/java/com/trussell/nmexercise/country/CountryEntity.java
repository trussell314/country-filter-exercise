package com.trussell.nmexercise.country;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryEntity {
	private final String continent;
	private final String alpha2;
	private final String name;
	private final String nationality;
	@JsonProperty("currency_code")
	private final String currencyCode;

	public CountryEntity(String continent, String alpha2, String name, String nationality, String currencyCode) {
		this.continent = continent;
		this.alpha2 = alpha2;
		this.name = name;
		this.nationality = nationality;
		this.currencyCode = currencyCode;
	}

	public String getContinent() {
		return continent;
	}

	public String getAlpha2() {
		return alpha2;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}
}
