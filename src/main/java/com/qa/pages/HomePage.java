package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import io.qameta.allure.Step;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userName;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Verify title")
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	@Step("Verify User")
	public String verifyUser() {
		return userName.getText();
	}

}
