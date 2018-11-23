/**
 * 
 */
package com.belatrixsf.util;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class DBManager {
	
	/**
	 * Obtiene una conexion a base de datos.
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		ConfigProperties properties = ConfigProperties.getInstance();
		Connection connection = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", properties.get("userName"));
		connectionProps.put("password", properties.get("password"));
		try {
			connection = DriverManager.getConnection(properties.get("url"), connectionProps);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
