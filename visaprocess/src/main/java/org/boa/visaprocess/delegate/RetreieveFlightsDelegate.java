package org.boa.visaprocess.delegate;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;

import org.boa.visaprocess.model.Flight;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component("retreieveFlightsDelegate")
public class RetreieveFlightsDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String fromCity=execution.getVariable("fromCity").toString();
		String toCity=execution.getVariable("toCity").toString();
		Date date=(Date)execution.getVariable("date");
		LocalDate localDate= Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		List<Flight> filteredFlights=new ArrayList<>();
		
		for(Flight flight:getAvailableFlights()) {
			if(flight.getFromCity().equals(fromCity)
					&&flight.getToCity().equals(toCity)&&flight.getDot().equals(localDate)) {
				filteredFlights.add(flight);
			}
		}
		
		System.out.println("Avialable Flight count"+filteredFlights.size());
		execution.setVariable("availableFlightCount", filteredFlights.size());
	}
	
	private List<Flight> getAvailableFlights(){
		
		List<Flight> flightList=new ArrayList<Flight>();
		for(int i=0;i<10;i++) {
			flightList.add(new Flight("toCity"+new Random().nextInt(1000),"fromCity"+new Random().nextInt(1000)
					,java.time.LocalDate.of(2020, new Random().nextInt(10)+1, new Random().nextInt(29)+1).plusMonths(1)));
			
		}
		flightList.add(new Flight("fromCity","toCity",LocalDate.of(2020, 2, 11)));
		
		return flightList;
	}

}
