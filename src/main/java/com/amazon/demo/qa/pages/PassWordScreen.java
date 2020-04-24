package com.amazon.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.demo.qa.base.Base;
import com.amazon.demo.qa.utility.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PassWordScreen extends Base {
	public PassWordScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath="//*[contains(@text(),'assword')]")
	public WebElement passwordTextbox;
	
	@AndroidFindBy(xpath="//*[contains(@text(),'ogin')]")
	public WebElement loginBtn;
	
	public boolean verifyPasswordtextBox() {
		TestUtil.explicitWait(passwordTextbox);
		return passwordTextbox.isDisplayed();
	}
	public boolean verifyLoginbtn() {
		TestUtil.explicitWait(loginBtn);
		return loginBtn.isDisplayed();
	}
	public void clickLoginBtn() {
		TestUtil.explicitWait(loginBtn);
		loginBtn.click();
	}
	public void inputPassword(String password) {
		TestUtil.explicitWait(passwordTextbox);
		passwordTextbox.sendKeys(password);
	}
}
