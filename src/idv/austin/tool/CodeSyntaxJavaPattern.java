package austin.tool;

import java.util.ArrayList;
import java.util.List;

import austin.bean.SQLBean;

public class CodeSyntaxJavaPattern {

	String tab1="\t";
	String tab2="\t\t";
	String tab3="\t\t\t";
	
	public String getClassHeader(String className){
		String ans = "";
		ans += "public class "+className;
		ans += "{";
		ans += "\r\n";
		return ans;
	}
	
	public String getClassTailer(){
		String ans = "";
		ans += "}";
		ans += "\r\n";
		return ans;
	}

	/**
	 * 提供簡單的宣告Patter
	 * @param accessModify
	 * @param parameterName
	 * @param commentString
	 * @return
	 */
	public String getDeclareString(String accessModify, String parameterName, String commentString){
		String ans = "";
		ans += "\t";
		ans += accessModify + " " + parameterName + " " + commentString;
		ans += "\r\n";
		return ans;
	}
	
	/**
	 * 初始建構子開頭
	 * @param className
	 * @return
	 */
	public String getConstructorHeader(String className){
		String ans = "\r\n\tpublic " + className + "(){\r\n";
		return ans;
	}
	
	/**
	 *  初始建構子結尾
	 * @return
	 */
	public String getConstructorTailer(){
		String ans = "\t}\r\n";
		return ans;
	}
	
	/**
	 * getter的方法標頭
	 * @param methodName
	 * @return
	 */
	public String getMethodHeader(String methodName){
		String ans = "";
		ans += "\r\n";
		ans += tab1+"public void "+methodName+"(){";
		ans += "\r\n";
		return ans;
	}
	/**
	 * gettter的方法結尾，需要return Value。
	 * @param returnName
	 * @return
	 */
	public String getMethodTailer(String returnName){
		String ans = "";
		ans += "\r\n";
		ans += "\t\treturn " + returnName + ";";
		ans += "\r\n";
		ans += "\t}";
		return ans;
	}
	
	/**
	 * getter的方法標頭
	 * @param methodName
	 * @return
	 */
	public String setMethodHeader(String methodName, String inputType, String inputName){
		String ans = "";
		ans += "\r\n";
		ans += "\tpublic void "+methodName;
		ans += "(";
		ans += inputType+" "+inputName;
		ans += ")";
		ans += "{";
		ans += "\n";
		return ans;
	}
	/**
	 * gettter的方法結尾，需要return Value。
	 * @param returnName
	 * @return
	 */
	public String setMethodTailer(){
		String ans = "";
		ans += "\r\n";
//		ans += "return " + returnName + ";";
		ans += "\r\n";
		ans += "\t}";
		return ans;
	}
	
	/**
	 * 提供List的方法進行處理
	 * @param beanList
	 * @return
	 */
	public List<String> toParameterDeclare(List<SQLBean> beanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:beanList){			
			outList.add(toParameterDeclare(sqlBeans));
		}
		return outList;
	}
	/**
	  * toParameterDeclare 說明： 產生程式碼<br>
	  * private String brokerBoxNo;//18:報關業者箱號 <br>
	  * @param bean
	  * @return <br>
	  * @author game<br>
	 */
	public String toParameterDeclare(SQLBean bean){
		String ans = "";
		ans += "\t";
		ans += "private";
		ans += " ";
		if(bean.getDataType().indexOf("DATE")>=0){
			ans += "RocDate";
		}else if(bean.getDataType().indexOf("NUMBER")>=0){
			ans += "BigDecimal";
		}else{
			ans += "String";
		}
		ans += " ";
		ans += bean.toCamalWord(bean.getColumnName());
		ans += ";";
		ans += "//";
		ans += bean.getColumnId();
		ans += ":";
		ans += bean.getComments();
		return ans;
	}
	
	public String toParameterDeclare(List<String> input){
		String ans = "";
		for(Object keys:input.toArray()){
			SQLBean sqlBean = new SQLBean((String)keys);
			ans += this.toParameterDeclare(sqlBean);
			ans += "\r\n";
		}
		return ans;
	}
	
	/**
	  * toRandomBeanSetter 說明： RandomBean產生器<br>
	  * //this.setTransId(pageBean.getTransId());//XX:傳送代碼<br>
	  * @param bean
	  * @return <br>
	  * @author game<br>
	 */
	public String toRandomBeanSetter(SQLBean bean){
		//this.setTransId(pageBean.getTransId());//XX:傳送代碼
		String key = bean.getColumnName();
		String javaWord = bean.toCamalWord(key);
		String setter = bean.addPreWord("set", javaWord);
		String getter = bean.addPreWord("get", javaWord);
		
		String ans = "";
		ans += "\t\t";
		ans += "this."+setter;
		ans += "(";
		ans += "randomBean."+getter;
		ans += "()";
		ans += ")";
		ans += ";";
		ans += "//";
		ans += bean.getColumnId();
		ans += ":";
		ans += bean.getComments();
		return ans;
	}
	
	
	/**
	 * 提供LIST的接值方式
	 * @param sqlBeanList
	 * @return List<String>
	 */
	public List<String> toDataObjectSetValue(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean beans: sqlBeanList){
			outList.add(toDataObjectSetValue(beans));
		}
		return outList;
	}
	
	/**
	 * 建立DataObject 的setValue方法
	 * @param bean
	 * @return
	 */
	public String toDataObjectSetValue(SQLBean bean){
		//pageBean.setValue("TRANS_ID", this.getTransId());//傳送代碼
		
		String key = bean.getColumnName();
		String javaWord = bean.toCamalWord(key);
		String getter = bean.addPreWord("get", javaWord)+"()";
		
		String ans = "";
		ans += "\t\t";
		ans += "dto.setValue";
		ans += "(\"";
		ans += key;
		ans += "\"";
		ans += ", ";
		ans += "this."+getter;
//		ans += "()";
		ans += ")";
		ans += ";";
		ans += "//";
		ans += bean.getColumnId();
		ans += ":";
		ans += bean.getComments();
		return ans;
	}
	
	/**
	 * 建立DataObject setValue方法的LIST結構
	 * @param sqlBeanList
	 * @return
	 */
	public List<String> toDataObjectGetValue(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean beans:sqlBeanList){
			outList.add(toDataObjectGetValue(beans));
		}
		return outList;
	}
	
	/**
	 * 建立DataObject setValue的方法
	 * @param bean
	 * @return
	 */
	public String toDataObjectGetValue(SQLBean bean){
		//pageBean.getValue("TRANS_ID", this.getTransId());//傳送代碼
		
		String key = bean.getColumnName();
		
		String ans = "";
		ans += "\t\tdto.getValue";
		ans += "(\"";
		ans += key;
		ans += "\"";
		ans += ")";
		ans += ";";
		ans += "//";
		ans += bean.getColumnId();
		ans += ":";
		ans += bean.getComments();
		return ans;
	}
	
	public List<String> toDataObjectGetMethod(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(toDataObjectGetMethod(sqlBeans));
		}
		return outList;
	}
	/**
	 * dto.setValue(this.getDeclNo());
	 * @param sqlBean
	 * @return
	 */
	public String toDataObjectGetMethod(SQLBean sqlBean){
		String ans = "";
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String getter = "this."+sqlBean.addPreWord("get", javaWord)+"()";
		ans += tab2+"dto.setValue("+getter+")";
		return ans;
	}
	
	public String getToStringHeader(){
		String ans = "";
		ans += tab1+"public String toString(){";
		ans += "\r\n";
		ans += tab2+"String ans = \"\";";
		return ans;
	}
	
	public String getToStringTailer(){
		String ans = "";
		ans += tab2+"return ans;";
		ans += "\r\n";
		ans += tab1+"}";
		return ans;
	}
	
	/**
	 * ans+= "printUnit="+getPrintUnit()+"(列印單位)";//列印單位
	 * @param sqlBean
	 * @return
	 */
	public String getToStringDetail(SQLBean sqlBean){
		//",傳送代碼"+"(transId)="+this.getTransId()+
		
		String key = sqlBean.getColumnName();
		String javaWord = sqlBean.toCamalWord(key);
		String getter = "this."+sqlBean.addPreWord("get", javaWord)+"()";
		String comment = sqlBean.getComments();
		
		String ans = "";
		ans += tab2+"ans += \""+key+"=\"+"+javaWord+getter+"+\"("+comment+"),\""+"//"+comment;
		return ans;
	}
	/**
	 * 提供List的結構
	 * ans+= "printUnit="+getPrintUnit()+"(列印單位)";//列印單位
	 * @param sqlBeanList
	 * @return
	 */
	public List<String> getToStringDetail(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getToStringDetail(sqlBeans));
		}
		return outList;
	}
	
	public String getMapHeader(){
		String ans = "";
		ans += tab1+"public Map<String, Object> getMap(){";
		ans += "\r\n";
		ans += tab2+"Map<String, Object> ansMap = new TreeMap<String, Object>();";
		return ans;
	}
	public String getMapDetail(SQLBean sqlBean){
		String ans = "";
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String getter = "this."+sqlBean.addPreWord("get", javaWord)+"()";
		ans += tab2+"ansMap.put(\""+sqlBean.getColumnName()+"\", "+getter+");";
		return ans;
	}
	public List<String> getMapDetail(List<SQLBean> sqlBeanList){
		List<String> outList = new ArrayList<String>();
		for(SQLBean sqlBeans:sqlBeanList){
			outList.add(getMapDetail(sqlBeans));
		}
		return outList;
	}
	public String getMapTailer(){
		String ans = "";
		ans += tab2+"return ansMap;";
		ans += "\r\n";
		ans += tab1+"}";
		return ans;
	}
	
	public String getSetterString(SQLBean sqlBean){
		String ans = "";
		String javaWord = sqlBean.toCamalWord(sqlBean.getColumnName());
		String getter = "this."+sqlBean.addPreWord("set", javaWord)+"("+")";
//		ans += sqlBean.get"";
		return ans;
	}
}
