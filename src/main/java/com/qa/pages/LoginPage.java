package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	//1. Page Factory
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement userpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//div[@id='navbar-collapse']/ul/li/a[contains(text(),'Features')]")
	WebElement featuresLink;
	
	@FindBy(xpath="//div[@id='navbar-collapse']/ul/li/a[contains(text(),'Pricing')]")
	WebElement pricingLink;
	
	//2. Initializing the Page Objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//3. Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {

		return crmLogo.isDisplayed();
	}
	
	public FeaturesPage clickFeaturesLink() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		//js.executeScript("featuresLink.click();");
		js.executeScript("arguments[0].click()", featuresLink);
		
		return new FeaturesPage();
	}
	
	public PricingPage clickPricingLink() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].click()", pricingLink);
		
		return new PricingPage();
	}
	
	public HomePage login(String un, String pwd){
		userName.sendKeys(un);
		userpassword.sendKeys(pwd);
				
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginButton);
		//js.executeScript("loginButton.click();");
		
		return new HomePage();
	}
	
}
