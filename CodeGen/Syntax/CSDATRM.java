public class CSDATRM{

	DataObject dto //該Bean的固定命名

	private String tfCustomSerialNo;//1:收文編號
	private String tfFlag;//2:特殊註記(徹案)
	private String ban;//3:統一編號
	private String cccCode;//4:商品標準分類號列
	private RocDate tfIssueDate;//5:發文日期
	private String tfIssueDocuNo;//6:發文文號
	private String tfEnglishCommodity;//7:貨品名稱型號規格
	private String tfMBNation;//8:製造廠商廠牌生產國別
	private String tfFactorMaterial;//9:材質成分
	private String tfReproduceSummary;//10:加工製程概述
	private String tfFunction;//11:用途
	private String tfPackWay;//12:包裝方式
	private String tfOtherExplain;//13:其他說明
	private String tfHsEReason;//14:稅則分類理由
	private String tfRemark;//15:備註
	private RocDate tfReceiveDate;//16:受理日期
	private String tfPerson;//17:承辦人代碼
	private String tfHsEReason0;//18:分類理由_總局
	private String tfHsEReasonA;//19:分類理由_基隆關
	private String tfHsEReasonB;//20:分類理由_高雄關
	private String tfHsEReasonC;//21:分類理由_台北關
	private String tfHsEReasonD;//22:分類理由_台中關
	private RocDate tf0dt;//23:分類理由異動日期_總局
	private RocDate tfAdt;//24:分類理由異動日期_基隆關
	private RocDate tfBdt;//25:分類理由異動日期_高雄關
	private RocDate tfCdt;//26:分類理由異動日期_台北關
	private RocDate tfDdt;//27:分類理由異動日期_台中關
	private String tf0id;//28:分類理由職員編號_總局
	private String tfAid;//29:分類理由職員編號_基隆關
	private String tfBid;//30:分類理由職員編號_高雄關
	private String tfCid;//31:分類理由職員編號_台北關
	private String tfDid;//32:分類理由職員編號_台中關
	private String tfAimport;//33:進口紀錄_基隆關
	private String tfBimport;//34:進口紀錄_高雄關
	private String tfCimport;//35:進口紀錄_台北關
	private String tfDimport;//36:進口紀錄_台中關
	private String bcUser0;//37:承辦人員_總局
	private String bcUserA;//38:承辦人員_基隆
	private String bcUserB;//39:承辦人員_高雄
	private String bcUserC;//40:承辦人員_台北
	private String bcUserD;//41:承辦人員_台中
	private String tfSendmark;//42:傳送註記
	private RocDate tfSendDate;//43:傳送註記日期
	private String tfStatus;//44:案件處理流程代碼
	private String upPerson;//45:異動人員
	private RocDate upDate;//46:異動時間
	private String tfReasonMark0;//47:分類理由完成註記_總局
	private String tfReasonMarkA;//48:分類理由完成註記_基隆關
	private String tfReasonMarkB;//49:分類理由完成註記_高雄關
	private String tfReasonMarkC;//50:分類理由完成註記_台北關
	private String tfReasonMarkD;//51:分類理由完成註記_台中關
	private RocDate tfRenewDate;//52:補件日期
	private String tfHsEMark;//53:稅則分類理由_完成註記
	private String tfAppName;//54:申請廠商名稱
	private String tfAppTel;//55:申請廠商電話
	private String tfAppAddress;//56:申請廠商地址

	public CSDATRM(){

	}


	public void getValue(){

		DataObject dto = new DataObject()
		dto.getValue("TF_CUSTOM_SERIAL_NO");//1:收文編號
		dto.getValue("TF_FLAG");//2:特殊註記(徹案)
		dto.getValue("BAN");//3:統一編號
		dto.getValue("CCC_CODE");//4:商品標準分類號列
		dto.getValue("TF_ISSUE_DATE");//5:發文日期
		dto.getValue("TF_ISSUE_DOCU_NO");//6:發文文號
		dto.getValue("TF_ENGLISH_COMMODITY");//7:貨品名稱型號規格
		dto.getValue("TF_M_B_NATION");//8:製造廠商廠牌生產國別
		dto.getValue("TF_FACTOR_MATERIAL");//9:材質成分
		dto.getValue("TF_REPRODUCE_SUMMARY");//10:加工製程概述
		dto.getValue("TF_FUNCTION");//11:用途
		dto.getValue("TF_PACK_WAY");//12:包裝方式
		dto.getValue("TF_OTHER_EXPLAIN");//13:其他說明
		dto.getValue("TF_HS_E_REASON");//14:稅則分類理由
		dto.getValue("TF_REMARK");//15:備註
		dto.getValue("TF_RECEIVE_DATE");//16:受理日期
		dto.getValue("TF_PERSON");//17:承辦人代碼
		dto.getValue("TF_HS_E_REASON_0");//18:分類理由_總局
		dto.getValue("TF_HS_E_REASON_A");//19:分類理由_基隆關
		dto.getValue("TF_HS_E_REASON_B");//20:分類理由_高雄關
		dto.getValue("TF_HS_E_REASON_C");//21:分類理由_台北關
		dto.getValue("TF_HS_E_REASON_D");//22:分類理由_台中關
		dto.getValue("TF_0DT");//23:分類理由異動日期_總局
		dto.getValue("TF_ADT");//24:分類理由異動日期_基隆關
		dto.getValue("TF_BDT");//25:分類理由異動日期_高雄關
		dto.getValue("TF_CDT");//26:分類理由異動日期_台北關
		dto.getValue("TF_DDT");//27:分類理由異動日期_台中關
		dto.getValue("TF_0ID");//28:分類理由職員編號_總局
		dto.getValue("TF_AID");//29:分類理由職員編號_基隆關
		dto.getValue("TF_BID");//30:分類理由職員編號_高雄關
		dto.getValue("TF_CID");//31:分類理由職員編號_台北關
		dto.getValue("TF_DID");//32:分類理由職員編號_台中關
		dto.getValue("TF_AIMPORT");//33:進口紀錄_基隆關
		dto.getValue("TF_BIMPORT");//34:進口紀錄_高雄關
		dto.getValue("TF_CIMPORT");//35:進口紀錄_台北關
		dto.getValue("TF_DIMPORT");//36:進口紀錄_台中關
		dto.getValue("BC_USER_0");//37:承辦人員_總局
		dto.getValue("BC_USER_A");//38:承辦人員_基隆
		dto.getValue("BC_USER_B");//39:承辦人員_高雄
		dto.getValue("BC_USER_C");//40:承辦人員_台北
		dto.getValue("BC_USER_D");//41:承辦人員_台中
		dto.getValue("TF_SENDMARK");//42:傳送註記
		dto.getValue("TF_SEND_DATE");//43:傳送註記日期
		dto.getValue("TF_STATUS");//44:案件處理流程代碼
		dto.getValue("UP_PERSON");//45:異動人員
		dto.getValue("UP_DATE");//46:異動時間
		dto.getValue("TF_REASON_MARK_0");//47:分類理由完成註記_總局
		dto.getValue("TF_REASON_MARK_A");//48:分類理由完成註記_基隆關
		dto.getValue("TF_REASON_MARK_B");//49:分類理由完成註記_高雄關
		dto.getValue("TF_REASON_MARK_C");//50:分類理由完成註記_台北關
		dto.getValue("TF_REASON_MARK_D");//51:分類理由完成註記_台中關
		dto.getValue("TF_RENEW_DATE");//52:補件日期
		dto.getValue("TF_HS_E_MARK");//53:稅則分類理由_完成註記
		dto.getValue("TF_APP_NAME");//54:申請廠商名稱
		dto.getValue("TF_APP_TEL");//55:申請廠商電話
		dto.getValue("TF_APP_ADDRESS");//56:申請廠商地址

		return dto;
	}

	public void getDataObject(){

		DataObject dto = new DataObject()
		dto.setValue(this.getTfCustomSerialNo())
		dto.setValue(this.getTfFlag())
		dto.setValue(this.getBan())
		dto.setValue(this.getCccCode())
		dto.setValue(this.getTfIssueDate())
		dto.setValue(this.getTfIssueDocuNo())
		dto.setValue(this.getTfEnglishCommodity())
		dto.setValue(this.getTfMBNation())
		dto.setValue(this.getTfFactorMaterial())
		dto.setValue(this.getTfReproduceSummary())
		dto.setValue(this.getTfFunction())
		dto.setValue(this.getTfPackWay())
		dto.setValue(this.getTfOtherExplain())
		dto.setValue(this.getTfHsEReason())
		dto.setValue(this.getTfRemark())
		dto.setValue(this.getTfReceiveDate())
		dto.setValue(this.getTfPerson())
		dto.setValue(this.getTfHsEReason0())
		dto.setValue(this.getTfHsEReasonA())
		dto.setValue(this.getTfHsEReasonB())
		dto.setValue(this.getTfHsEReasonC())
		dto.setValue(this.getTfHsEReasonD())
		dto.setValue(this.getTf0dt())
		dto.setValue(this.getTfAdt())
		dto.setValue(this.getTfBdt())
		dto.setValue(this.getTfCdt())
		dto.setValue(this.getTfDdt())
		dto.setValue(this.getTf0id())
		dto.setValue(this.getTfAid())
		dto.setValue(this.getTfBid())
		dto.setValue(this.getTfCid())
		dto.setValue(this.getTfDid())
		dto.setValue(this.getTfAimport())
		dto.setValue(this.getTfBimport())
		dto.setValue(this.getTfCimport())
		dto.setValue(this.getTfDimport())
		dto.setValue(this.getBcUser0())
		dto.setValue(this.getBcUserA())
		dto.setValue(this.getBcUserB())
		dto.setValue(this.getBcUserC())
		dto.setValue(this.getBcUserD())
		dto.setValue(this.getTfSendmark())
		dto.setValue(this.getTfSendDate())
		dto.setValue(this.getTfStatus())
		dto.setValue(this.getUpPerson())
		dto.setValue(this.getUpDate())
		dto.setValue(this.getTfReasonMark0())
		dto.setValue(this.getTfReasonMarkA())
		dto.setValue(this.getTfReasonMarkB())
		dto.setValue(this.getTfReasonMarkC())
		dto.setValue(this.getTfReasonMarkD())
		dto.setValue(this.getTfRenewDate())
		dto.setValue(this.getTfHsEMark())
		dto.setValue(this.getTfAppName())
		dto.setValue(this.getTfAppTel())
		dto.setValue(this.getTfAppAddress())

		return dto;
	}

	public void setValue(DataObject dto){

		dto.setValue("TF_CUSTOM_SERIAL_NO", this.getTfCustomSerialNo());//1:收文編號
		dto.setValue("TF_FLAG", this.getTfFlag());//2:特殊註記(徹案)
		dto.setValue("BAN", this.getBan());//3:統一編號
		dto.setValue("CCC_CODE", this.getCccCode());//4:商品標準分類號列
		dto.setValue("TF_ISSUE_DATE", this.getTfIssueDate());//5:發文日期
		dto.setValue("TF_ISSUE_DOCU_NO", this.getTfIssueDocuNo());//6:發文文號
		dto.setValue("TF_ENGLISH_COMMODITY", this.getTfEnglishCommodity());//7:貨品名稱型號規格
		dto.setValue("TF_M_B_NATION", this.getTfMBNation());//8:製造廠商廠牌生產國別
		dto.setValue("TF_FACTOR_MATERIAL", this.getTfFactorMaterial());//9:材質成分
		dto.setValue("TF_REPRODUCE_SUMMARY", this.getTfReproduceSummary());//10:加工製程概述
		dto.setValue("TF_FUNCTION", this.getTfFunction());//11:用途
		dto.setValue("TF_PACK_WAY", this.getTfPackWay());//12:包裝方式
		dto.setValue("TF_OTHER_EXPLAIN", this.getTfOtherExplain());//13:其他說明
		dto.setValue("TF_HS_E_REASON", this.getTfHsEReason());//14:稅則分類理由
		dto.setValue("TF_REMARK", this.getTfRemark());//15:備註
		dto.setValue("TF_RECEIVE_DATE", this.getTfReceiveDate());//16:受理日期
		dto.setValue("TF_PERSON", this.getTfPerson());//17:承辦人代碼
		dto.setValue("TF_HS_E_REASON_0", this.getTfHsEReason0());//18:分類理由_總局
		dto.setValue("TF_HS_E_REASON_A", this.getTfHsEReasonA());//19:分類理由_基隆關
		dto.setValue("TF_HS_E_REASON_B", this.getTfHsEReasonB());//20:分類理由_高雄關
		dto.setValue("TF_HS_E_REASON_C", this.getTfHsEReasonC());//21:分類理由_台北關
		dto.setValue("TF_HS_E_REASON_D", this.getTfHsEReasonD());//22:分類理由_台中關
		dto.setValue("TF_0DT", this.getTf0dt());//23:分類理由異動日期_總局
		dto.setValue("TF_ADT", this.getTfAdt());//24:分類理由異動日期_基隆關
		dto.setValue("TF_BDT", this.getTfBdt());//25:分類理由異動日期_高雄關
		dto.setValue("TF_CDT", this.getTfCdt());//26:分類理由異動日期_台北關
		dto.setValue("TF_DDT", this.getTfDdt());//27:分類理由異動日期_台中關
		dto.setValue("TF_0ID", this.getTf0id());//28:分類理由職員編號_總局
		dto.setValue("TF_AID", this.getTfAid());//29:分類理由職員編號_基隆關
		dto.setValue("TF_BID", this.getTfBid());//30:分類理由職員編號_高雄關
		dto.setValue("TF_CID", this.getTfCid());//31:分類理由職員編號_台北關
		dto.setValue("TF_DID", this.getTfDid());//32:分類理由職員編號_台中關
		dto.setValue("TF_AIMPORT", this.getTfAimport());//33:進口紀錄_基隆關
		dto.setValue("TF_BIMPORT", this.getTfBimport());//34:進口紀錄_高雄關
		dto.setValue("TF_CIMPORT", this.getTfCimport());//35:進口紀錄_台北關
		dto.setValue("TF_DIMPORT", this.getTfDimport());//36:進口紀錄_台中關
		dto.setValue("BC_USER_0", this.getBcUser0());//37:承辦人員_總局
		dto.setValue("BC_USER_A", this.getBcUserA());//38:承辦人員_基隆
		dto.setValue("BC_USER_B", this.getBcUserB());//39:承辦人員_高雄
		dto.setValue("BC_USER_C", this.getBcUserC());//40:承辦人員_台北
		dto.setValue("BC_USER_D", this.getBcUserD());//41:承辦人員_台中
		dto.setValue("TF_SENDMARK", this.getTfSendmark());//42:傳送註記
		dto.setValue("TF_SEND_DATE", this.getTfSendDate());//43:傳送註記日期
		dto.setValue("TF_STATUS", this.getTfStatus());//44:案件處理流程代碼
		dto.setValue("UP_PERSON", this.getUpPerson());//45:異動人員
		dto.setValue("UP_DATE", this.getUpDate());//46:異動時間
		dto.setValue("TF_REASON_MARK_0", this.getTfReasonMark0());//47:分類理由完成註記_總局
		dto.setValue("TF_REASON_MARK_A", this.getTfReasonMarkA());//48:分類理由完成註記_基隆關
		dto.setValue("TF_REASON_MARK_B", this.getTfReasonMarkB());//49:分類理由完成註記_高雄關
		dto.setValue("TF_REASON_MARK_C", this.getTfReasonMarkC());//50:分類理由完成註記_台北關
		dto.setValue("TF_REASON_MARK_D", this.getTfReasonMarkD());//51:分類理由完成註記_台中關
		dto.setValue("TF_RENEW_DATE", this.getTfRenewDate());//52:補件日期
		dto.setValue("TF_HS_E_MARK", this.getTfHsEMark());//53:稅則分類理由_完成註記
		dto.setValue("TF_APP_NAME", this.getTfAppName());//54:申請廠商名稱
		dto.setValue("TF_APP_TEL", this.getTfAppTel());//55:申請廠商電話
		dto.setValue("TF_APP_ADDRESS", this.getTfAppAddress());//56:申請廠商地址


	}
	public Map<String, Object> getMap(){
		Map<String, Object> ansMap = new TreeMap<String, Object>();
		ansMap.put("TF_CUSTOM_SERIAL_NO", this.getTfCustomSerialNo());
		ansMap.put("TF_FLAG", this.getTfFlag());
		ansMap.put("BAN", this.getBan());
		ansMap.put("CCC_CODE", this.getCccCode());
		ansMap.put("TF_ISSUE_DATE", this.getTfIssueDate());
		ansMap.put("TF_ISSUE_DOCU_NO", this.getTfIssueDocuNo());
		ansMap.put("TF_ENGLISH_COMMODITY", this.getTfEnglishCommodity());
		ansMap.put("TF_M_B_NATION", this.getTfMBNation());
		ansMap.put("TF_FACTOR_MATERIAL", this.getTfFactorMaterial());
		ansMap.put("TF_REPRODUCE_SUMMARY", this.getTfReproduceSummary());
		ansMap.put("TF_FUNCTION", this.getTfFunction());
		ansMap.put("TF_PACK_WAY", this.getTfPackWay());
		ansMap.put("TF_OTHER_EXPLAIN", this.getTfOtherExplain());
		ansMap.put("TF_HS_E_REASON", this.getTfHsEReason());
		ansMap.put("TF_REMARK", this.getTfRemark());
		ansMap.put("TF_RECEIVE_DATE", this.getTfReceiveDate());
		ansMap.put("TF_PERSON", this.getTfPerson());
		ansMap.put("TF_HS_E_REASON_0", this.getTfHsEReason0());
		ansMap.put("TF_HS_E_REASON_A", this.getTfHsEReasonA());
		ansMap.put("TF_HS_E_REASON_B", this.getTfHsEReasonB());
		ansMap.put("TF_HS_E_REASON_C", this.getTfHsEReasonC());
		ansMap.put("TF_HS_E_REASON_D", this.getTfHsEReasonD());
		ansMap.put("TF_0DT", this.getTf0dt());
		ansMap.put("TF_ADT", this.getTfAdt());
		ansMap.put("TF_BDT", this.getTfBdt());
		ansMap.put("TF_CDT", this.getTfCdt());
		ansMap.put("TF_DDT", this.getTfDdt());
		ansMap.put("TF_0ID", this.getTf0id());
		ansMap.put("TF_AID", this.getTfAid());
		ansMap.put("TF_BID", this.getTfBid());
		ansMap.put("TF_CID", this.getTfCid());
		ansMap.put("TF_DID", this.getTfDid());
		ansMap.put("TF_AIMPORT", this.getTfAimport());
		ansMap.put("TF_BIMPORT", this.getTfBimport());
		ansMap.put("TF_CIMPORT", this.getTfCimport());
		ansMap.put("TF_DIMPORT", this.getTfDimport());
		ansMap.put("BC_USER_0", this.getBcUser0());
		ansMap.put("BC_USER_A", this.getBcUserA());
		ansMap.put("BC_USER_B", this.getBcUserB());
		ansMap.put("BC_USER_C", this.getBcUserC());
		ansMap.put("BC_USER_D", this.getBcUserD());
		ansMap.put("TF_SENDMARK", this.getTfSendmark());
		ansMap.put("TF_SEND_DATE", this.getTfSendDate());
		ansMap.put("TF_STATUS", this.getTfStatus());
		ansMap.put("UP_PERSON", this.getUpPerson());
		ansMap.put("UP_DATE", this.getUpDate());
		ansMap.put("TF_REASON_MARK_0", this.getTfReasonMark0());
		ansMap.put("TF_REASON_MARK_A", this.getTfReasonMarkA());
		ansMap.put("TF_REASON_MARK_B", this.getTfReasonMarkB());
		ansMap.put("TF_REASON_MARK_C", this.getTfReasonMarkC());
		ansMap.put("TF_REASON_MARK_D", this.getTfReasonMarkD());
		ansMap.put("TF_RENEW_DATE", this.getTfRenewDate());
		ansMap.put("TF_HS_E_MARK", this.getTfHsEMark());
		ansMap.put("TF_APP_NAME", this.getTfAppName());
		ansMap.put("TF_APP_TEL", this.getTfAppTel());
		ansMap.put("TF_APP_ADDRESS", this.getTfAppAddress());
		return ansMap;
	}
	public String toString(){
		String ans = "";
		ans += "TF_CUSTOM_SERIAL_NO="+tfCustomSerialNothis.getTfCustomSerialNo()+"(收文編號),"//收文編號
		ans += "TF_FLAG="+tfFlagthis.getTfFlag()+"(特殊註記(徹案)),"//特殊註記(徹案)
		ans += "BAN="+banthis.getBan()+"(統一編號),"//統一編號
		ans += "CCC_CODE="+cccCodethis.getCccCode()+"(商品標準分類號列),"//商品標準分類號列
		ans += "TF_ISSUE_DATE="+tfIssueDatethis.getTfIssueDate()+"(發文日期),"//發文日期
		ans += "TF_ISSUE_DOCU_NO="+tfIssueDocuNothis.getTfIssueDocuNo()+"(發文文號),"//發文文號
		ans += "TF_ENGLISH_COMMODITY="+tfEnglishCommoditythis.getTfEnglishCommodity()+"(貨品名稱型號規格),"//貨品名稱型號規格
		ans += "TF_M_B_NATION="+tfMBNationthis.getTfMBNation()+"(製造廠商廠牌生產國別),"//製造廠商廠牌生產國別
		ans += "TF_FACTOR_MATERIAL="+tfFactorMaterialthis.getTfFactorMaterial()+"(材質成分),"//材質成分
		ans += "TF_REPRODUCE_SUMMARY="+tfReproduceSummarythis.getTfReproduceSummary()+"(加工製程概述),"//加工製程概述
		ans += "TF_FUNCTION="+tfFunctionthis.getTfFunction()+"(用途),"//用途
		ans += "TF_PACK_WAY="+tfPackWaythis.getTfPackWay()+"(包裝方式),"//包裝方式
		ans += "TF_OTHER_EXPLAIN="+tfOtherExplainthis.getTfOtherExplain()+"(其他說明),"//其他說明
		ans += "TF_HS_E_REASON="+tfHsEReasonthis.getTfHsEReason()+"(稅則分類理由),"//稅則分類理由
		ans += "TF_REMARK="+tfRemarkthis.getTfRemark()+"(備註),"//備註
		ans += "TF_RECEIVE_DATE="+tfReceiveDatethis.getTfReceiveDate()+"(受理日期),"//受理日期
		ans += "TF_PERSON="+tfPersonthis.getTfPerson()+"(承辦人代碼),"//承辦人代碼
		ans += "TF_HS_E_REASON_0="+tfHsEReason0this.getTfHsEReason0()+"(分類理由_總局),"//分類理由_總局
		ans += "TF_HS_E_REASON_A="+tfHsEReasonAthis.getTfHsEReasonA()+"(分類理由_基隆關),"//分類理由_基隆關
		ans += "TF_HS_E_REASON_B="+tfHsEReasonBthis.getTfHsEReasonB()+"(分類理由_高雄關),"//分類理由_高雄關
		ans += "TF_HS_E_REASON_C="+tfHsEReasonCthis.getTfHsEReasonC()+"(分類理由_台北關),"//分類理由_台北關
		ans += "TF_HS_E_REASON_D="+tfHsEReasonDthis.getTfHsEReasonD()+"(分類理由_台中關),"//分類理由_台中關
		ans += "TF_0DT="+tf0dtthis.getTf0dt()+"(分類理由異動日期_總局),"//分類理由異動日期_總局
		ans += "TF_ADT="+tfAdtthis.getTfAdt()+"(分類理由異動日期_基隆關),"//分類理由異動日期_基隆關
		ans += "TF_BDT="+tfBdtthis.getTfBdt()+"(分類理由異動日期_高雄關),"//分類理由異動日期_高雄關
		ans += "TF_CDT="+tfCdtthis.getTfCdt()+"(分類理由異動日期_台北關),"//分類理由異動日期_台北關
		ans += "TF_DDT="+tfDdtthis.getTfDdt()+"(分類理由異動日期_台中關),"//分類理由異動日期_台中關
		ans += "TF_0ID="+tf0idthis.getTf0id()+"(分類理由職員編號_總局),"//分類理由職員編號_總局
		ans += "TF_AID="+tfAidthis.getTfAid()+"(分類理由職員編號_基隆關),"//分類理由職員編號_基隆關
		ans += "TF_BID="+tfBidthis.getTfBid()+"(分類理由職員編號_高雄關),"//分類理由職員編號_高雄關
		ans += "TF_CID="+tfCidthis.getTfCid()+"(分類理由職員編號_台北關),"//分類理由職員編號_台北關
		ans += "TF_DID="+tfDidthis.getTfDid()+"(分類理由職員編號_台中關),"//分類理由職員編號_台中關
		ans += "TF_AIMPORT="+tfAimportthis.getTfAimport()+"(進口紀錄_基隆關),"//進口紀錄_基隆關
		ans += "TF_BIMPORT="+tfBimportthis.getTfBimport()+"(進口紀錄_高雄關),"//進口紀錄_高雄關
		ans += "TF_CIMPORT="+tfCimportthis.getTfCimport()+"(進口紀錄_台北關),"//進口紀錄_台北關
		ans += "TF_DIMPORT="+tfDimportthis.getTfDimport()+"(進口紀錄_台中關),"//進口紀錄_台中關
		ans += "BC_USER_0="+bcUser0this.getBcUser0()+"(承辦人員_總局),"//承辦人員_總局
		ans += "BC_USER_A="+bcUserAthis.getBcUserA()+"(承辦人員_基隆),"//承辦人員_基隆
		ans += "BC_USER_B="+bcUserBthis.getBcUserB()+"(承辦人員_高雄),"//承辦人員_高雄
		ans += "BC_USER_C="+bcUserCthis.getBcUserC()+"(承辦人員_台北),"//承辦人員_台北
		ans += "BC_USER_D="+bcUserDthis.getBcUserD()+"(承辦人員_台中),"//承辦人員_台中
		ans += "TF_SENDMARK="+tfSendmarkthis.getTfSendmark()+"(傳送註記),"//傳送註記
		ans += "TF_SEND_DATE="+tfSendDatethis.getTfSendDate()+"(傳送註記日期),"//傳送註記日期
		ans += "TF_STATUS="+tfStatusthis.getTfStatus()+"(案件處理流程代碼),"//案件處理流程代碼
		ans += "UP_PERSON="+upPersonthis.getUpPerson()+"(異動人員),"//異動人員
		ans += "UP_DATE="+upDatethis.getUpDate()+"(異動時間),"//異動時間
		ans += "TF_REASON_MARK_0="+tfReasonMark0this.getTfReasonMark0()+"(分類理由完成註記_總局),"//分類理由完成註記_總局
		ans += "TF_REASON_MARK_A="+tfReasonMarkAthis.getTfReasonMarkA()+"(分類理由完成註記_基隆關),"//分類理由完成註記_基隆關
		ans += "TF_REASON_MARK_B="+tfReasonMarkBthis.getTfReasonMarkB()+"(分類理由完成註記_高雄關),"//分類理由完成註記_高雄關
		ans += "TF_REASON_MARK_C="+tfReasonMarkCthis.getTfReasonMarkC()+"(分類理由完成註記_台北關),"//分類理由完成註記_台北關
		ans += "TF_REASON_MARK_D="+tfReasonMarkDthis.getTfReasonMarkD()+"(分類理由完成註記_台中關),"//分類理由完成註記_台中關
		ans += "TF_RENEW_DATE="+tfRenewDatethis.getTfRenewDate()+"(補件日期),"//補件日期
		ans += "TF_HS_E_MARK="+tfHsEMarkthis.getTfHsEMark()+"(稅則分類理由_完成註記),"//稅則分類理由_完成註記
		ans += "TF_APP_NAME="+tfAppNamethis.getTfAppName()+"(申請廠商名稱),"//申請廠商名稱
		ans += "TF_APP_TEL="+tfAppTelthis.getTfAppTel()+"(申請廠商電話),"//申請廠商電話
		ans += "TF_APP_ADDRESS="+tfAppAddressthis.getTfAppAddress()+"(申請廠商地址),"//申請廠商地址
		return ans;
	}
}

