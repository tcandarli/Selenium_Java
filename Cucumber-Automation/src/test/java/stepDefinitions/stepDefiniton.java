package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefiniton {

	@Given("^User is on NetBanking landing page$")
	public void user_is_on_NetBanking_landing_page() throws Throwable {
		System.out.println("Navigated to url");

	}

	@When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_into_application_with_something_and_password_something(String strArg1, String strArg2)
			throws Throwable {

		System.out.println(strArg1);
		System.out.println(strArg2);

	}

	@Then("^Home page is populated$")
	public void home_page_is_populated() throws Throwable {
		System.out.println("Home page is populated");

	}

	@Then("^Cards displayed are \"([^\"]*)\"$")
	public void cards_displayed_are(String arg1) throws Throwable {

		System.out.println(arg1);

	}

}