package Questions;

import java.util.Iterator;

public class Countof_Lower_Upper_Letter {

	public static void main(String[] args) {
		
		String str = "WelcomeToSelenium";
		int lowe = 0;
		int upper = 0;				
		for(int i=0;i<str.length();i++)
		{
		char ch = str.charAt(i)	;
		if(ch>=65 && ch<=90)
		{
			upper++;
		}
		else
		{
			lowe++;
		}
		}
		System.out.println("lowe = "+lowe);
		System.out.println("upper = "+upper);
	}	
}
