import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.newtours.demoaut.com");
		
		// enter name
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		
		// enter password
		driver.findElement(By.name("password")).sendKeys("tutorial");
		
		// click to sign in button
		driver.findElement(By.name("login")).click();
		
		// verify title contains "Find a Flight"
		String title = driver.getTitle();
		if (title.contains("Find a Flight" )) {
			System.out.println("Verified ");
		} else {
			System.out.println("Not verified");
		}
		
		driver.quit();

	}

}
