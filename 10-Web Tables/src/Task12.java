import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task12 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://testingpool.com/data-types-in-java/");
		driver.manage().window().maximize();

		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='su-table']/table/tbody/tr"));
		System.out.println("Total rows: " + rows.size());

		List<WebElement> columns = driver.findElements(By.xpath("//div[@class='su-table']/table/tbody/tr[1]/td"));
		System.out.println("Total columns: " + columns.size());

		String x = driver.findElement(By.xpath("//div[@class='su-table']/table/tbody/tr[2]/td[3]")).getText();
		System.out.println(x);

		String y = driver.findElement(By.xpath("//div[@class='su-table']/table/tbody/tr[6]/td[1]")).getText();
		System.out.println(y);

		driver.quit();

	}

}
