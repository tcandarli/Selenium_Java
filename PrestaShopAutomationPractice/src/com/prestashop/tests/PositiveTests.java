package com.prestashop.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
	
	
	public void createAccount() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String email = "abc123456@gmail.com";
		String password = "abc12345";
		String fName = "Michael";
		String lName = "Jordan";
		String company = "Selenium Software";
		String address = "1th Street 12";
		String city = "Geneva";
		driver.findElement(By.id("email_create")).sendKeys("email");
		driver.findElement(By.className("icon-user left")).click();
		
		List<WebElement> allRadios = driver.findElements(By.className("radio-inline"));
		allRadios.get(0).click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys(fName);
		driver.findElement(By.id("customer_lastname")).sendKeys(lName);
		
		
		
		
		
		
		
	}
	
	
	@AfterTest
	public void closeUp() {
		driver.quit();
	}
	
	

}
