package uk.gov.beis.cosmetics.pagemodel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import src.main.java.uk.gov.beis.digital.*;


public class AddProductPage extends BasePage {
	private  WebDriver driver;
	
	public AddProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
	}

	
	By ele_fileupload = By.xpath("//input[@multiple='multiple'][contains(@id,'files')]");
	By upload_button = By.xpath("//input[contains(@type,'submit')]");
	By login_button = By.cssSelector("#kc-login");
	By signOut_link = By.xpath("//a[contains(text(),'Sign out')]");
	By signIn_link = By.xpath("//a[text()='Sign in']");
	By reason_error = By.xpath("(//td[contains(@class,'govuk-table__cell')])[2]");
	By notification_check_status = By.xpath("//a[contains(.,'Refresh the browser to see uploaded products')]");
	By dismiss_error = By.xpath("(//input[@type='submit'])[2]");
	By page_header = By.xpath("//h1[@class='govuk-fieldset__heading']");
	
	
	public void login_as(String user,String pwd) throws InterruptedException
	{
	  this.click(signIn_link);
	  this.click(login_button);
	  assertTrue("Failed to signIn",this.IsElementDisplayed(signOut_link));
	  
	}
	
	
	public boolean verify_cosmetic_page_header1(String title)
	   {

			boolean flag= false;
			if(driver.findElement(page_header).getText().equals(title))
			return flag=true;
			else 
			{
				return flag=false;
			}
	   }
	
	public void add_notification_file(String file) throws InterruptedException
	{
		this.file_upload(ele_fileupload,file);
		click(upload_button);
		Thread.sleep(3000);
	}
	
	public void validate_notification_error(String error)
	{
		
		if(driver.getPageSource().contains("Refresh the browser to see uploaded products"))
		{
		this.click(notification_check_status);
		}
		System.out.println(this.getText(reason_error));
		assertTrue(this.getText(reason_error).contains(error));
		this.click(dismiss_error);
	}
	
}
