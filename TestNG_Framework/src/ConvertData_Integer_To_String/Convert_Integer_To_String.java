package ConvertData_Integer_To_String;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Convert_Integer_To_String {

	
	
	public static void main(String[] args) throws Throwable{
		
		FileInputStream fi  = new FileInputStream("E:\\Class Notes/Excel_Handlying.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(0);
		int rowcount = ws.getLastRowNum();
		
		for(int i=1;i<=rowcount;i++)
		{
		if(ws.getRow(i).getCell(0).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int celldata = (int) ws.getRow(i).getCell(0).getNumericCellValue();
			String serialnum = String.valueOf(celldata);
			System.out.println(serialnum);
		}
		}
		FileOutputStream fo = new FileOutputStream("E:\\Class Notes/Generated File.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
		

	}

}
