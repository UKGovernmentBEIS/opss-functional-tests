package uk.gov.beis.par.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uk.gov.beis.digital.BasePage;
import uk.gov.beis.par.Utils.AppProperties;

import static org.junit.Assert.assertTrue;

public class SearchPartnershipPage extends BasePage {

	private WebDriver driver;

	
	private By search_field =  By.cssSelector("#edit-keywords");
	private By search_button = By.cssSelector("#edit-submit-partnership-search");
	
	public SearchPartnershipPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
 public void search_by_keyword(String text)
 {
	 this.type(search_field,text);
	 this.click(search_button);
	 
 }
 
 public void search_results(String text)
 {
	 assertTrue("Failed: didnt find the partnership with keyword search",this.driver.getPageSource().contains(text));
 }
	
}
