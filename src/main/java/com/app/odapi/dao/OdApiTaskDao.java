package com.app.odapi.dao;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.app.odapi.model.CountriesRequest;
import com.app.odapi.model.OriginsRequest;
import com.app.odapi.model.RegionsRequest;
import com.app.odapi.model.RoutesRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OdApiTaskDao {

	@Value("${file.origins:test}")
	private String originsFile;
	@Value("${file.regions:test}")
	private String regionsFile;
	@Value("${file.countries:test}")
	private String countriesFile;
	@Value("${file.routes:test}")
	private String routesFile;

	ObjectMapper ob = new ObjectMapper();
	ClassLoader classLoader = OdApiTaskDao.class.getClassLoader();
	URL url = null;

	public OriginsRequest ReadOriginFile() throws JsonParseException, JsonMappingException, IOException {
		url = classLoader.getResource(originsFile);
		OriginsRequest airportRequest = ob.readValue(new FileReader(url.getPath()), OriginsRequest.class);
		return airportRequest;

	}

	public CountriesRequest ReadCountryFile() throws JsonParseException, JsonMappingException, IOException {
		url = classLoader.getResource(countriesFile);
		CountriesRequest countryRequest = ob.readValue(new FileReader(url.getPath()), CountriesRequest.class);
		return countryRequest;

	}
	
	public RegionsRequest ReadRegionsFile() throws JsonParseException, JsonMappingException, IOException {
		url = classLoader.getResource(regionsFile);
		RegionsRequest regionsRequest = ob.readValue(new FileReader(url.getPath()), RegionsRequest.class);
		return regionsRequest;

	}
	
	public RoutesRequest ReadRoutesFile() throws JsonParseException, JsonMappingException, IOException {
		url = classLoader.getResource(routesFile);
		RoutesRequest routesRequest = ob.readValue(new FileReader(url.getPath()), RoutesRequest.class);
		return routesRequest;

	}

}
