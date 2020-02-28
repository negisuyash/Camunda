package org.boa.visaprocess.delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;



@Component("readApplicationNo")
public class VisaApplicationDelegate implements JavaDelegate{
	
	private Logger logger = Logger.getLogger(VisaApplicationDelegate.class.getName());
	
	@Override
	public void execute(DelegateExecution execution) throws Exception{
		logger.info("Application Number :"+ execution.getVariable("ApplicationNo"));
	}

}
