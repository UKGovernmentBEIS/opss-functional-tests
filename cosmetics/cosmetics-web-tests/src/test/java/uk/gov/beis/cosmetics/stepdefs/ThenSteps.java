package uk.gov.beis.cosmetics.stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import uk.gov.beis.cosmetics.pagemodel.AddProductPage;
import uk.gov.beis.cosmetics.pagemodel.LoginPage;

public class ThenSteps extends SharedWebDriver {

	private WebDriver driver;
	private LoginPage loginPage;
	private AddProductPage addProductPage;

	public ThenSteps(SharedWebDriver driver) {
		this.driver = driver;
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		addProductPage = PageFactory.initElements(driver, AddProductPage.class);
	}

	@Then("^I should be presented with anti-dandruff agents form page to enter details$")
	public void i_should_be_presented_with_anti_dandruff_agents_form_page_to_enter_details() throws Throwable {
		addProductPage.verify_cosmetics_trigger_rules_question("List the anti-dandruff agents and their concentration");
		Thread.sleep(3000);
		this.takeScreenshot();
		addProductPage.click_back_on_cosmetics_page();
	}

	@Then("^I should see trigger rule question \"(.*?)\"$")
	public void i_should_see_trigger_rule_question(String arg1) throws Throwable {
		addProductPage.verify_cosmetics_trigger_rules_question(arg1);
		this.takeScreenshot();
	}

	@Then("^I should be presented with trigger rule question \"(.*?)\"$")
	public void i_should_be_presented_with_trigger_rule_question(String arg1) throws Throwable {
	    addProductPage.verify_cosmetics_trigger_rules_question(arg1);
	    Thread.sleep(3000);
	    this.takeScreenshot();
	    addProductPage.click_back_on_cosmetics_page();
	}

	@Then("^I should see error message \"(.*?)\"$")
	public void i_should_see_error_message(String arg1) throws Throwable {
	    addProductPage.verify_trigger_rule_error(arg1);
	  
	}

	@Then("^I should see manual journey \"(.*?)\"$")
	public void i_should_see_manual_journey(String arg1) throws Throwable {
	    addProductPage.verify_cosmetics_page_headers(arg1);
	    this.takeScreenshot();
	}

	@Then("^I click back$")
	public void i_click_back() throws Throwable {
	    addProductPage.click_back_on_cosmetics_page();
	}

	@Then("^I should see free text pH field to enter$")
	public void i_should_see_free_text_pH_field_to_enter() throws Throwable {
		addProductPage.Is_trigger_rule_question_displayed();
		this.takeScreenshot();
	}

	@Then("^I should see free text to enter amount contains in product$")
	public void i_should_see_free_text_to_enter_amount_contains_in_product() throws Throwable {
		addProductPage.Is_trigger_rule_question_displayed();
	}
	
	public void takeScreenshot()
	{
		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE_CHROME).save("src/test/resources/screen-grabs/");
		 
		}
}
