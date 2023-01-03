if(!window.Modalbox)var Modalbox=new Object;Modalbox.Methods={overrideAlert:false,focusableElements:new Array,currFocused:0,initialized:false,active:true,options:{title:"ModalBox Window",overlayClose:true,width:500,height:90,overlayOpacity:.65,overlayDuration:.25,slideDownDuration:.5,slideUpDuration:.5,resizeDuration:.25,inactiveFade:true,transitions:true,loadingString:"Please wait. Loading...",closeString:"Close window",closeValue:"&times;",params:{},method:"get",autoFocusing:true,aspnet:false},_options:new Object,setOptions:function(e){Object.extend(this.options,e||{})},_init:function(e){Object.extend(this._options,this.options);this.setOptions(e);this.MBoverlay=new Element("div",{id:"MB_overlay",opacity:"0"});this.MBwindow=(new Element("div",{id:"MB_window",style:"display: none"})).update(this.MBframe=(new Element("div",{id:"MB_frame"})).update(this.MBheader=(new Element("div",{id:"MB_header"})).update(this.MBcaption=new Element("div",{id:"MB_caption"}))));this.MBclose=(new Element("a",{id:"MB_close",title:this.options.closeString,href:"#"})).update("<span>"+this.options.closeValue+"</span>");this.MBheader.insert({bottom:this.MBclose});this.MBcontent=(new Element("div",{id:"MB_content"})).update(this.MBloading=(new Element("div",{id:"MB_loading"})).update(this.options.loadingString));this.MBframe.insert({bottom:this.MBcontent});var t=this.options.aspnet?$(document.body).down("form"):$(document.body);t.insert({top:this.MBwindow});t.insert({top:this.MBoverlay});this.initScrollX=window.pageXOffset||document.body.scrollLeft||document.documentElement.scrollLeft;this.initScrollY=window.pageYOffset||document.body.scrollTop||document.documentElement.scrollTop;this.hideObserver=this._hide.bindAsEventListener(this);this.kbdObserver=this._kbdHandler.bindAsEventListener(this);this._initObservers();this.initialized=true},show:function(e,t){if(!this.initialized)this._init(t);this.content=e;this.setOptions(t);if(this.options.title)$(this.MBcaption).update(this.options.title);else{$(this.MBheader).hide();$(this.MBcaption).hide()}if(this.MBwindow.style.display=="none"){this._appear();this.event("onShow")}else{this._update();this.event("onUpdate")}},hide:function(e){if(this.initialized){if(e&&typeof e.element!="function")Object.extend(this.options,e);this.event("beforeHide");if(this.options.transitions)Effect.SlideUp(this.MBwindow,{duration:this.options.slideUpDuration,transition:Effect.Transitions.sinoidal,afterFinish:this._deinit.bind(this)});else{$(this.MBwindow).hide();this._deinit()}}else throw"Modalbox is not initialized."},_hide:function(e){e.stop();if(e.element().id=="MB_overlay"&&!this.options.overlayClose)return false;this.hide()},alert:function(e){var t='<div class="MB_alert"><p>'+e+'</p><input type="button" onclick="Modalbox.hide()" value="OK" /></div>';Modalbox.show(t,{title:"Alert: "+document.title,width:300})},_appear:function(){if(Prototype.Browser.IE&&!navigator.appVersion.match(/\b7.0\b/)){window.scrollTo(0,0);this._prepareIE("100%","hidden")}this._setWidth();this._setPosition();if(this.options.transitions){$(this.MBoverlay).setStyle({opacity:0});new Effect.Fade(this.MBoverlay,{from:0,to:this.options.overlayOpacity,duration:this.options.overlayDuration,afterFinish:function(){new Effect.SlideDown(this.MBwindow,{duration:this.options.slideDownDuration,transition:Effect.Transitions.sinoidal,afterFinish:function(){this._setPosition();this.loadContent()}.bind(this)})}.bind(this)})}else{$(this.MBoverlay).setStyle({opacity:this.options.overlayOpacity});$(this.MBwindow).show();this._setPosition();this.loadContent()}this._setWidthAndPosition=this._setWidthAndPosition.bindAsEventListener(this);Event.observe(window,"resize",this._setWidthAndPosition)},resize:function(e,t,n){var r=$(this.MBoverlay).getWidth();var i=$(this.MBwindow).getHeight();var s=$(this.MBwindow).getWidth();var o=$(this.MBheader).getHeight();var u=$(this.MBcontent).getHeight();var a=i-o+t<u?u+o:i+t;var f=s+e;if(n)this.setOptions(n);if(this.options.transitions){new Effect.Morph(this.MBwindow,{style:"width:"+f+"px; height:"+a+"px; left:"+(r-f)/2+"px",duration:this.options.resizeDuration,beforeStart:function(e){e.element.setStyle({overflow:"hidden"})},afterFinish:function(e){e.element.setStyle({overflow:"visible"});this.event("_afterResize");this.event("afterResize")}.bind(this)})}else{this.MBwindow.setStyle({width:f+"px",height:a+"px"});setTimeout(function(){this.event("_afterResize");this.event("afterResize")}.bind(this),1)}},resizeToContent:function(e){var t=this.options.height-$(this.MBwindow).getHeight();if(t!=0){if(e)this.setOptions(e);Modalbox.resize(0,t)}},resizeToInclude:function(e,t){var n=$(e);var r=n.getHeight()+parseInt(n.getStyle("margin-top"),0)+parseInt(n.getStyle("margin-bottom"),0)+parseInt(n.getStyle("border-top-width"),0)+parseInt(n.getStyle("border-bottom-width"),0);if(r>0){if(t)this.setOptions(t);Modalbox.resize(0,r)}},_update:function(){$(this.MBcontent).update($(this.MBloading).update(this.options.loadingString));this.loadContent()},loadContent:function(){if(this.event("beforeLoad")!=false){if(typeof this.content=="string"){var htmlRegExp=new RegExp(/<\/?[^>]+>/gi);if(htmlRegExp.test(this.content)){this._insertContent(this.content.stripScripts(),function(){this.content.extractScripts().map(function(script){return eval(script.replace("<!--","").replace("// -->",""))}.bind(window))}.bind(this))}else new Ajax.Request(this.content,{method:this.options.method.toLowerCase(),parameters:this.options.params,onSuccess:function(transport){var response=new String(transport.responseText);this._insertContent(transport.responseText.stripScripts(),function(){response.extractScripts().map(function(script){return eval(script.replace("<!--","").replace("// -->",""))}.bind(window))})}.bind(this),onException:function(e,t){Modalbox.hide();throw"Modalbox Loading Error: "+t}})}else if(typeof this.content=="object"){this._insertContent(this.content)}else{Modalbox.hide();throw"Modalbox Parameters Error: Please specify correct URL or HTML element (plain HTML or object)"}}},_insertContent:function(e,t){$(this.MBcontent).hide().update("");if(typeof e=="string"){this.MBcontent.update((new Element("div",{style:"display: none"})).update(e)).down().show()}else if(typeof e=="object"){var n=e.cloneNode(true);if(e.id)e.id="MB_"+e.id;$(e).select("*[id]").each(function(e){e.id="MB_"+e.id});this.MBcontent.update(n).down("div").show();if(Prototype.Browser.IE)$$("#MB_content select").invoke("setStyle",{visibility:""})}if(this.options.height==this._options.height){Modalbox.resize(this.options.width-$(this.MBwindow).getWidth(),$(this.MBcontent).getHeight()-$(this.MBwindow).getHeight()+$(this.MBheader).getHeight(),{afterResize:function(){setTimeout(function(){this._putContent(t)}.bind(this),1)}.bind(this)})}else{this._setWidth();this.MBcontent.setStyle({overflow:"auto",height:$(this.MBwindow).getHeight()-$(this.MBheader).getHeight()-13+"px"});setTimeout(function(){this._putContent(t)}.bind(this),1)}},_putContent:function(e){this.MBcontent.show();this.focusableElements=this._findFocusableElements();this._setFocus();if(e!=undefined)e();this.event("afterLoad")},activate:function(e){this.setOptions(e);this.active=true;$(this.MBclose).observe("click",this.hideObserver);if(this.options.overlayClose)$(this.MBoverlay).observe("click",this.hideObserver);$(this.MBclose).show();if(this.options.transitions&&this.options.inactiveFade)new Effect.Appear(this.MBwindow,{duration:this.options.slideUpDuration})},deactivate:function(e){this.setOptions(e);this.active=false;$(this.MBclose).stopObserving("click",this.hideObserver);if(this.options.overlayClose)$(this.MBoverlay).stopObserving("click",this.hideObserver);$(this.MBclose).hide();if(this.options.transitions&&this.options.inactiveFade)new Effect.Fade(this.MBwindow,{duration:this.options.slideUpDuration,to:.75})},_initObservers:function(){$(this.MBclose).observe("click",this.hideObserver);if(this.options.overlayClose)$(this.MBoverlay).observe("click",this.hideObserver);if(Prototype.Browser.Gecko)Event.observe(document,"keypress",this.kbdObserver);else Event.observe(document,"keydown",this.kbdObserver)},_removeObservers:function(){$(this.MBclose).stopObserving("click",this.hideObserver);if(this.options.overlayClose)$(this.MBoverlay).stopObserving("click",this.hideObserver);if(Prototype.Browser.Gecko)Event.stopObserving(document,"keypress",this.kbdObserver);else Event.stopObserving(document,"keydown",this.kbdObserver)},_setFocus:function(){if(this.focusableElements.length>0&&this.options.autoFocusing==true){var e=this.focusableElements.find(function(e){return e.tabIndex==1})||this.focusableElements.first();this.currFocused=this.focusableElements.toArray().indexOf(e);e.focus()}else if($(this.MBclose).visible())$(this.MBclose).focus()},_findFocusableElements:function(){this.MBcontent.select("input:not([type~=hidden]), select, textarea, button, a[href]").invoke("addClassName","MB_focusable");return this.MBcontent.select(".MB_focusable")},_kbdHandler:function(e){var t=e.element();switch(e.keyCode){case Event.KEY_TAB:e.stop();if(t!=this.focusableElements[this.currFocused])this.currFocused=this.focusableElements.toArray().indexOf(t);if(!e.shiftKey){if(this.currFocused==this.focusableElements.length-1){this.focusableElements.first().focus();this.currFocused=0}else{this.currFocused++;this.focusableElements[this.currFocused].focus()}}else{if(this.currFocused==0){this.focusableElements.last().focus();this.currFocused=this.focusableElements.length-1}else{this.currFocused--;this.focusableElements[this.currFocused].focus()}}break;case Event.KEY_ESC:if(this.active)this._hide(e);break;case 32:this._preventScroll(e);break;case 0:if(e.which==32)this._preventScroll(e);break;case Event.KEY_UP:case Event.KEY_DOWN:case Event.KEY_PAGEDOWN:case Event.KEY_PAGEUP:case Event.KEY_HOME:case Event.KEY_END:if(Prototype.Browser.WebKit&&!["textarea","select"].include(t.tagName.toLowerCase()))e.stop();else if(t.tagName.toLowerCase()=="input"&&["submit","button"].include(t.type)||t.tagName.toLowerCase()=="a")e.stop();break}},_preventScroll:function(e){if(!["input","textarea","select","button"].include(e.element().tagName.toLowerCase()))e.stop()},_deinit:function(){this._removeObservers();Event.stopObserving(window,"resize",this._setWidthAndPosition);if(this.options.transitions){Effect.toggle(this.MBoverlay,"appear",{duration:this.options.overlayDuration,afterFinish:this._removeElements.bind(this)})}else{this.MBoverlay.hide();this._removeElements()}$(this.MBcontent).setStyle({overflow:"",height:""})},_removeElements:function(){$(this.MBoverlay).remove();$(this.MBwindow).remove();if(Prototype.Browser.IE&&!navigator.appVersion.match(/\b7.0\b/)){this._prepareIE("","");window.scrollTo(this.initScrollX,this.initScrollY)}if(typeof this.content=="object"){if(this.content.id&&this.content.id.match(/MB_/)){this.content.id=this.content.id.replace(/MB_/,"")}this.content.select("*[id]").each(function(e){e.id=e.id.replace(/MB_/,"")})}this.initialized=false;this.event("afterHide");this.setOptions(this._options)},_setWidth:function(){$(this.MBwindow).setStyle({width:this.options.width+"px",height:this.options.height+"px"})},_setPosition:function(){$(this.MBwindow).setStyle({left:($(this.MBoverlay).getWidth()-$(this.MBwindow).getWidth())/2+"px"})},_setWidthAndPosition:function(){$(this.MBwindow).setStyle({width:this.options.width+"px"});this._setPosition()},_getScrollTop:function(){var e;if(document.documentElement&&document.documentElement.scrollTop)e=document.documentElement.scrollTop;else if(document.body)e=document.body.scrollTop;return e},_prepareIE:function(e,t){$$("html, body").invoke("setStyle",{width:e,height:e,overflow:t});$$("select").invoke("setStyle",{visibility:t})},event:function(e){if(this.options[e]){var t=this.options[e]();this.options[e]=null;if(t!=undefined)return t;else return true}return true}};Object.extend(Modalbox,Modalbox.Methods);if(Modalbox.overrideAlert)window.alert=Modalbox.alert