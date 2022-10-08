package ms.app.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import ms.app.qa.base.TestBase;

public class DashboardPage extends TestBase{


	//@FindBy(css = "span.sc-cWPeQZ.cJgGMJ")
	@FindBy(xpath = "//a[@data-e2e-id='sidebar_my-jobs-btn']")
	WebElement MyJobs;
	
	@FindBy(xpath = "//span[text()='My schedules']")
	WebElement MySchedule;
	
	@FindBy(xpath = "//span[text()='My work times']")
	WebElement MyWorkTime;
	
	@FindBy(xpath = "//span[text()='Settings']")
	WebElement Settings;
	
	@FindBy(xpath = "//span[@class='sc-cWPeQZ jMewSq' and text()='Einstellungen']")////span[text()='Einstellungen']
	WebElement SettingsGr;
	
	@FindBy(css = "div.sc-ezDxBL.iffjTl")
	WebElement LanguageEnButton;

	public DashboardPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	public MyJobsPage ClickOnMyJobs() {
		//Actions action = new Actions(driver);
		//action.moveToElement(MyJobs).build().perform();		
		MyJobs.click();
		return new MyJobsPage();	
	}
	
	public MySchedulePage ClickOnMySchedule() {
		MySchedule.click();
		return new MySchedulePage();	
	}
	
	public MyWorkTimesPage ClickOnMyWorkTime() {
		MyWorkTime.click();
		return new MyWorkTimesPage();
	}
	
	public SettingsPage ClickOnSettings() {
		Settings.click();
		return new SettingsPage();
	}
	
	public void ChangeLangToEn() {
	
		LanguageEnButton.click();
	}
	
	public void ClickOnSettingsGr() {
		
		SettingsGr.click();
	}	
}

