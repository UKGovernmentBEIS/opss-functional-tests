package uk.gov.beis.digital.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.digital.mspsds.pagemodel.AddProductPage;
import uk.gov.beis.digital.mspsds.pagemodel.CasesPage;
import uk.gov.beis.digital.mspsds.pagemodel.DashboardPage;
import uk.gov.beis.digital.mspsds.pagemodel.LoginPage;

public class WhenSteps extends SharedWebDriver{
	
	private WebDriver driver;
	DashboardPage dashpge;
	CasesPage casepge;
	private LoginPage loginPage;
	private AddProductPage addProductPage;
	public WhenSteps(SharedWebDriver driver)
	{
		this.driver = driver;
		dashpge = PageFactory.initElements(driver, DashboardPage.class);
		casepge = PageFactory.initElements(driver, CasesPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		addProductPage = PageFactory.initElements(driver, AddProductPage.class);
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

	
	@When("^I click button \"(.*?)\"$")
	public void i_click_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    dashpge.click_by_text(arg1);
	}

	@When("^I select case type \"(.*?)\"$")
	public void i_select_case_type(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		dashpge.select_radio_button_by_text(arg1);
	   Thread.sleep(2000);
	   dashpge.click_continue();
	}

	@When("^I select reporter as \"(.*?)\"$")
	public void i_select_reporter_as(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		dashpge.select_radio_button_by_text(arg1);
		dashpge.click_continue();
	}

	@When("^I enter contact details$")
	public void i_enter_contact_details() throws Throwable {
		casepge.enter_contact_details();
	    
	    
	}

	@When("^I enter allegation details$")
	public void i_enter_allegation_details() throws Throwable {
		casepge.enter_allegation_details("",""); 
	    
	}

	@Then("^I should see \"(.*?)\"$")
	public void i_should_see(String arg1) throws Throwable {
		casepge.verify_banner_message(arg1);
	   
	}

	@When("^I enter allegation details for product category \"(.*?)\"$")
	public void i_enter_allegation_details_for_product_category(String arg1) throws Throwable {
		casepge.select_allegation_prod_cat(arg1);
	}

	@When("^I enter hazard type as \"(.*?)\"$")
	public void i_enter_hazard_type_as(String arg1) throws Throwable {
		casepge.select_hazard_type(arg1);
	}
	@When("^I click add user$")
	public void i_click_add_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.add_user();
	    
	}

	@When("^I enter testuser(\\d+)@test\\.com$")
	public void i_enter_testuser_test_com(String arg1) throws Throwable {
	   loginPage.enter_username(arg1);
	    
	}

	
	@When("^I click save$")
	public void i_click_save() throws Throwable {
		this.driver.findElement(By.xpath("//div[@class='col-md-10 col-md-offset-2']//button[@class='ng-binding btn btn-primary'][contains(text(),'Save')]")).click();
	    Thread.sleep(3000);   
	}

	@Then("^I should be able to add to Lincolnshire County Council$")
	public void i_should_be_able_to_add_to_Lincolnshire_County_Council() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^I should be able to invite user$")
	public void i_should_be_able_to_invite_user() throws Throwable {
	   loginPage.invite_user();
	   
	}
	
	@When("^I enter username \"(.*?)\"$")
	public void i_enter_username(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    loginPage.enter_username(arg1);
	    loginPage.enter_email(arg1);
	}

	@When("^I enter emnail \"(.*?)\"$")
	public void i_enter_emnail(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    loginPage.enter_email(arg1);
	}

	@Then("^I should be able to add to \"(.*?)\"$")
	public void i_should_be_able_to_add_to(String arg1) throws Throwable {
		loginPage.add_user_to_group(arg1);
		
	    
	}
	
	@Then("^I select role as team_admin$")
	public void i_select_role_as_team_admin() throws Throwable {
		loginPage.select_user_role("team_admin"); 
	}
	
	@Then("^I select role as \"(.*?)\"$")
	public void i_select_role_as(String arg1) throws Throwable {
	   loginPage.select_user_role(arg1);
	}

	@When("^I go to groups$")
	public void i_go_to_groups() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   loginPage.go_to_groups(); 
	}

	@When("^I click new$")
	public void i_click_new() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^I should be able to create new group \"(.*?)\"$")
	public void i_should_be_able_to_create_new_group(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.add_group(arg1);
	   
	}

	@Then("^I should be abel to create new team \"(.*?)\"$")
	public void i_should_be_abel_to_create_new_team(String arg1) throws Throwable {
	    loginPage.add_team_name(arg1);
	    
	}

	@Then("^I add group email box \"(.*?)\"$")
	public void i_add_group_email_box(String arg1) throws Throwable {
	   loginPage.add_team_mail_box(arg1);
	    
	}
	
	
	
	@When("^I enter product details for product category \"(.*?)\"$")
	public void i_enter_product_details_for_product_category(String arg1) throws Throwable {
	   addProductPage.enter_product_details(arg1);
	}



@When("^I enter product name$")
public void i_enter_product_name() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^I enter description of the product \"(.*?)\"$")
public void i_enter_description_of_the_product(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^I click continue$")
public void i_click_continue() throws Throwable {
   addProductPage.click_continue();
   Thread.sleep(2000);
}

@When("^I select compliance type \"(.*?)\"$")
public void i_select_compliance_type(String arg1) throws Throwable {
   addProductPage.select_compliance(arg1);
}

@When("^I enter hazard details \"(.*?)\"$")
public void i_enter_hazard_details(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^I select which parts of chain do you know as \"(.*?)\"$")
public void i_select_which_parts_of_chain_do_you_know_as(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    addProductPage.select_radio_button_by_text(arg1);
    Thread.sleep(2000);
}

@When("^I click on continue$")
public void i_click_on_continue() throws Throwable {
    
}

@When("^I enter business tradign name \"(.*?)\"$")
public void i_enter_business_tradign_name(String arg1) throws Throwable {
    addProductPage.enter_retailer_business(arg1);
}

@When("^I enter legal name \"(.*?)\"$")
public void i_enter_legal_name(String arg1) throws Throwable {
    
}

@When("^I select corrective action \"(.*?)\"$")
public void i_select_corrective_action(String arg1) throws Throwable {
    addProductPage.select_radio_button_by_text(arg1);
}

@When("^I click \"(.*?)\"$")
public void i_click(String arg1) throws Throwable {
	addProductPage.select_radio_button_by_text(arg1); 
}

@When("^I click create case$")
public void i_click_create_case() throws Throwable {
addProductPage.create_case();   

}



@When("^I go to activity log$")
public void i_go_to_activity_log() throws Throwable {
    
}

@Then("^I should be able to add activity \"(.*?)\"$")
public void i_should_be_able_to_add_activity(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
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
