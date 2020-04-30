package com.app.odapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class OdApiResponse {

	@JsonProperty("Airports")
	private Map<String, AirportsResponse> airports;
	@JsonProperty("Countries")
	private Map<String, CountriesResponse> countries;
	@JsonProperty("Regions")
	private Map<String, RegionsResponse> regions;
	@JsonProperty("RouteSets")
	private Map<String, RoutesResponse> routeSets;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("TimeStamp")
	private String timeStamp;
	
	public Map<String, AirportsResponse> getAirports() {
		return airports;
	}
	public void setAirports(Map<String, AirportsResponse> airports) {
		this.airports = airports;
	}
	public Map<String, CountriesResponse> getCountries() {
		return countries;
	}
	public void setCountries(Map<String, CountriesResponse> countries) {
		this.countries = countries;
	}
	public Map<String, RegionsResponse> getRegions() {
		return regions;
	}
	public void setRegions(Map<String, RegionsResponse> regions) {
		this.regions = regions;
	}
	public Map<String, RoutesResponse> getRouteSets() {
		return routeSets;
	}
	public void setRouteSets(Map<String, RoutesResponse> routeSets) {
		this.routeSets = routeSets;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
