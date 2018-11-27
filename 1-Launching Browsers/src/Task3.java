import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.rediff.com");

		String title = driver.getTitle();

		if (title.contains("Computer")) {
			System.out.println("Verified");
		} else {
			System.out.println("Not verified");
		}

		driver.quit();

	}

}
