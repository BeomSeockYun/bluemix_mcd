package com.samsung.smartretail.mcd.batch.item.sample;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component(value="writer3")
public class Writer3 implements ItemWriter<Object> {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void write(List<? extends Object> data) throws Exception {
		
		logger.info(">>>>> write3");
	
	}
}