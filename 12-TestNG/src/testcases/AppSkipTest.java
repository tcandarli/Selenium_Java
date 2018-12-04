package testcases;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppSkipTest {

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("---Before Suit---");
	}

	@AfterSuite
	public void afterSuit() {
		System.out.println("---After Suit---");
	}

	@Test(priority = 1)
	public void LoginTest() {
		// selenium code
		System.out.println("Login");
	}

	// To skip a test case we use: throw new SkipException("reason");
	@Test(priority = 2)
	public void PasswordChange() {
		System.out.println("Changing password");
		throw new SkipException("any reason");
	}

	// To skip the test case we use enabled=false
	@Test(priority = 3, enabled = false)
	public void LogoutTest() {
		System.out.println("Logout");
	}

}
