package com.google;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearchTest {

	WebDriver driver = null;
	Xls_Reader data = new Xls_Reader("C:\\Users\\PC\\Documents\\github\\Selenium\\testing-maven\\selenium-maven-excel-googleSearch\\src\\test\\resources\\testData.xlsx");

	@BeforeTest
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

	}

	@AfterTest
	public void closeUp() {
		driver.quit();
	}

	@Test
	public void searchResults() {

		driver.findElement(By.name("q")).sendKeys(item);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		String result = driver.findElement(By.id("resultatStats")).getText();
		result = result.replace("About ", "");
		result = result.replace(" results", "");
		driver.navigate().back();

	}

}
