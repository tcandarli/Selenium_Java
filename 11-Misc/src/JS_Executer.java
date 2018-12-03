import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class JS_Executer {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.hotwire.com/");

		driver.findElement(By.id("farefinder-hotel-destination-input")).sendKeys("New");
		driver.findElement(By.id("farefinder-hotel-destination-input")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("farefinder-hotel-destination-input")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("farefinder-hotel-destination-input")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("farefinder-hotel-destination-input")).sendKeys(Keys.ENTER);
		
		System.out.println(driver.findElement(By.id("farefinder-hotel-destination-input")).getAttribute("value"));
		
		// JavaScrip executor is used to grab the element from DOM	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"farefinder-hotel-destination-input\").value;";
		String text = (String) js.executeScript(script);
		System.out.println(text);
	}

}
