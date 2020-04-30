package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountriesResponse {

	@JsonProperty("Code")
	private String countryCode2;
	@JsonProperty("Name")
	private String countryName;
	@JsonProperty("RegionCodes")
	private List<String> regionCodes;
	public String getCountryCode2() {
		return countryCode2;
	}
	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<String> getRegionCodes() {
		return regionCodes;
	}
	public void setRegionCodes(List<String> regionCodes) {
		this.regionCodes = regionCodes;
	}
	@Override
	public String toString() {
		return "CountriesResponse [countryCode2=" + countryCode2 + ", countryName=" + countryName + ", regionCodes="
				+ regionCodes + "]";
	}
}
