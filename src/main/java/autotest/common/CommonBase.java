package autotest.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonBase {

	public CommonBase() {
		// TODO Auto-generated constructor stub
	}
	
	//Start browser
	WebDriver driver;
	public WebDriver startBrower(String url, String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}
		
		getDriver().manage().window().maximize();	
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeBrowser(WebDriver dr) {
		dr.close();
	}

	/**
	 * pause driver in timeInMillis
	 * 
	 * @param timeInMillis
	 */
	public void pause(long secondS) {
		try {
			Thread.sleep(secondS*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//close browser
	//hàm đợi

}
