package uk.gov.beis.cosmetics.pagemodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class AddProductPage extends BasePage {
	private  WebDriver driver;
	
	public AddProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
	}

	
	By ele_fileupload = By.id("notification_file_uploaded_file");
	By upload_button = By.xpath("//input[contains(@type,'submit')]");
	By login_button = By.cssSelector("#kc-login");
	By signOut_link = By.xpath("//a[contains(text(),'Sign out')]");
	By signIn_link = By.xpath("//a[text()='Sign in']");
	
	public void login_as(String user,String pwd) throws InterruptedException
	{
	  this.click(signIn_link);
	  this.click(login_button);
	  assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
	  
	}
	
	public void add_notification_file(String file) throws InterruptedException
	{
		this.file_upload(ele_fileupload, file);
		click(upload_button);
		Thread.sleep(3000);
	}
	
}
