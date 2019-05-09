package uk.gov.beis.digital.mspsds.pagemodel;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import uk.gov.beis.digital.BasePage;



public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	By UserNameFld = By.cssSelector("#username");
	By PasswordFld = By.cssSelector("#password");
	By login_button = By.cssSelector("#kc-login");
	By signOut_link = By.xpath("//a[contains(text(),'Sign out')]");
	By signIn_link = By.xpath("//a[text()='Sign in']");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	public void log_out()
	{
		if(driver.getPageSource().contains("Sign out"))
		{
			this.click(signOut_link);
		}
		
	}
	
	public void login_as_opss() throws InterruptedException
	{
		
		//this.click(signIn_link);
		if(driver.getPageSource().contains("Home"))
		{
		this.click(signOut_link);
		Thread.sleep(2000);
		this.type(UserNameFld,System.getenv("PSD_OPSS_USERNAME"));
		this.type(PasswordFld,System.getenv("PSD_OPSS_PASSWORD"));
		this.click(login_button);
		Thread.sleep(4000);
		assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
		}
		else if(driver.getPageSource().contains("Email address")){
			this.type(UserNameFld,System.getenv("PSD_OPSS_USERNAME"));
			this.type(PasswordFld,System.getenv("PSD_OPSS_PASSWORD"));
		this.click(login_button);
		Thread.sleep(4000);
		assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
		}
	
	}
	
	public void login_as_ts() throws InterruptedException
	{
		
		//this.click(signIn_link);
		if(!driver.getPageSource().contains("Home"))
		{
		this.click(signOut_link);
		Thread.sleep(2000);
		this.type(UserNameFld,System.getenv("PSD_TS_USERNAME"));
		this.type(PasswordFld,System.getenv("PSD_TS_PASSWORD"));
		this.click(login_button);
		Thread.sleep(4000);
		assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
		}
		else{
			this.type(UserNameFld,System.getenv("PSD_TS_USERNAME"));
			this.type(PasswordFld,System.getenv("PSD_TS_PASSWORD"));
		this.click(login_button);
		Thread.sleep(4000);
		assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
		}
		
		}

	}

