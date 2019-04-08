package uk.gov.beis.digital.mspsds.pagemodel;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import src.main.java.uk.gov.beis.digital.BasePage;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	By UserNameFld = By.cssSelector("#username");
	By PasswordFld = By.cssSelector("#password");
	By login_button = By.cssSelector("#kc-login");
	By signOut_link = By.xpath("//input[@value='Sign out']");
	By signIn_link = By.xpath("//a[text()='Sign in']");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	public void login_user(DataTable login_details) throws InterruptedException
	{
		List<List<String>> data = login_details.raw();
		//this.click(signIn_link);
		if(!driver.getPageSource().contains("Sign out"))
		{
		this.type(UserNameFld,data.get(0).get(0));
		this.type(PasswordFld,data.get(0).get(1));
		this.click(login_button);
		Thread.sleep(4000);
		assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
		}
		
	}
}
