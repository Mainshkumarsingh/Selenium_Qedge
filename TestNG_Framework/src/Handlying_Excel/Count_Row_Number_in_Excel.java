package Handlying_Excel;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Count_Row_Number_in_Excel{
	
	public static void main(String[] args) throws Throwable {

	
		//Read Path of FIle
		FileInputStream fi = new FileInputStream("E:\\Class Notes/Excel_Handlying.xlsx");
	
		//Get Work book from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		
		//Get sheet from Wb
		XSSFSheet ws = wb.getSheet("Details");

		//get First row from sheet
		XSSFRow row = ws.getRow(0);
		
		//Count number of Row and print
		int rc = ws.getLastRowNum();
		System.out.println(rc);
		
		//Count number of column and print
		
		int cc = row.getLastCellNum();
		System.out.println(cc);	
	
		fi.close();
		wb.close();
	}
	
}
