$.blockUI.defaults.message = '處理中，請稍候...';
$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);

function block(){
	$.blockUI();
}

function unblock(){
	$.unblockUI();
}