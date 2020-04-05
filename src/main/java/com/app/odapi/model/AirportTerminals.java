package com.app.odapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirportTerminals {
	
	@JsonProperty("AirportTerminal")
	private String AirportTerminal;
	@JsonProperty("IsDomesticInboundTerminal")
	private boolean IsDomesticInboundTerminal;
	@JsonProperty("IsDomesticOutboundTerminal")
	private boolean IsDomesticOutboundTerminal;
	@JsonProperty("IsInternationalInboundTerminal")
	private boolean IsInternationalInboundTerminal;
	@JsonProperty("IsInternationalOutboundTerminal")
	private boolean IsInternationalOutboundTerminal;
	@JsonProperty("AirportTerminalCommentText")
	private String AirportTerminalCommentText;
	@JsonProperty("AirportTerminalStartTime")
	private String AirportTerminalStartTime;
	@JsonProperty("AirportTerminalEndTime")
	private String AirportTerminalEndTime;
	@JsonProperty("AirportTerminalEffectiveDate")
	private String AirportTerminalEffectiveDate;
	@JsonProperty("AirportTerminalEndDate")
	private String AirportTerminalEndDate;

	public String getAirportTerminal() {
		return AirportTerminal;
	}

	public void setAirportTerminal(String airportTerminal) {
		AirportTerminal = airportTerminal;
	}

	public boolean isIsDomesticInboundTerminal() {
		return IsDomesticInboundTerminal;
	}

	public void setIsDomesticInboundTerminal(boolean isDomesticInboundTerminal) {
		IsDomesticInboundTerminal = isDomesticInboundTerminal;
	}

	public boolean isIsDomesticOutboundTerminal() {
		return IsDomesticOutboundTerminal;
	}

	public void setIsDomesticOutboundTerminal(boolean isDomesticOutboundTerminal) {
		IsDomesticOutboundTerminal = isDomesticOutboundTerminal;
	}

	public boolean isIsInternationalInboundTerminal() {
		return IsInternationalInboundTerminal;
	}

	public void setIsInternationalInboundTerminal(boolean isInternationalInboundTerminal) {
		IsInternationalInboundTerminal = isInternationalInboundTerminal;
	}

	public boolean isIsInternationalOutboundTerminal() {
		return IsInternationalOutboundTerminal;
	}

	public void setIsInternationalOutboundTerminal(boolean isInternationalOutboundTerminal) {
		IsInternationalOutboundTerminal = isInternationalOutboundTerminal;
	}

	public String getAirportTerminalCommentText() {
		return AirportTerminalCommentText;
	}

	public void setAirportTerminalCommentText(String airportTerminalCommentText) {
		AirportTerminalCommentText = airportTerminalCommentText;
	}

	public String getAirportTerminalStartTime() {
		return AirportTerminalStartTime;
	}

	public void setAirportTerminalStartTime(String airportTerminalStartTime) {
		AirportTerminalStartTime = airportTerminalStartTime;
	}

	public String getAirportTerminalEndTime() {
		return AirportTerminalEndTime;
	}

	public void setAirportTerminalEndTime(String airportTerminalEndTime) {
		AirportTerminalEndTime = airportTerminalEndTime;
	}

	public String getAirportTerminalEffectiveDate() {
		return AirportTerminalEffectiveDate;
	}

	public void setAirportTerminalEffectiveDate(String airportTerminalEffectiveDate) {
		AirportTerminalEffectiveDate = airportTerminalEffectiveDate;
	}

	public String getAirportTerminalEndDate() {
		return AirportTerminalEndDate;
	}

	public void setAirportTerminalEndDate(String airportTerminalEndDate) {
		AirportTerminalEndDate = airportTerminalEndDate;
	}

	@Override
	public String toString() {
		return "AirportTerminals [AirportTerminal=" + AirportTerminal + ", IsDomesticInboundTerminal="
				+ IsDomesticInboundTerminal + ", IsDomesticOutboundTerminal=" + IsDomesticOutboundTerminal
				+ ", IsInternationalInboundTerminal=" + IsInternationalInboundTerminal
				+ ", IsInternationalOutboundTerminal=" + IsInternationalOutboundTerminal
				+ ", AirportTerminalCommentText=" + AirportTerminalCommentText + ", AirportTerminalStartTime="
				+ AirportTerminalStartTime + ", AirportTerminalEndTime=" + AirportTerminalEndTime
				+ ", AirportTerminalEffectiveDate=" + AirportTerminalEffectiveDate + ", AirportTerminalEndDate="
				+ AirportTerminalEndDate + "]";
	}


}
