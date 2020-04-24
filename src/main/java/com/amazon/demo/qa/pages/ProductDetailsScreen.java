package com.amazon.demo.qa.pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.amazon.demo.qa.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailsScreen extends Base {
	public ProductDetailsScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	 
	public void selectATV() {
		randomTVtoBeSelected().click();
	}
	public MobileElement randomTVtoBeSelected() {
		List<MobileElement> list=driver.findElements(By.className("android.view.View"));
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
	public String nameAndDescriptionOfRandomTVOnSearchPage() {
		return randomTVtoBeSelected().getAttribute("text");
	}
}
