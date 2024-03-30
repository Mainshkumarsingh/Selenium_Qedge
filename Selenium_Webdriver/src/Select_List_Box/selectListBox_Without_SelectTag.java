package Select_List_Box;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class selectListBox_Without_SelectTag {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		Thread.sleep(2000);
		

		WebElement listelement = driver.findElement(By.xpath("(//a[@class='btn-primary dropdown-toggle btn-block'])[1]"));
		listelement.click();
		List<WebElement> productlist=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		System.out.println(productlist.size());	
			
		for (WebElement product : productlist) {
			System.out.println(product.getText());
			if (product.getText().equalsIgnoreCase("credit card services")) {

				product.click();
				break;
			}
			
		}

	}
}