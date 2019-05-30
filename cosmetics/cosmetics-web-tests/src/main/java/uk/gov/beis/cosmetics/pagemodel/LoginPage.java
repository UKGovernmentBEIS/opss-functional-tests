package uk.gov.beis.cosmetics.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uk.gov.beis.cosmetics.Utils.EnvironmentProperties;
import uk.gov.beis.digital.BasePage;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

	private WebDriver driver;

	private By usernameField = By.cssSelector("#username");
	private By passwordField = By.cssSelector("#password");
	private By loginButton = By.cssSelector("#kc-login");
	private By signInLink = By.xpath("//a[text()='Sign in']");
	private By signOutLink = By.xpath("//a[text()='Sign out']");

	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	public void login_as(String username, String password) throws InterruptedException
	{
		if (this.IsElementDisplayed(signInLink)) {
			this.click(signInLink);
			this.type(usernameField, username);
			this.type(passwordField, password);
			this.click(loginButton);
			Thread.sleep(4000);
		}

		assertTrue("Failed to sign in", this.IsElementDisplayed(signOutLink));
	}

	public void login_as_responsible_person() throws InterruptedException
	{
		login_as(EnvironmentProperties.getResponsiblePersonUsername(), EnvironmentProperties.getResponsiblePersonPassword());
	}

	public void login_as_poison_centre() throws InterruptedException
	{
		login_as(EnvironmentProperties.getPoisonCentreUsername(), EnvironmentProperties.getPoisonCentrePassword());
	}
}
