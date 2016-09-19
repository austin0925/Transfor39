( function( $ ){
	$.fn.myautocomplete = function( settings ){
		var defaultSettings = { 
				resultName		: null,
				tableName		: null,
				conditionName	: null,
				codeNameEle		: null,
				autoUpperCase	: true,
				minLength		: 1
		};

		var newSettings = $.extend( defaultSettings, settings );
		
		if( !check( newSettings ) ) return;
		
		var conditionId = this;
		
		$( this ).autocomplete({
			minLength:newSettings.minLength,
			source: function( request, response ){
				var url = getContextPath() + '/common!autoComplete';				
				console.log( 'url:', url );
				
				request.resultName = newSettings.resultName;
				request.tableName = newSettings.tableName;
				request.conditionName = newSettings.conditionName;
				request.conditionValue = $( conditionId ).val();
				
				if( newSettings.autoUpperCase )
					request.conditionValue = request.conditionValue.toUpperCase();
				
				$.post( url, request, function( res ){					
					newSettings.codeNameEle.val( res.data.codeName );
				}, 'json' );
			}
		});
		
		$(this).on( 'keyup', function(){
			var val = $(this).val();
			if( val == '' || val.length < newSettings.minLength )
				newSettings.codeNameEle.val( '' );				
		});
	};
	
	function check( newSettings ){
		if( newSettings.resultName == null || typeof( newSettings.resultName ) != 'string' || $.trim( newSettings.resultName ).length == 0 ){
			alert( '尚未指定 resultName 或指定的 resultName 錯誤, resultName:' + newSettings.resultName );
			return false;
		}
		
		if( newSettings.tableName == null || typeof( newSettings.tableName ) != 'string' || $.trim( newSettings.tableName ).length == 0 ){
			alert( '尚未指定 tableName 或指定的 tableName 錯誤, tableName:' + newSettings.tableName );
			return false;
		}
		
		if( newSettings.conditionName == null || typeof( newSettings.conditionName ) != 'string' || $.trim( newSettings.conditionName ).length == 0 ){
			alert( '尚未指定 conditionName 或指定的 conditionName 錯誤, conditionName:' + newSettings.conditionName );
			return false;
		}
		
		if( newSettings.codeNameEle != null && newSettings.codeNameEle.length == 0 ){
			alert( '使用 myautocomplete 錯誤, 指定的  codeNameEle 找不到 selector' );
			return false;
		}
		
		if( newSettings.autoUpperCase == null || typeof( newSettings.autoUpperCase ) != 'boolean' ){
			alert( '尚未指定 autoUpperCase 或指定的 autoUpperCase 錯誤, autoUpperCase:' + newSettings.autoUpperCase );
			return false;
		}
		
		return true;
	}
})( jQuery );