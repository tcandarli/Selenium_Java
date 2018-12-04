import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppBeforeAfterTest {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Executing Test Case");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Executing Test Case");
	}

	@Test(priority = 1)
	public void LoginTest() {
		// selenium code
		System.out.println("Login");
	}

	@Test(priority = 2)
	public void PasswordChange() {
		System.out.println("Changing password");
	}

	@Test(priority = 3)
	public void LogoutTest() {
		System.out.println("Logout");
	}

}
