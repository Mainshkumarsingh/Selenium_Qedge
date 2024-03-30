package Extra_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automate_google_Suggestions {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		String expected = "wikipedia";
		
		driver.findElement(By.xpath("//*[@name= 'q']")).sendKeys("vikas divyakirti");                           	     
		Thread.sleep(3000);

		List<WebElement> disiphonesugg = driver.findElements(By.xpath("//*[@class= 'sbct']"));
		System.out.println("Total suggestions displayed"+"     "+disiphonesugg.size());

	System.out.println(driver.getTitle());

		for (WebElement each : disiphonesugg) {

			if (expected.contains("wikipedia")) {
				each.click();
				break;
				
			}
		}	
		System.out.println(driver.getTitle());

	}

}
