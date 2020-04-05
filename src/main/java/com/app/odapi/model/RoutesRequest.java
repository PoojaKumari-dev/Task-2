package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutesRequest {

	@JsonProperty("ResponseStatusCode")
	private String responseStatusCode;
	@JsonProperty("Routes")
	private List<RoutesRequestData> routes;

	public String getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(String responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	public List<RoutesRequestData> getRoutes() {
		return routes;
	}

	public void setRoutes(List<RoutesRequestData> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "RoutesRequest [responseStatusCode=" + responseStatusCode + ", routes=" + routes + "]";
	}

}
