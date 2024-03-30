package Handling_WebTable;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class How_many_rows_And_Columns {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://money.rediff.com/mutual-funds");
		Thread.sleep(3000);

		WebElement webtable =driver.findElement(By.xpath("//table[@class='dataTable']"));
		List<WebElement> rowcount =	webtable.findElements(By.tagName("tr"));
		System.out.println(rowcount.size());
		for (WebElement eachrow : rowcount) {
			String rowname= eachrow.getText();
			System.out.println(rowname);
		}
		for(int i=1;i<rowcount.size();i++) {
			List<WebElement> colcount =	rowcount.get(i).findElements(By.tagName("td"));
			System.out.println("row Number"+i+"coloum  size"+colcount.size());
		}
		driver.quit();
		
	}
}