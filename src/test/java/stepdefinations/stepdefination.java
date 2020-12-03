package stepdefinations;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.openqa.selenium.WebElement;

import ApplicationPages.CheckOutPopUp;
import ApplicationPages.HomePage;
import ApplicationPages.LoginPage;
import CommonClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefination extends BaseClass {
	CheckOutPopUp pop;
	HomePage home;
	String product_name;
	String product_price;
	private static DecimalFormat df = new DecimalFormat("0.00");

	@Given("^User is login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_is_login(String email, String password) throws Throwable {
		driver = BaseClass.launchApplication();
		LoginPage page = new LoginPage(driver);
		page.clickOnSignIn();
		WebElement user = page.enterUsername(email);
		BaseClass.ScrolltoElement(driver, user);
		page.enterPassword(password);
		page.SubmitLogin();
	}

	@When("^user search with keyword \"([^\"]*)\" and add to cart the lowest price dress$")
	public void user_search_with_keyword(String Dress) throws Throwable {
		home = new HomePage(driver);
		assertEquals(home.CheckUserName(), true);
		home.enterSearch(Dress);
		assertEquals(Dress, "dresses");
		home.clickOnSearch();
		home.clickOngrid();
		product_price = home.lowest_productPrice();
		product_name = home.lowest_productPurchase();
	}

	@Then("^lowest price dress is added to cart$")
	public void lowest_price_dress_is_added_to_cart() throws Throwable {
		pop = new CheckOutPopUp(driver);
		assertEquals(true, home.popIsDisplay());
		assertEquals(true, home.popIsDisplay());
		assertEquals("Printed Chiffon Dress", product_name);
		assertEquals(pop.quantity(), "1");
		assertEquals(pop.productTotal(), "$" + product_price);
		assertEquals("$" + product_price, pop.productPrice());
		assertEquals("$2.00", pop.shipping_cost());
		double total = Double.valueOf(product_price);
		double value = total + 2;
		assertEquals("$" + df.format(value), pop.cart_Total());
		pop.closePopup();
		driver.close();

	}

}
