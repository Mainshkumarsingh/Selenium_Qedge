package SetCellValue_WithCustomisedFontStyle;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SetCellValue_In_CreatedCell {

	public static void main(String[] args) throws Throwable{
	
		FileInputStream fi = new FileInputStream("E:\\Class Notes/Excel_Handlying.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(0);
		int eachrow = ws.getLastRowNum();
		for(int i=1;i<=eachrow;i++)
		{
		//Create a cell and write PASS and FAIL Respectively with customized font and style(Color)	
		ws.getRow(i).createCell(4).setCellValue("PASS");
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBold(true);
		style.setFont(font);
		ws.getRow(i).getCell(4).setCellStyle(style);		
		}
fi.close();
FileOutputStream fo = new FileOutputStream("E:\\Class Notes/Style Font Setting.xlsx");
wb.write(fo);
fo.close();
wb.close();


	}

}
