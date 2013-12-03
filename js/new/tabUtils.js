$( function(){
	$( "#mytabs" ).bind( "tabsselect", function( event, ui ){
		cleanMsgForStatusField();
		
		if( ui.index == 0 )
			doAfterClickTab1( event );
		else if( ui.index == 1 )
			doAfterClickTab2( event ); 
		else if( ui.index == 2 )
			doAfterClickTab3( event );
		else if( ui.index == 3 )
			doAfterClickTab4( event );
		else if( ui.index == 4 )
			doAfterClickTab5( event );
		else if( ui.index == 5 )
			doAfterClickTab6( event );
		else if( ui.index == 6 )
			doAfterClickTab7( event );
		else if( ui.index == 7 )
			doAfterClickTab8( event );
		else if( ui.index == 8 )
			doAfterClickTab9( event );
		else if( ui.index == 9 )
			doAfterClickTab10( event );
		else
			alert( 'no funciton call in parmTabUtils.js' );
	});
});

function doAfterClickTab1( event ){};
function doAfterClickTab2( event ){};
function doAfterClickTab3( event ){};
function doAfterClickTab4( event ){};
function doAfterClickTab5( event ){};
function doAfterClickTab6( event ){};
function doAfterClickTab7( event ){};
function doAfterClickTab8( event ){};
function doAfterClickTab9( event ){};
function doAfterClickTab10( event ){};

function clickTab( idx ){
	$( '#mytabs' ).tabs( 'select', idx - 1 );
}