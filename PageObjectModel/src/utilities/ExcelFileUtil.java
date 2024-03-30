package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelFileUtil {
	XSSFWorkbook wb;
	//constructor for reading excel path
	public ExcelFileUtil(String ExcelPath)throws Throwable
	{
		FileInputStream fi =  new FileInputStream(ExcelPath);
		wb = new XSSFWorkbook(fi);
	}
	//method for counting no rows in a sheet
	public int rowCount(String sheetName) 
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}
	//method for reading celldata
	public String getCellData(String sheetName,int row,int column)
	{
		String data ="";
		if(wb.getSheet(sheetName).getRow(row).getCell(column).getCellType()==org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC)
		{
			int celldata =(int)wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
			data=String.valueOf(celldata);
		}
		else
		{
			data =wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
		
	}
	// method  for writing results
	public void setCellData(String sheetname,int row,int column,String status,String WriteExcel) throws Throwable
	{
		//get sheet from wb
		XSSFSheet ws = wb.getSheet(sheetname);
		//get row from sheet
		XSSFRow rowNum =ws.getRow(row);
		//create cell in a row
		XSSFCell cell = rowNum.createCell(column);
		cell.setCellValue(status);
		if(status.equalsIgnoreCase("pass"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(row).getCell(column).setCellStyle(style);
							
		}
		else if(status.equalsIgnoreCase("Fail"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(row).getCell(column).setCellStyle(style);
		}
		else if(status.equalsIgnoreCase("Blocked"))
		{
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(row).getCell(column).setCellStyle(style);
		}
		FileOutputStream fo = new FileOutputStream(WriteExcel);
		wb.write(fo);
		
	}
	/*public static void main(String[] args) throws Throwable {
	ExcelFileUtil x1 = new ExcelFileUtil("E:\\Class Notes/Sample_Handlying.xlsx");
	int rowcount = x1.rowCount("Details");
	for(int i=1;i<=rowcount;i++)
	{
		String fname = x1.getCellData("Details", i, 0);
		String mname = x1.getCellData("Details", i, 1);
		String lname = x1.getCellData("Details", i, 2);
		String eid = x1.getCellData("Details", i, 3);
		System.out.println(fname+mname+lname+eid);
		x1.setCellData("Details", i, 4, "Pass", "E:\\Class Notes/SampleResult_Handlying.xlsx");
		
	}
	
		
		
		
	}*/
	
	
	
	
	
}
