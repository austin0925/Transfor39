( function( $ ){
	$.fn.numberFormat = function( settings ){
		var defaultSettings = { 
			format 		: '#,###',	// format 的格式
			eventType 	: 'blur',	// 指定的 event 被 trigger, 會做 number fomrat
			initial		: true,		// 對指定的欄位,做初始化的動作
			debug		: false
		};

		var newSettings = $.extend( defaultSettings, settings );
		
		if( !checkSettings( newSettings ) )
			return;
		
		if( newSettings.debug )
			alertSettings( newSettings );
		
		return this.each( function(){
			if( newSettings.initial ){
				
				if( $.trim( $(this).val() ) == '' )
					return;
				
				$(this).parseNumber( {format : newSettings.format} );
				$(this).formatNumber( {format : newSettings.format} );
			}
			
			if( newSettings.debug )
				alert( 'bind selecotr:' + $(this).outerHtml() );
			
			$(this).on( newSettings.eventType, processByEvent( newSettings ) );
		});
	};
	
	function processByEvent( newSettings ){
		return function(){
			
			if( newSettings.debug )
				alert( 'run processByEvent() function.' );
			
			if( $.trim( $(this).val() ) == '' )
				return;			
			
			$(this).parseNumber({ 
				format : newSettings.format 
			});	
			
			$(this).formatNumber({ 
				format : newSettings.format 
			}); 
		};
	}
	
	function checkSettings( newSettings ){
		var format = newSettings.format;
		var eventType = newSettings.eventType;
		var initial = newSettings.initial;
		
		if( format == null || typeof( format ) != 'string' || $.trim( format ) == 0 ){
			alert( 'format 指定的格式不對, format:' + format );
			return false;
		}
		
		if( eventType == null || typeof( eventType ) != 'string' || $.trim( eventType ) == 0 ){
			alert( 'eventType 指定的格式不對, eventType:' + eventType );
			return false;
		}
		
		if( initial == null || typeof( initial ) != 'boolean' ){
			alert( 'initial 指定的格式不對, initial:' + initial );
			return false;
		}
		
		return true;
	}
	
	function alertSettings( newSettings ){
		var msg = 'settings:\r\n';
		msg += ( 'format:' + newSettings.format + '\r\n' );
		msg += ( 'eventType:' + newSettings.eventType + '\r\n' );
		msg += ( 'initial:' + newSettings.initial + '\r\n' );
		
		alert( msg );
	}
})( jQuery );
