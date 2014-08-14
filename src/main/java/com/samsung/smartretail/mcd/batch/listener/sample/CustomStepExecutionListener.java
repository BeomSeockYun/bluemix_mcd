package com.samsung.smartretail.mcd.batch.listener.sample;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;


@Component("customStepExecutionListener")
public class CustomStepExecutionListener implements StepExecutionListener{
	

	private static final Logger logger = LoggerFactory.getLogger(CleanUpListener.class);
	 private Long jobId;
	 private Date runDate;
	 private Date startTime;
	 


	private StepExecution stepExecution;

	
//	stepExecution.getExecutionContext().put(ValidationJobMapKey.FAILED_ACCOUNTS.name(), failedItems);
//	jobExecution.getExecutionContext().put(ValidationJobMapKey.JOB_INFO.name(), info);
//
//	 

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		
		
		String exitCode = stepExecution.getExitStatus().getExitCode();
		
		logger.debug(">>>> exitCode:: " +exitCode);
		
		if (exitCode.equals(ExitStatus.FAILED.getExitCode())) {
        	
            StringBuilder messages = new StringBuilder();
            
            for (Throwable error : stepExecution.getFailureExceptions()) {
            	
                messages.append(error.getMessage());
            }
            stepExecution.getJobExecution().getExecutionContext().put("error", messages.toString());
            
            logger.debug(">>>> exitCode:: error:: " +messages.toString());
    		
            return stepExecution.getExitStatus();
        }
        
        return ExitStatus.COMPLETED;
        
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		
		this.stepExecution = stepExecution;
		
        Long jobExecutionId =stepExecution.getJobExecutionId();
        
        //Spring allocates job ids. so get it.
		 jobId = stepExecution.getJobExecution().getJobId();
        String jobName=stepExecution.getJobExecution().getJobInstance().getJobName();

		stepExecution.getExecutionContext().put("jobId", jobId);
        stepExecution.getExecutionContext().put("jobExecutionId", jobExecutionId);
        stepExecution.getExecutionContext().put("stepExecutionId", stepExecution.getId());
        stepExecution.getExecutionContext().put("jobName", jobName);
	        
        
		
	}
	
	
	 public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public StepExecution getStepExecution() {
		return stepExecution;
	}

	public void setStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}
}
