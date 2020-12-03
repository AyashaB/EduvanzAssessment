package ApplicationPages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonClass.BaseClass;
import Helper.ActionHelper;

public class HomePage extends BaseClass {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Ayasha Bodele')]")
	WebElement UserName;

	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement Search;

	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement SearchIcon;

	@FindBy(id = "selectProductSort")
	WebElement sortdropdown;

	@FindBy(css = "span[class='price product-price']")
	List<WebElement> price;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement AddToCart;

	@FindBy(css = "div[class='clearfix']")
	WebElement proceedToCheckout;

	@FindBy(css = "div[class='button-container'] a")
	WebElement proceedToCheckoutbutton;

	@FindBy(css = "a[title='Grid'] i")
	WebElement grid;

	@FindBy(css = "div[id='layer_cart'] div")
	WebElement popup;

	public boolean popIsDisplay() {
		waitforElement(driver, popup);
		return popup.isDisplayed();
	}

	public void clickOngrid() {
		ActionHelper.clickOnElement(driver, grid);
	}

	public void clickOnproceedToCheckoutbutton() {
		ActionHelper.clickOnElement(driver, proceedToCheckoutbutton);
	}

	public boolean proceedToCheckout() {
		return proceedToCheckout.isDisplayed();
	}

	public boolean CheckUserName() {
		waitforElement(driver, UserName);
		return UserName.isDisplayed();
	}

	public void enterSearch(String text) {
		waitforElement(driver, Search);
		Search.sendKeys(text);
	}

	public void clickOnSearch() {
		ActionHelper.clickOnElement(driver, SearchIcon);
	}

	public String lowest_productPrice() {

		List<String> li = new ArrayList<String>();
		List<Double> li2 = new ArrayList<Double>();
		for (int i = 0; i < price.size(); i++) {
			li.add(price.get(i).getText());
		}
		for (String string : li) {
			if (string.contains("$")) {
				String value = string.substring(1);
				double num = Double.valueOf(value);
				li2.add(num);
			}
		}
		Collections.sort(li2);
		return String.format("%.2f",li2.get(0));
	}

	public String lowest_productPurchase() {
		String lowest_price = lowest_productPrice();
		String dressname = null;
		// String amount = Double.toString(lowest_price);
		for (int i = 0; i < price.size(); i++) {
			if (price.get(i).getText().contains(lowest_price)) {
				WebElement ele = price.get(i);
				WebElement container = ele.findElement(By.xpath(
						"//span[@class='price product-price']/parent::div/parent::div/parent::div[@class='product-container']"));
				dressname = container.findElement(By.xpath("//a[@class='product-name']")).getText();

				ActionHelper.clickOnElement(driver, price.get(i));
				break;
			}

		}
		return dressname;
	}

}
