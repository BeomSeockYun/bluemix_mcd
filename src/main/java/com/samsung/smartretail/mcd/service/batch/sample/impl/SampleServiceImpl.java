package com.samsung.smartretail.mcd.service.batch.sample.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import com.samsung.smartretail.mcd.dao.batch.sample.SampleMapper;
import com.samsung.smartretail.mcd.service.batch.sample.SampleService;
import com.samsung.smartretail.mcd.vo.batch.sample.MemberVO;


@Service
public class SampleServiceImpl implements SampleService { 
	/* The logger */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SampleMapper sampleMapper;
	
	
	@Override
	public List<MemberVO> list() throws Exception {
		
		List<MemberVO> sampleList = null;
		
		try{
			
		sampleList = sampleMapper.list();

			if (sampleList !=null){
				for (MemberVO sample : sampleList) {
					logger.info("<<<< sample["+sampleList.indexOf(sample)+"]", sample.getMbrId()+" == "+sample.getMbrNm());
				}
			}
			
		}catch(BadSqlGrammarException e1){
			logger.error("++++++++++++error BadSqlGrammarException");
		}catch (Exception e){
			logger.error("++++++++++++error ///"+ e.getMessage());
			
		}
		

		return sampleList;
	}

	@Override
	public int insertList(List<MemberVO> members) throws Exception {
		
		int result= -1;
		try{
			
			result= sampleMapper.insertList(members);
		
		}catch(BadSqlGrammarException e1){
			logger.error("++++++++++++error BadSqlGrammarException");
		}catch (Exception e){
			logger.error("++++++++++++error ///"+ e.getMessage());
			
		}
		
		return result;
	}
	

}