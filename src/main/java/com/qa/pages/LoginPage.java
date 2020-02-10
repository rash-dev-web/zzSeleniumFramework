package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement singUpButton;
	
	public void signIn() {
		
	}
	
	public void singUp() {
		
	}
}
