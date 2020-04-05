package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirportsRequest {
	
	@JsonProperty("IATAAirportCode")
	private String IATAAirportCode;
	@JsonProperty("IATAAirportName")
	private String IATAAirportName;
	@JsonProperty("ICAOAirportCode")
	private String ICAOAirportCode;
	@JsonProperty("ICAOAirportName")
	private String ICAOAirportName;
	@JsonProperty("WSILocationCode")
	private String WSILocationCode;
	@JsonProperty("MetropolitanAreaCode")
	private String MetropolitanAreaCode;
	@JsonProperty("MetropolitanAreaName")
	private String MetropolitanAreaName;
	@JsonProperty("AirportShortDisplayName")
	private String AirportShortDisplayName;
	@JsonProperty("AirportLongDisplayName")
	private String AirportLongDisplayName;
	@JsonProperty("AirportTypeCode")
	private String AirportTypeCode;
	@JsonProperty("AirportTypeName")
	private String AirportTypeName;
	@JsonProperty("AirportTypeDesc")
	private String AirportTypeDesc;
	@JsonProperty("TravelStartDate")
	private String TravelStartDate;
	@JsonProperty("BookingStartDate")
	private String BookingStartDate;
	@JsonProperty("IsActive")
	private boolean IsActive;
	@JsonProperty("IsJetBlue")
	private boolean IsJetBlue;
	@JsonProperty("IsInterline")
	private boolean IsInterline;
	@JsonProperty("IsCodeShare")
	private boolean IsCodeShare;
	@JsonProperty("IsPreClearedDestination")
	private boolean IsPreClearedDestination;
	@JsonProperty("Latitude")
	private String Latitude;
	@JsonProperty("Longitude")
	private String Longitude;
	@JsonProperty("CityCode")
	private String CityCode;
	@JsonProperty("CityName")
	private String CityName;
	@JsonProperty("CityDescription")
	private String CityDescription;
	@JsonProperty("StateCode")
	private String StateCode;
	@JsonProperty("StateName")
	private String StateName;
	@JsonProperty("StateDescription")
	private String StateDescription;
	@JsonProperty("CountryCode2")
	private String CountryCode2;
	@JsonProperty("TimezoneCode")
	private String TimezoneCode;
	@JsonProperty("TimezoneName")
	private String TimezoneName;
	@JsonProperty("StandardTimezoneVariance")
	private String StandardTimezoneVariance;
	@JsonProperty("DSTTimezoneVariance")
	private String DSTTimezoneVariance;
	@JsonProperty("DSTStartDate")
	private String DSTStartDate;
	@JsonProperty("DSTEndDate")
	private String DSTEndDate;
	@JsonProperty("AirportTerminals")
	private List<AirportTerminals> AirportTerminals;

	public String getIATAAirportCode() {
		return IATAAirportCode;
	}

	public void setIATAAirportCode(String iATAAirportCode) {
		IATAAirportCode = iATAAirportCode;
	}

	public String getIATAAirportName() {
		return IATAAirportName;
	}

	public void setIATAAirportName(String iATAAirportName) {
		IATAAirportName = iATAAirportName;
	}

	public String getICAOAirportCode() {
		return ICAOAirportCode;
	}

	public void setICAOAirportCode(String iCAOAirportCode) {
		ICAOAirportCode = iCAOAirportCode;
	}

	public String getICAOAirportName() {
		return ICAOAirportName;
	}

	public void setICAOAirportName(String iCAOAirportName) {
		ICAOAirportName = iCAOAirportName;
	}

	public String getWSILocationCode() {
		return WSILocationCode;
	}

	public void setWSILocationCode(String wSILocationCode) {
		WSILocationCode = wSILocationCode;
	}

	public String getMetropolitanAreaCode() {
		return MetropolitanAreaCode;
	}

	public void setMetropolitanAreaCode(String metropolitanAreaCode) {
		MetropolitanAreaCode = metropolitanAreaCode;
	}

	public String getMetropolitanAreaName() {
		return MetropolitanAreaName;
	}

	public void setMetropolitanAreaName(String metropolitanAreaName) {
		MetropolitanAreaName = metropolitanAreaName;
	}

	public String getAirportShortDisplayName() {
		return AirportShortDisplayName;
	}

	public void setAirportShortDisplayName(String airportShortDisplayName) {
		AirportShortDisplayName = airportShortDisplayName;
	}

	public String getAirportLongDisplayName() {
		return AirportLongDisplayName;
	}

	public void setAirportLongDisplayName(String airportLongDisplayName) {
		AirportLongDisplayName = airportLongDisplayName;
	}

	public String getAirportTypeCode() {
		return AirportTypeCode;
	}

	public void setAirportTypeCode(String airportTypeCode) {
		AirportTypeCode = airportTypeCode;
	}

	public String getAirportTypeName() {
		return AirportTypeName;
	}

	public void setAirportTypeName(String airportTypeName) {
		AirportTypeName = airportTypeName;
	}

	public String getAirportTypeDesc() {
		return AirportTypeDesc;
	}

	public void setAirportTypeDesc(String airportTypeDesc) {
		AirportTypeDesc = airportTypeDesc;
	}

	public String getTravelStartDate() {
		return TravelStartDate;
	}

	public void setTravelStartDate(String travelStartDate) {
		TravelStartDate = travelStartDate;
	}

	public String getBookingStartDate() {
		return BookingStartDate;
	}

	public void setBookingStartDate(String bookingStartDate) {
		BookingStartDate = bookingStartDate;
	}

	public boolean isIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}

	public boolean isIsJetBlue() {
		return IsJetBlue;
	}

	public void setIsJetBlue(boolean isJetBlue) {
		IsJetBlue = isJetBlue;
	}

	public boolean isIsInterline() {
		return IsInterline;
	}

	public void setIsInterline(boolean isInterline) {
		IsInterline = isInterline;
	}

	public boolean isIsCodeShare() {
		return IsCodeShare;
	}

	public void setIsCodeShare(boolean isCodeShare) {
		IsCodeShare = isCodeShare;
	}

	public boolean isIsPreClearedDestination() {
		return IsPreClearedDestination;
	}

	public void setIsPreClearedDestination(boolean isPreClearedDestination) {
		IsPreClearedDestination = isPreClearedDestination;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getCityCode() {
		return CityCode;
	}

	public void setCityCode(String cityCode) {
		CityCode = cityCode;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getCityDescription() {
		return CityDescription;
	}

	public void setCityDescription(String cityDescription) {
		CityDescription = cityDescription;
	}

	public String getStateCode() {
		return StateCode;
	}

	public void setStateCode(String stateCode) {
		StateCode = stateCode;
	}

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public String getStateDescription() {
		return StateDescription;
	}

	public void setStateDescription(String stateDescription) {
		StateDescription = stateDescription;
	}

	public String getCountryCode2() {
		return CountryCode2;
	}

	public void setCountryCode2(String countryCode2) {
		CountryCode2 = countryCode2;
	}

	public String getTimezoneCode() {
		return TimezoneCode;
	}

	public void setTimezoneCode(String timezoneCode) {
		TimezoneCode = timezoneCode;
	}

	public String getTimezoneName() {
		return TimezoneName;
	}

	public void setTimezoneName(String timezoneName) {
		TimezoneName = timezoneName;
	}

	public String getStandardTimezoneVariance() {
		return StandardTimezoneVariance;
	}

	public void setStandardTimezoneVariance(String standardTimezoneVariance) {
		StandardTimezoneVariance = standardTimezoneVariance;
	}

	public String getDSTTimezoneVariance() {
		return DSTTimezoneVariance;
	}

	public void setDSTTimezoneVariance(String dSTTimezoneVariance) {
		DSTTimezoneVariance = dSTTimezoneVariance;
	}

	public String getDSTStartDate() {
		return DSTStartDate;
	}

	public void setDSTStartDate(String dSTStartDate) {
		DSTStartDate = dSTStartDate;
	}

	public String getDSTEndDate() {
		return DSTEndDate;
	}

	public void setDSTEndDate(String dSTEndDate) {
		DSTEndDate = dSTEndDate;
	}

	public List<AirportTerminals> getAirportTerminals() {
		return AirportTerminals;
	}

	public void setAirportTerminals(List<AirportTerminals> airportTerminals) {
		AirportTerminals = airportTerminals;
	}

	

	@Override
	public String toString() {
		return "Airports [IATAAirportCode=" + IATAAirportCode
				+ ", IATAAirportName=" + IATAAirportName + ", ICAOAirportCode=" + ICAOAirportCode + ", ICAOAirportName="
				+ ICAOAirportName + ", WSILocationCode=" + WSILocationCode + ", MetropolitanAreaCode="
				+ MetropolitanAreaCode + ", MetropolitanAreaName=" + MetropolitanAreaName + ", AirportShortDisplayName="
				+ AirportShortDisplayName + ", AirportLongDisplayName=" + AirportLongDisplayName + ", AirportTypeCode="
				+ AirportTypeCode + ", AirportTypeName=" + AirportTypeName + ", AirportTypeDesc=" + AirportTypeDesc
				+ ", TravelStartDate=" + TravelStartDate + ", BookingStartDate=" + BookingStartDate + ", IsActive="
				+ IsActive + ", IsJetBlue=" + IsJetBlue + ", IsInterline=" + IsInterline + ", IsCodeShare="
				+ IsCodeShare + ", IsPreClearedDestination=" + IsPreClearedDestination + ", Latitude=" + Latitude
				+ ", Longitude=" + Longitude + ", CityCode=" + CityCode + ", CityName=" + CityName
				+ ", CityDescription=" + CityDescription + ", StateCode=" + StateCode + ", StateName=" + StateName
				+ ", StateDescription=" + StateDescription + ", CountryCode2=" + CountryCode2 + ", TimezoneCode="
				+ TimezoneCode + ", TimezoneName=" + TimezoneName + ", StandardTimezoneVariance="
				+ StandardTimezoneVariance + ", DSTTimezoneVariance=" + DSTTimezoneVariance + ", DSTStartDate="
				+ DSTStartDate + ", DSTEndDate=" + DSTEndDate + ", AirportTerminals=" + AirportTerminals + "]";
	}


}
