import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1-What is CSS and what are the advantages of using it as locator?
 * 
 * A-1- CSS (Cascading Style Sheet is a simple design language indented to simplify
 * the process of making web pages presentable.
 * 
 * CSS handles the look and fell part of a web page.
 * Advantages of using css selectors
 * a) CSS is more readable,
 * b) CSS is faster.

2-Navigate to: https://login.salesforce.com/ (Links to an external site.)Links to an external site.

    Enter username: mike
    Enter password: abc123
    Click on Login

    Note: Use only CSS locators

3- Navigate to bestbuy sign page

    Enter email: mike@mike.com (travel from the location shown below)
    Enter password: abc123 (travel from the location shown below)
    Click on Sign-in
 */

public class Assignment6 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// A-2
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.cssSelector("input#username")).sendKeys("Mike");
		driver.findElement(By.cssSelector("input.password")).sendKeys("abc123");
		driver.findElement(By.cssSelector("#Login")).click();
		// A-3
		driver.get("https://www.bestbuy.com/?intl=nosplash");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".account.global-header-remove-arrow a:nth-of-type(1)")).click();
		driver.findElement(By.cssSelector(".btn.btn-secondary.welcome-banner-sign-in")).click();
		driver.findElement(By.cssSelector("#fld-e")).sendKeys("mike@mike.com");
		driver.findElement(By.cssSelector("#fld-p1")).sendKeys("abc123");
		driver.findElement(By.cssSelector(".cia-form__submit-button.js-submit-button span:nth-of-type(1)")).click();
		
		
	}

}
