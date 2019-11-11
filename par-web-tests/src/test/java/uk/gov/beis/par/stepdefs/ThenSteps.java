package uk.gov.beis.par.stepdefs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.par.pagemodel.CreatePartnershipPage;
import uk.gov.beis.par.pagemodel.LoginPage;
import uk.gov.beis.par.pagemodel.SearchPartnershipPage;

public class ThenSteps extends SharedWebDriver
{
	
	private WebDriver driver;
	LoginPage loginPage;
	CreatePartnershipPage createPartnership;
	SearchPartnershipPage searchPartnerships;
	
	
 public ThenSteps(SharedWebDriver driver) {
	 this.driver = driver;
	 loginPage = PageFactory.initElements(driver, LoginPage.class);
	 createPartnership = PageFactory.initElements(driver,CreatePartnershipPage.class);
	 searchPartnerships = PageFactory.initElements(driver,SearchPartnershipPage.class);
 }
	 
	
 @Then("^I should see partnership creation confirmation \"(.*?)\"$")
 public void i_should_see_partnership_creation_confirmation(String arg1) throws Throwable {
     // Write code here that turns the phrase above into concrete actions
    createPartnership.verify_par_page_header1(arg1);
 }
 
 
 @Then("^I should see \"(.*?)\" page$")
 public void i_should_see_page(String arg1) throws Throwable {
     // Write code here that turns the phrase above into concrete actions
	 createPartnership.verify_par_page_header1(arg1);
 }

 @Then("^I see invite email with the text \"(.*?)\"$")
 public void i_see_invite_email_with_the_text(String arg1) throws Throwable {
     // Write code here that turns the phrase above into concrete actions
	 createPartnership.verify_page_contains(arg1);
	 Thread.sleep(4000);
     
 }
 
 @Then("^I should see \"(.*?)\" link$")
 public void i_should_see_link(String arg1) throws Throwable {
	 
	 createPartnership.verify_element_by_text(arg1);
     
 }
 
 @Then("^I should not see \"(.*?)\" link$")
 public void i_should_not_see_link(String arg1) throws Throwable {
	
 searchPartnerships.Verify_link_not_displayed(arg1);
 }


@Then("^I should see \"(.*?)\" against each authority$")
public void i_should_see_against_each_authority(String arg1) throws Throwable {
    searchPartnerships.verify_element_by_text(arg1);
}
 
@Then("^I should see \"(.*?)\" against each organisation$")
public void i_should_see_against_each_organisation(String arg1) throws Throwable {
    searchPartnerships.verify_element_by_text(arg1);
}


	}


