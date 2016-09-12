/**
 * String Utils
 * @author Grandy(grandy.kao@gmail.com)
 * @version 1.0
 */

/**
 * 將字串以 delim 為分離符號, 並在前後加上 quote
 * 如: "a,b,c" , delim=",", quote="#", 結果: #a#,#b#,#c#
 */
String.prototype.addQuoteByDelim = function( delim, quote )
{
	return quote + this.replace( new RegExp( delim, 'g' ), quote + delim + quote ) + quote;
};

/**
 * 含有多少的中文字(含全形)
 */
String.prototype.chineseCount = function()
{
	if( this.isBlank() )
		return 0;
	
	var str = this.trim();
	var count = 0;
	
	for( var i = 0 ; i < str.length ; i++ )
		if( str.charCodeAt( i ) > 256 )
			count++;
	
	return count;
};

String.prototype.convertToJavaConvenience = function(){
	return this.toLowerCase().replace( /_([a-z])/g, function( findString, parameter1 ){ return parameter1.toUpperCase(); });
};

/**
 * 將字串的第一個字母改為小寫
 */
String.prototype.firstCharToLowercase = function()
{
	if( this.length == 0 )
		return this;
	
	if( this.length == 1 )
		return this.toLowerCase();
	
	return this.substr( 0, 1 ).toLowerCase() + this.substr( 1 );
};

/**
 * 檢查欄位字串, 如果為空白或空字串, 則傳回 true
 * @return true: 為空白或空字串
 */
String.prototype.isBlank = function()
{
    return ( this == null ) || ( this.trim().length == 0 ) || /^\s+$/.test( this );
};

/**
 * ROC 日期格式: 只有 TTT/MM/dd
 */
String.prototype.isDateFormatBySlashByRoc = function()
{ 
	return this.isBlank() || /^\-?(|0|1)\d\d\/(0[1-9]|1[012])\/(0[1-9]|[12][0-9]|3[01])$/.test( this ) && isValidDate(this);	
};

/**
 * ROC 日期時間格式(不含秒): 只有 TTT/MM/dd HH:MM
 */
String.prototype.isDateTimeNoSecondFormatBySlashByRoc = function()
{
	return this.isBlank() || /^(0|1)\d\d\/(0[1-9]|1[012])\/(0[1-9]|[12][0-9]|3[01]) ([0-5][0-9]):([0-5][0-9])$/.test( this );	
};

/**
 * 檢查是否為 email 格式
 * @return true: 為 email 格式
 */
String.prototype.isEmail = function()
{
	return this.isBlank() || /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test( this );
};

/**
 * 檢查是否為身份證格式
 * @return true: 身份證格式
 */
String.prototype.isIdentity = function()
{
	if( this.isBlank() )
		return true;
	
	if( this.length != 10 )
		return false;
	
    var acc = '00';
    
    var d0 = this.charAt( 0 );
    var d1 = this.charAt( 1 );
    var d2 = this.charAt( 2 );
    var d3 = this.charAt( 3 );
    var d4 = this.charAt( 4 );
    var d5 = this.charAt( 5 );
    var d6 = this.charAt( 6 );
    var d7 = this.charAt( 7 );
    var d8 = this.charAt( 8 );
    var d9 = this.charAt( 9 );
    
    if( ( d0 == 'A' ) || ( d0 == 'a' ) ) { acc = '10'; }
    else if( ( d0 == 'B' ) || (d0 == 'b' ) ) { acc = '11'; }
    else if( ( d0 == 'C' ) || (d0 == 'c' ) ) { acc = '12'; }
    else if( ( d0 == 'D' ) || (d0 == 'd' ) ) { acc = '13'; }
    else if( ( d0 == 'E' ) || (d0 == 'e' ) ) { acc = '14'; }
    else if( ( d0 == 'F' ) || (d0 == 'f' ) ) { acc = '15'; }
    else if( ( d0 == 'G' ) || (d0 == 'g' ) ) { acc = '16'; }
    else if( ( d0 == 'H' ) || (d0 == 'h' ) ) { acc = '17'; }
    else if( ( d0 == 'J' ) || (d0 == 'j' ) ) { acc = '18'; }
    else if( ( d0 == 'K' ) || (d0 == 'k' ) ) { acc = '19'; }
    else if( ( d0 == 'L' ) || (d0 == 'l' ) ) { acc = '20'; }
    else if( ( d0 == 'M' ) || (d0 == 'm' ) ) { acc = '21'; }
    else if( ( d0 == 'N' ) || (d0 == 'n' ) ) { acc = '22'; }
    else if( ( d0 == 'P' ) || (d0 == 'p' ) ) { acc = '23'; }
    else if( ( d0 == 'Q' ) || (d0 == 'q' ) ) { acc = '24'; }
    else if( ( d0 == 'R' ) || (d0 == 'r' ) ) { acc = '25'; }
    else if( ( d0 == 'S' ) || (d0 == 's' ) ) { acc = '26'; }
    else if( ( d0 == 'T' ) || (d0 == 't' ) ) { acc = '27'; }
    else if( ( d0 == 'U' ) || (d0 == 'u' ) ) { acc = '28'; }
    else if( ( d0 == 'V' ) || (d0 == 'v' ) ) { acc = '29'; }
    else if( ( d0 == 'W' ) || (d0 == 'w' ) ) { acc = '30'; }
    else if( ( d0 == 'X' ) || (d0 == 'x' ) ) { acc = '31'; }
    else if( ( d0 == 'Y' ) || (d0 == 'y' ) ) { acc = '32'; }
    else if( ( d0 == 'Z' ) || (d0 == 'z' ) ) { acc = '33'; }
    else if( ( d0 == 'I' ) || (d0 == 'i' ) ) { acc = '34'; }
    else if( ( d0 == 'O' ) || (d0 == 'o' ) ) { acc = '35'; }
    
   
    acc1 = acc.charAt( 0 );
    acc2 = acc.charAt( 1 );
    
    certsum = 1 * acc1 + 9 * acc2 + 8 * d1 + 7 * d2 + 6 * d3 + 5 * d4 + 4 * d5 + 3 * d6 + 2 * d7 + 1 * d8;
    certsum = parseInt( certsum % 10);
    certsum = 10 - certsum;
	
    return d9 == certsum;
};

/**
 * 檢查是否為整數字串(大於或等於 0 的字串)
 * @return true: 為整數字串, false: 不為整數字串
 */
String.prototype.isInteger = function()
{
	return this.isBlank() || /^\d+$/.test( this );
};

/**
 * 檢查是否為整數或小數點第 n 位以內
 * @param {Object} n 當 n = 2 時, 2, 2.1, 2.34 都會回傳 true
 * @return true: 為整數或小數點第 n 位以內
 */
String.prototype.isLessThanNPlaceDecimal = function( n )
{
	return this.isBlank() || new RegExp( '^\\d+$' ).test( this ) || new RegExp( '^\\d+\\.?\\d{1,' + n + '}$' ).test( this );
};

/**
 * 檢查是否為行動電話格式, 0935-123456
 * @return true: 為行動電話格式
 */
String.prototype.isMobilePhone = function()
{
	return this.isBlank() || /^\d{4}-\d{6}$/.test( this );
};

/**
 * 檢查是否為數字的字串, 含小數和負數, 如: 123, 123.45, -123, -123.45, 123,456,789
 * @return true: 為數字的字串, false: 不為數字的字串
 */
String.prototype.isNumber = function()
{
    return this.isBlank() || /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test( this );
};

/**
 * 檢查是否為密碼格式( A-Z, a-z, 0-9, "./;[]!@#$%*()_-=+|?" )
 * @returns {Boolean} ture: 為密碼格式
 */
String.prototype.isPassword = function()
{
	return this.isBlank() || /^[\w\,\.\/\;\[\]\!\@\#\$\%\*\(\)\-\=\+\|\?]*$/.test( this );
};

/**
 * 檢查是否為家用電話格式, ex: 02-12345678
 * @return true:為家用電話格式
 */
String.prototype.isPhone = function()
{
	return this.isBlank() || /^0\d{1,3}-\d{6,8}$/.test( this );
};

/**
 * 檢查是否為統一編號的格式
 * @return true: 為統一編號的格式
 */
String.prototype.isTaxIdentity = function()
{
	if( this.isBlank() )
		return true;
	
	if( !/^\d{8}$/.test( this ) )
		return false;
	
	var tmp = new String( "12121241" );
	var sum = 0;
	var s1;
	var s2;
	
   	for( var i = 0 ; i < 8 ; i++ )
   	{
    	s1 = parseInt( this.substr( i, 1 ) );
     	s2 = parseInt( tmp.substr( i, 1 ) );
     	
     	var n = s1 * s2;
     	while( n != 0 )
     	{
     		sum += ( n % 10 );
     		n = ( n - n % 10 ) / 10;
     	}
   	}
   	
   	if( !( sum % 10 == 0 ) )
   		if( this.substr( 6, 1 ) == "7" )
   			return ( ( sum + 1 ) % 10 == 0 );
   	
   	return sum % 10 == 0;
};

/**
 * 檢查是否為 url 的格式
 * @return true: url 的格式
 */
String.prototype.isUrl = function()
{
	return this.isBlank() || /^(http|https):\/\/[\w]+\.[\w]{2,3}(\S*)?$/.test( this );
};

/**
 * 是否為 A-Z, a-z, 0-9 的字串
 */
String.prototype.isWord = function()
{
	return this.isBlank() || /^[A-Za-z0-9]*$/.test( this );
};

/**
 * Left pad a char with a specified char
 * @param {Object} size
 * @param {Object} padchar
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
String.prototype.leftPad = function( size, padChar )
{
	if( padChar.length > 1 || padChar.length == 0 )
		alert( 'The lenght of padChar must be 1.' );
	
	if( this.length >= size ) 
		return this;
	
	var temp = this;
	var minusLength = size - this.length;
	
	for( var i = 0; i < minusLength; i++ ) 
		temp = padChar + temp;
	
	return temp;
};

/**
 * 去除左邊空白
 * @return 去除左邊空白的字串
 */
String.prototype.leftTrim = function()
{
    return this.replace( /(^\s*)/g, '' );
};



/**
 * right pad a char with a specified char
 * @param {Object} size
 * @param {Object} padChar
 * @memberOf {TypeName} 
 * @return {TypeName} 
 */
String.prototype.rightPad = function( size, padChar )
{
	if( padChar.length > 1 || padChar.length == 0 )
		alert( 'The lenght of padChar must be 1.' );
	
	if( this.length >= size ) 
		return this;
	
	var temp = this;
	var minusLength = size - this.length;
	
	for( var i = 0; i < minusLength; i++ ) 
		temp += padChar;
	
	return temp;
};

/**
 * 去除右邊空白
 * @return 去除右邊空白的字串
 */
String.prototype.rightTrim = function()
{
    return this.replace( /(\s*$)/g, '' );
};

/**
 * 去除前後空白
 * @return 去除前後空白的字串
 */
String.prototype.trim = function()
{
	return this.replace( /^\s+|\s+$/g, '' );
};

/**
 * ROC 日期時間格式(不含秒): 只有 yyy/MM/dd HH:MM
 */
String.prototype.isDateTimeNoSecondFormatBySlashByRoc = function()
{
	return this.isBlank() || /^(0|1)\d\d\/(0[1-9]|1[012])\/(0[1-9]|[12][0-9]|3[01]) ([0-5][0-9]):([0-5][0-9])$/.test( this );	
};

/**
 * 走私方式 是否存在
 * @returns {Boolean}
 */
String.prototype.isExistBySmugWayCd = function()
{
	return this.isBlank() || isExistBySmugWayCd( this );
};

/**
 * 走私方式 是否存在
 * @param smugWayCd
 */
function isExistBySmugWayCd( smugWayCd ){
	var isExist = false;
	var url = getContextPath() + '/common!isExistBySmugWayCd';
	
	$.ajaxSetup({async:false});
	$.post( url, { 'smugWayCd' : smugWayCd}, function( callback ){
		showStatusMsg( callback.status, callback.msg );
		
		$.ajaxSetup({async:true});
		
		isExist = callback.data.isExist;		
	});
	
	return isExist;
}

/**
 * 代碼 是否存在
 * @returns {Boolean}
 */
String.prototype.isExistByCode = function(codeKind)
{
	return this.isBlank() || isExistByCode( codeKind, this );
};

/**
 * 代碼 是否存在
 * @param code
 */
function isExistByCode( codeKind, code ){
	var isExist = false;
	var url = getContextPath() + '/common!isExistByCode';
	
	$.ajaxSetup({async:false});
	$.post( url, { 'codeKind' : codeKind, 'code' : code }, function( callback ){
		showStatusMsg( callback.status, callback.msg );
		
		$.ajaxSetup({async:true});
		
		isExist = callback.data.isExist;		
	});
	
	return isExist;
}
/**
 * @param value 日期
 * @return {Boolean}
 */
function isValidDate(value){ 
	var val = value.replace(/\//g, '');

	
	var year = parseInt(val.substring(0,3)) + 1911 ;
	var month = parseInt(val.substring(3,5))-1 ;//month start from 0
	var date = val.substring(5,7);  
	var presumedDate = new Date(year, month, date); 

	if (presumedDate.getDate() != date){  
		return false;
	} 
	else{   
		return true;
	}
	    
};