package uk.gov.beis.cosmetics.pagemodel;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertTrue;
import uk.gov.beis.cosmetics.Utils.AppProperties;

/**
 * @
 * @author nasirkhan
 * @
 *
 */
public class BasePage {
	private WebDriver driver;
	private String envurl = AppProperties.get("envurl");

	protected SearchContext getSearchCtx() {
		return driver;
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void launch_app() throws InterruptedException {
		driver.get(envurl);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void gotoLogin() {
		driver.navigate().to(envurl + "ui-login/login");
	}

	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findelements(By locator) {
		return driver.findElements(locator);
	}

	public void click(By locator) {
		find(locator).click();
	}

	public void type(By locator, String arg1) {
		find(locator).clear();
		find(locator).sendKeys(arg1);
	}

	public void emptytextbox(By locator) {
		find(locator).clear();
	}

	public String getText(By locator) {
		return find(locator).getText();
	}

	public boolean isTextPresent(By locator, String exp) {
		if (getText(locator).equals(exp)) {

			return true;
		} else {
			return false;
		}
	}

	public void SelectItem(By locator, String Item) {

		Select contentsSelect = new Select(find(locator));
		List<WebElement> options = contentsSelect.getOptions();
		for (WebElement e : options) {
			System.out.println(e.getText());
		}
		// contentsSelect.selectByValue(Item);
		contentsSelect.selectByVisibleText(Item);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void verifyPageTitle(String title) {
		assertTrue("Failed: Expected Page" + title + " did not match to actual  " + driver.getTitle() + "",
				driver.getTitle().equals(title));

	}

	public boolean IsElementPresent(By locator) {
		return findelements(locator).size() > 0;
	}

	public boolean IsElementDisplayed(By locator) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		boolean flag;

		if (find(locator).isDisplayed()) {

			WebElement element = find(locator);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			Thread.sleep(2000);
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	 public void click_by_text(String text)
	 {
		try{
		 driver.findElement(By.xpath("//a[contains(.,'"+text+"')]")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 }
	 
	 
	public void file_upload(By locator,String file)
	{
		String testFile;
		testFile = System.getProperty("properties",System.getProperty("user.dir") + "/src/test/resources/testdata/" + file);
		System.out.println(testFile);
		WebElement uploadElement = this.find(locator);
		uploadElement.sendKeys(testFile);
	}
	 
	public void highlightElements(By locator) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = find(locator);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		Thread.sleep(3000);
	}

}
