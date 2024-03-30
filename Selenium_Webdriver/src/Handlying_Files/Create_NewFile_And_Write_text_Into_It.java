package Handlying_Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Create_NewFile_And_Write_text_Into_It{

	public static void main(String[] args) throws Throwable{

		// Create New File
		
		File f = new File("E:\\Class Notes\\File Handing Selenium data/Jai Shree Ram.docs");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw  = new BufferedWriter(fw);
		bw.write("Jai Shree Ram");
		bw.newLine();
		bw.newLine();
		bw.write("Jai Shree Krishna");
		//bw.flush();//this method is use for push text/Over write to existing file.
		bw.close();
		
	}

}
