package orangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username")
	WebElement txtUsername;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	@FindBy(xpath="//div[@class='orangehrm-login-forgot']")
	WebElement forgottxt;
	
	public boolean forgotPasswordEle() {
		boolean status = forgottxt.isDisplayed();
		return status;
	}
	public void enterUserName(String val) {
		txtUsername.clear();
		txtUsername.sendKeys(val);
		String valEntered = txtUsername.getAttribute("value");
		System.out.println("value entered in the username field is -"+valEntered);
	}
	public void enterPassword(String val) {
		txtPassword.clear();
		txtPassword.sendKeys(val);
		String ValEntered = txtPassword.getAttribute("value");
		System.out.println("value entered in the password fiels id "+ValEntered);
	}
	public void clickLogin() {
		loginButton.click();
	}
}

