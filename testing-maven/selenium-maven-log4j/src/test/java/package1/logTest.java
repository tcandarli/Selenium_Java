package package1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logTest {

	public static void main(String[] args) {

		Logger log = LogManager.getLogger(logTest.class.getName());
		log.debug("I am logging"); // When each selenium action is performed like click(),
		// sendKeys.getText()
		log.info("Object is present"); // When operation is succesfully completed
		// ex: After loading page
		log.debug("starting");

		if (3 > 2) {
			log.info("Object is present");
		} else {
			log.error("Object is not present");
		}
	}
}
