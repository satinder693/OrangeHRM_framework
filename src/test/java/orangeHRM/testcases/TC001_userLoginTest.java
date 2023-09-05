package orangeHRM.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangeHRM.pageObjects.Dashboard;
import orangeHRM.pageObjects.LoginPage;
import orangeHRM.testBase.BaseClass;

public class TC001_userLoginTest extends BaseClass{


	@Test// test cases will be built here. the methods will be called from login class
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		//enter username method
		lp.enterUserName(prop.getProperty("username"));
		//enter password method
		lp.enterPassword(prop.getProperty("password"));
		//click on login button method
		lp.clickLogin();
		// how to verify that login has been successful
		Dashboard db = new Dashboard(driver);
		boolean dashelement = db.topDashBoardElement();
		
		Assert.assertEquals(dashelement, true, "user did not log in successfully");
		System.out.println("user logged in successfully");
			}
	
}
