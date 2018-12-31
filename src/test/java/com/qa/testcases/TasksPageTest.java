package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.util.TestUtil;

public class TasksPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TasksPage tasksPage;
	TestUtil testUtil;
	String sheetName = "tasks";
	
	public TasksPageTest() {
		super();
	}
	
	@BeforeMethod
	@Parameters({"portNo","appUrl"})
	public void setUp(String portNo, String appUrl) throws MalformedURLException {
		initialization(portNo, appUrl);
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		tasksPage = new TasksPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		tasksPage = homePage.clickTasksLink();
		contactsPage = homePage.clickContactsLink();
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="getCRMTestData")
	public void createTasks(String title, String completion, String type, String priority) {
		//testUtil.switchToFrame();
		homePage.clickNewTasksLink();
		tasksPage.createTasks(title, completion, type, priority);
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
}
