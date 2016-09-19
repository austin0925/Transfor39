/**
 * 注意事項
 * 1. .jasper 檔, 一定要放在規定的位置 
 * @author Grandy.Kao(grandy.kao@gmail.com)
 */
( function( $ ){
	$.fn.viewReport = function( settings ){
		var defaultSettings = { 
			url						: null,			//rquired, url
			module					: null,			//rquired, 各個模組的名稱, ex: "rq", "rh", "ro" ...
			jasperFileName			: null,			//jasperFileName or jasperFileNameEle rquired, 不含副檔名的 jasper file name
			jasperFileNameSelector	: null,			//jasperFileName or jasperFileNameEle rquired, jasper file name selector
			reportType				: 'pdf',		//optional, report type, 目前只有提供 "pdf", "excel", "word", "html" "text"
			outputFileName			: '',			//可以指定匯出檔案的 file name
			characterWidth			: 10,			//在 reportType = 'text' 才會有作用
			characterHeight			: 20,			//在 reportType = 'text' 才會有作用
			conditionFormSelector	: null,			//rquired, 將查詢條件包起來的 form			
			debug					: false,		//optional, debug
			beforeValiation			: function( debug ){
				if( debug ) alert( 'run beforeValidation() function.' );
			},										//optional, 在 validation 之前會呼叫的 funciton
			beforeViewReport		: function( debug ){
				if( debug ) alert( 'run beforeViewReport() function.' );	
				return true;
			}										//optional, 在 submit 之前( 產生報表 ) 會呼叫的 function
		};

		var newSettings = $.extend( defaultSettings, settings );
		
		if( !check( newSettings ) ) return;
		
		initialValidation( newSettings.conditionFormSelector );
		
		this.click( clickButton( newSettings ) );
	};
	
	function check( newSettings ){
		if( newSettings.url == null || $.trim( newSettings.url ).length == 0 ){
			alert( '尚未指定 url 或指定的 url 錯誤, url:' + newSettings.url );
			return false;
		}
		
		if( newSettings.module == null || $.trim( newSettings.module ).length == 0 ){
			alert( '尚未指定  module' );
			return false;
		}
		
		if( newSettings.jasperFileName == null && newSettings.jasperFileNameSelector == null ){
			alert( '尚未指定  jasperFileName or jasperFileNameSelector' );
			return false;
		}
		
		if( newSettings.jasperFileName != null && $.trim( newSettings.jasperFileName ).length == 0 ){
			alert( '指定  jasperFileName 為空白' );
			return false;
		}	
		
		if( newSettings.jasperFileNameSelector != null && newSettings.jasperFileNameSelector.length == 0 ){
			alert( '指定  jasperFileNameSelector 錯誤' );
			return false;
		}		
		
		if( newSettings.reportType == null || $.trim( newSettings.reportType ).length == 0 ){
			alert( '尚未指定  reportType' );
			return false;
		}
		
		if( !( newSettings.reportType == 'pdf' || newSettings.reportType == 'excel' || newSettings.reportType == 'word' || newSettings.reportType == 'html' || newSettings.reportType == 'text' )){
			alert( '指定的 reportType 值錯誤, 目前只有支援 "pdf", "excel", "word", "html", "text"' );
			return false;
		}
		
		if( newSettings.conditionFormSelector == null || newSettings.conditionFormSelector.length == 0 ){
			alert( '指定的 conditon form selector 錯誤' );
			return false;
		}
		
		return true;
	}
	
	function clickButton( newSettings ){
		return function(){
			if( newSettings.debug )
				alert( 'url:' + newSettings.url );
			
			processConditionBySettings( newSettings );
			
			var urlIncludeParameter = newSettings.url + '?' + newSettings.conditionFormSelector.serialize();
			
			if( newSettings.debug )
				alert( '完整的 url:\r\n' + urlIncludeParameter );
			
			newSettings.beforeValiation( newSettings.debug );
			
			if( !newSettings.conditionFormSelector.valid() )			
				return false;
			
			if( !newSettings.beforeViewReport( newSettings.debug ) )
				return false;
			
			window.open( urlIncludeParameter,'', 'scrollbars=yes,status=0,resizable=1,width=' + ( screen.width - 10 ) + ',height=' + ( screen.height - 10 ) + ',left=0,top=0'  );
		};
	}
	
	function processConditionBySettings( newSettings ){
		var $module 		= $( '#moduleByReport',  newSettings.conditionFormSelector );
		var $jasperFileName 	= $( '#jasperFileNameByReport',  newSettings.conditionFormSelector );
		var $reportType 		= $( '#reportTypeByReport',  newSettings.conditionFormSelector );
		var $outputFileName 	= $( '#outputFileNameByReport',  newSettings.conditionFormSelector );
		var $characterWidth 	= $( '#characterWidthByReport',  newSettings.characterWidth );
		var $characterHeight	= $( '#characterHeightByReport',  newSettings.characterHeight );
		
		if( $module.length == 0 ){
			$module = getSelector( 'module');
			
			newSettings.conditionFormSelector.prepend( $module );
		}
		
		if( $jasperFileName.length == 0 ){
			$jasperFileName = getSelector( 'jasperFileName');
			
			newSettings.conditionFormSelector.prepend( $jasperFileName );
		}
		
		if( $reportType.length == 0 ){
			$reportType = getSelector( 'reportType');
			
			newSettings.conditionFormSelector.prepend( $reportType );
		}
		
		if( $outputFileName.length == 0 ){
			$outputFileName = getSelector( 'outputFileName');
			
			newSettings.conditionFormSelector.prepend( $outputFileName );
		}
		
		if( $characterWidth.length == 0 ){
			$characterWidth = getSelector( 'characterWidth');
			
			newSettings.conditionFormSelector.prepend( $characterWidth );
		}
		
		if( $characterHeight.length == 0 ){
			$characterHeight = getSelector( 'characterHeight');
			
			newSettings.conditionFormSelector.prepend( $characterHeight );
		}
			
		$module.val( newSettings.module );
		$jasperFileName.val( newSettings.jasperFileName == null ? newSettings.jasperFileNameSelector.val() : newSettings.jasperFileName );
		$reportType.val( newSettings.reportType );
		$outputFileName.val( newSettings.outputFileName );
		$characterWidth.val( newSettings.characterWidth );
		$characterHeight.val( newSettings.characterHeight );
	}
	
	function getSelector( name ){
		return $( '<input type="hidden" id="' + name + 'ByReport" name="' + name + 'ByReport"/>' );
	}
	
})( jQuery );
