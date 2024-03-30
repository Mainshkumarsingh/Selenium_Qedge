package Handlying_Files;

import java.io.BufferedReader;
import java.io.FileReader;

public class Read_LineByLine_from_existing_File {

	public static void main(String[] args) throws Throwable{
		// Read path of file

		FileReader fr = new FileReader("E:\\Class Notes\\File Handing Selenium data\\New folder/LaNarsy Capure Text Data.txt");
		BufferedReader br = new BufferedReader(fr);
		String str = "";
		while ((str=br.readLine())!=null) {
			Thread.sleep(3000);
			System.out.println(str);
		}
		br.close();


	}

}


	