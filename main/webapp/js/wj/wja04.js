var userType ="";
var ban = "";
var banName = "";
var box = "";
var boxName = "";
	

function documentReady(){
	
	
	var userType = $("#userBean_userType").val();//取得使用者類型
	var ban = $("#userBean_consignId").val();//取得使用者類型
	var banName = $("#userBean_companyName").val();//取得BanName
	var box = $("#userBean_brokerBoxNo").val();//取得使用者類型
	var boxName = $("#userBean_companyName").val();//取得BoxName
	var custcoms = $("#userBean_customsOffice").val()+"A";
	
	if(userType=="A"||userType=="C"){
		$("#wjagnmmBean_ban").val(ban);
		$("#wjagnmmBean_ban").attr('class', 'read');
		$("#wjagnmmBean_ban").attr('readonly', 'readonly');
		$("#wjagnmmBean_banName").val(banName);
	}
	if(userType=="D"){
		$("#wjagnmmBean_brokerBoxNo").val(box);
		$("#wjagnmmBean_brokerBoxNo").attr('class', 'read');
		$("#wjagnmmBean_brokerBoxNo").attr('readonly', 'readonly');
		$("#wjagnmmBean_boxName").val(boxName);
//		alert(custcoms+'7');
		$("#wjagnmmBean_customs").children().each(function(index, value){
//			alert("index="+index+',value='+value+',value.value='+value.value);
			if(value.value==custcoms){
				$(this).attr("selected", "true");
			}
		});
		SetSelectReadOnly($("#wjagnmmBean_customs"), true);
	}
	
	$("#wjagnmmBean_agentCd").keypress(function(e){
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


	$('#wjagnmmBean_agentCd'
			).blur(function(e){
		$(this).val($(this).val().toUpperCase());
	});
	
}

/**
 * 基本的grid查詢功能
 * @returns {Function}
 */
function queryEvent(){
	return function(){
		queryGrid("WJA04!query", "#masterGrid"
				, {rows:$("select[class='ui-pg-selbox']").val()});
	};
}


/**
 * 清除按鈕
 * @returns {Function}
 */
function clearEvent(){
	var $clearEle;
	if($("#userBean_userType").val()=="D"){
		$clearEle = $("#wjagnmmBean_ban" +
				", #wjagnmmBean_banName" +
				", #wjagnmmBean_assignBegDate" +
		", #wjagnmmBean_assignEndDate" +
		", #wjagnmmBean_agentCd");
	}else{
		$clearEle = $("#wjagnmmBean_brokerBoxNo" +
				", #wjagnmmBean_boxName" +
				", #wjagnmmBean_assignBegDate" +
		", #wjagnmmBean_assignEndDate" +
		", #wjagnmmBean_agentCd");
		$("#wjagnmmBean_customs").children("option:first-child").attr("selected", "true");
	}
	$clearEle.val("");
}

/**
 * Y-線上, null-紙本
 * @param value
 * @param opts
 * @param rowObject
 * @returns
 */
function webCreateNoteFormatter( value, opts, rowObject ){ 
	var ans = "線上";
//	alert(rowObject.SL_TYPE);
    if( value == undefined || value == null || value == '') 
    	ans = '紙本';
    if( rowObject.SL_TYPE=="個案"){
    	ans = "線上";
    }
	return ans;//toTwDate( value );
}