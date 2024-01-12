package Hooks;
import java.util.Iterator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.factory.DriverFactory;
import com.qa.util.BaseClass;
import com.qa.util.EmailUtil;

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
				System.out.println("-- Screenshot method sc.getName() - "+ sc.getName());
				String str = "";
				Iterator<String> iter = sc.getSourceTagNames().iterator();
				while( iter.hasNext()){
					str = iter.next().toString();
					System.out.println("-- Screenshot method - sc.getSourceTagNames() "+ str);
				}
				EmailUtil.sendEmail(sc.getName(),screenshotname, screenshot);
			}
		}catch (Exception e) {
			System.out.println("Exception get message...."+e.getMessage());
			e.printStackTrace();
			
		}
	}
//	@AfterAll(order=1)
//	public static void close_driver() throws Exception{
//		driver.close();
//		
//}
}
