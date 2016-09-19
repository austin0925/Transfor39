/**
 * 目前支援的格式有
 * 1. java script date object
 * 2. java.util.Date string
 * 3. java.sql.Timestampe string
 * 
 * 目前尚未支援 java.sql.Date string
 * 
 * @param value a date, or java.util.Date string, or java.sql.Timestamp string
 * @param format ref java.text.SimpleDateFormat
 */
function convertDate( value, format ){
	if( value == null )
		return null;
	
	if( typeof( value ) == 'string' && value.isBlank() )
		return value;
	
	return $.format.date( value, format );
}


/**
 * use format: yyyy/MM/dd
 * 
 * @param value
 * @returns
 * @see dateConvert 
 */
function convertyDateByShortFormat( value ){
	return convertDate( value, 'yyyy/MM/dd' );
}

/**
 * use format: yyyy/MM/dd HH:mm:ss
 * 
 * @param value
 * @returns
 * @see dateConvert
 */
function convertDateByLongFormat( value ){
	return convertDate( value, 'yyyy/MM/dd HH:mm:ss' );
}

/**
 * use format: ttt/MM/dd
 * 
 * @param value
 * @returns
 * @see dateConvert 
 */
function convertRocDateByShortFormat( value ){
	return convertDate( value, 'ttt/MM/dd' );
}

/**
 * use format: ttt/MM/dd HH:mm:ss
 * 
 * @param value
 * @returns
 * @see dateConvert
 */
function convertRocDateByLongFormat( value ){
	return convertDate( value, 'ttt/MM/dd HH:mm:ss' );
}