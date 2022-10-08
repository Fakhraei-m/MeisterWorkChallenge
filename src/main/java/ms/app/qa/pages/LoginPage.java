package ms.app.qa.pages;

import ms.app.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.eclips.jetty.

public class LoginPage extends TestBase{

	@FindBy(name= "email") ////input[@name='email']
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath= "//button[@type='submit']")
	WebElement loginBtn;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	public void EnterUsername(String un) {
		username.sendKeys(un);
	}
	
	public void EnterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public DashboardPage ClickLoginBtn() {
		loginBtn.click();
		return new DashboardPage();
	}
	
	public DashboardPage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new DashboardPage();
	}
}

