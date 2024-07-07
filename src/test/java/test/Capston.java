package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Cart_page;
import page.Inventory_Page;
import page.Login_page;
import page.checkout_page;
import page.complete_page;

public class Capston {

	static WebDriver driver;

	@Test(priority = 1)
	public static void verifylogin() throws InterruptedException, IOException {

		verifylogin.verifyuser(driver);

	}

	@Test(priority = 2)
	public void login() {
		Login_page.Username(driver).sendKeys("standard_user");
		Login_page.password(driver).sendKeys("secret_sauce");
		Login_page.loginbutton(driver);

	}

	@Test(dependsOnMethods = { "login" })
	public void inventory() throws InterruptedException {

		Inventory_Page.tshirt(driver);
	}

	@Test(dependsOnMethods = { "inventory" })
	public void cart() throws InterruptedException {
		Cart_page.Cart(driver);
	}

	@Test(dependsOnMethods = { "cart" })
	public void checkout() throws InterruptedException {

		checkout_page.firstname(driver).sendKeys("Abhishek");
		checkout_page.lastname(driver).sendKeys("Magdum");
		checkout_page.Zipcode(driver).sendKeys("416106");
		checkout_page.checkout(driver);
	}

	@Test(dependsOnMethods = { "checkout" })
	public void complete() throws InterruptedException {

		complete_page.lastpage(driver);
	}

	@BeforeTest
	public void url() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ABHI\\eclipse-workspace\\Practice_programs\\drivers\\chromedriver.exe");
		String url = "https://www.saucedemo.com/";
		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterTest

	public void close() {
		
		driver.close();
	}

}
