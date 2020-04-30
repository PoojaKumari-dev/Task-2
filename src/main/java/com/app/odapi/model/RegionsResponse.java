package com.app.odapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegionsResponse {

	@JsonProperty("Code")
	private String regionCode;
	@JsonProperty("Name")
	private String regionName;

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

	@Override
	public String toString() {
		return "RegionsResponse [regionCode=" + regionCode + ", regionName=" + regionName + "]";
	}
}
