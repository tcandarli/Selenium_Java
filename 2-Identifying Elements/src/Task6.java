import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task6 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.rediff.com");
		// maximize window
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("[title='Already a user? Sign in']")).click();
		driver.findElement(By.cssSelector("[name='loginform'] #login1")).sendKeys("Mike");
		driver.findElement(By.cssSelector(".f14.margTop10.form-label + div>input")).sendKeys("abc123");
		driver.findElement(By.cssSelector("[name='proceed']")).click();

	}

}
