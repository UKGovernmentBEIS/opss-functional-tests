package uk.gov.beis.digital.mspsds.pagemodel;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import src.main.java.uk.gov.beis.digital.BasePage;
import static org.junit.Assert.assertTrue;

public class AssigneePage extends BasePage {
	By team_elements = By.xpath("//label[contains(@class,'label')]");
	By change_assign = By.xpath("(//a[contains(.,'Change')])[2]");
	
	public AssigneePage(WebDriver driver) {
		super(driver);
		
	}
	
	public void click_change_assign()
	{
		this.click(change_assign);
	}
	
	
public void verify_priority_team(DataTable team_list)
{
	List<List<String>> list = team_list.raw();
	assertTrue("Failed:team not found",this.getText(team_elements).contains(list.get(0).get(1)));
	assertTrue("Failed:team not found",this.getText(team_elements).contains(list.get(0).get(2)));
	assertTrue("Failed:team not found",this.getText(team_elements).contains(list.get(0).get(3)));
}
	

//	public void verify_priority_team_list(DataTable team_list) throws InterruptedException
//	{
//		List<List<String>> list = team_list.raw();
//			for(int j=0;j<=list.size();j++)
//			{
//				Thread.sleep(3000);
//				System.out.println(this.getText(team));
//				
//			    assertTrue("Failed:Expected team not displayed",this.getText(team).contains(list.get(j).toString()));
//			}	
//	}
	
	
//	public Boolean verify_priority_team_list(DataTable team_list) throws Exception
//	{
//		Boolean flag=false;
//		List<List<String>> list = team_list.raw();
//		
//		List<WebElement> team = this.findelements(team_elements);
//		do {
//			Iterator<WebElement> iter = team.iterator();
//			team = findelements(team_elements);
//			WebElement team_name = iter.next();
//			for(int j=0;j<list.get(0).size();j++)
//			{
//			if(team_name.getText().equals(list.get(0).get(j)))
//			{
//				flag=true;
//				break;
//			}
//			}
//		}	
//		while (team.size() >= 1);
//		return flag;
//}

	}