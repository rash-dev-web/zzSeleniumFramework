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

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init();
		loginPage = new LoginPage();
		homePage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	@Severity(SeverityLevel.NORMAL)
	@Story("verifyTitle")
	public void verifyTitle() {
		String title = homePage.verifyTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("verifyUser")
	public void verifyUser() {
		Assert.assertEquals(homePage.verifyUser(), prop.getProperty("user"));

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
