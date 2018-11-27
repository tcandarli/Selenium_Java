import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintSpecificBox {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://edition.cnn.com/");
		driver.manage().window().maximize();

		// get the box
		WebElement box = driver.findElement(By.cssSelector(
				".cn.cn-list-hierarchical-xs.cn--idx-1.cn-container_617564EF-3A98-F1E9-04FC-EB35E8F95F99"));

		// get the list items

		List<WebElement> links = box.findElements(By.tagName("li"));

		System.out.println(links.size());

//		for (WebElement link : links) {
//			
//			links = box.findElements(By.tagName("li"));
//			System.out.println(link.getText());
//		}

		for (int i = 0; i < links.size(); i++) {
			links.get(i).click();
			driver.navigate().back();
			box = driver.findElement(By.cssSelector(
					".cn.cn-list-hierarchical-xs.cn--idx-1.cn-container_617564EF-3A98-F1E9-04FC-EB35E8F95F99"));
			links = box.findElements(By.tagName("li"));

		}

		driver.quit();
	}

}
