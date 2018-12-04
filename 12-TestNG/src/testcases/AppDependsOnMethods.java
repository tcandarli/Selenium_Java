import org.testng.SkipException;
import org.testng.annotations.Test;

public class AppDependsOnMethods {

	@Test(priority = 1)
	public void LoginTest() {
		// selenium code
		System.out.println("Login");
		throw new SkipException("This will be skipped");
	}

	@Test(priority = 2, dependsOnMethods = { "LoginTest" })
	public void PasswordChange() {
		System.out.println("Changing password");
	}
 
	@Test(priority = 3, dependsOnMethods = { "PasswordChange" })
	public void LogoutTest() {
		System.out.println("Logout");
	}

	@Test
	public void LogoutSystemTest() {
		System.out.println("System Logout");
	}

}
