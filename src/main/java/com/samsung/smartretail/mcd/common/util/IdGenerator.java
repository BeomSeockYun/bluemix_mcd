package com.samsung.smartretail.mcd.common.util;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.stereotype.Component;

@Component(value="idGenerator")
public class IdGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);
	
    
	public String generateRequestId()   {
    	
		 String requestId = "req-"+UUID.randomUUID().toString();
	
		logger.debug("generateRequestId ::: requestId:"+requestId);
		
		return requestId;
    
	}
	
	public String generateTodoId()   {
    	
		 String toDoId = "todo_"+UUID.randomUUID().toString();
	
		logger.debug("generateTodoId ::: toDoId:"+toDoId);
		
		return toDoId;
   
	}
	
	public String generatePushId()   {
    	
		 String pushId = "push-"+UUID.randomUUID().toString();
	
		logger.debug("generatePushId ::: pushId:"+pushId);
		
		return pushId;
  
	}
	
	
}
