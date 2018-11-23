/**
 * 
 */
package com.belatrixsf.logging;

public enum JobLoggerType {

	MESSAGE(1), ERROR(2), WARNING(3);
	private int id;

	private JobLoggerType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}