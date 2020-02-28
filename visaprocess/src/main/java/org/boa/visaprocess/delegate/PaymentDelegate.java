package org.boa.visaprocess.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("paymentDelegate")
public class PaymentDelegate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		//R4/2020-02-27T10:45:14/PT5M  TIME FORMAT
		
		System.out.println("IN PAYMENT GATEWAY");
		execution.setVariable("paymentStatus", true);
		System.out.println(execution.getVariable("paymentStatus"));
		
		
	}

}
