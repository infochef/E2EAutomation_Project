package academy;

import org.testng.annotations.Test;

import resources.Base;

public class HomePage extends Base{
	
	@Test
	public void basePageNavigation() throws Exception {
		
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
	}
}
