/**
 * 
 */
package com.belatrixsf.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DBManagerTest {

	@Before
	public void setup() {
		ConfigProperties.init();
	}

	@Test
	public void getConnection() {
		try {
			Connection cn = DBManager.getConnection();
			Assert.assertNotNull(cn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
