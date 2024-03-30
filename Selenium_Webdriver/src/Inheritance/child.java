package Inheritance;

import org.openqa.selenium.By;

public class child extends Parent{
public static void clickbranch()
{
driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']//img")).click();
}	
	public static void main(String[] args) {
	// Call methods launchurl,login,clickbranches
		
		Parent.launchurl("http://primusbank.qedgetech.com/");
		Parent.login("Admin", "Admin");
		child.clickbranch();
		driver.quit();
	}
}
