package ms.app.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ms.app.qa.base.TestBase;

public class MyWorkTimesPage extends TestBase{

	@FindBy(xpath = "//div[@class='sc-fkqipX gRsVIs' and text()='Work day']")
	WebElement WorkDayButton;
	
	@FindBy(xpath = "//div[@class='sc-fkqipX sc-brSHfi gRsVIs iFYcQM' and text()='Break']")
	WebElement BreaksButton;
	
	@FindBy(xpath = "//a[text()='Edit']")
	WebElement EditButton;
	
	@FindBy(xpath = "//a[text()='Save']")
	WebElement SaveButton;
	
	@FindBy(xpath = "//span[@class='sc-eEvSnX dOOEGe' and text()='15']")
	WebElement BreakTime15ButtonList;
	
	@FindBy(xpath = "//input[@id='morning_break_manual']")
	WebElement MorningBreakTimeManual;
	
	@FindBy(xpath = "//input[@id='lunch_break_manual']")
	WebElement LunchBreakTimeManual;
	
	@FindBy(xpath = "//input[@id='other_break_manual']")
	WebElement OtherBreakTimeManual;
	
	@FindBy(xpath = "//input[@name='endAt']")
	WebElement EndTimeField;
	
	@FindBy(css = ".sc-fmBtrw.sc-fkpkvu.fzVYKd.gNbMTu")
	WebElement CalculatedDurationField;
	
	@FindBy(css = ".sc-dOkGYn.pbNGh")
	WebElement CalculatedTimesList;
	//Work day = CalculatedTimesList[0]
	//Work time = CalculatedTimesList[1]
	//Breaks = CalculatedTimesList[2]
	
	public MyWorkTimesPage() {
		PageFactory.initElements(driver,this);
	}
}
