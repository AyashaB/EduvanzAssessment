package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {

	static Actions act ;
	
	public static void clickOnElement(WebDriver driver,WebElement ele) {
		act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	
	public static void hoverOnElement(WebDriver driver,WebElement ele) {
		act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
}
