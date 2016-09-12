package idv.austin.tool;

import java.util.Map;
import java.util.TreeMap;

public class TestMap {

	public static void main(String[] args) {
		TestMap test = new TestMap();
		test.duplicate();
		test.duplicate2();
		test.duplicate3();
	}
	
	
	public void duplicate(){
		Map<String, String> map = new TreeMap<String, String>();
		
		map.put("A", "Apple");
		map.put("A", "Alex");
		
		System.out.println(map);
		System.out.println("[END]");
	}
	
	public void duplicate2(){
		Map<String, Long> map = new TreeMap<String, Long>();
		
		map.put("A", System.nanoTime());
		System.out.println(map);
		
		map.put("A", System.nanoTime()+(5L * 60L * 1000L * 1000L));
		System.out.println(map);
		
		System.out.println("[END]");
	}
	
	public void duplicate3(){
		Map<String, String> map = new TreeMap<String, String>();

		map.put("A", "JHON");
		System.out.println(map);
		
		
		Object value = map.get("A");
		value = "PETER";
		System.out.println(map);
		
		System.out.println("[END]");
	}
	
}
