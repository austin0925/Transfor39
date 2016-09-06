package austin.tool;

import gov.customs.commons.bean.GridBean;
import gov.customs.commons.converter.RocDate;
import gov.customs.commons.converter.RocDateTime;
import gov.customs.commons.service.ProcessResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.Logger;

import com.tradevan.commons.collection.DataList;
import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.DataPage;
import com.tradevan.taurus.xdao.SqlPredicate;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;

public class GameUtil {
	
	private static final Logger logger = Logger.getLogger(GameUtil.class);

	/**
	 * 確認DataObject內的value是否為null，若有不為NULL的資料則回傳false
	 * @param dataObject
	 * @return boolean=>true:不全為NULL；false:全為NULL
	 */
	public TreeMap<String, Object> getNotEmptyMap(DataObject dataObject){
		TreeMap<String, Object> ansMap = new TreeMap<String, Object>();
		
		for(Object keys:dataObject.getKeys()){
			String keyString = keys.toString();
			Object value=dataObject.getValue(keyString);
			
			if(value==null || "".equals(value)){
			}else{
				ansMap.put(keyString, value);
			}
		}
		return ansMap;
	}
	
	/**
     * 若val遇到null或是空白字元。
     * 則回傳defaultValue，不然就回傳原來的val。
     * @param val
     * @param defaultValue
     * @return
     */
    public String transEmptyToDefaultValue(String val, String defaultValue){
    	String ans = val;
    	if(val==null || val.length()==0){
    		logger.debug("GameUtil.transEmptyToDefaultValue.102|[CHANGE]before="+val+",after="+defaultValue);
    		ans = defaultValue;
    	}
    	return ans;
    }
    
    /**
     * 因為資料庫內只能取得DataList，因此需要把畫面回傳的gridBean做一些資料設定。
     * 然後把DataList做一些切割後，把GridBean呈現到畫面上去。
     * @param dataList
     * @param gridBean
     * @return
     */
    public GridBean getGridBeanByDataList(DataList dataList, GridBean gridBean){
    	
    	int size = dataList.size();
    	int page = gridBean.getPage()<=0?1:gridBean.getPage();
    	int rows = gridBean.getRows()<=0?10:gridBean.getRows();
    	
    	DataList silmDataList = getDataListByPage(dataList, page, rows);
    	
    	gridBean.setGridModel(silmDataList.toList());
		gridBean.setPage(page);
		gridBean.setRows(rows);
		gridBean.setRecords(size);
		gridBean.setTotal(	(size/rows)	+	1);
    	
    	return gridBean;
    }
    
    public GridBean getGridBeanByDataPage(DataPage dataPage, GridBean gridBean) throws XdaoException{
    	gridBean.setPage(dataPage.getCurrentPage());
    	gridBean.setRows(dataPage.getPageSize());
    	gridBean.setRecords(dataPage.getTotalRows());
//    	gridBean.setTotal(dataPage.getTotalPages());
//    	gridBean.set

    	//list
    	List<DataObject> dataObjList = transDataListToList(dataPage.getDataList());
    	gridBean.setGridModel(dataObjList);
    	
    	return gridBean;
    }
    
    public List<DataObject> transDataListToList(DataList dataList){
    	//list
//    	DataList dataList = dataPage.getDataList();
    	List<DataObject> dataObjList = new ArrayList<DataObject>();
    	for(DataObject dataObjs:dataList.toArray()){
    		dataObjList.add(dataObjs);
    	}
    	return dataObjList;
    }
   
	/**
	  * getDataListByPage 說明：給定一個DataList後,<br>
	  * 可以透過page & size 的計算取得subDataList.<br>
	  * 若是輸入的page和size為空，則預設給定第一頁和一次 10 rows<br>
	  * @param dataList
	  * @param page
	  * @param rows
	  * @return <br>
	  * @author game<br>
	 */
	@Deprecated
	public DataList getDataListByPage(DataList dataList, int page, int rows){
		
		page = page<=0?1:page;
		rows = rows<=0?10:rows;
		
		int start 	= 	(page-1) * rows;
		int end 	= 	(page * rows)-1;
		
		return getDataListByRange(dataList, start, end);
		
	}
	
	/**
	  * getDataListByRange 說明：給定一個起始和終止的數字 <br>
	  * ，將會從DataList取出該數字涵蓋的subDataList<br>
	  * @param dataList
	  * @param start
	  * @param end
	  * @return <br>
	  * @author game<br>
	 */
	@Deprecated
	public DataList getDataListByRange(DataList dataList, int start, int end){
		DataList ansDataList = new DataList();
		logger.debug("getDataListByRange|[刪除前]dataList.size()="+dataList.size()
				+",dataList.size()="+dataList.size()
				+",start="+start
				+",end="+end);
		if(start >= 0 && end >= 1){
			for(int i = start; i <= Math.min(end, dataList.size()-1); i++){
				ansDataList.add(dataList.get(i));
				logger.debug("getDataListByRange|["+i+"加入此資料]"+dataList.get(i));
			}
		}
		logger.debug("getDataListByRange|[刪除後]ansDataList.size()="+ansDataList.size());
		return ansDataList;
	}
	
	/**
	 * 在join的時後，需要吃實際宣告的alas Name。
	 * 主要提供給where.addAll的方法使用。
	 * @param dataObject
	 * @param alasString
	 * @return
	 */
	public SqlWhere getDataObjectAlasSqlWhere(DataObject dataObject, String alasString){
		return getDataObjectAlasSqlWhere(dataObject, alasString, false, false);
	}
	
	/**
	 * 在join的時後，需要吃實際宣告的alas Name。
	 * 主要提供給where.addAll的方法使用。
	 * 增加左右%的調整字元
	 * @param dataObject
	 * @param alasString
	 * @param left
	 * @param right
	 * @return
	 */
	public SqlWhere getDataObjectAlasSqlWhere(DataObject dataObject, String alasString, boolean left, boolean right){
		
//		int count = 1;
		
		SqlWhere where = new SqlWhere();
		where.add("1", "1");
		
		for(Object keys:dataObject.getKeys()){
			String keyString = (String) keys;
			String comparison = (left||right)?"like":"=";
			Object values = dataObject.getValue(keyString);
			
			/*要加上alas name 的 column，這絕對是不會少的。*/
			String columnString = StringUtils.isBlank(alasString)?keyString:alasString+"."+keyString; 
			
			/*另外還想加上處理OR的字串，如果遇到OR字串，則必須在前面上一個 1=1 AND 
			 * OR 不採用=> 與 1=1 OR下去是甚麼也沒有*/
//			if(keyString.contains("OR ")){
//				keyString = ++count + "=" + count + " OR " 
//						+ columnString.replace("OR ", "")
//						+ " AND "+values;
//			}else 
			if(keyString.contains(" IS ") || keyString.contains(" <> ") || keyString.contains(" > ") || keyString.contains(" < ") || keyString.contains(" = ")){
				keyString = columnString+" AND "+values;
			}else{
				keyString = columnString;
			}
			
			String outputMethod = "SKIP";
			if(values != null){
				
				if(values instanceof String){
					//ADD STRING
					String valueString = values.toString();

					//確定valueString 不是空的才處理
					if(StringUtils.isNotBlank(valueString)){					
						//% or not
						valueString = left	?	"%"+valueString	:	valueString;
						valueString = right	?	valueString+"%"	:	valueString;
						
						//LIKE or not
						where.add(new SqlPredicate(keyString, comparison, valueString));
						outputMethod = "ADD";
					}
				}else {		
					//ADD Object
					where.add(new SqlPredicate(keyString, comparison, values));
					outputMethod = "ADD";
				}
			}
			
			//output
			System.out.println("GameUtil.getDataObjectAlasMap.253|[" +outputMethod +"]keyString="+keyString+",values="+values);
			
		}
		
		return where;
	}
	
	/**
	 * 給定一個日期，然後會回傳一個日期自串。
	 * 要符合SQL規定的格式
	 * 格式為：to_date("20130912", "yyyyMMDD");
	 * @param day
	 * @return
	 */
	public String getDifferenceFromToday(long day){
		Long l = System.currentTimeMillis();
		l += day * 86400 * 1000;
		RocDate rocDate = new RocDate(l);
		return rocDate.toDateString().replaceColumn("/", "");
	}

	/**
	 * 把日期區間加入到DataObject當中，使用RocDateTime
	 * @param dataObject
	 * @param key
	 * @param dateS
	 * @param dateE
	 * @return
	 */
	public DataObject addDataRangeByKey(DataObject dataObject, String key, RocDate rocDateA, RocDate rocDateB){
		
		if(dataObject==null) dataObject = new DataObject();
		
		rocDateA = rocDateA==null?new RocDate(Long.MIN_VALUE):rocDateA;
		rocDateB = rocDateB==null?new RocDate(Long.MAX_VALUE):rocDateB;
		
		dataObject.remove(key);
		dataObject.setValue(key+" >= to_date('"+rocDateA.toDateString()+" 00:00:00', 'yyyy/MM/dd HH24:mi:ss') and 1", "1");
		dataObject.setValue(key+" <= to_date('"+rocDateB.toDateString()+" 23:59:59', 'yyyy/MM/dd HH24:mi:ss') and 1", "1");
		
		return dataObject;
	}
	
	/**
	 * 把日期區間加入到DataObject當中，使用RocDate
	 * @param dataObject
	 * @param key
	 * @param dateS
	 * @param dateE
	 * @return
	 */
	public DataObject addDataRangeByKey(DataObject dataObject, String key, RocDateTime rocDateTimeA, RocDateTime rocDateTimeB){
		
		if(dataObject==null) dataObject = new DataObject();
		
		rocDateTimeA = rocDateTimeA==null?new RocDateTime(Long.MIN_VALUE):rocDateTimeA;
		rocDateTimeB = rocDateTimeB==null?new RocDateTime(Long.MAX_VALUE):rocDateTimeB;
		
		dataObject.remove(key);
		dataObject.setValue(key+" >= to_date('"+rocDateTimeA.toDateTimeString()+":00', 'yyyy/MM/dd HH24:mi:ss') and 1", "1");
		dataObject.setValue(key+" <= to_date('"+rocDateTimeB.toDateTimeString()+":59', 'yyyy/MM/dd HH24:mi:ss') and 1", "1");
		
		return dataObject;
	}
	
	/**
	  * addDateRangeToDataObjectByKey 說明：針對DataObject 加入日期的查詢區間。 <br>
	  * @param dataObject
	  * @param key 需查詢的欄位名稱
	  * @param dateS 2013/1/1
	  * @param dateE 2013/2/3
	  * @return <br>
	  * @author game<br>
	 */
	public DataObject addDateRangeToDataObjectByKey(DataObject dataObject, String key, String dateS, String dateE){
		
		if(dateS==null||dateS.length()==0||dateS.split("/").length!=3){
			dateS = "2000/01/01";
		}
		if(dateE==null||dateE.length()==0||dateE.split("/").length!=3){
			dateE = "3000/01/01";
		}
		
		dataObject.setValue(key+" >= to_date('"+dateS+" 00:00:00', 'yyyy/MM/dd HH24:mi:ss') and 1", "1");
		dataObject.setValue(key+" <= to_date('"+dateE+" 23:59:59', 'yyyy/MM/dd HH24:mi:ss') and 1", "1");
		
		return dataObject;
	}

	/**
	  * addDateRangeToDataObjectByKey 說明：提供DataList的輸出入方式，進行設定。 <br>
	  * @param dataList
	  * @param key
	  * @param dateS
	  * @param dateE
	  * @return <br>
	  * @author game<br>
	 */
	public DataList addDateRangeToDataObjectByKey(DataList dataList, String key, String dateS, String dateE){
		DataList newDataList = new DataList();
		for(DataObject dataObject: dataList.toArray()){			
			newDataList.add(addDateRangeToDataObjectByKey(dataObject, key, dateS, dateE));
		}
		return newDataList;
	}

	/**
	  * getADStringFromRocDateString 說明： 依照傳入的rocDateString以"/"切成String[]<br>
	  * 若切割有問題會進行空字串回傳。若接收到空字串需要進來修正....<br>
	  * @param rocDateString
	  * @return String ""=>代表有問題；2012/01/01=>代表正確<br>
	  * @author game<br>
	 */
	public String getADStringFromRocDateString(String rocDateString){
		
		if(rocDateString==null){
			return "";
		}
		
		String ansYear = "";
		String ansMonth = "";
		String ansDay = "";
		String[] inString = rocDateString.split("/");
		String[] inString2 = rocDateString.split("-");
		
		if(inString.length == 3){
			ansYear = inString[0];
			ansMonth = inString[1];
			ansDay = inString[2];
			
			ansYear = String.valueOf((Integer.valueOf(ansYear)+1911));
		}
		
		if(inString2.length == 3){
			ansYear = inString2[0];
			ansMonth = inString2[1];
			ansDay = inString2[2];
			
			ansYear = String.valueOf((Integer.valueOf(ansYear)+1911));
		}
		
		if(rocDateString.length() == 3){
			ansYear = inString[0];
			ansMonth = inString[1];
			ansDay = inString[2];
			
			ansYear = String.valueOf((Integer.valueOf(ansYear)+1911));
		}
		
		ansMonth = String.valueOf(ansMonth).compareTo("12")>0?"12"
				:String.valueOf(ansMonth).compareTo("01")<0?"1"
				:ansMonth;
		
		ansDay = String.valueOf(ansDay).compareTo("31")>0?"31"
				:String.valueOf(ansDay).compareTo("01")<0?"1"
				:ansDay;
		
		ansMonth = ansMonth.length()==1?"0"+ansMonth:ansMonth;
		ansDay = ansDay.length()==1?"0"+ansDay:ansDay;
		
		String returnString = ansYear  +"/"+  ansMonth  +"/"+  ansDay;
		
		logger.debug("DateUtils.getADStringFromRocDateString()|" +
				"rocDateString="+rocDateString
				+",returnString="+returnString);
		
		return returnString;
	}

	/**
	 * 建立一個ProcessResult affectedRow會傳遞到訊息去。<br>
	 * 
	 * @param count
	 * @param msg
	 * @param object
	 * @return
	 */
	public ProcessResult getProcessResult(int affectedRow, String msg, Object object){
		
		ProcessResult result = new ProcessResult();
		
		String outMsg = msg;
		
		if(affectedRow>0){
			result.setStatus(ProcessResult.OK);
			outMsg += "成功"+affectedRow;
		}else if(affectedRow==0){
			result.setStatus(ProcessResult.OK);
			outMsg += "完成"+affectedRow;
		}else{
			result.setStatus(ProcessResult.NG);
			outMsg += "錯誤"+affectedRow;
		}
		
		result.addMessage(outMsg);
		result.addError(outMsg);
		
		result.setObject(object);
		
		logger.debug("GameUtil.getProcessResult.325|outString="+outMsg+",object="+object);
		
		return result;
	}
	
	public ProcessResult getProcessResult(boolean isOk, String msg){
		return getProcessResult(isOk, msg, null);
	}
	
	public ProcessResult getProcessResult(boolean isOk, String msg, Object object){
		return getProcessResult(isOk?1:-1, msg, object);
	}
	
	public ProcessResult getProcessResult(int affectedRow, String msg){
		return getProcessResult(affectedRow, msg, null);
	}
	
	public ProcessResult getProcessResult(ProcessResult result){
		return getProcessResult(
				result.getStatus()==ProcessResult.OK
				, result.getMessages().toString()
				, result.getObject());
	}
	
	
	/**
	 * 把ProcessResult串接起來
	 * Status透過 AND 邏輯串接起來，若是發生false則會全盤已false回應。
	 * Message 字串 會完全串接起來
	 * Error 字串 會完全串接起來
	 * 
	 * 改版：Object裡面放了各個ProcessResult的資訊。
	 * ProcessResult裡面有status, data, msg三個資訊。
	 * 裡面僅僅保留status和object的資訊，其他的資訊用途比較小。
	 * 所以就直接排除。
	 * 
	 * 錯誤訊息還是得要append
	 * 
	 * @param results
	 * @return ProcessResult
	 * @throws XdaoException
	 */
	public ProcessResult getProcessResults(ProcessResult... results) throws XdaoException{
		
		String logMsg = "GameUtil.getProcessResults.412|";
		logger.debug(logMsg += "[Start],results="+results);
		
		ProcessResult sumResult = new ProcessResult();
		Set<Map<String, Object>> dataSet = new LinkedHashSet<Map<String, Object>>();
		
		
		int statusCount = 0;
		List<String> okMsgLisg = new ArrayList<String>();
		List<String> ngMsgLisg = new ArrayList<String>();
		
		for(ProcessResult result:results){
			statusCount += result.getStatus();
			okMsgLisg.addAll(result.getMessages());
			ngMsgLisg.addAll(result.getErrors());
			
			//把資料重新組到dataSet當中
			if(result.getObject() instanceof LinkedHashSet){
				dataSet.addAll((LinkedHashSet<Map<String, Object>>)result.getObject());
			}else{
				Map<String, Object> objMap = new HashMap<String, Object>();
				objMap.put("status", result.getStatus());
				objMap.put("object", result.getObject());
				dataSet.add(objMap);
			}
			
			logger.debug(logMsg += "[APPEND],result="+result);
			
		}
		
		//只要有NG情況出現，那就是NG。
		sumResult.setStatus(statusCount>0
				?ProcessResult.NG:ProcessResult.OK);
		
		//所有的訊息都是串接，不用考慮
		sumResult.setMessages(okMsgLisg);
		sumResult.setErrors(ngMsgLisg);
		//把重組好的dataSet重新放入Object當中
		sumResult.setObject(dataSet);
		
		logger.debug(logMsg += "[END],sumResult="+sumResult);
		
		return sumResult;
	}
	
}
