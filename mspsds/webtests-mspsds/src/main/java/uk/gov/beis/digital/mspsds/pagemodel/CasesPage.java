package uk.gov.beis.digital.mspsds.pagemodel;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import src.main.java.uk.gov.beis.digital.BasePage;
import uk.gov.beis.digital.mspsds.Utils.AppProperties;

public class CasesPage extends BasePage {
	String env = AppProperties.get("envurl");
	By team_elements = By.cssSelector("#govuk-radios__item");
	
	
	public CasesPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void open_case_page()
	{
	this.got_to(env+"casses");
	}
	
	public void open_case(String case_title)
	{
		this.open_case(case_title);
	}
	
}
