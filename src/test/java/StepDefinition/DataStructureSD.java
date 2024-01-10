package StepDefinition;

import com.pages.DataStructuresPage;
import com.pages.SignInPage;
import com.qa.factory.DriverFactory;
import com.qa.util.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DataStructureSD {

	DataStructuresPage dataIntro = new DataStructuresPage(DriverFactory.getDriver());
	SignInPage signIn = new SignInPage(DriverFactory.getDriver());

	@Given("User click the GetStared button under Data subtitle")
	public void user_click_the_get_stared_button_under_data_subtitle() {
		
		dataIntro.clickDataStructureGetStarted();
		LoggerLoad.info("User clicks on DataStructure get started Page");
	}
	@Then("User Navigates to Data Structures-Introduction")
	public void user_navigates_to_data_structures_introduction() {
		System.out.println("Data Structures-Introduction");
		LoggerLoad.info("User is in DataStructures-Introduction Page");

	}
	@When("User click on Time Complexity link")
	public void user_click_on_time_complexity_link() {
		dataIntro.Clicktime_complex();
		LoggerLoad.info("User clicks on TimeComplexity Page");
	}
	@Then("Navigates to Time Complexity link")
	public void navigates_to_time_complexity_link() {
		System.out.println("Time Complexity link");
		LoggerLoad.info("User is in TimeComplexity Page");
	}

}