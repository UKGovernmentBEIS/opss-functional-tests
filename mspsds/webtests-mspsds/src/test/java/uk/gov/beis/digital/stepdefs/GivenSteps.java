package uk.gov.beis.digital.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.digital.mspsds.Utils.AppProperties;
import uk.gov.beis.digital.mspsds.Utils.EnvironmentProperties;
import uk.gov.beis.digital.mspsds.pagemodel.AssigneePage;
import uk.gov.beis.digital.mspsds.pagemodel.LoginPage;

public class GivenSteps {

	private LoginPage loginPage;
	private AssigneePage assigneePage;
	private String platform=AppProperties.get("platform");
	private String kc_url = AppProperties.get("KC_URL");
	private String kc_pwd = AppProperties.get("KC_password");

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
		}
		Thread.sleep(5000);
		
		loginPage.login_as_opss();
		loginPage.verifyPageTitle("Cases - Product safety database - GOV.UK");
		
	}

	@Given("^I login as Trading standard user$")
	public void i_login_as_Trading_standard_user() throws Throwable {
		if (platform.equals("local")) {
			loginPage.launch_app(AppProperties.get("envurl"));
			
		} else {
		loginPage.launch_app(EnvironmentProperties.getServiceUrl());
		}
		Thread.sleep(5000);
		

		loginPage.login_as_ts();
		loginPage.verifyPageTitle("Home Page - Product safety database - GOV.UK");
	}

	@When("^I want to assign any case$")
	public void i_want_to_assign_any_case() throws Throwable {
		loginPage.open_mspsds_case("Fancy dress – Penetrating force (no product specified)");
		Thread.sleep(4000);

		assigneePage.click_change_assign();
}
	@Given("^I login as keycloack Admin user$")
	public void i_login_as_keycloack_Admin_user() throws Throwable {
		loginPage.launch_app(kc_url);
		Thread.sleep(3000);
		loginPage.login_as_kc_admin("Admin",kc_pwd);
	    
	}

	@When("^I go to users$")
	public void i_go_to_users() throws Throwable {
		loginPage.go_to_users();
	}



}
