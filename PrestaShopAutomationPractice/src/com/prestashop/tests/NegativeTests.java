package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class NegativeTests {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
	}

}
