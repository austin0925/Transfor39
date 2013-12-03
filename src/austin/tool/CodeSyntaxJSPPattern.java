package austin.tool;

import java.util.ArrayList;
import java.util.List;

import austin.bean.SQLBean;


public class CodeSyntaxJSPPattern {

	/**
	 * 取得form header
	 *  id="beanForm" method="post"
	 * @return
	 */
	public String getFormHeader(){
		String ans = "";
		ans += "<form ";
		ans += "id=\"beanForm\" ";
		ans += "method=\"post\" ";
		ans += ">";
		return ans;
	}
	
	/**
	 * 取得form header
	 * @return
	 */
	public String getFormTailer(){
		String ans = "";
		ans += "</form>";
		return ans;
	}
	
	/**
	 * <s:hidden name="beanName.fieldName"/>
	 * @param sqlBean
	 * @param beanName
	 * @return
	 */
	public String getHiddenField(SQLBean sqlBean, String beanName){
		String beanNameString = beanName.isEmpty()?"":sqlBean.toCamalWord(beanName)+"Bean.";
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String ans = "";
		ans += "\t<s:hidden name=\"";
		ans += beanNameString+javaWord;
		ans += "\" />";
		return ans;
	}
	
	/**
	 * <s:hidden name="beanName.fieldName"/> 透過List的方式執行
	 * @param sqlBeanList
	 * @param beanName
	 * @return
	 */
	public List<String> getHiddenField(List<SQLBean> sqlBeanList, String beanName){
		List<String> outList = new ArrayList<String>();
		
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getHiddenField(sqlBeans, beanName));
		}
		
		return outList;
	}
	
	/**
	 * <s:text name="beanName.fieldName"/>
	 * <s:textfield name="beanName.fieldName"/>
	 * @param sqlBean
	 * @return
	 */
	public String getTextField(SQLBean sqlBean, String beanName){
		String beanNameString = beanName.isEmpty()?"":sqlBean.toCamalWord(beanName)+"Bean.";
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String ans = "";
		ans += "\t<tr>\r\n";
		ans += "\t\t<td>\r\n";
		ans += "\t\t\t"+getJSPComment(sqlBean);
		ans += "\t\t\t<s:text name=\""+beanNameString+javaWord+"\"/>\r\n";
		ans += "\t\t\t<s:textfield name=\""+beanNameString+javaWord+"\"/>\r\n";
		ans += "\t\t</td>\r\n";
		ans += "\t</tr>\r\n";
		return ans;
	}
	
	/**
	 * 
	 * @param sqlBeanList
	 * @param beanName
	 * @return
	 */
	public List<String> getTextField(List<SQLBean> sqlBeanList, String beanName){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getTextField(sqlBeans, beanName));
		}
		return outList;
	}
	
	
	/**
	 * <sjg:grid 
 	        id="exzgodd_grid2" 
	        dataType="json" 
	        gridModel="gridModel"
	        rownumbers="true" 
	        rowNum="0"
	        height="120"
	        width="980"
	        shrinkToFit="false" 
	        onSelectRowTopics="exzgodd_selectRowTopics2"
	        onPagingTopics="exzgodd_pagingTopics2"	
	        onGridCompleteTopics="exzgodd_grid2CompleteTopics"
	        editinline="true"
	        editurl="false"			
	        autoencode="false"        
	        pager="true"
	        rowList="10,20,30"
	        viewrecords="true" >
	 * @return
	 */
	public String getGridHeader(String beanName){
		SQLBean sqlBean = new SQLBean();
		String beanNameString = beanName==null||beanName.isEmpty()?"bean":sqlBean.toCamalWord(beanName)+"Bean";
		String ans = "";
		ans += "\r\n\t"+"<sjg:grid";
		ans += "\r\n\t\t"+"id="+beanNameString+"_grid2";
		ans += "\r\n\t\t"+"dataType=\"json\"";
		ans += "\r\n\t\t"+"gridModel=\"gridModel\"";
		ans += "\r\n\t\t"+"rownumbers=\"true\"";
		ans += "\r\n\t\t"+"rowNum=\"0\"";
		ans += "\r\n\t\t"+"height=\"120\"";
		ans += "\r\n\t\t"+"width=\"980\"";
		ans += "\r\n\t\t"+"shrinkToFit=\"false\"";
		ans += "\r\n\t\t"+"onSelectRowTopics=\""+beanNameString+"_selectRowTopics2\"";
		ans += "\r\n\t\t"+"onPagingTopics=\""+beanNameString+"_pagingTopics2\"";
		ans += "\r\n\t\t"+"onGridCompleteTopics=\""+beanNameString+"_grid2CompleteTopics\"";
		ans += "\r\n\t\t"+"editinline=\"true\"";
		ans += "\r\n\t\t"+"editurl=\"false\"";
		ans += "\r\n\t\t"+"autoencode=\"false\"";
		ans += "\r\n\t\t"+"pager=\"true\"";
		ans += "\r\n\t\t"+"rowList=\"10,20,30\"";
		ans += "\r\n\t\t"+"viewrecords=\"true\" >";
		ans += "\r\n";
		return ans;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getGridTailer(){
		String ans = "";
		ans += "\r\n\t</sjg:grid>\r\n";
		return ans;
	}
	
	public String getTableHeader(){
		String ans = "";
		ans += "<table>";
		return ans;
	}
	public String getTableTailer(){
		String ans = "";
		ans += "</table>";
		return ans;
	}
	
	/**
	 * <%--ST_MODE:統計方式代碼:stMode--%>
	 * @param sqlBean
	 * @return
	 */
	public String getJSPComment(SQLBean sqlBean){
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String ans = "";
		ans += "\t\t<%--";
		ans += sqlBean.getColumnName();
		ans += ":";
		ans += sqlBean.getComments();
		ans += ":";
		ans += javaWord;
		ans += "--%>\r\n";
		return ans;
	}
	
	/**
	 * <%--ST_MODE:統計方式代碼:stMode--%>
	 * 建立註解依照List的格式
	 * @param sqlBeanList
	 * @return
	 */
	public List<String>getJSPComment(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getJSPComment(sqlBeans));
		}
		return outList;
	}
	
	/**
	 * <%--ST_MODE:統計方式代碼:stMode--%>
		<sjg:gridColumn name="ST_MODE" index="ST_MODE" title="%{getText('stMode')}" width="40"  sortable="true" editable="true"/>

	 * @return
	 */
	public String getGridColumn(SQLBean sqlBean){
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String ans = "";
		ans += getJSPComment(sqlBean);
//		ans += "\t\t<%--";
//		ans += sqlBean.getColumnName();
//		ans += ":";
//		ans += sqlBean.getComments();
//		ans += ":";
//		ans += javaWord;
//		ans += "--%>\r\n";
		
		ans += "\t\t<sjg:gridColumn";
		ans += " name=\""+sqlBean.getColumnName()+"\"";
		ans += " title=\"%{getText('"+javaWord+"')}\"";
		ans += " width=\"40\"";
		ans += " sortable=\"true\"";
		ans += " editable=\"true\"";
		ans += "";
		ans += "/>";
		return ans;
	}
	
	/**
	 * 取得GridColumn的LIST結構
	 * @param sqlBeanList
	 * @return
	 */
	public List<String> getGridColumn(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getGridColumn(sqlBeans));
		}
		return outList;
	}
	
	
	/**
	 * <table class="ctv">
				<tr>
					<th><label style="display: inline-block; width: 30px;"><s:text name="seqNo"/></label></th>  
					<th><label style="display: inline-block; width: 30px;"><s:checkbox name="chkAll" onclick="chkAllCheck(this);"/></label></th>
					<th><label style="display: inline-block; width: 150px;"><s:text name="updCode"/></label></th>
					<th><label style="display: inline-block; width: 100px;"><s:text name="caseNo"/></label></th>
					<th><label style="display: inline-block; width: 100px;"><s:text name="remark"/></label></th>
					<th><label style="display: inline-block; width: 75px;"><s:text name="recheckNo"/></label></th>
					<th><label style="display: inline-block; width: 150px;"><s:text name="arLevel"/></label></th>
					<th><label style="display: inline-block; width: 75px;"><s:text name="procDate"/></label></th>
					<th><label style="display: inline-block; width: 75px;"><s:text name="closeDate"/></label></th>
					<th><label style="display: inline-block; width: 30px;"><s:text name="fiveYearNote"/></label></th>
					<th><label style="display: inline-block; width: 15px;"></label></th>
				</tr>
				<tr>
				  	<td align="center" class="ctvTitle"><span id="seq" style="display:inline-block; width:30px;"></span></td>
				  	<td align="center" width="30px"><s:checkbox name="chk" cssClass="chkBox"/></td>
				    <td align="center">
				    <s:select name="updCode" emptyOption="true" list="getUpdCodeList()" listKey="code"
				    	      listValue="codeChinese" cssStyle="display:inline-block; width:150px;"></s:select>
				    </td>
				    <td align="left">
				    	<s:textfield name="caseNo" size="13" maxlength="13" cssStyle="display:inline-block; width:94px;"></s:textfield>
				    	<div class="acod">tr:upper</div>
				    </td>
				    <td align="left">
				    	<s:textfield name="remark" size="13" maxlength="80" cssStyle="display:inline-block; width:94px;"></s:textfield>
				    </td>
				    <td align="left">
				    	<s:textfield name="recheckNo" size="9" maxlength="9" cssStyle="display:inline-block; width:69px;"></s:textfield>
				    	<div class="acod">tr:upper</div>
				    </td>
				    <td align="left">
				    	<s:select name="arLevel" emptyOption="true" list="getArLevelList()" cssStyle="display:inline-block; width:150px;">
				    </s:select></td>
				    <td align="center"><label name="procDate" style="display:inline-block; width:75px;"></label><s:hidden name="procDateTimes"/></td>
				    <td align="center"><label name="closeDate" style="display:inline-block; width:75px;"></label></td>
				    <td align="center"><label name="fiveYearNote" style="display:inline-block; width:30px;"></label></td>
				</tr>
			</table>
	 * @return
	 */
	public String getGridCommonHeader(){
		String ans = "";
		ans += "\t<table class=\"ctv\">";
		ans += "\r\n";
		ans += "\t\t<tr>";
		return ans;
	}
	
	/**
	 * </tr>
		<tr>
	 * @return
	 */
	public String getGridCommonMiddle(){
		String ans = "";
		ans += "\t\t</tr>";
		ans += "\r\n";
		ans += "\t\t<tr>";
		return ans;
	}
	
	/**
	 * \t\t</tr>
	 * \t</table>
	 * @return
	 */
	public String getGridCommonTailer(){
		String ans = "";
		ans += "\t\t</tr>";
		ans += "\r\n";
		ans += "\t</table>";
		return ans;
	}
	
	/**
	 * <th><label style="display: inline-block; width: 30px;"><s:text name="seqNo"/></label></th>
	 * @param sqlBean
	 * @return ans
	 */
	public String getGridCommonTitle(SQLBean sqlBean){
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String ans = "";
		ans += "\t\t\t<th>";
		ans += "<label style=\"display: inline-block;\"";
		ans += "width: 30px;\">";
		ans += "<s:text name=\""+javaWord+"\"/></label></th>";
		return ans;
	}
	
	/**
	 * <th><label style="display: inline-block; width: 30px;"><s:text name="seqNo"/></label></th>
	 * 提供List結構的資訊
	 * @param sqlBeanList
	 * @return
	 */
	public List<String> getGridCommonTitle(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getGridCommonTitle(sqlBeans));
		}
		return outList;
	}
	
	/**
	 * <td align="center" class="ctvTitle"><span id="seq" style="display:inline-block; width:30px;"></span></td>
	 * @param sqlBean
	 * @return
	 */
	public String getGridCommonDetail(SQLBean sqlBean){
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String ans = "";
		ans += "\t\t\t";
		ans += "<td align=\"center\" ";
		ans += "class=\"ctvTitle\" >";
		ans += "<span id=\""+javaWord+"\" ";
		ans += " style=\"display:inline-block; width:30px;\" ></span></td>";
		return ans;
	}
	
	/**
	 * <td align="center" class="ctvTitle"><span id="seq" style="display:inline-block; width:30px;"></span></td>
	 * List<SQLBean> 提供List結構
	 * @param sqlBean
	 * @return
	 */
	public List<String> getGridCommonDetail(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getGridCommonDetail(sqlBeans));
		}
		return outList;
	} 
}
