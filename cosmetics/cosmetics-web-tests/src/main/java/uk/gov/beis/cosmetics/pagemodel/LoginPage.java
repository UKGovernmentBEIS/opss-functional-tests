package uk.gov.beis.cosmetics.pagemodel;
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
	By signOut_link = By.xpath("//input[@value='Sign out']");
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
	
	public void login_user(DataTable login_details) throws InterruptedException
	{
		if(driver.getPageSource().contains("Sign in"))
		{
			
		
		List<List<String>> data = login_details.raw();
		this.click(signIn_link);
		this.type(UserNameFld,data.get(0).get(0));
		this.type(PasswordFld,data.get(0).get(1));
		this.click(login_button);
		Thread.sleep(4000);
		assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
		  }
	}
	
}
