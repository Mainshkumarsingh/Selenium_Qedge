package PageAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {

	//WebDriver driver;
		/*
		 * public AdminLoginPage(WebDriver driver) { this.driver=driver; }
		 */
	//Define Repository for Login
		
	@FindBy(xpath = "//input[@id=\"txtUsername\"]")
		WebElement ObjUser;
		@FindBy(xpath = "//input[@id=\"txtPassword\"]")
		WebElement ObjPass;
		@FindBy(xpath = "//input[@id=\"btnLogin\"]")
		WebElement ObjLogin;
		
		//write method for login
		public void adminLogin(String user,String pass)
		{
			
			ObjUser.sendKeys(user);
			ObjPass.sendKeys(pass);
			ObjLogin.click();
		}
		
}
