package com.qa.testcases;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.FeaturesPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PricingPage;
import com.qa.util.TestUtil;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	FeaturesPage featuresPage;
	PricingPage pricingPage;
	TestUtil testUtil;
		
	public LoginPageTest() {
		super();
	}
		
	
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		loginPage = new LoginPage();
		featuresPage = new FeaturesPage();
		testUtil = new TestUtil();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		if(title.equalsIgnoreCase("#1 Free CRM software in the cloud for sales and service")) {
			Assert.assertTrue(true);
		}
		else {
		try {
			TestUtil.takeScreenshotAtEndOfTest("CRMLoginPageTest");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(false);
			
		}
			
	}
	
	@Test(priority=2)
	public void loginPageLogoTest() {
		Boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void validateFeaturesLink() {
		loginPage.clickFeaturesLink();
		String text = featuresPage.validatePageText();
		Assert.assertEquals(text,"Free CRM Features powerful sales automation and customer service features import data, export, dashboards and more");
	}
	
	@Test(priority=4)
	public void loginToFreeCRMApplication() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
/*	@Test(priority=5)
	public void validatePricingLink() {
		loginPage.clickPricingLink();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String text = pricingPage.validatePricing();
		Assert.assertEquals(text, " Contacts");
		
		
	}*/

	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	
	}
}
