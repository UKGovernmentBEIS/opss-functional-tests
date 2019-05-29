package uk.gov.beis.cosmetics.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import uk.gov.beis.cosmetics.pagemodel.AddProductPage;
import uk.gov.beis.cosmetics.pagemodel.LoginPage;

public class ThenSteps extends SharedWebDriver {
	
	private static WebDriver driver;
	LoginPage loginPge;
	AddProductPage addProd;
	
	public ThenSteps(SharedWebDriver driver)
	{
		this.driver=driver;
		loginPge = PageFactory.initElements(driver, LoginPage.class);
		addProd = PageFactory.initElements(driver, AddProductPage.class);
	}
	
	
	
	@Then("^I should be presented with anti-dandruff agents form page to enter details$")
	public void i_should_be_presented_with_anti_dandruff_agents_form_page_to_enter_details() throws Throwable {
		addProd.verify_cosmetics_trigger_rules_question("List the anti-dandruff agents and their concentration");
		Thread.sleep(3000);
		addProd.click_back_on_cosmetics_page();
	    
	}
	@Then("^I should be presented with trigger rule question \"(.*?)\"$")
	public void i_should_be_presented_with_trigger_rule_question(String arg1) throws Throwable {
	    addProd.verify_cosmetics_trigger_rules_question(arg1);
	    Thread.sleep(3000);
	    addProd.click_back_on_cosmetics_page();
	}
	
	@Then("^I should see error message \"(.*?)\"$")
	public void i_should_see_error_message(String arg1) throws Throwable {
	    addProd.verify_trigger_rule_error(arg1);
	}
	@Then("^I should see manual journey \"(.*?)\"$")
	public void i_should_see_manual_journey(String arg1) throws Throwable {
	    addProd.verify_cosmetics_page_headers(arg1);
	}
	
	@Then("^I click back$")
	public void i_click_back() throws Throwable {
	    addProd.click_back_on_cosmetics_page();
	}
	
	@Then("^I should see free text pH field to enter$")
	public void i_should_see_free_text_pH_field_to_enter() throws Throwable {
		addProd.Is_trigger_rule_question_displayed();
	   
	}
	
	@Then("^I should see free text to enter amount contains in product$")
	public void i_should_see_free_text_to_enter_amount_contains_in_product() throws Throwable {
		addProd.Is_trigger_rule_question_displayed();
	}

	@Then("^I dismiss any existing errors from error tab$")
	public void i_dismiss_any_existing_errors_from_error_tab() throws Throwable {
	    addProd.dismiss_error();
	}
	
}
