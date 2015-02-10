package austin.test;

import java.sql.Timestamp;

public class TestTimestamp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TestTimestamp test = new TestTimestamp();
		
		Long HourLong = (60L * 60L * 1000L);
		Long nowL = System.currentTimeMillis()+(0L * HourLong);
		System.out.println("模擬現在時間："+new Timestamp(nowL));
		System.out.println("三小時區間");
		System.out.println("調整-8小時:"+test.getLatestEraPeriod(nowL, 3L, -8L));
		System.out.println("六小時區間");
		System.out.println("調整-8小時:"+test.getLatestEraPeriod(nowL, 6L, -8L));
		
		nowL = System.currentTimeMillis()+(2L * HourLong);
		System.out.println("模擬現在時間："+new Timestamp(nowL));
		System.out.println("三小時區間");
		System.out.println("調整-8小時:"+test.getLatestEraPeriod(nowL, 3L, -8L));
		System.out.println("六小時區間");
		System.out.println("調整-8小時:"+test.getLatestEraPeriod(nowL, 6L, -8L));
		
		nowL = System.currentTimeMillis()+(8L * HourLong);
		System.out.println("模擬現在時間："+new Timestamp(nowL));
		System.out.println("三小時區間");
		System.out.println("調整-8小時:"+test.getLatestEraPeriod(nowL, 3L, -8L));
		System.out.println("六小時區間");
		System.out.println("調整-8小時:"+test.getLatestEraPeriod(nowL, 6L, -8L));
		
		nowL = System.currentTimeMillis()+(14L * HourLong);
		System.out.println("模擬現在時間："+new Timestamp(nowL));
		System.out.println("三小時區間");
		System.out.println("調整-8小時:"+test.getLatestEraPeriod(nowL, 3L, -8L));
		System.out.println("六小時區間");
		System.out.println("調整-8小時:"+test.getLatestEraPeriod(nowL, 6L, -8L));
		
		
	}
	
	/**
	 * 透過提供的時間級距算出最接近的時間，之後再透過提供的時間校準把準確的時間算出。
	 * 起始時間都以0點為起始
	 * 若時間級距為3小時則將會往前推算至：0, 3, 6, 9, 12, 15, 18, 21...
	 * 若時間級距為6小時則將會往前推算至：0, 6, 12, 18...
	 * @param nowL 請自行提供現在時間(此僅提供邏輯計算)
	 * @param period 時間級距
	 * @param diffHour 時間校準(小時)
	 * @return
	 */
	public Timestamp getLatestEraPeriod(Long nowL, Long period, Long diffHour){
		Long HourLong = (60L * 60L * 1000L);
		
		nowL -= diffHour * HourLong;//偏差值再進入的時候，和出去的時候都需要做調整。
		
		Long remainderL = nowL % (period * HourLong);
		Long standardL = nowL - remainderL;
		
		Long peroidL = standardL + (diffHour*HourLong);
		return new Timestamp(peroidL);
	}

}
