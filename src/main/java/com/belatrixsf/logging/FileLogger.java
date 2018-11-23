package com.belatrixsf.logging;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrixsf.util.ConfigProperties;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 ...
 * 
 * @author javilach
 * @version 1.0.0
 * @since 1.0.0
 *
 **/
public class FileLogger extends JobLogger {
	protected static Logger logger;

	public FileLogger() {
		logger = Logger.getLogger("MyLog");
		ConfigProperties.init();
	}

	/**
	 * Escribe un mensaje en un archivo logFile.txt.
	 * @param messageText
	 * @param t 
	 */
	@Override
	public void logMessage(String messageText, JobLoggerType t) throws Exception {
		// TODO Auto-generated method stub
		if (messageText == null || messageText.trim().length() == 0) {
			return;
		}
		ConfigProperties properties = ConfigProperties.getInstance();
		File logFile = new File(properties.get("logFileFolder").concat("/logFile.txt"));

		if (!logFile.exists()) {
			logFile.createNewFile();
		}
		FileHandler fh = new FileHandler(properties.get("logFileFolder").concat("/logFile.txt"), true);
		logger.addHandler(fh);
		messageText = this.getFormattedMessage(messageText, t);
		logger.log(Level.INFO, messageText);
	}

}
