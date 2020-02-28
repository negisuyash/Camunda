package org.boa.visaprocess.model;

import java.time.LocalDate;

public class Flight {
	
	private String fromCity;
	private String toCity;
	private LocalDate dot;
	
	public Flight(String fromCity, String toCity, LocalDate dot) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.dot = dot;
	}
	
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public LocalDate getDot() {
		return dot;
	}
	public void setDot(LocalDate dot) {
		this.dot = dot;
	}
	
	@Override
	public String toString(){
		return "FromCity"+this.fromCity+" TOCITY"+this.toCity+" DOT"+this.dot;
	}

}
