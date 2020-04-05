package com.app.odapi.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OdApiResponse {

	@JsonProperty("Airports")
	private HashMap<String, AirportsResponse> airports;
	@JsonProperty("Countries")
	private HashMap<String, CountriesResponse> countries;
	@JsonProperty("Regions")
	private HashMap<String, RegionsResponse> regions;
	@JsonProperty("RouteSets")
	private HashMap<String, RoutesResponse> routeSets;
	@JsonProperty("Source")
	private String source;
	@JsonProperty("TimeStamp")
	private String timeStamp;
	
	public HashMap<String, AirportsResponse> getAirports() {
		return airports;
	}
	public void setAirports(HashMap<String, AirportsResponse> airports) {
		this.airports = airports;
	}
	public HashMap<String, CountriesResponse> getCountries() {
		return countries;
	}
	public void setCountries(HashMap<String, CountriesResponse> countries) {
		this.countries = countries;
	}
	public HashMap<String, RegionsResponse> getRegions() {
		return regions;
	}
	public void setRegions(HashMap<String, RegionsResponse> regions) {
		this.regions = regions;
	}
	public HashMap<String, RoutesResponse> getRouteSets() {
		return routeSets;
	}
	public void setRouteSets(HashMap<String, RoutesResponse> routeSets) {
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
