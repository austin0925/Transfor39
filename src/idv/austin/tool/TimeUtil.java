package idv.austin.tool;
//import com.nec.svc.nfa.sso.util.TimeUtil

import java.util.TreeMap;

public class TimeUtil{
	
	private static String logMsg = "TimeUtil.";

	private static TreeMap<String, Long> timeMap = new TreeMap<String, Long>();

	public static Long periodTime(String key){
		return expiriedTime(key, 0L);
	}
	
	public static Long expiriedTime(String key, Long expired){
		
		Long now = System.nanoTime();
		
		Long period = 0L;
		
		//initial key & value = now
		Long value = timeMap.get(key);
		if(value == null){
			timeMap.put(key, now);
			showMiliTime("period", period);
			showMiliTime("first time");
			return 0L;
		}
		
		//has value
		period = now-value;
//		showMiliTime("now", now);
//		showMiliTime("value", value);
		showMiliTime("period", period);
		
		boolean isExpired = period > expired;
		showMiliTime(period+">"+expired+" for "+isExpired);
		if(isExpired){
			timeMap.put(key, now);
			period = 0L;
		}
		return period;
		
	}
	
	private static void showMiliTime(String msg, Long nanoTime){
		Long miliTime = nanoTime;
		showMiliTime(msg+":"+miliTime);
	}
	
	private static void showMiliTime(String msg){
		System.out.println(logMsg+msg);
	}
	
	public static void main(String args[]) throws InterruptedException{
		TimeUtil test = new TimeUtil();
		test.runTest1();
		System.out.println("[END]");
		test.runTest2();
		System.out.println("[END]");
	}
	
	public static void runTest1() throws InterruptedException{
		periodTime("test1");
		Thread.sleep(1000);
		periodTime("test1");
		Thread.sleep(1000);
		periodTime("test1");
		Thread.sleep(1000);
		periodTime("test1");
	}
	
	public static void runTest2() throws InterruptedException{
		expiriedTime("test2", 3000000000L);
		Thread.sleep(1000);
		expiriedTime("test2", 3000000000L);
		Thread.sleep(1000);
		expiriedTime("test2", 3000000000L);
		Thread.sleep(1000);
		expiriedTime("test2", 3000000000L);
		Thread.sleep(1000);
		expiriedTime("test2", 3000000000L);
	}
	
	
}