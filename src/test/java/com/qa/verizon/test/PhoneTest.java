package com.qa.verizon.test;

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
public class PhoneTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	Phonepage phone;
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
	   smartPhone=new SmartPhone(driver);
	   smartPhone=homepage.clickPhones();
	    smartPhone= homepage.clicksmartphones();
	    phone=smartPhone.ClickPhone();
	}@Test(priority=1)
	public void VerifyTitle(){
String title=		phone.getVerifyTitle();
System.out.println(title);
Assert.assertEquals(title, "New Apple iPhone 11 - 6 Cool Colors & Dual Camera | Best Price");
	}
	@Test(priority=2)
	public void ChooseColorAndPrice(){
		phone.ChooseColorandPrice();
	}
	@Test(priority=3)
	public void SelectNextButton(){
		phone.SelectnextButton();
	}@Test(priority=4)
	public void SelectDeclineButton(){
		phone.SelectDeclineButton();
	}@Test(priority=5)
	public void Chooseplan(){
		phone.choosePlan();
	}@Test(priority=6)
	public void VerifyPhone(){
	String phone2=phone.verifyPhone();
	System.out.println(phone2);
	Assert.assertEquals(phone2,"iPhone 11");
	
		
	}
	@Test(priority=6)
	public void getSecondTitle(){
	String title2=	phone.getVerifyTitle2();
	System.out.println(title2);
	Assert.assertEquals(title2, "Verizon | Shopping Cart");
	}
	@AfterTest
	public void teardown(){
		driver.quit();
	}
}
