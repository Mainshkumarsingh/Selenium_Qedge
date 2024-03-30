package Action_Class;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RobotClassMethod_MouseMethod_Context_click {

	public static void main(String[] args) throws Throwable {
		// Right click on G-mail by using context click method,open g-mail link in new
		//window by using robot class method.
		

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		
		Actions ac = new Actions(driver);
		
		// Move mouse to gmail and right click
		ac.moveToElement(driver.findElement(By.linkText("Gmail"))).contextClick().perform();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		// Create Object for Robot Class
		Robot r = new Robot();
		//Press Down Arrow in keyboard
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		//click enter key in keyboard
		r.keyPress(KeyEvent.VK_ENTER);
		//store all window in Array List
		Thread.sleep(3000);
		
	ArrayList<String> brw = new ArrayList<String>(driver.getWindowHandles());
	// switch to child window Gmail
	driver.switchTo().window(brw.get(1));
	Thread.sleep(3000);
	//Move to create account
	ac.moveToElement(driver.findElement(By.xpath("(//span[text()='Create an account'])[1]"))).click().perform();
	System.out.println(driver.getTitle());
	Thread.sleep(5000);
	driver.close();
	driver.switchTo().window(brw.get(0));
	Thread.sleep(3000);
	ac.moveToElement(driver.findElement(By.linkText("Images"))).click().perform();
	System.out.println(driver.getTitle());
	driver.close();
	
	
	
	}

}
