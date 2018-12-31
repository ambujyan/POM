package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class TasksPage extends TestBase {
	
	@FindBy(id="title")
	WebElement titleTextBox;
	
	@FindBy(id="completion")
	WebElement completionTextBox;
	
	@FindBy(name="task_type")
	WebElement typeSelect;
	
	@FindBy(name="priority")
	WebElement prioritySelect;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement saveButton;
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createTasks(String title, String completion, String type, String priority) {
		titleTextBox.sendKeys(title);
		completionTextBox.sendKeys(completion);
		
		Select select = new Select(typeSelect);
		select.selectByVisibleText(type);
		
		Select select1 = new Select(prioritySelect);
		select1.selectByVisibleText(priority);
		
		saveButton.click();
		
	}
	
}
