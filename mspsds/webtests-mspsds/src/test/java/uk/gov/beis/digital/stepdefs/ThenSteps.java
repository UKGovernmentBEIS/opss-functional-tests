package uk.gov.beis.digital.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import uk.gov.beis.digital.mspsds.pagemodel.AssigneePage;

public class ThenSteps {
	private WebDriver driver;
	AssigneePage assignpge;
	
	public ThenSteps(SharedWebDriver driver)
	{
		this.driver= driver;
		assignpge = PageFactory.initElements(driver,AssigneePage.class);
		
	}

	@Then("^I should be able to see prioritise team list under teams$")
	public void i_should_be_able_to_see_prioritise_team_list_under_teams(DataTable arg1) throws Throwable {
	   assignpge.click_change_assign();
	   assignpge.verify_priority_team(arg1);
	}

	
}
