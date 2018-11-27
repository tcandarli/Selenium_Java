import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
		driver.manage().window().maximize();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 
		
//		driver.findElement(By.id("H-destination")).sendKeys("nyc");
//		driver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);	// Press TAB key
//		driver.findElement(By.id("H-destination")).sendKeys(Keys.ENTER); // Press ENTER key
//		
//		driver.findElement(By.xpath("//a[contains(@href, 'Hotels')]")).click();
//		
		
		// Explicit Wait
		
		WebDriverWait wait = new WebDriverWait(driver, 10); // Wait 5 seconds
		
		driver.findElement(By.id("H-destination")).sendKeys("nyc");
		driver.findElement(By.id("H-destination")).sendKeys(Keys.TAB);	// Press TAB key
		driver.findElement(By.id("H-destination")).sendKeys(Keys.ENTER); // Press ENTER key
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'Hotels')]")));
		driver.findElement(By.xpath("//a[contains(@href, 'Hotels')]")).click();

	}

}
