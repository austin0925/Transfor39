package austin.tool;

import java.util.ArrayList;
import java.util.List;

import austin.bean.SQLBean;

public class CodeSyntaxXMLPattern {

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
	
}
