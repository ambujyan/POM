/*Author - Ambuj Jain
 * 
 * 
 */


package com.qa.testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.FeaturesPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	FeaturesPage featuresPage;
	TasksPage tasksPage;
	TestUtil testUtil;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		tasksPage = new TasksPage();
		contactsPage = new ContactsPage();
		featuresPage = new FeaturesPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
		tasksPage = homePage.clickTasksLink();
		
	}
	
	@Test(priority=1)
	public void validateContactsLabel() {
		Assert.assertTrue(contactsPage.validateContactsLabel());
	}
	
/*	@Test(priority=3)
	public void searchContact() {
		contactsPage.searchContact("Tom");		
	}
*/	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
		
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
		homePage.clickNewContactsLink();
		contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
/*	@Test(priority=4)
	public void selectContactByName() {
		contactsPage.selectContactByName("Tom Peter");
	}
*/	
	@AfterMethod
	public void tearDown() {
	driver.close();
	}
	
}
