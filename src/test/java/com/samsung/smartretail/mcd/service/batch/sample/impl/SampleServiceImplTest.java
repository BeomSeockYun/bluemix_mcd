package com.samsung.smartretail.mcd.service.batch.sample.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.samsung.smartretail.mcd.service.batch.sample.SampleService;
import com.samsung.smartretail.mcd.vo.batch.sample.MemberVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath:/test-context.xml"
	})
public class SampleServiceImplTest {
	private static final Log logger = LogFactory.getLog(SampleServiceImplTest.class);

	@Autowired 
	SampleService sampleServiceImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testList() {
		try {
			List <MemberVO> result = sampleServiceImpl.list() ;
			
			Assert.notNull(result);
			
			for (MemberVO m : result){
				
				logger.debug( ">>> " + m.getMbrId()+" - " + m.getMbrNm());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
