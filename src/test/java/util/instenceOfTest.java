package test.java.util;

public class instenceOfTest {

	public static void main(String[] args) {
		
		String hello = "hello";
		
		System.out.println(hello instanceof String);
		System.out.println(hello);
		
		hello = null;
		
		System.out.println(hello instanceof String);
		System.out.println(hello);
		
	}
}
