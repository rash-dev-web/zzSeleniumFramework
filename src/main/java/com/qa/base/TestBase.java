package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestLog;
import com.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	//public static TestLog testLog;
	public static Logger log = Logger.getLogger(TestBase.class);

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\Automation\\zzTesting\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);

			log.info("Property file loaded.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void init() {

		if (prop.getProperty("browser").equals("chrome")) {
		//	testLog.logFile();
			System.setProperty("webdriver.chrome.driver",
					"D:\\Automation\\zzTesting\\src\\main\\java\\com\\qa\\config\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
}
