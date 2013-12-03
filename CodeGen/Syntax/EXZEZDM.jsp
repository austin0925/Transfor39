<form id="beanForm" method="post" >
	<s:hidden name="exzezdmBean.mawb" />
	<s:hidden name="exzezdmBean.hawb" />
	<s:hidden name="exzezdmBean.itemNo" />
	<s:hidden name="exzezdmBean.goodsDesc" />
	<s:hidden name="exzezdmBean.brand" />
	<s:hidden name="exzezdmBean.model" />
	<s:hidden name="exzezdmBean.spec" />
	<s:hidden name="exzezdmBean.cccCode" />
	<s:hidden name="exzezdmBean.qty" />
	<s:hidden name="exzezdmBean.qtyUnit" />
	<s:hidden name="exzezdmBean.netWeight" />
	<s:hidden name="exzezdmBean.twdFob" />
	<s:hidden name="exzezdmBean.stMode" />
<table>
	<tr>
		<td>
					<%--MAWB:託運單主號:mawb--%>
			<s:text name="exzezdmBean.mawb"/>
			<s:textfield name="exzezdmBean.mawb"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--HAWB:託運單分號:hawb--%>
			<s:text name="exzezdmBean.hawb"/>
			<s:textfield name="exzezdmBean.hawb"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--ITEM_NO:序號:itemNo--%>
			<s:text name="exzezdmBean.itemNo"/>
			<s:textfield name="exzezdmBean.itemNo"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--GOODS_DESC:貨物名稱:goodsDesc--%>
			<s:text name="exzezdmBean.goodsDesc"/>
			<s:textfield name="exzezdmBean.goodsDesc"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--BRAND:牌名(商標):brand--%>
			<s:text name="exzezdmBean.brand"/>
			<s:textfield name="exzezdmBean.brand"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--MODEL:型號:model--%>
			<s:text name="exzezdmBean.model"/>
			<s:textfield name="exzezdmBean.model"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--SPEC:成分及規格:spec--%>
			<s:text name="exzezdmBean.spec"/>
			<s:textfield name="exzezdmBean.spec"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--CCC_CODE:貨品分類號列:cccCode--%>
			<s:text name="exzezdmBean.cccCode"/>
			<s:textfield name="exzezdmBean.cccCode"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--QTY:數量:qty--%>
			<s:text name="exzezdmBean.qty"/>
			<s:textfield name="exzezdmBean.qty"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--QTY_UNIT:數量單位:qtyUnit--%>
			<s:text name="exzezdmBean.qtyUnit"/>
			<s:textfield name="exzezdmBean.qtyUnit"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--NET_WEIGHT:淨重:netWeight--%>
			<s:text name="exzezdmBean.netWeight"/>
			<s:textfield name="exzezdmBean.netWeight"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--TWD_FOB:離岸價格(新台幣):twdFob--%>
			<s:text name="exzezdmBean.twdFob"/>
			<s:textfield name="exzezdmBean.twdFob"/>
		</td>
	</tr>

	<tr>
		<td>
					<%--ST_MODE:統計方式代碼:stMode--%>
			<s:text name="exzezdmBean.stMode"/>
			<s:textfield name="exzezdmBean.stMode"/>
		</td>
	</tr>

</table>

	<sjg:grid
		id=exzezdmBean_grid2
		dataType="json"
		gridModel="gridModel"
		rownumbers="true"
		rowNum="0"
		height="120"
		width="980"
		shrinkToFit="false"
		onSelectRowTopics="exzezdmBean_selectRowTopics2"
		onPagingTopics="exzezdmBean_pagingTopics2"
		onGridCompleteTopics="exzezdmBean_grid2CompleteTopics"
		editinline="true"
		editurl="false"
		autoencode="false"
		pager="true"
		rowList="10,20,30"
		viewrecords="true" >

		<%--MAWB:託運單主號:mawb--%>
		<sjg:gridColumn name="MAWB" title="%{getText('mawb')}" width="40" sortable="true" editable="true"/>
		<%--HAWB:託運單分號:hawb--%>
		<sjg:gridColumn name="HAWB" title="%{getText('hawb')}" width="40" sortable="true" editable="true"/>
		<%--ITEM_NO:序號:itemNo--%>
		<sjg:gridColumn name="ITEM_NO" title="%{getText('itemNo')}" width="40" sortable="true" editable="true"/>
		<%--GOODS_DESC:貨物名稱:goodsDesc--%>
		<sjg:gridColumn name="GOODS_DESC" title="%{getText('goodsDesc')}" width="40" sortable="true" editable="true"/>
		<%--BRAND:牌名(商標):brand--%>
		<sjg:gridColumn name="BRAND" title="%{getText('brand')}" width="40" sortable="true" editable="true"/>
		<%--MODEL:型號:model--%>
		<sjg:gridColumn name="MODEL" title="%{getText('model')}" width="40" sortable="true" editable="true"/>
		<%--SPEC:成分及規格:spec--%>
		<sjg:gridColumn name="SPEC" title="%{getText('spec')}" width="40" sortable="true" editable="true"/>
		<%--CCC_CODE:貨品分類號列:cccCode--%>
		<sjg:gridColumn name="CCC_CODE" title="%{getText('cccCode')}" width="40" sortable="true" editable="true"/>
		<%--QTY:數量:qty--%>
		<sjg:gridColumn name="QTY" title="%{getText('qty')}" width="40" sortable="true" editable="true"/>
		<%--QTY_UNIT:數量單位:qtyUnit--%>
		<sjg:gridColumn name="QTY_UNIT" title="%{getText('qtyUnit')}" width="40" sortable="true" editable="true"/>
		<%--NET_WEIGHT:淨重:netWeight--%>
		<sjg:gridColumn name="NET_WEIGHT" title="%{getText('netWeight')}" width="40" sortable="true" editable="true"/>
		<%--TWD_FOB:離岸價格(新台幣):twdFob--%>
		<sjg:gridColumn name="TWD_FOB" title="%{getText('twdFob')}" width="40" sortable="true" editable="true"/>
		<%--ST_MODE:統計方式代碼:stMode--%>
		<sjg:gridColumn name="ST_MODE" title="%{getText('stMode')}" width="40" sortable="true" editable="true"/>

	</sjg:grid>



	<table class="ctv">
		<tr>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="mawb"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="hawb"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="itemNo"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="goodsDesc"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="brand"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="model"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="spec"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="cccCode"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="qty"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="qtyUnit"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="netWeight"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="twdFob"/></label></th>
			<th><label style="display: inline-block;"width: 30px;"><s:text name="stMode"/></label></th>
		</tr>
		<tr>
			<td align="center" class="ctvTitle" ><span id="mawb"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="hawb"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="itemNo"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="goodsDesc"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="brand"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="model"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="spec"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="cccCode"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="qty"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="qtyUnit"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="netWeight"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="twdFob"  style="display:inline-block; width:30px;" ></span></td>
			<td align="center" class="ctvTitle" ><span id="stMode"  style="display:inline-block; width:30px;" ></span></td>
		</tr>
	</table>
</form>
