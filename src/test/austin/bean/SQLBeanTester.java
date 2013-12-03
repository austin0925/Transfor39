package test.austin.bean;

import org.junit.Test;

import austin.bean.SQLBean;

public class SQLBeanTester extends SQLBean {
	
	@Test
	public void Test(){
		SQLBean sqlBean = new SQLBean();
		System.out.println(sqlBean);
	}
	
	@Test
	public void getBytest(){
		SQLBean sqlBean = null;
		sqlBean = new SQLBean("BROKER_BOX_NO	VARCHAR2(3 CHAR)	Yes		18	報關業者箱號");
		System.out.println(sqlBean.toString());
		sqlBean = new SQLBean("BROKER_BOX_SUB_NO	VARCHAR2(1 CHAR)	Yes		19	報關業者箱號附碼");
		System.out.println(sqlBean.toString());
		sqlBean = new SQLBean("STOR_WARE_CD,VARCHAR2(8 CHAR),No,,20,卸存地點代碼");
		System.out.println(sqlBean.toString());
		sqlBean = new SQLBean("DCLR_NOTE_BREF,VARCHAR2(1 CHAR),,Yes,21,簡易申報註記");
		System.out.println(sqlBean.toString());
		sqlBean = new SQLBean("MAWB	VARCHAR2(35 CHAR)	No		32	託運單主號");
		System.out.println(sqlBean.toString());
	}
	
	@Test
	public void toCamalWordTest(){
		System.out.println(toCamalWord("BROKER_BOX_NO"));
		System.out.println(toCamalWord("BROKER_BOX_SUB_NO"));
		System.out.println(toCamalWord("STOR_WARE_CD"));
		System.out.println(toCamalWord("DCLR_NOTE_BREF"));
		System.out.println(toCamalWord("MAWB"));
	}
	
	@Test
	public void toUnderLineWord(){
		System.out.println(toUnderLineWord("brokerBoxNo"));
		System.out.println(toUnderLineWord("brokerBoxSubNo"));
		System.out.println(toUnderLineWord("storWareCd"));
		System.out.println(toUnderLineWord("dclrNoteBref"));
	}
}
