package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart_page {

	public static WebElement element = null;

	public static WebElement Cart(WebDriver driver) throws InterruptedException {

		String productname = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText();
		String Quentity = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]"))
				.getText();
		String Price = driver
				.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"))
				.getText();

		System.out.println("Product Name:- " + productname);
		System.out.println("Quentity:- " + Quentity);
		System.out.println("Price:- " + Price);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		return element;

	}
}
