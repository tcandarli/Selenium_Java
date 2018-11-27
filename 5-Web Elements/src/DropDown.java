import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

//		driver.get("https://www.priceline.com/");
//		driver.manage().window().maximize();

		// We use Select class to select dropdowns
//		Select s = new Select(driver.findElement(By.id("rooms")));

		// s.selectByIndex(2);
//		s.selectByValue("7");

		// Print everything from the list
//		List<WebElement> options = s.getOptions(); // first we get everything by getOptions()
//		System.out.println(options.size());

		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();

		Select s = new Select(driver.findElement(By.id("#selenium_commands")));
		s.selectByIndex(0);
		s.selectByIndex(3);

		List<WebElement> allSelected = s.getAllSelectedOptions();
		System.out.println(allSelected.size());

		for (WebElement e : allSelected) {
			System.out.println(e.getText());
		}

		driver.quit();

	}

}
