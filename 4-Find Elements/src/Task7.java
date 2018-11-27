import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task7 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.etsy.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement we : links) {

			if (we.getText().equals("Clothing & Shoes")) {
				we.click();
			}

		}

		// 2nd way - for loop
		List<WebElement> links2 = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links2.size(); i++) {
			WebElement link = links2.get(i);
			if (link.getText().equals("Clothing & Shoes")) {
				link.click();
			}
		}

		driver.close();
		driver.quit();
	}

}
