package org.boa.goldprocessexternal;

import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.client.ExternalTaskClient;


public class OffPeakRateWorker {
	private final static Logger LOGGER = Logger.getLogger(OffPeakRateWorker.class.getName());

	  public static void main(String[] args) {
		  
	    ExternalTaskClient client = ExternalTaskClient.create()
	        .baseUrl("http://localhost:8080/engine-rest")
	        .asyncResponseTimeout(10000) // long polling timeout
	        .build();

	    // subscribe to an external task topic as specified in the process
	    client.subscribe("OffPeakRate")
	        .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
	        .handler((externalTask, externalTaskService) -> {
	          // Put your business logic here
	        
	        	Map<String,Object> variables= externalTask.getAllVariables();
	        	double value=1;
	        	
	        	try {
	        	for(String variablekey: variables.keySet()) {
	        		if(variablekey.equals("goldRate")) {
	        			value = (double)variables.get(variablekey);
	        		}
	        	}
	  
	        	if(value>0) {
	        		System.out.println("HELLLLLLLLLOOOOOOOOOO");
	          LOGGER.info("External task accessing service off peak service task "+value);
	        	}
	        	else
	        		LOGGER.info("External task could not access "+value);
	        	}
	        	catch(NullPointerException e) {
	        		LOGGER.warning(""+e.getStackTrace());
	        	}

	          // Complete the task
	          externalTaskService.complete(externalTask);
	        })
	        .open();
	  }
}

