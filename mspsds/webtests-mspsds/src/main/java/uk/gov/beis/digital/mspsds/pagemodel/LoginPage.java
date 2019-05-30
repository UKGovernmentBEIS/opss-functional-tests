package uk.gov.beis.digital.mspsds.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.gov.beis.digital.BasePage;
import uk.gov.beis.digital.mspsds.Utils.EnvironmentProperties;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	private By usernameField = By.cssSelector("#username");
	private By passwordField = By.cssSelector("#password");
	private By loginButton = By.cssSelector("#kc-login");
	private By signInLink = By.xpath("//a[text()='Sign in']");
	private By signOutLink = By.xpath("//a[contains(text(),'Sign out')]");

	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	public void login_as(String username, String password) throws InterruptedException
	{
		if (this.IsElementDisplayed(signOutLink)) {
			this.click(signOutLink);
		}

		this.type(usernameField, username);
		this.type(passwordField, password);
		this.click(loginButton);
		Thread.sleep(4000);

		assertTrue("Failed to sign in", this.IsElementDisplayed(signOutLink));
	}

	public void login_as_opss() throws InterruptedException
	{
		login_as(EnvironmentProperties.getOpssUsername(), EnvironmentProperties.getOpssPassword());
	}

	public void login_as_ts() throws InterruptedException
	{
		login_as(EnvironmentProperties.getTradingStandardsUsername(), EnvironmentProperties.getTradingStandardsPassword());
	}

	public void log_out()
	{
		if (driver.getPageSource().contains("Sign out")) {
			this.click(signOutLink);
		}
	}
}
