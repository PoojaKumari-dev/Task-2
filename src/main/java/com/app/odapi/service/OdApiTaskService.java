package com.app.odapi.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.odapi.dao.OdApiTaskDao;
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

@Service
public class OdApiTaskService {

	@Autowired
	OdApiTaskDao odApiTaskDao;

	public OdApiResponse getAllOdApiData() throws JsonParseException, JsonMappingException, IOException {
		OdApiResponse response = new OdApiResponse();
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
		String stringDate = DateFor.format(date);

		Map<String, AirportsResponse> OriginResponse = getOriginsData();
		Map<String, CountriesResponse> CountryResponse = getCountryData();
		Map<String, RegionsResponse> regionsResponse = getRegionsData();
		Map<String, RoutesResponse> routesResponse = getRoutesData();

		response.setAirports(OriginResponse);
		response.setAirports(OriginResponse);
		response.setCountries(CountryResponse);
		response.setRegions(regionsResponse);
		response.setRouteSets(routesResponse);
		response.setSource("New");
		response.setTimeStamp(stringDate);

		return response;

	}

	public Map<String, AirportsResponse> getOriginsData() throws JsonParseException, JsonMappingException, IOException {
		AirportsResponse airportResponse = null;
		HashMap<String, AirportsResponse> airportMap = new HashMap<String, AirportsResponse>();
		OriginsRequest airportRequest = new OriginsRequest();
		CountriesRequest countryRequest = new CountriesRequest();
		airportRequest = odApiTaskDao.ReadOriginFile();
		countryRequest = odApiTaskDao.ReadCountryFile();

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

	public Map<String, CountriesResponse> getCountryData()
			throws JsonParseException, JsonMappingException, IOException {
		CountriesResponse countriesResponse = null;
		HashMap<String, CountriesResponse> countriesMap = new HashMap<String, CountriesResponse>();
		CountriesRequest countryRequest = new CountriesRequest();
		countryRequest = odApiTaskDao.ReadCountryFile();

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

	public Map<String, RegionsResponse> getRegionsData() throws JsonParseException, JsonMappingException, IOException {
		RegionsResponse regionsResponse = null;
		HashMap<String, RegionsResponse> regionsMap = new HashMap<String, RegionsResponse>();
		RegionsRequest regionsRequest = new RegionsRequest();
		regionsRequest = odApiTaskDao.ReadRegionsFile();
		List<RegionsRequestData> regionsList = regionsRequest.getRegions();

		for (RegionsRequestData region : regionsList) {
			regionsResponse = new RegionsResponse();
			regionsResponse.setRegionCode(region.getRegionCode());
			regionsResponse.setRegionName(region.getRegionName());

			regionsMap.put(regionsResponse.getRegionCode(), regionsResponse);
		}

		return regionsMap;

	}

	public Map<String, RoutesResponse> getRoutesData() throws JsonParseException, JsonMappingException, IOException {
		RoutesResponse routesResponse = null;
		HashMap<String, RoutesResponse> routesMap = new HashMap<String, RoutesResponse>();
		RoutesRequest routesRequest = new RoutesRequest();
		routesRequest = odApiTaskDao.ReadRoutesFile();
		List<RoutesRequestData> routesList = routesRequest.getRoutes();

		Map<String, DestinationProperties> rmap = new HashMap<String, DestinationProperties>();
		for (RoutesRequestData routeReq : routesList) {
			DestinationProperties dp = new DestinationProperties();
			dp.setI(routeReq.isIsInterline() ? 1 : 0);
			dp.setC(routeReq.isIsCodeShare() ? 1 : 0);
			rmap.put(routeReq.getDestinationAirportCode(), dp);
		}

		Map<String, List<String>> destinationCode = routesList.stream()
				.collect(Collectors.groupingBy(RoutesRequestData::getOriginAirportCode,
						Collectors.mapping(RoutesRequestData::getDestinationAirportCode, Collectors.toList())));

		for (RoutesRequestData routes : routesList) {
			routesResponse = new RoutesResponse();
			routesResponse.setOriginCode(routes.getOriginAirportCode());
			routesResponse.setDestinationCodes(destinationCode.get(routes.getOriginAirportCode()));
			routesResponse.setDestinationProperties(routesResponse.getDestinationCodes().stream()
					.map(dcode -> rmap.get(dcode)).collect(Collectors.toList()));
			routesMap.put(routesResponse.getOriginCode(), routesResponse);

		}
		return routesMap;

	}

}
