//path	=	PACS/src/main/webapp/js/requestParamAPCS.js

				
var debug = false;

var requestHeader = [];				

function setRequestHeader(beanName, rowData){
	
	if(debug)alert('requestHeader.length='+requestHeader.length);
	
	requestHeader = [];
	
	if(rowData != null){
		
		$.each(rowData, function(index, values){
			
			var javaWords = beanName + "." +toJavaWord( index );
			
			if(typeof(values)=='undefined'||typeof(values)=='object'){			
			}else{
//			alert(javaWords.indexOf("Date"));
				if((javaWords.indexOf("dateTime")<0 && javaWords.indexOf("date")>=0)
						||(javaWords.indexOf("DateTime")<0 && javaWords.indexOf("Date")>=0)
				){
					requestHeader.push({name: javaWords+"Time",value: toRocDate(values)});
				//financialCenter1stdateTime
				}else if(javaWords.indexOf("financialCenter1stdateTime")>=0){
					requestHeader.push({name: "exzhawdBean.financialCenter1stdate",value: toRocDate(values)});
				}else if(javaWords.indexOf("financialCenter2nddateTime")>=0){
					requestHeader.push({name: "exzhawdBean.financialCenter2nddate",value: toRocDate(values)});
				}else{				
					requestHeader.push({name: javaWords,value: values});		
				}
			}
			
		});
	}
	
//	var outObj = $.param(requestHeader);
	
	if(debug)alert('setRequestHeader|beanName='+beanName
			
			+',requestHeader='+requestHeader);
	
	return requestHeader;
	
}

function setRequestHeaderWithoutToJavaWord(beanName, rowData){
	
	if(debug)alert('requestHeader.length='+requestHeader.length);
	
	requestHeader = [];
	
	$.each(rowData, function(index, values){
		
		var javaWords = beanName + "." + index ;
		
		if((javaWords.indexOf("dateTime")<0 && javaWords.indexOf("date")>=0)
				||(javaWords.indexOf("DateTime")<0 && javaWords.indexOf("Date")>=0)
				){
			requestHeader.push({name: javaWords+"Time",value: toRocDate(values)});
		}else if(javaWords.indexOf("financialCenter1stdateTime")>=0){
			requestHeader.push({name: "exzhawdBean.financialCenter1stdate",value: toRocDate(values)});
		}else if(javaWords.indexOf("financialCenter2nddateTime")>=0){
			requestHeader.push({name: "exzhawdBean.financialCenter2nddate",value: toRocDate(values)});
		}else{				
			requestHeader.push({name: javaWords,value: values});		
		}
		
	});
	
//	var outObj = $.param(requestHeader);
	
	if(debug)alert('setRequestHeader|beanName='+beanName
			
			+',requestHeader='+requestHeader);
	
	return requestHeader;
	
}

function getRequestHeader(){
	
	if(debug)alert('getRequestHeader|requestHeader='+requestHeader);
	
	return requestHeader;
	
}

function toJavaWord(underLineWord){
	
	var javaWord = "";
	
	var wordArray = underLineWord.toLowerCase().split('_');
	
	$.each(wordArray, function(index, value){
		if(index==0){
			javaWord += value;
		}else{
			javaWord += value.toString().substring(0, 1).toUpperCase()+value.toString().substring(1);
		}
		
	});
	
	if(debug)alert(underLineWord+'--change->'+javaWord+',');
	
	return javaWord;
}

/**
 * 把rowData裡面的Key轉成javaWord
 * @param rowData
 * @returns {Array}
 */
function toJavaWordKey(rowData){
	
	var param = {};
	
	$.each(rowData, function(index, value){
		var keyString = toJavaWord(index);
		var valueString = value;
		param[keyString] = valueString;
	});
	
	return param;
}

/**
 * 把DataObject的資料，用Keys, Values包起來進行array的設定。
 * @param dataObject
 * @returns {Array}
 */
function getKeyValueJsonFromDataObject(dataObject){
	var param = {};
	
	if(typeof dataObject == 'undefined' || typeof dataObject.keys == 'undefined' || dataObject.keys.length == 0){
		//do nothing
	}else{
		var len = dataObject.keys.length;
		for(var idx = 0; idx < len; idx++){
			var keys = dataObject.keys[idx];
			var values = dataObject.values[idx];
//			alert(keys +":"+ values);
			param[keys]=values;
		}
	}
	
	return param;
}

function toUnderLineRowData(rowData){
	
	var rowValue = [];
	
	var length = rowData.keys.length;
	
	for(var index = 0; index<length; index++){
		rowValue.push(rowData.keys[index], rowData.values[index]);
	}
	
	if(debug)alert('toUnderLineRowData|rowValue='+$.makeArray ( rowValue )   );
	
	return $.makeArray ( rowValue );
}

function toUnderLineWord(javaWord){
	
	var underLineWord = "";
	
	javaWord= trimWord(javaWord);
	
	var javaWordArray = javaWord.split('');
	
	$.each(javaWordArray, function(index, value){
		if(value.charCodeAt()>=65 && value.charCodeAt()<=95){
			underLineWord+='_'+value;
		}else{
			underLineWord+=value;
		}
	});
	
	return underLineWord.toUpperCase();
}

/**
 * 重複性的過慮文字
 * @param str
 * @returns str.slice(start, end + 1);
 */
function trimWord(str){
	var start = -1,
	end = str.length;
	while (str.charCodeAt(--end) < 33);
	while (str.charCodeAt(++start) < 33);
	return str.slice(start, end + 1);
}
	
/**
 * 安全的加入name and Value 到 param 當中。
 * @param param
 * @param name
 * @param value
 */
function addParamSafty(param, key, value){
	var index = 0;
	if (typeof param !='undefined') {
		//page added for formData
		for (index = 0; index < param.length; ++index) {
		    if (param[index].name == key) {
		    	param[index].value = value;
		        break;
		    }
		}
		// Add it if it wasn't there
		if (index >= param.length) {
			param.push({	name: key, value: value	});
		}
	}
	return param;
}
	
/**
 * 把西元年轉換成民國年
 * @param adDate
 * @returns
 */
function toRocDate(adDate){
	if(!isUndefinedOrNull(adDate) && typeof adDate != 'boolean'){
		console.log('requestParameter.toRocDate|adDate is not undefined or null. adDate='+adDate +', typeof adDate='+typeof adDate);

		var index = Math.max(adDate.indexOf("/"), adDate.indexOf("-"));
//		alert(index);
		if(index>=4){
			var year = adDate.substring(0, index);
			var dateString = adDate.substring(index);
			year -= 1911;
			adDate = year+dateString;
//		alert(adDate.length);
			if(adDate.length>16){
				adData = adDate.substring(0, 15);
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
//		alert(adDate);
	}else{
		console.log('requestParameter.toRocDate|adDate is undefined or null. adDate='+adDate +', typeof adDate='+typeof adDate);
	}
	return adDate;
}

/**
 * 把rowData裡面有關於Date的資料統一轉成RocDateTime。
 * 然後回傳rowData出去
 * @param rowData
 */
function toRocDateRow(rowData){
	var msg = '';
	$.each(rowData, function(index, value){
		msg += ',index='+index+',value='+value;
		if(		(index.indexOf('date')>=0 && index.indexOf('dateTime')<0)
			||	(index.indexOf('Date')>=0 && index.indexOf('DateTime')<0)
			||	(index.indexOf('financialCenter1stdatetime')>=0)
			||	(index.indexOf('financialCenter2nddatetime')>=0)
				){			
			index = index+'Time';
			value = toRocDateTTT(value);
		}
	});
	console.log(msg);
	return rowData;
}

/**
 * filterCommonArray 說明：把String用逗號格開，並且取得逗號格開後的字串。 <br>
 * @param arrayString
 * @return <br>
 * @author game<br>
*/
function filterCommonArray(arrayString, index, defaultValue){
	var ans = defaultValue;
	if(arrayString==null || arrayString==""){
	}else{
		var temp = arrayString.split(",");
		if(temp.length>index){
			ans = temp[index];
		}
	}
	return ans;
}

/**
 * 依照提供的訊息顯示錯誤訊息
 * @param msg
 * @returns {Boolean}
 */
function showChecker(msg){
	if(isUndefinedOrNull(msg)){
		return true;
	}else{
		showStatusMsg('ng', msg);
		return false;
	}
}


/**測試用(未來將移至公用區)*/
/**
 * 給定一個className，會去掃描相關的className下的欄位，進行設定。
 * 需考慮textfield and dropDownList and radio button
 * 
 * TODO: radio button 尚未測試成功 [select OK!!]
 * 
 * @param $fieldEle
 * @param beanName
 * @param rowData
 */
function setFieldFromJson($fieldEle, beanName, rowData){
//	alert('set...');
	$.each(rowData, function(index, value){
		var $tmpEle = $fieldEle.find("#"+beanName+"_"+index);
		$tmpEle.val(value); 
		
		$filterTmp = $("option", $tmpEle).filter(function(){
			if($(this).text().indexOf(value)>=0){
				return $(this);
			}
		});
		$filterTmp.attr("selected", true);
		
	});
}

/**
 * 把整個rowData內部的值做個轉換
 * @param rowData
 */
function getADStringFromRocDateStringByRowData(rowData){
	
	var param = {};
	 
	var msg = "";
	$.each(rowData, function (index, value) {
		var keyString = index;
		var valueString = value;
		param[keyString] = getADStringFromRocDateString(valueString);
		msg += index+"="+value+',';
	});
//	alert(msg);
	return param;
}

/**
 * getADStringFromRocDateString 說明： 依照傳入的rocDateString以"/"切成String[]<br>
 * 若切割有問題會進行空字串回傳。若接收到空字串需要進來修正....<br>
 * @param rocDateString
 * @return String rocDateString=>代表有問題；2012/01/01=>代表正確<br>
 * @author game<br>
*/
function getADStringFromRocDateString(rocDateString){
//	alert(rocDateString);
	var ans = rocDateString;
	var ansYear = "";
	var ansMonth = "";
	var ansDay = "";
	var inString = rocDateString.split("/");
	
//	alert(rocDateString);
	
	if(inString.length == 3){
		ansYear = inString[0];
		ansMonth = inString[1];
		ansDay = inString[2];
		
		var intYear = 0;//ansYear%1911;
		ansYear = intYear+1911;
		
		if(!isUndefinedOrNull(ansMonth) && ansMonth.length==1){
			ansMonth = '0'+ansMonth;
		}
		
		if(!isUndefinedOrNull(ansDay) && ansMonth.length==1){
			ansDay = '0'+ansDay;
		}
		
		ans = ansYear + "/" +  ansMonth + "/" + ansDay;
	}			
	
//	alert(ans);
	
	return ans;
}

/**
 * Default Date 顯示
 * @param value
 * @param opts
 * @param rowObject
 * @returns
 */
function dateFormatterForDefault( value, opts, rowObject ){ 
    if( value == undefined || value == null || value == '' ) 
        return '&nbsp;';
    else if( value.length == 9 )
		return value;
    else
    	return toTwDateForDefault(	toTwDate( value )	);
}

/**
 * 把物件全部加上readonly屬性
 * @param $ele
 */
jQuery.fn.inputReadonly = function inputReadonly(){
	
	var $ele = $(this);//.logObj("requestParamAPCS.inputReadonly.427");
	
	if($ele.length==0	||	isUndefinedOrNull($ele)){
		console.log("inputReadonly($ele)|[SKIP]$ele is "+$ele+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return;
	}else{
		console.log("inputReadonly($ele)|[RUN]$ele.length="+$ele.length);
	}
	
	$.each($ele, function(index, value){
		
		if(value=='[object HTMLSelectElement]'){	
//			$selectedEle = $("option:selected", $(value));
//			$.each($selectedEle, function(index1, value1){
//				var ans = ',index1='+index1+',value1='+value1+',value1.value='+value1.value+",typeof="+typeof value1;
//				console.log("requestParamAPCS.readOnlyOn|ans1="+ans);
//			});
			$notSelectedEle = $("option:not(:selected)", $(value));
			$.each($notSelectedEle, function(index1, value1){
				$(value1).attr("disabled", "disabled");
				$(value1).attr("readonly", "readonly");
			});
		}
		
		if(value=='[object HTMLInputElement]'){	
			//依照不同的type，進行顯示設定。
			if("button"==value.type){
				$(value).attr("class", "btnFixed");
			}else if("checkbox"==value.type){
				//checkbox=>不要上黃色，不做設定。
			}else{
				//不是button的時候，才上class為read("黃色");
				$(value).attr("class", "read");
			}
//			$(value).attr("disabled", true);//此為灰色(不需要上灰色)
		}
		
		if(value=='[object HTMLTextAreaElement]'){
			$(value).attr("class", "read");
//			$(value).attr("disabled", true);//字樣會變成灰色(取消)
			$(value).attr("readonly", "readonly");
		}
	});
};

/**
 * 全部取消readonly屬性
 * @param $ele
 */
jQuery.fn.inputReadonlyOff = function inputReadonlyOff(){
	
	var $ele = $(this);//.logObj("requestParamAPCS.inputReadonlyOff.468");
	
	if($ele.length==0	||	isUndefinedOrNull($ele)){
		console.log("inputReadonlyOff($ele)|[SKIP]$ele is "+$ele+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return;
	}else{
		console.log("inputReadonlyOff($ele)|[RUN]$ele.length="+$ele.length);
	}

	$.each($ele, function(index, value){

		if(value=='[object HTMLSelectElement]'){
			$optionEld = $("option", $(value));
			$.each($optionEld, function(index1, value1){
				$(value1).removeAttr("disabled");
				$(value1).removeAttr("class");
			});
		}
		
		if(value=='[object HTMLInputElement]'){	
			if("button"==value.type){
				$(value).attr("class", "btnFixed");
			}else if("checkbox"==value.type){
				//checkbox=>不要上黃色，不做設定。
				$(value).removeAttr("class");
			}else{
				//不是button的時候，才上class為read("黃色");
				$(value).removeAttr("class");
			}
			$(value).attr("disabled", false);
			$(value).removeAttr("readonly");
		}
		
		if(value=='[object HTMLTextAreaElement]'){
			$(value).removeAttr("class");
			$(value).attr("disabled", false);
			$(value).removeAttr("readonly");
		}
	});
};

/**
 * Default Date 顯示
 * @param value
 * @returns
 */
function toTwDateForDefault( value ){
	console.log("requestParamAPCS.toTwDateForDefault()|valeu="+value);
	if(value == undefined || value == null || value == ''){
		return '&nbsp;';
	}else if( value.indexOf('-011/01/01') !== -1 ){
		return '&nbsp;';
	}else{
		return value;
	}
}


/**
 * 
 * @param msg
 * @returns {Boolean}
 */
function alertStatusMsg(msg){
	
	var nowString = getNowString();
	if(isUndefinedOrNull(msg)){
		var outMsg = '無錯誤訊息';
		console.log(nowString+'|requestParamAPCS.alertStatusMsg.531|[正確],outMsg='+outMsg);
//		showStatusMsg('ok', outMsg);
		return true;
	}else{		
		var outMsg = msg;
		console.log(nowString+'|requestParamAPCS.alertStatusMsg.537|[錯誤],outMsg='+outMsg);
		alert(outMsg);
		showStatusMsg('ng', outMsg);
		return false;
	}
}

/**
 * 如果logger參數等於debug的時候，就把msg顯示在console上。
 * @param key
 * @param logger
 */
jQuery.fn.logObj = function logObj(key){
	
	var nowString = getNowString();

	var msg = "["+key+"]";
	
	$.each($(this), function(index, value){
		msg += ",index="+index;
		msg += ",id="+$(value).attr("id");
		msg += ",val()="+$(value).val();
		msg += ",value="+value;
		msg += ",value.type="+value.type;
		msg += ",value.className="+value.className;
		msg += ",value.checked="+value.checked;
	});
	
	if(isUndefinedOrNull(key)){}else{		
		console.log("%s|%s", nowString, msg);
	}
	
	return $(this);	
};


/**
 * 取得時間字串
 * @returns {String}
 */
function getNowString(){
	var nowString = "";
	var now = new Date();
	nowString += now.getFullYear() + "-";
	nowString += now.getMonth() + "-";
	nowString += now.getDay() + " ";
	nowString += now.getHours() + ":";
	nowString += now.getMinutes() + ":";
	nowString += now.getSeconds() + " ";
	return nowString;
}

/**
 * 專門提供給declNoInput所使用的keyPressFuction
 * @returns {Function}
 */
function keypressRuleDeclNo(){
	return function(e){
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
	    }else{
	    	var value = $(this).val();
	    	value += String.fromCharCode(e.which);
	    	$(this).val(value.toUpperCase());
	    	return false;
	    };
	};
}

/**
 * 把一個物件吃下來之後，透過for 把 key = value & 接起來，並且使用encodeURI方法。
 * @param obj
 * @returns key=value&
 */
encodeUriSerialize = function encodeUriSerialize(obj) { 
	var str = []; 
	for(var p in obj) 
		str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p])); 
	return str.join("&"); 
};

/**
 * 透過boolean設定checkBox的值
 */
jQuery.fn.setCheckBoxWithBoolean = function setCheckBoxWithBoolean(isTrue){
	$(this).attr('checked',isTrue);//jquery pattern selector jsp javascript
};

/**
 * 透過Default取回checkBox的值
 */
jQuery.fn.getCheckBoxWithBoolean = function getCheckBoxWithBoolean(trueString, falseString){
	if($(this).prop("checked")){
		return isUndefinedOrNull(falseString)?true:falseString;
	}else{
		return isUndefinedOrNull(trueString)?false:trueString;
	}
};


/**
 * 開啟一個彈跳視窗詢問select的結果後，將值設定於$selectEle。
 * @param $selectEle
 */
jQuery.fn.popInputselect = function popInputselect($selectEle){
	if($selectEle.length == 0){
		$selectEle.logObj("[SKIP]$selectEle.length == 0 !!!!!!!!!!!!!"+$selectEle);
	}
	
};

/**
 * 將selectOption內的value或text做valueString比對，成功則設定為selected，不成功則取消selected設定。
 * @param valueString
 */
jQuery.fn.setInputselect1Obj = function setInputselect1Obj(valueString){
	if($(this).length==0){
		$(this).logObj("setInputselectObj|[SKIP]length==0!!!!!!!!!!!!!"
				+$(this));
		return ;
	}
	var $optionEle = $(this).children();
	$.each($optionEle, function (index, value){
		if(valueString == $(value).val()){
			$(value).attr("selected", "selected");
		}else{
			$(value).removeAttr("selected", "selected");
		}
	});
};

/**
 * 取得扔入物件的selected的text的值，並以array的方式取回。
 */
jQuery.fn.getInputselectObjs = function getInputselectObjs(){
	if($(this).length==0){
		$(this).logObj("setInputselectObj|[SKIP]length==0!!!!!!!!!!!!!"
				+$(this));
		return ;
	}
	var selectedArr = new Array();
	var $optionEle = $(this).children();
	$.each($optionEle, function (index, value){
//		console.log("value="+value
//				+",text="+value.text
//				+",selected="+value.selected
//		);
		if(value.selected==true){
			selectedArr.push(value.text);
		}else{
			console.log(getNowString()+"|"+value.text+" selected is false !!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
	});
	return selectedArr;
};

/**
 * 真對傳入的value和commaString進行分隔。
 * @param value
 * @param commaString
 * @returns {Boolean}
 */
function isValueExist(value, commaString){
	//如果value為空值，則一定存在。
	if(isUndefinedOrNull(value))return true;
	
	/* 若輸入值沒有問題，則進行comma解析。
	 * 如果對應到正確的值，則*/
	var commaArr = commaString.split(",");
	for(var commaStr in commaArr){
		var indexOf = value.indexOf(commaArr[commaStr]);
		if(indexOf >= 0)	return true;//找到了，直接回應存在。
	}
	
	return false;//最後都沒找到的話，則表示不存在。
}