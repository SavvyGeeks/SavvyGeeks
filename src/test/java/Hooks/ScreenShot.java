package Hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.factory.DriverFactory;
import com.qa.util.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class ScreenShot extends BaseClass {

	@After(order=0)
	public void tearDown_close(Scenario sc) {

		try {
			String screenshotname = sc.getName().replaceAll(" ", "-");
			if (sc.isFailed()) {
				sc.log("This is my failure message");
				byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
				sc.attach(screenshot, "image/png", screenshotname);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
//	@AfterAll(order=1)
//	public static void close_driver() throws Exception{
//		driver.close();
//		
//}
}
