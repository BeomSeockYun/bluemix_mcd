package com.samsung.smartretail.mcd.batch.item.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samsung.smartretail.mcd.service.batch.sample.SampleService;

@Component(value="writer1")
public class Writer1 implements ItemWriter<Object> {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	SampleService sampleService;

	public void write(List<? extends Object> data) throws Exception {
		logger.info("data:" + data);
		logger.info(">>>> Start Writer1");
		sampleService.list();
		
		// sampleService.insert();
		
		logger.info(">>>> End Writer1");
	}
}
