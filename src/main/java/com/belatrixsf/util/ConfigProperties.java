package com.belatrixsf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 ...
 * 
 * @author javilach
 * @version 1.0.0
 * @since 1.0.0
 *
 **/
public class ConfigProperties {

	private Properties properties = null;
	private static ConfigProperties configProperties;

	private ConfigProperties() throws IOException {
		properties = new Properties();
		String resourceName = "config.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		properties = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			properties.load(resourceStream);
		}
	}

	public static void init() {
		try {
			configProperties = new ConfigProperties();
		} catch (IOException ioe) {
			configProperties = null;
			ioe.printStackTrace();
		}
	}

	public static ConfigProperties getInstance() {
		return configProperties;
	}

	public String get(String key) {
		return properties.getProperty(key);
	}
}