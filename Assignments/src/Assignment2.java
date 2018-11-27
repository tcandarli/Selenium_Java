import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Browser methods 1- Navigate to: https://shop.honda.com/ (Links to an external
 * site.)Links to an external site. 2- Get the title and keep in the variable
 * called hondaTitle 3- Navigate to: https://www.ferrari.com/en-US (Links to an
 * external site.)Links to an external site. 4- Get the title and keep in the
 * variable called ferrariTitle 5- Use hondaTitle and ferrariTitle variables,
 * and print Shop for Ferrari 6- Close the browser 7- Quit driver
 */

public class Assignment2 {

	public static void main(String[] args) {

	

		System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://shop.honda.com/");
		String hondaTitle = driver.getTitle();
		driver.get("https://www.ferrari.com/en-US");
		String ferrariTitle = driver.getTitle();
		System.out.println(hondaTitle);
		System.out.println(ferrariTitle);
		
		String s1 = hondaTitle.substring(0, 8);
		String s2 = ferrariTitle.substring(9, 16);
		System.out.println(s1 + " " +s2);

		driver.close();
		driver.quit();

	}

}
