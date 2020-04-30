package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OriginsRequest {

	@JsonProperty("ResponseStatusCode")
	private String responseStatusCode;
	@JsonProperty("Airports")
	private List<AirportsRequest> airports;

	public String getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(String responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}
	
	public List<AirportsRequest> getAirports() {
		return airports;
	}

	public void setAirports(List<AirportsRequest> airports) {
		this.airports = airports;
	}

	@Override
	public String toString() {
		return "OriginsRequest [responseStatusCode=" + responseStatusCode + ", airports=" + airports + "]";
	}
}
