if( !Array.indexOf ){
	Array.prototype.indexOf = function( obj ){
		for( var i=0; i < this.length ; i++ ){
			if( this[i] == obj ) return i;
		}

		return -1;
  };
};

$( function(){
	//當 browser 沒有支援 console object, console 將不起作用
	if( typeof( console ) == 'undefined' ){
		console = new Object();
		console.log = function(){};
		console.info = function(){};
		console.warn = function(){};
		console.error = function(){};
		console.dir = function(){};
	}
});

var common = new Object();

//定義常用的 method
common.grid = {
	/**
	 * 取得目前頁面所有的 id
	 *
	 * @param $gridEle
	 * @returns 傳回 array
	 */
	getIds : function( $gridEle ){
		return $gridEle.jqGrid( 'getDataIDs' );
	},

	getRowId : function($gridEle){
		return $gridEle.jqGrid( 'getGridParam', 'selrow' );
	},

	getRowData : function( $gridEle, rowId ){
		return $gridEle.jqGrid( 'getRowData', rowId );
	},

	/**
	 * 取得目前頁面最後一筆的 id, 再加一, 通常用在新增一筆資料時使用
	 *
	 * @param ids
	 * @returns
	 */
	getLastId : function( ids ){
		if( ids.length == 0 )
			return 1;

		return parseInt( ids[ids.length - 1] ) + 1;
	},

	/**
	 * 從 ids 取得 row number
	 *
	 * getRowNumberByAction( [1,2,4,8], 1 ) = 1
	 * getRowNumberByAction( [1,2,4,8], 2 ) = 2
	 * getRowNumberByAction( [1,2,4,8], 4 ) = 3
	 * getRowNumberByAction( [1,2,4,8], 8 ) = 4
	 *
	 * @param ids
	 * @param actionRowId
	 */
	getRowNumberByAction : function( ids, actionRowId ){
		if( ids == null )
			console.error( 'ids can not be null' );

		if( actionRowId == null )
			console.error( 'actionRowId can not be null' );

		for( var i = 0 ; i < ids.length ; i++ )
			if( ids[i] == actionRowId )
				return ( i + 1 );

		console.error( 'can not find any id in ids:' + ids.join( ',' ) );
	},

	setRowData : function( $gridEle, rowId, rowData ){
		$gridEle.jqGrid( 'setRowData', rowId, rowData );
	}
};

/**
 * ============================================= 狀態列相關的 function =============================================
 *
 */

/**
 * append error msg 到原來的狀態列
 * @param msg 錯誤訊息, request
 */
function appendMsgToStatusField( msg ){
	if( msg == undefined || msg == null ){
		alert( '使用 appendMsgToStatusField function(), 指定的 msg 有錯, msg:' + msg );
		return;
	}

	var msgTemp = '';
	if( typeof( msg ) == 'string' )
		msgTemp = ( '[' + msg + ']' );
	else{
		$.each( msg, function(){
			msgTemp += ( '[' + this + ']' );
		});
	}

	$( '#statusMsg' ).val( $( '#statusMsg' ).val() + msgTemp );
}

/**
 * 清除狀態列的訊息
 */
function cleanMsgForStatusField(){
	var $statsMsg = $( '#statusMsg' );

	if( $statsMsg.length != 0 )
		$statsMsg.val( '' ).css( 'color' );
}

/**
 * 將組好的訊息, 填入狀態列, ex: "[欄位1:錯誤訊息1][欄位2:錯誤訊息2][欄位3:錯誤訊息3]"
 */
function fillMsgToStatusField( msg ){
	if( msg == undefined || msg == null || typeof( msg ) != 'string' ){
		alert( '使用 showStatusMsg function(), 指定的 msg 有錯, msg:' + msg );
		return;
	}

	$( '#statusMsg' ).val( msg );
}

/**
 * 更改狀態列顏色
 *
 * @param color
 */
function setColorForStatusField( color ){
	$( '#statusMsg' ).css( 'color', color );
}

/**
 * 顯示錯誤訊息在狀態列, status 有 "ok", "ng", "ex", 只有當為 "ok" 時, 才會顯示藍色, 其餘都為紅色
 * 當 status 為 null 時, 則自動將 status 設為 "ex", 並將錯誤訊息改為 "[發生伺服器例外錯誤]"
 *
 * @param status 狀態列的 status, 有 "ok", "ng", "ex", 只有當為 "ok" 時, 才會顯示藍色, 其餘都為紅色, request
 * @param msg 錯誤訊息, 已含有[], request
 */
function showStatusMsg( status, msg ){
	if( status == null ){
		status = 'ex';
		msg='[發生伺服器例外錯誤]';
	}

	if( status == undefined || typeof( status ) != 'string' || !( status == 'ok' || status == 'ng' || status == 'ex' ) ){
		alert( '使用 showStatusMsg function(), 指定的 status 有錯, status:' + status );
		return;
	}

	fillMsgToStatusField( msg );

	if( status == 'ok' )
		setColorForStatusField( 'blue' );
	else
		setColorForStatusField( 'red' );
}

/**
 * =================================================== 相關 util  =====================================================================
 */
function switchGroup( newGroupId, searchButtonId ){
	if( typeof( newGroupId ) == 'undefined' || newGroupId == null )
		alert( '沒有傳入  newGroupId 的參數' );

	if( typeof( searchButtonId ) == 'undefined' || searchButtonId == null )
		alert( '沒有傳入  searchButtonId 的參數' );

	var mode = searchButtonId.substring( searchButtonId.length - 1, searchButtonId.length );
	var name = searchButtonId.replace( '_searchButton' + mode, '' );

	console.log( 'switchGroup, name:', name,  ' and switch to new grid:', newGroupId, ' in 模式 ', mode );

	var $searchEle = $( '#' + searchButtonId );

	if( $searchEle.length == 0 )
		alert( '找不到搜尋按鈕的 selector, searchButtonId:' + searchButtonId );

	var $addButtonEle = $( '#' + name + '_addButton' + mode );
	var $updateButtonEle = $( '#' + name + '_updateButton' + mode );
	var $deleteButtonEle = $( '#' + name + '_deleteButton' + mode );

	$.destroyTopic( name + '_sortColTopics' + mode );
	$.destroyTopic( name + '_pagingTopics' + mode );
	$.destroyTopic( name + '_selectRowTopics' + mode );

	$searchEle.off( 'click' );
	$addButtonEle.off( 'click' );
	$updateButtonEle.off( 'click' );
	$deleteButtonEle.off( 'click' );

	$( '#' + name + '_gridCondition' + mode + ' #currentGrid' ).val( newGroupId );

	if( mode == '1' )
		initialGrid1( $searchEle );
	else if( mode == '2' )
		initialGrid2( $searchEle );
	else if( mode == '3' )
		initialGrid3( $searchEle );
	else if( mode == '4' )
		initialGrid4( $searchEle );
}

function doOnLoadByGrid( gridMode ){
	return function(){
		$( '[id$=_searchButton' + gridMode + ']' ).each( function(){
			var name = $(this).attr( 'id' ).replace( '_searchButton' + gridMode, '' );
			var gridId = ( name + '_grid' + gridMode );

			var colModels = $( '#' + gridId ).jqGrid( 'getGridParam', 'colModel' );

			$.each( colModels, function(){
				var name = this.name;
				var sortable = this.sortable;

				if( name != 'rn' && sortable ){
					var thId =  gridId + '_' + name;

					$( '#' + thId + ' .s-ico' ).show();

					//處理  header 需要折行, 就會折行
					$( '#jqgh_' + thId ).css( 'white-space', 'normal' ).css( 'height', 'auto').css( 'padding', '2px' );
				}

				if( !sortable )
					$( '#jqgh_' + gridId +'_' + name ).css( 'cursor', 'default' );
			});
		});
	};
}

/**
 * grid 使用的 format
 */
function numberFormatByGrid( value ){
	if( value == null || $.trim( value ).length == 0 )
		return '&nbsp;';

	var temp;

	if( typeof( value ) == 'number' )
		temp = value.toString();
	else
		temp = value;

	return temp.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, "$1," );
}

/**
 * 使用 validataion, 初始化
 */
function initialValidation( $form ){
	$form.validate({
		ignoreTitle : true,
		onfocusout : false,
		onkeyup : false,
		onclick : false,
		errorClass : 'validation_error',
		errorPlacement : function( $error, $element ){
			var msg = '';

			var classValue = $element.attr( 'class' );

			if( typeof( classValue ) != 'undefined' && classValue.indexOf( 'fillOne' ) != -1 )
			{
				$( '.fillOne' ).each( function( index ){

					var fieldName = $(this).attr( 'alt' );
					if ( typeof( fieldName ) == 'undefined' )
						fieldName = $(this).attr( 'title' );

					if( index != 0 )
						msg += ',';

					msg += fieldName;
				});

				msg += ':';
				msg += $error.text();

				$element.removeAttr( 'myfillerror' );
			}else{
				var fieldName = $element.attr( 'alt' );
				if ( typeof( fieldName ) == 'undefined' )
					fieldName = $element.attr( 'title' );

				msg += fieldName;
				msg += ':';
				msg += $error.text();
			}

			appendMsgToStatusField( msg );
		},
		invalidHandler: function( form, validator ){
			$( '#statusMsg' ).val( '' ).css( 'color', 'red' );
		}
	});
}

/**
 * reset value
 *
 * @param $dataForm
 * @param isTriggerChangeEvent
 */
function resetValue( $dataForm, isTriggerChangeEvent ){
	if( $dataForm == null || $dataForm.length == 0 )
		alert( '在 resetValue() function, 指定的 $dataForm 錯誤' );

	if( isTriggerChangeEvent == null )
		isTriggerChangeEvent = false;

	$( 'input[type=text]:not( [role] ):not( [reset=false] ), textarea:not( [role] ):not( [reset=false] )', $dataForm ).each( function(){
		$(this).val( '' );
	});

	$( 'select:not( [role] ):not( [reset=false] )', $dataForm ).each( function(){
		$(this).val( $(this).children( ':first' ).attr( 'value' ) );

		if( isTriggerChangeEvent )
			$(this).trigger( 'change' );
	});

	$( 'div.checkboxGroup,div.radioGroup', $dataForm ).each( function(){
		$( 'input:checkbox:checked,input:radio:checked', $(this) ).each( function(){
			$(this).attr( 'checked', false );
		});
	});
}

/**
 * 在 grid, 選的資料, 會填入到 dataform 的每一個 element
 *
 * @param $gridEle
 * @param $dataForm
 * @param isTriggerChangeEvent
 */
function fillDataToElementForSelectRow( $gridEle, $dataForm, isTriggerChangeEvent ){
	var rowId = $gridEle.jqGrid( 'getGridParam', 'selrow' );

	$( 'input[type=text]:not( [role] ), input[type=hidden]:not( [role] ), select:not( [role] ), textarea:not( [role] )', $dataForm ).each( function(){
		var $ele = $(this);
		var cellValue = $gridEle.jqGrid( 'getCell', rowId, $ele.attr( 'id' ) );

		//沒有在 $gridEle table 的欄位, 不會把值填入
		if( typeof( cellValue ) != 'boolean' ){
			var tagName = $ele.prop( 'tagName' );

			$ele.val( cellValue );

			if( $ele.attr( 'pk' ) == 'true' )
				cloneHidden( $ele, cellValue, $dataForm );

			if( isTriggerChangeEvent && tagName == 'SELECT' )
				$ele.trigger( 'change' );
		}
	});

	$( 'div.checkboxGroup,div.radioGroup', $dataForm ).each( function(){
		var $divEle = $(this);
		var divId = $divEle.attr( 'id' );

		if( divId == null || $.trim( divId ).length == 0 )
			alert( '使用 checkbox or radio element 時, 在 div tag 要設定 id' );

		var cellValue = $gridEle.jqGrid( 'getCell', rowId, divId );

		if( typeof( cellValue ) != 'boolean' ){

			var cellValues = cellValue.split( ',' );

			$( 'input:checkbox,input:radio', $divEle ).each( function( index ) {
				var $checkboxEle = $(this);
				$checkboxEle.attr( 'checked', false );

				for( var i = 0 ; i < cellValues.length ; i++ )
				{
					if( $checkboxEle.attr( 'value' ) == cellValues[i] )
					{
						$checkboxEle.attr( 'checked', true );
						break;
					}
				}
			});
		}
	});
}

function getRowDataByGrid( $gridEle, $dataForm ){
	var rowData = {};

	$.each( $gridEle.jqGrid( 'getGridParam', 'colModel' ), function( index, data ){
		var headerName = data.name;

		if( headerName == 'rn' )
			return true;

		var $dataEle = $( '#' + headerName, $dataForm );

		if( $dataEle.length == 0 )
			return true;

		var value = '';

		//處理 checkbox
		if( $dataEle.hasClass( 'checkboxGroup' ) ){
			$( 'input:checkbox:checked', $dataEle ).each( function( index ){
				if( index != 0 )
					value += ',';

				value += $(this).val();
			});
		//process radio button
		}else if( $dataEle.hasClass( 'radioGroup' ) ){
			value = $( 'input:radio:checked', $dataEle ).val();
		}
		else
			value = $dataEle.val();

		rowData[ headerName ] = value;
	});

	return rowData;
}

function checkPkValue( $dataForm ){
	var valid = true;

	$( '[pk=true]', $dataForm ).each( function(){
		var $ele = $(this);
		var $pkEle = $( '#' + $ele.attr( 'id' ) + '_pk' );

		if( $ele.val() != $pkEle.val() ){
			appendMsgToStatusField( $ele.attr( 'alt' ) + ':' + '欄位,不可修改' );
			setColorForStatusField( 'red' );

			valid = false;
		}
	});

	return valid;
}

function checkPKByGrid( $dataForm ){
	var $pkEles = $( '[pk=true]', $dataForm );
	var valid = true;
	var tableName = $dataForm.attr( 'table' );
	var $tempForm = $( '#tempForm' );
	var $tableHiddenEle = $( '<input type="hidden" name="tableName_common">' );
	var url = getContextPath() + '/common!getCount';

	$tableHiddenEle.val( tableName );

	if( $pkEles.length == 0 )
		return true;

	if( tableName == null || $.trim( tableName ).length == 0 ){
		console.log('未指定 tableName');
		return true;
	}


	if( $tempForm.length == 0 ){
		$tempForm = $( '<form id="tempForm"></form>' );
		$( 'body' ).append( $tempForm );
	}
	else
		$tempForm.empty();

	$tempForm.append( $tableHiddenEle );

	$pkEles.each( function(){
		var $columnEle = $( '<input type="hidden" name="column_common">' );
		var $valueEle = $( '<input type="hidden" name="value_common">' );
		var column = $(this).attr( 'column' );

		if( column == null || $.trim( column ).length == 0 )
			column = $(this).attr( 'id' );

		$columnEle.val( column );
		$valueEle.val( $(this).val() );

		$tempForm.append( $columnEle ).append( $valueEle );
	});

	$.ajaxSetup({async:false});
	$.post( url, $tempForm.serialize(), function( callback ){
		$.ajaxSetup({async:true});

		if( callback.status == 'ok' ){
			if( callback.data.count != 0 ){
				appendMsgToStatusField( '資料已存在' );
				setColorForStatusField( 'red' );

				valid = false;
			}
		}else{
			showStatusMsg( callback.status, callback.msg );
			valid = false;
		}
	});

	return valid;
}

function subscribeSortColTopics( $gridEle, $searchEle, $gridCondition, gridMode, debug ){
	var lastSortColumnIndex = null;

	return function( event ){
		if( debug )
			alert( 'run subscribeSortColTopics' + gridMode + '() function.' );

		//sjg:column , 如果 index 沒有設定, 以去取得到 name
		var sortColumnName = $gridEle.jqGrid( 'getGridParam', 'sortname' );
		var sortOrder = $gridEle.jqGrid( 'getGridParam', 'sortorder' );

		var $sortColumnNameEle = $( '#sortColumnName', $gridCondition );
		var $sortOrderEle = $( '#sortOrder', $gridCondition );

		var sortColumnIndex = event.originalEvent.iCol;
		var colModels = $gridEle.jqGrid( 'getGridParam', 'colModel' );

		if( debug )
			alert( 'sortColumnName:' + sortColumnName + ', sortOrder:' + sortOrder + ', sortColumnIndex:' + sortColumnIndex );

		if( $sortColumnNameEle.length == 0 ){
			alert( '未指定 sortColumnName hidden element' );
			return;
		}

		if( $sortOrderEle.length == 0 ){
			alert( '未指定 sortOrder hidden element' );
			return;
		}

		if( lastSortColumnIndex != null && lastSortColumnIndex != sortColumnIndex ){
			var gridId = $gridEle.attr( 'id' );
			var thId = gridId + '_' + colModels[lastSortColumnIndex].name;

			$( '#' + thId + ' .s-ico' ).show();
		}

		lastSortColumnIndex = sortColumnIndex;

		$sortColumnNameEle.val( sortColumnName );
		$sortOrderEle.val( sortOrder );

		$searchEle.trigger( 'click', 1 );
	};
}

function searchByGrid( $searchUrl, $gridCondition, $gridEle, page, autoSelected, autoSelectedWhenRows, gridMode, name, debug ){
	var url = getContextPath() + '/' + $searchUrl.val();

	if( debug )
		alert( 'in searchByGrid() function, page:' + page + ', url:' + url );

	$.ajaxSetup({ async:false });
	$.post( url , $gridCondition.serialize(), function( data ){
		$.ajaxSetup({ async:true });

		if( debug )
			alert( 'in searchByGrid function, callbackData:' + JSON.stringify( data ) );

		$gridEle[0].addJSONData( data );

		showStatusMsg( data.status, data.msg );

		if( data.status == 'ok' ){
			var validTemp = false;
			if( autoSelectedWhenRows == 0 )
				validTemp = ( $gridEle.jqGrid( 'getDataIDs' ).length != 0 );
			else
				validTemp = ( $gridEle.jqGrid( 'getDataIDs' ).length == autoSelectedWhenRows );

			if( page == '1' && autoSelected && validTemp ){

				$gridEle.jqGrid( 'setGridParam', { selrow : '1' } );

				$.publish( name + '_selectRowTopics' + gridMode );
			}

			//如果查無資料, 會在狀態列顯示 [查無資料]
			if( data.records == 0 )
				showStatusMsg( 'ok', ' [查無資料]' );

			if( gridMode == 1 )
				doAfterQuery1( name, data.gridModel, debug );
			else if( gridMode == 2 )
				doAfterQuery2( name, data.gridModel, debug );
			else if( gridMode == 3 )
				doAfterQuery3( name, data.gridModel, debug );
			else if( gridMode == 4 )
				doAfterQuery4( name, data.gridModel, debug );
		}
	});
}

function getPrefix( value, delim ){
	var idx = value.indexOf( delim );

	if( idx == -1 )
		return '';

	return value.substring( 0, idx );
}
/**
 * ======================= 以下為 private ================================
 */
function cloneHidden( $ele, cellValue, $dataForm ){
	var idPk = $ele.attr( 'id' ) + '_pk';
	var pkEle = $( '#' + idPk, $dataForm );

	if( pkEle.length == 0  ){
		pkEle = $( '<input type="hidden" id="' + idPk + '">' );

		$dataForm.prepend( pkEle );
	}

	pkEle.val( cellValue );
}

function doBefore( name, debug, actionName ){
	if( debug ){
		alert( 'run doBefore' + actionName + '() function, name:' + name );
	}

	return true;
}

function doAfter( name, data, debug, actionName ){
	if( debug )
		alert( 'run doAfter' + actionName + '() function, name:' + name + ', data:' + JSON.stringify( data ) );
}
/**
 * ======================= 以下未整理 ================================
 */
(function($) {
	$.fn.extend({
		outerHtml : function() {
			return $('<div>').append(this.clone()).remove().html();
		}
	});
})(jQuery);

function convertRocDateString2Date( value ){
	var v = new String(value);
	var Y,M,D;
	if (v.length == 9) {
		/*100/12/15*/
		Y = v.substring(0,3)-0+1911;
		M = v.substring(4,6)-0-1;
		D = v.substring(7,9)-0;
		return (new Date(Y,M,D));
	} else if (v.length == 8) {
		/*98/12/15*/
		Y = v.substring(0,2)-0+1911;
		M = v.substring(3,5)-0-1;
		D = v.substring(6,8)-0;
		return (new Date(Y,M,D));
	}
		return (new Date());
}

/**
 * check element
 * @param $ele
 * @param idName
 */
function checkElement( $ele, idName ){
	if( $ele.length == 0 )
		alert( '無法找到指定的 selector, 當  id:' + idName );
}

/**
 * check range value
 * @param $ele
 * @param n
 * @param m
 */
function checkRangeValue( $ele, n, m ){
	if( $ele.length == 0 )
		return;

	var value = Number( $ele.val().trim() );

	if( isNaN( value ) || value < n || value > m )
		alert( '指定的 value 不合法, id:' + $ele.attr( 'id' ) + ', value:' + $ele.val() );
}

/**
 * disable button
 * @param $buttonEle
 */
function disableButton( $buttonEle ){
	if( $buttonEle.length != 0 )
		$buttonEle.attr( 'disabled', 'disabled' );
}

/**
 * enable button
 * @param $buttonEle
 */
function enableButton( $buttonEle ){
	if( $buttonEle.length != 0 )
		$buttonEle.removeAttr( 'disabled' );
}

function checkNull( value, name ){
	if( value == null ){
		alert( '尚未指定 ' + name );
		return false;
	}

	return true;
}

function checkTypeByString( value, name ){
	return checkType( value, name, 'string' );
}

function checkTypeByObject( value, name ){
	return checkType( value, name, 'object' );
}

function checkType( value, name, type ){
	if( typeof( value ) != type ){
		alert( '指定 ' + name + ' 的型態錯誤, 請改為 ' + type );
		return false;
	}

	return true;
}

function checkSelector( selector, name ){
	if( selector.length == 0 ){
		alert( '指定的 ' + name + ' selector 找不到' );
		return false;
	}

	return true;
}

function addHiddenEleToForm( $form, name, id, value ){
	var $hiddenEle = $( '#' + id, $form );

	if( $hiddenEle.length == 0 ){
		$hiddenEle = $( '<input type="hidden"/>' );
		$hiddenEle.attr( 'name', name ).attr( 'id', id );

		$form.append( $hiddenEle );
	}

	$hiddenEle.val( value );
}