package com.samsung.smartretail.mcd.batch.item.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samsung.smartretail.mcd.service.batch.sample.SampleService;
import com.samsung.smartretail.mcd.vo.batch.sample.MemberVO;


@Component(value="writer2")
public class Writer2 implements ItemWriter<MemberVO> {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SampleService sampleService;
	
	
	@SuppressWarnings("unchecked")
	public void write(List<? extends MemberVO> data) throws Exception {
		
		logger.info(">>>>> write2");

		int result = -1;
		
		try{
			List<MemberVO> members=(List<MemberVO>)data;
			
			for (MemberVO m: members){

				logger.info(">>>>> write2  >> Member:"+ m.getMbrId()+" - "+ m.getMbrNm());
			}
        result = sampleService.insertList(members);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		logger.info(">>>>> write2  >> result:"+result);
        
	}
	


}
