package uk.gov.beis.digital.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import uk.gov.beis.digital.mspsds.pagemodel.AssigneePage;
import uk.gov.beis.digital.mspsds.pagemodel.DashboardPage;

public class ThenSteps {
	private WebDriver driver;
	AssigneePage assignpge;
	DashboardPage dashpge;
	
	public ThenSteps(SharedWebDriver driver)
	{
		this.driver= driver;
		assignpge = PageFactory.initElements(driver,AssigneePage.class);
		dashpge = PageFactory.initElements(driver,DashboardPage.class);
		
	}

	@Then("^I should be able to see prioritise team list under teams$")
	public void i_should_be_able_to_see_prioritise_team_list_under_teams(DataTable arg1) throws Throwable {
	   assignpge.click_change_assign();
	   assignpge.verify_priority_team(arg1);
	}

	@Then("^I should see \"(.*?)\" tab$")
	public void i_should_see_tab(String arg1) throws Throwable {
		dashpge.verify_tabs(arg1);
	  
	}
	

	@Then("^I should see Businesses list page$")
	public void i_should_see_Businesses_list_page() throws Throwable {
		
	    
	}

	@Then("^I should see \"(.*?)\" list page$")
	public void i_should_see_list_page(String arg1) throws Throwable {
	    dashpge.Verify_tab_info(arg1);
	}

	@Then("^I should see team \"(.*?)\"$")
	public void i_should_see_team(String arg1) throws Throwable {
	   dashpge.verify_radio_button_by_text(arg1);
	}
	
	@Then("^I should see team page \"(.*?)\"$")
	public void i_should_see_team_page(String arg1) throws Throwable {
	   dashpge.verify_page_header1(arg1);
	}
	@Then("^I should see team member \"(.*?)\"$")
	public void i_should_see_team_member(String arg1) throws Throwable {
	   assertTrue("Failed:team member not displayed",dashpge.IsElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+arg1+"')]"))));
	}
	@After()
	/*
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
