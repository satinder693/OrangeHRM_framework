package orangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	public WebDriver driver;
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory .initElements(driver, this);
		
	}
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	WebElement topDshBrdTxt;
	
	public boolean topDashBoardElement() {
		Boolean status = topDshBrdTxt.isDisplayed();
		return status;
	}
}
