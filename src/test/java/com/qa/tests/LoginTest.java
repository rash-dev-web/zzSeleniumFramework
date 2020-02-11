package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
	}

	@Test
	public void validateTitle() {
		String title = "Cogmento CRM";
		Assert.assertEquals(loginPage.validateTitle(), title);
	}

	@Test
	public void loginTest() {
		loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
