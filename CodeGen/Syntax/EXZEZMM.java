public class EXZEZMM{

	DataObject dto //該Bean的固定命名

	private String transTypeCd;//1:訊息功能代碼
	private String mawb;//2:託運單主號
	private String hawb;//3:託運單分號
	private String declNo;//4:報單號碼
	private String declCustCd;//5:報單關別
	private BigDecimal seqNo;//6:序號
	private String declType;//7:報單類別
	private String brokerBoxNo;//8:業者箱號
	private String brokerSubBoxNo;//9:箱號附碼
	private String brokerEmp;//10:專責報關人員代號
	private String storWareCd;//11:卸存地點代碼
	private String exporterBan;//12:輸出人統一編號
	private String exporterEname;//13:輸出人英文名稱
	private String exporterCname;//14:輸出人中文名稱
	private String exporterEaddr;//15:輸出人英文地址
	private String exporterCaddr;//16:輸出人中文地址
	private String expressCarrierBan;//17:快遞業者統一編號
	private String expressCarrierEname;//18:快遞業者英文名稱
	private String expressCarrierCname;//19:快遞業者中文名稱
	private String onBoardCourierBan;//20:快遞專差統一編號
	private String onBoardCourierEname;//21:快遞專差英文名稱
	private String onBoardCourierCname;//22:快遞專差中文名稱
	private String consolidatedBagNo;//23:併袋號碼
	private BigDecimal totalHawb;//24:併袋筆數
	private RocDate declDate;//25:報關日期
	private String voyageFlightNo;//26:船舶航機班次
	private String salBan;//27:貨物輸出人統一編號
	private String salEname;//28:貨物輸出人英文名稱
	private String salCname;//29:貨物輸出人中文名稱
	private String salEaddr;//30:貨物輸出人英文地址
	private String salCaddr;//31:貨物輸出人中文地址
	private String destCd;//32:目的地代碼
	private BigDecimal totPackQty;//33:總件數
	private String packUnit;//34:件數單位
	private BigDecimal totGrossWeight;//35:總毛重
	private BigDecimal totTwdFob;//36:總離岸價格(新台幣)
	private String proType;//37:訊息功能代碼
	private String clearType;//38:通關方式
	private String examMark;//39:驗貨註記
	private String rlsNote;//40:放行註記
	private RocDate relDate;//41:放行日期時間
	private BigDecimal relPack;//42:放行件數
	private String examCounter;//43:驗貨檯號
	private String senderId;//44:傳送方代碼
	private String controlNumber;//45:交換控制碼
	private String transId;//46:訊息處理編號
	private RocDate dealDate;//47:訊息處理時間
	private String receiverId;//48:接收方代碼
	private RocDate recvFinishDate;//49:收單完成時間

	public EXZEZMM(){

	}


	public void getValue(){

		DataObject dto = new DataObject()
		dto.getValue("TRANS_TYPE_CD");//1:訊息功能代碼
		dto.getValue("MAWB");//2:託運單主號
		dto.getValue("HAWB");//3:託運單分號
		dto.getValue("DECL_NO");//4:報單號碼
		dto.getValue("DECL_CUST_CD");//5:報單關別
		dto.getValue("SEQ_NO");//6:序號
		dto.getValue("DECL_TYPE");//7:報單類別
		dto.getValue("BROKER_BOX_NO");//8:業者箱號
		dto.getValue("BROKER_SUB_BOX_NO");//9:箱號附碼
		dto.getValue("BROKER_EMP");//10:專責報關人員代號
		dto.getValue("STOR_WARE_CD");//11:卸存地點代碼
		dto.getValue("EXPORTER_BAN");//12:輸出人統一編號
		dto.getValue("EXPORTER_ENAME");//13:輸出人英文名稱
		dto.getValue("EXPORTER_CNAME");//14:輸出人中文名稱
		dto.getValue("EXPORTER_EADDR");//15:輸出人英文地址
		dto.getValue("EXPORTER_CADDR");//16:輸出人中文地址
		dto.getValue("EXPRESS_CARRIER_BAN");//17:快遞業者統一編號
		dto.getValue("EXPRESS_CARRIER_ENAME");//18:快遞業者英文名稱
		dto.getValue("EXPRESS_CARRIER_CNAME");//19:快遞業者中文名稱
		dto.getValue("ON_BOARD_COURIER_BAN");//20:快遞專差統一編號
		dto.getValue("ON_BOARD_COURIER_ENAME");//21:快遞專差英文名稱
		dto.getValue("ON_BOARD_COURIER_CNAME");//22:快遞專差中文名稱
		dto.getValue("CONSOLIDATED_BAG_NO");//23:併袋號碼
		dto.getValue("TOTAL_HAWB");//24:併袋筆數
		dto.getValue("DECL_DATE");//25:報關日期
		dto.getValue("VOYAGE_FLIGHT_NO");//26:船舶航機班次
		dto.getValue("SAL_BAN");//27:貨物輸出人統一編號
		dto.getValue("SAL_ENAME");//28:貨物輸出人英文名稱
		dto.getValue("SAL_CNAME");//29:貨物輸出人中文名稱
		dto.getValue("SAL_EADDR");//30:貨物輸出人英文地址
		dto.getValue("SAL_CADDR");//31:貨物輸出人中文地址
		dto.getValue("DEST_CD");//32:目的地代碼
		dto.getValue("TOT_PACK_QTY");//33:總件數
		dto.getValue("PACK_UNIT");//34:件數單位
		dto.getValue("TOT_GROSS_WEIGHT");//35:總毛重
		dto.getValue("TOT_TWD_FOB");//36:總離岸價格(新台幣)
		dto.getValue("PRO_TYPE");//37:訊息功能代碼
		dto.getValue("CLEAR_TYPE");//38:通關方式
		dto.getValue("EXAM_MARK");//39:驗貨註記
		dto.getValue("RLS_NOTE");//40:放行註記
		dto.getValue("REL_DATE");//41:放行日期時間
		dto.getValue("REL_PACK");//42:放行件數
		dto.getValue("EXAM_COUNTER");//43:驗貨檯號
		dto.getValue("SENDER_ID");//44:傳送方代碼
		dto.getValue("CONTROL_NUMBER");//45:交換控制碼
		dto.getValue("TRANS_ID");//46:訊息處理編號
		dto.getValue("DEAL_DATE");//47:訊息處理時間
		dto.getValue("RECEIVER_ID");//48:接收方代碼
		dto.getValue("RECV_FINISH_DATE");//49:收單完成時間

		return dto;
	}

	public void getDataObject(){

		DataObject dto = new DataObject()
		dto.setValue(this.getTransTypeCd())
		dto.setValue(this.getMawb())
		dto.setValue(this.getHawb())
		dto.setValue(this.getDeclNo())
		dto.setValue(this.getDeclCustCd())
		dto.setValue(this.getSeqNo())
		dto.setValue(this.getDeclType())
		dto.setValue(this.getBrokerBoxNo())
		dto.setValue(this.getBrokerSubBoxNo())
		dto.setValue(this.getBrokerEmp())
		dto.setValue(this.getStorWareCd())
		dto.setValue(this.getExporterBan())
		dto.setValue(this.getExporterEname())
		dto.setValue(this.getExporterCname())
		dto.setValue(this.getExporterEaddr())
		dto.setValue(this.getExporterCaddr())
		dto.setValue(this.getExpressCarrierBan())
		dto.setValue(this.getExpressCarrierEname())
		dto.setValue(this.getExpressCarrierCname())
		dto.setValue(this.getOnBoardCourierBan())
		dto.setValue(this.getOnBoardCourierEname())
		dto.setValue(this.getOnBoardCourierCname())
		dto.setValue(this.getConsolidatedBagNo())
		dto.setValue(this.getTotalHawb())
		dto.setValue(this.getDeclDate())
		dto.setValue(this.getVoyageFlightNo())
		dto.setValue(this.getSalBan())
		dto.setValue(this.getSalEname())
		dto.setValue(this.getSalCname())
		dto.setValue(this.getSalEaddr())
		dto.setValue(this.getSalCaddr())
		dto.setValue(this.getDestCd())
		dto.setValue(this.getTotPackQty())
		dto.setValue(this.getPackUnit())
		dto.setValue(this.getTotGrossWeight())
		dto.setValue(this.getTotTwdFob())
		dto.setValue(this.getProType())
		dto.setValue(this.getClearType())
		dto.setValue(this.getExamMark())
		dto.setValue(this.getRlsNote())
		dto.setValue(this.getRelDate())
		dto.setValue(this.getRelPack())
		dto.setValue(this.getExamCounter())
		dto.setValue(this.getSenderId())
		dto.setValue(this.getControlNumber())
		dto.setValue(this.getTransId())
		dto.setValue(this.getDealDate())
		dto.setValue(this.getReceiverId())
		dto.setValue(this.getRecvFinishDate())

		return dto;
	}

	public void setValue(DataObject dto){

		dto.setValue("TRANS_TYPE_CD", this.getTransTypeCd());//1:訊息功能代碼
		dto.setValue("MAWB", this.getMawb());//2:託運單主號
		dto.setValue("HAWB", this.getHawb());//3:託運單分號
		dto.setValue("DECL_NO", this.getDeclNo());//4:報單號碼
		dto.setValue("DECL_CUST_CD", this.getDeclCustCd());//5:報單關別
		dto.setValue("SEQ_NO", this.getSeqNo());//6:序號
		dto.setValue("DECL_TYPE", this.getDeclType());//7:報單類別
		dto.setValue("BROKER_BOX_NO", this.getBrokerBoxNo());//8:業者箱號
		dto.setValue("BROKER_SUB_BOX_NO", this.getBrokerSubBoxNo());//9:箱號附碼
		dto.setValue("BROKER_EMP", this.getBrokerEmp());//10:專責報關人員代號
		dto.setValue("STOR_WARE_CD", this.getStorWareCd());//11:卸存地點代碼
		dto.setValue("EXPORTER_BAN", this.getExporterBan());//12:輸出人統一編號
		dto.setValue("EXPORTER_ENAME", this.getExporterEname());//13:輸出人英文名稱
		dto.setValue("EXPORTER_CNAME", this.getExporterCname());//14:輸出人中文名稱
		dto.setValue("EXPORTER_EADDR", this.getExporterEaddr());//15:輸出人英文地址
		dto.setValue("EXPORTER_CADDR", this.getExporterCaddr());//16:輸出人中文地址
		dto.setValue("EXPRESS_CARRIER_BAN", this.getExpressCarrierBan());//17:快遞業者統一編號
		dto.setValue("EXPRESS_CARRIER_ENAME", this.getExpressCarrierEname());//18:快遞業者英文名稱
		dto.setValue("EXPRESS_CARRIER_CNAME", this.getExpressCarrierCname());//19:快遞業者中文名稱
		dto.setValue("ON_BOARD_COURIER_BAN", this.getOnBoardCourierBan());//20:快遞專差統一編號
		dto.setValue("ON_BOARD_COURIER_ENAME", this.getOnBoardCourierEname());//21:快遞專差英文名稱
		dto.setValue("ON_BOARD_COURIER_CNAME", this.getOnBoardCourierCname());//22:快遞專差中文名稱
		dto.setValue("CONSOLIDATED_BAG_NO", this.getConsolidatedBagNo());//23:併袋號碼
		dto.setValue("TOTAL_HAWB", this.getTotalHawb());//24:併袋筆數
		dto.setValue("DECL_DATE", this.getDeclDate());//25:報關日期
		dto.setValue("VOYAGE_FLIGHT_NO", this.getVoyageFlightNo());//26:船舶航機班次
		dto.setValue("SAL_BAN", this.getSalBan());//27:貨物輸出人統一編號
		dto.setValue("SAL_ENAME", this.getSalEname());//28:貨物輸出人英文名稱
		dto.setValue("SAL_CNAME", this.getSalCname());//29:貨物輸出人中文名稱
		dto.setValue("SAL_EADDR", this.getSalEaddr());//30:貨物輸出人英文地址
		dto.setValue("SAL_CADDR", this.getSalCaddr());//31:貨物輸出人中文地址
		dto.setValue("DEST_CD", this.getDestCd());//32:目的地代碼
		dto.setValue("TOT_PACK_QTY", this.getTotPackQty());//33:總件數
		dto.setValue("PACK_UNIT", this.getPackUnit());//34:件數單位
		dto.setValue("TOT_GROSS_WEIGHT", this.getTotGrossWeight());//35:總毛重
		dto.setValue("TOT_TWD_FOB", this.getTotTwdFob());//36:總離岸價格(新台幣)
		dto.setValue("PRO_TYPE", this.getProType());//37:訊息功能代碼
		dto.setValue("CLEAR_TYPE", this.getClearType());//38:通關方式
		dto.setValue("EXAM_MARK", this.getExamMark());//39:驗貨註記
		dto.setValue("RLS_NOTE", this.getRlsNote());//40:放行註記
		dto.setValue("REL_DATE", this.getRelDate());//41:放行日期時間
		dto.setValue("REL_PACK", this.getRelPack());//42:放行件數
		dto.setValue("EXAM_COUNTER", this.getExamCounter());//43:驗貨檯號
		dto.setValue("SENDER_ID", this.getSenderId());//44:傳送方代碼
		dto.setValue("CONTROL_NUMBER", this.getControlNumber());//45:交換控制碼
		dto.setValue("TRANS_ID", this.getTransId());//46:訊息處理編號
		dto.setValue("DEAL_DATE", this.getDealDate());//47:訊息處理時間
		dto.setValue("RECEIVER_ID", this.getReceiverId());//48:接收方代碼
		dto.setValue("RECV_FINISH_DATE", this.getRecvFinishDate());//49:收單完成時間


	}
	public Map<String, Object> getMap(){
		Map<String, Object> ansMap = new TreeMap<String, Object>();
		ansMap.put("TRANS_TYPE_CD", this.getTransTypeCd());
		ansMap.put("MAWB", this.getMawb());
		ansMap.put("HAWB", this.getHawb());
		ansMap.put("DECL_NO", this.getDeclNo());
		ansMap.put("DECL_CUST_CD", this.getDeclCustCd());
		ansMap.put("SEQ_NO", this.getSeqNo());
		ansMap.put("DECL_TYPE", this.getDeclType());
		ansMap.put("BROKER_BOX_NO", this.getBrokerBoxNo());
		ansMap.put("BROKER_SUB_BOX_NO", this.getBrokerSubBoxNo());
		ansMap.put("BROKER_EMP", this.getBrokerEmp());
		ansMap.put("STOR_WARE_CD", this.getStorWareCd());
		ansMap.put("EXPORTER_BAN", this.getExporterBan());
		ansMap.put("EXPORTER_ENAME", this.getExporterEname());
		ansMap.put("EXPORTER_CNAME", this.getExporterCname());
		ansMap.put("EXPORTER_EADDR", this.getExporterEaddr());
		ansMap.put("EXPORTER_CADDR", this.getExporterCaddr());
		ansMap.put("EXPRESS_CARRIER_BAN", this.getExpressCarrierBan());
		ansMap.put("EXPRESS_CARRIER_ENAME", this.getExpressCarrierEname());
		ansMap.put("EXPRESS_CARRIER_CNAME", this.getExpressCarrierCname());
		ansMap.put("ON_BOARD_COURIER_BAN", this.getOnBoardCourierBan());
		ansMap.put("ON_BOARD_COURIER_ENAME", this.getOnBoardCourierEname());
		ansMap.put("ON_BOARD_COURIER_CNAME", this.getOnBoardCourierCname());
		ansMap.put("CONSOLIDATED_BAG_NO", this.getConsolidatedBagNo());
		ansMap.put("TOTAL_HAWB", this.getTotalHawb());
		ansMap.put("DECL_DATE", this.getDeclDate());
		ansMap.put("VOYAGE_FLIGHT_NO", this.getVoyageFlightNo());
		ansMap.put("SAL_BAN", this.getSalBan());
		ansMap.put("SAL_ENAME", this.getSalEname());
		ansMap.put("SAL_CNAME", this.getSalCname());
		ansMap.put("SAL_EADDR", this.getSalEaddr());
		ansMap.put("SAL_CADDR", this.getSalCaddr());
		ansMap.put("DEST_CD", this.getDestCd());
		ansMap.put("TOT_PACK_QTY", this.getTotPackQty());
		ansMap.put("PACK_UNIT", this.getPackUnit());
		ansMap.put("TOT_GROSS_WEIGHT", this.getTotGrossWeight());
		ansMap.put("TOT_TWD_FOB", this.getTotTwdFob());
		ansMap.put("PRO_TYPE", this.getProType());
		ansMap.put("CLEAR_TYPE", this.getClearType());
		ansMap.put("EXAM_MARK", this.getExamMark());
		ansMap.put("RLS_NOTE", this.getRlsNote());
		ansMap.put("REL_DATE", this.getRelDate());
		ansMap.put("REL_PACK", this.getRelPack());
		ansMap.put("EXAM_COUNTER", this.getExamCounter());
		ansMap.put("SENDER_ID", this.getSenderId());
		ansMap.put("CONTROL_NUMBER", this.getControlNumber());
		ansMap.put("TRANS_ID", this.getTransId());
		ansMap.put("DEAL_DATE", this.getDealDate());
		ansMap.put("RECEIVER_ID", this.getReceiverId());
		ansMap.put("RECV_FINISH_DATE", this.getRecvFinishDate());
		return ansMap;
	}
	public String toString(){
		String ans = "";
		ans += "TRANS_TYPE_CD="+transTypeCdthis.getTransTypeCd()+"(訊息功能代碼),"//訊息功能代碼
		ans += "MAWB="+mawbthis.getMawb()+"(託運單主號),"//託運單主號
		ans += "HAWB="+hawbthis.getHawb()+"(託運單分號),"//託運單分號
		ans += "DECL_NO="+declNothis.getDeclNo()+"(報單號碼),"//報單號碼
		ans += "DECL_CUST_CD="+declCustCdthis.getDeclCustCd()+"(報單關別),"//報單關別
		ans += "SEQ_NO="+seqNothis.getSeqNo()+"(序號),"//序號
		ans += "DECL_TYPE="+declTypethis.getDeclType()+"(報單類別),"//報單類別
		ans += "BROKER_BOX_NO="+brokerBoxNothis.getBrokerBoxNo()+"(業者箱號),"//業者箱號
		ans += "BROKER_SUB_BOX_NO="+brokerSubBoxNothis.getBrokerSubBoxNo()+"(箱號附碼),"//箱號附碼
		ans += "BROKER_EMP="+brokerEmpthis.getBrokerEmp()+"(專責報關人員代號),"//專責報關人員代號
		ans += "STOR_WARE_CD="+storWareCdthis.getStorWareCd()+"(卸存地點代碼),"//卸存地點代碼
		ans += "EXPORTER_BAN="+exporterBanthis.getExporterBan()+"(輸出人統一編號),"//輸出人統一編號
		ans += "EXPORTER_ENAME="+exporterEnamethis.getExporterEname()+"(輸出人英文名稱),"//輸出人英文名稱
		ans += "EXPORTER_CNAME="+exporterCnamethis.getExporterCname()+"(輸出人中文名稱),"//輸出人中文名稱
		ans += "EXPORTER_EADDR="+exporterEaddrthis.getExporterEaddr()+"(輸出人英文地址),"//輸出人英文地址
		ans += "EXPORTER_CADDR="+exporterCaddrthis.getExporterCaddr()+"(輸出人中文地址),"//輸出人中文地址
		ans += "EXPRESS_CARRIER_BAN="+expressCarrierBanthis.getExpressCarrierBan()+"(快遞業者統一編號),"//快遞業者統一編號
		ans += "EXPRESS_CARRIER_ENAME="+expressCarrierEnamethis.getExpressCarrierEname()+"(快遞業者英文名稱),"//快遞業者英文名稱
		ans += "EXPRESS_CARRIER_CNAME="+expressCarrierCnamethis.getExpressCarrierCname()+"(快遞業者中文名稱),"//快遞業者中文名稱
		ans += "ON_BOARD_COURIER_BAN="+onBoardCourierBanthis.getOnBoardCourierBan()+"(快遞專差統一編號),"//快遞專差統一編號
		ans += "ON_BOARD_COURIER_ENAME="+onBoardCourierEnamethis.getOnBoardCourierEname()+"(快遞專差英文名稱),"//快遞專差英文名稱
		ans += "ON_BOARD_COURIER_CNAME="+onBoardCourierCnamethis.getOnBoardCourierCname()+"(快遞專差中文名稱),"//快遞專差中文名稱
		ans += "CONSOLIDATED_BAG_NO="+consolidatedBagNothis.getConsolidatedBagNo()+"(併袋號碼),"//併袋號碼
		ans += "TOTAL_HAWB="+totalHawbthis.getTotalHawb()+"(併袋筆數),"//併袋筆數
		ans += "DECL_DATE="+declDatethis.getDeclDate()+"(報關日期),"//報關日期
		ans += "VOYAGE_FLIGHT_NO="+voyageFlightNothis.getVoyageFlightNo()+"(船舶航機班次),"//船舶航機班次
		ans += "SAL_BAN="+salBanthis.getSalBan()+"(貨物輸出人統一編號),"//貨物輸出人統一編號
		ans += "SAL_ENAME="+salEnamethis.getSalEname()+"(貨物輸出人英文名稱),"//貨物輸出人英文名稱
		ans += "SAL_CNAME="+salCnamethis.getSalCname()+"(貨物輸出人中文名稱),"//貨物輸出人中文名稱
		ans += "SAL_EADDR="+salEaddrthis.getSalEaddr()+"(貨物輸出人英文地址),"//貨物輸出人英文地址
		ans += "SAL_CADDR="+salCaddrthis.getSalCaddr()+"(貨物輸出人中文地址),"//貨物輸出人中文地址
		ans += "DEST_CD="+destCdthis.getDestCd()+"(目的地代碼),"//目的地代碼
		ans += "TOT_PACK_QTY="+totPackQtythis.getTotPackQty()+"(總件數),"//總件數
		ans += "PACK_UNIT="+packUnitthis.getPackUnit()+"(件數單位),"//件數單位
		ans += "TOT_GROSS_WEIGHT="+totGrossWeightthis.getTotGrossWeight()+"(總毛重),"//總毛重
		ans += "TOT_TWD_FOB="+totTwdFobthis.getTotTwdFob()+"(總離岸價格(新台幣)),"//總離岸價格(新台幣)
		ans += "PRO_TYPE="+proTypethis.getProType()+"(訊息功能代碼),"//訊息功能代碼
		ans += "CLEAR_TYPE="+clearTypethis.getClearType()+"(通關方式),"//通關方式
		ans += "EXAM_MARK="+examMarkthis.getExamMark()+"(驗貨註記),"//驗貨註記
		ans += "RLS_NOTE="+rlsNotethis.getRlsNote()+"(放行註記),"//放行註記
		ans += "REL_DATE="+relDatethis.getRelDate()+"(放行日期時間),"//放行日期時間
		ans += "REL_PACK="+relPackthis.getRelPack()+"(放行件數),"//放行件數
		ans += "EXAM_COUNTER="+examCounterthis.getExamCounter()+"(驗貨檯號),"//驗貨檯號
		ans += "SENDER_ID="+senderIdthis.getSenderId()+"(傳送方代碼),"//傳送方代碼
		ans += "CONTROL_NUMBER="+controlNumberthis.getControlNumber()+"(交換控制碼),"//交換控制碼
		ans += "TRANS_ID="+transIdthis.getTransId()+"(訊息處理編號),"//訊息處理編號
		ans += "DEAL_DATE="+dealDatethis.getDealDate()+"(訊息處理時間),"//訊息處理時間
		ans += "RECEIVER_ID="+receiverIdthis.getReceiverId()+"(接收方代碼),"//接收方代碼
		ans += "RECV_FINISH_DATE="+recvFinishDatethis.getRecvFinishDate()+"(收單完成時間),"//收單完成時間
		return ans;
	}
}

