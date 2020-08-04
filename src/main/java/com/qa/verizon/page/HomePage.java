package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.spi.Element;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class HomePage extends BasePage {
WebDriver driver;
ElementUtil elementUtil;
By phoneslist=By.xpath("//div[@class='gnav20-primary-menu gnav20-grouping']");

By smartphones=By.xpath("//*[@id='gnav20-Shop-L3-1'][2]");
public HomePage(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
	
}
public String getPageTitle(){
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.titleContains("Verizon: Wireless, Internet, TV and Phone Services | Official Site"));
	return elementUtil.doGetPageTitle();
	}
public SmartPhone clickPhones(){
	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.textToBe(phoneslist, "Shop"));
	WebElement phonelistt=driver.findElement(phoneslist);
	Actions actions=new Actions(driver);
	actions.moveToElement(phonelistt).build().perform();
	return new SmartPhone(driver);
	}
public SmartPhone clicksmartphones(){
	elementUtil.doClick(smartphones);
	return new SmartPhone(driver);
}
//cd + project path yapistiriyorsun

//allure serve allure-results
}
