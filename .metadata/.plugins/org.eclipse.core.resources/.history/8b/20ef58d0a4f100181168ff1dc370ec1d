import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.close();
		driver.quit();

		System.setProperty("webdriver.gecko.driver", "..\\geckodriver.exe");
		FirefoxDriver driver2 = new FirefoxDriver();
		driver2.get("https://www.bestbuy.com/");
		driver2.close();
	}

}
