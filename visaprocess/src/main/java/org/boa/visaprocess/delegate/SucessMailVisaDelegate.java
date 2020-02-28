package org.boa.visaprocess.delegate;



import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.SignalEventReceivedBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("SuccessMailVisaDelegate")
public class SucessMailVisaDelegate implements JavaDelegate{
	
	@Autowired
	RuntimeService runtimeService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("VISA SUCCESSFULLY APPLIED");
//		SignalEventReceivedBuilder signalEventReceivedBuilder= runtimeService.createSignalEvent("flightSignal");
//		signalEventReceivedBuilder.send();
	}

}
