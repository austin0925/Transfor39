package idv.austin.tool;

import java.sql.Timestamp;

public class TestTimesatmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timestamp t1 = new Timestamp(0L);
		Timestamp t2 = new Timestamp(System.currentTimeMillis());
		System.out.println(t1.compareTo(t2));
		System.out.println(t2.compareTo(t1));
	}

}
