package com.samsung.smartretail.mcd.batch.launcher;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public class InventoryLauncher {

    final Logger logger = LoggerFactory.getLogger(InventoryLauncher.class);


    SimpleDateFormat sdf = null;
    private JobLauncher jobLauncher;

    // Job Instance
    private Job job;
    
    private String dateFormat;

    public void launch() {

	// JobParamters 설정- 주의: JobExecution 설정시 매번 다른 값이 되도록 설정 (예:매번다른날짜)  
	sdf = new SimpleDateFormat(getDateFormat());
	long ct = System.currentTimeMillis();

	logger.debug("====> launch() ::: DateFormat:"+getDateFormat()+" - ct: "+ct);


	JobParametersBuilder pBuilder = new JobParametersBuilder();	
	pBuilder.addString("jobName", "daily1");  
	pBuilder.addDate("date", new Date());
	pBuilder.addLong("time", ct );
	JobParameters jobParameters = pBuilder.toJobParameters();;

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



    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }
    
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

}
