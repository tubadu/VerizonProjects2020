package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;




public class Phonepage extends BasePage {
	
	By packagee=By.xpath("//div[contains(@class,'cursorPointer height100p positionRelative border_grayThree')]//span");
	By colorphone=By.xpath("//label[@for='#A3D9C2']");
	By continuebutton=By.id("ATC-Btn");
	By newcustomer=By.xpath("//button[@aria-label='New Customer']");
	By nextButton=By.xpath("//button[@class='button margin30 onlyTopMargin primary']");
	By secondnextButton=By.id("deviceProtectionBtn");
	By declineprotection=By.id("declineDeviceSelectProtecionBtn");
	By seconddecline=By.xpath("//button[@class='secondary button cancelProtectionButton']");
	By selectplan=By.xpath("//button[@aria-label='Start Unlimited']");
	By zipconfirm=By.xpath("//button[@type='submit']");
	By price=By.xpath("//div[@class='cursorPointer height100p positionRelative border_grayThree ']");
	By verifyphone=By.xpath("//h3[@class='h2']//span");
	
	WebDriver driver;
	ElementUtil elementUtil;
	public Phonepage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
	}public String getVerifyTitle(){
		return elementUtil.doGetPageTitle();
	}
	public void ChooseColorandPrice(){
	
		elementUtil.doClick(colorphone);
		elementUtil.doClick(price);
		elementUtil.doClick(continuebutton);

	}
	public void SelectnextButton(){
		elementUtil.doClick(zipconfirm);
		elementUtil.doClick(newcustomer);
		
		elementUtil.doClick(nextButton);
		elementUtil.doClick(secondnextButton);
	
		
	}public void SelectDeclineButton(){
		elementUtil.doClick(declineprotection);
		elementUtil.doClick(seconddecline);
	}
	public void choosePlan(){
		elementUtil.doClick(selectplan);
	}
	public String  verifyPhone(){
		
		return elementUtil.doGetText(verifyphone);
	}public String getVerifyTitle2(){
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.titleContains("Verizon | Shopping Cart"));
		return elementUtil.doGetPageTitle();
	}
}
