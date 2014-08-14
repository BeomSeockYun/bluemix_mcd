package com.samsung.smartretail.mcd.batch.launcher.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public class MyLauncher {
	
	final Logger logger = LoggerFactory.getLogger(MyLauncher.class);
	
	
	SimpleDateFormat sdf = null;

	
	private JobLauncher jobLauncher;

	 // Job Instance
	private Job job;

	private String dateFormat;


	private Date targetDate;


	private String retryYn;
	  


	public void launch() {
		  
		// JobParamters 설정- 주의: JobExecution 설정시 매번 다른 값이 되도록 설정 (예:매번다른날짜)  
		
		sdf = new SimpleDateFormat(getDateFormat());
		
		String bd= sdf.format(getTargetDate());
		
		long ct = System.currentTimeMillis();
		
		logger.debug("====> launch() ::: DateFormat:"+getDateFormat()+" - targetDate: "+bd+" - ct: "+ct+" - retryYn: "+getRetryYn());

		
		JobParametersBuilder pBuilder = new JobParametersBuilder();	
		pBuilder.addString("jobName", getJob().getName());  
		pBuilder.addDate("date", new Date());
		pBuilder.addLong("time", ct );
		pBuilder.addString("targetDate", bd);               
		pBuilder.addString("retryYn", getRetryYn());  
		JobParameters jobParameters = pBuilder.toJobParameters();

	    try {
	    	
		/** JobExecution 설정 

		* getStatus():	실행상태를 의미.
		* 실행중(BatchStatus.STARTED), 실패(BatchStatus.FAILED),	성공(BatchStatus.COMPLETED)
		* getStartTime():	실행이 시작되는 당시 시스템 시간을 Java.util.Date 로 저장 
		* getEndTime():	실행의 성공 여부에 관계 없이 실행이 끝나는 당시 시스템 시간을 Java.uitl.Date로 저장.
		* getExitStatus():	실행의 결과를 ExitStatus로 알림. 호출자에게 반환될 종료 코드를 포함하기 때문에 중요.
		* getCreateTime():	JobExecution이 처음으로 DB에 등록된 시스템시간
		*/	    	
	      JobExecution execution = jobLauncher.run(job, jobParameters);
	      logger.debug("=====> Exit Status : " + execution.getStatus());
	    } catch (Exception e) {

	    	e.printStackTrace();
		      
	    	logger.debug("=====> Unable to execute job");

	    }
	  }

	  public JobLauncher getJobLauncher() {
	    return jobLauncher;
	  }

	  public void setJobLauncher(JobLauncher jobLauncher) {
	    this.jobLauncher = jobLauncher;
	  }

	  // Job Instance 세팅
	  public Job getJob() {
	    return job;
	  }

	  public void setJob(Job job) {
	    this.job = job;
	  }	
	



	  public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getRetryYn() {
		return retryYn;
	}

	public void setRetryYn(String retryYn) {
		this.retryYn = retryYn;
	}
}
