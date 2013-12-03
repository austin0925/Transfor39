<form id="beanForm" method="post" >
	<s:hidden name="exzezmmBean.transTypeCd" />
	<s:hidden name="exzezmmBean.mawb" />
	<s:hidden name="exzezmmBean.hawb" />
	<s:hidden name="exzezmmBean.declNo" />
	<s:hidden name="exzezmmBean.declCustCd" />
	<s:hidden name="exzezmmBean.seqNo" />
	<s:hidden name="exzezmmBean.declType" />
	<s:hidden name="exzezmmBean.brokerBoxNo" />
	<s:hidden name="exzezmmBean.brokerSubBoxNo" />
	<s:hidden name="exzezmmBean.brokerEmp" />
	<s:hidden name="exzezmmBean.storWareCd" />
	<s:hidden name="exzezmmBean.exporterBan" />
	<s:hidden name="exzezmmBean.exporterEname" />
	<s:hidden name="exzezmmBean.exporterCname" />
	<s:hidden name="exzezmmBean.exporterEaddr" />
	<s:hidden name="exzezmmBean.exporterCaddr" />
	<s:hidden name="exzezmmBean.expressCarrierBan" />
	<s:hidden name="exzezmmBean.expressCarrierEname" />
	<s:hidden name="exzezmmBean.expressCarrierCname" />
	<s:hidden name="exzezmmBean.onBoardCourierBan" />
	<s:hidden name="exzezmmBean.onBoardCourierEname" />
	<s:hidden name="exzezmmBean.onBoardCourierCname" />
	<s:hidden name="exzezmmBean.consolidatedBagNo" />
	<s:hidden name="exzezmmBean.totalHawb" />
	<s:hidden name="exzezmmBean.declDate" />
	<s:hidden name="exzezmmBean.voyageFlightNo" />
	<s:hidden name="exzezmmBean.salBan" />
	<s:hidden name="exzezmmBean.salEname" />
	<s:hidden name="exzezmmBean.salCname" />
	<s:hidden name="exzezmmBean.salEaddr" />
	<s:hidden name="exzezmmBean.salCaddr" />
	<s:hidden name="exzezmmBean.destCd" />
	<s:hidden name="exzezmmBean.totPackQty" />
	<s:hidden name="exzezmmBean.packUnit" />
	<s:hidden name="exzezmmBean.totGrossWeight" />
	<s:hidden name="exzezmmBean.totTwdFob" />
	<s:hidden name="exzezmmBean.proType" />
	<s:hidden name="exzezmmBean.clearType" />
	<s:hidden name="exzezmmBean.examMark" />
	<s:hidden name="exzezmmBean.rlsNote" />
	<s:hidden name="exzezmmBean.relDate" />
	<s:hidden name="exzezmmBean.relPack" />
	<s:hidden name="exzezmmBean.examCounter" />
	<s:hidden name="exzezmmBean.senderId" />
	<s:hidden name="exzezmmBean.controlNumber" />
	<s:hidden name="exzezmmBean.transId" />
	<s:hidden name="exzezmmBean.dealDate" />
	<s:hidden name="exzezmmBean.receiverId" />
	<s:hidden name="exzezmmBean.recvFinishDate" />
<table>
	<tr>
		<td>
					<%--TRANS_TYPE_CD:訊息功能代碼:transTypeCd--%>
			<s:text name="exzezmmBean.transTypeCd"/>
			<s:textfield name="exzezmmBean.transTypeCd"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--MAWB:託運單主號:mawb--%>
			<s:text name="exzezmmBean.mawb"/>
			<s:textfield name="exzezmmBean.mawb"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--HAWB:託運單分號:hawb--%>
			<s:text name="exzezmmBean.hawb"/>
			<s:textfield name="exzezmmBean.hawb"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--DECL_NO:報單號碼:declNo--%>
			<s:text name="exzezmmBean.declNo"/>
			<s:textfield name="exzezmmBean.declNo"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--DECL_CUST_CD:報單關別:declCustCd--%>
			<s:text name="exzezmmBean.declCustCd"/>
			<s:textfield name="exzezmmBean.declCustCd"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--SEQ_NO:序號:seqNo--%>
			<s:text name="exzezmmBean.seqNo"/>
			<s:textfield name="exzezmmBean.seqNo"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--DECL_TYPE:報單類別:declType--%>
			<s:text name="exzezmmBean.declType"/>
			<s:textfield name="exzezmmBean.declType"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--BROKER_BOX_NO:業者箱號:brokerBoxNo--%>
			<s:text name="exzezmmBean.brokerBoxNo"/>
			<s:textfield name="exzezmmBean.brokerBoxNo"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--BROKER_SUB_BOX_NO:箱號附碼:brokerSubBoxNo--%>
			<s:text name="exzezmmBean.brokerSubBoxNo"/>
			<s:textfield name="exzezmmBean.brokerSubBoxNo"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--BROKER_EMP:專責報關人員代號:brokerEmp--%>
			<s:text name="exzezmmBean.brokerEmp"/>
			<s:textfield name="exzezmmBean.brokerEmp"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--STOR_WARE_CD:卸存地點代碼:storWareCd--%>
			<s:text name="exzezmmBean.storWareCd"/>
			<s:textfield name="exzezmmBean.storWareCd"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXPORTER_BAN:輸出人統一編號:exporterBan--%>
			<s:text name="exzezmmBean.exporterBan"/>
			<s:textfield name="exzezmmBean.exporterBan"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXPORTER_ENAME:輸出人英文名稱:exporterEname--%>
			<s:text name="exzezmmBean.exporterEname"/>
			<s:textfield name="exzezmmBean.exporterEname"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXPORTER_CNAME:輸出人中文名稱:exporterCname--%>
			<s:text name="exzezmmBean.exporterCname"/>
			<s:textfield name="exzezmmBean.exporterCname"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXPORTER_EADDR:輸出人英文地址:exporterEaddr--%>
			<s:text name="exzezmmBean.exporterEaddr"/>
			<s:textfield name="exzezmmBean.exporterEaddr"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXPORTER_CADDR:輸出人中文地址:exporterCaddr--%>
			<s:text name="exzezmmBean.exporterCaddr"/>
			<s:textfield name="exzezmmBean.exporterCaddr"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXPRESS_CARRIER_BAN:快遞業者統一編號:expressCarrierBan--%>
			<s:text name="exzezmmBean.expressCarrierBan"/>
			<s:textfield name="exzezmmBean.expressCarrierBan"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXPRESS_CARRIER_ENAME:快遞業者英文名稱:expressCarrierEname--%>
			<s:text name="exzezmmBean.expressCarrierEname"/>
			<s:textfield name="exzezmmBean.expressCarrierEname"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXPRESS_CARRIER_CNAME:快遞業者中文名稱:expressCarrierCname--%>
			<s:text name="exzezmmBean.expressCarrierCname"/>
			<s:textfield name="exzezmmBean.expressCarrierCname"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--ON_BOARD_COURIER_BAN:快遞專差統一編號:onBoardCourierBan--%>
			<s:text name="exzezmmBean.onBoardCourierBan"/>
			<s:textfield name="exzezmmBean.onBoardCourierBan"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--ON_BOARD_COURIER_ENAME:快遞專差英文名稱:onBoardCourierEname--%>
			<s:text name="exzezmmBean.onBoardCourierEname"/>
			<s:textfield name="exzezmmBean.onBoardCourierEname"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--ON_BOARD_COURIER_CNAME:快遞專差中文名稱:onBoardCourierCname--%>
			<s:text name="exzezmmBean.onBoardCourierCname"/>
			<s:textfield name="exzezmmBean.onBoardCourierCname"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--CONSOLIDATED_BAG_NO:併袋號碼:consolidatedBagNo--%>
			<s:text name="exzezmmBean.consolidatedBagNo"/>
			<s:textfield name="exzezmmBean.consolidatedBagNo"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--TOTAL_HAWB:併袋筆數:totalHawb--%>
			<s:text name="exzezmmBean.totalHawb"/>
			<s:textfield name="exzezmmBean.totalHawb"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--DECL_DATE:報關日期:declDate--%>
			<s:text name="exzezmmBean.declDate"/>
			<s:textfield name="exzezmmBean.declDate"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--VOYAGE_FLIGHT_NO:船舶航機班次:voyageFlightNo--%>
			<s:text name="exzezmmBean.voyageFlightNo"/>
			<s:textfield name="exzezmmBean.voyageFlightNo"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--SAL_BAN:貨物輸出人統一編號:salBan--%>
			<s:text name="exzezmmBean.salBan"/>
			<s:textfield name="exzezmmBean.salBan"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--SAL_ENAME:貨物輸出人英文名稱:salEname--%>
			<s:text name="exzezmmBean.salEname"/>
			<s:textfield name="exzezmmBean.salEname"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--SAL_CNAME:貨物輸出人中文名稱:salCname--%>
			<s:text name="exzezmmBean.salCname"/>
			<s:textfield name="exzezmmBean.salCname"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--SAL_EADDR:貨物輸出人英文地址:salEaddr--%>
			<s:text name="exzezmmBean.salEaddr"/>
			<s:textfield name="exzezmmBean.salEaddr"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--SAL_CADDR:貨物輸出人中文地址:salCaddr--%>
			<s:text name="exzezmmBean.salCaddr"/>
			<s:textfield name="exzezmmBean.salCaddr"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--DEST_CD:目的地代碼:destCd--%>
			<s:text name="exzezmmBean.destCd"/>
			<s:textfield name="exzezmmBean.destCd"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--TOT_PACK_QTY:總件數:totPackQty--%>
			<s:text name="exzezmmBean.totPackQty"/>
			<s:textfield name="exzezmmBean.totPackQty"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--PACK_UNIT:件數單位:packUnit--%>
			<s:text name="exzezmmBean.packUnit"/>
			<s:textfield name="exzezmmBean.packUnit"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--TOT_GROSS_WEIGHT:總毛重:totGrossWeight--%>
			<s:text name="exzezmmBean.totGrossWeight"/>
			<s:textfield name="exzezmmBean.totGrossWeight"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--TOT_TWD_FOB:總離岸價格(新台幣):totTwdFob--%>
			<s:text name="exzezmmBean.totTwdFob"/>
			<s:textfield name="exzezmmBean.totTwdFob"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--PRO_TYPE:訊息功能代碼:proType--%>
			<s:text name="exzezmmBean.proType"/>
			<s:textfield name="exzezmmBean.proType"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--CLEAR_TYPE:通關方式:clearType--%>
			<s:text name="exzezmmBean.clearType"/>
			<s:textfield name="exzezmmBean.clearType"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXAM_MARK:驗貨註記:examMark--%>
			<s:text name="exzezmmBean.examMark"/>
			<s:textfield name="exzezmmBean.examMark"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--RLS_NOTE:放行註記:rlsNote--%>
			<s:text name="exzezmmBean.rlsNote"/>
			<s:textfield name="exzezmmBean.rlsNote"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--REL_DATE:放行日期時間:relDate--%>
			<s:text name="exzezmmBean.relDate"/>
			<s:textfield name="exzezmmBean.relDate"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--REL_PACK:放行件數:relPack--%>
			<s:text name="exzezmmBean.relPack"/>
			<s:textfield name="exzezmmBean.relPack"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--EXAM_COUNTER:驗貨檯號:examCounter--%>
			<s:text name="exzezmmBean.examCounter"/>
			<s:textfield name="exzezmmBean.examCounter"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--SENDER_ID:傳送方代碼:senderId--%>
			<s:text name="exzezmmBean.senderId"/>
			<s:textfield name="exzezmmBean.senderId"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--CONTROL_NUMBER:交換控制碼:controlNumber--%>
			<s:text name="exzezmmBean.controlNumber"/>
			<s:textfield name="exzezmmBean.controlNumber"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--TRANS_ID:訊息處理編號:transId--%>
			<s:text name="exzezmmBean.transId"/>
			<s:textfield name="exzezmmBean.transId"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--DEAL_DATE:訊息處理時間:dealDate--%>
			<s:text name="exzezmmBean.dealDate"/>
			<s:textfield name="exzezmmBean.dealDate"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--RECEIVER_ID:接收方代碼:receiverId--%>
			<s:text name="exzezmmBean.receiverId"/>
			<s:textfield name="exzezmmBean.receiverId"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--RECV_FINISH_DATE:收單完成時間:recvFinishDate--%>
			<s:text name="exzezmmBean.recvFinishDate"/>
			<s:textfield name="exzezmmBean.recvFinishDate"/>
		</td>
	</tr>

</table>

	<sjg:grid
		id=exzezmmBean_grid2
		dataType="json"
		gridModel="gridModel"
		rownumbers="true"
		rowNum="0"
		height="120"
		width="980"
		shrinkToFit="false"
		onSelectRowTopics="exzezmmBean_selectRowTopics2"
		onPagingTopics="exzezmmBean_pagingTopics2"
		onGridCompleteTopics="exzezmmBean_grid2CompleteTopics"
		editinline="true"
		editurl="false"
		autoencode="false"
		pager="true"
		rowList="10,20,30"
		viewrecords="true" >

		<%--TRANS_TYPE_CD:訊息功能代碼:transTypeCd--%>
		<sjg:gridColumn name="TRANS_TYPE_CD" title="%{getText('transTypeCd')}" width="40" sortable="true" editable="true"/>
		<%--MAWB:託運單主號:mawb--%>
		<sjg:gridColumn name="MAWB" title="%{getText('mawb')}" width="40" sortable="true" editable="true"/>
		<%--HAWB:託運單分號:hawb--%>
		<sjg:gridColumn name="HAWB" title="%{getText('hawb')}" width="40" sortable="true" editable="true"/>
		<%--DECL_NO:報單號碼:declNo--%>
		<sjg:gridColumn name="DECL_NO" title="%{getText('declNo')}" width="40" sortable="true" editable="true"/>
		<%--DECL_CUST_CD:報單關別:declCustCd--%>
		<sjg:gridColumn name="DECL_CUST_CD" title="%{getText('declCustCd')}" width="40" sortable="true" editable="true"/>
		<%--SEQ_NO:序號:seqNo--%>
		<sjg:gridColumn name="SEQ_NO" title="%{getText('seqNo')}" width="40" sortable="true" editable="true"/>
		<%--DECL_TYPE:報單類別:declType--%>
		<sjg:gridColumn name="DECL_TYPE" title="%{getText('declType')}" width="40" sortable="true" editable="true"/>
		<%--BROKER_BOX_NO:業者箱號:brokerBoxNo--%>
		<sjg:gridColumn name="BROKER_BOX_NO" title="%{getText('brokerBoxNo')}" width="40" sortable="true" editable="true"/>
		<%--BROKER_SUB_BOX_NO:箱號附碼:brokerSubBoxNo--%>
		<sjg:gridColumn name="BROKER_SUB_BOX_NO" title="%{getText('brokerSubBoxNo')}" width="40" sortable="true" editable="true"/>
		<%--BROKER_EMP:專責報關人員代號:brokerEmp--%>
		<sjg:gridColumn name="BROKER_EMP" title="%{getText('brokerEmp')}" width="40" sortable="true" editable="true"/>
		<%--STOR_WARE_CD:卸存地點代碼:storWareCd--%>
		<sjg:gridColumn name="STOR_WARE_CD" title="%{getText('storWareCd')}" width="40" sortable="true" editable="true"/>
		<%--EXPORTER_BAN:輸出人統一編號:exporterBan--%>
		<sjg:gridColumn name="EXPORTER_BAN" title="%{getText('exporterBan')}" width="40" sortable="true" editable="true"/>
		<%--EXPORTER_ENAME:輸出人英文名稱:exporterEname--%>
		<sjg:gridColumn name="EXPORTER_ENAME" title="%{getText('exporterEname')}" width="40" sortable="true" editable="true"/>
		<%--EXPORTER_CNAME:輸出人中文名稱:exporterCname--%>
		<sjg:gridColumn name="EXPORTER_CNAME" title="%{getText('exporterCname')}" width="40" sortable="true" editable="true"/>
		<%--EXPORTER_EADDR:輸出人英文地址:exporterEaddr--%>
		<sjg:gridColumn name="EXPORTER_EADDR" title="%{getText('exporterEaddr')}" width="40" sortable="true" editable="true"/>
		<%--EXPORTER_CADDR:輸出人中文地址:exporterCaddr--%>
		<sjg:gridColumn name="EXPORTER_CADDR" title="%{getText('exporterCaddr')}" width="40" sortable="true" editable="true"/>
		<%--EXPRESS_CARRIER_BAN:快遞業者統一編號:expressCarrierBan--%>
		<sjg:gridColumn name="EXPRESS_CARRIER_BAN" title="%{getText('expressCarrierBan')}" width="40" sortable="true" editable="true"/>
		<%--EXPRESS_CARRIER_ENAME:快遞業者英文名稱:expressCarrierEname--%>
		<sjg:gridColumn name="EXPRESS_CARRIER_ENAME" title="%{getText('expressCarrierEname')}" width="40" sortable="true" editable="true"/>
		<%--EXPRESS_CARRIER_CNAME:快遞業者中文名稱:expressCarrierCname--%>
		<sjg:gridColumn name="EXPRESS_CARRIER_CNAME" title="%{getText('expressCarrierCname')}" width="40" sortable="true" editable="true"/>
		<%--ON_BOARD_COURIER_BAN:快遞專差統一編號:onBoardCourierBan--%>
		<sjg:gridColumn name="ON_BOARD_COURIER_BAN" title="%{getText('onBoardCourierBan')}" width="40" sortable="true" editable="true"/>
		<%--ON_BOARD_COURIER_ENAME:快遞專差英文名稱:onBoardCourierEname--%>
		<sjg:gridColumn name="ON_BOARD_COURIER_ENAME" title="%{getText('onBoardCourierEname')}" width="40" sortable="true" editable="true"/>
		<%--ON_BOARD_COURIER_CNAME:快遞專差中文名稱:onBoardCourierCname--%>
		<sjg:gridColumn name="ON_BOARD_COURIER_CNAME" title="%{getText('onBoardCourierCname')}" width="40" sortable="true" editable="true"/>
		<%--CONSOLIDATED_BAG_NO:併袋號碼:consolidatedBagNo--%>
		<sjg:gridColumn name="CONSOLIDATED_BAG_NO" title="%{getText('consolidatedBagNo')}" width="40" sortable="true" editable="true"/>
		<%--TOTAL_HAWB:併袋筆數:totalHawb--%>
		<sjg:gridColumn name="TOTAL_HAWB" title="%{getText('totalHawb')}" width="40" sortable="true" editable="true"/>
		<%--DECL_DATE:報關日期:declDate--%>
		<sjg:gridColumn name="DECL_DATE" title="%{getText('declDate')}" width="40" sortable="true" editable="true"/>
		<%--VOYAGE_FLIGHT_NO:船舶航機班次:voyageFlightNo--%>
		<sjg:gridColumn name="VOYAGE_FLIGHT_NO" title="%{getText('voyageFlightNo')}" width="40" sortable="true" editable="true"/>
		<%--SAL_BAN:貨物輸出人統一編號:salBan--%>
		<sjg:gridColumn name="SAL_BAN" title="%{getText('salBan')}" width="40" sortable="true" editable="true"/>
		<%--SAL_ENAME:貨物輸出人英文名稱:salEname--%>
		<sjg:gridColumn name="SAL_ENAME" title="%{getText('salEname')}" width="40" sortable="true" editable="true"/>
		<%--SAL_CNAME:貨物輸出人中文名稱:salCname--%>
		<sjg:gridColumn name="SAL_CNAME" title="%{getText('salCname')}" width="40" sortable="true" editable="true"/>
		<%--SAL_EADDR:貨物輸出人英文地址:salEaddr--%>
		<sjg:gridColumn name="SAL_EADDR" title="%{getText('salEaddr')}" width="40" sortable="true" editable="true"/>
		<%--SAL_CADDR:貨物輸出人中文地址:salCaddr--%>
		<sjg:gridColumn name="SAL_CADDR" title="%{getText('salCaddr')}" width="40" sortable="true" editable="true"/>
		<%--DEST_CD:目的地代碼:destCd--%>
		<sjg:gridColumn name="DEST_CD" title="%{getText('destCd')}" width="40" sortable="true" editable="true"/>
		<%--TOT_PACK_QTY:總件數:totPackQty--%>
		<sjg:gridColumn name="TOT_PACK_QTY" title="%{getText('totPackQty')}" width="40" sortable="true" editable="true"/>
		<%--PACK_UNIT:件數單位:packUnit--%>
		<sjg:gridColumn name="PACK_UNIT" title="%{getText('packUnit')}" width="40" sortable="true" editable="true"/>
		<%--TOT_GROSS_WEIGHT:總毛重:totGrossWeight--%>
		<sjg:gridColumn name="TOT_GROSS_WEIGHT" title="%{getText('totGrossWeight')}" width="40" sortable="true" editable="true"/>
		<%--TOT_TWD_FOB:總離岸價格(新台幣):totTwdFob--%>
		<sjg:gridColumn name="TOT_TWD_FOB" title="%{getText('totTwdFob')}" width="40" sortable="true" editable="true"/>
		<%--PRO_TYPE:訊息功能代碼:proType--%>
		<sjg:gridColumn name="PRO_TYPE" title="%{getText('proType')}" width="40" sortable="true" editable="true"/>
		<%--CLEAR_TYPE:通關方式:clearType--%>
		<sjg:gridColumn name="CLEAR_TYPE" title="%{getText('clearType')}" width="40" sortable="true" editable="true"/>
		<%--EXAM_MARK:驗貨註記:examMark--%>
		<sjg:gridColumn name="EXAM_MARK" title="%{getText('examMark')}" width="40" sortable="true" editable="true"/>
		<%--RLS_NOTE:放行註記:rlsNote--%>
		<sjg:gridColumn name="RLS_NOTE" title="%{getText('rlsNote')}" width="40" sortable="true" editable="true"/>
		<%--REL_DATE:放行日期時間:relDate--%>
		<sjg:gridColumn name="REL_DATE" title="%{getText('relDate')}" width="40" sortable="true" editable="true"/>
		<%--REL_PACK:放行件數:relPack--%>
		<sjg:gridColumn name="REL_PACK" title="%{getText('relPack')}" width="40" sortable="true" editable="true"/>
		<%--EXAM_COUNTER:驗貨檯號:examCounter--%>
		<sjg:gridColumn name="EXAM_COUNTER" title="%{getText('examCounter')}" width="40" sortable="true" editable="true"/>
		<%--SENDER_ID:傳送方代碼:senderId--%>
		<sjg:gridColumn name="SENDER_ID" title="%{getText('senderId')}" width="40" sortable="true" editable="true"/>
		<%--CONTROL_NUMBER:交換控制碼:controlNumber--%>
		<sjg:gridColumn name="CONTROL_NUMBER" title="%{getText('controlNumber')}" width="40" sortable="true" editable="true"/>
		<%--TRANS_ID:訊息處理編號:transId--%>
		<sjg:gridColumn name="TRANS_ID" title="%{getText('transId')}" width="40" sortable="true" editable="true"/>
		<%--DEAL_DATE:訊息處理時間:dealDate--%>
		<sjg:gridColumn name="DEAL_DATE" title="%{getText('dealDate')}" width="40" sortable="true" editable="true"/>
		<%--RECEIVER_ID:接收方代碼:receiverId--%>
		<sjg:gridColumn name="RECEIVER_ID" title="%{getText('receiverId')}" width="40" sortable="true" editable="true"/>
		<%--RECV_FINISH_DATE:收單完成時間:recvFinishDate--%>
		<sjg:gridColumn name="RECV_FINISH_DATE" title="%{getText('recvFinishDate')}" width="40" sortable="true" editable="true"/>

	</sjg:grid>



	<table class="ctv">
		<tr>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="transTypeCd"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="mawb"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="hawb"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="declNo"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="declCustCd"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="seqNo"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="declType"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="brokerBoxNo"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="brokerSubBoxNo"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="brokerEmp"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="storWareCd"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="exporterBan"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="exporterEname"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="exporterCname"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="exporterEaddr"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="exporterCaddr"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="expressCarrierBan"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="expressCarrierEname"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="expressCarrierCname"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="onBoardCourierBan"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="onBoardCourierEname"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="onBoardCourierCname"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="consolidatedBagNo"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="totalHawb"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="declDate"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="voyageFlightNo"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="salBan"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="salEname"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="salCname"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="salEaddr"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="salCaddr"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="destCd"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="totPackQty"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="packUnit"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="totGrossWeight"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="totTwdFob"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="proType"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="clearType"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="examMark"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="rlsNote"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="relDate"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="relPack"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="examCounter"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="senderId"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="controlNumber"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="transId"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="dealDate"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="receiverId"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="recvFinishDate"/></label></th>
		</tr>
		<tr>
			<td align="center" class="ctvTitle" ><span id="transTypeCd"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="mawb"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="hawb"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="declNo"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="declCustCd"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="seqNo"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="declType"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="brokerBoxNo"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="brokerSubBoxNo"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="brokerEmp"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="storWareCd"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="exporterBan"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="exporterEname"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="exporterCname"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="exporterEaddr"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="exporterCaddr"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="expressCarrierBan"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="expressCarrierEname"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="expressCarrierCname"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="onBoardCourierBan"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="onBoardCourierEname"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="onBoardCourierCname"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="consolidatedBagNo"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="totalHawb"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="declDate"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="voyageFlightNo"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="salBan"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="salEname"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="salCname"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="salEaddr"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="salCaddr"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="destCd"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="totPackQty"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="packUnit"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="totGrossWeight"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="totTwdFob"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="proType"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="clearType"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="examMark"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="rlsNote"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="relDate"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="relPack"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="examCounter"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="senderId"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="controlNumber"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="transId"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="dealDate"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="receiverId"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="recvFinishDate"  style="display:inline-block; width:30px;" ></span></td>
		</tr>
	</table>
</form>
