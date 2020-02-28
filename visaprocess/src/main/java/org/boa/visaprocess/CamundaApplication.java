package org.boa.visaprocess;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.query.PeriodUnit;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.ProcessApplicationStartedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import static org.camunda.bpm.engine.variable.Variables.putValue;

import java.util.Calendar;;

@SpringBootApplication
//@EnableProcessApplication("visaprocess")
public class CamundaApplication {
	
  @Autowired
  private RuntimeService runTimeService;
  
  @Autowired
  private HistoryService historyService;
  
  private static final String PROCESS_DEF_KEY="generateRandom";
  
  public static void main(String... args) {
    SpringApplication.run(CamundaApplication.class, args);
  }
  
  @EventListener
  public void onStart(final ProcessApplicationStartedEvent event)
  {
	  
	  ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
	  
//	  ProcessInstance processInstance = runTimeService.startProcessInstanceByKey(PROCESS_DEF_KEY
//			  ,putValue("email","negisuyash1998@gmail.com"));
	  
	  historyService = processEngine.getHistoryService();
	  System.out.println(historyService.toString());
	  Calendar calendar = Calendar.getInstance();
	  historyService.createHistoricProcessInstanceReport().startedBefore(calendar.getTime()).duration(PeriodUnit.MONTH);
	  System.out.println(processEngine.VERSION);
  }
}
