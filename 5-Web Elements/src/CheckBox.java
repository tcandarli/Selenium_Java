import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		
		List<WebElement> allCheckBoxes = driver.findElements(By.name("profession"));
		int size = allCheckBoxes.size();
		allCheckBoxes.get(1).click();
		System.out.println(size);
		System.out.println(allCheckBoxes.get(0).isSelected());
		
	}

}
