package PageAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {

	
	//define repository for logout
	
		@FindBy(xpath = "//a[@id=\"welcome\"]")
		WebElement ObjWelcome;
		@FindBy(xpath = "//a[normalize-space()=\"Logout\"]")
		WebElement ObjLogout;
		
		//method for logout
		public void adminLogout()
		{
			ObjWelcome.click();
			ObjLogout.click();
		}
}
