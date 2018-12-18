package com.prestashop.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PositiveTests {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();		
	}
	
	@Test
	public void createAccount() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String email = "abc1234567@gmail.com";
		String password = "abc12345";
		String fName = "Michael";
		String lName = "Jordan";
		String company = "Selenium Software";
		String address = "1th Street 12";
		String city = "Geneva";
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		
		// Select Radio button
		List<WebElement> allRadios = driver.findElements(By.className("radio-inline"));
		allRadios.get(0).click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys(fName);
		driver.findElement(By.id("customer_lastname")).sendKeys(lName);
		driver.findElement(By.id("passwd")).sendKeys(password);
		
		// Select day from days dropdown
		Select selDay = new Select(driver.findElement(By.id("days")));
		selDay.selectByIndex(14);
		
		// Select month from months dropdown
		Select selMonth = new Select(driver.findElement(By.id("months")));
		selMonth.selectByIndex(2);
		
		// Select year from years dropdown
		Select selYear = new Select(driver.findElement(By.id("years")));
		selYear.selectByIndex(36);
		
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("address1")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		
		// Select state from dropdown
		Select selState = new Select(driver.findElement(By.id("id_state")));
		selState.selectByIndex(15);
		
		driver.findElement(By.id("postcode")).sendKeys("66040");
		driver.findElement(By.id("phone_mobile")).sendKeys("5424554339");
		driver.findElement(By.id("submitAccount")).click();
		driver.findElement(By.linkText("Sign out")).click();
		
		// Login with same credentials
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		
		String expectedUserName = fName + " " + lName;
		String actualUserName = driver.findElement(By.className("account")).getText();
		Assert.assertEquals(actualUserName, expectedUserName, "Can not get expected username");
		
	}
	
	
//	@AfterTest
//	public void closeUp() {
//		driver.quit();
//	}
	
	

}
