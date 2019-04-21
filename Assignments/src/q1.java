
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;

public class q1 {

	public static void main(String[] args) {

		try {
			FileInputStream fstream = new FileInputStream("engine.log");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String lines;
			int startCycle = 1;
			LocalTime startTime = null;
			LocalTime endTime = null;
			boolean started = false;

			while ((lines = br.readLine()) != null) {
				if (!started) {
					if (lines.contains("starting nxengine")) {
						startTime = LocalTime.parse(lines.substring(7, 15));
						started = true;
					}
				} else {
					if (lines.contains("nxengine is running")) {
						endTime = LocalTime.parse(lines.substring(7, 15));
						started = false;
						long duration = (Duration.between(startTime, endTime).toMillis() / 1000);
						String difference = String.format("%d:%02d:%02d", duration / 3600, (duration % 3600) / 60,
								(duration % 60));
						System.out.println("Start Cycle: " + startCycle++ + " Duration: " + difference);
					}

				}

			}

		} catch (IOException ex) {
			System.out.println("Failed to load file: " + ex.getMessage());
		}

	}

}
