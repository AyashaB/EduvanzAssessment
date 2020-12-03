package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.ActionHelper;

public class CheckOutPopUp {
	WebDriver driver;

	public CheckOutPopUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='icon-ok']")
	WebElement successMessage;

	@FindBy(xpath = "//span[@id='layer_cart_product_title']")
	WebElement productTitle;

	@FindBy(xpath = "//span[@id='layer_cart_product_quantity']")
	WebElement quantity;

	@FindBy(xpath = "//span[@id='layer_cart_product_price']")
	WebElement productPrice;

	@FindBy(xpath = "h2:nth-child(1) > span.ajax_cart_product_txt_s.unvisible")
	WebElement header;

	@FindBy(xpath = "//span[@class='ajax_block_products_total']")
	WebElement productTotal;

	@FindBy(xpath = "//span[@class='ajax_block_cart_total']")
	WebElement cart_Total;
	

	@FindBy(xpath = "//span[@title='Close window']")
	WebElement closeicon;
	
	

	@FindBy(xpath = "//span[@class='ajax_cart_shipping_cost']")
	WebElement shipping_cost;
	
	
	public void closePopup() {
		ActionHelper.clickOnElement(driver, closeicon);
	}

	public String successMessage() {
		return successMessage.getText();
	}

	public String productTitle() {
		return productTitle.getText();
	}

	public String quantity() {
		return quantity.getText();
	}

	public String productPrice() {
		return productPrice.getText();
	}

	public String header() {
		return header.getText();
	}

	public String productTotal() {
		return productTotal.getText();
	}

	public String cart_Total() {
		return cart_Total.getText();
	}

	public String shipping_cost() {
		return shipping_cost.getText();
	}

}
