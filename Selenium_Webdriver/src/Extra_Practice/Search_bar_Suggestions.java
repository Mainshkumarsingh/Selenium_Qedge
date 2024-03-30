package Extra_Practice;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search_bar_Suggestions {

	public static void main(String[] args) throws Throwable {
		//  create a instance object

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		
		driver.findElement(By.name("q")).sendKeys("selenium openings ");
		Thread.sleep(5000);
		String expected = "selenium openings in chennai";
		List<WebElement> dropdown = driver.findElements(By.xpath("//li[@role= 'presentation']"));
		
		
		System.out.println("No of dropdown elements: "+dropdown.size() );
		
		for (WebElement each : dropdown) {
			String actual = each.getText();
			if (actual.equals(expected)) {
				each.click();
				break;
								
			}
		}	
	}}