package com.aluminc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aluminc.utilities.Driver;

public class DashBoardPage {
	
	public DashBoardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(className = "menu-title")
	public WebElement dashboard;

}
