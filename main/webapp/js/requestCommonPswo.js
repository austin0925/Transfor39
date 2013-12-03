/**
 * 給定Ban和物件，會回傳BanName和同時進行$showEle.val()的設定
 * @param ban
 * @param $showEle
 */
function banEvent($banEle, $showEle, $showAddrEle, $showTelEle){
	var ans = "";
	var ban = $banEle.val();
	if(!isUndefinedOrNull(ban) && ban.length==8){			
		$.post('WJA03!getCSBCOMM', {'pageBean.ban':ban}, function(json){
			
			ans = json.data.cname;
			if(isUndefinedOrNull(ans)  || ans =='查無資料'){
				ans="";
				showStatusMsg('ng', '該統編無公司資料');
				$showEle.val(ans);
				$showAddrEle.val("");
				$showTelEle.val("");
			}else{					
				showStatusMsg('ok', '');
				$showEle.val(ans);
				if(typeof $showAddrEle!='undefined' || typeof $showAddrEle!=null || typeof $showAddrEle.val()!='undefined'){						
					$showAddrEle.val(json.data.brokerAddr);
				}
				if(typeof $showTelEle!='undefined' || typeof $showTelEle!=null || typeof $showTelEle.val() != 'undefined'){						
					$showTelEle.val(json.data.broboxMfgTelkerName);
				}
//					$showAddrEle.val(json.data.brokerAddr);
//					$showTelEle.val(json.data.broboxMfgTelkerName);
			}
		});
	}else if(isUndefinedOrNull(ban) || ban.length==0){
		showStatusMsg('ok', '');
		$showEle.val('');
	}else{
		showStatusMsg('ng', '統編格式錯誤');
		$showEle.val('');
	}
	return ans;
}


/**
 * 給定box取得BOXNAME
 * @param box
 */
function boxEvent($boxEle, $customEle, $showEle, $showAddrEle, $showTelEle){
	var ans = "";
	var box = $boxEle.val();
	var custom = $customEle.val();
//	alert('box='+box+',custom='+custom);
	if(!isUndefinedOrNull(box)	&& 	box.length==3
			&& !isUndefinedOrNull(custom) && custom.length==2){	
		$.post('WJA03!getCSBBOXM', {'pageBean.ban':box, 'pageBean.custCd':custom}, function(json){
			
			ans = json.data.brokerName;
			//brokerAddr
			//boxMfgTel
			if(isUndefinedOrNull(ans)  || ans =='查無資料'){
				ans="";
				showStatusMsg('ng', '該箱號無報關業者資料');
				$showEle.val(ans);
				$showAddrEle.val("");
				$showTelEle.val("");
			}else{					
				showStatusMsg('ok', '');
				$showEle.val(ans);
				if(typeof $showAddrEle!=null || typeof $showAddrEle!='undefined' || typeof $showAddrEle.val()!='undefined'){						
					$showAddrEle.val(json.data.brokerAddr);
				}
				if(typeof $showTelEle!=null ||typeof $showTelEle!='undefined' || typeof $showTelEle.val() != 'undefined'){						
					$showTelEle.val(json.data.broboxMfgTelkerName);
				}
			}
		});
	}else if(isUndefinedOrNull(box) || box.length==0
			|| isUndefinedOrNull(custom) || custom.length==0){
		showStatusMsg('ok', '');
		$showEle.val('');
	}else{
		showStatusMsg('ng', '箱號或關別格式錯誤');
		$showEle.val('');
	}
}


/**
 * 關別Formatter
 * @param value
 * @param opts
 * @param rowObject
 * @returns
 */
function customsFormatter( value, opts, rowObject ){ 
	console.log("requestCommonPwso.customsFormatter|[95]value="+value);
	var ans = '&nbsp;';
	if( 'AA'==value || 'A' == value)
		ans = "基隆關";
	if( 'BA'==value || 'B' == value )
		ans = "高雄關";
	if( 'CA'==value || 'C' == value )
		ans = "台北關";
	if( 'DA'==value || 'D' == value )
		ans = "台中關";
	return ans;
}

/**
 * Grid使用的Formatter
 */
function applyTypeFormatter( value, opts, rowObject ){ 
    var ans = "&nbsp;";
	if( 'I'==value )
		ans = "進口";
    if( 'E'==value )
    	ans = "出口";
    if( 'T'==value )
    	ans = "轉運";
	return ans;
}

/**
 * Grid使用的Formatter
 */
function transTypeFormatter( value, opts, rowObject ){ 
	var ans ="&nbsp;";
    if( 'A'==value ){    	
    	ans = "空運";
    }
    if( 'S'==value ){    	
    	ans = "海運";
    }
    if( 'T'==value )
    	ans = "轉運";
	return ans;
}

/**
 * 第一個新增欄位的資料顯示
 * A 待廠商接受委任
	B 待報關業者接受委任
	C 廠商拒絕報關業者委任
	D 報關業者拒絕廠商委任
	E 已建立委任關係

 * @param value
 * @param opts
 * @param rowObject
 * @returns
 */
function confirmTypeFormatter( value, opts, rowObject ){ 
	var ans = "&nbsp;";
	
    if( value == undefined || value == null || value == '' ) 
    	ans = '&nbsp;';
    
    if( rowObject.CONFIRM_TYPE == 'A' )
		ans = "A.待廠商接受委任";
    if( rowObject.CONFIRM_TYPE == 'B' )
		ans = "B.待報關業者接受委任";
    if( rowObject.CONFIRM_TYPE == 'C' )
		ans = "C.廠商拒絕報關業者委任";
    if( rowObject.CONFIRM_TYPE == 'D' )
		ans = "D.報關業者拒絕廠商委任";
    if( rowObject.CONFIRM_TYPE == 'E' )
		ans = "E.已建立委任關係";
    
    return ans;
}

//agentTypeFormatter
/**
 * 關別agentTypeFormatter
 * @param value
 * @param opts
 * @param rowObject
 * @returns
 */
function agentTypeFormatter( value, opts, rowObject ){ 
	var ans = '&nbsp;';
	if( '5'==value )
		ans = "保稅監管";
	if( '7'==value )
		ans = "船公司";
	if( '8'==value )
		ans = "進出口商";
	if( '9'==value )
		ans = "個人";
	return ans;
}


/**
 * 取得關別名稱
 * @param customs
 * @returns {String}
 */
function getCustomsName(customs){
//	alert(customs);
	var ans = "";
	if(isUndefinedOrNull(customs)){
		ans = "無法取得";
	}else{
		ans = "AA"==customs?"基隆關"
				:"BA"==customs?"高雄關"
						:"CA"==customs?"台北關"
								:"DA"==customs?"台中關":"關別錯誤";
	}
	return ans;
}

/**
 * set設定就是要提供元素，get就是提供value。
 * @param $fromEle
 * @param $toEle
 */
function setCustomsName($fromEle, $toEle){
//	alert(getCustomsName($fromEle.find(":checked").val()));
	$toEle.val(getCustomsName($fromEle.find(":checked").val()));
}

/**公用預備用*/
/**
 * 給定一個className，會去掃描相關的className下的欄位，進行設定。
 * 需考慮textfield and dropDownList and radio button
 * 
 * TODO: radio button 尚未測試成功
 * 
 * @param $fieldEle
 * @param beanName
 * @param rowData
 */
function setFieldFromJsonTTT($fieldEle, beanName, rowData){
//	alert('set...');
	$.each(rowData, function(index, value){
		var $tmpEle = $fieldEle.find("#"+beanName+"_"+index);
		$tmpEle.val(value); 
			
//		alert('1.index='+index+',html='+$tmpEle.html()+',value='+value);
		
		$filterTmp = $("option", $tmpEle).filter(function(){
//			alert('2.this='+$(this).html()+',text='+$(this).text()+',indexOf='+$(this).text().indexOf(value));
			if($(this).text().indexOf(value)>=0){
				return $(this);
			}
//			return $(this).text() == value;
		});
//		alert('3.'+$filterTmp.html());
		$filterTmp.attr("selected", true);
		
	});
}

var optionContainer={};
/**
 * 可以設定Select物件是否唯讀，當中的暫時移除的物件會放至於optionContainer當中。
 * @param obj Select的物件
 * @param readonly 設定是否設定成唯讀。
 */
function SetSelectReadOnlyTTT(obj, readonly){
//	alert('readonly='+readonly);
    if(obj){
    	var id = $(obj).attr('id');
    	if (readonly) {
    		if ( ! optionContainer[id]) {
    			optionContainer[id] = $(obj).html();
    		}
    		$('option:not(:selected)', $(obj)).each(function(index, value){
    			$(value).remove();
    		});
    	} else if (optionContainer[id]){
    		$(obj).find('option').remove().end().append(optionContainer[id]);
    	} else {
    		alert('no html!obj='+obj+',readonly='+readonly);
    	}
        
    }
}

/**(需移入公用requestParameter.sj)
 * 把西元年轉換成民國年
 * @param adDate
 * @returns
 */
function toRocDateTTT(adDate){
	var index = adDate.indexOf("/");
//	alert(index);
	if(index>=4){
		var year = adDate.substring(0, index);
		var dateString = adDate.substring(index);
		year -= 1911;
		adDate = year+dateString;
//		alert(adDate.length);
		if(adDate.length>16){
			adData = adDate.subtring(0, 15);
		}
		if(adDate.length<10){
			adDate = adDate+" 00:00";
		}
	}
	if(index==3){
		if(adDate.length<10){
			adDate += " 00:00";
		}
		if(adDate.length>16){
			adDate = adDate.substring(0, 15);
		}
	}
//	alert(adDate);
	return adDate;
}