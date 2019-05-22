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

	public void login_as_opss() throws InterruptedException
	{
		if (driver.getPageSource().contains("Home")) {
			this.click(signOutLink);
			Thread.sleep(2000);
		}

		this.type(usernameField, EnvironmentProperties.getOpssUsername());
		this.type(passwordField, EnvironmentProperties.getOpssPassword());
		this.click(loginButton);
		Thread.sleep(4000);

		assertTrue("Failed to sign in", this.IsElementDisplayed(signOutLink));
	}

	public void login_as_ts() throws InterruptedException
	{
		if (!driver.getPageSource().contains("Home")) {
			this.click(signOutLink);
			Thread.sleep(2000);
		}

		this.type(usernameField, EnvironmentProperties.getTradingStandardsUsername());
		this.type(passwordField, EnvironmentProperties.getTradingStandardsPassword());
		this.click(loginButton);
		Thread.sleep(4000);

		assertTrue("Failed to sign in", this.IsElementDisplayed(signOutLink));
	}

	public void log_out()
	{
		if (driver.getPageSource().contains("Sign out")) {
			this.click(signOutLink);
		}
	}
}
