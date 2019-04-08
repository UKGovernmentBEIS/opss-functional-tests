package uk.gov.beis.digital.mspsds.pagemodel;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import src.main.java.uk.gov.beis.digital.BasePage;
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
	By Prod_Category = By.id("picker-product_category");
	By Hazard_type = By.xpath("//input[@id='picker-hazard_type']");
	By create_allegation = By.xpath("//input[@value='Create allegation']");
	
	
	
	public CasesPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		
	}
	
	public void open_case_page()
	{
	this.got_to(env+"casses");
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
		driver.findElement(By.id("picker-product_category")).sendKeys(Keys.RETURN);
		
		Thread.sleep(2000);
		this.type(Hazard_type,"Asphyxiation");
		driver.findElement(By.xpath("//input[@id='picker-hazard_type']")).sendKeys(Keys.RETURN);
		this.click(create_allegation);
		Thread.sleep(3000);
	}
	
	public void select_allegation_prod_cat(String category) throws InterruptedException{
		this.type(AllegationDetail, "Auto-Test-allegation");
		this.type(Prod_Category,category);
		driver.findElement(By.id("picker-product_category")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		
	}
	
	
	public void select_hazard_type(String type) throws InterruptedException{
		this.type(Hazard_type,type);
		driver.findElement(By.xpath("//input[@id='picker-hazard_type']")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		this.click(create_allegation);
		
	}
}
