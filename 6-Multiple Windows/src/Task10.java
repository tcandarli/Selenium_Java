import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task10 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("button1")).click();
		
		// 1st step get all winIds
		Set<String> winIds = driver.getWindowHandles();
		
		// all set items and iterate
		Iterator<String> it = winIds.iterator();
		
		// our windows with it.next
		String mainWindow = it.next();
		String firstWindow = it.next();
		
		// print title of main window
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());
		
		// print title of first window
		driver.switchTo().window(firstWindow);
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
