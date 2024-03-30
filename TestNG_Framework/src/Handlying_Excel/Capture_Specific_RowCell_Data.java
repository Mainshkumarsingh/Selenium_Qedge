package Handlying_Excel;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Capture_Specific_RowCell_Data {

	public static void main(String[] args) throws Throwable {
		// Read Source path of excel
		
		FileInputStream fi = new FileInputStream("E:\\Class Notes/Excel_Handlying.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(0);
		
		//Print any row first cell data
		int srn = (int) ws.getRow(2).getCell(0).getNumericCellValue();
		String fname = ws.getRow(2).getCell(1).getStringCellValue();
		String mname = ws.getRow(2).getCell(2).getStringCellValue();
		String lname = ws.getRow(2).getCell(3).getStringCellValue();
		
		System.out.println(srn+fname+mname+lname);
		
wb.close();
	}

}
