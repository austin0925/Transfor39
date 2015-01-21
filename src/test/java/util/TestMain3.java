package test.java.util;

public class TestMain3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange USAOrg = new Orange();
		System.out.println(USAOrg.name);
		
		System.out.println(((Fruit)USAOrg).name);
		
		//無法往下找
//		System.out.println(((Fruit)USAOrg).subber.name);
		
		Fruit USAFruit = new Fruit();
		USAFruit.obj = new Orange();
//		System.out.println((Orange)USAFruit.name));
		System.out.println(((Orange)USAFruit.obj).name);
		
		Orange USAOrange = new Orange();
		System.out.println((((Orange)	((Fruit)USAOrange)	).name));
	}

}


class Fruit{
	
	public Object obj = new Object();
	
	{
		System.out.println("Fruit...Init");
	}
	Fruit(){
		System.out.println("Fruit...");
	}
	public String name = "USAFruit";
}

class Orange extends Fruit{
	{
		System.out.println("Orange...Init");
	}
	Orange(){
		System.out.println("Orange...");
	}
	public String name = "USAOrange";
}

class Banana extends Fruit{
	{
		System.out.println("Banana...Init");
	}
	Banana(){
		System.out.println("Banana...");
	}
	public String name = "USABanana";
}