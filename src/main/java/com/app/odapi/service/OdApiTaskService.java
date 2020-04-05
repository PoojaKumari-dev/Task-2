package com.app.odapi.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.odapi.model.AirportsRequest;
import com.app.odapi.model.AirportsResponse;
import com.app.odapi.model.CountriesRequest;
import com.app.odapi.model.CountriesRequestData;
import com.app.odapi.model.CountriesResponse;
import com.app.odapi.model.DestinationProperties;
import com.app.odapi.model.OdApiResponse;
import com.app.odapi.model.OriginsRequest;
import com.app.odapi.model.RegionsRequest;
import com.app.odapi.model.RegionsRequestData;
import com.app.odapi.model.RegionsResponse;
import com.app.odapi.model.RoutesRequest;
import com.app.odapi.model.RoutesRequestData;
import com.app.odapi.model.RoutesResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OdApiTaskService {

	@Value("${file.origins:test}")
	private String originsFile;
	@Value("${file.regions:test}")
	private String regionsFile;
	@Value("${file.countries:test}")
	private String countriesFile;
	@Value("${file.routes:test}")
	private String routesFile;

	public OdApiResponse getAllOdApiData() throws JsonParseException, JsonMappingException, IOException {
		  ClassLoader classLoader = new OdApiTaskService().getClass().getClassLoader();
		  ObjectMapper ob = new ObjectMapper();
		  OdApiResponse response = new OdApiResponse();
		  
		  Date date = new Date();
		  SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
		  String stringDate = DateFor.format(date);
           
		  File originsfile = new File(classLoader.getResource(originsFile).getFile());
		  OriginsRequest airportRequest = ob.readValue(originsfile,
		  OriginsRequest.class);
		  
		  File countriesfile = new
		  File(classLoader.getResource(countriesFile).getFile()); CountriesRequest
		  countryRequest = ob.readValue(countriesfile, CountriesRequest.class);
		  
		  File regionsfile = new File(classLoader.getResource(regionsFile).getFile());
		  RegionsRequest regionsRequest = ob.readValue(regionsfile,RegionsRequest.class); 
		 
		  File routesfile = new File(classLoader.getResource(routesFile).getFile());
		  RoutesRequest routesRequest = ob.readValue(routesfile, RoutesRequest.class);

		  HashMap<String, AirportsResponse> OriginResponse = getOriginsData(airportRequest, countryRequest);
		  HashMap<String, CountriesResponse> CountryResponse = getCountryData(countryRequest); 
		  HashMap<String, RegionsResponse> regionsResponse = getRegionsData(regionsRequest); 
		  HashMap<String, RoutesResponse> routesResponse = getRoutesData(routesRequest);
		  
		  response.setAirports(OriginResponse);
		  response.setCountries(CountryResponse);
		  response.setRegions(regionsResponse);
		  response.setRouteSets(routesResponse);
		  response.setSource("New");
		  response.setTimeStamp(stringDate);
		  return response;

	}

	public HashMap<String, AirportsResponse> getOriginsData(OriginsRequest airportRequest, CountriesRequest countryRequest)
			throws JsonParseException, JsonMappingException, IOException {
		AirportsResponse airportResponse = null;
		HashMap<String, AirportsResponse> airportMap = new HashMap<String, AirportsResponse>();
		
		List<AirportsRequest> airportList = airportRequest.getAirports();
		List<CountriesRequestData> countryList = countryRequest.getCountries();

		Map<String, List<String>> metroMap = airportList.stream()
				.filter(airport -> airport.getMetropolitanAreaCode() != null)
				.collect(Collectors.groupingBy(AirportsRequest::getMetropolitanAreaCode,
						Collectors.mapping(AirportsRequest::getIATAAirportCode, Collectors.toList())));

		for (AirportsRequest airport : airportList) {
			airportResponse = new AirportsResponse();
			airportResponse.setCode(airport.getIATAAirportCode().toString());
			airportResponse.setCity(airport.getCityName().toString());
			airportResponse.setName(airport.getIATAAirportName().toString());
			airportResponse.setDefaultDisplayName(airport.getAirportShortDisplayName().toString());
			airportResponse.setStateCode(airport.getStateCode() == null ? "" : airport.getStateCode().toString());
			airportResponse.setCountryCode(airport.getCountryCode2().toString());
			airportResponse.setCountryName(
					countryList.stream().filter(a -> a.getCountryCode2().equalsIgnoreCase(airport.getCountryCode2()))
							.findAny().get().getCountryName().toString());
			airportResponse.setBlueCity(airport.isIsJetBlue());
			airportResponse.setPreClearedStation(airport.isIsPreClearedDestination());
			airportResponse.setParentMACCode(airport.getMetropolitanAreaCode());
			airportResponse.setChildrenMACCodes(null);
			airportResponse.setMACCode(airportResponse.getChildrenMACCodes() == null ? false : true);
			airportResponse.setRegionCodes(
					countryList.stream().filter(a -> a.getCountryCode2().equalsIgnoreCase(airport.getCountryCode2()))
							.findAny().get().getRegionCodes());
			airportMap.put(airportResponse.getCode(), airportResponse);

			if (airport.getMetropolitanAreaCode() != null) {
				airportResponse = new AirportsResponse();
				airportResponse.setCode(airport.getMetropolitanAreaCode());
				airportResponse.setCity(airport.getMetropolitanAreaName());
				airportResponse.setName(airport.getMetropolitanAreaName());
				airportResponse.setDefaultDisplayName(airport.getMetropolitanAreaName());
				airportResponse.setStateCode(airport.getStateCode() == null ? "" : airport.getStateCode().toString());
				airportResponse.setCountryCode(airport.getCountryCode2());
				airportResponse.setCountryName(countryList.stream()
						.filter(a -> a.getCountryCode2().equalsIgnoreCase(airport.getCountryCode2())).findAny().get()
						.getCountryName());
				airportResponse.setBlueCity(airport.isIsJetBlue());
				airportResponse.setPreClearedStation(airport.isIsPreClearedDestination());
				airportResponse.setParentMACCode(null);
				airportResponse.setChildrenMACCodes(metroMap.get(airport.getMetropolitanAreaCode()));
				airportResponse.setMACCode(airportResponse.getChildrenMACCodes() == null ? false : true);
				airportResponse.setRegionCodes(countryList.stream()
						.filter(a -> a.getCountryCode2().equalsIgnoreCase(airport.getCountryCode2())).findAny().get()
						.getRegionCodes());
				airportMap.put(airportResponse.getCode(), airportResponse);
			}

		}

		return airportMap;

	}

	public HashMap<String, CountriesResponse> getCountryData(CountriesRequest countryRequest)
			throws JsonParseException, JsonMappingException, IOException {
		CountriesResponse countriesResponse = null;
		HashMap<String, CountriesResponse> countriesMap = new HashMap<String, CountriesResponse>();
		List<CountriesRequestData> countryList = countryRequest.getCountries();

		for (CountriesRequestData country : countryList) {
			countriesResponse = new CountriesResponse();
			countriesResponse.setCountryCode2(country.getCountryCode2());
			countriesResponse.setCountryName(country.getCountryName());
			countriesResponse.setRegionCodes(country.getRegionCodes());

			countriesMap.put(countriesResponse.getCountryCode2(), countriesResponse);
		}

		return countriesMap;

	}

	public HashMap<String, RegionsResponse> getRegionsData(RegionsRequest regionsRequest) throws JsonParseException, JsonMappingException, IOException {
		RegionsResponse regionsResponse = null;
		HashMap<String, RegionsResponse> regionsMap = new HashMap<String, RegionsResponse>();
		List<RegionsRequestData> regionsList = regionsRequest.getRegions();

		for (RegionsRequestData region : regionsList) {
			regionsResponse = new RegionsResponse();
			regionsResponse.setRegionCode(region.getRegionCode());
			regionsResponse.setRegionName(region.getRegionName());

			regionsMap.put(regionsResponse.getRegionCode(), regionsResponse);
		}

		return regionsMap;

	}

	public HashMap<String, RoutesResponse> getRoutesData(RoutesRequest routesRequest) throws JsonParseException, JsonMappingException, IOException {
		RoutesResponse routesResponse = null;
		HashMap<String, RoutesResponse> routesMap = new HashMap<String, RoutesResponse>();
		List<RoutesRequestData> routesList = routesRequest.getRoutes();
		
		Map<String,DestinationProperties> rmap=new HashMap<String,DestinationProperties>();
		for(RoutesRequestData routeReq:routesList) {
			DestinationProperties dp=new DestinationProperties();
			if(routeReq.isIsInterline())
				dp.setI(1);
			if(routeReq.isIsCodeShare())
				dp.setC(1);
			rmap.put(routeReq.getDestinationAirportCode(),dp);
		}
		
		Map<String, List<String>> destinationCode = routesList.stream()
				.collect(Collectors.groupingBy(RoutesRequestData::getOriginAirportCode,
						Collectors.mapping(RoutesRequestData::getDestinationAirportCode, Collectors.toList())));
		
		for (RoutesRequestData routes : routesList) {
			routesResponse = new RoutesResponse();
			routesResponse.setOriginCode(routes.getOriginAirportCode());
			routesResponse.setDestinationCodes(destinationCode.get(routes.getOriginAirportCode()));
			routesResponse.setDestinationProperties(routesResponse.getDestinationCodes().stream().map(dcode-> rmap.get(dcode)).collect(Collectors.toList()));
			routesMap.put(routesResponse.getOriginCode(), routesResponse);

		}
		return routesMap;

	}

}
