package com.qa.verizon.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;

import com.qa.verizon.page.SmartPhone;

import io.github.bonigarcia.wdm.WebDriverManager;



public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	
	SmartPhone smartPhone;
	HomePage homepage;
	@BeforeTest
	public void Setup(){
		basePage=new BasePage();
		prop=basePage.init_properties();
	String browserName=	prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	homepage=new HomePage(driver);
		
	
	}@Test(priority=1)
	public void verifyPagetitle(){
	String title=	homepage.getPageTitle();
		System.out.println("Title is "+ title);
		Assert.assertEquals(title, "Verizon: Wireless, Internet, TV and Phone Services | Official Site");}
		
	@Test (priority=2)
	public void Clickphone(){
		homepage.clickPhones();
		
	}
	@Test(priority=3)
public void ClickSmartPhone(){
		homepage.clicksmartphones();
	}
	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
