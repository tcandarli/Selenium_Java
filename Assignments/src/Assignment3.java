import org.openqa.selenium.chrome.ChromeDriver;

/*
 * You got 5 offers from below mentioned companies and trying to decide which one to choose:

1-Navigate to: https://www.bankofamerica.com/ (Links to an external site.)Links to an external site.

2-Navigate to: http://www.fanniemae.com/portal/index.html (Links to an external site.)Links to an external site.

3-Navigate to: https://www.bcbs.com/ (Links to an external site.)Links to an external site.

4-Navigate to: https://www.ibm.com/us-en/?lnk=m (Links to an external site.)Links to an external site.

5-Navigate to: https://www.mcdonalds.com/us/en-us.html (Links to an external site.)Links to an external site.

6-Navigate back to bcbs

7-Navigate forward to ibm

8-Navigate back to fanniemae

9-Ok that is enough. LETS ACCEPT THE OFFER (Print : this is my company: "company url")

10-Close the browser

11-Quit driver
 
 */


public class Assignment3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
			driver.get("https://www.bankofamerica.com/");
			driver.get("http://www.fanniemae.com/portal/index.html");
			driver.get("https://www.bcbs.com/");
			driver.get("https://www.ibm.com/us-en/?lnk=m");
			driver.get("https://www.mcdonalds.com/us/en-us.html");
			driver.navigate().back();
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().back();
			driver.navigate().back();
			System.out.println("This is the company" + driver.getCurrentUrl());
			driver.close();
			driver.quit();
			
	}

}
