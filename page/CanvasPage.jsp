<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>測試手機畫圖</title>
</head>
<body>
 <table>
		<tbody>
			<tr>
				<td style="vertical-align: top;">
					<table id="DATA_TB">
						<tbody>
							<tr><td>通報傳送主旨：<label >${lbl1}</label></td><td></td><td>通報傳送時間：<label>${lbl2}</label></td></tr>
							<tr><td>通報傳送單位：<label >${lbl3}</label></td><td></td><td>回條簽署層級：<label>${lbl4}</label></td></tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>		
	</table>
	 <div id="container">
          <canvas id="imageView" width="500" height="200"  style="border:1px solid #000000;"></canvas>
          <button id="clearJpg" value="清除">清除</button>
          <button id="saveJpg"  value="存檔">存檔</button>
     </div>
     <div id="snapShot"  >
     </div>
     <div id="url" >
     	<label  id="hostURL"   style='display:none;'>${hostURL }</label>
     </div>
     
     <label  style='display:block' >手簽畫面目前狀態：<b id='boldStuff'>請簽名</b></label>
    
</body>
<script type="text/javascript">
//--------------------------------------------------------------------------
 	function $(id){
			return document.getElementById(id);
		}
			
		var canvas = $("imageView");
		var context = canvas.getContext("2d");
			
		function getTouchPoint(e){
			var pageX = e.targetTouches[0].pageX;
			var pageY = e.targetTouches[0].pageY;	
			
			return {
				x: pageX - e.target.offsetLeft,
				y: pageY - e.target.offsetTop	
			}
		}
			
		canvas.addEventListener("touchstart",function(e){
			context.beginPath();
			var point = getTouchPoint(e);
			context.moveTo(point.x,point.y); 
		});
				
		canvas.addEventListener("touchmove",function(e){
			e.preventDefault();
			var point = getTouchPoint(e);
			context.lineTo(point.x,point.y);
			context.strokeStyle = 'block';
			context.stroke();
		});
				
		canvas.addEventListener("touchend",function(e){
			context.save();	
		});
		

//--------------------------------------------------------------------------
     	
          // Keep everything in anonymous function, called on window load.
     
          if(window.addEventListener) {
              window.addEventListener('load', function () {
                   var canvas, context, tool, saveBtn;
          
                   function init () {
                       // Find the canvas element.
                       canvas = document.getElementById('imageView');
                       context = canvas.getContext('2d');
                       saveBtn = document.getElementById('saveJpg');
                       clearBtn = document.getElementById('clearJpg');
                   
                       // Pencil tool instance.
                       tool = new tool_pencil();
                   
                       // Attach the mousedown, mousemove and mouseup event listeners.
                       canvas.addEventListener('mousedown', ev_canvas, false);
                       canvas.addEventListener('mousemove', ev_canvas, false);
                       canvas.addEventListener('mouseup', ev_canvas, false);
                       canvas.addEventListener('touchstart', ev_canvas, false);
//                        canvas.addEventListener('touchstart', function(){testLine();}, false);
                       canvas.addEventListener('touchend', ev_canvas, false);
//                        canvas.addEventListener('touchend', function(){testLine();}, false);
//                        canvas.addEventListener('touchleave', function(){alert('touchleave');}, false);
//                        canvas.addEventListener('touchmove', ev_canvas, false);
                       canvas.addEventListener('touchmove', function(){testLine();}, false);
                       saveBtn.addEventListener('click', confirmChoice, false);
                       clearBtn.addEventListener('click', clearImg, false);
                      
                   }
          
                   // This painting tool works like a drawing pencil which tracks the mouse
                   // movements.
                   function tool_pencil () {
                        var tool = this;
                        this.started = false;
              
                        // This is called when you start holding down the mouse button.
                        // This starts the pencil drawing.
                        this.mousedown = function (ev) {
                             context.beginPath();
                             context.moveTo(ev._x, ev._y);
                             tool.started = true;
                        };
              
                        // This function is called every time you move the mouse. Obviously, it only
                        // draws if the tool.started state is set to true (when you are holding down
                        // the mouse button).
                        this.mousemove = function (ev) {
                             if (tool.started) {
                                  context.lineTo(ev._x, ev._y);
                                  context.stroke();
                             }
                        };
              
                        // This is called when you release the mouse button.
                        this.mouseup = function (ev) {
                             if (tool.started) {
                                  tool.mousemove(ev);
                                  tool.started = false;
                             }
                        };
                        
                        this.touchstart = function (ev) {
                             ev.preventDefault();
                             context.beginPath();
                             tool.started = true;
                        }
                        
                        this.touchmove = function(){
                             for(var i=0; i<event.touches.length; i++){
                                  var touch = event.touches[i];
                                  context.lineTo(touch.pageX, touch.pageY-65);
//                                context.arc(touch.pageX, touch.pageY, 1, 0, 2*Math.PI, true);
//                                context.fill();
                                  context.stroke();
                             }
                        }
                        
                        this.touchend = function(ev){
                             if(tool.started){
                                  tool.touchmove(ev);
                                  tool.started = false;
                             }
                        }
                        
                        
                   }
                   
                   function testLine(ev){

//                 	   var c=document.getElementById("imageView");
//                 	   var ctx=c.getContext("2d");
//                 	   ctx.beginPath();
//                 	   ctx.arc(100,75,50,0,2*Math.PI);
//                 	   ctx.stroke();

                   }
          
                   // The general-purpose event handler. This function just determines the mouse
                   // position relative to the canvas element.
                   function ev_canvas (ev) {
                	   var agent=navigator.userAgent.toLowerCase();
                	   if(agent.indexOf("chrome") > 0){
                		   ev._x = ev.layerX;
                  	       ev._y = ev.layerY;
                  	       }
                	   else if(agent.indexOf("firefox") > 0){
                		   ev._x = ev.layerX;
                      	   ev._y = ev.layerY-60;
                      	   }
//                 	   if (ev.layerX || ev.layerX == 0) { // Firefox
                            
//                    } else if (ev.offsetX || ev.offsetX == 0) { // Opera
//                              ev._x = ev.offsetX;
//                              ev._y = ev.offsetY;
//                    }
              
                   // Call the event handler of the tool.
                        var func = tool[ev.type];
                        if (func) {
                             func(ev);
                        }
                   }
                   
                   //建立一個基本圖片，先替換圖片測試看看。
                   function snapImg(){
                 	  //alert('snapImg in...');
                        var img    = canvas.toDataURL("image/png");
                        
                       // var e = document.getElementById("snapShot");
                      // e.innerHTML = '<img src="'+img+'"/>';
                        
                        var httpRequest = new XMLHttpRequest();
                        //單機
                       // var url = "http://web.nfa.com/NTTWebTest1/common/nttSaveImg";
                       
 						var url = document.getElementById("hostURL").innerHTML+"/common/nttSaveImg"
					
						//alert("url="+url);
                        httpRequest.open("POST", url, true);
                        //alert('POST...');
                        httpRequest.send("img="+img);
                        
                        sleep(2000);
                        document.getElementById("boldStuff").style.color="red";
                        document.getElementById('boldStuff').innerHTML = '存檔完成......請關閉網頁';
                        
//                         alert("img..00.");
                       //window.close();
                   }
                   
                   function confirmChoice(){
                	   document.getElementById("boldStuff").style.color="black";
                	   document.getElementById('boldStuff').innerHTML = '準備中.........';
						if ( confirm ("按下確定後，即執行手簽畫面存檔作業......") ) {
							snapImg();// id="saveJpg"
						}else{
							document.getElementById('boldStuff').innerHTML = '無';
           				}
                   }
                   
                   function clearImg(){
                	   document.getElementById("boldStuff").style.color="black";
                        context.clearRect(0, 0, canvas.width, canvas.height);
                        document.getElementById('boldStuff').innerHTML = '請簽名';
                   }
                   
                   function sleep(ms)
	               	{
	               		var dt = new Date();
	               		dt.setTime(dt.getTime() + ms);
	               		while (new Date().getTime() < dt.getTime());
	               	}
                   init();
          
              }, false);
          }
          </script>
</html>