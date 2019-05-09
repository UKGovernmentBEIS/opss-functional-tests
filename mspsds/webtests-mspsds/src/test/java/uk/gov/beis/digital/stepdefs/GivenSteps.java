package uk.gov.beis.digital.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.digital.mspsds.Utils.AppProperties;
import uk.gov.beis.digital.mspsds.pagemodel.AssigneePage;
import uk.gov.beis.digital.mspsds.pagemodel.LoginPage;

public class GivenSteps {
	
	private WebDriver driver;
	String env = System.getenv("PSD_STAGE");
	LoginPage login_pge;
	AssigneePage assignpge;
	public GivenSteps(SharedWebDriver driver)
	{
		this.driver = driver;
		login_pge = PageFactory.initElements(driver,LoginPage.class);
		assignpge = PageFactory.initElements(driver, AssigneePage.class);
	}
	@Given("^I login as OPSS user$")
	public void i_login_as_OPSS_user() throws Throwable {
		login_pge.launch_app(env);
		Thread.sleep(5000);
		
		login_pge.login_as_opss();
		login_pge.verifyPageTitle("Cases - Product safety database - GOV.UK");
		
	}
	@Given("^I login as Trading standard user$")
	public void i_login_as_Trading_standard_user() throws Throwable {
		
		login_pge.launch_app(env);
		Thread.sleep(5000);
		login_pge.login_as_ts();
		login_pge.verifyPageTitle("Home Page - Product safety database - GOV.UK");
	}
	@When("^I want to assign any case$")
	public void i_want_to_assign_any_case() throws Throwable {
		login_pge.open_mspsds_case("Fancy Dress – Penetrating force (no product specified)");
		Thread.sleep(4000);
		assignpge.click_change_assign();
	    
	}
	
}
