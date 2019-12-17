package uk.gov.beis.digital.mspsds.pagemodel;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import uk.gov.beis.digital.BasePage;
import uk.gov.beis.digital.mspsds.Utils.AppProperties;



public class CasesPage extends BasePage {
	String env = AppProperties.get("envurl");
	private WebDriver driver;
	By team_elements = By.cssSelector("#govuk-radios__item");
	By cont_name = By.xpath("//input[@name='complainant[name]']");
	By cont_phone = By.xpath("//input[@id='complainant_phone_number']");
	By cont_email = By.xpath("//input[@id='complainant_email_address'])");
	By Continue = By.xpath("//input[@value='Continue']");
	
	// Allegation details Page Elements
	By AllegationDetail = By.xpath("//textarea[@id='allegation_description']");
	By Prod_Category = By.cssSelector("#allegation_product_category");
	By Hazard_type = By.cssSelector("#allegation_hazard_type");
	By create_allegation = By.xpath("//input[@value='Create allegation']");
	By ts_case_page = By.xpath("//h1[@class='govuk-heading-l']");
	By ts_activity = By.xpath("//a[@id='Activity_id']");
	By case_add_activity = By.xpath("//a[contains(text(),'Add activity')]");
	By case_comment = By.cssSelector("#comment_activity_body");
	
	
	
	
	public CasesPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		
	}
	
	public void open_case_page()
	{
	this.got_to(env+"casses");
	}
	
	public void verify_on_correct_page(String page_name)
	{
		assertTrue("Failed:not on the correct page",find(this.ts_case_page).getText().contains(page_name));
	}
	
	public void open_case(String case_title)
	{
		this.open_case(case_title);
	}
	
	public void enter_contact_details()
	{
		this.type(cont_name, "AutoTest-Nasir");
		this.click(Continue);
	}
	public void enter_allegation_details(String prod_cat,String hazard_type) throws InterruptedException
	{
		this.type(AllegationDetail, "Auto-Test-allegation");
		this.type(Prod_Category,"Baby/Children's Products");
		driver.findElement(By.cssSelector("#allegation_product_category")).sendKeys(Keys.RETURN);
		
		Thread.sleep(2000);
		this.type(Hazard_type,"Asphyxiation");
		driver.findElement(By.cssSelector("#allegation_hazard_type")).sendKeys(Keys.RETURN);
		this.click(create_allegation);
		Thread.sleep(3000);
	}
	
	public void select_allegation_prod_cat(String category) throws InterruptedException{
		this.type(AllegationDetail, "Auto-Test-allegation");
		this.type(Prod_Category,category);
		driver.findElement(By.cssSelector("#allegation_product_category")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		
	}
	
	public void open_a_case(String case_title)
	{
		this.click_by_text("Your cases");
		this.click_by_text(case_title);
	}
	
	
	public void select_hazard_type(String type) throws InterruptedException{
		this.type(Hazard_type,type);
		driver.findElement(By.cssSelector("#allegation_hazard_type")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		this.click(create_allegation);
		
	}
	
	public void add_comment_activity() throws InterruptedException
	{
		this.click(this.ts_activity);
		this.click(this.case_add_activity);
		this.select_radio_button_by_text("Add a comment");
		this.click_continue();
		this.type(this.case_comment,"Automated test-comment1");
		this.click_continue();
		Thread.sleep(2000);
		this.verify_banner_message("Comment was successfully added.");	
		
	}
}
