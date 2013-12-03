$.format.date.defaultShortDateFormat = 'ttt/MM/dd';
$.format.date.defaultLongDateFormat = 'ttt/MM/dd hh:mm:ss';

$.format.date.convertDate = function( $selector, format ){
	if( $selector.is( ':input' ) )
		$selector.val( convertDate( $selector.val(), format ) );
	else
		$selector.text( convertDate( $selector.text(), format ) );
};

$( function(){
	$( '.shortDateFormat' ).each( function(){
		$.format.date.convertDate( $(this), $.format.date.defaultShortDateFormat );
	});
	
	$( '.longDateFormat' ).each( function(){
		$.format.date.convertDate( $(this), $.format.date.defaultLongDateFormat );
	});
	
	$( '.dateFormat' ).each( function(){
		var dateFormatStyle = $(this).attr( 'dateFormatStyle' );
		
		if( dateFormatStyle == null )
			alert( '尚未指定 dateFormatStyle attribute' );
		
		$.format.date.convertDate( $(this), dateFormatStyle );
	});
});