import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://dice.com");
		driver.get("https://www.indeed.com");
		driver.navigate().back();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();

	}

}
