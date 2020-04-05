package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegionsRequestData {

	@JsonProperty("RegionCode")
	private String regionCode;
	@JsonProperty("RegionName")
	private String regionName;
	@JsonProperty("RegionDescription")
	private String regionDescription;
	@JsonProperty("ActiveFromDate")
	private String activeFromDate;
	@JsonProperty("ActiveToDate")
	private String activeToDate;
	@JsonProperty("CountryCodes")
	private List<String> countryCodes;

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionDescription() {
		return regionDescription;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
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

	public List<String> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<String> countryCodes) {
		this.countryCodes = countryCodes;
	}

	@Override
	public String toString() {
		return "RegionsRequestData [regionCode=" + regionCode + ", regionName=" + regionName + ", regionDescription="
				+ regionDescription + ", activeFromDate=" + activeFromDate + ", activeToDate=" + activeToDate
				+ ", countryCodes=" + countryCodes + "]";
	}
}
