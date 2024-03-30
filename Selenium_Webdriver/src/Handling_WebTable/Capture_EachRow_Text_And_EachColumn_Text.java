package Handling_WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Capture_EachRow_Text_And_EachColumn_Text {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.get("https://money.rediff.com/mutual-funds");
		Thread.sleep(3000);

		WebElement webtable = driver.findElement(By.className("dataTable"));
		List<WebElement> rows,cols;

		// get Row Colletion from table
		rows= webtable.findElements(By.tagName("tr"));

		//Iterate all rows
		for (WebElement eachrow : rows) {
			// Get each row cell collection
			cols = eachrow.findElements(By.tagName("td"));
			//Iterate all column
			for (WebElement eachcolumn : cols) {
			System.out.print(eachcolumn.getText());	
			}
			System.out.println();
		}
		driver.quit();
	}
}
