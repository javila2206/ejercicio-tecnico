package com.belatrixsf.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 ...
 * 
 * @author javilach
 * @version 1.0.0
 * @since 1.0.0
 *
 **/
public class ConsoleLogger extends JobLogger {
	protected static Logger logger;

	public ConsoleLogger() {
		logger = Logger.getLogger("MyLog");
	}

	/**
	 * Escribe un mensaje en la consola de Java.
	 * @param messageText
	 * @param t 
	 */
	@Override
	public void logMessage(String messageText, JobLoggerType t) throws Exception {
		if (messageText == null || messageText.trim().length() == 0) {
			return;
		}
		ConsoleHandler ch = new ConsoleHandler();
		logger.addHandler(ch);
		messageText = this.getFormattedMessage(messageText, t);
		logger.log(Level.INFO, messageText);
	}

}
