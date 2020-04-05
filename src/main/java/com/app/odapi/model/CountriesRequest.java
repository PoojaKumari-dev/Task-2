package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountriesRequest {
	
	@JsonProperty("ResponseStatusCode")
	private String responseStatusCode;
	@JsonProperty("Countries")
	private List<CountriesRequestData> countries;

	public String getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(String responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	public List<CountriesRequestData> getCountries() {
		return countries;
	}

	public void setCountries(List<CountriesRequestData> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "CountriesRequest [responseStatusCode=" + responseStatusCode + ", countries=" + countries + "]";
	}

}
