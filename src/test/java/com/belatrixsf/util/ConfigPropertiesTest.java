/**
 * 
 */
package com.belatrixsf.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigPropertiesTest {
	ConfigProperties c = null;
	
	@Before
	public void setup() {
		ConfigProperties.init();
		c = ConfigProperties.getInstance();
	}
	
	@Test
	public void getUserName() {
		String userName = c.get("userName");
		Assert.assertNotNull("Field userName is Null.", userName);
	}
	
	@Test
	public void getPassword() {
		String password = c.get("password");
		Assert.assertNotNull("Field password is Null.", password);
	}
	
	@Test
	public void getUrl() {
		String url = c.get("url");
		Assert.assertNotNull("Field url is Null.", url);
	}
	
	@Test
	public void getLoFileFolder() {
		String logFileFolder = c.get("logFileFolder");
		Assert.assertNotNull("Field logFileFolder is Null.", logFileFolder);
	}
}