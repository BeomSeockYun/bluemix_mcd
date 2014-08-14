package com.samsung.smartretail.mcd.batch.item.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component(value="reader3")
public class Reader3 implements ItemReader<String> {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private String[] input = { "Hello world!", null };
	private int index = 0;

	public String read() throws Exception {
		logger.info("<<<< read3");
		
		if (index < input.length) {
			return input[index++];
		} else {
			return null;
		}
	}
}