package pomdesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.WebOrderLoginPage;

public class WebOrderLoginTest {

	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	}
	
	
	@AfterTest
	public void closeUp() {
		driver.quit();
	}
	
	@Ignore
	@Test
	public void login() {
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
	}
	
	@Test
	public void loginusingPOM() {
		
		WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
		loginPage.username.sendKeys("Tester");
		loginPage.password.sendKeys("test");
		loginPage.loginButton.click();
		
	}
	
	
	
	
	
}
