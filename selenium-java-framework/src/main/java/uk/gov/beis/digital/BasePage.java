package src.main.java.uk.gov.beis.digital;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * @ @author nasirkhan @
 *
 */
public class BasePage {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final int TIMEOUT = 5;
	private static final int POLLING = 50;
	By cases = By.cssSelector("#h1.govuk-heading-xl");

	protected SearchContext getSearchCtx() {
		return driver;
	}

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	public void launch_app(String url) throws InterruptedException {

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public void got_to(String page_url)
	{
		driver.navigate().to(page_url);
	}

	protected void waitForElementToLoad(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement find(By locator) {
		
		return driver.findElement(locator);
		}
		

	public void open_mspsds_case(String title)
	{
		driver.findElement(By.linkText(title)).click();
	   // this.waitForElementToLoad(cases);
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

	public void click_by_text(String text) {
		try {
			driver.findElement(By.xpath("//a[contains(.,'" + text + "')]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void file_upload(By locator, String file) {
		String testFile;
		testFile = System.getProperty("properties",
				System.getProperty("user.dir") + "/src/test/resources/testdata/" + file);
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
