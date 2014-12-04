package test.java.util;

import java.sql.Timestamp;

public class TestTimestamp {

	public static void main(String[] args) {
		Long nowL = System.currentTimeMillis();
		
		Long test1 = nowL % (3L*60L*60L*1000L);
		System.out.println(test1);
		System.out.println(new Timestamp(test1));
		
		Long test2 = nowL - test1;
		System.out.println(test2);
		System.out.println(new Timestamp(test2));
		
		Long test3 = nowL - test1 + (1L*60L*60L*1000L);
		System.out.println(test3);
		System.out.println(new Timestamp(test3));
		
		Long test4 = nowL - test1 - (2L*60L*60L*1000L);
		System.out.println(test4);
		System.out.println(new Timestamp(test4));
		
		
		
	}
}
