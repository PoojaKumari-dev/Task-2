package com.app.odapi.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.app.odapi.controller.OdApiTaskController;
import com.app.odapi.model.AirportsResponse;
import com.app.odapi.model.CountriesResponse;
import com.app.odapi.model.DestinationProperties;
import com.app.odapi.model.OdApiResponse;
import com.app.odapi.model.RegionsResponse;
import com.app.odapi.model.RoutesResponse;
import com.app.odapi.service.OdApiTaskService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(OdApiTaskController.class)
public class OdApiTaskControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private OdApiTaskService service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testOdApiTask() {
		ObjectMapper mapper = new ObjectMapper();
		OdApiResponse odApiResponse = new OdApiResponse();
		MvcResult mvcResult;
		try {
			odApiResponse.setAirports(getAirPortData());
			odApiResponse.setCountries(getCountryData());
			odApiResponse.setRegions(getRegionsData());
			odApiResponse.setRouteSets(getRoutesData());
			odApiResponse.setSource("New");
			odApiResponse.setTimeStamp("04/09/2020 01:23:36 PM");
			when(service.getAllOdApiData()).thenReturn(odApiResponse);
			mvcResult = mvc.perform(get("/odapiall").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
			OdApiResponse result = mapper.readValue(mvcResult.getResponse().getContentAsString(),
					new TypeReference<OdApiResponse>() {
					});
			assertNotNull(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Map<String, AirportsResponse> getAirPortData() {
		Map<String, AirportsResponse> airPortMap = new HashMap<String, AirportsResponse>();
		List<String> region = new ArrayList<String>();
		region.add("US");
		AirportsResponse airport = new AirportsResponse();
		airport.setCode("JAX");
		airport.setCity("Jacksonville");
		airport.setName("Jacksonville International Apt");
		airport.setDefaultDisplayName("Jacksonville, FL (JAX)");
		airport.setStateCode("FL");
		airport.setCountryCode("US");
		airport.setCountryName("UNITED STATES");
		airport.isBlueCity();
		airport.isPreClearedStation();
		airport.isMACCode();
		airport.setParentMACCode("null");
		airport.setChildrenMACCodes(null);
		airport.setRegionCodes(region);
		airPortMap.put(airport.getCode(), airport);
		return airPortMap;
	}

	public Map<String, CountriesResponse> getCountryData() {
		Map<String, CountriesResponse> countryMap = new HashMap<String, CountriesResponse>();
		List<String> region = new ArrayList<String>();
		region.add("US");
		CountriesResponse country = new CountriesResponse();
		country.setCountryCode2("PR");
		country.setCountryName("PUERTO RICO");
		country.setRegionCodes(region);

		countryMap.put(country.getCountryCode2(), country);
		return countryMap;
	}

	public Map<String, RegionsResponse> getRegionsData() {
		Map<String, RegionsResponse> regionsMap = new HashMap<String, RegionsResponse>();
		RegionsResponse regions = new RegionsResponse();
		regions.setRegionCode("EU");
		regions.setRegionName("Europe");

		regionsMap.put(regions.getRegionCode(), regions);
		return regionsMap;
	}

	public Map<String, RoutesResponse> getRoutesData() {
		Map<String, RoutesResponse> routessMap = new HashMap<String, RoutesResponse>();
		List<String> destinationCodes = new ArrayList<String>();
		destinationCodes.add("BWI");
		List<DestinationProperties> destinationProperties = new ArrayList<DestinationProperties>();
		DestinationProperties destination = new DestinationProperties();
		destination.setI(0);
		destination.setC(1);
		destinationProperties.add(destination);
		RoutesResponse routes = new RoutesResponse();
		routes.setOriginCode("JAX");
		routes.setDestinationCodes(destinationCodes);
		routes.setDestinationProperties(destinationProperties);
		routessMap.put(routes.getOriginCode(), routes);
		return routessMap;
	}

}
