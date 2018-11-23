package com.belatrixsf.logging;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 ...
 * 
 * @author javilach
 * @version 1.0.0
 * @since 1.0.0
 *
 **/
public final class JobLoggerFactory {

	/**
	 * Crea los objetos de tipo JobLogger, de acuerdo a su tipo.
	 * @param type
	 * @return
	 */
	public static JobLogger getJobLogger(JobLoggerAppender type) {
		if (JobLoggerAppender.CONSOLE.equals(type)) {
			return new ConsoleLogger();
		}
		if (JobLoggerAppender.DATABASE.equals(type)) {
			return new DatabaseLogger();
		}
		return new FileLogger();
	}

}