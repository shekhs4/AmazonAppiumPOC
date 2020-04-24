package com.amazon.demo.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.demo.qa.base.Base;
import com.amazon.demo.qa.utility.TestUtil;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends Base {
	
	public LoginScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	@AndroidFindBy(id="in.amazon.mShop.android.shopping:id/sign_in_button")
	public WebElement signInbtn;
	
	public boolean verifySigninBtn() {
		TestUtil.explicitWait(signInbtn);
		return signInbtn.isDisplayed();
	}
	public void clickSigninBtn() {
		TestUtil.explicitWait(signInbtn);
		signInbtn.click();
	}
	
	

}
