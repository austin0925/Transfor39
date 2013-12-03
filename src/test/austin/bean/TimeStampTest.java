package test.austin.bean;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TimeStampTest {

	public static void main(String args[]){
		System.out.println("getString()="+getString());
		
		System.out.println("...END");
	}
	
	public static String getString(){
		String ans="";
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String custCd = "A";
		String yearString = timestamp.toString().substring(0, 4);
		System.out.println("yearString="+yearString);	
		String monthString = timestamp.toString().substring(5, 7);
		System.out.println("monthString="+monthString);	
		
		int year = Integer.valueOf(yearString)-1911;
		NumberFormat formatter = new DecimalFormat("000");
		yearString = formatter.format(year);
		
		ans = custCd+yearString+monthString;
		
		return ans;
	}
}
