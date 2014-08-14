package com.samsung.smartretail.mcd.controller.auth.login;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.samsung.smartretail.mcd.entity.common.ResultResponse;
import com.samsung.smartretail.mcd.entity.common.ResultType;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath:/config/spring/spring-context.xml",
	"classpath:/config/mybatis/mybatis-context.xml"
	})
public class LoginControllerTest {
	
	private static final Log logger = LogFactory.getLog(LoginControllerTest.class);

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        
	}

	@Test
	public void testLogin() {
		
		

		
		logger.debug("로그인 단위 테스트 시작.");
		MvcResult result =null;
		
		try {
			
			result = mockMvc.perform(post("/auth/login").param("userId", "manager@mcd.com").param("password", "manager").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			//.andExpect(model().attributeExists("resultType"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();

		logger.debug("로그인 단위 테스트 수행 성공.");
        
        String content = result.getResponse().getContentAsString();	        
      
	      ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
	      ResultResponse rr = mapper.readValue(content, ResultResponse.class);
	       
	      logger.debug("JSon Result=" + mapper.defaultPrettyPrintingWriter().writeValueAsString(rr));
	       
	      assertEquals(rr.getResultType(), ResultType.SUCCESS);
    	
      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
	}

	
	@Test
	public void testLogout() {
		logger.debug("로그아웃 단위 테스트 시작.");
		MvcResult result =null;
		
		try {
			
			result = mockMvc.perform(post("/auth/logout").param("userId", "manager@mcd.com").param("password", "manager").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			//.andExpect(model().attributeExists("resultType"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json"))
			.andReturn();

		  logger.debug("로그아웃 단위 테스트 수행 성공.");
        
          String content = result.getResponse().getContentAsString();
           
	      ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
	      ResultResponse rr = mapper.readValue(content, ResultResponse.class);
	       
	      logger.debug("JSon Result=" + mapper.defaultPrettyPrintingWriter().writeValueAsString(rr));
	       
	      assertEquals(rr.getResultType(), ResultType.SUCCESS);
    	
      

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	
	@Test
	public void testTimeStamp(){
		
//		Timestamp.valueOf("2009-03-01 10:10:05"); 형태로 집어넣는 겁니다.
//
//		그러기에 이를 쓰기 위한 메소드는 두 줄이면 끝납니다.
//
//		import java.sql.Timestamp;
//
//		public Timestamp getTimestamp(String str){
//		return Timestamp.valueOf(str);
//		}
//
//		위의 문자열 형태는 규칙에 따르면 yyyy-mm-dd hh:mm:ss.fffffffff 형식입니다.
//		위에서 보는 것과 같이 timestamp는 나노 세컨드까지 지원하는 반면,
//		java.sql.date는 밀리 세컨드까지만 지원합니다.
//		
		 Timestamp stamp = new Timestamp(System.currentTimeMillis());
		 SimpleDateFormat dFormat = new SimpleDateFormat ( "dd/MMM" , Locale.ENGLISH);
		 Date dt= new Date(stamp.getTime());
		 
		String date = dFormat.format(dt);
		
		
		String hour = ""+stamp.getHours();
		
		logger.debug("date:::" +date +" - hour:::"+hour);
			
		
	}
}
