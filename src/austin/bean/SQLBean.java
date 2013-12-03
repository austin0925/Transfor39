package austin.bean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SQLBean {

	private String columnName;//欄位名稱
	private String dataType;//型別
	private String nullAble;//可否空白
	private String dataDefault;//預設值
	private String columnId;//欄位編號
	private String comments;//欄位說明
	
	public boolean debug=false;
	
	private Map<String, String> fieldName = new LinkedHashMap<String, String>();
	private Map<String, String> fieldValue = new LinkedHashMap<String, String>();
	
	/**
	 * 基本的建構子，把fieldName的標誌先標上。
	 */
	public SQLBean(){
		fieldName.put("columnName", "欄位名稱");
		fieldName.put("dataType", "型別");
		fieldName.put("nullAble", "可否空白");
		fieldName.put("dataDefault", "預設值");
		fieldName.put("columnId", "欄位編號");
		fieldName.put("comments", "欄位說明");
	}
	
	/**
	 * 提供透過指定資料的方式來建立Bean
	 * @param columnName
	 * @param dataType
	 * @param nullAble
	 * @param dataDefault
	 * @param columnId
	 * @param comments
	 */
	public SQLBean(
			String columnName,
			String dataType,
			String nullAble,
			String dataDefault,
			String columnId,
			String comments
			){
		this();
		this.columnName=columnName;
		this.dataType=dataType;
		this.nullAble=nullAble;
		this.dataDefault=dataDefault;
		this.columnId=columnId;
		this.comments=comments;

	}
	
	/**
	 * 提供透過Line來建立SQL的Bean
	 * @param line
	 */
	public SQLBean(String line){
		this();
		ArrayList<Integer> tabArray = new ArrayList<Integer>();
		
		for(int i=0; i<line.length(); i++){
			if(line.charAt(i)=='\t'){
				tabArray.add(i);
			}else if(line.charAt(i)==','){
				if(i-line.indexOf("R(")>=5){
					tabArray.add(i);
				}
			}
		}
			
		setColumnName(line.substring(0, tabArray.get(0)));
		setDataType(line.substring(tabArray.get(0)+1, tabArray.get(1)));
		setNullAble(line.substring(tabArray.get(1)+1, tabArray.get(2)));
		setDataDefault(line.substring(tabArray.get(2)+1, tabArray.get(3)));
		setColumnId(line.substring(tabArray.get(3)+1, tabArray.get(4)));
		setComments(line.substring(tabArray.get(4)+1, line.length()));
		//setComments(line.substring(tabArray.get(tabArray.size()-1), line.length()));
			
		if(debug)System.out.println("tabArray="+tabArray);
	}
	
	/**
	  * addPreword 說明： 加上前贅字<br>
	  * @param preWord 前贅字
	  * @param orgWord 原字串字頭換成大寫
	  * @return preWord+orgWord.substring(0, 1).toUpperCase()+orgWord.substring(1)<br>
	  * @author game<br>
	 */
	public String addPreWord(String preWord, String orgWord){
		return preWord+orgWord.substring(0, 1).toUpperCase()+orgWord.substring(1);
	}
	
	/**
	 * 改為底線字
	 * @param orgWord 原來的字串
	 * @return	新的字串
	 */
	public String toUnderLineWord(String orgWord){
		String ans = "";
		
		ArrayList<Integer> bigWordArray = new ArrayList<Integer>();
		for(int i=0; i<orgWord.length(); i++){
			if(orgWord.charAt(i)<='Z' && orgWord.charAt(i)>='A'){
				bigWordArray.add(i);
			}
		}
		
		int start = 0;
		for(Object indexes:bigWordArray.toArray()){
			ans += orgWord.substring(start, (Integer)indexes);
			ans += "_";
			start = (Integer)indexes;
		}
		ans += orgWord.substring((Integer)bigWordArray.get(bigWordArray.size()-1), orgWord.length());
		
		return ans.toUpperCase();
	}
	
	/**
	  * toCamalWord 說明： 切成駝峰字<br>
	  * @param orgWord	舊的字串
	  * @return 新的字串<br>
	  * @author game<br>
	 */
	public String toCamalWord(String orgWord){
		String ans = "";
		ArrayList<Integer> underLineArray = new ArrayList<Integer>();
		for(int i=0; i<orgWord.length(); i++){
			if(orgWord.charAt(i)=='_')underLineArray.add(i);
		}
		underLineArray.add(orgWord.length());
		
		orgWord = orgWord.toLowerCase();
		int start = 0;
		for(Object indexs:(Object[])underLineArray.toArray()){
			String temp = orgWord.substring(start, (Integer)indexs);
			ans += temp.substring(0, 1).toUpperCase()+temp.substring(1);
			start = (Integer)indexs+1;
//			System.out.println("temp="+temp);
//			System.out.println("start="+start);
//			System.out.println("ans="+ans);
		}
		if(debug)System.out.println("SQLBean.toCamalWord()|run at "+orgWord);
//		if(underLineArray.size()!=1){
//			if(debug)System.out.println("SQLBean.toCamalWord()|run at "+orgWord);
//			String temp = orgWord.substring(underLineArray.get(underLineArray.size()-1)+1, orgWord.length());
//			ans += temp.substring(0, 1).toUpperCase()+temp.substring(1);			
//		}
		return ans.substring(0, 1).toLowerCase()+ans.substring(1);
	}
	
	@Override
    public String toString() {
       String ans = "" ;
       for(Object keys:(Object[])fieldName.keySet().toArray()){
    	   ans += keys+"="+fieldValue.get(keys)+";";
       }
        return ans;
   }

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		fieldValue.put("columnName", columnName);
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		fieldValue.put("dataType", dataType);
		this.dataType = dataType;
	}

	public String getNullAble() {
		return nullAble;
	}

	public void setNullAble(String nullAble) {
		fieldValue.put("nullAble", nullAble);
		this.nullAble = nullAble;
	}

	public String getDataDefault() {
		return dataDefault;
	}

	public void setDataDefault(String dataDefault) {
		fieldValue.put("dataDefault", dataDefault);
		this.dataDefault = dataDefault;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		fieldValue.put("columnId", columnId);
		this.columnId = columnId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		fieldValue.put("comments", comments);
		this.comments = comments;
	}

	
}
