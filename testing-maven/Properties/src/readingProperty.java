import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readingProperty {

	public static void main(String[] args) throws IOException {

		// Create an instance of class
		Properties prop = new Properties();

		// Provide path of the file to constructor of the class
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\PC\\Documents\\github\\Selenium\\testing-maven\\Properties\\employee.properties");

		// Loading instance
		prop.load(ip);
		
		// retrieve those properties
		String name = prop.getProperty("name");
		System.out.println(name);
		
		System.out.println(prop.getProperty("age"));

	}

}
