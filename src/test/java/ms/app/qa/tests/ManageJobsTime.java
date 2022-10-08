package ms.app.qa.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ms.app.qa.base.TestBase;
import ms.app.qa.pages.DashboardPage;
import ms.app.qa.pages.*;

public class ManageJobsTime extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	MyJobsPage myJobsPage;
	
	SoftAssert softAssertion= new SoftAssert();
	
	public ManageJobsTime() throws IOException{
		//super();
	}

	@BeforeMethod
	public void SetUp() throws IOException{
		
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(10000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}	
	
		public void JobStatusAndDescriptionUpdateTest() throws InterruptedException {
		
		System.out.println("***-> Driver title****" + driver.getTitle());
		String MainWindow = driver.getWindowHandle();
		System.out.println("Main window handle is " + MainWindow);
		
		dashboardPage.ClickOnSettingsGr();
		dashboardPage.ChangeLangToEn();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itrator = handles.iterator();
		System.out.println("Main window handle is " + MainWindow);
		
		System.out.println("***-> get Window Handles count: ****" + handles.size());
		String ChildWindow = itrator.next();
		System.out.println("Cild window handle is " + ChildWindow);
		//driver.switchTo().window(ChildWindow);
		//driver.close();
		//driver.switchTo().window(MainWindow);
		
		/*while (itrator.hasNext()) {
	          String ChildWindow = itrator.next();
	          if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
	              driver.switchTo().window(ChildWindow);
	              driver.close();
	              System.out.println("Child window closed");
	           }
	       }*/
		myJobsPage = dashboardPage.ClickOnMyJobs();
		System.out.println("***-> clicked on MyJobs ****");
		System.out.println("***-> Driver title****" + driver.getTitle());
		myJobsPage.ClickOnJobList(0);
		myJobsPage.ChangeStatus("Geplant");//Ungeplant
		String JobStatus = myJobsPage.GetStatus();		
		softAssertion.assertEquals(JobStatus, "Geplant");
		Thread.sleep(3000);
		
		myJobsPage.ClickOnAppoinmentsTab();
		myJobsPage.ClickOnEditButton();
		myJobsPage.SetNewDescription("This is my New Descriptions!");
		myJobsPage.ClickOnSaveButton();
		myJobsPage.ClickOnInfoTab();
		String DescriptionShown = myJobsPage.GetDescriptionShown();
		softAssertion.assertEquals(DescriptionShown, "This is my New Descriptions!");
				
		softAssertion.assertAll();
		
	}
}

