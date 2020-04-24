package com.amazon.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.amazon.demo.qa.base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectedProductDetailsScreen extends Base {
	public SelectedProductDetailsScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="bylineInfo")
	public WebElement tvName;
	
	public String getNameAndDescriptionOfSelectedTV() {
		return tvName.getAttribute("text");
	}
}
