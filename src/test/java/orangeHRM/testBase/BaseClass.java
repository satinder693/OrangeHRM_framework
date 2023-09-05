package orangeHRM.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	public WebDriver driver;
	public Properties prop;
	public Logger logger = LogManager.getLogger(this.getClass());
	@BeforeMethod
	@Parameters("browsername")//from testng.xml
	public void setup(String browser) throws IOException { //it is called setup instead of openBrowser
		
		//reading the config.properties file ->
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Windows\\eclipse-workspace\\framework\\resources\\config.properties"); // copy the path from resource file and paste it here.
		prop.load(fis);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser is launched successfully");
			
		} else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge browser is launched successfully");
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox browser is launched successfully");
		}else {
			logger.info("Supported browsers are chrome / edge/ firefox");
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url")); // make the change here for using config.properties file.
		String appTitle = driver.getTitle();
		Assert.assertEquals(appTitle, "OrangeHRM", "orangeHRM application is not opened");
		//System.out.println("orangeHRM application is opened");
		logger.info("orangeHRM application is opened");
	}
	@AfterMethod
	public void tearDown() {//it is called tearDown instead of closeApplication
		driver.quit();
		System.out.println("Application is closed");
	}
}
