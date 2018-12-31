package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.FeaturesPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	FeaturesPage featuresPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();  
		tasksPage = new TasksPage();
		testUtil = new TestUtil();		
		featuresPage = new FeaturesPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		tasksPage = homePage.clickTasksLink();
		contactsPage = homePage.clickContactsLink();
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title = homePage.validateTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void homePageUserValidation() {
		testUtil.switchToFrame();
		Boolean flag = homePage.validateUserName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void homePageContactsLink() {
		//testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
		System.out.println("Contact Page is displayed");
	}
	
	
	@AfterMethod
	public void tearDown() {
	driver.close();
	}
	
}
