package com.belatrixsf.util;

import java.sql.*;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.Server;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright (C) 2018 ...
 * 
 * @author javilach
 * @version 1.0.0
 * @since 1.0.0
 *
 **/
public class H2Database {
	private static ConfigProperties properties = null;
	private static final String JDBC_DRIVER = "org.h2.Driver";

	public static void main(String[] args) throws SQLException {
		ConfigProperties.init();
		properties = ConfigProperties.getInstance();
		startServer();
		createTable();
	}

	/**
	 * Inicia el servidor de base de datos embebido.
	 */
	private static void startServer() {
		Server server = null;

		try {
			// create H2 server that supports connections via web page
			// we can also use ("-tcp", "-tcpPort", "9090") to specify a TCP
			// port.
			server = Server.createWebServer("-webAllowOthers", "-browser");
			// server = Server.createWebServer("-web", "-webAllowOthers",
			// "-browser", "-webPort", "8082");
			server.start();

			// create connection pool
			final JdbcConnectionPool cp = JdbcConnectionPool.create(properties.get("url"), properties.get("userName"), properties.get("password"));

			// launch web console
			try {
				new Thread() {
					public void run() {
						Connection conn = null;
						try {
							conn = cp.getConnection();
							try {
								Server.startWebServer(conn);
							} catch (SQLException e) {
								System.out.println(e.getMessage());
							}
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						} finally {
							try {
								if (conn != null) {
									conn.close();
								}
							} catch (SQLException sqle) {
								sqle.printStackTrace();
							}
						}
					}
				}.start();

			} finally {

				// close connection pool.
				// cp.dispose();

				// close underlying H2 database.
				if (server != null) {
					// server.stop();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea la tabla Log_Values.
	 */
	private static void createTable() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(properties.get("url"), properties.get("userName"), properties.get("password"));

			// STEP 3: Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Log_Values (id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY, message_type INTEGER NOT NULL, message VARCHAR(255) NOT NULL)";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");

			// STEP 4: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}
}