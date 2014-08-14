/**
 * 
 */
package com.samsung.smartretail.mcd.service.push.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.samsung.smartretail.mcd.service.push.GcmPushService;

/**
 * @author SDS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath:test-context.xml",
	})
public class GcmPushServiceImplTest {
	
	
	private static final Logger logger = LoggerFactory.getLogger(GcmPushServiceImplTest.class);
	
	@Autowired 
	GcmPushService gcmPushService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 
	 *  현재는 방화벽 안쪽이라 Proxy세팅을 해서 작동되고 있음
	 * */	
	@Test
	public void testSendPushMessage() {
		
		String title ="testAlarm2"; 
		String content ="Retail Shortage Alarm112 ";
		String id="1";
		String userId="manager@mcd.com";
		
		
		Boolean result = false;
		
		try {
			result = 	gcmPushService.sendPushMessage(id,title, content, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, result);
	
	}

	
	/**
	 * 
	 *  <<주의!>> 현재는 방화벽 안쪽이라 Proxy세팅이 안되서 작동하지 않음
	 * */
	@Test
	public void testSendPushSrvMessage() {
		
		String title ="testAlarm"; 
		String content ="Retail Shortage Alarm ";
		
		String userId="manager@mcd.com";
		
		
		Boolean result = false;
		
		try {
			result = 	gcmPushService.sendPushSrvMessage(title, content, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, result);
	
	}
	
}
