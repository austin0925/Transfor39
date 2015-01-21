package test.java.util;

public class TestMain{

	{
		System.out.println("B...");
	}
	
	TestMain(){
		System.out.println("A...");
	}
	
	
	public void call(){
		System.out.println("call...");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start...");
//		TestMain testObj = new TestMain();
//		testObj.call();
		new TestMain().call();
		System.out.println("end...");
//		call();
//		Apple jap = new Apple();
//		Apple usa = new Apple();
//		System.out.println(jap.name);
//		System.out.println(usa.name);
//		
//		jap.name = "austin";
//		
//		System.out.println(jap.name);
//		System.out.println(usa.name);
		
	}
}

class Apple{
	public static final String name= "Apple";
}

