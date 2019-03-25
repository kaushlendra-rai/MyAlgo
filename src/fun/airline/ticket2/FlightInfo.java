package fun.airline.ticket2;

import java.util.Calendar;

public class FlightInfo {

	private String flightNumber;
	private String sourceLoc;
	private String destinationLoc;
	private Calendar validTill;
	private Calendar flightTime;
	private double flightDuration;
	private String fare;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getSourceLoc() {
		return sourceLoc;
	}
	public void setSourceLoc(String sourceLoc) {
		this.sourceLoc = sourceLoc;
	}
	public String getDestinationLoc() {
		return destinationLoc;
	}
	public void setDestinationLoc(String destinationLoc) {
		this.destinationLoc = destinationLoc;
	}
	public Calendar getValidTill() {
		return validTill;
	}
	public void setValidTill(Calendar validTill) {
		this.validTill = validTill;
	}
	public Calendar getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(Calendar flightTime) {
		this.flightTime = flightTime;
	}
	public double getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(double flightDuration) {
		this.flightDuration = flightDuration;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
}