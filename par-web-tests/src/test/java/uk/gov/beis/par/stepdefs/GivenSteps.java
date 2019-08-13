package uk.gov.beis.par.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import uk.gov.beis.par.pagemodel.LoginPage;

public class GivenSteps extends SharedWebDriver
{
	
	private WebDriver driver;
	LoginPage loginPage;
	
	
 public GivenSteps(SharedWebDriver driver) {
	 this.driver = driver;
	 loginPage = PageFactory.initElements(driver, LoginPage.class);
 }
	 
	
		
		@Given("^I login as \"(.*?)\"$")
		public void i_login_as(String arg1) throws Throwable {
			loginPage.login_as(arg1,"TestPassword");
			
		   
		}

		@Then("^I should be able to see \"(.*?)\"$")
		public void i_should_be_able_to_see(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}



	}


