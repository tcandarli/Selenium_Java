import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *1-How Selenium will identify elements? Explain briefly.

2-Explain the each component of below syntax:

            driver.findElement(By.locatorStrategy("LocatorValue"));

3-How many total locators Selenium have and what are those?

4- Navigate to: https://www.website.com/sign-in/ (Links to an external site.)Links to an external site.

    Enter username: mike

    Enter password: abc123

    Click Log-in buttton 
 */


public class Assignment4 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.website.com/sign-in/");
		driver.findElement(By.id("username")).sendKeys("Mike");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.id("signin-submit2")).click();
		
		driver.close();
		driver.quit();

	}

}
