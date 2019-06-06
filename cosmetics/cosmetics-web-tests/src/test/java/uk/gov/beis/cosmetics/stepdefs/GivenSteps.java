package uk.gov.beis.cosmetics.stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.cosmetics.Utils.AppProperties;
import org.apache.commons.io.FileUtils;
import uk.gov.beis.cosmetics.Utils.EnvironmentProperties;
import uk.gov.beis.cosmetics.pagemodel.AddProductPage;
import uk.gov.beis.cosmetics.pagemodel.LoginPage;
import org.openqa.selenium.TakesScreenshot;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

public class GivenSteps extends SharedWebDriver {

	private WebDriver driver;
	private LoginPage loginPage;
	private AddProductPage addProductPage;

	public GivenSteps(SharedWebDriver driver) {
		this.driver = driver;
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		addProductPage = PageFactory.initElements(driver, AddProductPage.class);
	}

	@Given("^I upload a valid file$")
	public void i_upload_a_valid_file() throws Throwable {
		loginPage.launch_app(AppProperties.get("envurl"));
		//loginPage.launch_app(EnvironmentProperties.getServiceUrl());
		loginPage.verifyPageTitle("Landing Page - Cosmetics Portal");
		loginPage.login_as_responsible_person();
	}

	@When("^upload is successfull$")
	public void upload_is_successfull() throws Throwable {
	    
	}

	@Then("^I should see product populated \"(.*?)\" in unfinished tab$")
	public void i_should_see_product_populated_in_unfinished_tab(String arg1) throws Throwable {
	  
	}

	@Given("^I login user as$")
	public void i_login_user_as() throws Throwable {
		Scenario scenario=null;
		loginPage.launch_app(EnvironmentProperties.getServiceUrl());
		 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
         scenario.embed(screenshot, "image/png");
		Thread.sleep(3000);
		loginPage.verifyPageTitle("Landing Page - Submit cosmetic product notifications");
	    loginPage.login_as_responsible_person();
	    
	}

	@Given("^I click on \"(.*?)\"$")
	public void i_click_on(String arg1) throws Throwable {
	    loginPage.click_by_text(arg1);
	    this.takeScreenshot();
	}

	@When("^I upload file \"(.*?)\"$")
	public void i_upload_file(String arg1) throws Throwable {
		addProductPage.add_notification_file(arg1);
		Thread.sleep(5000);
		this.takeScreenshot();
	   
	}

	@Then("^I should be able to see no errors$")
	public void i_should_be_able_to_see_no_errors() throws Throwable {
	    
	}

	@Then("^I should see product added in Unfinished tab$")
	public void i_should_see_product_added_in_Unfinished_tab() throws Throwable {
	    
	}

	@When("^I upload \"(.*?)\"$")
	public void i_upload(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		addProductPage.add_notification_file(arg1);
		this.takeScreenshot();
		Thread.sleep(5000);
	}

	@Then("^I should see respective error\"(.*?)\"$")
	public void i_should_see_respective_error(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		addProductPage.validate_notification_error(arg1);
	}
	
	@Then("^I should see \"(.*?)\"$")
	public void i_should_see(String arg1) throws Throwable {
	  addProductPage.Is_trigger_rule_displayed();
	  this.takeScreenshot();
	  assertTrue("Failed: Not on expected page", addProductPage.verify_cosmetics_trigger_rules_question(arg1)) ;
	}

	@When("^I click \"(.*?)\"$")
	public void i_click(String arg1) throws Throwable {
	  addProductPage.select_radio_button_by_text(arg1);
	  addProductPage.click_continue();
	  Thread.sleep(3000);
	}

	@When("^I select \"(.*?)\"$")
	public void i_select(String option) throws Throwable {
		addProductPage.select_radio_button_by_text(option);
		
		addProductPage.click_continue();
		this.takeScreenshot();
	}

	@Given("^I login as responsible person user$")
	public void i_login_as_responsible_person_user() throws Throwable {
		loginPage.launch_app(AppProperties.get("envurl"));
		//loginPage.launch_app(EnvironmentProperties.getServiceUrl());
		Thread.sleep(3000);
		loginPage.verifyPageTitle("Landing Page - Submit cosmetic product notifications");
	    loginPage.login_as_responsible_person();
	    this.takeScreenshot();
	}

	@Given("^I login as poison centre user$")
	public void i_login_as_poison_centre_user() throws Throwable {
		loginPage.launch_app(EnvironmentProperties.getServiceUrl());
		Thread.sleep(3000);
		loginPage.verifyPageTitle("Landing Page - Submit cosmetic product notifications");
		loginPage.login_as_poison_centre();
	}

	@Then("^I should see landing page$")
	public void i_should_see_landing_page() throws Throwable {
		assertTrue("Failed: Landing page not loaded", loginPage.verify_cosmetics_page_headers("Your cosmetic products"));
	}

	@When("^I select to manual journey$")
	public void i_select_to_manual_journey() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  addProductPage.select_radio_button_by_text("No, they have not been notified in the EU");
		  addProductPage.click_continue();
		  this.takeScreenshot();
	      addProductPage.select_radio_button_by_text("No");
	      addProductPage.click_continue();
	      this.takeScreenshot();
	}

	@When("^I select imported into UK \"(.*?)\"$")
	public void i_select_imported_into_UK(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    addProductPage.select_radio_button_by_text("Yes");
	    addProductPage.click_continue();
	}

	@When("^I select sold as single component \"(.*?)\"$")
	public void i_select_sold_as_single_component(String arg1) throws Throwable {
	    addProductPage.select_radio_button_by_text(arg1);
	    addProductPage.click_continue();
	    this.takeScreenshot();
	}

	@When("^I select cosmetic sold as more than one shade \"(.*?)\"$")
	public void i_select_cosmetic_sold_as_more_than_one_shade(String arg1) throws Throwable {
	   addProductPage.select_radio_button_by_text(arg1);
	   addProductPage.click_continue();
	   this.takeScreenshot();
	}

	@When("^I select nanomaterials as \"(.*?)\"$")
	public void i_select_nanomaterials_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   addProductPage.select_radio_button_by_text("No");
	   addProductPage.click_continue();
	   this.takeScreenshot();
	}

	@When("^I select image to upload$")
	public void i_select_image_to_upload() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should successfully land on checkyour answers page$")
	public void i_should_successfully_land_on_checkyour_answers_page() throws Throwable {    
	}
@When("^I enter product name\"(.*?)\"$")
public void i_enter_product_name(String arg1) throws Throwable {
    addProductPage.enter_productname(arg1);
    this.takeScreenshot();
  
}

@When("^I enter country imported from\"(.*?)\"$")
public void i_enter_country_imported_from(String arg1) throws Throwable {
   addProductPage.enter_country_imported_from(arg1);
   this.takeScreenshot();
   addProductPage.click_continue();
   this.takeScreenshot();
   
}

@When("^I select product category\"(.*?)\"$")
public void i_select_product_category(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	this.takeScreenshot();
	addProductPage.select_prod_category(arg1);
	this.takeScreenshot();
  
}

@When("^I select formulation\"(.*?)\"$")
public void i_select_formulation(String arg1) throws Throwable {
  addProductPage.select_radio_button_by_text(arg1);
  addProductPage.click_continue();
  this.takeScreenshot();
}

@When("^I select frame formulation\"(.*?)\"$")
public void i_select_frame_formulation(String arg1) throws Throwable {
	addProductPage.select_frame_formulation(arg1);
	this.takeScreenshot();
}

@Then("^I should see product name\"(.*?)\"$")
public void i_should_see_product_name(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}
@Given("^I select manually to notify product with single component$")
public void i_select_manually_to_notify_product_with_single_component() throws Throwable {
	    addProductPage.add_product_manually();
	    this.takeScreenshot();
}

@Given("^I select \"(.*?)\" product contains anti-dandruff agents$")
public void i_select_product_contains_anti_dandruff_agents(String arg1) throws Throwable {
    addProductPage.select_radio_button_by_text(arg1);
    addProductPage.click_continue();
}

@Given("^I enter agents substance \"(.*?)\"$")
public void i_enter_agents_substance(String arg1) throws Throwable {
    addProductPage.enter_trigger_rule1(arg1);
}

@Given("^I enter substance value \"(.*?)\"$")
public void i_enter_substance_value(String arg1) throws Throwable {
    addProductPage.enter_trigger_rule2(arg1);
    Thread.sleep(3000);
}

@Given("^I select pH between three and ten as \"(.*?)\"$")
public void i_select_pH_between_three_and_ten_as(String arg1) throws Throwable {
	addProductPage.select_radio_button_by_text(arg1);
    
}


@Given("^I enter ph value as \"(.*?)\"$")
public void i_enter_ph_value_as(String arg1) throws Throwable {
	addProductPage.enter_trigger_rule1(arg1);
   
}

@Given("^I enter invalid pH value \"(.*?)\"$")
public void i_enter_invalid_pH_value(String arg1) throws Throwable {
	addProductPage.enter_trigger_rule1(arg1);
}

@Given("^I enter valid pH value between (\\d+) and (\\d+) \"(.*?)\"$")
public void i_enter_valid_pH_value_between_and(int arg1, int arg2, String arg3) throws Throwable {
   addProductPage.enter_trigger_rule1(arg3);
}

public void takeScreenshot()
{
	Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE_CHROME).save("src/test/resources/screen-grabs/");
	 
	}
	
	@After()
    /*
      Embed a screenshot in test report if test is marked as failed
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
