package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class SmartPhone extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	By iphone11 = By.xpath("//a[@aria-label='Apple iPhone 11']/span[contains(text(), 'Apple ')]");

	public SmartPhone(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	public Phonepage ClickPhone() {
		elementUtil.doClick(iphone11);
		return new Phonepage(driver);
	}

	public String getpagetitle() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Smartphones - Buy The Newest Cell Phones | Verizon Wireless"));
		return elementUtil.doGetPageTitle();
	}
}
