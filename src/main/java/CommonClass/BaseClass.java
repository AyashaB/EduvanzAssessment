package CommonClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

	public static  WebDriver driver;
	public static  Properties pro;

	
	public static  WebDriver launchApplication() throws IOException {
		String path = System.getProperty("user.dir") + "\\global.properties";
		pro = new Properties();
		FileInputStream fis = new FileInputStream(path);
		pro.load(fis);
		String driverpath = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(pro.getProperty("baseUrl"));
		return driver;
	}
	
	public static void ScrolltoElement(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	public static void waitforElement(WebDriver driver, WebElement ele ) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}