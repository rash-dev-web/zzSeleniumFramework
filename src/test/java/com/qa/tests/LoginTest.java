package com.qa.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		//logger.info("setUp started...");
		init();
		loginPage = new LoginPage();
	//	logger.info("setUp completed...");
	}

	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Story("validateTitle")
	public void validateTitle() {
		String title = "Cogmento CRM";
		Assert.assertEquals(loginPage.validateTitle(), title);
	}

	@Test(priority=2)
	@Severity(SeverityLevel.CRITICAL)
	@Story("loginTest")
	public void loginTest() {
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
