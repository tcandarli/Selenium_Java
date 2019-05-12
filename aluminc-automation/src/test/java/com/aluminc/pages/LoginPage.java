package com.aluminc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aluminc.utilities.Driver;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(name = "inputEmail")
	public WebElement email;
	
	@FindBy(id = "inputPass")
	public WebElement password;
	
	@FindBy(className = "btn btn-pink btn-block btn-raised")
	public WebElement submit;
	
	@FindBy(className = "btn btn-secondary btn-block btn-raised")
	public WebElement cancel;

}
