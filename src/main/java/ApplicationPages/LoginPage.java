package ApplicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonClass.BaseClass;
import Helper.ActionHelper;

public class LoginPage extends BaseClass {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement SignIn;

	@FindBy(xpath = "//input[@id='email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement SubmitLogin;

	public void clickOnSignIn() {
		ActionHelper.clickOnElement(driver, SignIn);
	}

	public WebElement enterUsername(String user) {
		waitforElement(driver, username);
		username.sendKeys(user);
		return username;
	}

	public void enterPassword(String pass) {
		
		password.sendKeys(pass);
	}

	public void SubmitLogin() {
		ActionHelper.clickOnElement(driver, SubmitLogin);
	}

}
