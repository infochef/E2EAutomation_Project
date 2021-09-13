package academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.*;
import resources.Base;

public class ValidateNavigationBar extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void Initialize() throws Exception 
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws Exception
	{
		LandingPage l = new LandingPage(driver);
		System.out.println(l.getNavigationBar().isDisplayed());
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation BAr is working fine");
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}
