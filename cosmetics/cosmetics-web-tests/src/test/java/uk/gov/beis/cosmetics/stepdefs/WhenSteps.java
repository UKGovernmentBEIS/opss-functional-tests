package uk.gov.beis.cosmetics.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.gov.beis.cosmetics.pagemodel.AddProductPage;
import uk.gov.beis.cosmetics.pagemodel.LoginPage;

public class WhenSteps extends SharedWebDriver {
	private static WebDriver driver;
	LoginPage loginPge;
	AddProductPage addProd;
	String env = System.getenv("COSMETICS_URL");

	public WhenSteps(SharedWebDriver driver) {
		this.driver = driver;
		loginPge = PageFactory.initElements(driver, LoginPage.class);
		addProd = PageFactory.initElements(driver, AddProductPage.class);

	}
	@When("^I enter internal reference number \"(.*?)\"$")
	public void i_enter_internal_reference_number(String arg1) throws Throwable {
		addProd.enter_reference_number(arg1);
	    
	}
	
	@When("^I select physical form as \"(.*?)\"$")
	public void i_select_physical_form_as(String arg1) throws Throwable {
	    addProd.select_radio_button_by_text(arg1);
	    addProd.click_continue();
	}
	@When("^I click on continue$")
	public void i_click_on_continue() throws Throwable {
	    addProd.click_continue();
	}
	
	@When("^I notify product manually$")
	public void i_notify_product_manually() throws Throwable {
		  loginPge.click_by_text("Add cosmetic products");
		  addProd.select_radio_button_by_text("No, they have not been notified in the EU");
		  addProd.click_continue();
	      addProd.select_radio_button_by_text("No");
	      addProd.click_continue();
	      addProd.enter_productname("TestManual-Prod");
	      addProd.enter_reference_number("TestRef-2003");
	      addProd.select_radio_button_by_text("Yes");
		  addProd.click_continue();
	      addProd.enter_country_imported_from("India");
	      addProd.click_continue();
	      addProd.select_radio_button_by_text("The cosmetic product is a single item");
	      addProd.click_continue();
	      addProd.select_radio_button_by_text("No");
	      addProd.click_continue();
	      addProd.select_radio_button_by_text("Loose powder");
	      addProd.click_continue();
	      addProd.click_continue();
	      addProd.select_radio_button_by_text("No");
	      addProd.click_continue();
	      addProd.select_prod_category("Skin care products - Hand care products");
	      addProd.select_radio_button_by_text("Choose a predefined frame formulation");
	      addProd.click_continue();
	      
	      
	}
	
	@When("^I choose frame formulation$")
	public void i_choose_frame_formulation() throws Throwable {
		addProd.select_frame_formulation("Skin Care Cream, Lotion, Gel");
	    addProd.click_continue();   
	    
	}
	
	@Then("^I should see trigger rule question \"(.*?)\"$")
	public void i_should_see_trigger_rule_question(String arg1) throws Throwable {
	   addProd.verify_cosmetics_trigger_rules_question(arg1);
	}

	@Then("^I should be asked if the product contains anti-dandruff agents$")
	public void i_should_be_asked_if_the_product_contains_anti_dandruff_agents() throws Throwable {
		
	   
	}
}
