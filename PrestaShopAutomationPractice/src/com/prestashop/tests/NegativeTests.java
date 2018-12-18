package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

	@Test
	public void wrongCredentials() {
		driver.findElement(By.id("email")).sendKeys("email@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("pass12345");
		driver.findElement(By.id("SubmitLogin")).click();
		Assert.assertTrue(isDisplayed(), "Authentication failed. is displayed");
	}

	private boolean isDisplayed() {

		if (driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).isDisplayed()) {
			return true;
		}
		return false;

	}

	@Test
	public void invalidEmailTest() {

		driver.findElement(By.id("email")).sendKeys("abc.gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("pass12345");
		driver.findElement(By.id("SubmitLogin")).click();
		Assert.assertTrue(isDisplayed(), "Invalid email address. is displayed");
	}

	@Test
	public void blankEmailTest() {

		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("passwd")).sendKeys("pass12345");
		driver.findElement(By.id("SubmitLogin")).click();
		Assert.assertTrue(isDisplayed(), "An email address required. is displayed");
	}

	@Test
	public void blankPasswordTest() {

		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("");
		driver.findElement(By.id("SubmitLogin")).click();
		Assert.assertTrue(isDisplayed(), "Password is required. is displayed");
	}

	@AfterTest
	public void closeup() {

		driver.quit();

	}

}
