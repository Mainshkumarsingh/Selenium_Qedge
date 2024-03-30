package Handling_WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class To_Capture_Date_from_calaender {

	public static void main(String[] args) throws Throwable {

		String doj = "12/Nov/1973";
		String temp[] = doj.split("/");
		String date =temp[0];
		String month = temp[1];
		String year = temp[2];
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://flights.qedgetech.com/");
		Thread.sleep(3000);
		//Click on Register Link
		driver.findElement(By.xpath("//a[@href='http://flights.qedgetech.com/register.html']")).click();
		//CLick on date of birth box
		driver.findElement(By.xpath("//input[@id='popupDatepicker']")).click();
		Thread.sleep(2000);
		//Select year from list box
		new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"))).selectByVisibleText(year);
		new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"))).selectByVisibleText(month);
		//locate date table
		WebElement datetable = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
		List<WebElement> rows,cols;
		rows= datetable.findElements(By.tagName("tr"));
		//get row collection
		for (WebElement eachrow : rows) {
			System.out.println(eachrow.getSize());
			cols=datetable.findElements(By.tagName("td"));
			for (WebElement eachcol : cols) {
				if(eachcol.getText().equals(date))
				{
					eachcol.click();
					}

			}				
		}

		driver.quit();
	}

}
