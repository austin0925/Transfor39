package test.java.util;

public class TestMain2{

	public String nameA = "Apple";
	
	TestMain2(){}
	
	TestMain2(String name){
		nameA = name;
	}
	
	public static void main(String[] args){
		TestMain2 test = new TestMain2("USA");
		System.out.println(test.nameA);
		test.call();
	}
	
	public void call(){
		System.out.println("call..");
	}
	
}

