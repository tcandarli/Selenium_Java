package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrderLoginPage {
	
	// Constructor
	public WebOrderLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);  // Page.initElements method is used to initialize web elements
		
	}
	
	@FindBy(id="ctl00_MainContent_username")
	public WebElement username;
	
	@FindBy(id="ctl00_MainContent_password")
	public WebElement password;
	
	@FindBy(id="ctl00_MainContent_login_button")
	public WebElement loginButton;	
	
	

}
