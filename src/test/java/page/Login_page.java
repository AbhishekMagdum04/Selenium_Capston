package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_page {

	public static WebElement element = null;

	public static WebElement Username(WebDriver driver) {

		element = driver.findElement(By.id("user-name"));
		return element;
	}

	public static WebElement password(WebDriver driver) {

		element = driver.findElement(By.id("password"));
		return element;
	}

	public static void loginbutton(WebDriver driver) {

		element = driver.findElement(By.id("login-button"));
		element.click();

	}
}
