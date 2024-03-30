package Handling_WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Capture_Data_from_Specific_Row_Column {
	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://money.rediff.com/mutual-funds");
		Thread.sleep(3000);
		
		String tabletext0 = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[6]")).getText();
		String tabletext1 = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[6]/td[1]")).getText();
		String tabletext2 = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[6]/td[2]")).getText();
	
		System.out.println(tabletext0);
		System.out.println(tabletext1);
		System.out.println(tabletext2);	
		driver.quit();
		
	}

}
