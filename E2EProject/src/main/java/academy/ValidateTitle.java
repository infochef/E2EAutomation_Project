package academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.*;
import resources.Base;

public class ValidateTitle extends Base{

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
		Assert.assertEquals(l.getTitle().getText() ,  "FEATURED COURSES");
		log.info("Title is validated succesfully");
	}

	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}
