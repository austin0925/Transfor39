
function documentReady(){
	
	var userType = $("#userBean_userType").val(); 
	var box = $("#userBean_brokerBoxNo").val();
	var customs = $("#userBean_customsOffice").val()+"A";
	
	if("A"==userType||"C"==userType){
		
		$("#pageBean_0__ban").val($("#userBean_consignId").val());
		$("#pageBean_0__ban").attr('class', 'read');
		$("#pageBean_0__ban").attr('readonly', 'readonly');

		$.post('WJA01!getUserInfo', $("#postForm").serialize(), function(data){
			$("#pageBean_0__banName").val(data.data.cname);
		});
		$("#pageBean_0__banName").attr('class', 'read');
		$("#pageBean_0__banName").attr('readonly', 'readonly');

	}else if("D"==userType){
		
		$("#pageBean_0__brokerBoxNo").val(box);
		$("#pageBean_0__brokerBoxNo").attr('class', 'read');
		$("#pageBean_0__brokerBoxNo").attr('readonly', 'readonly');
		$("#pageBean_1__brokerBoxNo").val(box);
		$("#pageBean_1__brokerBoxNo").attr('class', 'read');
		$("#pageBean_1__brokerBoxNo").attr('readonly', 'readonly');
		$("#pageBean_2__brokerBoxNo").val(box);
		$("#pageBean_2__brokerBoxNo").attr('class', 'read');
		$("#pageBean_2__brokerBoxNo").attr('readonly', 'readonly');
		$("#pageBean_3__brokerBoxNo").val(box);
		$("#pageBean_3__brokerBoxNo").attr('class', 'read');
		$("#pageBean_3__brokerBoxNo").attr('readonly', 'readonly');
		$("#pageBean_4__brokerBoxNo").val(box);
		$("#pageBean_4__brokerBoxNo").attr('class', 'read');
		$("#pageBean_4__brokerBoxNo").attr('readonly', 'readonly');
		
		
		//customsDropDownList
		$.selectEle = $("#pageBean_0__customs" +
				", #pageBean_1__customs" +
				", #pageBean_2__customs" +
				", #pageBean_3__customs" +
				", #pageBean_4__customs");
		$.selectEle.val(customs);
		$.selectEle.attr('class', 'read');
		$.selectEle.attr('readonly', 'readonly');
		$.selectEle.find("option:not(:selected)").each(function(index,ele){
			$(ele).remove();
		});
		
	}

	$("#pageBean_0__declNo, #pageBean_1__declNo, #pageBean_2__declNo, #pageBean_3__declNo, #pageBean_4__declNo" +
			",#pageBean_0__agentCd ,#pageBean_1__agentCd ,#pageBean_2__agentCd ,#pageBean_3__agentCd ,#pageBean_4__agentCd "
			).keypress(function(e){
//		alert('如果輸入了非0-9, a-z, A-Z，則return false，但用貼上則沒用');
	    if((e.shiftKey && e.keyCode == 45) 
	    		||e.which!=8 && e.which!=0 &&  
	        !(
	            (e.which>=48 && e.which<=57)
	            ||(e.which==32)
//	            ||(e.which==44)||(e.which==45)
	            ||(e.which>64 && e.which<91)  
	            ||(e.which>=97 && e.which<=122)
	        )
	    ){
	    	showStatusMsg('ng', '[請輸入英數字或空白]');
	        return false;
	    }
     	$(this).val($(this).val().toUpperCase());
	});


	$('#pageBean_0__declNo, #pageBean_1__declNo, #pageBean_2__declNo, #pageBean_3__declNo, #pageBean_4__declNo'
			).blur(function(e){
		$(this).val($(this).val().toUpperCase());
	});
	
	//使用者指定要清除終止日期區間。
	$("#dateE").val("");
	
}

/**
 * 取得文案內容的方法
 * @param param 提供
 * 	brokerName
 * 	declNo
 * 	customs
 * 	agentCompanyName
 * 	agentBan
 * @returns {String}
 */
function getTextAreaString(){
	
	var textAreaString=
		"為辦理進口、出口、轉運（口）貨物通關作業需要，茲依關稅法第22條第１項規定，委任受任人（報關業者）上述報關業者　自上述期間，代為辦理通關過程中依規定應為之各項手續，受任人對之均有為一切行為之權，並包括：簽認查驗結果、繳納稅費、提領進口貨物、捨棄、認諾、收受　貴關有關報關貨物之一切通知與稅費繳納證等文件(或訊息)、領取報關貨物之貨樣，以及辦理出口貨物之退關、退關轉船、提領出倉等之特別委任權。委任人如嗣後擬對受任人之權限加以限制或予終止委任時，應先以書面通知　貴關，經　貴關更新委任資料後始發生效力，否則不得以其事項對抗 貴關。"
	;
	
	return textAreaString;
}

function addChecker(){
	var ans = "";
	
	var checkValue = $("#pageBean_0__ban").val();
	if(isUndefinedOrNull(checkValue)|| checkValue.length!=8){		
		ans += "請輸入正確統一編號";
	}
	
	var value = $("#userBean_customsOffice").val();
//	var key0 = $("#pageBean_0__declNo").val().substring(0,1);
//	var key1 = $("#pageBean_1__declNo").val().substring(0,1);
//	var key2 = $("#pageBean_2__declNo").val().substring(0,1);
//	var key3 = $("#pageBean_3__declNo").val().substring(0,1);
//	var key4 = $("#pageBean_4__declNo").val().substring(0,1);
//	
////	alert('value='+value+',key0='+key0);
//	
//	if(!isUndefinedOrNull(value)){
//		
//		if(!isUndefinedOrNull(key0) && value!=key0)
//			ans += "[第一項報單號碼輸入不正確]";
//		if(!isUndefinedOrNull(key1) && value!=key1)
//			ans += "[第二項報單號碼輸入不正確]";
//		if(!isUndefinedOrNull(key2) && value!=key2)
//			ans += "[第三項報單號碼輸入不正確]";
//		if(!isUndefinedOrNull(key3) && value!=key3)
//			ans += "[第四項報單號碼輸入不正確]";
//		if(!isUndefinedOrNull(key4) && value!=key4)
//			ans += "[第五項報單號碼輸入不正確]";
//	}
	
	return ans;
}

function addButton(){
	return function(){
		
		var param = $("#postForm").serializeArray();
		
		addParamSafty(param, "pageBean[0].customs", $("#pageBean_0__customs").val());
		addParamSafty(param, "pageBean[1].customs", $("#pageBean_1__customs").val());
		addParamSafty(param, "pageBean[2].customs", $("#pageBean_2__customs").val());
		addParamSafty(param, "pageBean[3].customs", $("#pageBean_3__customs").val());
		addParamSafty(param, "pageBean[4].customs", $("#pageBean_4__customs").val());
		
		if(showChecker(addChecker())){			
			$.post("WJA02!add", param, function(data){
				showStatusMsg(data.status, data.msg);
			});
		}
	};
}

function clearButton(){
	return function(){		
		var userType = $("#userBean_userType").val();
//		alert('userType='+userType);
		if(userType=="D"){
			
			//如果使用者是報關行，則有些資料不可以清除。
			
			//特定排除使用者欄位
			$("#pageBean_0__agentCd").val("");
			$("#pageBean_1__agentCd").val("");
			$("#pageBean_2__agentCd").val("");
			$("#pageBean_3__agentCd").val("");
			$("#pageBean_4__agentCd").val("");
			//指定清除非使用者欄位
			$("#pageBean_0__ban").val("");
			$("#pageBean_0__banName").val("");
		}else{
			//清除前記錄日期資料，清除後回寫日期資料。
			var dateS = $("#dateS").val();
			var dateE = $("#dateE").val();
			clearArea(".content");
			$("#dateS").val(dateS);
			$("#dateE").val(dateE);
		}
		$("#statusMsg").val();
	};
}

/**
 * 按下一般進出口商的radio button 變更顯示方式
 * @returns {Function}
 */
function type8Event(){
	return function(){
		var value = $(".type8Event:checked").val();
		if(value==8){
			$(".agentCdType").hide();
		}else{
			$(".agentCdType").show();
		}
	};
}

function getUserData(){
	return function(){
//		$.post("WJA01!getUserInfo", $("#postForm").serialize(), function(data){
//			showStatusMsg(data.status, data.msg);
//			/*進行欄位的setter*/
//			
//			$("#userBean")
//			
//			
//		});
		alert(
			'userBean_id='+$("#userBean_id").val()
			+',userBean_ban='+$("#userBean_ban").val()
			+',userBean_name='+$("#userBean_name").val()
			+',userBean_type='+$("#userBean_type").val()
		);
	};
}