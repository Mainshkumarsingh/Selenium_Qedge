package Handlying_Files;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Capture_Text_From_Site {

	public static void main(String[] args) throws Throwable{
		// Create new File
		
		File f = new File("E:\\\\Class Notes\\\\File Handing Selenium data/LaNarsy Capure Text Data.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://lanarsy.com/");
		Thread.sleep(3000);
		
		String para1 = driver.findElement(By.xpath("(//div[@class='tab-content'])[1]")).getText();	
		bw.write(para1);
		bw.close();
		driver.quit();
		
		
		
		

	}

}
