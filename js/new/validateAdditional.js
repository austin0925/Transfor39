/**
 * ======================================================== 有關字串 ========================================================
 */
jQuery.validator.addMethod( 'isDateFormatBySlashByRoc', function( value, element ){
	return this.optional( element ) || value.isDateFormatBySlashByRoc();
}, jQuery.validator.format( '日期格式錯誤(yyy/MM/dd)' ) );

jQuery.validator.addMethod( 'isDateFormatBySlashByRocIncludeNine', function( value, element ){
	return this.optional( element ) || value == '999/99/99' || value == '000/00/00' || value.isDateFormatBySlashByRoc();
}, jQuery.validator.format( '日期格式錯誤(yyy/MM/dd)或不為 999/99/99 或不為 000/00/00' ) );
 
jQuery.validator.addMethod( 'isDateTimeNoSecondFormatBySlashByRoc', function( value, element ){
	return this.optional( element ) || value.isDateTimeNoSecondFormatBySlashByRoc();
}, jQuery.validator.format( '日期時間格式錯誤(yyy/MM/dd HH:MM)' ) );

jQuery.validator.addMethod( 'identity', function( value, element ){	
	return this.optional( element ) || value.isIdentity();
}, jQuery.validator.format( '身份證號碼錯誤' ) );

jQuery.validator.addMethod( 'mobilePhone', function( value, element ){
	return this.optional( element ) || value.isMobilePhone();
}, jQuery.validator.format( '不為行動電話格式(0935-123456)' ) );

jQuery.validator.addMethod( 'password', function( value, element ){
	return this.optional( element ) || value.isPassword();
}, jQuery.validator.format( '不為密碼格式(A-Z, a-z, 0-9, "./;[]!@#$%*()_-=+|?")' ) );

jQuery.validator.addMethod( 'phone', function( value, element ){
	return this.optional( element ) || value.isPhone();
}, jQuery.validator.format( '不為家用電話格式(02-12345678)' ) );

jQuery.validator.addMethod( 'taxIdentity', function( value, element ){
	return this.optional( element ) || value.isTaxIdentity();
}, jQuery.validator.format( '不為統一編號的格式' ) );

jQuery.validator.addMethod( 'word', function( value, element ){
	return this.optional( element ) || value.isWord();
}, jQuery.validator.format( '不為 A-Z, a-z, 0-9 的字串' ) );

jQuery.validator.addMethod( 'equalLength', function( value, element, param ){
	return this.optional( element ) || value.length == param;
}, jQuery.validator.format( '長度應等於 {0} 的字串' ) );

jQuery.validator.addMethod( 'dateRange', function( value, element, param ){
	var $minDateEle = $( element );
	var $maxDateEle = $( param );
	
	if( $maxDateEle.length == 0 )
		alert( '找不到 maxDate 的 selector, id:' +  maxDateId );
	
	var dateFormat = $minDateEle.attr( 'dateFormat' );
	
	if( dateFormat == undefined || dateFormat == null )
		dateFormat = 'yy/mm/dd';
	
	var minDateString = $.trim( $minDateEle.val() );
	var maxDateString = $.trim( $maxDateEle.val() );
	
	if( minDateString == '' || maxDateString == '' )
		return true;
	
	var minDate = convertRocDateString2Date( minDateString );
	var maxDate = convertRocDateString2Date( maxDateString );
	
	return minDate.getTime() <= maxDate.getTime();
}, jQuery.validator.format( '起始日期要小於結束日期' ) );

jQuery.validator.addMethod( 'taxOrIdentity', function( value, element ){
	return this.optional( element ) || value.isTaxIdentity() || value.isIdentity();
}, jQuery.validator.format( '不為身份證字號或統一編號的格式' ) );

jQuery.validator.addMethod( 'taxOrIdentityStrange', function( value, element ){
	var valid = this.optional( element ) || value.isTaxIdentity() || value.isIdentity();
	
	if( !valid ){
		if( confirm( '身份證字號或統一編號或護照格式不正確, 是否要繼續?' ) )
			valid = true;
		else
			valid = false;
	}
	
	return valid;	
}, jQuery.validator.format( '不為身份證字號或統一編號的格式或護照格式' ) );

jQuery.validator.addMethod( 'isToday', function( value, element ){
	var nowDate = new Date();	
	var date = convertRocDateString2Date( value );
	
	var valid = ( nowDate.getFullYear == date.getFullYear && nowDate.getMonth() == date.getMonth() && nowDate.getDate() == date.getDate() );
	
	return this.optional( element ) || valid;
}, jQuery.validator.format( '不是今日的日期' ) );

jQuery.validator.addMethod( 'isNotToday', function( value, element ){
	var nowDate = new Date();	
	var date = convertRocDateString2Date( value );
	
	var valid = ( nowDate.getFullYear == date.getFullYear && nowDate.getMonth() == date.getMonth() && nowDate.getDate() == date.getDate() );
	
	return this.optional( element ) || !valid;
}, jQuery.validator.format( '不能為今日的日期' ) );

/**
 * ======================================================== 有關數值 ========================================================
 */
jQuery.validator.addMethod( 'lessThanDecimal', function( value, element, param ){
	return this.optional( element ) || value.isLessThanNPlaceDecimal( param );
}, jQuery.validator.format( '不為整數或小數點在 {0} 位以內' ) );

jQuery.validator.addMethod( 'tradevanNumber', function( value, element ){
	return this.optional( element ) || value.isNumber();
}, jQuery.validator.format( '不為數字' ) );

/**
 * ======================================================== 有關代碼 ========================================================
 */
jQuery.validator.addMethod( 'isExistBySmugWayCd', function( value, element ){
	return this.optional( element ) || value.isExistBySmugWayCd();
}, jQuery.validator.format( '走私方式輸入錯誤！' ) );

jQuery.validator.addMethod( 'isExistByCode', function( value, element, param ){
	return this.optional( element ) || value.isExistByCode(param);
}, jQuery.validator.format( '代碼不存在！' ) );

/**
 * ======================================================== 其它 ========================================================
 */
jQuery.validator.addMethod( 'myFill', function( value, element, parms ){
	var $thisEle = $( element );	
	var $eles = $( parms[1] );
	
	//如果欄位已有檢查到, 就不再檢查其它欄位
	if( $eles.filter( function(){ 
				var myFillError = $(this).attr( 'myfillerror' );
				if( typeof( myFillError ) != 'undefined' && myFillError == 'true' )
					return true;
			} ).length > 0 )
		return true;
	
	var valid = $eles.filter( function(){ return $.trim( $(this).val() ) != ''; }).length >= parms[0];
	
	//如果不合法, 會加入 myfillerror="true"
	if( !valid )
		$thisEle.attr( 'myfillerror', 'true' );
	
	return valid;
	
}, jQuery.validator.format( '至少要有 {0} 筆資料輸入' ) );

jQuery.validator.addClassRules( 'fillOne', {
	myFill: [ 1, '.fillOne' ]
});
