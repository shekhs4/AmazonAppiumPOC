package com.amazon.demo.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.amazon.demo.qa.utility.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	public static AppiumDriver<MobileElement> driver;;
	public static Properties prop ;
	private DesiredCapabilities caps;
	private URL url;
	public Base(){
		try {
			prop=new Properties();
		    prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/amazon/demo/qa/configurations/Properties.properties"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	public void initialization() throws MalformedURLException {
		caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PLATFORM_NAME"));
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("PLATFORM_VERSION"));
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));
		caps.setCapability(MobileCapabilityType.UDID, prop.getProperty("UDID"));
		caps.setCapability("appPackage",prop.getProperty("APP_PACKAGE"));
		caps.setCapability("appActivity",prop.getProperty("APP_ACTIVITY"));
		url=new URL(prop.getProperty("URL"));
		driver=new AndroidDriver<MobileElement>(url,caps);
	}
	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		Base.prop = prop;
	}

	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	public void setDriver(AppiumDriver<MobileElement> driver) {
		Base.driver = driver;
	}
}
