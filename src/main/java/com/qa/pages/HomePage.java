package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory
	@FindBy(xpath="//td[contains(text(),'User: TestFirst TestLast')]")
	WebElement userName;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;


	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Task')]")
	WebElement newTasksLink;
	
	
	//Initializing Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateUserName() {
		return userName.isDisplayed();
	}
	
	public ContactsPage clickContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public TasksPage clickTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
		
	public void clickNewContactsLink() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			
			//newContactsLink.click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click",newContactsLink);
		}
		catch(org.openqa.selenium.StaleElementReferenceException e){
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			
			//newContactsLink.click();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click",newContactsLink);
		}
		
				
	}
	
	public void clickNewTasksLink() {
	
		try {			
			Actions action  = new Actions(driver);
			action.moveToElement(tasksLink).build().perform();
			//newTasksLink.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", newTasksLink);
		
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			Actions action  = new Actions(driver);
			action.moveToElement(tasksLink).build().perform();
			//newTasksLink.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", newTasksLink);
		}
		
	}
	
/*	public DealsPage clickDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
*/}
