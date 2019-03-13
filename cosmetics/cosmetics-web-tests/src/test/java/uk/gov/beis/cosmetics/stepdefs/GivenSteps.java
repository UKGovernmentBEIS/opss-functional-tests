package uk.gov.beis.cosmetics.stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.cosmetics.Utils.AppProperties;
import uk.gov.beis.cosmetics.pagemodel.AddProductPage;
import src.main.java.uk.gov.beis.digital.*;
import uk.gov.beis.cosmetics.pagemodel.LoginPage;
import org.openqa.selenium.TakesScreenshot;

public class GivenSteps extends SharedWebDriver {
	
	private static WebDriver driver;
	LoginPage loginPge;
	AddProductPage addProd;
	String env = AppProperties.get("envurl");
	public GivenSteps(SharedWebDriver driver)
	{
		this.driver  = driver;
		loginPge = PageFactory.initElements(driver,LoginPage.class);
		addProd = PageFactory.initElements(driver, AddProductPage.class);
		
	}
	@Given("^I upload a valid file$")
	public void i_upload_a_valid_file() throws Throwable {
		loginPge.launch_app(env);
		loginPge.verifyPageTitle("Landing Page - Cosmetics Portal");
		loginPge.login_as("nasiralikhan1982@gmail.com", "Test@123");   
	}

	@When("^upload is successfull$")
	public void upload_is_successfull() throws Throwable {
	    
	}

	@Then("^I should see product populated \"(.*?)\" in unfinished tab$")
	public void i_should_see_product_populated_in_unfinished_tab(String arg1) throws Throwable {
	  
	}
	@Given("^I login user as$")
	public void i_login_user_as(DataTable arg1) throws Throwable {
		loginPge.launch_app(env);
		Thread.sleep(3000);
		loginPge.verifyPageTitle("Landing Page - Cosmetics Portal");
	    loginPge.login_user(arg1);
	}

	@Given("^I click on \"(.*?)\"$")
	public void i_click_on(String arg1) throws Throwable {
	   loginPge.click_by_text(arg1);
	    
	}


	@When("^I upload file \"(.*?)\"$")
	public void i_upload_file(String arg1) throws Throwable {
		addProd.add_notification_file(arg1);
		Thread.sleep(5000);
	   
	}

	@Then("^I should be able to see no errors$")
	public void i_should_be_able_to_see_no_errors() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^I should see product added in Unfinished tab$")
	public void i_should_see_product_added_in_Unfinished_tab() throws Throwable {
	    
	}

	@When("^I upload \"(.*?)\"$")
	public void i_upload(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		addProd.add_notification_file(arg1);
		Thread.sleep(5000);
	}

	@Then("^I should see respective error\"(.*?)\"$")
	public void i_should_see_respective_error(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	addProd.validate_notification_error(arg1);
	}

	@After()
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                // byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }

    }

}
