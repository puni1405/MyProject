package org.testleaf.leaftaps.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testleaf.leaftaps.utils.ReadExcel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectBase {

	public String excelFileName;

	public static WebDriver driver;

	@Parameters("browser")

	@BeforeMethod
	/*
	 * public void launchApp() {
	 * 
	 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 * driver = new ChromeDriver(); driver.manage().window().maximize();
	 * driver.get("http://leaftaps.com/opentaps/");
	 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 * 
	 * }
	 */
	public void launchApp(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.out.println("Launching Firefox Browser....");
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.out.println("Launching Chrome Browser....");
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver();
		}

		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("edge")) { // set path to Edge driver.exe
			System.out.println("Launching Edge Browser....");
			System.setProperty("webdriver.edge.driver", ".\\drivers\\MicrosoftWebDriver.exe"); //
			// create Edge instance
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) { // set path to Edge driver.exe
			System.out.println("Launching IE Browser....");
			System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe"); //
			// create Edge instance
			driver = new InternetExplorerDriver();
		}

		else

		{
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeApp() {
		driver.close();
	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		ReadExcel excel = new ReadExcel();
		return excel.excelRead(excelFileName);
	}

}
