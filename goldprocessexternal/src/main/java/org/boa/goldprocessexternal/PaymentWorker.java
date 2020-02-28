package org.boa.goldprocessexternal;

import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.client.ExternalTaskClient;

public class PaymentWorker {
	private final static Logger LOGGER = Logger.getLogger(OffPeakRateWorker.class.getName());

	  public static void main(String[] args) {
		  
	    ExternalTaskClient client = ExternalTaskClient.create()
	        .baseUrl("http://localhost:7070/rest")
	        .asyncResponseTimeout(10000) // long polling timeout
	        .build();

	    // subscribe to an external task topic as specified in the process
	    client.subscribe("PaymentWorker")
	        .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
	        .handler((externalTask, externalTaskService) -> {
	          // Put your business logic here
	        	System.out.println("IN PAYMENT GATEWAY!!!!!!!!!!!!");
//	    		execution.setVariable("paymentStatus", true);
//	    		System.out.println(execution.getVariable("paymentStatus"));
	        
	        	Map<String,Object> variables= externalTask.getAllVariables();
	        	
	        	variables.put("paymentStatus",true);

	          // Complete the task
	          externalTaskService.complete(externalTask,variables);
	        })
	        .open();
	  }

}
