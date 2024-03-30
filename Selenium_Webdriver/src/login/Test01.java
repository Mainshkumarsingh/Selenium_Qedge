package login;

import java.util.Iterator;

public class Test01 {
public static void main(String[] args) {
	
	// 1. Using String Concatenation Method	
	String str = "abcd";
	String rev = "";	
	int len = str.length(); //4		
	for(int i =0;i<len;i++) //3210
	{
		rev =rev+str.charAt(len-1-i);//dcba
	}	
	System.out.println("Reverse String is ="+"   "+ rev);
	
	
	
	// 2. Using Character Array
	
	/*char a[]=str.toCharArray();
	int len = a.length;
	for(int i = len-1;i>=0;i--)
	{
	rev = rev+a[i];	
	}
	System.out.println(rev);
	*/
	
	/*
	// Using String BufferClas
	StringBuffer sb = new StringBuffer(str);
	System.out.println(sb.reverse());
	*/
	}

}