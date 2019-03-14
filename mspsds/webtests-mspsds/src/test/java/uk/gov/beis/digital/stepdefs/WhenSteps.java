package uk.gov.beis.digital.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.digital.mspsds.pagemodel.DashboardPage;

public class WhenSteps extends SharedWebDriver{
	
	private WebDriver driver;
	DashboardPage dashpge;
	public WhenSteps(SharedWebDriver driver)
	{
		this.driver = driver;
		dashpge = PageFactory.initElements(driver, DashboardPage.class);
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

	

	

}
