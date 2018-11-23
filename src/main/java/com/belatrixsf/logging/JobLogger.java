package com.belatrixsf.logging;

import java.text.DateFormat;
import java.util.Date;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 ...
 * 
 * @author javilach
 * @version 1.0.0
 * @since 1.0.0
 *
 **/
public abstract class JobLogger {

	/**
	 * Retorna el mensaje formateado: tipo + fecha + mensajeText
	 * @param messageText
	 * @param t
	 * @return
	 */
	protected String getFormattedMessage(String messageText, JobLoggerType t) {
		String l = t.name().toLowerCase().concat(" ").concat(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())).concat(" ").concat(messageText);
		return l;
	}

	public abstract void logMessage(String messageText, JobLoggerType t) throws Exception;
}