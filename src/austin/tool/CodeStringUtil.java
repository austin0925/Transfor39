package austin.tool;

import java.util.TreeSet;

public class CodeStringUtil {

	public static TreeSet<Integer> indexOfArray(String valueString, String keyString){
		
		valueString = "abcdabcdabcdabcdabcdabcd";
		keyString = "a";
		
		TreeSet<Integer> outSet = new TreeSet<Integer>();
		
		for(int index = 0; index<valueString.length(); index++){
			Integer indexOf = valueString.indexOf(keyString, index);
			if(indexOf!=-1)outSet.add(indexOf);
			index = indexOf==-1?valueString.length()
					:index<indexOf?indexOf
					:index;
//			System.out.println(index);
		}
		System.out.println("END:"+outSet);
		return outSet;
	}
	
}
