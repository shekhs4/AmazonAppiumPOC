package com.amazon.demo.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.demo.qa.base.Base;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestUtil extends Base{
	public static long NEW_COMMAND_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 20;
	public static long EXPLICIT_WAIT = 59;
	private static WebDriverWait wait;
	
	public static void explicitWait(WebElement ele) {
		wait =new WebDriverWait(driver, EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	public static void setPotraitMode() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}
	public static void setLandscapeMode() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}
	public static void scrollDown()
	{
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.8);
		int startx = (int ) (size.width * 0.5);
		new TouchAction((PerformsTouchActions)driver).
		press(PointOption.point(0,startx)).
		waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000))).
		moveTo(PointOption.point(0,starty)).
		release().perform();
	}
	public static List<String> readDataFromExcel(int sheetNum) throws IOException {
		File excelFile=new File("TestData.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		List<String> list=new ArrayList<String>();
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(sheetNum);
		Iterator<Row> rowIt=sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row=rowIt.next();
			Iterator<Cell> cellIt=row.iterator();
			
			while(cellIt.hasNext()) {
				Cell cell=cellIt.next();
				list.add(cell.toString());
			}
		}
		wb.close();
		fis.close();
		return list;
	}
	
	
	 
   
}
