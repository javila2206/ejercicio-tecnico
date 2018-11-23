package com.belatrixsf.logging;

import java.sql.Connection;
import java.sql.Statement;

import com.belatrixsf.util.ConfigProperties;
import com.belatrixsf.util.DBManager;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 ...
 * 
 * @author javilach
 * @version 1.0.0
 * @since 1.0.0
 *
 **/
public class DatabaseLogger extends JobLogger {

	public DatabaseLogger() {
		ConfigProperties.init();
	}

	/**
	 * Guarda un mensaje en la tabla Log_Values.
	 * @param messageText
	 * @param t 
	 */
	@Override
	public void logMessage(String messageText, JobLoggerType t) throws Exception {
		if (messageText == null || messageText.trim().length() == 0) {
			return;
		}
		Connection cn = DBManager.getConnection();
		Statement stmt = cn.createStatement();
		messageText = this.getFormattedMessage(messageText, t);
		stmt.executeUpdate("insert into Log_Values(message, message_type) values('" + messageText + "'," + String.valueOf(t.getId()) + ")");
	}

}