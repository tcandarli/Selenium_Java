package pomdesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.WebOrderLoginPage;

public class WebOrderTest {

	WebDriver driver;
	WebOrderLoginPage loginPage;
	AllOrdersPage allOrdersPage;

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

	@Test
	public void labelsVerification() {

		loginPage = new WebOrderLoginPage(driver);
		allOrdersPage = new AllOrdersPage(driver);
		Assert.assertEquals(driver.getTitle(), "Web Orders Login", "Login Page is not displayed");
		loginPage.username.sendKeys("Tester");
		loginPage.password.sendKeys("test");
		loginPage.loginButton.click();
		Assert.assertTrue(allOrdersPage.webOrders.isDisplayed(), "Web Orders is not displayed");
		Assert.assertTrue(allOrdersPage.listOfAllOrders.isDisplayed(), "List of all orders is not displayed");
		Assert.assertTrue(allOrdersPage.welcomeMsg.isDisplayed(), "Welcome message is not displayed");

	}

}
