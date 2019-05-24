package uk.gov.beis.cosmetics.pagemodel;
import uk.gov.beis.cosmetics.Utils.AppProperties;
import uk.gov.beis.digital.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;

import static org.junit.Assert.assertTrue;

import java.util.List;

public class LoginPage extends BasePage {
	private  WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
	}

	By UserNameFld = By.cssSelector("#username");
	By PasswordFld = By.cssSelector("#password");
	By login_button = By.cssSelector("#kc-login");
	By signOut_link = By.xpath("//a[contains(.,'Sign out')]");
	By signIn_link = By.xpath("//a[text()='Sign in']");
	//By signOut_link = By.xpath("//a[text()='Sign out']");
	
	public void login_as(String user,String pwd) throws InterruptedException
	{
	  if(this.IsElementDisplayed(signIn_link))
		  {
	  this.click(signIn_link);
	  this.type(UserNameFld,user);
	  this.type(PasswordFld, pwd);
	  this.click(login_button);
	  assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
		  }
	}
	
	public void login_user() throws InterruptedException
	{
		if(driver.getPageSource().contains("Sign in"))
		{
			
		this.click(signIn_link);
		this.type(UserNameFld,System.getenv("RP_ACCOUNT_USERNAME"));
		this.type(PasswordFld,System.getenv("RP_ACCOUNT_PASSWORD"));
		this.click(login_button);
		Thread.sleep(4000);
		assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
		  }
	}
	
}
