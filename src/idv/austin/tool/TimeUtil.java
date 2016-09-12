package com.nec.svc.nfa.sso.util;
//import com.nec.svc.nfa.sso.util.TimeUtil
public class TimeUtil{
	
	private static Long jumperTime = System.nanoTime();
	private static String logMsg = "TimeUtil.";

	private static TreeMap<String, Long> timeMap = new TreeMap<String, Long>();

	public Long periodTime(String key){
		retrn expiriedTime(key, Long.MAX_VALUE);
	}
	
	public Long expiriedTime(String key, Long expired){
		Long now = System.nanoTime();
		
		Long value = timeMap.get(key);
		if(value == null){
			timeMap.put(key, now);
			showMiliTime("first time");
			return 0L;
		}

		Long period = now-value; 
		showMiliTime("period", period);
		showMiliTime("expired", expired);
		
		if(expired < period){
			showMiliTime("EXPIRED RESET TIME");
			timeMap.put(key, now);
			return 0L;
		}else{
			showMiliTime("IN PERIOD");
			return period;
		}
		
	}
	
	public String showMiliTime(String msg, Long nanoTime){
		Long miliTime = nanoTime / 1000L;
		showMiliTime(msg+":"+miliTime);
	}
	
	private String showMiliTime(String msg){
		System.out(logMsg+msg+);
	}
	
	
	
}