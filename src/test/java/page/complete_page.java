package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class complete_page {

	public static WebElement element = null;

	public static WebElement lastpage(WebDriver driver) throws InterruptedException {

		String thankyou = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
		System.out.println(thankyou);
		driver.findElement(By.name("back-to-products")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		WebElement logout = driver.findElement(By.linkText("Logout"));

		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		Thread.sleep(3000);
		logout.click();

		return element;

	}
}
