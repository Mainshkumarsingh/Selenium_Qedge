package Handling_WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class select_Date_from_Calender_WithoutSelect_Class {

	public static void main(String[] args) throws Throwable {

		String doj = "22-October-2024";
		String temp[]= doj.split("-");
		String date = temp[0];
		String month = temp[1];
		String year = temp[2];

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jqueryui.com/datepicker/");
		Thread.sleep(2000);

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@class='hasDatepicker']")).click();

		// capture year from calendar
		String calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		while (!calyear.equals(year)) {	
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		}

		//capture month from calendar
		String calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		while (!calmonth.equalsIgnoreCase(month)) {		
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}

		// capture date table from calendar
		WebElement datetable = driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> rows,cols;
		rows=datetable.findElements(By.tagName("tr"));
		for (WebElement eachrow : rows) {
			cols=eachrow.findElements(By.tagName("td"));
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

