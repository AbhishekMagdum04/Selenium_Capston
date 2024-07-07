package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Inventory_Page {

	public static WebElement element = null;

	public static WebElement tshirt(WebDriver driver) throws InterruptedException {

		Select ac = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
		ac.selectByVisibleText("Price (high to low)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		Thread.sleep(3000);
		
		WebElement flag = driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]"));
		flag.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		return flag;
		

	}

}
