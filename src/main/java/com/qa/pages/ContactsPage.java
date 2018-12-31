package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{

	//Page Elements
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveButtton;
	
	@FindBy(name="cs_name")
	WebElement nameTextBox;
	
	@FindBy(xpath="//a[contains(text(),'Tom')]")
	WebElement nameLabel;
	
	@FindBy(xpath="(//input[@name=\"cs_submit\"])[2]")
	WebElement searchButtton;
	 
	@FindBy(name="title")
	WebElement titleDropDown;
	
	
	//PageFactory Initialization
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public boolean validateContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	/*public void searchContact(String name) {
		nameTextBox.sendKeys(name);
		searchButtton.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nameLabel.isDisplayed()) {
			Assert.assertTrue(true, "Contact already exists");
		}
		else {
			Assert.assertTrue(false, "Contact doesnot exists");
		}
	}
	*/
/*	public void selectContactByName(String name) {
			driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	*/
	
	public void createNewContact(String title, String fname, String lname, String cname) {
	/*	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}*/
		
		Select select = new Select(titleDropDown);
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(cname);
		saveButtton.click();
	}
	
	
}
