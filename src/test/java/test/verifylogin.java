package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Login_page;

public class verifylogin {

	static WebDriver driver;

	// Verify Login using 4 users credentials.

	public static void verifyuser(WebDriver driver) throws InterruptedException, IOException {

		File src = new File("C:\\Users\\ABHI\\Desktop\\SDET_Mar\\Datasheet.xlsx");

		FileInputStream filein = new FileInputStream(src);

		XSSFWorkbook MyFile = new XSSFWorkbook(filein);

		XSSFSheet Data = MyFile.getSheetAt(0);

		for (int i = 1; i <= Data.getLastRowNum(); i++)

		{

			XSSFCell entry1 = Data.getRow(i).getCell(0);
			Login_page.Username(driver).sendKeys(entry1.getStringCellValue());
			XSSFCell entry2 = Data.getRow(i).getCell(1);
			Login_page.password(driver).sendKeys(entry2.getStringCellValue());
			Login_page.loginbutton(driver);
			Thread.sleep(2000);

			String expected = "https://www.saucedemo.com/inventory.html";
			String actual = driver.getCurrentUrl();

			if (expected.equals(actual)) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("User Login Succesfully.....");
				driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
				WebElement logout = driver.findElement(By.linkText("Logout"));

				Actions action = new Actions(driver);

				action.moveToElement(logout).perform();

				logout.click();

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}

			else {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File source = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("C:\\Users\\ABHI\\Desktop\\SDET_Mar\\CapstonImage.jpeg"));
				System.out.println("Enable to login.....Screenshot is captured....");
				Login_page.Username(driver).clear();
				Login_page.password(driver).clear();
				Thread.sleep(2000);
				driver.navigate().refresh();
				// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}

		}

	}
}
