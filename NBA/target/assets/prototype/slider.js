if(!Control)var Control={};Control.Slider=Class.create({initialize:function(e,t,n){var r=this;if(Object.isArray(e)){this.handles=e.collect(function(e){return $(e)})}else{this.handles=[$(e)]}this.track=$(t);this.options=n||{};this.axis=this.options.axis||"horizontal";this.increment=this.options.increment||1;this.step=parseInt(this.options.step||"1");this.range=this.options.range||$R(0,1);this.value=0;this.values=this.handles.map(function(){return 0});this.spans=this.options.spans?this.options.spans.map(function(e){return $(e)}):false;this.options.startSpan=$(this.options.startSpan||null);this.options.endSpan=$(this.options.endSpan||null);this.restricted=this.options.restricted||false;this.maximum=this.options.maximum||this.range.end;this.minimum=this.options.minimum||this.range.start;this.alignX=parseInt(this.options.alignX||"0");this.alignY=parseInt(this.options.alignY||"0");this.trackLength=this.maximumOffset()-this.minimumOffset();this.handleLength=this.isVertical()?this.handles[0].offsetHeight!=0?this.handles[0].offsetHeight:this.handles[0].style.height.replace(/px$/,""):this.handles[0].offsetWidth!=0?this.handles[0].offsetWidth:this.handles[0].style.width.replace(/px$/,"");this.active=false;this.dragging=false;this.disabled=false;if(this.options.disabled)this.setDisabled();this.allowedValues=this.options.values?this.options.values.sortBy(Prototype.K):false;if(this.allowedValues){this.minimum=this.allowedValues.min();this.maximum=this.allowedValues.max()}this.eventMouseDown=this.startDrag.bindAsEventListener(this);this.eventMouseUp=this.endDrag.bindAsEventListener(this);this.eventMouseMove=this.update.bindAsEventListener(this);this.handles.each(function(e,t){t=r.handles.length-1-t;r.setValue(parseFloat((Object.isArray(r.options.sliderValue)?r.options.sliderValue[t]:r.options.sliderValue)||r.range.start),t);e.makePositioned().observe("mousedown",r.eventMouseDown)});this.track.observe("mousedown",this.eventMouseDown);document.observe("mouseup",this.eventMouseUp);document.observe("mousemove",this.eventMouseMove);this.initialized=true},dispose:function(){var e=this;Event.stopObserving(this.track,"mousedown",this.eventMouseDown);Event.stopObserving(document,"mouseup",this.eventMouseUp);Event.stopObserving(document,"mousemove",this.eventMouseMove);this.handles.each(function(t){Event.stopObserving(t,"mousedown",e.eventMouseDown)})},setDisabled:function(){this.disabled=true},setEnabled:function(){this.disabled=false},getNearestValue:function(e){if(this.allowedValues){if(e>=this.allowedValues.max())return this.allowedValues.max();if(e<=this.allowedValues.min())return this.allowedValues.min();var t=Math.abs(this.allowedValues[0]-e);var n=this.allowedValues[0];this.allowedValues.each(function(r){var i=Math.abs(r-e);if(i<=t){n=r;t=i}});return n}if(e>this.range.end)return this.range.end;if(e<this.range.start)return this.range.start;return e},setValue:function(e,t){if(!this.active){this.activeHandleIdx=t||0;this.activeHandle=this.handles[this.activeHandleIdx];this.updateStyles()}t=t||this.activeHandleIdx||0;if(this.initialized&&this.restricted){if(t>0&&e<this.values[t-1])e=this.values[t-1];if(t<this.handles.length-1&&e>this.values[t+1])e=this.values[t+1]}e=this.getNearestValue(e);this.values[t]=e;this.value=this.values[0];this.handles[t].style[this.isVertical()?"top":"left"]=this.translateToPx(e);this.drawSpans();if(!this.dragging||!this.event)this.updateFinished()},setValueBy:function(e,t){this.setValue(this.values[t||this.activeHandleIdx||0]+e,t||this.activeHandleIdx||0)},translateToPx:function(e){return Math.round((this.trackLength-this.handleLength)/(this.range.end-this.range.start)*(e-this.range.start))+"px"},translateToValue:function(e){return e/(this.trackLength-this.handleLength)*(this.range.end-this.range.start)+this.range.start},getRange:function(e){var t=this.values.sortBy(Prototype.K);e=e||0;return $R(t[e],t[e+1])},minimumOffset:function(){return this.isVertical()?this.alignY:this.alignX},maximumOffset:function(){return this.isVertical()?(this.track.offsetHeight!=0?this.track.offsetHeight:this.track.style.height.replace(/px$/,""))-this.alignY:(this.track.offsetWidth!=0?this.track.offsetWidth:this.track.style.width.replace(/px$/,""))-this.alignX},isVertical:function(){return this.axis=="vertical"},drawSpans:function(){var e=this;if(this.spans)$R(0,this.spans.length-1).each(function(t){e.setSpan(e.spans[t],e.getRange(t))});if(this.options.startSpan)this.setSpan(this.options.startSpan,$R(0,this.values.length>1?this.getRange(0).min():this.value));if(this.options.endSpan)this.setSpan(this.options.endSpan,$R(this.values.length>1?this.getRange(this.spans.length-1).max():this.value,this.maximum))},setSpan:function(e,t){if(this.isVertical()){e.style.top=this.translateToPx(t.start);e.style.height=this.translateToPx(t.end-t.start+this.range.start)}else{e.style.left=this.translateToPx(t.start);e.style.width=this.translateToPx(t.end-t.start+this.range.start)}},updateStyles:function(){this.handles.each(function(e){Element.removeClassName(e,"selected")});Element.addClassName(this.activeHandle,"selected")},startDrag:function(e){if(Event.isLeftClick(e)){if(!this.disabled){this.active=true;var t=Event.element(e);var n=[Event.pointerX(e),Event.pointerY(e)];var r=t;if(r==this.track){var i=Position.cumulativeOffset(this.track);this.event=e;this.setValue(this.translateToValue((this.isVertical()?n[1]-i[1]:n[0]-i[0])-this.handleLength/2));var i=Position.cumulativeOffset(this.activeHandle);this.offsetX=n[0]-i[0];this.offsetY=n[1]-i[1]}else{while(this.handles.indexOf(t)==-1&&t.parentNode)t=t.parentNode;if(this.handles.indexOf(t)!=-1){this.activeHandle=t;this.activeHandleIdx=this.handles.indexOf(this.activeHandle);this.updateStyles();var i=Position.cumulativeOffset(this.activeHandle);this.offsetX=n[0]-i[0];this.offsetY=n[1]-i[1]}}}Event.stop(e)}},update:function(e){if(this.active){if(!this.dragging)this.dragging=true;this.draw(e);if(Prototype.Browser.WebKit)window.scrollBy(0,0);Event.stop(e)}},draw:function(e){var t=[Event.pointerX(e),Event.pointerY(e)];var n=Position.cumulativeOffset(this.track);t[0]-=this.offsetX+n[0];t[1]-=this.offsetY+n[1];this.event=e;this.setValue(this.translateToValue(this.isVertical()?t[1]:t[0]));if(this.initialized&&this.options.onSlide)this.options.onSlide(this.values.length>1?this.values:this.value,this)},endDrag:function(e){if(this.active&&this.dragging){this.finishDrag(e,true);Event.stop(e)}this.active=false;this.dragging=false},finishDrag:function(e,t){this.active=false;this.dragging=false;this.updateFinished()},updateFinished:function(){if(this.initialized&&this.options.onChange)this.options.onChange(this.values.length>1?this.values:this.value,this);this.event=null}})