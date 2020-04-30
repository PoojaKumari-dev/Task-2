package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountriesRequestData {

	@JsonProperty("CountryCode2")
	private String countryCode2;
	@JsonProperty("CountryCode3")
	private String countryCode3;
	@JsonProperty("CountryName")
	private String countryName;
	@JsonProperty("CountryFullName")
	private String countryFullName;
	@JsonProperty("CheckinAllowed")
	private boolean checkinAllowed;
	@JsonProperty("ActiveFromDate")
	private String activeFromDate;
	@JsonProperty("ActiveToDate")
	private String activeToDate;
	@JsonProperty("RegionCodes")
	private List<String> regionCodes;

	public String getCountryCode2() {
		return countryCode2;
	}

	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	public String getCountryCode3() {
		return countryCode3;
	}

	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryFullName() {
		return countryFullName;
	}

	public void setCountryFullName(String countryFullName) {
		this.countryFullName = countryFullName;
	}

	public boolean isCheckinAllowed() {
		return checkinAllowed;
	}

	public void setCheckinAllowed(boolean checkinAllowed) {
		this.checkinAllowed = checkinAllowed;
	}

	public String getActiveFromDate() {
		return activeFromDate;
	}

	public void setActiveFromDate(String activeFromDate) {
		this.activeFromDate = activeFromDate;
	}

	public String getActiveToDate() {
		return activeToDate;
	}

	public void setActiveToDate(String activeToDate) {
		this.activeToDate = activeToDate;
	}

	public List<String> getRegionCodes() {
		return regionCodes;
	}

	public void setRegionCodes(List<String> regionCodes) {
		this.regionCodes = regionCodes;
	}

	@Override
	public String toString() {
		return "CountriesRequestData [countryCode2=" + countryCode2 + ", countryCode3=" + countryCode3
				+ ", countryName=" + countryName + ", countryFullName=" + countryFullName + ", checkinAllowed="
				+ checkinAllowed + ", activeFromDate=" + activeFromDate + ", activeToDate=" + activeToDate
				+ ", regionCodes=" + regionCodes + "]";
	}
}
