/**
 * Copyright (c) 2012 Trade-Van Information Service Co.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Trade-Van Information Service Co. ("Confidential Information").
 *
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of license agreement you entered
 * into with Trade-Van Information Service Co.   
 */
package gov.customs.aci.cs.cd.service;

import gov.customs.aci.cs.cc.util.GameUtil;
import gov.customs.aci.cs.cd.model.XTCSDATRMModel;
import gov.customs.aci.cs.common.service.CSDMSGMService;
import gov.customs.aci.cs.dao.bean.CSDCODMBean;
import gov.customs.aci.cs.dao.bean.CSDDISMBean;
import gov.customs.aci.cs.dao.bean.CSDMSGMBean;
import gov.customs.aci.cs.dao.bean.CSDPICMBean;
import gov.customs.aci.cs.dao.bean.CSDREVMBean;
import gov.customs.aci.cs.dao.model.CSDCODMModel;
import gov.customs.aci.cs.dao.model.CSDDISMModel;
import gov.customs.aci.cs.dao.model.CSDMSGMModel;
import gov.customs.aci.cs.dao.model.CSDPICMModel;
import gov.customs.aci.cs.dao.model.CSDRCAMModel;
import gov.customs.aci.cs.dao.model.CSDRCSMModel;
import gov.customs.aci.cs.dao.model.CSDREVMModel;
import gov.customs.commons.bean.CodeData;
import gov.customs.commons.bean.UserData;
import gov.customs.commons.converter.RocDate;
import gov.customs.commons.converter.RocDateTime;
import gov.customs.commons.service.DefaultService;
import gov.customs.commons.service.ProcessResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;

import com.tradevan.commons.collection.DataList;
import com.tradevan.commons.collection.DataObject;
import com.tradevan.commons.io.FileUtil;
import com.tradevan.taurus.xdao.DataPage;
import com.tradevan.taurus.xdao.SqlPredicate;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.TemplateResult;
import com.tradevan.taurus.xdao.XdaoException;
import com.tradevan.taurus.xdao.XdaoTemplate;

/**
 * 作 業 代 碼 ：<br>
 * 作 業 名 稱 ：CD共用服務<br>
 * 程 式 代 號 ：CDService.java<br>
 * 描　　　　述 ：<br>
 * 公　　　　司 ：Tradevan Co.<br><br>
 *【 資 料 來 源】  ：<br>
 *【 輸 出 報 表】  ：<br>
 *【 異 動 紀 錄】  ：<br>
 * @author   : jimmy Lin<br>
 * @version  : 1.0.0 2012/11/19<P>
 */
public class CDService extends DefaultService {
	/**
	 * 分案簽註檔(CSDDISM)
	 */
	CSDDISMModel csddismModel = new CSDDISMModel();
	/**
	 * 稅則核定-附件檔(CSDPICM)
	 */
	CSDPICMModel csdpicmModel = new CSDPICMModel();
	/**
	 * 訊息通知檔(CSDMSGM)
	 */
	CSDMSGMModel csdmsgmModel = new CSDMSGMModel();
	/**
	 * 收件註記檔
	 */
	CSDREVMModel csdrevmmodel = new CSDREVMModel();

	 /**
	  * getDateAfter 說明：取得N天後日期.<br>
	  * EX: getDateAfter(new Date,5); 取得五天後日期<br>
	  * @param d 日期
	  * @param day n天後
	  * @return
	  * @author Jimmy Lin
	  */
	public static Date getDateAfter(Date d,int day){  
	    Calendar now = Calendar.getInstance();  
		now.setTime(d);  
	    now.set(Calendar.DATE,now.get(Calendar.DATE)+day);  
	    return now.getTime();  
	}
	
	 /**
	  * loadFile 說明：讀取檔案<br>
	  * @param filename 檔案路徑
	  * @return InputStream
	  * @throws IOException
	  * @author jimmy Lin
	  */
	public InputStream loadFile(String filename) throws IOException {
		File file = new File(filename);
		if (file.exists()) {
			ByteArrayInputStream is = new ByteArrayInputStream(FileUtil.read(file));
			return is;
		} else {
			logger.error(file + " was not found!");
		}
		return null;
		
	}

	 /**
	  * zipFile 說明：壓縮檔案<br>
	  * @param pathList 檔案路徑列表字串(以,分隔)
	  * @param zos
	  * @throws IOException
	  * @author jimmy Lin
	  */
	private void zipFile(List<File> pathList, ZipOutputStream zos) throws IOException {       
	    for (int i=0;i<pathList.size();i++) {  
		     File f = pathList.get(i);  
		     zos.putNextEntry(new ZipEntry(f.getName()));     
		     FileInputStream fis = new FileInputStream(f);     
		     byte[] buffer = new byte[1024];     
		     int r = 0;     
		     while ((r = fis.read(buffer)) != -1) {     
		    	 zos.write(buffer, 0, r);     
		     }     
		fis.close();   
		}  
	}
	
	 /**
	  * downloadFiles 說明：下載檔案<br>
	  * @param list 下載檔案列表(路徑)
	  * @param response HttpServletResponse
	  * @param fileName 下載顯示檔案名稱
	  * @author jimmy Lin
	  */
	public void downloadFiles(String[] list , HttpServletResponse response , String fileName){
		try {
	        response.setContentType("application/zip");
	        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
	        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());     
	        List<File> files = new ArrayList<File>();
	        File tmp;
	        for (int i = 0; i < list.length; i++) {
	        	tmp = new File(list[i]);
	        	/* 檢查檔案存在才加入 */
	        	if(tmp.exists()){
	        		logger.debug(tmp.getName() + "已找到檔案!!");
	        		files.add(tmp);
	        	}else{
	        		logger.debug(tmp.getName() + "遺失檔案!!");
	        	}
			}
	        
	        /* 若無檔案不進行壓縮及傳送 */
	        if(files.size() >= 1){
		        zipFile(files, zos);
		        logger.debug("壓縮完成");
		        zos.flush();
		        zos.close();
	        }else{
	        	logger.debug("壓縮檔無任何檔案");
	        }
	        response.reset();
		} catch (IOException e) {
			logger.error(e, e);
		}
	}
	
	 /**
	  * deleteFile 說明：刪除附件檔.<br>
	  * 刪除附件檔並將路徑檔案刪除
	  * @param delList 欲刪除附件列表
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public void deleteFile(List<DataObject> delList) throws XdaoException{
		for(DataObject delTmp:delList){
	        SqlWhere sql = new SqlWhere();
	        sql.add(CSDPICMBean.TF_TYPE,delTmp.getString("TF_TYPE"));
	        sql.add(CSDPICMBean.TF_DOC_NO,delTmp.getString("TF_DOC_NO"));
	        sql.add(CSDPICMBean.TF_DOC_TYPE,delTmp.getString("TF_DOC_TYPE"));
	        sql.add(CSDPICMBean.TF_SEQ_NO,delTmp.getString("TF_SEQ_NO"));
	        csdpicmModel.del(sql);
	        
	        File delFile = new File(delTmp.getString("TF_PIC_PATH"));
	        delFile.delete();
	        logger.debug("已刪除: " + delTmp.getString("TF_PIC_PATH"));
		}
        
	}
	
	 /**
	  * getAttType 說明：取得附件類別<br>
	  * code:A03疑義 , B03預審
	  * @return List
	  * @author jimmy Lin
	  */
	static public List<CodeData> getAttType(String code) {
        List<CodeData> lst = new ArrayList<CodeData>();
        try {
            SqlWhere where = new SqlWhere();
            where.add(new SqlPredicate(CSDCODMBean.CODEKIND, "=", code, true));
            CSDCODMModel model = new CSDCODMModel();
            DataList dataList = model.getDataList(where);

            for (int i = 0; i < dataList.size(); i++) {
                CodeData cd = new CodeData();
                cd.setCode(dataList.get(i).getString("CODE"));
                cd.setCodeChinse(dataList.get(i).getString("CODE_REMARK"));
                lst.add(cd);
            }

        } catch (XdaoException e) {
            e.printStackTrace();
        }
        return lst;
    }
	
     /**
      * getCSDPICM 說明：取得附件列表<br>
      * @param tfCustomSerialNo 文號
      * @param codekind 作業別:A03,B03
      * @return ProcessResult
      * @author jimmy Lin
      */
    public ProcessResult getCSDPICMs(String tfCustomSerialNo,String codekind) {
        ProcessResult result = new ProcessResult();
        try {
            XdaoTemplate template = XTCSDATRMModel.getTemplate();
            DataObject dataObject = new DataObject();
            dataObject.setValue("TF_DOC_NO", tfCustomSerialNo);
            dataObject.setValue("CODE_KIND", codekind);
            if(!"I".equals(getUserData().getMainCustCd()))
            	dataObject.setValue("TF_DOC_TYPE", "1");
            DataPage page = template.getDataPage("CD101QueryCSDPICMData", dataObject);
            logger.debug("########### page " + page.getDataList().toList() + "  ##############");

            result.setStatus(ProcessResult.OK);
            if (page.getTotalRows() == 0) {
                result.addMessage(getText(MCOD004));
            } else {
                result.addMessage(getText(ECOP002));
                result.setDataPage(page);
            }

        } catch (XdaoException e) {
            e.printStackTrace();
            result.setStatus(ProcessResult.NG);
            result.addError(getText(ECOD005));// ECOD005=查詢失敗。
        }
        return result;
    }
    
     /**
      * getCSDPICMSeqNo 說明：取得附件檔序號<br>
      * @param csdpicm 稅則核定-附件檔(CSDPICM)
      * @return String
      * @author jimmy Lin
      */
    public String getCSDPICMSeqNo(CSDPICMBean csdpicm) {
        String resultStr = "001";
        try {
            SqlWhere where = new SqlWhere();
            if (StringUtils.isNotBlank(csdpicm.getTfType()))
                where.add(new SqlPredicate(CSDPICMBean.TF_TYPE, "=", csdpicm.getTfType(), true));
            if (StringUtils.isNotBlank(csdpicm.getTfDocNo()))
                where.add(new SqlPredicate(CSDPICMBean.TF_DOC_NO, "=", csdpicm.getTfDocNo(), true));

            String filed = " nvl(lpad(max(to_number(tf_seq_no)+1),3,'0'),'001') maxcode ";
            DataList dataList = csdpicmModel.getDataList(filed, where, "");

            if (dataList.size() > 0) {
                resultStr = dataList.get(0).getString("MAXCODE");
            }
        } catch (XdaoException e) {
            e.printStackTrace();
        }
        return resultStr;
    }
    

     /**
      * addCSDPICM 說明：寫入附件檔表格<br>
      * @param obj 稅則核定-附件檔(CSDPICM)
      * @return ProcessResult
      * @throws XdaoException
      * @author jimmy Lin
      */
    public ProcessResult addCSDPICM(CSDPICMBean obj) throws XdaoException {
        ProcessResult result = new ProcessResult();
        try {
            if (csdpicmModel.existsByPKFields(obj)) {
                result.setStatus(ProcessResult.NG);
                result.addError(getText(ECOD002, new String[] { getText("operationType") + "," + getText("tfDocNo")+","+getText("uploadType")+ "," + getText("tfSeqNo") }));// ECOD002=新增失敗，{0}資料已存在。
            } else {
                csdpicmModel.add(obj);
                result.setStatus(ProcessResult.OK);
                result.addMessage(getText(ECOP002));// ECOP002=執行成功。
            }
        } catch (XdaoException e) {
            e.printStackTrace();
            result.setStatus(ProcessResult.NG);
            result.addError(getText(ECOD001));// ECOD001=新增失敗。
            throw e;
        }
        return result;
    }
    
     /**
      * getOpinionData 說明：匯入簽注用箋資料<br>
      * @param custCd 關別
      * @param tfType A:預審,B:疑義
      * @param tfDocNo 文號
      * @return String
      * @author jimmy Lin
      */
    public DataObject getOpinionData(String custCd, String tfType, String tfDocNo) {
        String resultStr = "";
        DataObject data = new DataObject();
        try {
            SqlWhere where = new SqlWhere();
            where.add(new SqlPredicate(CSDDISMBean.CUST_CD, "=", custCd, true));
            where.add(new SqlPredicate(CSDDISMBean.TF_TYPE, "=", tfType, true));
            where.add(new SqlPredicate(CSDDISMBean.TF_DOC_NO, "=", tfDocNo, true));
            where.add(new SqlPredicate(CSDDISMBean.TF_COMM_CHK, "=", "Y", true));/* 須為陳核完成 */

            String[] filed = {"TF_COMM","TF_IMP"};
            DataList dataList = csddismModel.getDataList(filed, where);

            if (dataList.size() > 0) {
                resultStr = dataList.get(0).getString("TF_COMM");
                data.setValue("TF_IMP", dataList.get(0).getString("TF_IMP"));
            }else{
            	resultStr="查無資料";
            }
            data.setValue("TF_COMM", resultStr);
            data.setValue("ROW", String.valueOf(dataList.size()));
        } catch (XdaoException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    /**
	  * getImageList 說明：取得圖檔附件<br>
	  * 依文號查詢圖檔附件,codekind為A03,B03<br>
	  * 只列印為jpg,png圖檔並且檔案存在
	  * @param queryId 文號
	  * @param codekind 作業別
	  * @return List
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public List<DataObject> getImageList(String queryId,String codekind) throws XdaoException{
	    DataPage fileList = getCSDPICMs(queryId,codekind).getDataPage();
	   	DataList dataList = fileList!=null?fileList.getDataList():new DataList();
	   	DataObject dotmp;
	   	List<DataObject> imageList = new ArrayList<DataObject>();
	   	
	   	for(int i = 0;i < dataList.size();i++){
	   		dotmp = dataList.get(i);
	   		if(dotmp.getString("tf_pic_path")!=null)
	   		if(dotmp.getString("tf_pic_path").indexOf(".jpg")>=1 || dotmp.getString("tf_pic_path").indexOf(".png")>=1){
	   			if(new File(dotmp.getString("tf_pic_path")).exists())/* 如果檔案存在才加入 */
	   				imageList.add(dotmp);
	   		}
	   	}
		return imageList;
	    }
   
   
    /**
     * createStringCell 說明：寫入字串EXCEL第row欄,column列<br>
     * @param row 欄
     * @param column 列
     * @param value 字串
     * @param cs HSSFCellStyle
     * @author jimmy Lin
     */
   @SuppressWarnings("deprecation")
	public void createStringCell(HSSFRow row, short column, String value,HSSFCellStyle cs) {  
       HSSFCell cell = row.createCell(column);  
       cell.setCellValue(new HSSFRichTextString(value));
       if(cs!=null)
           cell.setCellStyle(cs);
   }
   
	 /**
	  * createStringCell 說明：寫入字串EXCEL第row欄,column列<br>
	  * @param row 欄
	  * @param column 列
	  * @param value 字串
	  * @author jimmy Lin
	  */
	public void createStringCell(HSSFRow row, short column, String value) {  
		createStringCell(row,column,value,null);
    }
	
	 /**
	  * createFile 說明：創建檔案<br>
	  * @param tmpFilePath 檔案路徑
	  * @param tmpFileName 檔案路徑+檔名
	  * @return File
	  * @author jimmy Lin
	  */
	public File createFile(String tmpFilePath, String tmpFileName){
   	File tmpFile = null;
   	try {
   		/*如果目錄不存在，就創建*/
	        tmpFile = new File(tmpFilePath);
	        if(!tmpFile.exists())
	            if(!tmpFile.mkdirs())
	            	;
       
	        /*如果文件不存在，就創建*/
	        tmpFile = new File(tmpFileName);
	        if(!tmpFile.exists())
				if(!tmpFile.createNewFile())
					;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmpFile;
   }
   
	 /**
	  * getCsdcodm 說明：取得代碼<br>
	  * code: 代碼編號
	  * @return List
	  * @author jimmy Lin
	  */
	static public List<CodeData> getCsdcodm(String code) {
       List<CodeData> lst = new ArrayList<CodeData>();
       try {
           SqlWhere where = new SqlWhere();
           where.add(new SqlPredicate(CSDCODMBean.CODEKIND, "=", code, true));
           CSDCODMModel model = new CSDCODMModel();
           DataList dataList = model.getDataList(where);

           for (int i = 0; i < dataList.size(); i++) {
               CodeData cd = new CodeData();
               cd.setCode(dataList.get(i).getString("CODE"));
               cd.setCodeChinse(dataList.get(i).getString("CODE_REMARK"));
               lst.add(cd);
           }

       } catch (XdaoException e) {
           e.printStackTrace();
       }
       return lst;
   }
   
	 /**
	  * checkFileStatus 說明：檢查檔案是否存在<br>
	  * @param dataObject
	  * @return ProcessResult
	  * @author jimmy Lin
	  */
	public ProcessResult checkFileStatus(DataObject dataObject){
		String[] list = ((String[])dataObject.getValue("data"))[0].split(",");
		String[] fileName = ((String[])dataObject.getValue("fileName"))[0].split(",");
		
		ProcessResult result = new ProcessResult();
		result.setStatus(ProcessResult.OK);
		for (int i = 0; i < list.length; i++) {
			/* 確認檔案是否存在 */
			if(!new File(list[i]).exists()){
				result.setStatus(ProcessResult.NG);
				result.addMessage("FileName:" + fileName[i] + " 檔案已遺失");
			}
		}
		return result;
	}
	
	
	 /**
	  * parseCustCdName 說明：轉換關別代碼成中文名稱<br>
	  * @param custCd 關別代碼
	  * @return String
	  * @author jimmy Lin
	  */
	 public String parseCustCdName(String custCd) {
		String name = "";
		if("A".equals(custCd)){
			name = "基隆關";
		}else if("B".equals(custCd)){
			name = "高雄關";
		}else if("C".equals(custCd)){
			name = "台北關";
		}else if("D".equals(custCd)){
			name = "台中關";
		}else if("I".equals(custCd)){
			name = "關務署";
		}
		return name;
	}	

	 /**
	  * getAttachment 說明：取得附件類別及件數<br>
	  * @param tfCustomSerialNo 文號
	  * @return ProcessResult
	  * @author jimmy Lin
	  */
	public ProcessResult getAttachment(String tfCustomSerialNo,String codeKind) {
	       ProcessResult result = new ProcessResult();
	       try {

	           XdaoTemplate template = XTCSDATRMModel.getTemplate();

	           DataObject dataObject = new DataObject();
	           dataObject.setValue("TF_CUSTOM_SERIAL_NO", tfCustomSerialNo);
	           dataObject.setValue("CODE_KIND", codeKind);

	           DataPage page = template.getDataPage("CD101_203QueryAttachment", dataObject);

	           logger.debug("########### page " + page.getDataList().toList() + "  ##############");

	           result.setStatus(ProcessResult.OK);
	           if (page.getTotalRows() == 0) {
	               result.addMessage(getText(MCOD004));
	           } else {
	               result.addMessage(getText(ECOP002));
	               result.setDataPage(page);
	           }
	       } catch (XdaoException e) {
	           e.printStackTrace();
	           result.setStatus(ProcessResult.NG);
	           result.addError(getText(ECOS005));
	       }
	       return result;
	   }

	 /**
	  * deleteAllFile 說明：刪除全部附件檔案<br>
	  * @param tfType 作業別A,B
	  * @param tfCustomSerialNo 文號
	  * @author jimmy Lin
	  * @throws XdaoException 
	  */
	@SuppressWarnings("unchecked")
	public void deleteAllFile(String tfType, String tfCustomSerialNo) throws XdaoException {
        DataObject del = new DataObject();
        del.setValue("TF_TYPE", tfType);
        del.setValue("TF_DOC_NO", tfCustomSerialNo);
        List<DataObject> delFileList = csdpicmModel.getDataList(del).toList();
        deleteFile(delFileList);
	}
	
	
	
	 /**
	  * delMessage 說明：刪除訊息檔(未接收的訊息才刪)<br>
	  * DB:訊息通知檔(CSDMSGM)<br>
	  * @param tfDocNo 文號
	  * @param rcvUser 接收者
	  * @return boolean
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public boolean delMessage(String tfDocNo,String rcvUser) throws XdaoException{
        CSDMSGMBean csdmsgm=new CSDMSGMBean();
    	csdmsgm.setTfDocNo(tfDocNo);
    	csdmsgm.setRcvUser(rcvUser);
    	
    	//訊息通知檔(CSDMSGM)
    	TemplateResult result = CSDMSGMModel.getTemplate().executeUpdate("del_Message_CDService", csdmsgm);
    	
    	return result.getAffectedNum() >= 1; 
	}
	
	 /**
	  * addCsdrevm 說明：新增收件註記檔<br>
	  * @param tfType 作業別
	  * @param tfDocNo 文號
	  * @param tfFunc 收件註記代號
	  * @return true:成功,false:失敗
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public int addCsdrevm(String tfType, String tfDocNo , String tfFunc) throws XdaoException{
		DataObject sqlObj = new DataObject();
		sqlObj.setValue("TF_TYPE", tfType);
		sqlObj.setValue("TF_DOC_NO", tfDocNo);
		sqlObj.setValue("TF_FUNC", tfFunc);
		sqlObj.setValue("SEND_DATE", new RocDate());
    	
		return  csdrevmmodel.add(sqlObj);
	}
	
	/**
	 * 提供tfFunc自動判斷的機制提供新增資料
	 * @param tfType
	 * @param tfDocNo
	 * @return
	 * @throws XdaoException
	 */
	public int addCsdrevm(String tfType, String tfDocNo) throws XdaoException{
		String tfFunc = "A".equals(tfType)?"5":"3";
		int count = addCsdrevm(tfType, tfDocNo, tfFunc);
		return count;
	}
	
	 /**
	  * deleteCsdrevm 說明：刪除收件註記檔<br>
	  * @param tfType 作業別
	  * @param tfDocNo 文號
	  * @param tfFunc 收件註記代號
	  * @return true:成功,false:失敗
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public boolean deleteCsdrevm(String tfType, String tfDocNo , String tfFunc) throws XdaoException{
		SqlWhere where = new SqlWhere();
        where.add(new SqlPredicate(CSDREVMBean.TF_TYPE, "=", tfType, true));
        where.add(new SqlPredicate(CSDREVMBean.TF_DOC_NO, "=", tfDocNo, true));
        where.add(new SqlPredicate(CSDREVMBean.TF_FUNC, "=", tfFunc, true));
		int count = csdrevmmodel.del(where);
		if(count >= 1)
			return true;
		
		return false;
	}
	
	 /**
	  * queryCSDMSGM 說明：查詢訊息通知檔(未接收)<br>
	  * @param dataObject
	  * @return Map
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public Map<String, String> queryCSDMSGM(String userId) throws XdaoException{
		Map<String, String> resultMap = new HashMap<String, String>();
		
		/*這個方法應該抽離，直接取得DataList*/
		CSDMSGMService csdmsgmService = new CSDMSGMService(); 
		DataList dataList = csdmsgmService.queryList(userId);
		
		resultMap.put("size", String.valueOf(dataList.size()));
		StringBuilder noDocNo = new StringBuilder();
		String executeJob = "CD105";
		
		if(dataList.size() >= 1)
			executeJob = dataList.get(0).getString("EXEC_JOB");
		for (int i = 0; i < dataList.size(); i++) {
			noDocNo.append(dataList.get(i).getString("TF_DOC_NO"));
			if(i != dataList.size()-1)
				noDocNo.append(",");
		}
		
		resultMap.put("no", noDocNo.toString());
		resultMap.put("executeJob", executeJob);
		return resultMap;
	}

	 /**
	  * updateCSDMSGM 說明：更新訊息通知檔(確認收件)<br>
	  * 這裡單純進行把給定的WHERE進行MSG_MARK的欄位Y給定<br>
	  * 僅僅單純只做這件事情而已。<br>
	  * @param dataObject
	  * @return Map
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public ProcessResult updateCSDMSGM(DataObject dataObject) throws XdaoException {
//		Map<String, String> resultMap = new HashMap<String, String>();
//		SqlWhere sqlWhere = new SqlWhere();
//		sqlWhere.add(new SqlPredicate("RCV_USER", "=", dataObject.getString("RCV_USER"), true));
//		sqlWhere.add(new SqlPredicate("EXEC_JOB", "=", dataObject.getString("EXEC_JOB"), true));
//		DataObject updateObject = new DataObject();
//		//updateObject.setValue("RCV_DATE", new RocDateTime());資料庫為字串 待確認
//		updateObject.setValue("MSG_MARK", "Y");
		ProcessResult result = new ProcessResult();
		CSDMSGMService csdmsgmService = new CSDMSGMService();
		int affectedRow = csdmsgmService.setMsgMarkY(dataObject.getString("RCV_USER"), dataObject.getString("EXEC_JOB"));
		if(affectedRow >= 1)
			result.setStatus(result.OK);//.put("status", "ok");
		else
			result.setStatus(result.NG);//resultMap.put("status", "ng");
		return result;
	}
	
	 /**
	  * createFileNo 說明：造冊作業編號函數<br>
	  * @param dataObject
	  * @param tfType 作業別A疑義、B預審
	  * @return String
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public String createFileNo(String tfType,String tfDocNo) throws XdaoException{
		DataObject dataObject = new DataObject();
		/* 取得目前民國年 */
		//Calendar c = Calendar.getInstance();
		//String year = String.format("%03d",c.get(Calendar.YEAR)-1911);
		/* 使用文號之年度 */
		String year = "B".equals(tfType)?tfDocNo.substring(2,5):tfDocNo.substring(0,3);
		logger.debug("file no type:" + tfType);
		logger.debug("file no year:" + year);
		logger.debug("file no ?:" + tfDocNo.substring(2,5)+"  "+tfDocNo.substring(0,3));
		dataObject.setValue("TF_TYPE", tfType);
		dataObject.setValue("TF_YEAR", year);
		TemplateResult tr = CSDRCSMModel.getTemplate().executeQuery("query_002_CD104", dataObject);
		String fileNo = "";
		if(tr.getResult().size() >= 1){
			/* 如果已經有前次編號 */
			fileNo = year + tfType +tr.getResult().get(0).getString("NO");
		}else{
			/* 若無則直接從0001編號 */
			fileNo = year +  tfType + "0001";
		}
		return fileNo;
	}
	
	 /**
	  * addCSDRCAM 說明：新增疑義辦結作業檔<br>
	  * @param id 文號
	  * @param nDay N個工作天
	  * @author jimmy Lin
	  */
	public void addCSDRCAM(String id , int nDay){
		/* 新增辦結檔 */
	    CSDRCAMModel csdracmModel = new CSDRCAMModel();
	    DataObject tmp = new DataObject();
	    tmp.setValue("TF_DOC_NO", id);
		tmp.setValue("TF_APP_PERSON", getUserData().getUserId());
		tmp.setValue("TF_APP_CLOSE_DATE", CDService.getAfterWorkRocDay(new Date(), nDay));
		tmp.setValue("UP_PERSON", getUserData().getUserId());
		tmp.setValue("UP_DATE", new RocDateTime());
		try {
			csdracmModel.add(tmp);
		} catch (XdaoException e) {
			logger.debug(e);
		}
	}
	
	 /**
	  * addCSDRCAM 說明：新增預審辦結作業檔<br>
	  * @param id 文號
	  * @param nDay N個工作天
	  * @author jimmy Lin
	  */
	public void addCSDRCSM(String id , int nDay){
		/* 新增辦結檔 */
		CSDRCSMModel csdrcsmModel = new CSDRCSMModel();
	    DataObject tmp = new DataObject();
	    tmp.setValue("TF_CUSTOM_SERIAL_NO", id);
		tmp.setValue("TF_CUTOM_ID", getUserData().getUserId());
		tmp.setValue("TF_EXPECT_DATE", CDService.getAfterWorkRocDay(new Date(), nDay));
		tmp.setValue("UP_PERSON", getUserData().getUserId());
		tmp.setValue("UP_DATE", new RocDateTime());
		try {
			csdrcsmModel.add(tmp);
		} catch (XdaoException e) {
			logger.debug(e);
		}
	}
	
	 /**
	  * updateCSDDPICM 說明：更新附件檔<br>
	  * 開放上網數量限制5筆，超過數量將提示訊息不可更新
	  * @param dataObject
	  * @return ProcessResult
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public ProcessResult updateCSDDPICM(DataObject dataObject) throws XdaoException{
		ProcessResult result = new ProcessResult();
		
		if(checkOpenFlagCount(dataObject) > 5 && "Y".equals(dataObject.getString("TF_OPEN_FLAG"))){
			result.setStatus(ProcessResult.OK);
			result.addMessage("附件檔:修改失敗，已超過允許開放上網附件數量");
			return result;
		}
		
		int count = csdpicmModel.updateByPKFields(dataObject);
		
		if(count < 1){
			result.setStatus(ProcessResult.NG);
			result.addError("附件檔:未能更新到資料");
		}else{
			result.setStatus(ProcessResult.OK);
			result.addMessage("附件檔:修改成功");
		}
			
		return result;
	}
	
	 /**
	  * checkOpenFlagCount 說明：檢查開放上網數量<br>
	  * @param dataObject
	  * @return int
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public int checkOpenFlagCount(DataObject dataObject) throws XdaoException{
		String[] filed ={"count(*) count"};
		SqlWhere where = new SqlWhere();
		where.add(CSDPICMBean.TF_TYPE,dataObject.getString("TF_TYPE"));
		where.add(CSDPICMBean.TF_DOC_NO,dataObject.getString("TF_DOC_NO"));
		where.add(CSDPICMBean.TF_OPEN_FLAG,"Y");
		DataList list = csdpicmModel.getDataList(filed, where);
		return list.get(0).getInt("count");
	}
	
     /**
      * getDaysBetween 說明：取得兩日期間隔日數<br>
      * @param d1
      * @param d2
      * @return int
      * @author jimmy Lin
      */
    public static int getDaysBetween(java.util.Calendar d1, java.util.Calendar d2) {
        if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
            java.util.Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(java.util.Calendar.DAY_OF_YEAR) - d1.get(java.util.Calendar.DAY_OF_YEAR);
        int y2 = d2.get(java.util.Calendar.YEAR);
        if (d1.get(java.util.Calendar.YEAR) != y2) {
            d1 = (java.util.Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
                d1.add(java.util.Calendar.YEAR, 1);
            } while (d1.get(java.util.Calendar.YEAR) != y2);
        }
        return days;
    }
     /**
      * getWorkingDay 說明：計算2個日期之間的相隔工作天數<br>
      * @param d1
      * @param d2
      * @return int
      * @author jimmy Lin
      */
    public static int getWorkingDay(java.util.Calendar d1, java.util.Calendar d2) {
        int result = -1;
        if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
            java.util.Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int charge_start_date = 0;// 開始日期的日期偏移量
        int charge_end_date = 0;// 結束日期的日期偏移量
        // 日期不在同一個日期之內
        int stmp;
        int etmp;
        stmp = 7 - d1.get(Calendar.DAY_OF_WEEK);
        etmp = 7 - d2.get(Calendar.DAY_OF_WEEK);
        if (stmp != 0 && stmp != 6) {// 開始日期為星期六和星期日時偏移量為0
            charge_start_date = stmp - 1;
        }
        if (etmp != 0 && etmp != 6) {// 結束日期為星期六和星期日時偏移量為0
            charge_end_date = etmp - 1;
        }
        
        result = (getDaysBetween(getNextMonday(d1), getNextMonday(d2)) / 7)
                * 5 + charge_start_date - charge_end_date;
        return result;
    }
     /**
      * getNextMonday 說明：獲得日期的下一個星期一的日期<br>
      * @param date
      * @return Calendar
      * @author jimmy Lin
      */
    public static Calendar getNextMonday(Calendar date) {
        Calendar result = null;
        result = date;
        do {
            result = (Calendar) result.clone();
            result.add(Calendar.DATE, 1);
        } while (result.get(Calendar.DAY_OF_WEEK) != 2);
        return result;
    }
     /**
      * getHolidays 說明：取得假日天數<br>
      * @param d1
      * @param d2
      * @return int
      * @author jimmy Lin
      */
    public static int getHolidays(Calendar d1, Calendar d2) {
        return getDaysBetween(d1, d2) - getWorkingDay(d1, d2);
    }
    
     /**
      * getRocAfter 說明：取得N個工作天後的日期<br>
      * @param date_start 起始日期
      * @param nDay N工作天
      * @return RocDate
      * @author jimmy Lin
      */
    public static RocDate getAfterWorkRocDay(Date date_start , int nDay){
        Date date_end = getDateAfter(date_start, nDay);
        Calendar cal_start = Calendar.getInstance();
        Calendar cal_end = Calendar.getInstance();
        cal_start.setTime(date_start);
        cal_end.setTime(date_end);
        int day = 1;
        day = getHolidays(cal_start,cal_end);
        while(day != 0){
	    	date_start.setTime(date_end.getTime());
	    	date_end.setTime(getDateAfter(date_end, day).getTime());
	        cal_start.setTime(date_start);
	        cal_end.setTime(date_end);
	    	day = getHolidays(cal_start,cal_end);
        }
        return new RocDate(date_end.getTime());
    }

	 /**
	  * getCSDPICM 說明：查詢附件檔單筆資料<br>
	  * @param dataObject
	  * @return DataObject
	  * @throws XdaoException
	  * @author jimmy Lin
	  */
	public DataObject getCSDPICM(DataObject dataObject) throws XdaoException {
		DataList list = csdpicmModel.getDataListByPKFields(dataObject);
		if(list.size() >= 1){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	
	static String[] custCd = {"基隆","高雄","台北","台中"};
	
	 /**
	  * checkOldNewText 說明：檢查日期輸出新舊制對應文字<br>
	  * type = 1.判斷函稿關務長、局長文字
	  *        2.判斷函稿副關務長、副局長文字
	  *        3.判斷函稿標題財政部　台北關、財政部　台北　關稅局文字
	  *        4.判斷函稿標題台北關、台北關稅局文字
	  *        5.判斷函稿稅則法制組、稅則處
	  *        6.判斷函稿稅則法制組組長、稅則處處長
	  *        7.判斷函稿組、處
	  *        8.判斷CD207報表title
	  *          狀態<20，XX關稅則分類整合意見簽註用箋
	  *          狀態>20, XX關稅則分類疑問及解答簽註用箋
	  * 
	  * @param type
	  * @param date
	  * @param checkText
	  * @return
	  * @author jimmy Lin
	  */
	@SuppressWarnings("deprecation")
	static public String checkOldNewText(String type , Date date , String checkText){
		System.out.println(type + " " + date + " " + checkText);
		String returnText = "";
		Date checkDate = new Date(113,0,1);//2013.1.1 新制起始日期
		if(date == null)
			date = new Date();
		if("1".equals(type)){
			if(date.compareTo(checkDate) > 0)
				returnText = "關務長";
			else
				returnText = "局長";
		}else if("2".equals(type)){
			if(date.compareTo(checkDate) > 0)
				returnText = "副關務長";
			else
				returnText = "副局長";
		}else if("3".equals(type)){
			if("".equals(checkText))
				return "";
			if(date.compareTo(checkDate) > 0){
				returnText = "財政部　" + custCd[checkText.charAt(0)-65] + "關";
			}else{
				returnText = "財政部　" + custCd[checkText.charAt(0)-65] + "　關稅局";
			}
		}else if("4".equals(type)){
			if("".equals(checkText))
				return "";
			if(date.compareTo(checkDate) > 0){
				returnText = custCd[checkText.charAt(0)-65] + "關";
			}else{
				returnText = custCd[checkText.charAt(0)-65] + "關稅局";
			}
		}else if("5".equals(type)){
			if(date.compareTo(checkDate) > 0)
				returnText = "稅則法制組";
			else
				returnText = "稅則處";
		}else if("6".equals(type)){
			if(date.compareTo(checkDate) > 0)
				returnText = "稅則法制組組長";
			else
				returnText = "稅則處處長";
		}else if("7".equals(type)){
			if(date.compareTo(checkDate) > 0)
				returnText = "組";
			else
				returnText = "處";
		}else if("8".equals(type)){
			String check1 = checkText.split(",")[0];
			String check2 = checkText.split(",")[1];
			String custCdText;
			if(date.compareTo(checkDate) > 0){
				custCdText = custCd[check1.charAt(0)-65] + "關";
			}else{
				custCdText = custCd[check1.charAt(0)-65] + "關稅局";
			}
			if(Integer.parseInt(check2)<20)
				returnText = custCdText + "稅則分類整合意見簽註用箋";
			else
				returnText = custCdText + "進口貨物稅則分類疑問及解答簽註用箋";
		}
		return returnText;
	}
	
	/**
	 * 把DataObject傳入，若DataObject無值。
	 * 則直接顯示訊息。
	 * @param dataObject
	 * @return
	 */
	public boolean isEmpty(DataObject dataObject){
		int count = new GameUtil().getNotEmptyMap(dataObject).size();
		return count == 0 ;
	}
    
   /*    
   //=====TESTER=====
   public static void main(String[] args) throws ParseException{
    	String strDateStart = "2012-12-10";
        String strDateEnd = "2012-12-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date_start = sdf.parse(strDateStart);
        Date date_end = sdf.parse(strDateEnd);
        Calendar cal_start = Calendar.getInstance();
        Calendar cal_end = Calendar.getInstance();
        cal_start.setTime(date_start);
        cal_end.setTime(date_end);
        int day = 1;
        day = getHolidays(cal_start,cal_end);
    	System.out.println(day);
        while(day != 0){
	    	date_start.setTime(date_end.getTime());
	    	date_end.setTime(getDateAfter(date_end, day).getTime());
	        cal_start.setTime(date_start);
	        cal_end.setTime(date_end);
	    	day = getHolidays(cal_start,cal_end);
	    	System.out.println(day);
	    	System.out.println(date_end);
        }
    }*/
	
	/**
	 * DefaultService取得的UserData，另外建立UserBean並可以調整資訊。
	 * @return
	 */
	public UserData getUserBean(){
		UserData userBean = getUserData();
		return userBean;
	}
	
	/**
	 * 取得custCdSafty
	 * @return
	 */
	public String getCustCdSafty(){
		String custCd = getUserBean().getCustCd();
		String custCdNew = custCd==null||custCd.isEmpty()?"A":custCd;
		if(custCdNew.equals(custCd)){
		}else{
			logger.debug("CDService.getCustCdSafty.1120|[CHANGE]custCd="+custCd+",custCdNew="+custCdNew);
		}
		if(custCdNew.contains("*")){	
			String custCdOld = custCdNew;
			custCdNew = custCdNew.replace("*", "A");
			logger.debug("CDService.getCustCdSafty.1120|[CHANGE]custCdOld="+custCdOld+",custCdNew="+custCdNew);
		}
		return custCdNew;
	}
	
	/**
	 * 取得custCdSafty
	 * @return
	 */
	public String getCustCdSaftyBy1(){
		String custCdString = getCustCdSafty();
		if(custCdString==null||custCdString.isEmpty()){
			
		}else{
			custCdString = custCdString.substring(0, 1);
		}
		return custCdString;
	}
	
	/**
	 * 把ProcessResult串接起來
	 * Status透過 AND 邏輯串接起來，若是發生false則會全盤已false回應。
	 * Message 字串 會完全串接起來
	 * Error 字串 會完全串接起來
	 * @param result
	 * @return
	 */
	public ProcessResult sumProcessResult(ProcessResult... result){
		ProcessResult sumResult = new ProcessResult();
		int count = 0;
		List<String> msgList = new ArrayList<String>();
		for(ProcessResult results : result){
			count += results.getStatus()+1;
			msgList.addAll(results.getMessages());
			msgList.addAll(results.getErrors());
		}
		sumResult.setStatus(count%2);
		sumResult.setMessages(msgList);
		sumResult.setErrors(msgList);
		return sumResult;
	}
}
