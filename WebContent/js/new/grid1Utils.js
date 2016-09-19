/**
 * 功能: 查詢頁面(搜尋條件, 顯示資料的 grid) 和 新增;刪除;修改的頁面不在同一個 tab
 * 範例: http://127.0.0.1:8080/yourContext/sampleIndex( sampleGrid-1XX.jsp )
 * 使用規則:
 * 1. 在搜尋按鈕給一個 id, 我們這邊用 "master" 為開頭(可以改變這個名字), 但要以 searchButton1 結尾, 如; id="master_searchButton1",
 * 2. 其它的按鈕的 id 就要以 "master" 為開頭, 目前要設定的按鈕如下, 如果畫面不需要有這個按鈕, 請用 style="visibility: hidden;" 來隱藏按鈕,
 *    如果沒有設定, 那這個 framework 會提示哪個 element 沒有設定 id
 * 		2.1  id="master_gridCondition1", 在個 <form> 底下, 要放固定的參數, 如下
 * 				2.1.1 id="searchUrl"
 * 				2.1.2 id="addUrl"
 * 				2.1.3 id="updateUrl"
 * 				2.1.4 id="deleteUrl"
 * 				2.1.5 id="printUrl"
 * 				2.1.6 id="rows", 不用設值
 * 				2.1.7 id="page", 不用設值
 * 				2.1.8 id="tabAfterSelectRow", option, 選擇完資料後, 會切換到到指定的 tab, 預設值2, 如果值為0, 不做切換
 * 				2.1.9 id="tabAfterDelete", option, 刪除完資料後, 會切換到指定的 tab, 預設值1, 如果值為0, 不做切換
 * 				2.1.10 id="isTriggerChangeEvent" : 預設值為 true, 功能:當資料區域有 combobox, 那當選完資料, 將資料帶到資料區域,如遇到 select 且資料有改變 會 trigger change event
 * 		2.2  id="master_grid1"
 * 		2.3  id="master_selectRowTopics1"
 * 		2.4  id="master_pagingTopics1"
 * 		2.5  id="master_searchResetButton1"
 * 		2.6  id="master_dataForm1"
 * 		2.7  id="master_addButton1"
 * 		2.8  id="master_updateButton1"
 * 		2.9  id="master_deleteButton1"
 * 		2.10 id="master_printButton1"
 * 		2.11 id="master_resetButton1"
 * 		2.12 id="master_searchAddButtonEle1"
 * 3. 提供下列方法, 如果要用到, 才去 overwrite, 不能不用理會
 * 		3.1  doBeforeQuery1( name )		: trigger 搜尋按鈕, 在發動  request 之前, 通常用於檢查資料是否完整性(複雜的 validation)
 * 		3.2  doAfterQuery1( name, data ): response 後要做的事
 * 		3.3  doAfterSelect1()			: 選完資料後要做的事
 * 		3.4  doBeforeAdd1()				: trigger 新增按鈕, 在發動  request 之前, 要做的事
 * 		3.5  doAfterAdd1()				: response 後要做的事
 *      3.6  doBeforeUpdate1()			: trigger 更新按鈕, 在發動  request 之前, 要做的事
 *      3.7  doAfterUpdate1()			: response 後要做的事
 *      3.8  doBeforeDelete1()			: trigger 刪除按鈕, 在發動  request 之前, 要做的事
 *      3.9  doAfterDelete1()			: response 後要做的事
 *      3.10 doBeforeReset1()			: trigger 維護頁面清除按鈕, 未將欄位資料清除, 要做的事
 *      3.11 doAfterReset1()			: 清完資料後要做的事
 *      3.12 doBeforeSearchReset1()		: trigger 搜尋頁面清除按鈕, 未將欄位資料清除, 要做的事
 *      3.13 doAfterSearchReset1()		: 清完資料後要做的事
 *      3.14 doBeforePrint1()			: 未實作
 *      3.15 doAfterPrint1()			: 未實作
 *      3.16 doBeforeSearchAddButton1()	: 在查詢頁面按下新增按鈕, 在共用元件未做任何事之前, 要處理的事
 *      3.17 doAfterSearchAddButton1()	: 在查詢頁面按下新增按鈕, 在共用元件已完成要做的事後, 要處理的事
 */
$( function(){
	$( '[id$=_searchButton1]' ).each( function(){
		initialGrid1( $(this) );
	});

	$( window ).on( 'load', doOnLoadByGrid( '1' ) );
});

function initialGrid1( $searchEle ){
	var id = $searchEle.attr( 'id' );
	var name = id.replace( '_searchButton1', '' );

	var $addButtonEle = $( '#' + name + '_addButton1' );

	var $updateButtonEle = $( '#' + name + '_updateButton1' );
	disableButton( $updateButtonEle );

	var $deleteButtonEle = $( '#' + name + '_deleteButton1' );
	disableButton( $deleteButtonEle );

	var $printButtonEle = $( '#' + name + '_printButton1' );
	disableButton( $printButtonEle );

	var $searchResetButtonEle = $( '#' + name + '_searchResetButton1' );

	var $searchAddButtonEle = $( '#' + name + '_searchAddButtonEle1' );

	var $resetButtonEle = $( '#' + name + '_resetButton1' );

	var $gridCondition = $( '#' + name + '_gridCondition1' );
	checkElement( $gridCondition, name + '_gridCondition1' );

	var $currentGrid = $( '#currentGrid', $gridCondition );

	var $gridEle = ( $currentGrid.length == 0 ? $( '#' + name + '_grid1' ) : $( '#' + $currentGrid.val() ) );
	checkElement( $gridEle, name + '_grid1' );

	console.log( 'use grid in initial, gridId:' + $gridEle.attr( 'id' ) );

	var $dataForm = $( '#' + name + "_dataForm1" );
	checkElement( $dataForm, name + '_dataForm1' );

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

	var $isTriggerChangeEventEle = $( '#isTriggerChangeEvent ', $gridCondition );
	var $autoSelected = $( '#autoSelected ', $gridCondition );
	var $autoSelectedWhenRows = $( '#autoSelectedWhenRows ', $gridCondition );

	var $tabAfterSelectRowEle = $( '#tabAfterSelectRow', $gridCondition );
	checkRangeValue( $tabAfterSelectRowEle, 0, 10 );

	var $tabAfterDeleteEle = $( '#tabAfterDelete', $gridCondition );
	checkRangeValue( $tabAfterDeleteEle, 0, 10 );

	var debug = ( $debugEle.val() == 'true' );
	var tabAfterSelect = ( $tabAfterSelectRowEle.length == 0 ? 2 : $tabAfterSelectRowEle.val() );
	var tabAfterDelete = ( $tabAfterDeleteEle.length == 0 ? 1 : $tabAfterDeleteEle.val() );
	var isTriggerChangeEvent = ( $isTriggerChangeEventEle.length == 0 ? true : $isTriggerChangeEventEle.val() == 'true' );
	var autoSelected = ( $autoSelected.length == 0 ? true : $autoSelected.val() == 'true' );
	var autoSelectedWhenRows = ( $autoSelectedWhenRows.length == 0 ? 1 : $autoSelectedWhenRows.val() );

	$.subscribe( name + '_sortColTopics1', subscribeSortColTopics( $gridEle, $searchEle, $gridCondition, '1', debug ) );
	$.subscribe( name + '_pagingTopics1', subscribePagingTopics1( $searchEle, $gridEle, debug ) );
	$.subscribe( name + '_selectRowTopics1', subscribeSelectRowTopics1( $gridEle, $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, tabAfterSelect, isTriggerChangeEvent, debug ) );

	$searchEle.bind( 'click', bindClickEventForSearchButton1( $gridEle, $gridCondition, $searchUrl, $rows, $page, autoSelected, autoSelectedWhenRows, name, debug ) );
	$addButtonEle.bind( 'click', bindClickEventForAddButton1( $gridEle, $addUrl, $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, debug )  );
	$updateButtonEle.bind( 'click', bindClickEventForUpdateButton1( $gridEle, $updateUrl, $dataForm, name, debug ) );
	$deleteButtonEle.bind( 'click', bindClickEventForDeleteButton1( $gridEle, $deleteUrl, $dataForm, $resetButtonEle, name, tabAfterDelete, debug ) );
	//$printButtonEle.bind( 'click', bindClickEventForPrintButton1( $printUrl, name, debug ) );
	$searchResetButtonEle.bind( 'click', bindClickEventForSearchResetButton1( $gridEle, $gridCondition, name, isTriggerChangeEvent, debug ) );
	$searchAddButtonEle.bind( 'click', bindClickEventForSearchAddButton1( $resetButtonEle, name, tabAfterSelect, debug ) );
	$resetButtonEle.bind( 'click', bindClickEventForResetButton1( $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, isTriggerChangeEvent, debug ) );

	initialValidation( $gridCondition );
	initialValidation( $dataForm );
}

/**
 * complete
 * @param $gridEle
 * @returns {Function}
 */
function subscribePagingTopics1( $searchEle, $gridEle, debug ){
	return function(){
		if( debug )
			alert( 'run subscribePagingTopics1() function.' );

		$searchEle.trigger( 'click', $gridEle.jqGrid( 'getGridParam', 'page' ) );
	};
}

/**
 * subscribe
 * (complete)
 * @param $grid
 * @param $dataForm
 * @param name
 * @returns {Function}
 */
function subscribeSelectRowTopics1( $gridEle, $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, tabAfterSelect, isTriggerChangeEvent, debug ){
	return function(){
		if( debug )
			alert( 'run subscribeSelectRowTopics1() function.' );

		console.log( 'subscribeSelectRowTopics1, gridId:', $gridEle.attr( 'id' ) );

		fillDataToElementForSelectRow( $gridEle, $dataForm, isTriggerChangeEvent );

		enableButton($updateButtonEle);
		enableButton($deleteButtonEle);
		enableButton($printButtonEle);

		if( tabAfterSelect != 0 )
			clickTab( tabAfterSelect );

		/*for Libra */
		$("#libraCopy").val("");
		//$("#master_dataForm1 #libraCopy").val("");
		var form = $("#master_dataForm1").serialize();
		form = form.replace(new RegExp("%2F","gm"),"/");
		//$("#master_dataForm1 #libraCopy").val(form);
		$("#libraCopy").val(form);

		doAfterSelect1( name, debug );
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
function bindClickEventForSearchButton1( $gridEle, $gridCondition, $searchUrl, $rows, $page, autoSelected, autoSelectedWhenRows, name, debug )
{
	return function( data, page ){
		if( debug )
			alert( 'run bindClickEventForSearchButton1() function.' );

		console.log( 'bindClickEventForSearchButton1, gridId:', $gridEle.attr( 'id' ) );

		if( !$gridCondition.valid() )
			return false;

		if( page == undefined ){
			page = '1';

			if( !doBeforeQuery1( name ) )
				return false;
		}

		$rows.val( $gridEle.jqGrid( 'getGridParam', 'rowNum' ) );
		$page.val( page );

		searchByGrid( $searchUrl, $gridCondition, $gridEle, page, autoSelected, autoSelectedWhenRows, 1, name, debug );
	};
}

/**
 * bind add button click
 * (complete)
 * @param $addUrl
 * @param name
 * @returns {Function}
 */
function bindClickEventForAddButton1( $gridEle, $addUrl, $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, debug ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForAddButton1() function.' );

		cleanMsgForStatusField();

		doBeforeValidationByAdd1( name, debug );

		if( !$dataForm.valid() )
			return false;

		if( !checkPKByGrid( $dataForm ) )
			return false;

		if( !doBeforeAdd1( name, debug ) )
			return false;

		var addUrl = $addUrl.val();

		if( debug )
			alert( 'in bindClickEventForAddButton1() function, addUrl:' + addUrl );

		/**
		 *先跳至最後一頁，再送資料至後端(當current page 已是最後一頁時，不會triiger subscribePagingTopics1 event)。
		 */
		$( '#last_' + $gridEle.attr( 'id' ) + '_pager' ).trigger( 'click' );

		$.post( addUrl, $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForAddButton1() function, callbackDaata:' + JSON.stringify( data ) );

			showStatusMsg( data.status, data.msg );

			if( data.status == 'ok' ){
				enableButton( $updateButtonEle );
				enableButton( $deleteButtonEle );
				enableButton( $printButtonEle );

				doAfterAdd1( name, data.data, debug );

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
 * complete
 * @returns {Function}
 */
function bindClickEventForUpdateButton1( $gridEle, $updateUrl, $dataForm, name, debug ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForUpdateButton1() function.' );

		cleanMsgForStatusField();

		doBeforeValidationByUpdate1( name, debug );

		if( !$dataForm.valid() )
			return false;

		if( !checkPkValue( $dataForm ) )
			return false;

		if( !doBeforeUpdate1( name, debug ) )
			return false;

		$.post( $updateUrl.val(), $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForUpdateButton1() function, callbackDaata:' + JSON.stringify( data ) );

			showStatusMsg( data.status, data.msg );

			if( data.status == 'ok' ){
				doAfterUpdate1( name, data.data, debug );

				/*for Libra */
				$("#master_dataForm1 #libraCopy").val("");
				var form = $("#master_dataForm1").serialize();
				form = form.replace(new RegExp("%2F","gm"),"/");
				$("#master_dataForm1 #libraCopy").val(form);

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
function bindClickEventForDeleteButton1( $gridEle, $deleteUrl, $dataForm, $resetButtonEle, name, tabAfterDelete, debug ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForDeleteButton1() function.' );

		cleanMsgForStatusField();

		if( !checkPkValue( $dataForm ) )
			return false;

		if( !doBeforeDelete1( name, debug ) )
			return false;

		if( !confirm( '確定刪除此筆資料?' ) )
			return;

		$.post( $deleteUrl.val(), $dataForm.serialize(), function( data ){
			if( debug )
				alert( 'in bindClickEventForDeleteButton1() function, callbackDaata:' + JSON.stringify( data ) );

			showStatusMsg( data.status, data.msg );

			if( data.status == 'ok' ){
				$gridEle.jqGrid( 'delRowData', $gridEle.jqGrid( 'getGridParam', 'selrow' ) );

				$resetButtonEle.trigger( 'click' );

				if( tabAfterDelete != 0 )
					clickTab( tabAfterDelete );

				doAfterDelete1( name, data.data, debug );
			}
		});
	};
}

/**
 * complete
 * @param $gridCondition
 * @param name
 * @returns {Function}
 */
function bindClickEventForSearchResetButton1( $gridEle, $gridCondition, name, isTriggerChangeEvent, debug ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForSearchResetButton1() function.' );

		if( !doBeforeSearchReset1( name, debug ) )
			return false;

		resetValue( $gridCondition, isTriggerChangeEvent );

		$gridEle.jqGrid( 'clearGridData' );

		cleanMsgForStatusField();

		doAfterSearchReset1( name, debug );
	};
}

function bindClickEventForSearchAddButton1( $resetButtonEle, name, tabAfterSelect, debug ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForSearchAddButton1() function.' );

		if( !doBeforeSearchAddButton1( name, debug ) )
			return;

		$resetButtonEle.trigger( 'click' );
		clickTab( tabAfterSelect );

		doAfterSearchAddButton1( name, debug );
	};
}

/**
 * complete
 * @param $dataForm
 * @param name
 */
function bindClickEventForResetButton1( $dataForm, $updateButtonEle, $deleteButtonEle, $printButtonEle, name, isTriggerChangeEvent, debug ){
	return function(){
		if( debug )
			alert( 'run bindClickEventForSearchResetButton1() function.' );

		if( !doBeforeReset1( name, debug ) )
			return false;

		resetValue( $dataForm, isTriggerChangeEvent );

		disableButton( $updateButtonEle );
		disableButton( $deleteButtonEle );
		disableButton( $printButtonEle );

		cleanMsgForStatusField();

		doAfterReset1( name, debug );
	};
}

function doBeforeSearchReset1( name, debug ){
	if( debug )
		alert( 'callback doBeforeSearchReset1(), name:' + name );

	return true;
}
function doAfterSearchReset1( name, debug ){
	if( debug )
		alert( 'callback doAfterSearchReset1(), name:' + name );
}

function doBeforeSearchAddButton1( name, debug ){
	if( debug )
		alert( 'callback doBeforeSearchAddButton1(), name:' + name );

	return true;
}

function doAfterSearchAddButton1( name, debug ){
	if( debug )
		alert( 'callback doAfterSearchReset1(), name:' + name );
}

function doBeforeQuery1( name, debug ){
	if( debug )
		alert( 'callback doBeforeQuery1(), name:' + name );

	return true;
}

function doAfterQuery1( name, data, debug ){
	if( debug )
		alert( 'callback doAfterQuery1(), name:' + name + ', data:' + JSON.stringify( data ) );
}

function doAfterSelect1( name, debug ){
	if( debug ){

		alert( 'callback doAfterSelect1(), name:' + name );
	}
}

function doBeforeAdd1( name, debug ){
	$("#libraCopy").val("");
	if( debug )
		alert( 'callback doBeforeAdd1(), name:' + name );

	return true;
}

function doAfterAdd1( name, data, debug ){
	if( debug )
		alert( 'callback doAfterAdd1(), name:' + name + ', data:' + JSON.stringify( data ) );
}

function doBeforeUpdate1( name, debug ){
	if( debug )
		alert( 'callback doBeforeUpdate1(), name:' + name );

	return true;
}

function doAfterUpdate1( name, data, debug ){
	if( debug )
		alert( 'callback doAfterUpdate1(), name:' + name );
}

function doBeforeDelete1( name, debug ){
	$("#libraCopy").val("");
	if( debug )
		alert( 'callback doBeforeDelete1(), name:' + name );

	return true;
}

function doAfterDelete1( name, data, debug ){
	if( debug )
		alert( 'callback doAfterDelete1(), name:' + name );
}

function doBeforeReset1( name, debug ){
	if( debug )
		alert( 'callback doBeforeReset1(), name:' + name );

	return true;
}

function doAfterReset1( name, debug ){
	if( debug )
		alert( 'callback doAfterReset1(), name:' + name );
}

function doBeforeValidationByAdd1( name, debug ){
	if( debug )
		alert( 'callback doBeforeValidationByAdd1(), name:' + name );
}

function doBeforeValidationByUpdate1( name, debug ){
	if( debug )
		alert( 'callback doBeforeValidationByUpdate1(), name:' + name );
}