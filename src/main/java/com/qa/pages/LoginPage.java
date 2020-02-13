package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase {

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signUpButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@Step("Validating title")
	public String validateTitle() {
		
		return driver.getTitle();
		
	}

	@Step("login with username :{0} and password :{1} ")
	public HomePage signIn(String uname, String pwd) {
		
		email.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
		
	}

	public void singUp() {

		signUpButton.click();
		
	}
}
