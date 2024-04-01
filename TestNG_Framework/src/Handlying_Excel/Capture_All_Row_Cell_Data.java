package Handlying_Excel;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Capture_All_Row_Cell_Data {

	public static void main(String[] args) throws Throwable {
		// Read Source path of excel
		
				FileInputStream fi = new FileInputStream("E:\\Class Notes/Excel_Handlying.xlsx");
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				XSSFSheet ws = wb.getSheetAt(0);
				int allrowcount = ws.getPhysicalNumberOfRows();
				System.out.println(allrowcount);
				int rc = ws.getLastRowNum();
				
				//Print all row cell data
				
			for(int i=1;i<=rc;i++)
			{
				int srn = (int) ws.getRow(i).getCell(0).getNumericCellValue();
				String fname = ws.getRow(i).getCell(1).getStringCellValue();
				String mname = ws.getRow(i).getCell(2).getStringCellValue();
				String lname = ws.getRow(i).getCell(3).getStringCellValue();
				
				
				System.out.println(srn+"  "+fname+"  "+mname+"  "+lname+"  ");
				
		
			}
			wb.close();
	}
}
