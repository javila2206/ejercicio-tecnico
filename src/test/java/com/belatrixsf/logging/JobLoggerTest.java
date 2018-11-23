package com.belatrixsf.logging;

import org.junit.Ignore;
import org.junit.Test;

public class JobLoggerTest {

//	@Ignore
	@Test
	public void logToFile() {
		JobLogger logger =JobLoggerFactory.getJobLogger(JobLoggerAppender.FILE);
		try {
			logger.logMessage("Prueba Message log to file.", JobLoggerType.MESSAGE);
			logger.logMessage("Prueba Warning log to file.", JobLoggerType.WARNING);
			logger.logMessage("Prueba Error log to file.", JobLoggerType.ERROR);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Ignore
	@Test
	public void logToConsole() {
		JobLogger logger =JobLoggerFactory.getJobLogger(JobLoggerAppender.CONSOLE);
		try {
			logger.logMessage("Prueba Message log to console.", JobLoggerType.MESSAGE);
			logger.logMessage("Prueba Warning log to console.", JobLoggerType.WARNING);
			logger.logMessage("Prueba Error log to console.", JobLoggerType.ERROR);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void logToDatabase() {
		JobLogger logger =JobLoggerFactory.getJobLogger(JobLoggerAppender.DATABASE);
		try {
			logger.logMessage("Prueba Message log to console.", JobLoggerType.MESSAGE);
			logger.logMessage("Prueba Warning to console.", JobLoggerType.WARNING);
			logger.logMessage("Prueba Error log to console.", JobLoggerType.ERROR);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
