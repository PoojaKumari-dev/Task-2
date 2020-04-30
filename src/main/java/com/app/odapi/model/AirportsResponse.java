package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"preClearedStation", "maccode", "blueCity"})
public class AirportsResponse {
	
	@JsonProperty("Code")
	private String code;
	@JsonProperty("City")
	private String city;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("DefaultDisplayName")
	private String defaultDisplayName;
	@JsonProperty("StateCode")
	private String stateCode;
	@JsonProperty("CountryCode")
	private String countryCode;
	@JsonProperty("CountryName")
	private String countryName;
	@JsonProperty("IsBlueCity")
	private boolean isBlueCity;
	@JsonProperty("IsPreClearedStation")
	private boolean isPreClearedStation;
	@JsonProperty("IsMACCode")
	private boolean isMACCode;
	@JsonProperty("ParentMACCode")
	private String parentMACCode;
	@JsonProperty("ChildrenMACCodes")
	private List<String> childrenMACCodes;
	@JsonProperty("RegionCodes")
	private List<String> regionCodes;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}

	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getParentMACCode() {
		return parentMACCode;
	}

	public void setParentMACCode(String parentMACCode) {
		this.parentMACCode = parentMACCode;
	}
	

	public List<String> getChildrenMACCodes() {
		return childrenMACCodes;
	}

	public void setChildrenMACCodes(List<String> childrenMACCodes) {
		this.childrenMACCodes = childrenMACCodes;
	}

	public List<String> getRegionCodes() {
		return regionCodes;
	}

	public void setRegionCodes(List<String> regionCodes) {
		this.regionCodes = regionCodes;
	}

	public boolean isPreClearedStation() {
		return isPreClearedStation;
	}

	public void setPreClearedStation(boolean isPreClearedStation) {
		this.isPreClearedStation = isPreClearedStation;
	}

	public boolean isBlueCity() {
		return isBlueCity;
	}

	public void setBlueCity(boolean isBlueCity) {
		this.isBlueCity = isBlueCity;
	}

	public boolean isMACCode() {
		return isMACCode;
	}

	public void setMACCode(boolean isMACCode) {
		this.isMACCode = isMACCode;
	}

	@Override
	public String toString() {
		return "AirportsResponse [code=" + code + ", city=" + city + ", name=" + name + ", defaultDisplayName="
				+ defaultDisplayName + ", stateCode=" + stateCode + ", countryCode=" + countryCode + ", countryName="
				+ countryName + ", isBlueCity=" + isBlueCity + ", isPreClearedStation=" + isPreClearedStation
				+ ", isMACCode=" + isMACCode + ", parentMACCode=" + parentMACCode + ", childrenMACCodes="
				+ childrenMACCodes + ", regionCodes=" + regionCodes + "]";
	}
	
	

}
