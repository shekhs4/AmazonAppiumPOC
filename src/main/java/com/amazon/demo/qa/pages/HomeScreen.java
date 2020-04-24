package com.amazon.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.amazon.demo.qa.base.Base;
import com.amazon.demo.qa.utility.TestUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends Base {
	
	public HomeScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="in.amazon.mShop.android.shopping:id/rs_search_src_text")
	public WebElement searchTextbox;
	
	public boolean verifySearchtextBox() {
		TestUtil.explicitWait(searchTextbox);
		return searchTextbox.isDisplayed();
	}
	public void clickInsideSearchtextBox() {
		TestUtil.explicitWait(searchTextbox);
		searchTextbox.click();
	}
	public void inputToSearchtextBox(String item) {
		TestUtil.explicitWait(searchTextbox);
		searchTextbox.sendKeys(item+"\n");
	}
}
