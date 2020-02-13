package com.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {

	private static WebDriver driver;
	private SingletonDriver() {
	
	}
	
	public static WebDriver getInstance() {
		if(driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}
}
