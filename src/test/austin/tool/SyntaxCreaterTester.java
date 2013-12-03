package test.austin.tool;

import org.junit.Test;

import austin.bean.SQLBean;
import austin.tool.CodeSyntaxJavaPattern;

public class SyntaxCreaterTester extends CodeSyntaxJavaPattern {

	@Test
	public void toParameterDeclareTest(){
		SQLBean sqlBean = null;
		sqlBean = new SQLBean("BROKER_BOX_NO	VARCHAR2(3 CHAR)	Yes		18	報關業者箱號");
		System.out.println(toParameterDeclare(sqlBean));
		sqlBean = new SQLBean("BROKER_BOX_SUB_NO	VARCHAR2(1 CHAR)	Yes		19	報關業者箱號附碼");
		System.out.println(toParameterDeclare(sqlBean));
		sqlBean = new SQLBean("STOR_WARE_CD,VARCHAR2(8 CHAR),No,,20,卸存地點代碼");
		System.out.println(toParameterDeclare(sqlBean));
		sqlBean = new SQLBean("DCLR_NOTE_BREF,VARCHAR2(1 CHAR),,Yes,21,簡易申報註記");
		System.out.println(toParameterDeclare(sqlBean));
		sqlBean = new SQLBean("TOT_PACK_QTY	NUMBER(8,0)	No		34	總件數");
		System.out.println(toParameterDeclare(sqlBean));
		sqlBean = new SQLBean("CUTOFF_DATE	DATE	Yes		29	截止收貨日");
		System.out.println(toParameterDeclare(sqlBean));
	}
	
	@Test
	public void toRandomBeanSetterTest(){
		SQLBean sqlBean = null;
		sqlBean = new SQLBean("BROKER_BOX_NO	VARCHAR2(3 CHAR)	Yes		18	報關業者箱號");
		System.out.println(toRandomBeanSetter(sqlBean));
		sqlBean = new SQLBean("BROKER_BOX_SUB_NO	VARCHAR2(1 CHAR)	Yes		19	報關業者箱號附碼");
		System.out.println(toRandomBeanSetter(sqlBean));
		sqlBean = new SQLBean("STOR_WARE_CD,VARCHAR2(8 CHAR),No,,20,卸存地點代碼");
		System.out.println(toRandomBeanSetter(sqlBean));
		sqlBean = new SQLBean("DCLR_NOTE_BREF,VARCHAR2(1 CHAR),,Yes,21,簡易申報註記");
		System.out.println(toRandomBeanSetter(sqlBean));
		sqlBean = new SQLBean("TOT_PACK_QTY	NUMBER(8,0)	No		34	總件數");
		System.out.println(toRandomBeanSetter(sqlBean));
		sqlBean = new SQLBean("CUTOFF_DATE	DATE	Yes		29	截止收貨日");
		System.out.println(toRandomBeanSetter(sqlBean));
	}
	
	//toDataObject
	@Test
	public void toDataObjectSetValueTest(){
		SQLBean sqlBean = null;
		sqlBean = new SQLBean("BROKER_BOX_NO	VARCHAR2(3 CHAR)	Yes		18	報關業者箱號");
		System.out.println(toDataObjectSetValue(sqlBean));
		sqlBean = new SQLBean("BROKER_BOX_SUB_NO	VARCHAR2(1 CHAR)	Yes		19	報關業者箱號附碼");
		System.out.println(toDataObjectSetValue(sqlBean));
		sqlBean = new SQLBean("STOR_WARE_CD,VARCHAR2(8 CHAR),No,,20,卸存地點代碼");
		System.out.println(toDataObjectSetValue(sqlBean));
		sqlBean = new SQLBean("DCLR_NOTE_BREF,VARCHAR2(1 CHAR),,Yes,21,簡易申報註記");
		System.out.println(toDataObjectSetValue(sqlBean));
		sqlBean = new SQLBean("TOT_PACK_QTY	NUMBER(8,0)	No		34	總件數");
		System.out.println(toDataObjectSetValue(sqlBean));
		sqlBean = new SQLBean("CUTOFF_DATE	DATE	Yes		29	截止收貨日");
		System.out.println(toDataObjectSetValue(sqlBean));
	}
	
	//toDataObjectGetValue
		@Test
		public void toDataObjectGetValueTest(){
			SQLBean sqlBean = null;
			sqlBean = new SQLBean("BROKER_BOX_NO	VARCHAR2(3 CHAR)	Yes		18	報關業者箱號");
			System.out.println(toDataObjectGetValue(sqlBean));
			sqlBean = new SQLBean("BROKER_BOX_SUB_NO	VARCHAR2(1 CHAR)	Yes		19	報關業者箱號附碼");
			System.out.println(toDataObjectGetValue(sqlBean));
			sqlBean = new SQLBean("STOR_WARE_CD,VARCHAR2(8 CHAR),No,,20,卸存地點代碼");
			System.out.println(toDataObjectGetValue(sqlBean));
			sqlBean = new SQLBean("DCLR_NOTE_BREF,VARCHAR2(1 CHAR),,Yes,21,簡易申報註記");
			System.out.println(toDataObjectGetValue(sqlBean));
			sqlBean = new SQLBean("TOT_PACK_QTY	NUMBER(8,0)	No		34	總件數");
			System.out.println(toDataObjectGetValue(sqlBean));
			sqlBean = new SQLBean("CUTOFF_DATE	DATE	Yes		29	截止收貨日");
			System.out.println(toDataObjectGetValue(sqlBean));
		}
	
	//getToString
	@Test
	public void getToStringTest(){
		SQLBean sqlBean = null;
		sqlBean = new SQLBean("BROKER_BOX_NO	VARCHAR2(3 CHAR)	Yes		18	報關業者箱號");
		System.out.println(getToStringDetail(sqlBean));
		sqlBean = new SQLBean("BROKER_BOX_SUB_NO	VARCHAR2(1 CHAR)	Yes		19	報關業者箱號附碼");
		System.out.println(getToStringDetail(sqlBean));
		sqlBean = new SQLBean("STOR_WARE_CD,VARCHAR2(8 CHAR),No,,20,卸存地點代碼");
		System.out.println(getToStringDetail(sqlBean));
		sqlBean = new SQLBean("DCLR_NOTE_BREF,VARCHAR2(1 CHAR),,Yes,21,簡易申報註記");
		System.out.println(getToStringDetail(sqlBean));
		sqlBean = new SQLBean("TOT_PACK_QTY	NUMBER(8,0)	No		34	總件數");
		System.out.println(getToStringDetail(sqlBean));
		sqlBean = new SQLBean("CUTOFF_DATE	DATE	Yes		29	截止收貨日");
		System.out.println(getToStringDetail(sqlBean));
	}
	
	
}
