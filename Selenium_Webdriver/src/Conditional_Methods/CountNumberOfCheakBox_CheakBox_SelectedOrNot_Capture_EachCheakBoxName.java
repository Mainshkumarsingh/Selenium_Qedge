package Conditional_Methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountNumberOfCheakBox_CheakBox_SelectedOrNot_Capture_EachCheakBoxName {

	public static void main(String[] args) throws Throwable {
		// CountNumberOfCheakBox
		// CheakBox_SelectedOrNot
		// Capture_EachCheakBoxName
		// Cheak uncheaked boxes and uncheak cheaked boxes
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.manage().deleteAllCookies();
		driver.get("file:///E:/Software%20Testing/checkbox_1_lyst1698.html");
		Thread.sleep(2000);
		
		//Get Collections of check boxes in webpage
		List<WebElement>all_checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("No of Checklist         "+all_checkboxes.size());
		
		//Iterate all checkboxes
		for (WebElement each : all_checkboxes) {

		// Verify each cheakboxes which is selected or not
		boolean value = each.isSelected();

		//capture each check box name
		String cheakbox_name = each.getAttribute("value");
		System.out.println(cheakbox_name+"    "+value);
		Thread.sleep(1000);
		

		// check all uncheacked box and uncleck all checked list box
		each.click();
		System.out.println(cheakbox_name+"   "+"after click"+"    "+each.isSelected());
		each.click();
		System.out.println(cheakbox_name+"   "+"after click2"+"    "+each.isSelected());
		each.click();
		System.out.println(cheakbox_name+"   "+"after click3"+"    "+each.isSelected());
		
		
		}
		driver.quit();
	}
		}				

