package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class PricingPage extends TestBase {

	@FindBy(xpath="//div[@class='col-sm-4']/div[2]")
	WebElement getFreeCRMButton;
	
	public PricingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePricing() {
			
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getFreeCRMButton);*/
		
		String text = getFreeCRMButton.getText();
		return text;
		
		
	}
	
}
