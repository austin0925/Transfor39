/**
 * 功能:
 * 	1. 查詢;新增;刪除;修改的頁面在同一個 tab, 查詢條件區域和資料區域是同一塊
 * 範例: http://127.0.0.1:8080/yourContext/sampleIndex( sampleGrid-2XX.jsp )
 * 使用規則:
 * 1. 在搜尋按鈕給一個 id, 我們這邊用 "master" 為開頭(可以改變這個名字), 但要以 "_searchButton2" 結尾, 如; id="master_searchButton2",
 * 2. 其它的按鈕的 id 就要以 "master" 為開頭, 目前要設定的按鈕如下, 如果畫面不需要有這個按鈕, 請用 style="display: none;" 來隱藏按鈕,
 *    如果沒有設定, 那這個 framework 會提示哪個 element 沒有設定 id
 * 		2.1  id="master_gridCondition2", 在個 <form> 底下, 要放固定的參數, 如下
 * 				2.1.1 id="searchUrl"
 * 				2.1.2 id="addUrl"
 * 				2.1.3 id="updateUrl"
 * 				2.1.4 id="deleteUrl"
 * 				2.1.5 id="printUrl"
 * 				2.1.6 id="rows", 不用設值
 * 				2.1.7 id="page", 不用設值
 * 				2.1.8 id="isTriggerChangeEvent" : 預設值為 true, 功能:當資料區域有 combobox, 那當選完資料, 將資料帶到資料區域,如遇到 select 且資料有改變 會 trigger change event
 * 		2.2  id="master_grid2"
 * 		2.3  id="master_selectRowTopics2"
 * 		2.4  id="master_pagingTopics2"
 * 		2.5  id="master_dataForm2"
 * 		2.6  id="master_addButton2"
 * 		2.7  id="master_updateButton2"
 * 		2.8  id="master_deleteButton2"
 * 		2.9  id="master_printButton2"
 * 		2.10 id="master_resetButton2"
 * 3. 提供下列方法, 如果要用到, 才去 overwrite
 * 		3.1  doBeforeQuery2( name )		: trigger 搜尋按鈕, 在發動  request 之前, 通常用於檢查資料是否完整性(複雜的 validation)
 * 		3.2  doAfterQuery2( name, data ): response 後要做的事
 * 		3.3  doAfterSelect2()			: 選完資料後要做的事
 * 		3.4  doBeforeAdd2()				: trigger 新增按鈕, 在發動  request 之前, 要做的事
 * 		3.5  doAfterAdd2()				: response 後要做的事
 *      3.6  doBeforeUpdate2()			: trigger 更新按鈕, 在發動  request 之前, 要做的事
 *      3.7  doAfterUpdate2()			: response 後要做的事
 *      3.8  doBeforeDelete2()			: trigger 刪除按鈕, 在發動  request 之前, 要做的事
 *      3.9  doAfterDelete2()			: response 後要做的事
 *      3.10 doBeforeReset2()			: trigger 清除按鈕, 未將欄位資料清除, 要做的事
 *      3.11 doAfterReset2()			: 清完資料後要做的事
 *      3.12 doBeforePrint2()			: 未實作
 *      3.12 doAfterPrint2()			: 未實作
 */
$( function(){
	$( '[id$=_searchButton2]' ).each( function(){
		initialGrid2( $(this) );
	});

	$( window ).on( 'load', doOnLoadByGrid( '2' ) );
});

function initialGrid2( $searchEle ){

	var id = $searchEle.attr( 'id' );
	var name = id.replace( '_searchButton2', '' );

	var $addButtonEle = $( '#' + name + '_addButton2' );

	var $updateButtonEle = $( '#' + name + '_updateButton2' );
	disableButton( $updateButtonEle );

	var $deleteButtonEle = $( '#' + name + '_deleteButton2' );
	disableButton( $deleteButtonEle );

	var $printButtonEle = $( '#' + name + '_printButton2' );
	disableButton( $printButtonEle );

	var $resetButtonEle = $( '#' + name + '_resetButton2' );

	var $gridCondition = $( '#' + name + '_gridCondition2' );
	checkElement( $gridCondition, name + '_gridCondition2' );

	var $currentGrid = $( '#currentGrid', $gridCondition );

	var $gridEle = ( $currentGrid.length == 0 ? $( '#' + name + '_grid2' ) : $( '#' + $currentGrid.val() ) );
	checkElement( $gridEle, name + '_grid2' );

	console.log( 'use grid in initial, gridId:' + $gridEle.attr( 'id' ) );

	var $dataForm = $( '#' + name + "_dataForm2" );
	checkElement( $dataForm, name + '_dataForm2' );

	var $addUrl = $( '#addUrl', $gridCondition );
	checkElement( $addUrl, 'addUrl' );

	var $searchUrl = $( '#searchUrl', $gridCondition );
	checkElement( $searchUrl, 'searchUrl' );

	var $addUrl = $( '#addUrl', $gridCondition );
	checkElement( $addUrl, 'addUrl' );

	var $updateUrl = $( '#updateUrl', $gridCondition );
	checkElement( $updateUrl, 'updateUrl' );

	var $deleteUrl = $( '#deleteUrl', $gridCondition );
	checkElement( $deleteUrl, 'deleteUrl' );

	var $printUrl = $( '#printUrl', $gridCondition );
	checkElement( $printUrl, 'printUrl' );

	var $rows = $( '#rows', $gridCondition );
	checkElement( $rows, 'rows' );

	var $page = $( '#page', $gridCondition );
	checkElement( $page, 'page' );

	var $debugEle = $( '#debug', $gridCondition );
	checkElement( $debugEle, 'debug' );

	var $isTriggerChangeEventEle = $( '#isTriggerChangeEvent', $gridCondition );
	var $autoSelected = $( '#autoSelected', $gridCondition );
	var $autoSelectedWhenRows = $( '#autoSelectedWhenRows', $gridCondition );
	var $isFillDataToDataForm = $( '#isFillDataToDataForm', $gridCondition );

	var debug = (  $debugEle.val() == 'true' );
	var isTriggerChangeEvent = ( $isTriggerChangeEventEle.length == 0 ? true : $isTriggerChangeEventEle.val() == 'true' );
	var autoSelected = ( $autoSelected.length == 0 ? true : $autoSelected.val() == 'true' );
	var autoSelectedWhenRows = ( $autoSelectedWhenRows.length == 0 ? 1 : $autoSelectedWhenRows.val() );
	var isFillDataToDataForm = ( $isFillDataToDataForm.length == 0 ? true : $isFillDataToDataForm.val() == 'true' );

	$.subscribe( name + '_sortColTopics2', subscribeSortColTopics( $gridEle, $searchEle, $gridCondition, '2', debug ) );
	$.subscribe( name + '_pagingTopics2', subscribePagingTopics2( $searchEle, $gridEle, debug ) );
	$.subscribe( name + '_selectRowTopics2', subscribeSelectRowTopics2( $gridEle, $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, isTriggerChangeEvent, isFillDataToDataForm, debug  ));

	$searchEle.bind( 'click', bindClickEventForSearchButton2( $gridEle, $gridCondition, $dataForm, $searchUrl, $rows, $page, autoSelected, autoSelectedWhenRows, name, id, debug  ) );
	$addButtonEle.bind( 'click', bindClickEventForAddButton2( $gridEle, $addUrl, $dataForm, name, debug  ) );
	$updateButtonEle.bind( 'click', bindClickEventForUpdateButton2( $gridEle, $updateUrl, $dataForm, name, debug  ) );
	$deleteButtonEle.bind( 'click', bindClickEventForDeleteButton2( $gridEle, $deleteUrl, $dataForm, $resetButtonEle, name, debug  ) );
	//$printButtonEle.bind( 'click', bindClickEventForPrintButton2( $printUrl, name, debug  ) );
	$resetButtonEle.bind( 'click', bindClickEventForResetButton2( $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, isTriggerChangeEvent, debug  ) );

	initialValidation( $dataForm );
}

/**
 * complete
 * @param $gridEle
 * @returns {Function}
 */
function subscribePagingTopics2( $searchEle, $gridEle, debug  ){
	return function(){
		if( debug )
			alert( 'run subscribePagingTopics2() function.' );

		$searchEle.trigger( 'click', $gridEle.jqGrid( 'getGridParam', 'page' ) );
	};
}

/**
 * complete
 * @param $grid
 * @param $dataForm
 * @param name
 * @returns {Function}
 */
function subscribeSelectRowTopics2( $gridEle, $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, isTriggerChangeEvent, isFillDataToDataForm, debug  ){
	return function(){
		if( debug )
			alert( 'run subscribeSelectRowTopics2() function.' );

		console.log( 'subscribeSelectRowTopics2, gridId:' + $gridEle.attr( 'id' ) );

		if( isFillDataToDataForm )
			fillDataToElementForSelectRow( $gridEle, $dataForm, isTriggerChangeEvent );

		enableButton($updateButtonEle);
		enableButton($deleteButtonEle);
		enableButton($printButtonEle);

		var rowData = $gridEle.jqGrid( 'getRowData', $gridEle.jqGrid( 'getGridParam', 'selrow' ) );

		/*for Libra */
		$("#detail_dataForm2 #libraCopy").val("");
		var form = $("#detail_dataForm2").serialize();
		form = form.replace(new RegExp("%2F","gm"),"/");
		$("#detail_dataForm2 #libraCopy").val(form);

		doAfterSelect2( name, debug, rowData  );
	};
}


/**
 * complete
 * @param $gridEle
 * @param $gridCondition
 * @param $searchUrl
 * @param $rows
 * @param $page
 * @param name
 * @returns {Function}
 */
function bindClickEventForSearchButton2( $gridEle, $gridCondition, $dataForm, $searchUrl, $rows, $page, autoSelected, autoSelectedWhenRows, name, id, debug ){
	return function( event, page ){
		if( debug )
			alert(  'run bindClickEventForSearchButton2() function.' );

		console.log( 'bindClickEventForSearchButton2, gridId:' + $gridEle.attr( 'id' ) );

		cleanMsgForStatusField();

		var copy = true;

		if( page == undefined ){
			page = '1';

			var validationAttrNames = [ 'class', 'dateRange', 'minlength', 'rangelength', 'equalLength', 'lessThanDecimal', 'max', 'min', 'range', 'isExistByCode', 'isExistByCode' ];

			$( 'input:text,input:password,select,textarea', $dataForm ).filter( ':not([role])' ).each( function(){
				var $ele = $(this);

				$.each( validationAttrNames, function( index, attrName ){
					var searchValue = $ele.attr( attrName + '_search' );
					var originalValue = $ele.attr( attrName );

					if( originalValue != undefined && $.trim( originalValue ) != 0 )
						$ele.attr( attrName + '_temp', originalValue ).removeAttr( attrName );

					if( searchValue != undefined && $.trim( searchValue ) != 0 )
						$ele.get(0).setAttribute( attrName, searchValue );
				});

				console.log( 'search:', $ele.outerHtml() );
			});

			if( debug )
				alert( 'before validation:' + $dataForm.outerHtml() );

			var valid = $dataForm.valid();

			$( 'input:text,input:password,select,textarea', $dataForm ).filter( ':not([role])' ).each( function(){
				var $ele = $(this);

				$.each( validationAttrNames, function( index, attrName ){
					var tempValue = $ele.attr( attrName + '_temp' );
					var originalValue = $ele.attr( attrName );

					if( originalValue != null && $.trim( originalValue ) != 0 )
						$ele.removeAttr( attrName );

					if( tempValue != null && $.trim( tempValue ) != 0 )
						$ele.attr( attrName, tempValue );
				});

				console.log( $ele.outerHtml() );
			});

			if( debug )
				alert( 'after validation:' + $dataForm.outerHtml() );

			if( !valid )
				return false;

			if( !doBeforeQuery2( name, debug ) )
				return false;
		}
		else{
			//來自 按下下一頁, 上一頁等等的 trigger
			copy = false;
		}

		$rows.val( $gridEle.jqGrid( 'getGridParam', 'rowNum' ) );
		$page.val( page );

		if( copy )
			copyDataFormToCondition( $gridCondition, $dataForm, id, debug );

		searchByGrid( $searchUrl, $gridCondition, $gridEle, page, autoSelected, autoSelectedWhenRows, 2, name, debug );
	};
}

/**
 * bind event for add button 2
 * (complete)
 * @param $addUrl
 * @param name
 * @returns {Function}
 */
function bindClickEventForAddButton2( $gridEle, $addUrl, $dataForm, name, debug  ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForAddButton2() function.' );

		cleanMsgForStatusField();

		doBeforeValidationByAdd2( name, debug );

		if( !$dataForm.valid() )
			return false;

		if( !checkPKByGrid( $dataForm ) )
			return false;

		if( !doBeforeAdd2( name, debug ) )
			return false;

		var addUrl = $addUrl.val();

		if( debug )
			alert( 'in bindClickEventForAddButton2() function, addUrl:' + addUrl );

		/**
		 *先跳至最後一頁，再送資料至後端(當current page 已是最後一頁時，不會triiger subscribePagingTopics2 event)。
		 */
		$( '#last_' + $gridEle.attr( 'id' ) + '_pager' ).trigger( 'click' );

		$.post( addUrl, $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForAddButton2() function, callbackDaata:' + JSON.stringify( data ) );

			showStatusMsg( data.status, data.msg );

			if( data.status == 'ok' ){
				doAfterAdd2( name, data.data, debug );

				var rowId = $gridEle.jqGrid( 'getGridParam', 'records' ) + 1;

				$gridEle.jqGrid( 'addRowData', rowId, getRowDataByGrid( $gridEle, $dataForm ) );

				/**
				 * 連續add 會重複select，所以先resetSelect，再setSelect
				 *
				 */
				$gridEle.jqGrid('resetSelection');
				$gridEle.jqGrid( 'setSelection', rowId );
			}
		});
	};
}

/**
 * compltete
 * @param $updateUrl
 * @param $dataForm
 * @param name
 */
function bindClickEventForUpdateButton2( $gridEle, $updateUrl, $dataForm, name, debug  ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForUpdateButton2() function.' );

		cleanMsgForStatusField();

		doBeforeValidationByUpdate2( name, debug );

		if( !$dataForm.valid() )
			return false;

		if( !checkPkValue( $dataForm ) )
			return false;

		if( !doBeforeUpdate2( name, debug ) )
			return false;

		$.post( $updateUrl.val(), $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForUpdateButton2() function, callbackDaata:' + JSON.stringify( data ) );

			showStatusMsg( data.status, data.msg );

			if( data.status == 'ok' ){
				doAfterUpdate2( name, data.data, debug );
				/* for Libra */
				//$("#detail_dataForm2 #libraCopy").val("");
				$("#libraCopy").val("");
				var form = $("#detail_dataForm2").serialize();
				form = form.replace(new RegExp("%2F","gm"),"/");
				//$("#detail_dataForm2 #libraCopy").val(form);
				$("#libraCopy").val(form);

				var rowId = $gridEle.jqGrid( 'getGridParam', 'selrow' );

				$gridEle.jqGrid( 'setRowData', rowId, getRowDataByGrid( $gridEle, $dataForm ) );
			}
		});
	};
}

/**
 * complete
 * @param $deleteUrl
 * @param $dataForm
 * @param name
 * @returns {Function}
 */
function bindClickEventForDeleteButton2( $gridEle, $deleteUrl, $dataForm, $resetButtonEle, name, debug  ){
	return function(){
		if( debug ){
			alert( 'run bindClickEventForDeleteButton2() function.' );
		}

		cleanMsgForStatusField();

		if( !checkPkValue( $dataForm ) )
			return false;

		if( !doBeforeDelete2( name, debug ) )
			return false;

		if( !confirm( '確定刪除此筆資料?' ) )
			return;

		$.post( $deleteUrl.val(), $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForDeleteButton2() function, callbackDaata:' + JSON.stringify( data ) );

			if( data.status == 'ok' ){
				$gridEle.jqGrid( 'delRowData', $gridEle.jqGrid( 'getGridParam', 'selrow' ) );

				$resetButtonEle.trigger( 'click' );

				doAfterDelete2( name, data.data, debug );
			}

			showStatusMsg( data.status, data.msg );
		});
	};
}

/**
 * complete
 * @param $dataForm
 * @param name
 * @returns {Function}
 */
function bindClickEventForResetButton2( $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, isTriggerChangeEvent, debug  ){
	return function(){
			if( debug )
				alert( 'run bindClickEventForResetButton2() function.' );

			if( !doBeforeReset2( name, debug ) )
				return false;

			resetValue( $dataForm, isTriggerChangeEvent );

			disableButton( $updateButtonEle );
			disableButton( $deleteButtonEle );
			disableButton( $printButtonEle );

			cleanMsgForStatusField();

			doAfterReset2( name, debug );
		};
	}

/**
 *
 * @param $gridCondition
 * @param $dataForm
 * @param debug
 */
function copyDataFormToCondition( $gridCondition, $dataForm, id, debug ){
	$( 'input[type=text]:not( [role] ), select:not( [role] ), input[type=hidden]:not( [role] ), textarea:not( [role] )', $dataForm ).each( function(){
		var $eleInDataForm = $(this);
		var eleId = $eleInDataForm.attr( 'id' );
		var $eleInCondition = $( '#' + eleId, $gridCondition );

		if( $eleInCondition.length == 0 ){
			$eleInCondition = $( '<input type="hidden"/>' );
			$gridCondition.append( $eleInCondition );

			$eleInCondition.attr( 'name', $eleInDataForm.attr( 'name' ) ).attr( 'id', $eleInDataForm.attr( 'id' ) );

			if( !debug )
				$eleInCondition.hide();
		}

		var value;
		if( $eleInDataForm.prop( 'tagName' ) == 'TEXTAREA' )
			value = $eleInDataForm.text();
		else
			value = $eleInDataForm.val();

		$eleInCondition.val( value );
	});

	$( 'div.checkboxGroup,div.radioGroup', $dataForm ).each( function(){
		var $eleInDataForm = $(this);
		var eleId = $eleInDataForm.attr( 'id' );
		var $eleInCondition = $( '#' + eleId, $gridCondition );

		if( $eleInCondition.length == 0 ){
			$eleInCondition = $eleInDataForm.clone();
			$gridCondition.append( $eleInCondition );
		}

		$eleInCondition.empty();

		$( 'input:checkbox:checked,input:radio:checked', $eleInDataForm ).each( function(){
			var $checkboxInDataForm = $(this);
			var $checkboxInCondition = $( '<input type="hidden"/>' );

			$checkboxInCondition.attr( 'name', $checkboxInDataForm.attr( 'name' ) ).val( $checkboxInDataForm.val() );

			$eleInCondition.append( $checkboxInCondition );
		});

		if( !debug )
			$eleInCondition.hide();
	});

	if( debug )
		alert( 'in gridCondition:' + $gridCondition.html() );
}

function doBeforeQuery2( name, debug ){
	if( debug )
		alert( 'callback doBeforeQuery2(), name:' + name );

	return true;
}

function doAfterQuery2( name, data, debug ){
	if( debug )
		alert( 'callback doAfterQuery2(), name:' + name + ', data:' + JSON.stringify( data ) );
}

function doAfterSelect2( name, debug, data ){
	if( debug )
		alert( 'callback doAfterSelect2(), name:' + name + ', data:' + JSON.stringify( data ) );
}

function doBeforeAdd2( name, debug ){
	$("#libraCopy").val("");
	if( debug )
		alert( 'callback doBeforeAdd2(), name:' + name );

	return true;
}

function doAfterAdd2( name, data, debug ){
	if( debug )
		alert( 'callback doAfterAdd2(), name:' + name + ', data:' + JSON.stringify( data ) );
}

function doBeforeUpdate2( name, debug ){
	if( debug )
		alert( 'callback doBeforeUpdate2(), name:' + name );

	return true;
}

function doAfterUpdate2( name, data, debug ){
	if( debug )
		alert( 'callback doAfterUpdate2(), name:' + name );
}

function doBeforeDelete2( name, debug ){
	$("#libraCopy").val("");
	if( debug )
		alert( 'callback doBeforeDelete2(), name:' + name );

	return true;
}

function doAfterDelete2( name, data, debug ){
	if( debug )
		alert( 'callback doAfterDelete2(), name:' + name );
}

function doBeforeReset2( name, debug ){
	if( debug )
		alert( 'callback doBeforeReset2(), name:' + name );

	return true;
}

function doAfterReset2( name, debug ){
	if( debug )
		alert( 'callback doAfterReset2(), name:' + name );
}

function doBeforeValidationByAdd2( name, debug ){
	if( debug )
		alert( 'callback doBeforeValidationByAdd2(), name:' + name );
}

function doBeforeValidationByUpdate2( name, debug ){
	if( debug )
		alert( 'callback doBeforeValidationByUpdate2(), name:' + name );
}