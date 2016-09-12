( function( $ ){
	$.fn.grid4 = function( settings ){
		var defaultSettings = {
			addUrl					: null,		// add url, required
			debug					: false,	// debug, optional
			deleteUrl				: null,		// delete url, required
			editUrl					: null,		// edit url, required
			gridCompleteTopics		: null,		//grid complete topics, required
			gridConditionEle		: null,		//查詢條件的  selector, required
			pagingTopics			: null,		//pagingTopics, required
			searchUrl				: null,		//查詢 url, required
			searchButtonEle			: null,		//查詢button 的 selector, required
			selectRowTopics			: null,		//selectRowTopics, required
			dataFormEle				: null,		//data form ele
			notEditableWhenEditing	: null,		//當 eidtable = true 時且在編輯狀能, 某些欄位不能被編輯, 但新增可以編輯, 通常用在 PK 欄位, ex: ['column1','column2']
			copyKeys				: [],		//複制前一個欄位
			doBeforeSaveByAdding	: function( name, debug ){ return doBefore( name, debug, 'Add' ); },		//按儲存按鈕, 但是要做新增的動作
			doBeforeSaveByUpdating	: function( name, debug ){ return doBefore( name, debug, 'Update' ); },		//按儲存按鈕, 但是要做更新的動作
			doBeforeDelete			: function( name, debug ){ return doBefore( name, debug, 'Delete' ); },
			doBeforeQuery			: function( name, debug ){ return doBefore( name, debug, 'Query' ); },
			doAfterSaveByAdding		: function( name, data, debug ){ doAfter( name, data, debug, 'Add' ); },	//按儲存按鈕, 但是要做新增的動作
			doAfterSaveByUpdating	: function( name, data, debug ){ doAfter( name, data, debug, 'Update' ); },	//按儲存按鈕, 但是要做更新的動作
			doAfterDelete			: function( name, data, debug ){ doAfter( name, data, debug, 'Delete' ); },				
			doAfterQuery			: function( name, data, debug ){ doAfter( name, data, debug, 'Query' ); },
			doAfterSelect			: function( name, data, debug ){ doAfter( name, data, debug, 'Select' ); }
		};
		
		var newSettings = $.extend( defaultSettings, settings );
		
		newSettings.gridEle = this;
		
		if( !( checkNull( newSettings.addUrl, 'addUrl' ) &&
			   checkNull( newSettings.deleteUrl, 'deleteUrl' ) &&
			   checkNull( newSettings.editUrl, 'editUrl' ) &&
			   checkNull( newSettings.gridCompleteTopics, 'gridCompleteTopics' ) &&
			   checkNull( newSettings.gridConditionEle, 'gridConditionEle' ) &&
			   checkNull( newSettings.pagingTopics, 'pagingTopics' ) && 
			   checkNull( newSettings.searchUrl, 'searchUrl' ) && 
			   checkNull( newSettings.searchButtonEle, 'searchButtonEle' ) &&
			   checkNull( newSettings.selectRowTopics, 'selectRowTopics' ) ) ) 
			return;
		
		if( !( checkTypeByString( newSettings.addUrl, 'addUrl' ) &&
			   checkTypeByString( newSettings.deleteUrl, 'deleteUrl' ) &&
			   checkTypeByString( newSettings.editUrl, 'editUrl' ) &&
			   checkTypeByString( newSettings.gridCompleteTopics, 'gridCompleteTopics' ) &&
			   checkTypeByObject( newSettings.gridConditionEle, 'gridConditionEle') &&
			   checkTypeByString( newSettings.pagingTopics, 'pagingTopics' ) &&
			   checkTypeByString( newSettings.searchUrl, 'searchUrl' ) &&
			   checkTypeByObject( newSettings.searchButtonEle, 'searchButtonEle' ) &&
			   checkTypeByString( newSettings.selectRowTopics, 'selectRowTopics' ) ) ) 
			return;
		
		if( !( checkSelector( newSettings.searchButtonEle, 'searchButtonEle' ) ) ) 
			return;
		
		appendFormToBody( newSettings );
		
		initial( newSettings );
	};
	
	function appendFormToBody( newSettings ){
		var $dataFormEle = newSettings.dataFormEle;
		
		if( $dataFormEle != null && $dataFormEle.length ==0 ){
			alert( '指定的  dataform 找不到' );
			return;
		}
			
		if( $dataFormEle == null ){		
			$dataFormEle = $( '<form></form>' );
			
			$( 'body' ).append( $dataFormEle );
		}
		
		newSettings.dataFormEle = $dataFormEle;
	}
	
	function initial( newSettings ){	
		$( window ).bind( 'load', doOnload( newSettings ));
		
		initialValidation( newSettings.dataFormEle );
		
		$.subscribe( newSettings.gridCompleteTopics, subscribeGridCompleteTopics( newSettings ) );
		$.subscribe( newSettings.pagingTopics, subscribePagingTopics( newSettings ) );
		$.subscribe( newSettings.selectRowTopics, subscribeSelectRowTopics( newSettings ) );
		
		newSettings.searchButtonEle.bind( 'click', clickSearch( newSettings ) );
	}
	
	function doOnload( newSettings ){
		return function(){
			newSettings.gridEle.jqGrid( 'navGrid', '#' + newSettings.gridEle.attr( 'id' ) + '_pager',{
				edit	:false,
				del		:false,
				search	:false,
				refresh	:false,
				addfunc	:clickAddRow( newSettings )
			} );
		};
	}
	
	function subscribeGridCompleteTopics( newSettings ){
		return function(){
			if( newSettings.debug )
				alert( 'run subscribeGridCompleteTopics() function.' );
			
			var $gridEle = newSettings.gridEle;
			var ids = common.grid.getIds( $gridEle );
			
			console.log( 'run subscribeGridCompleteTopics, initial action button, ids:' + ids.join( ',' ) );
			
			for( var i = 0 ; i < ids.length ; i++ ){
				var rowData = $gridEle.jqGrid( 'getRowData', ids[i] );
				
				if( rowData.GRID_ACTION != '' )
					continue;
				
				var edit = '<a href="#" class="gridEditButton" id="edit_' + ids[i] + '" idValue="' + ids[i] + '" title="編輯">&nbsp;</a>'; 
				var del = '<a href="#" class="gridDelButton" id="delete_' + ids[i] + '" idValue="' + ids[i] + '" title="刪除">&nbsp;</a>'; 
				var save = '<a href="#" class="gridSaveButton" id="save_' + ids[i] + '" idValue="' + ids[i] + '" title="儲存">&nbsp;</a>';
				var restore = '<a href="#" class="gridRestoreButton" id="restore_' + ids[i] + '" idValue="' + ids[i] + '" title="回復">&nbsp;</a>';
				
				$gridEle.jqGrid( 'setRowData', ids[i], { GRID_ACTION : edit + del + save + restore });
				
				$( '[id=save_' + ids[i] + ']', $gridEle ).hide();
				$( '[id=restore_' + ids[i] + ']', $gridEle ).hide();
				
				$( '[id=edit_' + ids[i] + ']', $gridEle ).bind( 'click', clickEdit( newSettings ) );
				$( '[id=delete_' + ids[i] + ']', $gridEle ).bind( 'click', clickDelete( newSettings ) );
				$( '[id=save_' + ids[i] + ']', $gridEle ).bind( 'click', clickSave( newSettings ) );
				$( '[id=restore_' + ids[i] + ']', $gridEle ).bind( 'click', clickRestore( newSettings ) );
			}
		};
	}
	
	function subscribePagingTopics( newSettings ){
		return function(){
			if( newSettings.debug )
				alert( 'run subscribePagingTopics() function.' );
			
			newSettings.searchButtonEle.trigger( 'click', newSettings.gridEle.jqGrid( 'getGridParam', 'page' ) );
		};
	};
	
	function subscribeSelectRowTopics( newSettings ){
		return function(){
			var debug = newSettings.debug;
			
			if( debug )
				alert( 'run subscribeSelectRowTopics() function.' );
			
			var $gridEle = newSettings.gridEle;
			var rowId = $gridEle.jqGrid( 'getGridParam', 'selrow' );			
			var rowData = $gridEle.jqGrid( 'getRowData', rowId );
			var gridId = $gridEle.attr( 'id' );
			
			newSettings.doAfterSelect( gridId, rowData, debug );
		};
	}
	
	function clickSearch( newSettings ){
		return function( data, page ){
			if( newSettings.debug )
				alert(  'run clickSearch() function.' );
			
			var $gridEle = newSettings.gridEle;
			var $gridConditionEle = newSettings.gridConditionEle;
			var gridId = $gridEle.attr( 'id' );
			var debug = newSettings.debug;
			
			if( page == undefined ){
				page = '1';
				
				if( !newSettings.doBeforeQuery( gridId, newSettings.debug ) )
					return false;
			}	
			
			addHiddenEleToForm( $gridConditionEle, 'page', 'pageId', page );
			addHiddenEleToForm( $gridConditionEle, 'rows', 'rowsId', $gridEle.jqGrid( 'getGridParam', 'rowNum' ) );
			
			var url = getContextPath() + '/' + newSettings.searchUrl;
			
			if( debug )
				alert( 'in clickSearch(), url:' + url );
			
			$.post( url, $gridConditionEle.serialize(), function( data ){
				if( debug )
					alert( 'in clickSearch function, callbackData:' + JSON.stringify( data ) );
				
				$gridEle[0].addJSONData( data );
				
				showStatusMsg( data.status, data.msg );
				
				if( data.status == 'ok' ){
					if( data.records == 0 )
						showStatusMsg( 'ok', ' [查無資料]' );
					
					newSettings.doAfterQuery( gridId, data.data, debug );
				}
			});
		};
	}
	
	function clickAddRow( newSettings ){
		return function(){
			if( newSettings.debug )
				alert( 'run clickAddRow() function.' );
			
			var $gridEle = newSettings.gridEle;			
			
			var rowId = common.grid.getLastId( common.grid.getIds( $gridEle ) );
			
			$gridEle.jqGrid( 'addRowData', rowId, {} );	//執行完, 會呼叫 gridComplete
			
			copyPreviousData( newSettings, rowId );
			
			setAction( $gridEle, rowId, 'add' );
			
			processEditable( newSettings, true );
			
			editStatus( $gridEle, rowId );
		};
	}
	
	function clickEdit( newSettings ){
		return function(){
			if( newSettings.debug )
				alert( 'run clickEdit() function.' );
			
			var $gridEle = newSettings.gridEle;
			var $buttonEle = $(this);
			var rowId = $buttonEle.attr( 'idValue' );
			
			
			
			setAction( $gridEle, rowId, 'edit' );
			
			closeEditable( newSettings );
			
			editStatus( $gridEle, rowId );
		};
	}
	
	function clickDelete( newSettings ){
		return function(){
			if( newSettings.debug )
				alert( 'run clickDelete() function' );
			
			var $deleteButtonEle = $(this);
			var $gridEle = newSettings.gridEle;
			var $dataFormEle = newSettings.dataFormEle;
			var gridId = $gridEle.attr( 'id' );
			var debug = newSettings.debug;
			var rowId = $deleteButtonEle.attr( 'idValue' );
			
			if( !newSettings.doBeforeDelete( gridId, debug ) )
				return;
			
			if( !confirm( '確定刪除第[' + common.grid.getRowNumberByAction( common.grid.getIds( $gridEle ), rowId ) + ']筆資料?' ) )
				return;
			
			copyToForm( $gridEle, $dataFormEle, rowId );
			
			var url = getContextPath() + '/' + newSettings.deleteUrl;
			
			$.post( url, $dataFormEle.serialize(), function( data ){
				if( newSettings.debug )
					alert( 'in clickDelete function, callbackData:' + JSON.stringify( data ) );
				
				showStatusMsg( data.status, data.msg );
				
				if( data.status == 'ok' ){
					$gridEle.jqGrid( 'delRowData', rowId );
					
					newSettings.doAfterDelete( gridId, data.data, debug );
				}
			});
		};
	}
	
	function clickSave( newSettings ){
		return function(){
			if( newSettings.debug )
				alert( 'run clickSave() function' );
			
			var $gridEle = newSettings.gridEle;
			var $dataFormEle = newSettings.dataFormEle;
			var $saveEle = $(this);
			var action = $saveEle.attr( 'action' );
			var rowId = $saveEle.attr( 'idValue' );
			
			copyToForm( $gridEle, $dataFormEle, rowId );
			
			if( action == 'add' )
				processAdd( newSettings, rowId );
			else if( action == 'edit' )
				processUpdate( newSettings, rowId );
			else{
				alert( 'action 的值不為 add or edit, action:' + action );
			}	
		};
	}
	
	function clickRestore( newSettings ){
		return function(){
			if( newSettings.debug )
				alert( 'run clickRestore() function' );
			
			var $gridEle = newSettings.gridEle;
			var $restoreButtonEle = $(this);
			var currentId = $restoreButtonEle.attr( 'idValue' );
			var action = $restoreButtonEle.attr( 'action' );
			
			if( action == 'edit' )
				restoreStatus( $gridEle, currentId );
			else if( action == 'add' ){
				$gridEle.jqGrid( 'delRowData', currentId );
			}
			else
				alert( 'action 的值有錯. action:' + action );
		};
	}
	
	function processAdd( newSettings, rowId ){
		var debug = newSettings.debug;
		var $gridEle = newSettings.gridEle;
		var $dataFormEle = newSettings.dataFormEle;
		var gridId = $gridEle.attr( 'id' );
		var url = getContextPath() + '/' + newSettings.addUrl;
		
		if( debug )
			alert( 'run processAdd() function, addUrl:' + url );
		
		if( !$dataFormEle.valid() )			
			return false;
		
		if( !newSettings.doBeforeSaveByAdding( gridId, debug ) )
			return;
		
		$.post( url, $dataFormEle.serialize(), function( data ){
			if( newSettings.debug )
				alert( 'in processAdd function, callbackData:' + JSON.stringify( data ) );
			
			showStatusMsg( data.status, data.msg );
			
			if( data.status == 'ok' ){
				saveStatus( $gridEle, rowId );
				
				newSettings.doAfterSaveByAdding( gridId, data.data, debug );
			}
		});
	}
	
	function processUpdate( newSettings, rowId ){
		var debug = newSettings.debug;
		var $gridEle = newSettings.gridEle;
		var $dataFormEle = newSettings.dataFormEle;
		var gridId = $gridEle.attr( 'id' );
		var url = getContextPath() + '/' + newSettings.editUrl;
		
		if( debug )
			alert( 'run processUpdate() function, editUrl:' + url );
		
		if( !$dataFormEle.valid() )			
			return false;
		
		if( !newSettings.doBeforeSaveByUpdating( gridId, debug ) )
			return;
		
		$.post( url, $dataFormEle.serialize(), function( data ){
			if( newSettings.debug )
				alert( 'in processUpdate function, callbackData:' + JSON.stringify( data ) );
			
			showStatusMsg( data.status, data.msg );
			
			if( data.status == 'ok' ){
				saveStatus( $gridEle, rowId );
				
				newSettings.doAfterSaveByUpdating( gridId, data.data, debug );
			}
		});
	}
	
	function copyToForm( $gridEle, $dataFormEle, rowId ){
		var rowData = $gridEle.jqGrid( 'getRowData', rowId );
		var colNames = $gridEle.jqGrid( 'getGridParam', 'colNames' );
		var index = 0;
		
		$( '[dynamic=true]', $dataFormEle ).remove();
		
		for( property in rowData )
		{
			index++;
			
			if( property == 'GRID_ACTION' )
				continue;
			
			var nameOrId = property.convertToJavaConvenience();
			var value = null;
			var $selector = $( '#' + rowId + '_' + property );
			
			var $textEle = $( '#nameOrId' );
			
			if( $textEle.length == 0 ){			
				$textEle = $( '<input type="text">' );
				
				$dataFormEle.append( $textEle );
			}
			
			if( $selector.length == 0 )
				value = rowData[ property ];
			else{
				value = $selector.val();
				
				$textEle.attr( 'class', $selector.attr( 'class' ) );
			}
			
			$textEle.attr( 'name', nameOrId )
					.attr( 'id', nameOrId )
					.attr( 'alt', colNames[index] )
					.attr( 'dynamic', 'true' )
					.val( value )
					.hide();
		}
	}
	
	function processEditable( newSettings, editabled ){
		var $gridEle = newSettings.gridEle;
		var colModel = $gridEle.jqGrid( 'getGridParam', 'colModel' );
		
		$.each( colModel, function(){
			if( this.name == 'rn' || this.name == 'GRID_ACTION' )
				return true;
			
			$gridEle.jqGrid( 'setColProp', this.name, {editable:editabled} );
		});
	}
	
	function closeEditable( newSettings ){
		var $gridEle = newSettings.gridEle;
		var notEditableWhenEditing = newSettings.notEditableWhenEditing;
		
		if( notEditableWhenEditing == null )
			return;
		
		var type = typeof( notEditableWhenEditing );
		
		if( type == 'string' )
			$gridEle.jqGrid( 'setColProp', notEditableWhenEditing, {editable:false} );
		else if( type == 'object' && notEditableWhenEditing instanceof Array ){
			$.each( notEditableWhenEditing, function(){
				$gridEle.jqGrid( 'setColProp', this, {editable:false} );
			});
		}
		else
			alert( '指定 notEditableWhenEditing 的型態錯誤, 請使用 string or Array 的型態' );
	}
	
	function copyPreviousData( newSettings, rowId ){
		var copyKeys = newSettings.copyKeys; 
		
		if( copyKeys.length == 0 )
			return;
		
		var $gridEle = newSettings.gridEle;
		
		var ids = common.grid.getIds( $gridEle );
		
		var currentIndex = ids.indexOf( rowId + '' );
		
		if( currentIndex == -1 ){
			console.info( 'copyPreviousData(), can not find any rowId in rowIds.' );
			console.log( 'rowId:' + rowId );
			console.log( 'ids:' + ids );
			return;
		}
		
		var previousIndex = currentIndex - 1;
		
		if( previousIndex == -1 ){
			console.info( 'in first row, not copy' );
			return;
		}
		
		console.log( 'copyPreviousData(),rowId:', rowId, ', ids:', ids, ', previousIndex:' + previousIndex );		
		
		var currentRowData = common.grid.getRowData( $gridEle, rowId );
		var previousRowData = common.grid.getRowData( $gridEle, ids[ previousIndex ] );
		
		$.each( copyKeys, function( index ,data ){
			var colValue = previousRowData[ data ];
			
			console.log( 'colValue:' + colValue );
			
			if( $( colValue ).length != 0 ){
				var selector = '#' + ids[ previousIndex ] + '_' + data;
				// $( colValue )直接取得 val(), 是沒有值的, 要用 id 去取得
				colValue = $( selector ).val();
				console.log( 'when selector is:', selector ,', colValue:', colValue );
			}
			
			currentRowData[ this ] = colValue;
		});
		
		common.grid.setRowData( $gridEle, rowId, currentRowData );
	}
	
	function editStatus( $gridEle, idValue ){
		console.log( 'editRow, id:' + idValue );
		console.log( 'editRow, $gridEle:' + $gridEle );
		/*for libra*/
		 var colNames = $gridEle.jqGrid( 'getGridParam', 'colNames' );
		 var colModel = $gridEle.jqGrid( 'getGridParam', 'colModel' );
		 var libraCopy ="";
		 for(i=2;i<colNames.length;i++){
			 var v = $gridEle.jqGrid('getCell',idValue,i);
			 var copy = colModel[i].name+"="+v;
			 libraCopy = libraCopy +"&"+ copy;
		 }
		 console.log( 'clickEdit libraCopy:' + libraCopy );
		 $('#libraCopy').val(libraCopy);
		
		$gridEle.jqGrid( 'editRow', idValue );
		
		$( '#edit_' + idValue, $gridEle ).hide();
		$( '#delete_' + idValue, $gridEle ).hide();
		
		$( '#save_' + idValue, $gridEle ).show();
		$( '#restore_' + idValue, $gridEle ).show();
	}

	function restoreStatus( $gridEle, idValue ){
		$gridEle.jqGrid( 'restoreRow', idValue );
		
		$( '#edit_' + idValue, $gridEle ).show();
		$( '#delete_' + idValue, $gridEle ).show();
		
		$( '#save_' + idValue, $gridEle ).hide();
		$( '#restore_' + idValue, $gridEle ).hide();
	}
	
	function saveStatus( $gridEle, idValue ){
		$gridEle.jqGrid( 'saveRow', idValue, null, 'clientArray' );
		
		$( '#edit_' + idValue, $gridEle ).show();
		$( '#delete_' + idValue, $gridEle ).show();
		
		$( '#save_' + idValue, $gridEle ).hide();
		$( '#restore_' + idValue, $gridEle ).hide();
	}
	
	function setAction( $gridEle, idValue, action ){
		$( '#restore_' + idValue, $gridEle ).attr( 'action', action );
		$( '#save_' + idValue, $gridEle ).attr( 'action', action );
	}
	
})( jQuery );