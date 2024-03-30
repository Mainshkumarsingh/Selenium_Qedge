package Handling_WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class To_Check_country_Found_in_Table_or_Not {
	public static void main(String[] args) throws Throwable {

		String expected_country ="india";
		boolean country_exist =false;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(5000);
		WebElement webtable =driver.findElement(By.id("customers"));
		List<WebElement> rows,cols;
		rows = webtable.findElements(By.tagName("tr"));
		int row = rows.size()-1;
		System.out.println("No of rows are::"+row);
		for (WebElement eachrow : rows) {
			cols = eachrow.findElements(By.tagName("td"));
			for (WebElement eachcell : cols) {
				String actual_data =eachcell.getText();
				System.out.print("\n"+actual_data);
				if(actual_data.equalsIgnoreCase(expected_country))
				{
					country_exist=true;
					break;
				}
			}
			System.out.println();
			System.out.println("====================================");

		}
		if(country_exist)
		{
			System.out.println(expected_country+"    "+"Country Found in Table");
		}
		else
		{
			System.out.println(expected_country+"    "+"Country Not Found in Table");
		}
		driver.quit();	



	}
}
