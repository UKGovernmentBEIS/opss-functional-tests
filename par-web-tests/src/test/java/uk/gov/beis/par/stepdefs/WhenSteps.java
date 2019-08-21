package uk.gov.beis.par.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.par.pagemodel.CreatePartnershipPage;
import uk.gov.beis.par.pagemodel.LoginPage;

public class WhenSteps extends SharedWebDriver
{
	
	private WebDriver driver;
	LoginPage loginPage;
	CreatePartnershipPage createPartnership;
	
	
 public WhenSteps(SharedWebDriver driver) {
	 this.driver = driver;
	 loginPage = PageFactory.initElements(driver, LoginPage.class);
	 createPartnership = PageFactory.initElements(driver,CreatePartnershipPage.class);
 }
 @When("^I accept terms and conditions$")
 public void i_accept_terms_and_conditions() throws Throwable {
    createPartnership.confirm_terms_conditions();
     
 }

 @When("^I click on save$")
 public void i_click_on_save() throws Throwable {
	 
	
     
   
 }

 @When("^I click send invite$")
 public void i_click_send_invite() throws Throwable {
     createPartnership.click_continue();
     
 }

 @Then("^I should see \"(.*?)\"$")
 public void i_should_see(String arg1) throws Throwable {
     // Write code here that turns the phrase above into concrete actions
	 createPartnership.verify_par_page_header1(arg1);
	 Thread.sleep(2000);
     
 }

 

	}


