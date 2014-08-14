package com.samsung.smartretail.mcd.batch.listener.sample;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class StatusMailJobListener implements JobExecutionListener {
    
   private String recipient;
   private String sender;
   private String successMailPath;
   private String errorMailPath;
   private String subject;
    
   @Autowired
   private JavaMailSenderImpl mailSender;
//   @Autowired
//   private VelocityEngine velocityEngine;

   public void afterJob(JobExecution jobExecution) {
       String exitCode = jobExecution.getExitStatus().getExitCode();
       if (exitCode.equals(ExitStatus.COMPLETED.getExitCode())) {
           sendMail(successMailPath, "[OK] " + subject, jobExecution.getExecutionContext());
       } else {
           sendMail(errorMailPath, "[ERROR] " + subject, jobExecution.getExecutionContext());
       }
   }

   private void sendMail(final String messagePath, final String subject, final ExecutionContext executionContext) {
       MimeMessagePreparator preparator = new MimeMessagePreparator() {
           public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setSubject(subject);
               message.setTo(recipient);
               message.setFrom(sender);
               
               StringBuilder messages = new StringBuilder();
               
               
               Map<String, String> values = (Map<String, String>) executionContext.get("values");
               
               if (executionContext.containsKey("error")) {
                   values.clear();
                   values.put("error", executionContext.getString("error"));
                   
                   messages.append(" "+ executionContext.getString("error"));
               }
               String text = messages.toString();
//                   VelocityEngineUtils.
//                       mergeTemplateIntoString(velocityEngine, messagePath, values);
               message.setText(text, true);
           }
       };
       mailSender.send(preparator);
   }

   public void beforeJob(JobExecution jobExecution) {
       Map<String, String> values = new HashMap<String, String>();
       jobExecution.getExecutionContext().put("values", values);
   }

       //[setters excluded]

}