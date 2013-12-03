
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
	
}

/**
 * 取得文案內容的方法
 * @param param 提供
 * 	brokerName
 * 	declNo
 * 	cumtoms
 * 	agentCompanyName
 * 	agentBan
 * @returns {String}
 */
function getTextAreaString(){
	
	var textAreaString="為辦理貨物通關作業需要，茲依關稅法第22條第１項規定，委任受任人（上述報關業者），代為辦理如上述所載貨物通關過程中依規定應為之各項手續，受任人對之均有為一切行為之權，並包括：簽認查驗結果、繳納稅費、提領進口貨物、捨棄、認諾、收受　貴關有關本批貨物之一切通知與稅費繳納證等文件(或訊息)、領取報關貨物之貨樣，以及辦理出口貨物之退關、退關轉船、提領出倉等之特別委任權。";
	
	return textAreaString;
}

function addChecker(){
	var msg = "";
	
	if(isUndefinedOrNull($("#pageBean_0__ban").val())||$("#pageBean_0__ban").val().length!=8){	
		msg += "請輸入統一編號";
	}
	//
	//此為空運報單，但目前選擇海運，是否繼續處理?C, BF

	var value = $("#userBean_customsOffice").val();
	var key0 = $("#pageBean_0__declNo").val().substring(0,1);
	var key1 = $("#pageBean_1__declNo").val().substring(0,1);
	var key2 = $("#pageBean_2__declNo").val().substring(0,1);
	var key3 = $("#pageBean_3__declNo").val().substring(0,1);
	var key4 = $("#pageBean_4__declNo").val().substring(0,1);
	
	var transType0 = $("#pageBean_0__transType").val();
	var transType1 = $("#pageBean_1__transType").val();
	var transType2 = $("#pageBean_2__transType").val();
	var transType3 = $("#pageBean_3__transType").val();
	var transType4 = $("#pageBean_4__transType").val();
	
	var keyB0 = $("#pageBean_0__declNo").val().substring(0,2);
	var keyB1 = $("#pageBean_1__declNo").val().substring(0,2);
	var keyB2 = $("#pageBean_2__declNo").val().substring(0,2);
	var keyB3 = $("#pageBean_3__declNo").val().substring(0,2);
	var keyB4 = $("#pageBean_4__declNo").val().substring(0,2);
	
//	alert('value='+value+',key0='+key0);
	
	if(!isUndefinedOrNull(value)){
		
		if(!isUndefinedOrNull(key0) && value!=key0)
			msg += "[第一項報單號碼輸入不正確]";
		if(!isUndefinedOrNull(key1) && value!=key1)
			msg += "[第二項報單號碼輸入不正確]";
		if(!isUndefinedOrNull(key2) && value!=key2)
			msg += "[第三項報單號碼輸入不正確]";
		if(!isUndefinedOrNull(key3) && value!=key3)
			msg += "[第四項報單號碼輸入不正確]";
		if(!isUndefinedOrNull(key4) && value!=key4)
			msg += "[第五項報單號碼輸入不正確]";
	}
	
	return msg;
}

function addButton(){
	return function(param){
		if(showChecker(addChecker())){
			
			var param = $("#postForm").serializeArray();
			
			$.post("WJA01!add", param, function(data){
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
//			alert('clear click..');
			$("#pageBean_0__ban").val("");
			$("#pageBean_0__banName").val("");
			$tmpEle = $(
					 ".mainUI #pageBean_0__transType, .mainUI #pageBean_0__applyType, .mainUI #pageBean_0__declNo, .mainUI #pageBean_0__agentCd"
					+",.mainUI #pageBean_1__transType, .mainUI #pageBean_1__applyType, .mainUI #pageBean_1__declNo, .mainUI #pageBean_1__agentCd"
					+",.mainUI #pageBean_2__transType, .mainUI #pageBean_2__applyType, .mainUI #pageBean_2__declNo, .mainUI #pageBean_2__agentCd"
					+",.mainUI #pageBean_3__transType, .mainUI #pageBean_3__applyType, .mainUI #pageBean_3__declNo, .mainUI #pageBean_3__agentCd"
					+",.mainUI #pageBean_4__transType, .mainUI #pageBean_4__applyType, .mainUI #pageBean_4__declNo, .mainUI #pageBean_4__agentCd");
			$tmpEle.val("");
			$tmpEle.find("select option:first-child").attr("selected", true);
		}else if(userType=="A" || userType=="C"){
			clearArea(".content");
		}else{			
			clearArea(".content");
		}
	};
}

