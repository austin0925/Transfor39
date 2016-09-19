/**
 * 功能:
 * 	1. 新增;刪除;修改的頁面在同一個 tab, 但沒有查詢條件
 *  2. 若 Grid 有資料, 預設會將第一筆資料帶資料區
 * 範例: http://127.0.0.1:8080/yourContext/sampleIndex( sampleGrid-3XX.jsp )
 * 使用規則:
 * 1. 在搜尋按鈕給一個 id, 我們這邊用 "detail" 為開頭(可以改變這個名字), 但要以 searchButton3 結尾, 如; id="detail_searchButton3",
 * 2. 其它的按鈕的 id 就要以 "detail" 為開頭, 目前要設定的按鈕如下, 如果畫面不需要有這個按鈕, 請用 style="display: none;" 來隱藏按鈕,
 *    如果沒有設定, 那這個 framework 會提示哪個 element 沒有設定 id
 * 		2.1  id="detail_gridCondition3", 在個 <form> 底下, 要放固定的參數, 如下
 * 				2.1.1 id="searchUrl"
 * 				2.1.2 id="addUrl"
 * 				2.1.3 id="updateUrl"
 * 				2.1.4 id="deleteUrl"
 * 				2.1.5 id="printUrl"
 * 				2.1.6 id="rows", 不用設值
 * 				2.1.7 id="page", 不用設值
 * 				2.1.8 id="isTriggerChangeEvent" : 預設值為 true, 功能:當資料區域有 combobox, 那當選完資料, 將資料帶到資料區域,如遇到 select 且資料有改變 會 trigger change event
 * 		2.2  id="detail_grid3"
 * 		2.3  id="detail_selectRowTopics3"
 * 		2.4  id="detail_pagingTopics3"
 * 		2.5  id="detail_dataForm3"
 * 		2.6  id="detail_addButton3"
 * 		2.7  id="detail_updateButton3"
 * 		2.8  id="detail_deleteButton3"
 * 		2.9  id="detail_printButton3"
 * 		2.10 id="detail_resetButton3"
 * 3. 提供下列方法, 如果要用到, 才去 overwrite
 * 		3.1  doBeforeQuery3( name )		: trigger 搜尋按鈕, 在發動  request 之前, 通常用於檢查資料是否完整性(複雜的 validation)
 * 		3.2  doAfterQuery3( name, data ): response 後要做的事
 * 		3.3  doAfterSelect3()			: 選完資料後要做的事
 * 		3.4  doBeforeAdd3()				: trigger 新增按鈕, 在發動  request 之前, 要做的事
 * 		3.5  doAfterAdd3()				: response 後要做的事
 *      3.6  doBeforeUpdate3()			: trigger 更新按鈕, 在發動  request 之前, 要做的事
 *      3.7  doAfterUpdate3()			: response 後要做的事
 *      3.8  doBeforeDelete3()			: trigger 刪除按鈕, 在發動  request 之前, 要做的事
 *      3.9  doAfterDelete3()			: response 後要做的事
 *      3.10 doBeforeReset3()			: trigger 清除按鈕, 未將欄位資料清除, 要做的事
 *      3.11 doAfterReset3()			: 清完資料後要做的事
 *      3.12 doBeforePrint3()			: 未實作
 *      3.13 doAfterPrint3()			: 未實作
 */
$( function(){
	$( '[id$=_searchButton3]' ).each( function(){
		initialGrid3( $(this) );
	});

	$( window ).on( 'load', doOnLoadByGrid( '3' ) );
});

function initialGrid3( $searchEle ){
	var id = $searchEle.attr( 'id' );
	var name = id.replace( '_searchButton3', '' );

	var $addButtonEle = $( '#' + name + '_addButton3' );

	var $updateButtonEle = $( '#' + name + '_updateButton3' );
	disableButton( $updateButtonEle );

	var $deleteButtonEle = $( '#' + name + '_deleteButton3' );
	disableButton( $deleteButtonEle );

	var $printButtonEle = $( '#' + name + '_printButton3' );
	disableButton( $printButtonEle );

	var $resetButtonEle = $( '#' + name + '_resetButton3' );

	var $gridCondition = $( '#' + name + '_gridCondition3' );
	checkElement( $gridCondition, name + '_gridCondition3' );

	var $currentGrid = $( '#currentGrid', $gridCondition );

	var $gridEle = ( $currentGrid.length == 0 ? $( '#' + name + '_grid3' ) : $( '#' + $currentGrid.val() ) );
	checkElement( $gridEle, name + '_grid3' );

	console.log( 'use grid in initial, gridId:' + $gridEle.attr( 'id' ) );

	var $dataForm = $( '#' + name + "_dataForm3" );
	checkElement( $dataForm, name + '_dataForm3' );

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

	$debugEle = $( '#debug', $gridCondition );
	checkElement( $debugEle, 'debug' );

	var $isTriggerChangeEventEle = $( '#isTriggerChangeEvent ', $gridCondition );
	var $autoSelected = $( '#autoSelected ', $gridCondition );
	var $autoSelectedWhenRows = $( '#autoSelectedWhenRows ', $gridCondition );

	var debug = (  $debugEle.val() == 'true' );
	var isTriggerChangeEvent = ( $isTriggerChangeEventEle.length == 0 ? true : $isTriggerChangeEventEle.val() == 'true' );
	var autoSelected = ( $autoSelected.length == 0 ? true : $autoSelected.val() == 'true' );
	var autoSelectedWhenRows = ( $autoSelectedWhenRows.length == 0 ? 0 : $autoSelectedWhenRows.val() );

	$.subscribe( name + '_sortColTopics3', subscribeSortColTopics( $gridEle, $searchEle, $gridCondition, '3', debug ) );
	$.subscribe( name + '_pagingTopics3', subscribePagingTopics3( $searchEle, $gridEle, debug   ) );
	$.subscribe( name + '_selectRowTopics3', subscribeSelectRowTopics3( $gridEle, $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, isTriggerChangeEvent, debug ));

	$searchEle.bind( 'click', bindClickEventForSearchButton3( $gridEle, $gridCondition, $searchUrl, $rows, $page, autoSelected, autoSelectedWhenRows, name, debug  ) );
	$addButtonEle.bind( 'click', bindClickEventForAddButton3( $gridEle, $addUrl, $dataForm, name, debug  ) );
	$updateButtonEle.bind( 'click', bindClickEventForUpdateButton3( $gridEle, $updateUrl, $dataForm, name, debug  ) );
	$deleteButtonEle.bind( 'click', bindClickEventForDeleteButton3( $gridEle, $deleteUrl, $dataForm, $resetButtonEle, name, debug  ) );
	//$printButtonEle.bind( 'click', bindClickEventForPrintButton3( $printUrl, name, debug  ) );
	$resetButtonEle.bind( 'click', bindClickEventForResetButton3( $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, debug, isTriggerChangeEvent ) );

	initialValidation( $dataForm );
}

/**
 * complete
 * @param $gridEle
 * @returns {Function}
 */
function subscribePagingTopics3( $searchEle, $gridEle, debug  ){
	return function(){
		if( debug )
			alert( 'run subscribePagingTopics3() function.' );

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
function subscribeSelectRowTopics3( $gridEle, $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, isTriggerChangeEvent, debug ){
	return function(){
		if( debug )
			alert( 'run subscribeSelectRowTopics3() function.' );

		console.log( 'subscribeSelectRowTopics3, gridId:' + $gridEle.attr( 'id' ) );

		fillDataToElementForSelectRow( $gridEle, $dataForm, isTriggerChangeEvent );

		enableButton($updateButtonEle);
		enableButton($deleteButtonEle);
		enableButton($printButtonEle);

		/*for Libra */
		//$("#detail_dataForm3 #libraCopy").val("");
		$("#libraCopy").val("");
		var form = $("#detail_dataForm3").serialize();
		form = form.replace(new RegExp("%2F","gm"),"/");
		//$("#detail_dataForm3 #libraCopy").val(form);
		$("#libraCopy").val(form);
		doAfterSelect3( name, debug );
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
function bindClickEventForSearchButton3( $gridEle, $gridCondition, $searchUrl, $rows, $page, autoSelected, autoSelectedWhenRows, name, debug  ){
	return function( data, page ){
		if( debug )
			alert(  'run bindClickEventForSearchButton3() function.' );

		console.log( 'bindClickEventForSearchButton3, gridId:' + $gridEle.attr( 'id' ) );

		if( page == undefined ){
			page = '1';

			if( !doBeforeQuery3( name, debug ) )
				return false;
		}

		$rows.val( $gridEle.jqGrid( 'getGridParam', 'rowNum' ) );
		$page.val( page );

		searchByGrid( $searchUrl, $gridCondition, $gridEle, page, autoSelected, autoSelectedWhenRows, 3, name, debug );
	};
}

/**
 * bind event for add button 3
 * (complete)
 * @param $addUrl
 * @param name
 * @returns {Function}
 */
function bindClickEventForAddButton3( $gridEle, $addUrl, $dataForm, name, debug  ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForAddButton3() function.' );

		cleanMsgForStatusField();

		doBeforeValidationByAdd3( name, debug );

		if( !$dataForm.valid() )
			return false;

		if( !checkPKByGrid( $dataForm ) )
			return false;

		if( !doBeforeAdd3( name, debug ) )
			return false;

		var addUrl = $addUrl.val();

		if( debug )
			alert( 'in bindClickEventForAddButton3() function, addUrl:' + addUrl );

		/**
		 *先跳至最後一頁，再送資料至後端(當current page 已是最後一頁時，不會triiger subscribePagingTopics3 event)。
		 */
		$( '#last_' + $gridEle.attr( 'id' ) + '_pager' ).trigger( 'click' );

		$.post( addUrl, $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForAddButton3() function, callbackDaata:' + JSON.stringify( data ) );

			showStatusMsg( data.status, data.msg );

			if( data.status == 'ok' ){
				doAfterAdd3( name, data.data, debug );

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
function bindClickEventForUpdateButton3( $gridEle, $updateUrl, $dataForm, name, debug  ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForUpdateButton3() function.' );

		cleanMsgForStatusField();

		doBeforeValidationByUpdate3( name, debug );

		if( !$dataForm.valid() )
			return false;

		if( !checkPkValue( $dataForm ) )
			return false;

		if( !doBeforeUpdate3( name, debug ) )
			return false;

		$.post( $updateUrl.val(), $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForUpdateButton3() function, callbackDaata:' + JSON.stringify( data ) );

			showStatusMsg( data.status, data.msg );

			if( data.status == 'ok' ){
				doAfterUpdate3( name, data.data, debug );

				/*for Libra */
				$("#detail_dataForm2 #libraCopy").val("");
				var form = $("#detail_dataForm2").serialize();
				form = form.replace(new RegExp("%2F","gm"),"/");
				$("#detail_dataForm2 #libraCopy").val(form);

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
function bindClickEventForDeleteButton3( $gridEle, $deleteUrl, $dataForm, $resetButtonEle, name, debug  ){
	return function(){
		if( debug ){
			alert( 'run bindClickEventForDeleteButton3() function.' );
		}

		cleanMsgForStatusField();

		if( !checkPkValue( $dataForm ) )
			return false;

		if( !doBeforeDelete3( name, debug ) )
			return false;

		if( !confirm( '確定刪除此筆資料?' ) )
			return;

		$.post( $deleteUrl.val(), $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForDeleteButton3() function, callbackDaata:' + JSON.stringify( data ) );

			showStatusMsg( data.status, data.msg );

			if( data.status == 'ok' ){
				$gridEle.jqGrid( 'delRowData', $gridEle.jqGrid( 'getGridParam', 'selrow' ) );

				$resetButtonEle.trigger( 'click' );

				doAfterDelete3( name, data.data, debug );
			}
		});
	};
}

/**
 * complete
 * @param $dataForm
 * @param name
 * @returns {Function}
 */
function bindClickEventForResetButton3( $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, debug, isTriggerChangeEvent  ){
	return function(){
			if( debug )
				alert( 'run bindClickEventForResetButton3() function.' );

			if( !doBeforeReset3( name, debug ) )
				return false;

			resetValue( $dataForm, isTriggerChangeEvent );

			disableButton( $updateButtonEle );
			disableButton( $deleteButtonEle );
			disableButton( $printButtonEle );

			cleanMsgForStatusField();

			doAfterReset3( name, debug );
		};
	}

function doBeforeQuery3( name, debug ){
	if( debug )
		alert( 'callback doBeforeQuery3(), name:' + name );

	return true;
}

function doAfterQuery3( name, data, debug ){
	if( debug )
		alert( 'callback doAfterQuery3(), name:' + name + ', data:' + JSON.stringify( data ) );
}

function doAfterSelect3( name, debug ){
	if( debug )
		alert( 'callback doAfterSelect3(), name:' + name );
}

function doBeforeAdd3( name, debug ){
	$("#libraCopy").val("");
	if( debug )
		alert( 'callback doBeforeAdd3(), name:' + name );

	return true;
}

function doAfterAdd3( name, data, debug ){
	if( debug )
		alert( 'callback doAfterAdd3(), name:' + name + ', data:' + JSON.stringify( data ) );
}

function doBeforeUpdate3( name, debug ){
	if( debug )
		alert( 'callback doBeforeUpdate3(), name:' + name );

	return true;
}

function doAfterUpdate3( name, data, debug ){
	if( debug )
		alert( 'callback doAfterUpdate3(), name:' + name );
}

function doBeforeDelete3( name, debug ){
	$("#libraCopy").val("");
	if( debug )
		alert( 'callback doBeforeDelete3(), name:' + name );

	return true;
}

function doAfterDelete3( name, data, debug ){
	if( debug )
		alert( 'callback doAfterDelete3(), name:' + name );
}

function doBeforeReset3( name, debug ){
	if( debug )
		alert( 'callback doBeforeReset3(), name:' + name );

	return true;
}

function doAfterReset3( name, debug ){
	if( debug )
		alert( 'callback doAfterReset3(), name:' + name );
}

function doBeforeValidationByAdd3( name, debug ){
	if( debug )
		alert( 'callback doBeforeValidationByAdd3(), name:' + name );
}

function doBeforeValidationByUpdate3( name, debug ){
	if( debug )
		alert( 'callback doBeforeValidationByUpdate3(), name:' + name );
}