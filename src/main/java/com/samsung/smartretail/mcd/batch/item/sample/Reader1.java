package com.samsung.smartretail.mcd.batch.item.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samsung.smartretail.mcd.service.batch.sample.SampleService;
import com.samsung.smartretail.mcd.vo.batch.sample.MemberVO;



@Component(value="reader1")
public class Reader1 implements ItemReader<String> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	SampleService sampleService;

	private String[] input = { "Hello world!", null };
	private int index = 0;

	public String read() throws Exception {
		logger.debug("read");
		logger.info("<<<< Start Reader1");
		List<MemberVO> list = sampleService.list();
		//sampleService.insert();
		for (MemberVO sample : list) {
			logger.info("sample["+list.indexOf(sample)+"]"+" id: "+sample.getMbrId()+" - name: "+sample.getMbrNm());
		}
		logger.info("<<<< End Reader1");
		
		if (index < input.length) {
			
			logger.info("index : {}", input[index]);
			
			return input[index++];
			
		} else {
			return null;
		}
	}
}
