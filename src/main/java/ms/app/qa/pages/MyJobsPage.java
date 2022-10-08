package ms.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ms.app.qa.base.TestBase;

public class MyJobsPage extends TestBase{

	@FindBy(css = "h2.sc-jlsrNB.sc-JEhMO.imGdKi.cgfCuF")
	WebElement MyJobsList;
	
	@FindBy(css = ".sc-faUpoM.dxbtRW[title='Info']")
	WebElement InfoTab;
	
	@FindBy(css = ".sc-faUpoM.dxbtRW[title='Appointments']")
	WebElement AppoinmentsTab;
	
	@FindBy(css = ".sc-jcFjpl.Pyuvo")
	WebElement EditButton;
	
	@FindBy(css = ".ql-editor")
	WebElement DescriptionTextField;
	
	@FindBy(css = ".sc-crHmcD.kIAgbw.sc-bkkeKt.gAqCbJ")
	WebElement SaveButton;

	//@FindBy(xpath = "//div[@id='status']")// //input[@name='status']
	@FindBy(css = ".sc-fGoOlv.chNLCW.react-select-container.css-2b097c-container > .sc-eBTqsU.gNXyCp.react-select__control.css-yk16xz-control > .react-select__indicators.css-1wy0on6 > .react-select__indicator.react-select__dropdown-indicator.css-tlfecz-indicatorContainer > .css-8mmkcg")
	WebElement StatusSelector;
	
	@FindBy(xpath = "//div[contains(text(),'Geplant')]")
	WebElement StatusGeplant;
	
	@FindBy(xpath = "//div[contains(text(),'Ungeplant')]")
	WebElement StatusUngeplant;
	
	@FindBy(xpath = "//div[contains(text(),'Fertig')]")
	WebElement StatusFertig;
	
	@FindBy(xpath = "//div[contains(text(),'Anfrage')]")
	WebElement StatusAnfrage;
	
	@FindBy(css = ".sc-fGoOlv.chNLCW.react-select-container.css-2b097c-container > .sc-eBTqsU.gNXyCp.react-select__control.css-yk16xz-control > .react-select__value-container.react-select__value-container--has-value.css-1hwfws3 > .react-select__single-value.css-1uccc91-singleValue")
	WebElement StatusInfo;
	
	@FindBy(xpath = "//div[contains(text(),'Description')]")
	WebElement DescriptionShown;
	
	public MyJobsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	public void ClickOnInfoTab() {
		InfoTab.click();
	}
	
	public void ClickOnAppoinmentsTab() {
		AppoinmentsTab.click();
	}
	
	public void ClickOnEditButton() {
		EditButton.click();
	}
	
	public void ClickOnSaveButton() {
		SaveButton.click();
	}
	
	public void ClickOnJobList(int index) {
		
		MyJobsList.click();
	}
	
	public void ChangeStatus(String title) throws InterruptedException {
		
		//Select select = new Select(StatusSelector);
		//select.selectByVisibleText(title);
		StatusSelector.click();
		Thread.sleep(1000);
		switch (title) {
		case "Geplant":
			StatusGeplant.click();
			break;
		case "Ungeplant":
			StatusUngeplant.click();
			break;
		case "Fertig":
			StatusFertig.click();
			break;
		case "Anfrage":
			StatusAnfrage.click();
			break;	
		}
	}
	
	public String GetStatus() {
		
		return StatusInfo.getText();
	}
	
	public void SetNewDescription(String description) {
		DescriptionTextField.clear();
		DescriptionTextField.sendKeys(description);
	}
	
	public String GetDescriptionShown() {
		
		return DescriptionShown.getText();
	}
}
