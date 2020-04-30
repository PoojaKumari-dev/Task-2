package com.app.odapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutesRequestData {

	@JsonProperty("OriginAirportCode")
	private String OriginAirportCode;
	@JsonProperty("DestinationAirportCode")
	private String DestinationAirportCode;
	@JsonProperty("IsActive")
	private boolean IsActive;
	@JsonProperty("IsJetBlue")
	private boolean IsJetBlue;
	@JsonProperty("IsInterline")
	private boolean IsInterline;
	@JsonProperty("IsCodeShare")
	private boolean IsCodeShare;
	@JsonProperty("OperatingCarrierCodes")
	private List<String> OperatingCarrierCodes;
	public String getOriginAirportCode() {
		return OriginAirportCode;
	}
	public void setOriginAirportCode(String originAirportCode) {
		OriginAirportCode = originAirportCode;
	}
	public String getDestinationAirportCode() {
		return DestinationAirportCode;
	}
	public void setDestinationAirportCode(String destinationAirportCode) {
		DestinationAirportCode = destinationAirportCode;
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
	public List<String> getOperatingCarrierCodes() {
		return OperatingCarrierCodes;
	}
	public void setOperatingCarrierCodes(List<String> operatingCarrierCodes) {
		OperatingCarrierCodes = operatingCarrierCodes;
	}
	@Override
	public String toString() {
		return "RoutesRequestData [OriginAirportCode=" + OriginAirportCode + ", DestinationAirportCode="
				+ DestinationAirportCode + ", IsActive=" + IsActive + ", IsJetBlue=" + IsJetBlue + ", IsInterline="
				+ IsInterline + ", IsCodeShare=" + IsCodeShare + ", OperatingCarrierCodes=" + OperatingCarrierCodes
				+ "]";
	}
	
	

	
}
