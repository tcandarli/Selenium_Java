package com.gascalculator.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GasCalculatorPage {
	
	public class frameworkTest {
		
		WebDriver driver = null;
		
		@BeforeTest
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.calculator.net/gas-mileage-calculator.html");			
		}
		
		
		@AfterTest
		public void quit() {
			driver.quit();
		}
		
		@Test
		public void test() {
			
			driver.findElement(By.id("uscodreading")).clear();
			driver.findElement(By.id("uscodreading")).sendKeys("11000");
			driver.findElement(By.id("uspodreading")).clear();
			driver.findElement(By.id("uspodreading")).sendKeys("10000");
			driver.findElement(By.id("usgasputin")).clear();
			driver.findElement(By.id("usgasputin")).sendKeys("10");
			driver.findElement(By.id("usgasprice")).clear();
			driver.findElement(By.id("usgasprice")).sendKeys("3");
			
			
		}
		
		
		
	}

}
