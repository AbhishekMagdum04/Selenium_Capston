package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkout_page {

	public static WebElement element = null;

	public static WebElement firstname(WebDriver driver) {
		element = driver.findElement(By.id("first-name"));
		return element;
	}

	public static WebElement lastname(WebDriver driver) {
		element = driver.findElement(By.id("last-name"));
		return element;
	}

	public static WebElement Zipcode(WebDriver driver) {
		element = driver.findElement(By.id("postal-code"));
		return element;
	}

	public static WebElement checkout(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
		
		String Totalprice = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"))
				.getText();
		String paymentinfo = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]"))
				.getText();
		String shippinginfo = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]"))
				.getText();

		System.out.println("Total price:- " + Totalprice);
		System.out.println("Payment info:- " + paymentinfo);
		System.out.println("Shipping Info:- " + shippinginfo);

		Thread.sleep(3000);
		driver.findElement(By.name("finish")).click();
		return element;

	}

}
