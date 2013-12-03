package test.java.util;

public class TestCutUnderLine {

	/**
	 * main 說明： <br>
	 * @param args <br>
	 * @author game<br>
	 */
	public static void main(String[] args) {
		System.out.println(cutUnderLine("A_S_TYPE"));

	}

	public static String cutUnderLine(String line){
		String newLine = line.toLowerCase();
		
		while(newLine.contains("_")){
			int index = newLine.indexOf("_");
			int length = newLine.length();
			
//			System.out.println("index = "+index+"& length="+length);
			
			String headString = (index==0)?"":newLine.substring(0, index);
			String midString = (index==length)?"":newLine.substring(index+1,index+2).toUpperCase();
			String tailString = (index+1>length)?"":newLine.substring(index+2);
			
//			System.out.println("newLine = "+newLine);
//			System.out.println("headString = "+headString);
//			System.out.println("midString = "+midString);
//			System.out.println("tailString = "+tailString);
			
			newLine = headString.concat(midString).concat(tailString);
		}
		
		System.out.println("["+line + "] => ["+ newLine+"]");
		return newLine;
	}
}
