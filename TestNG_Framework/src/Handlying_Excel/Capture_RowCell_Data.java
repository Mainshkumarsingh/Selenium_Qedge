package Handlying_Excel;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Capture_RowCell_Data {

	public static void main(String[] args) throws Throwable {
		// Read file source
		FileInputStream fi = new FileInputStream("E:\\Class Notes/Excel_Handlying.xlsx");
		
		// Get Workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		
		//Get sheet from workbook
		XSSFSheet ws = wb.getSheetAt(0);
		
		// Get Row from sheet
		XSSFRow row = ws.getRow(3);
		
		// Number of row in this sheet
		int rc = ws.getLastRowNum();
		System.out.println("Number of Row in this sheet"+"   "+rc);
				
		//Get cell count
		int cc = row.getLastCellNum();
		System.out.println("3rd.Row Data Cell data "+"   "+cc);
		
		//Get Each Cell Data
		XSSFCell c1 = row.getCell(0);
		XSSFCell c2 = row.getCell(1);
		XSSFCell c3 = row.getCell(2);
		XSSFCell c4 = row.getCell(3);
		
		int srn = (int)c1.getNumericCellValue();
		String fName = c2.getStringCellValue();
		String mName = c3.getStringCellValue();
		String lName = c4.getStringCellValue();
		
		System.out.println(srn+fName+mName+lName);
		
		
		
	
wb.close();
	}
}
