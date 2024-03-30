package Conditional_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class To_Handle_isEnabled_isDisplayed_isSelected {

	public static void main(String[] args) throws Throwable{
		// To_Handle_isEnabled_isDisplayed_isSelected over Facebook
		
		//Create a webDriver Object Instance
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Go to facebook page via chrome browser
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		
		//	click over crate new account button
		driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
		Thread.sleep(3000);
		//verify first name text box is enabled or not
		WebElement first_name = driver.findElement(By.xpath("//*[contains(@placeholder,'First')]"));
		String firstname_pagetitle = driver.getTitle();
		boolean firstname_isenabled = first_name.isEnabled();
		System.out.println(firstname_pagetitle+"           "+"first name is enabled="+firstname_isenabled);
		Thread.sleep(1000);
		
		//verify re-enter Email Address text box is displayed or hidden
		WebElement reenter_email = driver.findElement(By.xpath("(//*[contains(@name,'reg_email_')])[2]"));
		boolean reemail_displayed = reenter_email.isDisplayed();
		System.out.println("Reenter Email is displays"+"   ="+reemail_displayed);
		
		//verify radio buttons are selected or not
		WebElement radio_button = driver.findElement(By.xpath("(//*[contains(@class,'_58mt')])[3]"));
		boolean radiobutton_selected = radio_button.isSelected();
		System.out.println("Radio buttons are selected"+"    "+radiobutton_selected);
		
		
	
		
		
		
		
		driver.quit();
		
		
			
			
	 

		
		
		
	}

}