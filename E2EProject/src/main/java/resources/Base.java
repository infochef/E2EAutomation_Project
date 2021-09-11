package resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public WebDriver initializeDriver() throws Exception {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("F:\\CompleteAtuomation_Framework\\E2EProject\\src\\main\\java\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if(browserName.equalsIgnoreCase("Chrome"))
		{

			//System.setProperty("webdriver.chrome.driver", "F:\\Driver\\chromedriver_win32\\chromedriver.exe");
			//ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup(); //Intializes updated driver base on chrome verison.
			//options.addArguments("--start-maximized");
			driver = new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("Firefox")) 
		{

			//System.setProperty("webdriver.gecko.driver", "F:\\Driver\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		else if(browserName.equalsIgnoreCase("IE")) 
		{

			//System.setProperty("webdriver.ie.driver", "F:\\Driver\\IEDriverServer_x64_3.150.2\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
