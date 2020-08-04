package com.qa.verizon.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;

import com.qa.verizon.page.Phonepage;
import com.qa.verizon.page.SmartPhone;

public class SmartPhonePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	Phonepage phone;
	SmartPhone smartPhone;
	HomePage homepage;

	@BeforeTest
	public void Setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		smartPhone = new SmartPhone(driver);
		smartPhone = homepage.clickPhones();
		smartPhone = homepage.clicksmartphones();

	}

	@Test(priority = 1)
	public void PagetitleVerify() {
		String title = smartPhone.getpagetitle();
		System.out.println("Title is " + title);
		Assert.assertEquals(title, "Smartphones - Buy The Newest Cell Phones | Verizon Wireless");
	}

	@Test(priority = 2)
	public void Choosephone() {
		smartPhone.ClickPhone();
	}

	@AfterTest
	public void teardown() {

		driver.quit();
	}
}
