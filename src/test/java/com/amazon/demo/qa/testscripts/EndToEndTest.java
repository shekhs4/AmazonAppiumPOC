package com.amazon.demo.qa.testscripts;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazon.demo.qa.base.Base;
import com.amazon.demo.qa.pages.CheckOutScreen;
import com.amazon.demo.qa.pages.HomeScreen;
import com.amazon.demo.qa.pages.LoginScreen;
import com.amazon.demo.qa.pages.PassWordScreen;
import com.amazon.demo.qa.pages.ProductDetailsScreen;
import com.amazon.demo.qa.pages.SelectedProductDetailsScreen;
import com.amazon.demo.qa.pages.WelcomeScreen;
import com.amazon.demo.qa.utility.TestUtil;


public class EndToEndTest extends Base {
	LoginScreen loginScreen;
	WelcomeScreen welScreen;
	PassWordScreen passwordScreen;
	HomeScreen homeScreen;
	ProductDetailsScreen pdscreen;
	SelectedProductDetailsScreen spdScreen;
	CheckOutScreen checkOutscreen;
	public EndToEndTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		initialization();
		loginScreen=new LoginScreen();
		welScreen=new WelcomeScreen();
		passwordScreen=new PassWordScreen();
		homeScreen=new HomeScreen();
		pdscreen= new ProductDetailsScreen();
		spdScreen=new SelectedProductDetailsScreen();
		checkOutscreen=new CheckOutScreen();
	}
	
	@Test(priority = 1,description = "Verifying name and description of the product in Portrait mode")
	public void verifyNamedescriptionofTheproductInportraitModeTest() throws IOException {
		TestUtil.setPotraitMode();
		Assert.assertTrue(loginScreen.verifySigninBtn());
		loginScreen.clickSigninBtn();
		Assert.assertTrue(welScreen.verifyEmailTextBox());
		welScreen.inputEmail(TestUtil.readDataFromExcel(0).get(0));
		Assert.assertTrue(welScreen.verifyContinuebtn());
		welScreen.clickContinueBtn();
		Assert.assertTrue(passwordScreen.verifyPasswordtextBox());
		passwordScreen.inputPassword(TestUtil.readDataFromExcel(0).get(1));
		Assert.assertTrue(passwordScreen.verifyLoginbtn());
		passwordScreen.clickLoginBtn();
		Assert.assertTrue(homeScreen.verifySearchtextBox());
		homeScreen.inputToSearchtextBox(TestUtil.readDataFromExcel(0).get(2));
		pdscreen.selectATV();
		Assert.assertEquals(pdscreen.nameAndDescriptionOfRandomTVOnSearchPage(), spdScreen.getNameAndDescriptionOfSelectedTV());
	}
	@Test(priority = 1,description = "Verifying name and description of the product in Portrait mode")
	public void verifyNamedescriptionofTheproductInLandscapeModeTest() throws IOException {
		TestUtil.setLandscapeMode();
		Assert.assertTrue(loginScreen.verifySigninBtn());
		loginScreen.clickSigninBtn();
		Assert.assertTrue(welScreen.verifyEmailTextBox());
		welScreen.inputEmail(TestUtil.readDataFromExcel(0).get(0));
		Assert.assertTrue(welScreen.verifyContinuebtn());
		welScreen.clickContinueBtn();
		Assert.assertTrue(passwordScreen.verifyPasswordtextBox());
		passwordScreen.inputPassword(TestUtil.readDataFromExcel(0).get(1));
		Assert.assertTrue(passwordScreen.verifyLoginbtn());
		passwordScreen.clickLoginBtn();
		Assert.assertTrue(homeScreen.verifySearchtextBox());
		homeScreen.inputToSearchtextBox(TestUtil.readDataFromExcel(0).get(2));
		pdscreen.selectATV();
		Assert.assertEquals(pdscreen.nameAndDescriptionOfRandomTVOnSearchPage(), spdScreen.getNameAndDescriptionOfSelectedTV());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.closeApp();
	}
}
