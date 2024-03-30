package Extra_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automate_Flipkart_searchsuggestions {

	public static void main(String[] args) throws Throwable {

		// Create Object Instance

		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("iphone13");
		                            	//input[@title='Search for products, brands and more']     
		Thread.sleep(3000);
		String expected = "pro";
		
		List<WebElement> disiphonesugg = driver.findElements(By.xpath("//li[@class='_3D0G9a']"));
		System.out.println("Total suggestions displayed"+"     "+disiphonesugg.size());

		for (WebElement each : disiphonesugg) {
        String suggnames = each.getText();
        System.out.println(suggnames);
        
			//if (expected.contains("pro")) {
				//each.click();
				//break;
			}
		}	
	} 
//}
