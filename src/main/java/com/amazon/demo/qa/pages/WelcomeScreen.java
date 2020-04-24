package com.amazon.demo.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.demo.qa.base.Base;
import com.amazon.demo.qa.utility.TestUtil;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeScreen extends Base {
	public WelcomeScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	@AndroidFindBy(id ="ap_email_login")
	public WebElement emailTextbox;
	
	@AndroidFindBy(xpath="//*[@text(),'Continue')]")
	public WebElement continueBtn;
	
	public boolean verifyEmailTextBox() {
		TestUtil.explicitWait(emailTextbox);
		return emailTextbox.isDisplayed();
	}
	public boolean verifyContinuebtn() {
		TestUtil.explicitWait(continueBtn);
		return continueBtn.isDisplayed();
	}
	public void clickContinueBtn() {
		TestUtil.explicitWait(continueBtn);
		continueBtn.click();
	}
	public void inputEmail(String validEmailId) {
		TestUtil.explicitWait(emailTextbox);
		emailTextbox.sendKeys(validEmailId);
	}
}
