package com.samsung.smartretail.mcd.batch.launcher.sample;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"classpath:test-context.xml",
	"classpath:batch-test-config.xml"
	})
public class MyLauncherTest1 {

	private static final Logger log = LoggerFactory.getLogger(MyLauncherTest1.class);
	
	private String dateFormat="yyyyMMdd";
	
	
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils1;
    
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils2;

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils3;
    
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBatchDaily1() {

		long ct = System.currentTimeMillis();		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		String bd= sdf.format(new Date());
		String jobName ="daily1";
		
		
		JobParametersBuilder pBuilder = new JobParametersBuilder();	
		pBuilder.addString("jobName", jobName);  
		pBuilder.addDate("date", new Date());
		pBuilder.addLong("time", ct );
		pBuilder.addString("targetDate", bd);               
		pBuilder.addString("retryYn", "n");  
		JobParameters jobParameters = pBuilder.toJobParameters();
				
		JobExecution jobExecution =null;
		
		try {
			
			jobExecution = jobLauncherTestUtils1.launchJob(jobParameters);
			
			log.debug("daily1 jobExecution.getStatus(): " + jobExecution.getStatus());
	    	
			Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Test
	public void testBatchReportJob() {

		long ct = System.currentTimeMillis();		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		String bd= sdf.format(new Date());
		String jobName ="reportJob";
		
		
		JobParametersBuilder pBuilder = new JobParametersBuilder();	
		pBuilder.addString("jobName", jobName);  
		pBuilder.addDate("date", new Date());
		pBuilder.addLong("time", ct );
		pBuilder.addString("targetDate", bd);               
		pBuilder.addString("retryYn", "n");  
		JobParameters jobParameters = pBuilder.toJobParameters();
				
		JobExecution jobExecution =null;
		
		try {
			
			jobExecution = jobLauncherTestUtils2.launchJob(jobParameters);
			
			log.debug("reportJob jobExecution.getStatus(): " + jobExecution.getStatus());
	    	
			Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void testBatchHourly1() {

		long ct = System.currentTimeMillis();		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		
		String bd= sdf.format(new Date());
		String jobName ="hourly1";
		
		
		JobParametersBuilder pBuilder = new JobParametersBuilder();	
		pBuilder.addString("jobName", jobName);  
		pBuilder.addDate("date", new Date());
		pBuilder.addLong("time", ct );
		pBuilder.addString("targetDate", bd);               
		pBuilder.addString("retryYn", "n");  
		JobParameters jobParameters = pBuilder.toJobParameters();
				
		JobExecution jobExecution =null;
		
		try {
			
			jobExecution = jobLauncherTestUtils3.launchJob(jobParameters);
			
			log.debug("hourly1 jobExecution.getStatus(): " + jobExecution.getStatus());
	    	
			Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}	
	
}
