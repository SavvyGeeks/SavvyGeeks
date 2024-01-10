package StepDefinition;

import java.io.IOException;

import com.pages.SignInPage;
import com.qa.factory.DriverFactory;
import com.qa.util.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSD {

	SignInPage signIn = new SignInPage(DriverFactory.getDriver());


	@Given("User is on home page and click SignIn button")
	public void user_is_on_home_page_and_click_sign_in_button() {
		DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/home");
		signIn.clickSignIn();
		LoggerLoad.info("User clicks on signin link");
	}

	@When("User enters sheetname {string} and rownumber {int}")
	public void user_enters_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException {
		
		signIn.readDataFromSheet(sheetName, rowNumber);
		LoggerLoad.info("User reads data from excel sheet");
	}

	@When("Enter username {string} and password {string} and click on login button")
	public void enter_username_and_password_and_click_on_login_button(String string, String string2) throws IOException {
		signIn.sendUsername();
		signIn.sendPassword();
		signIn.clickLoginBtn();

	}

	@Then("User navigates to home page and see success message")
	public void user_navigates_to_home_page() {

		signIn.verifyValidUserLoginMessage();
		LoggerLoad.info("User verifies valid user login message");
	}


	@Then("User will see invalid user details message")
	public void user_will_see_invalid_user_details_message() {
		signIn.verifyInvalidUserErrorMessage();
		LoggerLoad.info("User verifies Invalid user error message");
		
		
	}



	@When("when user completes all operations")
	public void when_user_completes_all_operations() {
	  
	    
	}

	@Then("User click on Signout")
	public void user_click_on_signout() {
	   
		signIn.clickSignOut();
		LoggerLoad.info("User clicks on signout link");
	   
	}



}