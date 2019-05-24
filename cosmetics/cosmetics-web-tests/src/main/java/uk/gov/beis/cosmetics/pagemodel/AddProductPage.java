package uk.gov.beis.cosmetics.pagemodel;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import uk.gov.beis.digital.*;


public class AddProductPage extends BasePage {
	private  WebDriver driver;
	
	public AddProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
	}

	
	By ele_fileupload = By.xpath("//input[@multiple='multiple'][contains(@id,'files')]");
	By upload_button = By.xpath("//input[contains(@type,'submit')]");
	By login_button = By.cssSelector("#kc-login");
	By signOut_link = By.xpath("//a[contains(text(),'Sign out')]");
	By signIn_link = By.xpath("//a[text()='Sign in']");
	By reason_error = By.xpath("(//td[contains(@class,'govuk-table__cell')])[2]");
	By notification_check_status = By.xpath("//a[contains(.,'Refresh the browser to see uploaded products')]");
	By dismiss_error = By.xpath("(//input[@type='submit'])[2]");
	By page_header = By.xpath("//h1[@class='govuk-fieldset__heading']");
	By prod_name = By.xpath("//input[contains(@type,'text')]");
	By prod_import_country = By.xpath("//input[@id='location-autocomplete']");
	By prod_category = By.id("component_sub_sub_category");
	By frame_formulation = By.id("component_frame_formulation");
	By prod_UK_register = By.xpath("//div[@class='product']");
	By prod_reference_field = By.xpath("//input[@id='notification_industry_reference']");
	//By trigger_rule_summary_error = By.xpath("//a[contains(text(),'No substance added')]");
	By trigger_rule_question_1 = By.cssSelector("#trigger_question_trigger_question_elements_attributes_0_answer");
	By trigger_rule_question_2 = By.cssSelector("#trigger_question_trigger_question_elements_attributes_1_answer");
	
	By trigger_rule_question_header = By.xpath("//h1[@class='govuk-fieldset__heading']");
	
	public void login_as(String user,String pwd) throws InterruptedException
	{
	  this.click(signIn_link);
	  this.click(login_button);
	  assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
	  
	}
	
	
	
	public void enter_productname(String name)
	{
		this.type(prod_name, name);
		this.click_continue();
	}
	
	public void enter_trigger_rule1(String text)
	{
		this.type(trigger_rule_question_1, text);
	}
	
	public void enter_trigger_rule2(String text)
	{
		this.type(trigger_rule_question_2, text);
		
	}
	public void enter_reference_number(String refer_numb)
	{
		
		this.select_radio_button_by_text("Yes, add an internal reference");
		this.type(prod_reference_field,refer_numb);
		this.click_continue();
		
		
	}
	
	public void enter_country_imported_from(String country)
	{
		this.type(prod_import_country,country);
		find(prod_import_country).sendKeys(Keys.ENTER);
	}
	public void select_frame_formulation(String formulation)
	{
		this.type(frame_formulation, "Skin");
		find(frame_formulation).sendKeys(Keys.ENTER);
	}
	
	public void Is_trigger_rule_displayed() throws InterruptedException
	{
		this.IsElementDisplayed(trigger_rule_question_header);
	}
	
	public void Is_trigger_rule_question_displayed() throws InterruptedException
	{
		this.IsElementDisplayed(trigger_rule_question_1);
	}
	
	public void select_prod_category(String cat)
	{
		this.select_radio_button_by_text("Skin products");
		this.click_continue();
		this.select_radio_button_by_text("Skin care products");
		this.click_continue();
		this.select_radio_button_by_text("Hand care products");
		this.click_continue();
		
	}
	
	public boolean verify_cosmetic_page_header1(String title)
	   {

			boolean flag= false;
			if(driver.findElement(page_header).getText().equals(title))
			return flag=true;
			else 
			{
				return flag=false;
			}
	   }
	
	public void add_notification_file(String file) throws InterruptedException
	{
		this.file_upload(ele_fileupload,file);
		click(upload_button);
		Thread.sleep(3000);
	}
	
	public void add_product_manually() throws InterruptedException
	{
		Thread.sleep(3000);  
		this.click_by_text("Add cosmetic products");
		  this.select_radio_button_by_text("No, they have not been notified in the EU");
		  this.click_continue();
	      this.select_radio_button_by_text("No");
	      this.click_continue();
	      this.enter_productname("TestManual-Prod");
	      this.enter_reference_number("TestRef-2003");
	      this.select_radio_button_by_text("Yes");
		  this.click_continue();
	      this.enter_country_imported_from("India");
	      this.click_continue();
	      this.select_radio_button_by_text("The cosmetic product is a single item");
	      this.click_continue();
	      this.select_radio_button_by_text("No");
	      this.click_continue();
	      this.select_radio_button_by_text("Loose powder");
	      this.click_continue();
	      this.click_continue();
	      this.select_radio_button_by_text("No");
	      this.click_continue();
	      this.select_prod_category("Skin care products - Hand care products");
	      this.select_radio_button_by_text("Choose a predefined frame formulation");
	      this.click_continue();  
	}
	
	public void verify_trigger_rule_error(String error)
	{
	   By trigger_rule_summary_error = By.xpath("//a[contains(text(),'"+error+"')]");
		assertTrue(this.getText(trigger_rule_summary_error).equals(error));
	}
	
	public void validate_notification_error(String error)
	{
		
		if(driver.getPageSource().contains("Refresh the browser to see uploaded products"))
		{
		this.click(notification_check_status);
		}
		System.out.println(this.getText(reason_error));
		assertTrue(this.getText(reason_error).contains(error));
		this.click(dismiss_error);
	}
	
}
