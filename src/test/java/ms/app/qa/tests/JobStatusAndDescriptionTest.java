package ms.app.qa.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ms.app.qa.pages.*;
import ms.app.qa.base.TestBase;

public class JobStatusAndDescriptionTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	MyJobsPage myJobsPage;
	
	SoftAssert softAssertion;
	
	public JobStatusAndDescriptionTest() throws IOException{
		
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
			Thread.sleep(6000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	@Test(priority=1, groups = { "F1", "Jobs Status", "E2E" }, description="Verifying the ability to change Status of Jobs")
	public void JobStatusUpdateTest() throws InterruptedException {
		
		softAssertion= new SoftAssert();
		
		//Change the Language from Dutch to English
		dashboardPage.ClickOnSettingsGr();
		dashboardPage.ChangeLangToEn();
		
		//Click on "My Jobs" in the left side panel
		myJobsPage = dashboardPage.ClickOnMyJobs();
		System.out.println("***-> Driver title: " + driver.getTitle());
		
		//Click on the First job on the List
		myJobsPage.ClickOnJobList(0);
		
		//Change the Status of Job to "Geplant"
		myJobsPage.ChangeStatus("Geplant");
		myJobsPage.ClickOnInfoTab();
		String JobStatus = myJobsPage.GetStatus();	
		softAssertion.assertEquals(JobStatus, "Geplant");
		Thread.sleep(5000);//Just to see the change
		
		//Change the Status of Job to "Ungeplant"
		myJobsPage.ChangeStatus("Ungeplant");
		myJobsPage.ClickOnInfoTab();
		JobStatus = myJobsPage.GetStatus();		
		softAssertion.assertEquals(JobStatus, "Ungeplant");
		Thread.sleep(5000);//Just to see the change
		
		//myJobsPage.ClickOnAppoinmentsTab();
		myJobsPage.ClickOnInfoTab();
		
		softAssertion.assertAll();
	}
	
	@Test(priority=1, groups = { "F1", "Jobs Description", "E2E" }, description="Verifying the ability to change Description of Jobs")
	public void JobDescriptionUpdateTest() throws InterruptedException {
		
		softAssertion= new SoftAssert();
		
		//Change the Language from Dutch to English
		dashboardPage.ClickOnSettingsGr();
		dashboardPage.ChangeLangToEn();
		
		//Click on "My Jobs" in the left side panel
		myJobsPage = dashboardPage.ClickOnMyJobs();
		System.out.println("***-> Driver title: " + driver.getTitle());
		
		//Click on the First job on the List
		myJobsPage.ClickOnJobList(0);
		
		//Click on Appointment Tab
		myJobsPage.ClickOnAppoinmentsTab();
		Thread.sleep(3000);
		
		//Change the Description
		myJobsPage.ClickOnEditButton();
		myJobsPage.SetNewDescription("This is my New Descriptions!");
		myJobsPage.ClickOnSaveButton();
		
		//Click on Info Tab and check if the Description got updated
		myJobsPage.ClickOnInfoTab();
		String DescriptionShown = myJobsPage.GetDescriptionShown();
		softAssertion.assertEquals(DescriptionShown, "This is my New Descriptions!");
				
		softAssertion.assertAll();		
	}
	
}
