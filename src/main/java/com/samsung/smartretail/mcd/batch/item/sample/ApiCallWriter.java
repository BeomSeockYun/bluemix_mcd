package com.samsung.smartretail.mcd.batch.item.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;



import org.springframework.stereotype.Component;

@Component
public class ApiCallWriter implements ItemWriter<Object> {
	
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void write(List<? extends Object> arg0) throws Exception {

		logger.debug(">>> invoking ... API ");
		
	//	new MyApiClient();
		
		logger.debug(">>> complete ... API ");
		
		
		
	}
	

}
