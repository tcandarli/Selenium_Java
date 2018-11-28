import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#login1")).sendKeys("John");
		driver.findElement(By.name("proceed")).click();

		// Define alert by Alert()
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());

		// accept the alert message
		al.accept();

		// we have to switch to default content from alert page
		driver.switchTo().defaultContent();

	}

}
