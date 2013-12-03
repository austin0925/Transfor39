package austin.tool;

import java.util.ArrayList;
import java.util.List;

import austin.bean.SQLBean;

public class CodeSyntaxSQLPattern {

	/**
	 * create or replace PACKAGE        EN01
	 * IS
	 * @return
	 */
	public String getPackageHeader(String packageName){
		String ans="";
		ans += "create or replace PACKAGE        "+packageName;
		ans += "\r\n";
		ans += "IS";
		ans += "\r\n";
		return ans;
	}
	
	/**
	 * END EN01;
	 * @return
	 */
	public String getPackageTailer(String packageName){
		String ans="";
		ans += "END "+packageName+";";
		ans += "\r\n";
		return ans;
	}
	
	/**
	 * TYPE EN01_TYPE IS RECORD
	 * (
	 * @param recordName
	 * @return
	 */
	public String getRecordHeader(String recordName){
		String ans = "";
		ans += "\tTYPE "+recordName+" IS RECORD";
		ans += "\r\n";
		ans += "\t(";
//		ans += "\r\n";
		return ans;
	}
	
	/**
	 * );
	 * @return
	 */
	public String getRecordTailer(){
		String ans = "";
		ans += "\t);";
		ans += "\r\n";
		return ans;
	}
	
	
	/**
	 * DECL_NO				EXDEDMM.DECL_NO%TYPE,
	 * @param underLineWord
	 * @param beanName
	 * @return
	 */
	public String getRecordFields(String underLineWord, String beanName, String comment){
		String ans = "";
		ans += "\t\t"+underLineWord+"\t\t"+beanName+"."+underLineWord+"%TYPE,\t--"+comment;
//		ans += "\r\n";
		return ans;
	}
	
	/**
	 * DECL_NO				EXDEDMM.DECL_NO%TYPE, for List<String>
	 * @param sqlBeanList
	 * @param beanName
	 * @return
	 */
	public List<String> getRecordFields(List<SQLBean> sqlBeanList, String beanName){
		List<String> outList = new ArrayList<String>();
		
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getRecordFields(sqlBeans.getColumnName(), beanName, sqlBeans.getComments()));
		}
		
		outList.add(outList.remove(outList.size()-1).replace(",", ""));
		
		return outList;
	}
	
	/**
	 * FIELD_NAME,
	 * @param sqlBean
	 * @return
	 */
	public String getFields(SQLBean sqlBean){
		String ans = "";
		ans += "\t"+sqlBean.getColumnName()+",\t\t--"+sqlBean.getComments();
		return ans;
	}
	
	/**
	 * FIELD_NAME, 提供List的型態串接
	 * @param sqlBeanList
	 * @return
	 */
	public List<String> getFields(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getFields(sqlBeans));
		}
		outList.add(outList.remove(outList.size()-1).replace(",", ""));
		return outList;
	}
	
	/**
	 * 取得where的條件「COLUMN_NAME = beanName.COLUMN_NAME」
	 * @param sqlBean
	 * @param beanName
	 * @return
	 */
	public String getWhereFields(SQLBean sqlBean, String beanName){
		String ans = "";
		ans += "\t"+sqlBean.getColumnName() + " = " +beanName+"."+sqlBean.getColumnName() + "  AND  ";
		return ans;
	}
	
	/**
	 * 取得where的條件「COLUMN_NAME = beanName.COLUMN_NAME」，提供LIST的結構。
	 * @param sqlBeanList
	 * @param beanName
	 * @return
	 */
	public List<String> getWhereFields(List<SQLBean> sqlBeanList, String beanName){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){			
			outList.add(getWhereFields(sqlBeans, beanName));
		}
		outList.add(outList.remove(outList.size()-1).replace("  AND  ", ";"));
		return outList;
	}
	
}
