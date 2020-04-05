package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegionsRequest {

	@JsonProperty("ResponseStatusCode")
	private String responseStatusCode;
	@JsonProperty("Regions")
	private List<RegionsRequestData> regions;

	public String getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(String responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	public List<RegionsRequestData> getRegions() {
		return regions;
	}

	public void setRegions(List<RegionsRequestData> regions) {
		this.regions = regions;
	}

	@Override
	public String toString() {
		return "RegionsRequest [responseStatusCode=" + responseStatusCode + ", regions=" + regions + "]";
	}
}
