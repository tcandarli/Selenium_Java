package com.gascalculator.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gascalculator.pages.GasCalculatorPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDFTest {

	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.calculator.net/gas-mileage-calculator.html");			
	}
	
	
	@AfterTest
	public void closeup() {
		driver.quit();
	}
	
	
	
	@Test
	public void calculateTest() {
	
		GasCalculatorPage calculatePage = new GasCalculatorPage(driver);
		
		double currentOr = 3456;
		double previousOr = 2345;
		double gas = 30;
		
		calculatePage.currentOdometer.clear();
		
		
		
		
	}
	
}
