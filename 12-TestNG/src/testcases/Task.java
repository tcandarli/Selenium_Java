package testcases;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {
	
	@BeforeMethod
	public void Login() {
		System.out.println("Login");
	}
	
	@AfterMethod
	public void Logout() {
		System.out.println("Logout");
	}
	
	@Test(priority = 1)
	public void Register() {
		System.out.println("Register succesfully completed");
	}
	
	@Test(priority = 2, dependsOnMethods = {"Register"}) 
	public void Search() {
		System.out.println("Search successfully completed");
		// throw new SkipException("Search is skipped");
	}
	
	@Test(priority = 3, dependsOnMethods = {"Search"}) 
	public void Buy() {
		System.out.println("Buy succesfully completed");
	}
	
	@Test(priority = 4, dependsOnMethods = {"Buy"})
	public void Pay() {
		System.out.println("Pay successfully completed");
	}

}
