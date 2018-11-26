import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DynamicBrowser {

	public static void main(String[] args) {

		String browser = "Chrome";
		WebDriver driver = null;

		if (browser.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "..\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("https://www.bestbuy.com");

		// selenium

	}
}