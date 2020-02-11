package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userName;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public String verifyUser() {
		return userName.getText();
	}

}
