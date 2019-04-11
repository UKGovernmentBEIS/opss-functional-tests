package uk.gov.beis.digital.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.digital.mspsds.pagemodel.CasesPage;
import uk.gov.beis.digital.mspsds.pagemodel.DashboardPage;

public class WhenSteps extends SharedWebDriver{
	
	private WebDriver driver;
	DashboardPage dashpge;
	CasesPage casepge;
	public WhenSteps(SharedWebDriver driver)
	{
		this.driver = driver;
		dashpge = PageFactory.initElements(driver, DashboardPage.class);
		casepge = PageFactory.initElements(driver, CasesPage.class);
	}

	
	@When("^I click on \"(.*?)\" tab$")
	public void i_click_on_tab(String arg1) throws Throwable {
		dashpge.click_by_text(arg1);
	   
	}
	@When("^I am on dashboard$")
	public void i_am_on_dashboard() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  dashpge.verify_dashboard();
	}

	@Then("^I should see my team name \"(.*?)\" displayed$")
	public void i_should_see_my_team_name_displayed(String arg1) throws Throwable {
	
	   dashpge.verify_element_by_text(arg1);
		
	   
	}

	@When("^I click team \"(.*?)\"$")
	public void i_click_team(String arg1) throws Throwable {
	   dashpge.click_by_text(arg1);
	}

	
	@When("^I click button \"(.*?)\"$")
	public void i_click_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    dashpge.click_by_text(arg1);
	}

	@When("^I select case type \"(.*?)\"$")
	public void i_select_case_type(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		dashpge.select_radio_button_by_text(arg1);
	   Thread.sleep(2000);
	   dashpge.click_continue();
	}

	@When("^I select reporter as \"(.*?)\"$")
	public void i_select_reporter_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		dashpge.select_radio_button_by_text(arg1);
		dashpge.click_continue();
	}

	@When("^I enter contact details$")
	public void i_enter_contact_details() throws Throwable {
		casepge.enter_contact_details();
	    
	    
	}

	@When("^I enter allegation details$")
	public void i_enter_allegation_details() throws Throwable {
		casepge.enter_allegation_details("",""); 
	    
	}

	@Then("^I should see \"(.*?)\"$")
	public void i_should_see(String arg1) throws Throwable {
		casepge.verify_banner_message(arg1);
	   
	}

	@When("^I enter allegation details for product category \"(.*?)\"$")
	public void i_enter_allegation_details_for_product_category(String arg1) throws Throwable {
		casepge.select_allegation_prod_cat(arg1);
	}

	@When("^I enter hazard type as \"(.*?)\"$")
	public void i_enter_hazard_type_as(String arg1) throws Throwable {
		casepge.select_hazard_type(arg1);
	}



}
