package uk.gov.beis.par.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uk.gov.beis.digital.BasePage;
import uk.gov.beis.par.Utils.AppProperties;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

	private WebDriver driver;

	private By usernameField = By.cssSelector("#edit-name");
	private By passwordField = By.cssSelector("#edit-pass");
	private By loginButton = By.cssSelector("#edit-submit");
	private By signInLink = By.xpath("//a[contains(text(),'Sign in')]");
	private By signOutLink = By.xpath("//a[contains(text(),'Sign out')]");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void login_as(String username, String password) throws InterruptedException {
			this.launch_app(AppProperties.get("envurl"));
		if (this.IsElementDisplayed(signOutLink)) {
			this.click(signOutLink);
		}

		if (this.IsElementDisplayed(signInLink)) {
			this.click(signInLink);
			this.type(usernameField, username);
			this.type(passwordField, "TestPassword");
			this.click(loginButton);
			Thread.sleep(4000);
		}

		assertTrue("Failed to sign in", this.IsElementDisplayed(signOutLink));
	}
	
	
}
