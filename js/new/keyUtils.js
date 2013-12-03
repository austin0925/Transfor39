window.onhelp = function(){
	return false;
};

$( function(){
	$( document ).on( 'keydown', doKeyDown );
	$( document ).on( 'keydown', doFunctionKey );
});

function doKeyDown( eventObject ){	
	var keyCode = eventObject.keyCode;	
	var shiftKey = eventObject.shiftKey;
	var idNames;
	
	if( keyCode == 112 && shiftKey )
		idNames = ['resetButton','searchResetButton'];
	else if( keyCode == 113 )
		idNames = ['addButton'];	
	else if( keyCode == 114 )
		idNames = ['updateButton'];
	else if( keyCode == 115 )
		idNames = ['deleteButton'];
	else if( keyCode == 117 )
		idNames = ['searchButton'];
	else if( keyCode == 118 )
		idNames = ['printButton'];
	else if( keyCode == 123 && shiftKey )
		idNames = ['searchAddButton'];
	else 
		return true;
	
	console.log( 'doKeyDown():keyCode:', keyCode + ', shfitKey:' + shiftKey );
	
	var $mytabs = $( '#mytabs' );
	
	var $button = null;
	
	if( $mytabs.length == 0 ){
		console.log( 'no tab' );
		
		$.each( idNames, function(){
			$button = $( '[id*=_' + this + ']' );
			
			if( $button.length != 0 )
				return false;
		});
	}else{
		var selectedIndex = $mytabs.tabs( 'option', 'selected' );
		
		console.log( 'has tab, selectedIndex:' + selectedIndex );
		
		$.each( idNames, function(){
			$button = $( '[id*=_' + this + ']', $mytabs.children( 'div' ).eq( selectedIndex ) );
			
			if( $button.length != 0 )
				return false;
		});
	}
	
	if( $button == null || $button.length == 0 ){
		console.log( '找不到指定的 button' );
		return;
	}
	
	if( $button.length > 1 ){
		alert( 'trigger 的 button 有二個以上' );
		return;
	}
	
	event.keyCode = 0;
	
	if( !$button.prop( 'disabled' ) ){
		console.log( 'functionKey, trigger button id:' + $button.attr( 'id' ) );
		$button.trigger( 'click' );
	}else
		console.log( 'button is dialbed, buttonId:' + $button.attr( 'id' ) );
	
	return false;
}

function doFunctionKey( eventObject ){
	var keyCode = eventObject.keyCode;	
	var ctrlKey = eventObject.ctrlKey;
	var shiftKey = eventObject.shiftKey;
	var altKey = eventObject.altKey;
	
	//只有按 ctrl, or alt or shift
	if( keyCode == 16 || keyCode == 17 || keyCode == 18 )
		return;
	
	console.log( 'doFunctionKey():keyCode:' + keyCode + ', ctrlKey:' + ctrlKey + ', shfitKey:' + shiftKey + ', altKey:' + altKey );
	
	var functionKey = '';
	
	if( ctrlKey )
		functionKey += 'ctrl_';
	
	if( shiftKey )
		functionKey += 'shift_';
	
	if( altKey )
		functionKey += 'alt_';
	
	functionKey += keyCode;
	
	console.log( 'functinKey:' + functionKey );
	
	$( 'a[functionkey=' + functionKey + '], :button[functionkey=' + functionKey + ']' ).trigger( 'click' );
}

( function( $ ){
	$.fn.functionkey = function( settings ){
		var defaultSettings = { 
			keyCode			: null,		// key code, refer to http://www.webonweboff.com/tips/js/event_key_codes.aspx 
			ctrl	 		: false,	// 是否要加 ctrl
			shift			: false,	// 是否要加 shift
			alt				: false,	// 是否要加  alt	
			debug			: false
		};

		var newSettings = $.extend( defaultSettings, settings );
		
		if( !checkSettings( newSettings ) )
			return;
		
		return this.each( function(){
			var functionKey = '';
			
			if( newSettings.ctrl )
				functionKey += 'ctrl_';
			
			if( newSettings.shift )
				functionKey += 'shift_';
			
			if( newSettings.alt )
				functionKey += 'alt_';
			
			functionKey += newSettings.keyCode;
			
			$(this).attr( 'functionkey', functionKey );
			
			if( newSettings.debug )
				console.log( $(this).outerHtml() );
		});
	};
	
	function checkSettings( newSettings ){
		var keyCode = newSettings.keyCode;
		var ctrl = newSettings.ctrl;
		var shift = newSettings.shift;
		var alt = newSettings.alt;
		
		if( keyCode == null || typeof( keyCode ) != 'number' ){
			alert( 'keyCode 指定的格式不對, keyCode:' + keyCode );
			return false;
		}
		
		if( ctrl == null || typeof( ctrl ) != 'boolean' ){
			alert( 'ctrl 指定的格式不對, ctrl:' + ctrl );
			return false;
		}
		
		if( shift == null || typeof( shift ) != 'boolean' ){
			alert( 'shift 指定的格式不對, shift:' + keyCode );
			return false;
		}
		
		if( alt == null || typeof( alt ) != 'boolean' ){
			alert( 'alt 指定的格式不對, alt:' + alt );
			return false;
		}
		
		return true;
	}	
})( jQuery );