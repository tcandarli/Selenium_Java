package com.cybertek;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class sauceTest {

	public static final String USERNAME = "tcandarli";
	public static final String ACCESS_KEY = "e3a5e7eb-91f3-4003-894b-58f86a240cd4";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@Test
	public void login() throws MalformedURLException {

		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "42.0");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://www.cnn.com");
		System.out.println(driver.getTitle());

	}

}
