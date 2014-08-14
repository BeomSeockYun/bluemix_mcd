package com.samsung.smartretail.mcd.batch.item.sample;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class DummyWriter implements ItemWriter<Object> {


	public void write(List<? extends Object> data) throws Exception {
		
		// No Operation
		
	}
}
