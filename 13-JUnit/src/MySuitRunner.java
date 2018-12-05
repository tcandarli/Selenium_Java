import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)

// Add test classes into {} to run all of them
@SuiteClasses({TestApplication.class, Assertions.class, Parameterization.class})
public class MySuitRunner {

}
