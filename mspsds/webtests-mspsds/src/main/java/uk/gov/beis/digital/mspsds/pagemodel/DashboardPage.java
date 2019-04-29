package uk.gov.beis.digital.mspsds.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import src.main.java.uk.gov.beis.digital.BasePage;

import static org.junit.Assert.assertTrue;



public class DashboardPage extends BasePage {
	private WebDriver driver;
	By tab_case = By.xpath("//a[contains(.,'Cases')]");
	By tab_product = By.xpath("//a[contains(.,'Products')]");
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
 public void  verify_tabs(String tab) throws InterruptedException
 {
	 assertTrue("Failed:"+tab+"not displayed check manually",this.verify_element_by_text(tab));
 }

 public void Verify_tab_info(String tab){
	 assertTrue("Failed:"+tab+"not displayed check manually",this.verify_element_by_text(tab));
	 this.click_by_text(tab);
	 assertTrue("Failed:"+tab+"not displayed check manually",this.verify_element_by_text(tab));	 
	 
 }

 public void verify_dashboard() throws InterruptedException
 {
	 this.IsElementDisplayed(tab_case);
 }


	
	
	
}
