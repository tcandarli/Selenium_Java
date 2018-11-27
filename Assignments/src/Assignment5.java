import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

/*
 * 1-What is XPATH? Explain the advantages and disadvantages of using it.

2-How can we  handle elements with dynamic attribute values?

3-Navigate to: http://www.way2automation.com/angularjs-protractor/registeration/#/login (Links to an external site.)Links to an external site.

   Enter username: angular

   Enter password: password

   Enter username: angular

   Click on login

    Note: Use only XPATH to identify elements

4-Navigate to https://mail.rediff.com/cgi-bin/login.cgi (Links to an external site.)Links to an external site.

       Enter username: mike (travel from the location showed below)
 */

public class Assignment5 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");
		driver.findElement(By.xpath("//i[@class=\"fa fa-key\"]/../input")).click();
		driver.findElement(By.xpath("//i[@class=\"fa fa-key\"]/../input")).sendKeys("angular");

		driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]/../input")).click();
		driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]/../input")).sendKeys("password");

		driver.findElement(By.xpath("//label[@class=\"control-label \"]/../input")).click();
		driver.findElement(By.xpath("//label[@class=\"control-label \"]/../input")).sendKeys("angular");

		driver.findElement(By.xpath("//div[@class=\"form-actions\"]/button")).click();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.findElementByXPath("//form[@name=\"loginform\"]/div/div[1]").sendKeys("Mike");
		driver.findElementByXPath("//img[@id=\"fill_metric\"]/../div/div[4]/input").sendKeys("abc123");
		driver.findElementByXPath("//input[@title=\'Sign in\']").click();
		
		driver.close();
		driver.quit();
		
		
	}

}
