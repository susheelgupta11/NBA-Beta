CKEDITOR.dialog.add("paste",function(e){function t(t){var n=new CKEDITOR.dom.document(t.document),s=n.getBody(),o=n.getById("cke_actscrpt");o&&o.remove();s.setAttribute("contenteditable",!0);s.on(r.mainPasteEvent,function(e){e=r.initPasteDataTransfer(e);i?e!=i&&(i=r.initPasteDataTransfer()):i=e});if(CKEDITOR.env.ie&&8>CKEDITOR.env.version)n.getWindow().on("blur",function(){n.$.selection.empty()});n.on("keydown",function(e){e=e.data;var t;switch(e.getKeystroke()){case 27:this.hide();t=1;break;case 9:case CKEDITOR.SHIFT+9:this.changeFocus(1),t=1}t&&e.preventDefault()},this);e.fire("ariaWidget",new CKEDITOR.dom.element(t.frameElement));n.getWindow().getFrame().removeCustomData("pendingFocus")&&s.focus()}var n=e.lang.clipboard,r=CKEDITOR.plugins.clipboard,i;e.on("pasteDialogCommit",function(t){t.data&&e.fire("paste",{type:"auto",dataValue:t.data.dataValue,method:"paste",dataTransfer:t.data.dataTransfer||r.initPasteDataTransfer()})},null,null,1e3);return{title:n.title,minWidth:CKEDITOR.env.ie&&CKEDITOR.env.quirks?370:350,minHeight:CKEDITOR.env.quirks?250:245,onShow:function(){this.parts.dialog.$.offsetHeight;this.setupContent();this.parts.title.setHtml(this.customTitle||n.title);this.customTitle=null},onLoad:function(){(CKEDITOR.env.ie7Compat||CKEDITOR.env.ie6Compat)&&"rtl"==e.lang.dir&&this.parts.contents.setStyle("overflow","hidden")},onOk:function(){this.commitContent()},contents:[{id:"general",label:e.lang.common.generalTab,elements:[{type:"html",id:"securityMsg",html:'<div style="white-space:normal;width:340px">'+n.securityMsg+"</div>"},{type:"html",id:"pasteMsg",html:'<div style="white-space:normal;width:340px">'+n.pasteMsg+"</div>"},{type:"html",id:"editing_area",style:"width:100%;height:100%",html:"",focus:function(){var e=this.getInputElement(),t=e.getFrameDocument().getBody();!t||t.isReadOnly()?e.setCustomData("pendingFocus",1):t.focus()},setup:function(){var r=this.getDialog(),s='<html dir="'+e.config.contentsLangDirection+'" lang="'+(e.config.contentsLanguage||e.langCode)+'"><head><style>body{margin:3px;height:95%;word-break:break-all;}</style></head><body><script id="cke_actscrpt" type="text/javascript">window.parent.CKEDITOR.tools.callFunction('+CKEDITOR.tools.addFunction(t,r)+",this);</script></body></html>",o=CKEDITOR.env.air?"javascript:void(0)":CKEDITOR.env.ie&&!CKEDITOR.env.edge?"javascript:void((function(){"+encodeURIComponent("document.open();("+CKEDITOR.tools.fixDomain+")();document.close();")+'})())"':"",u=CKEDITOR.dom.element.createFromHtml('<iframe class="cke_pasteframe" frameborder="0"  allowTransparency="true" src="'+o+'" aria-label="'+n.pasteArea+'" aria-describedby="'+r.getContentElement("general","pasteMsg").domId+'"></iframe>');i=null;u.on("load",function(n){n.removeListener();n=u.getFrameDocument();n.write(s);e.focusManager.add(n.getBody());CKEDITOR.env.air&&t.call(this,n.getWindow().$)},r);u.setCustomData("dialog",r);r=this.getElement();r.setHtml("");r.append(u);if(CKEDITOR.env.ie&&!CKEDITOR.env.edge){var a=CKEDITOR.dom.element.createFromHtml('<span tabindex="-1" style="position:absolute" role="presentation"></span>');a.on("focus",function(){setTimeout(function(){u.$.contentWindow.focus()})});r.append(a);this.focus=function(){a.focus();this.fire("focus")}}this.getInputElement=function(){return u};CKEDITOR.env.ie&&(r.setStyle("display","block"),r.setStyle("height",u.$.offsetHeight+2+"px"))},commit:function(){var e=this.getDialog().getParentEditor(),t=this.getInputElement().getFrameDocument().getBody(),n=t.getBogus(),s;n&&n.remove();s=t.getHtml();setTimeout(function(){e.fire("pasteDialogCommit",{dataValue:s,dataTransfer:i||r.initPasteDataTransfer()})},0)}}]}]}})