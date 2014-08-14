package com.samsung.smartretail.mcd.batch.listener.sample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class CleanUpListener implements StepExecutionListener {

		private static final Logger logger = LoggerFactory.getLogger(CleanUpListener.class);

		private String folderToBeDeleted;

		@Override
		public ExitStatus afterStep(StepExecution arg0) {
		    try {
		        logger.debug("Deleting folder: " + folderToBeDeleted + " ...");
		        File file = new File(folderToBeDeleted);
		        logger.debug("folder contains: " + file.listFiles().length);
		        FileUtils.deleteDirectory(file);
		        logger.debug("Deleted folder: " + folderToBeDeleted);
		    } catch (IOException e) {
		        logger.error("Failed to delete folder: " + folderToBeDeleted + " with exception: " + e.toString());
		    }
		    return null;
		}

		@Override
		public void beforeStep(StepExecution arg0) {
		    // TODO Auto-generated method stub

		}

		public String getFolderToBeDeleted() {
		    return folderToBeDeleted;
		}

		public void setFolderToBeDeleted(String folderToBeDeleted) {
		    this.folderToBeDeleted = folderToBeDeleted;
		}
	}