package austin.tool;

import java.util.Map;
import java.util.TreeMap;

public class TestMap {

	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<String, String>();
		
		map.put("A", "Apple");
		map.put("A", "Alex");
		
		System.out.println(map.keySet());
		System.out.println(map.values());
	}
}
