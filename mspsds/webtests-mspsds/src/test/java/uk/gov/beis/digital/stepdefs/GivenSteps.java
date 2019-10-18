package uk.gov.beis.digital.stepdefs;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import uk.gov.beis.digital.mspsds.Utils.AppProperties;
import uk.gov.beis.digital.mspsds.Utils.EnvironmentProperties;
import uk.gov.beis.digital.mspsds.pagemodel.AssigneePage;
import uk.gov.beis.digital.mspsds.pagemodel.LoginPage;

public class GivenSteps {

	private LoginPage loginPage;
	private AssigneePage assigneePage;
	private String platform=AppProperties.get("platform");

	public GivenSteps(SharedWebDriver driver) {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		assigneePage = PageFactory.initElements(driver, AssigneePage.class);
	}

	@Given("^I login as OPSS user$")
	public void i_login_as_OPSS_user() throws Throwable {
		if (platform.equals("local")) {
			loginPage.launch_app(AppProperties.get("envurl"));
		} else {
		loginPage.launch_app(EnvironmentProperties.getServiceUrl());
		Thread.sleep(5000);
		}
		
		loginPage.login_as_opss();
		loginPage.verifyPageTitle("Cases - Product safety database - GOV.UK");
		
	}

	@Given("^I login as Trading standard user$")
	public void i_login_as_Trading_standard_user() throws Throwable {
		if (platform.equals("local")) {
			loginPage.launch_app(AppProperties.get("envurl"));
		} else {
		loginPage.launch_app(EnvironmentProperties.getServiceUrl());
		Thread.sleep(5000);
		}

		loginPage.login_as_ts();
		loginPage.verifyPageTitle("Home Page - Product safety database - GOV.UK");
	}

	@When("^I want to assign any case$")
	public void i_want_to_assign_any_case() throws Throwable {
		loginPage.open_mspsds_case("Fancy dress – Penetrating force (no product specified)");
		Thread.sleep(4000);

		assigneePage.click_change_assign();
	}
}
