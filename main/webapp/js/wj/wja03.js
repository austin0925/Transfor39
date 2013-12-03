function queryGridTTT(urlString, gridTableId, param){
	var fromString = "form";
	var jsonData;
	var showMsg = true;
	var showGrid = true;
	var msgId = '#statusMsg'; //下方狀態列
	var msgWinId = '#window'; //彈跳視窗
	var formData = $(fromString).serializeArray();
	var lastUrl = urlString;
	var gridParam = jQuery.param(formData);
	var index;
	if (typeof param !='undefined') {
		//msgId defaultValue = "#statusMsg" (can Change)
		if (param['msgId'] != null && param['msgId'].lenght>0) {
			msgId = param['msgId'];
		}
//		alert('1.value='+param['form']+',length='+param['form'].lenght);
		
		//重新變更form的ID
		if (param['form'] != null && param['form']!="" && typeof param['form'] != 'undefined') {
//			alert('2.'+param['form']);
			formData = $(param['form']).serializeArray();
			gridParam = jQuery.param(formData);;
		}
		
		//lastUrl defaultValue = urlString; (can Change)
		if (param['lastUrl'] != null && param['lastUrl'].lenght>0) {
			lastUrl = param['lastUrl'];
		}
		
		//showMsg defaultValue = true (can Change)
		if (param['showMsg'] != null) {
			showMsg = param['showMsg'];
		}
		
		//showGrid defaultValue = true (can Change)
		if (param['showGrid'] != null) {
			showGrid = param['showGrid'];
		}
		
		//page added for formData
		if (param['page'] != null && param['page']>0) {
			// Find and replace `msgId` if there
			for (index = 0; index < formData.length; ++index) {
			    if (formData[index].name == "page") {
			    	formData[index].value = param['page'];
			        break;
			    }
			}
			// Add it if it wasn't there
			if (index >= formData.length) {
				formData.push({
			        name: "page",
			        value: param['page']
			    });
			}
		}
		//rows added for formData
		if (param['rows'] != null && param['rows']>0) {
			// Find and replace `rows` if there
			for (index = 0; index < formData.length; ++index) {
			    if (formData[index].name == "rows") {
			    	formData[index].value = param['rows'];
			        break;
			    }
			}
			// Add it if it wasn't there
			if (index >= formData.length) {
				formData.push({
			        name: "rows",
			        value: param['rows']
			    });
			}
		}
		//sidx added for formData
		if (param['sidx'] != null && param['sidx']>0) {
			// Find and replace `rows` if there
			for (index = 0; index < formData.length; ++index) {
			    if (formData[index].name == "sidx") {
			    	formData[index].value = param['sidx'];
			        break;
			    }
			}
			// Add it if it wasn't there
			if (index >= formData.length) {
				formData.push({
			        name: "sidx",
			        value: param['sidx']
			    });
			}
		}
		//sord added for formData
		if (param['sord'] != null && param['sord']>0) {
			// Find and replace `rows` if there
			for (index = 0; index < formData.length; ++index) {
			    if (formData[index].name == "sord") {
			    	formData[index].value = param['sord'];
			        break;
			    }
			}
			// Add it if it wasn't there
			if (index >= formData.length) {
				formData.push({
			        name: "sord",
			        value: param['sord']
			    });
			}
		}
		
	}
	formData = jQuery.param(formData);

	$.ajax({
		url: urlString, //"RP10!querySerNo",
		type: "POST",
		data: formData,
		async: false,
		//dataType: "json",
		success: function(json, status) {
			if (typeof json == 'string') {
				var errMsg = $(json).find("#jsonMsg").html();
				$(msgWinId).html(errMsg);
				$(msgWinId).attr("style","color:red");
				var errString = "";
				listMsg = $(json).find("#jsonMsg").children("li");
				for(var i = 0; i<listMsg.size();i++){
					errString += listMsg.eq(i).html();
				}
				$(msgId).val(errString);
				$(msgId).attr("style","color:red");
			} else {
				jsonData={
					'page':json.page, 'records' :json.records,
					'rows':json.rows, 'total' :json.total,
					'gridModel':json.gridModel
				};//GridBean only
				//if showGrid is true, then showGrid.
				if(showGrid){
					$(gridTableId)[0].addJSONData(jsonData);
				}
				$(gridTableId).jqGrid( 'setGridParam', {
					url:lastUrl+ '?'+gridParam
				}); //.trigger("reloadGrid");
				if(urlString != lastUrl){
					$(gridTableId).jqGrid( 'setGridParam', {
						url:lastUrl+'?'+gridParam
					}).trigger("reloadGrid");
				}
				if(showMsg==true){
					//處理message or msg(廢棄)
					if(typeof json.msg != 'undefined'){
						$(msgId).val(json.msg);
						$(msgWinId).html(json.msg.replace("]", "]<br/>"));
					}else if(typeof json.message != 'undefined'){
						$(msgId).val(json.message);
						$(msgWinId).html(json.message.replace("]", "]<br/>"));
					}
					//處理status or success(廢棄)
					if(typeof json.status != 'undefined'){
						if(json.status.toUpperCase().indexOf('OK')>=0){
							$(msgId).attr("style","color:blue");//has effect
							$(msgWinId).attr("style","color:black");
						}else{
							$(msgId).attr("style","color:red");
							$(msgWinId).attr("style","color:red");
						}
					}else if(typeof json.success != 'undefined'){
						if(json.success.toUpperCase().indexOf('OK')>=0){
							$(msgId).attr("style","color:blue");//has effect
							$(msgWinId).attr("style","color:black");
						}else{
							$(msgId).attr("style","color:red");
							$(msgWinId).attr("style","color:red");
						}
					}
				}
				jsonData=json;//GridBean only

			}
		},
		error: function(xhrInstance, status, xhrException) {
			message='發生伺服器例外錯誤';
 			$(msgId).val(message);
 			$(msgWinId).html(message+"<br/>");
 			$(msgId).attr("style","color:red");
 			$(msgWinId).attr("style","color:red");
 		}
	});
	$.ajax({async: true});
	return jsonData;
}

//----------------------------------------------


/**
 * 畫面ready後的動作
 */
function documentReady(){

	//基礎資料讀取
	var userType = $("#userBean_userType").val();
	var customType = $("#userBean_customsOffice").val();
	var ban = $("#userBean_consignId").val();
	var banName = $("#userBean_companyName").val();
	var box = $("#userBean_brokerBoxNo").val();
	
//	alert('userType='+userType);
	
	/*個人或公司情況，必須填入名稱和統編號碼，之後設定統編欄位為唯獨*/
	if("A"== userType || "C"== userType ){
		
		var $tmpEle = $("#queryBean_ban");
		$tmpEle.attr("class", "read");
		$tmpEle.attr("readonly", "readonly");

		$("#queryBean_ban").val(ban);
		$("#banName").val(banName);//getBanInfo(ban)[banName]);
		
	}
	/*報關業者，必須填入箱號及名稱，之後設定欄位為唯讀*/
	if("D"==userType){
		
		var $tmpEle = $("#queryBean_brokerBoxNo, #queryBean_customs");
		$tmpEle.attr("class", "read");
		$tmpEle.attr("readonly", "readonly");
		
		$("#queryBean_brokerBoxNo").val(box);
		$("#brokerBoxNoName").val(banName);//getBoxInfo(box));
		$("#queryBean_customs").val(customType+"A");
		
		$("option:not(:selected)", "#queryBean_customs").each(function(index, value){
			$(value).remove();
		});
	}
}


/**
 * 進行畫面查詢作業
 * @returns {Function}
 */
function queryButton(){
	return function(){
		
//		var param = [];
//		param = $("#postForm").serializeArray();
		
//		addParamSafty(param, "queryBean.customs", $("#queryBean_customs").val());
		
//		$.post("WJA03!query", param, function(json){
//			showStatusMsg(json.status, json.msg);
//			jsonData={
//				'page':json.page, 'records' :json.records,
//				'rows':json.rows, 'total' :json.total,
//				'gridModel':json.gridModel
//			};
//			$("#masterGrid")[0].addJSONData(json);
//		});
		queryGridTTT("WJA03!query", "#masterGrid", {
			rows:$("select[class='ui-pg-selbox']").val(),
			form:"#postForm",
			"queryBean.customs": $("#queryBean_customs").val()
		});
	};
}

/**
 * 進行畫面清除作業
 * @returns {Function}
 */
function clearEvent(){
	return function(){
		var userType = $("#userBean_userType").val();
//		alert(userType);
		if("A"==userType||"C"==userType){
			$(".queryBar #queryBean_brokerBoxNo").val("");
			$(".queryBar #brokerBoxNoName").val("");
			$("select option:first-child").attr('selected', true);
		}
		if("D"==userType){
			$(".queryBar #queryBean_ban").val("");
			$(".queryBar #banName").val("");
			$("#queryBean_confirmType option:first-child").attr('selected', true);
		}
	};
}



/**
 * masterGrid選取後執行的方法
 * @param gridId
 * @returns {Function}
 */
function masterSelectRowTopics(gridId){
	return function(){
		var selectId = $("#"+gridId).jqGrid('getGridParam','selrow');
		var rowData = $("#"+gridId).jqGrid('getRowData',selectId);
		
		rowData = toJavaWordKey(rowData);
//		rowData = getADStringFromRocDateStringByRowData(rowData);
		
		
		var type = rowData.slType;
		var userType = $("#userBean_userType").val();
		var confirmType = rowData.confirmType.substring(0, 1);
		
		
//		alert('type='+type+',userType='+userType+',confirmType='+confirmType);

		/*不論短期或長期都需要做的事情*/
		$("#postForm").hide();
		showButton(userType, confirmType, type);
		setFieldFromJson($(".beanBar"), 'pageBean', rowData);
		
		/*設定view.sn列印時需要的參數*/
		$("#view_sn").val(rowData.sn);
		
		//S=>短期走WJA031; L=>長期走WJA032
		if("S"==type){
			setFieldFromJsonTTT($(".shortBar"), 'queryBean', rowData);
			setFieldFromJsonTTT($(".shortBar"), 'view', rowData);
			
			$(".shortBar").show();
			
			$(".shortBar #queryBean_customsName").val(getCustomsName($(".shortBar #queryBean_customs").val()));
			showTextfield($(".shortBar"), userType, confirmType);
			
		}else if("L"==type){
			setFieldFromJsonTTT($(".longBar"), 'queryBean', rowData);
			setFieldFromJsonTTT($(".longBar"), 'view', rowData);
			
			$(".longBar").show();
			
			$(".longBar #queryBean_customsName").val(getCustomsName($(".longBar #queryBean_customs").val()));
			showTextfield($(".longBar"), userType, confirmType);
			
		}else{
			showStatusMsg('ng', '選取的資料狀態欄位有誤');
			
		}
	};  
}


var optionContainer = {};
/**
 * 執行documentReady
 * @returns {Function}
 */
function showTextfield($class, userType, confirmType){
	//alert("$class="+$class.html()+"userType="+userType +",confirmType="+ confirmType);

	if(
			(userType=="A" || userType=="C")
			&& confirmType=="B"
	){
//		alert('1.可以改26');
		//這裡設定select readonly
		$("select", $class).each(function(index, value){
			$(value).children().each(function(i, v){
//				alert('value='+v.value+',selected ='+v.selected+',text='+v.text);
				if(v.selected==false){
					v.disabled=true;
				}
			});
		});
		//這段將根據使用者A+C進行箱號editable的設定
		$readEle = $("#queryBean_agentCd, #queryBean_brokerBoxNo", $class);//$("#queryBean_brokerBoxNo, #queryBean_brokerBoxNo", $class) ;
		$readEle.addClass('read');
		$readEle.attr('readonly', true);
		
		//箱號也不能改了(2013/5/23)  , #queryBean_brokerBoxNo"
		//關別也不能改了
//		SetSelectReadOnlyTTT($("#queryBean_customs", $class), true);
		
		//可以編輯的日期顯示，不可以編輯的隱藏。
    	$("#queryBean_assignBegDate, #queryBean_assignEndDate", $class).show();
		$("#queryBean_assignBeg, #queryBean_assignEnd", $class).hide();
		
		//accroding to wendy (2013/5/18) add cure requirement
		$("#queryBean_assignBegDate", $class).val($("#nowToday").val());
		
		
	}else if(userType=="D" && confirmType=="A"){
//		alert('2.可以改91');
		var $tmpEle = $("" +
				"#queryBean_assignBegDate" +
				", #queryBean_assignEndDate" +
				", #queryBean_customs", $class);
		//這段統一設定指定的".editableField"為 editable
		$(".editableField input, .editableField select", $tmpEle).removeClass('read');
		$(".editableField input, .editableField select", $tmpEle).attr('readonly', false);
		$(".editableField select", $tmpEle).each(function(){
			SetSelectReadOnlyTTT(this, false);
		});
		//這段將根據使用者D進行箱號editable的設定
//		$readEle = $("#queryBean_ban, #queryBean_brokerBoxNo", $class) ;
//		$readEle.removeClass('read');
//		$readEle.attr('readonly', false);
		
		//箱號也不能改了(2013/5/23)  #queryBean_brokerBoxNo"
		SetSelectReadOnlyTTT($("#queryBean_customs", $class), true);
		
		
		//可以編輯的日期顯示，不可以編輯的隱藏。
		$("#queryBean_assignBegDate, #queryBean_assignEndDate", $class).show();
		$("#queryBean_assignBeg, #queryBean_assignEnd", $class).hide();
		
		//accroding to wendy (2013/5/18) add cure requirement
		$("#queryBean_assignBegDate", $class).val($("#nowToday").val());
		
	}else{
//		alert('3.不可以改,optionContainer.length='+optionContainer);
		$('input, select', $class).addClass('read');
		$('input, select', $class).attr('readonly', true);
		$('select', $class).each(function(){
			SetSelectReadOnlyTTT(this, true);
		});
		
		//不可以編輯的日期顯示，可以編輯的隱藏。
    	$("#queryBean_assignBegDate, #queryBean_assignEndDate", $class).hide();
		$("#queryBean_assignBeg, #queryBean_assignEnd", $class).show();
		
		//設定日期
		
		$("#queryBean_assignBeg", $class).val($("#queryBean_assignBegDate", $class).val());
		$("#queryBean_assignEnd", $class).val($("#queryBean_assignEndDate", $class).val());
		
//		alert('3.不可以改,optionContainer.length='+optionContainer);
	}
	//最後統一把日期一併改掉
	var dateS=$("#queryBean_assignBegDate").val().substring(0,9);
	var dateE=$("#queryBean_assignEndDate").val().substring(0,9);
	
	$("#queryBean_assignBeg, #queryBean_assignBegDate", $class).val(dateS);
	$("#queryBean_assignEnd, #queryBean_assignEndDate", $class).val(dateE);
		
}

/**
 * 設定按鈕顯示的狀況
 * @param className
 * @param confirmType
 */
function showButton(userType, confirmType, slType){
	//過慮一下僅留第一個字碼
	confirmType = confirmType.substring(0,1);
	
//	alert('userType='+userType+',confirmType='+confirmType);
	
	//主畫面按鈕先隱藏
	$(".progMain").hide();
	
    if(confirmType=="A" && ("A"==userType||"C"==userType)
    ){
    	$(".resignA").hide();
    	$(".resignB").show();
    }else if(confirmType=="A" && ("D"==userType)
    ){
    	$(".resignB").hide();
    	$(".resignA").show();
	}else if(confirmType=="B" && ("D"==userType)
    ){
		$(".resignA").hide();
    	$(".resignB").show();
    }else if(confirmType=="B" && ("A"==userType||"C"==userType)
    ){
    	$(".resignB").hide();
    	$(".resignA").show();
    }else if(confirmType=="C" || confirmType=="E" || confirmType=="D" ){
    	$(".resignB").hide();
    	$(".resignA").hide();
    	$(".resignE").hide();
    	$("#exitButton").show();
    	//列印按鈕分兩種，所以得要把另外一種檔起來.
    	if("L"==slType && confirmType=="E"){
    		$("#printButtonL").show();
    	}else if("S"==slType && confirmType=="E"){
    		$("#printButtonS").show();
    	}
	} 
    
}

/**
 * 執行列印鍵
 * @returns {Function}
 */
function updateButton(){
	return function(){
		var slType = $("#pageBean_slType").val();
//		alert('updateButton, slType='+slType);
		var param = getRequestParam(slType);
		
		if(slType=='S' || slType=='L'){
			$.post("WJA03!update", param, function(data){
				showStatusMsg(data.status, data.msg);
			});
		}else{
			showStatusMsg('ng', '執行狀態錯誤');
		}
	};
}

/**
 * 執行列印鍵
 * @returns {Function}
 */
function deleteButton(){
	return function(){
		var slType = $("#pageBean_slType").val();
//		alert('updateButton, slType='+slType);
		var param = getRequestParam(slType);
		
		if(slType=='S' || slType=='L'){
			$.post("WJA03!delete", param, function(data){
				showStatusMsg(data.status, data.msg);
			});
		}else{
			showStatusMsg('ng', '執行狀態錯誤');
		}
	};
}

/**
 * 執行列印鍵
 * @returns {Function}
 */
function acceptButton(){
	return function(){
		
		var slType = $("#pageBean_slType").val();
		var param = getRequestParam(slType);
		
		$.post("WJA03!requestOK", param, function(data){
			showStatusMsg(data.status, data.msg);
		});
	};
}

/**
 * 執行列印鍵
 * @returns {Function}
 */
function rejectButton(){
	return function(){
		
		var userType = $("#userBean_userType").val();
		var slType = $("#pageBean_slType").val();
		var param = getRequestParam(slType);
		
//		alert('userType='+userType+',slType='+slType+',param='+param);
		
		if('A'==userType || 'C'==userType){
			$.post("WJA03!companyRequestNG", param, function(data){
				showStatusMsg(data.status, data.msg);
			});
		}else if('D'==userType){
			$.post("WJA03!brokerRequestNG", param, function(data){
				showStatusMsg(data.status, data.msg);
			});
		}else{
			showStatusMsg('ng', '使用者狀態錯誤');
		}
	};
}

/**
 * get longBar param
 * @returns {Array}
 */
function getRequestParam(slType){
	var param = [];
	
	addParamSafty(param, "page", $("input .ui-pg-input").val());
	addParamSafty(param, "rows", $("select .ui-pg-selbox").val());

	if(slType=='S'){
		$tmpEle = $(".beanBar input, .shortBar input, .shortBar select");
		$tmpEle.each(function(index, value){
			var idString = value.id;
			idString = idString.replace("_", ".");
			if(idString.indexOf("Date")<0){				
//				alert("idString="+idString+",value.value="+value.value);
				param.push({name:idString, value:value.value});
				
			}else{
//				param.push({name:idString+"Time", value:toRocDateTTT(value.value)});
			}
		});
	}else if(slType=='L'){
		$tmpEle = $(".beanBar input, .longBar input, .longBar select");
		$tmpEle.each(function(index, value){
			var idString = value.id;
			idString = idString.replace("_", ".");
			if(idString.indexOf("Date")<0){				
//				alert("idString="+idString+",value.value="+value.value);
				param.push({name:idString, value:value.value});
			}else{
				param.push({name:idString+"Time", value:toRocDateTTT(value.value)});
			}
		});
	}
	
	return param;
}

/**
 * beforeViewReportEvent add Form
 */
function beforeValiationEvent(){
	
}

/**
 * 回到上一個畫面
 * @returns {Function}
 */
function exitEvent(){
	return function(){		
		$(".shortBar, .longBar, .resignA, .resignB, .resignE").hide();
		$(".progMain, #postForm").show();
		$(".resignA, .resignB, .resignE").hide();
		showStatusMsg('ok', '');
//		$("#queryButton").trigger('click');
	};
//	return function(){
//		window.history.go(-1);
//	};
}


function showViewBanWithName($slClass, ban, banName){
	$("#view_ban", $slClass).val(ban);
	$("#view_banName", $slClass).val(banName);
}

/**------------------------Grid使用的Formatter-------------------------*/

/**
 * 第一個新增欄位的資料顯示
 * @param value
 * @param opts
 * @param rowObject
 * @returns
 */
function add1Formatter( value, opts, rowObject ){ 
	var ans = "&nbsp;";
	
    if( value == undefined || value == null || value == '' ) 
    	ans = '&nbsp;';
    
    var userType = $("#userBean_userType").val();
    var confirmType = rowObject.CONFIRM_TYPE;
    
//    alert('userType='+userType+',confirmType='+confirmType);
    
    if( confirmType == 'A' && (userType=="A"||userType=="C"))
    	ans = "接受/拒絕";
    if( confirmType == 'B' && (userType=="D"))
    	ans = "接受/拒絕";//btnB
    
    if( confirmType == 'B' && (userType=="A"||userType=="C"))
    	ans = "修改/刪除";//btnA
    if( confirmType == 'A' && (userType=="D"))
    	ans = "修改/刪除";
    
    if( confirmType == 'C' || confirmType == 'D' || confirmType == 'E' )
		ans = "查看";
    
    return ans;
}

/**測試用(未來將移至公用區)*/


