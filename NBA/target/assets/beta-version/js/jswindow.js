function ready(e){if(document.attachEvent?document.readyState==="complete":document.readyState!=="loading"){e()}else{document.addEventListener("DOMContentLoaded",e)}}function renderWindow(e,t){if(state.isHidden){e.style.display="none"}else{e.style.display=""}e.style.transform="translate("+t.x+"px, "+t.y+"px)"}function clampX(e){return Math.min(Math.max(e,0),900-200)}function clampY(e){return Math.min(Math.max(e,0),800)}function onMouseMove(e){if(state.isDragging){state.x=clampX(e.pageX-state.xDiff);state.y=clampY(e.pageY-state.yDiff)}var t=document.getElementById("window");renderWindow(t,state)}function onMouseDown(e){state.isDragging=true;state.xDiff=e.pageX-state.x;state.yDiff=e.pageY-state.y}function onMouseUp(){state.isDragging=false}function closeWindow(){state.isHidden=true;var e=document.getElementById("window");renderWindow(e,state)}var state={isDragging:false,isHidden:true,xDiff:0,yDiff:0,x:50,y:50};ready(function(){var e=document.getElementById("window");renderWindow(e,state);var t=document.querySelectorAll(".window-bar");t[0].addEventListener("mousedown",onMouseDown);document.addEventListener("mousemove",onMouseMove);document.addEventListener("mouseup",onMouseUp);var n=document.querySelectorAll(".window-close");n[0].addEventListener("click",closeWindow);var r=document.getElementById("windowtoggle");r.addEventListener("click",function(){state.isHidden=!state.isHidden;renderWindow(e,state)})})