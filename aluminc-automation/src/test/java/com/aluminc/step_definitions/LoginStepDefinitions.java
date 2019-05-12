package com.aluminc.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import com.aluminc.pages.DashBoardPage;
import com.aluminc.pages.LoginPage;
import com.aluminc.utilities.ConfigurationReader;
import com.aluminc.utilities.Driver;

@SuppressWarnings("deprecation")
public class LoginStepDefinitions {
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		
	    String loginPage = ConfigurationReader.getProperty("loginPage");
	    Driver.getDriver().get(loginPage);
	}

	@When("the user logs in as mikesmith")
	public void the_user_logs_in_as_mikesmith() {
	    
		String email = "mikesmith@gmail.com";
		String password = "123";
		
		LoginPage loginPage = new LoginPage();
		loginPage.email.sendKeys(email);
		loginPage.password.sendKeys(password + Keys.ENTER);
		// loginPage.submit.click();
				
	}

	@Then("the user should be logged in")
	public void the_user_should_be_logged_in() {
	    
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DashBoardPage dashBoardPage = new DashBoardPage();
		Assert.assertTrue(dashBoardPage.dashboard.isDisplayed());
	}

	@Then("there should be dashboard")
	public void there_should_be_dashboard() {
		
	   
		
	}

//	@Given("the user logs in using {string} {string}")
//	public void the_user_logs_in_using(String string, String string2) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new cucumber.api.PendingException();
//	}

//	@When("the user is on the login page")
//	public void the_user_is_on_the_login_page1() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new cucumber.api.PendingException();
//	}


}
