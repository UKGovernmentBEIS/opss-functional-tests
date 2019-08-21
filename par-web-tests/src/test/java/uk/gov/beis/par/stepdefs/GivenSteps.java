package uk.gov.beis.par.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.par.pagemodel.CreatePartnershipPage;
import uk.gov.beis.par.pagemodel.LoginPage;

public class GivenSteps extends SharedWebDriver
{
	
	private WebDriver driver;
	LoginPage loginPage;
	CreatePartnershipPage createPartnership;
	
	
 public GivenSteps(SharedWebDriver driver) {
	 this.driver = driver;
	 loginPage = PageFactory.initElements(driver, LoginPage.class);
	 createPartnership = PageFactory.initElements(driver,CreatePartnershipPage.class);
 }
	 
	
		
		@Given("^I login as \"(.*?)\"$")
		public void i_login_as(String arg1) throws Throwable {
			loginPage.login_as(arg1,"TestPassword");
			
		   
		}

		@Then("^I should be able to see \"(.*?)\"$")
		public void i_should_be_able_to_see(String arg1) throws Throwable {
		   
		    
		}

		
		@When("^I click on \"(.*?)\"$")
		public void i_click_on(String arg1) throws Throwable {
		    loginPage.click_by_text(arg1);
		}

		@When("^I fill-in the create partnershp form$")
		public void i_fill_in_the_create_partnershp_form() throws Throwable {
		   createPartnership.Enteraboutpartnership();
		}

		@When("^I select authority \"(.*?)\"$")
		public void i_select_authority(String arg1) throws Throwable {
			createPartnership.select_radio_button_by_text(arg1);
		    
		}

		@When("^I select partnership type \"(.*?)\"$")
		public void i_select_partnership_type(String arg1) throws Throwable {
			createPartnership.select_radio_button_by_text(arg1);
			Thread.sleep(4000);
			createPartnership.click_continue();
		}
		
		@When("^I click continue$")
		public void i_click_continue() throws Throwable {
		   createPartnership.click_continue();
		}
		
		@When("^I fill in partnership details$")
		public void i_fill_in_partnership_details() throws Throwable {
		   createPartnership.click_confirm_checkbox();
		   createPartnership.fill_in_partnership_details();
		   createPartnership.fill_org_mem_details();
		}

	}


