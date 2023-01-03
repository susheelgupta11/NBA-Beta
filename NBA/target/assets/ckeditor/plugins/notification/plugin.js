"use strict";function Notification(e,t){CKEDITOR.tools.extend(this,t,{editor:e,id:"cke-"+CKEDITOR.tools.getUniqueId(),area:e._.notificationArea});if(!t.type){this.type="info"}this.element=this._createElement();e.plugins.clipboard&&CKEDITOR.plugins.clipboard.preventDefaultDropOnElement(this.element)}function Area(e){var t=this;this.editor=e;this.notifications=[];this.element=this._createElement();this._uiBuffer=CKEDITOR.tools.eventsBuffer(10,this._layout,this);this._changeBuffer=CKEDITOR.tools.eventsBuffer(500,this._layout,this);e.on("destroy",function(){t._removeListeners();t.element.remove()})}CKEDITOR.plugins.add("notification",{lang:"cs,da,de,de-ch,en,eo,eu,fr,gl,id,it,km,ko,ku,nb,nl,pl,pt,pt-br,ru,sv,tr,ug,uk,zh,zh-cn",requires:"toolbar",init:function(e){function t(e){var t=new CKEDITOR.dom.element("div");t.setStyles({position:"fixed","margin-left":"-9999px"});t.setAttributes({"aria-live":"assertive","aria-atomic":"true"});t.setText(e);CKEDITOR.document.getBody().append(t);setTimeout(function(){t.remove()},100)}e._.notificationArea=new Area(e);e.showNotification=function(t,n,r){var i,s;if(n=="progress"){i=r}else{s=r}var o=new CKEDITOR.plugins.notification(e,{message:t,type:n,progress:i,duration:s});o.show();return o};e.on("key",function(n){if(n.data.keyCode==27){var r=e._.notificationArea.notifications;if(!r.length){return}t(e.lang.notification.closed);r[r.length-1].hide();n.cancel()}})}});Notification.prototype={show:function(){if(this.editor.fire("notificationShow",{notification:this})===false){return}this.area.add(this);this._hideAfterTimeout()},update:function(e){var t=true;if(this.editor.fire("notificationUpdate",{notification:this,options:e})===false){t=false}var n=this.element,r=n.findOne(".cke_notification_message"),i=n.findOne(".cke_notification_progress"),s=e.type;n.removeAttribute("role");if(e.progress&&this.type!="progress"){s="progress"}if(s){n.removeClass(this._getClass());n.removeAttribute("aria-label");this.type=s;n.addClass(this._getClass());n.setAttribute("aria-label",this.type);if(this.type=="progress"&&!i){i=this._createProgressElement();i.insertBefore(r)}else if(this.type!="progress"&&i){i.remove()}}if(e.message!==undefined){this.message=e.message;r.setHtml(this.message)}if(e.progress!==undefined){this.progress=e.progress;if(i){i.setStyle("width",this._getPercentageProgress())}}if(t&&e.important){n.setAttribute("role","alert");if(!this.isVisible()){this.area.add(this)}}this.duration=e.duration;this._hideAfterTimeout()},hide:function(){if(this.editor.fire("notificationHide",{notification:this})===false){return}this.area.remove(this)},isVisible:function(){return CKEDITOR.tools.indexOf(this.area.notifications,this)>=0},_createElement:function(){var e=this,t,n,r,i=this.editor.lang.common.close;t=new CKEDITOR.dom.element("div");t.addClass("cke_notification");t.addClass(this._getClass());t.setAttributes({id:this.id,role:"alert","aria-label":this.type});if(this.type=="progress")t.append(this._createProgressElement());n=new CKEDITOR.dom.element("p");n.addClass("cke_notification_message");n.setHtml(this.message);t.append(n);r=CKEDITOR.dom.element.createFromHtml('<a class="cke_notification_close" href="javascript:void(0)" title="'+i+'" role="button" tabindex="-1">'+'<span class="cke_label">X</span>'+"</a>");t.append(r);r.on("click",function(){e.editor.focus();e.hide()});return t},_getClass:function(){return this.type=="progress"?"cke_notification_info":"cke_notification_"+this.type},_createProgressElement:function(){var e=new CKEDITOR.dom.element("span");e.addClass("cke_notification_progress");e.setStyle("width",this._getPercentageProgress());return e},_getPercentageProgress:function(){return Math.round((this.progress||0)*100)+"%"},_hideAfterTimeout:function(){var e=this,t;if(this._hideTimeoutId){clearTimeout(this._hideTimeoutId)}if(typeof this.duration=="number"){t=this.duration}else if(this.type=="info"||this.type=="success"){t=typeof this.editor.config.notification_duration=="number"?this.editor.config.notification_duration:5e3}if(t){e._hideTimeoutId=setTimeout(function(){e.hide()},t)}}};Area.prototype={add:function(e){this.notifications.push(e);this.element.append(e.element);if(this.element.getChildCount()==1){CKEDITOR.document.getBody().append(this.element);this._attachListeners()}this._layout()},remove:function(e){var t=CKEDITOR.tools.indexOf(this.notifications,e);if(t<0){return}this.notifications.splice(t,1);e.element.remove();if(!this.element.getChildCount()){this._removeListeners();this.element.remove()}},_createElement:function(){var e=this.editor,t=e.config,n=new CKEDITOR.dom.element("div");n.addClass("cke_notifications_area");n.setAttribute("id","cke_notifications_area_"+e.name);n.setStyle("z-index",t.baseFloatZIndex-2);return n},_attachListeners:function(){var e=CKEDITOR.document.getWindow(),t=this.editor;e.on("scroll",this._uiBuffer.input);e.on("resize",this._uiBuffer.input);t.on("change",this._changeBuffer.input);t.on("floatingSpaceLayout",this._layout,this,null,20);t.on("blur",this._layout,this,null,20)},_removeListeners:function(){var e=CKEDITOR.document.getWindow(),t=this.editor;e.removeListener("scroll",this._uiBuffer.input);e.removeListener("resize",this._uiBuffer.input);t.removeListener("change",this._changeBuffer.input);t.removeListener("floatingSpaceLayout",this._layout);t.removeListener("blur",this._layout)},_layout:function(){function m(){e.setStyles({position:"absolute",top:v(r.y)})}function g(){e.setStyles({position:"fixed",top:v(s.bottom)})}function y(){e.setStyles({position:"fixed",top:0})}function b(){e.setStyles({position:"absolute",top:v(r.y+n.height-o.height)})}function E(){e.setStyle("left",v(w))}function S(){e.setStyle("left",v(w-r.x+c.x))}function x(){e.setStyle("left",v(w+n.width/2-a/2-f/2))}function T(){e.setStyle("left",v(w+n.width-a-f))}function N(){e.setStyle("left",v(w-r.x+c.x+h.width-a-f))}var e=this.element,t=this.editor,n=t.ui.contentsElement.getClientRect(),r=t.ui.contentsElement.getDocumentPosition(),i=t.ui.space("top"),s=i.getClientRect(),o=e.getClientRect(),u,a=this._notificationWidth,f=this._notificationMargin,l=CKEDITOR.document.getWindow(),c=l.getScrollPosition(),h=l.getViewPaneSize(),p=CKEDITOR.document.getBody(),d=p.getDocumentPosition(),v=CKEDITOR.tools.cssLength;if(!a||!f){u=this.element.getChild(0);a=this._notificationWidth=u.getClientRect().width;f=this._notificationMargin=parseInt(u.getComputedStyle("margin-left"),10)+parseInt(u.getComputedStyle("margin-right"),10)}if(i.isVisible()&&s.bottom>n.top&&s.bottom<n.bottom-o.height){g()}else if(n.top>0){m()}else if(r.y+n.height-o.height>c.y){y()}else{b()}var w=e.getStyle("position")=="fixed"?n.left:p.getComputedStyle("position")!="static"?r.x-d.x:r.x;if(n.width<a+f){if(r.x+a+f>c.x+h.width){T()}else{E()}}else{if(r.x+a+f>c.x+h.width){E()}else if(r.x+n.width/2+a/2+f>c.x+h.width){N()}else if(n.left+n.width-a-f<0){T()}else if(n.left+n.width/2-a/2<0){S()}else{x()}}}};CKEDITOR.plugins.notification=Notification