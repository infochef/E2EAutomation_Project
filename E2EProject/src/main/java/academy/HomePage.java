package academy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.*;
import resources.Base;

public class HomePage extends Base{
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password) throws Exception {
		
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		Object[][] data = new Object[1][2];
		//0th row
		data[0][0]="test.data@gmail.com";
		data[0][1]="testdata";
		//1st row
		/*
		 * data[1][0]="test@gmail.com"; data[1][1]="test";
		 */
		
		return data;
	}
}
