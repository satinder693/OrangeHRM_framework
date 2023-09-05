package orangeHRM.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangeHRM.pageObjects.LoginPage;
import orangeHRM.testBase.BaseClass;

public class TC002_forgotPasswordElement extends BaseClass {
	public WebDriver driver;
	
	@Test// test cases will be built here. the methods will be called from login class
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		
		boolean forgotPasswordElement = lp.forgotPasswordEle();
		Assert.assertEquals(forgotPasswordElement, true, "Forgot your Password? link is absent");
		System.out.println("Forgot your Password? link is present");
	}
}
