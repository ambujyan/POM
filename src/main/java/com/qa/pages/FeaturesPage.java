package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FeaturesPage extends TestBase {

	
	@FindBy(xpath="//h1[@class='text-center']")
	WebElement pageText;
	
	public FeaturesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageText() {
		String text = pageText.getText();
		return text;
		
	}
	
}

