package commonFunction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.PropertyFileUtil;

public class FunctionLibrary {

	public static WebDriver driver;
	//method for start browser
		public static WebDriver startBrowser()throws Throwable
		{
			if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("Browser value not matching");
			}
			return driver;
		}
		//method for launch url
		public static void openUrl(WebDriver driver)throws Throwable
		{
			driver.get(PropertyFileUtil.getValueForKey("Url"));
		}
		//method for waitForElement
		public static void waitForElement(WebDriver driver,String Locator_type,String Locator_Value,String wait)
		{
			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(wait)));
			if(Locator_type.equalsIgnoreCase("name"))
			{
				mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name(Locator_Value)));
			}
			if(Locator_type.equalsIgnoreCase("xpath"))
			{
				mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator_Value)));
			}
			if(Locator_type.equalsIgnoreCase("id"))
			{
				mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locator_Value)));
			}
		}
	//method for textboxes
		public static void typeAction(WebDriver driver,String Locator_Type,String Locator_Value,String Test_Data)
		{
			if(Locator_Type.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id(Locator_Value)).clear();
				driver.findElement(By.id(Locator_Value)).sendKeys(Test_Data);
			}
			if(Locator_Type.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(Locator_Value)).clear();
				driver.findElement(By.name(Locator_Value)).sendKeys(Test_Data);
			}
			if(Locator_Type.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(Locator_Value)).clear();
				driver.findElement(By.xpath(Locator_Value)).sendKeys(Test_Data);
			}
		}
		//method for links,buttons,checkboxes,radiobuttons and images
		public static void clickAction(WebDriver driver,String Locator_Type,String Locator_Value)
		{
			if(Locator_Type.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(Locator_Value)).click();
			}
			if(Locator_Type.equalsIgnoreCase("name"))
			{
				driver.findElement(By.name(Locator_Value)).click();
			}
			if(Locator_Type.equalsIgnoreCase("id"))
			{
				driver.findElement(By.id(Locator_Value)).sendKeys(Keys.ENTER);
			}
		}
		//method for title validation
		public static void validateTitle(WebDriver driver,String Expected_Title)
		{
			String Actual_Title= driver.getTitle();
			try {
				Assert.assertEquals(Expected_Title, Actual_Title, "Title is Not Matching");
			}catch(Throwable t)
			{
				System.out.println(t.getMessage());
			}
		}
		//method for closing browser
		public static void closeBrowser(WebDriver driver)
		{
			driver.close();
		}
		//method for date formate
		public static String generateDate()
		{
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("YYYY_MM_dd");
			return df.format(date);
		}
		//method for mouse click
		public static void mouseClick(WebDriver driver) throws Throwable
		{
			Actions ac = new Actions(driver);
			
			ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"mi_a_stock_items\"]/a"))).perform();
			Thread.sleep(3000);
			ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"mi_a_stock_categories\"]/a"))).click().perform();
			Thread.sleep(3000);
		}
		//method for category table
		public static void categoryTable(WebDriver driver,String Exp_Data) throws Throwable
		{
			if(! driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-textbox"))).isDisplayed())
				driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-panel"))).click();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-textbox"))).sendKeys(Exp_Data);
			Thread.sleep(3000);
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-button"))).click();
			Thread.sleep(3000);
			//capture data from table
			String Act_Data =driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[4]/div/span/span")).getText();
			try {
				Assert.assertEquals(Exp_Data, Act_Data, "Category name is Not Matching");
			}catch(Throwable t)
			{
				System.out.println(t.getMessage());
			}
		}
		//method for drop down or listboxes
		public static void dropDownAction(WebDriver driver, String Locator_Type, String Locator_value, String Test_Data) throws Exception
		{
			if(Locator_Type.equalsIgnoreCase("xpath"))
			{
				int value = Integer.parseInt(Test_Data);
				WebElement element = driver.findElement(By.xpath(Locator_value));
				Select select = new Select(element);
				select.selectByIndex(value);
				
			}
			if(Locator_Type.equalsIgnoreCase("id"))
			{
				int value = Integer.parseInt(Test_Data);
				WebElement element = driver.findElement(By.id(Locator_value));
				Select select = new Select(element);
				select.selectByIndex(value);
				
			}
			if(Locator_Type.equalsIgnoreCase("name"))
			{
				int value = Integer.parseInt(Test_Data);
				WebElement element = driver.findElement(By.name(Locator_value));
				Select select = new Select(element);
				select.selectByIndex(value);
			}
		
	}
		//method for capture stock number
			public static void captureStocknum(WebDriver driver,String Locator_Type,String Locator_Value)throws Throwable
			{
				String Exp_Data="";
				if(Locator_Type.equalsIgnoreCase("name"))
				{
					Exp_Data= driver.findElement(By.name(Locator_Value)).getAttribute("value");
				}
				if(Locator_Type.equalsIgnoreCase("id"))
				{
					Exp_Data= driver.findElement(By.id(Locator_Value)).getAttribute("value");
				}
				if(Locator_Type.equalsIgnoreCase("xpath"))
				{
					Exp_Data= driver.findElement(By.xpath(Locator_Value)).getAttribute("value");
				}
				FileWriter fw = new FileWriter("./CaptureData/stocknum.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(Exp_Data);
				bw.flush();
				bw.close();
				
			}
			//method stock item table
			public static void stockItemTable(WebDriver driver)throws Throwable
			{
				FileReader fr = new FileReader("./CaptureData/stocknum.txt");
				BufferedReader br = new BufferedReader(fr);
				String Exp_stockNum =br.readLine();
				if(! driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-textbox"))).isDisplayed())
					driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-panel"))).click();
				driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-textbox"))).sendKeys(Exp_stockNum);
				Thread.sleep(3000);
				driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-button"))).click();
				Thread.sleep(3000);
				String Act_StockNum = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[8]/div/span/span")).getText();
				try {
				Assert.assertEquals(Exp_stockNum, Act_StockNum, "Stock Number is not Matching");
				}catch(Throwable t)
				{
					System.out.println(t.getMessage());
				}
				br.close();
			}
			//method for capture supplier number
			public static void capturesuppnum(WebDriver driver,String Locator_Type,String Locator_Value)throws Throwable
			{
				String Exp_Data="";
				if(Locator_Type.equalsIgnoreCase("name"))
				{
					Exp_Data= driver.findElement(By.name(Locator_Value)).getAttribute("value");
				}
				if(Locator_Type.equalsIgnoreCase("id"))
				{
					Exp_Data= driver.findElement(By.id(Locator_Value)).getAttribute("value");
				}
				if(Locator_Type.equalsIgnoreCase("xpath"))
				{
					Exp_Data= driver.findElement(By.xpath(Locator_Value)).getAttribute("value");
				}
				FileWriter fw = new FileWriter("./CaptureData/suppliernum.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(Exp_Data);
				bw.flush();
				bw.close();
			}
			//method supplier table
			public static void suppliertable(WebDriver driver)throws Throwable
			{
				FileReader fr = new FileReader("./CaptureData/suppliernum.txt");
				BufferedReader br = new BufferedReader(fr);
				String Exp_supNum =br.readLine();
				if(! driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-textbox"))).isDisplayed())
					driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-panel"))).click();
				driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-textbox"))).sendKeys(Exp_supNum);
				Thread.sleep(3000);
				driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-button"))).click();
				Thread.sleep(3000);
				String Act_SupNum = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
				try {
					Assert.assertEquals(Exp_supNum, Act_SupNum, "Supplier Number is not Matching");
					}catch(Throwable t)
					{
						System.out.println(t.getMessage());
					}
				br.close();
			}
			
			// Method for capture customer Number
			public static void capturecustnum(WebDriver driver,String Locator_Type,String Locator_Value)throws Throwable
			{
				String Exp_Data="";
				if(Locator_Type.equalsIgnoreCase("name"))
				{
					Exp_Data= driver.findElement(By.name(Locator_Value)).getAttribute("value");
				}
				if(Locator_Type.equalsIgnoreCase("id"))
				{
					Exp_Data= driver.findElement(By.id(Locator_Value)).getAttribute("value");
				}
				if(Locator_Type.equalsIgnoreCase("xpath"))
				{
					Exp_Data= driver.findElement(By.xpath(Locator_Value)).getAttribute("value");
				}
				FileWriter fw = new FileWriter("./CaptureData/custrnum.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(Exp_Data);
				bw.flush();
				bw.close();
			}
			
			//method Customer table
			public static void customertable(WebDriver driver)throws Throwable
			{
				FileReader fr = new FileReader("./CaptureData/custrnum.txt");
				BufferedReader br = new BufferedReader(fr);
				String Exp_custNum =br.readLine();
				if(! driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-textbox"))).isDisplayed())
					driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-panel"))).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-textbox"))).sendKeys(Exp_custNum);
				Thread.sleep(3000);
				driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("search-button"))).click();
				Thread.sleep(3000);
				String Act_CustNum = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")).getText();
				try {
					Assert.assertEquals(Exp_custNum, Act_CustNum, "Supplier Number is not Matching");
					}catch(Throwable t)
					{
						System.out.println(t.getMessage());
					}	
			br.close();
			}
			
}
