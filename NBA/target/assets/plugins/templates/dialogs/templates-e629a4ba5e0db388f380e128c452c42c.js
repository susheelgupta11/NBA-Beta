(function(){CKEDITOR.dialog.add("templates",function(e){function t(e,t){var r=CKEDITOR.dom.element.createFromHtml('<a href="javascript:void(0)" tabIndex="-1" role="option" ><div class="cke_tpl_item"></div></a>'),i='<table style="width:350px;" class="cke_tpl_preview" role="presentation"><tr>';e.image&&t&&(i+='<td class="cke_tpl_preview_img"><img src="'+CKEDITOR.getUrl(t+e.image)+'"'+(CKEDITOR.env.ie6Compat?' onload="this.width=this.width"':"")+' alt="" title=""></td>');i+='<td style="white-space:normal;"><span class="cke_tpl_title">'+e.title+"</span><br/>";e.description&&(i+="<span>"+e.description+"</span>");i+="</td></tr></table>";r.getFirst().setHtml(i);r.on("click",function(){n(e.html)});return r}function n(t){var n=CKEDITOR.dialog.getCurrent();n.getValueOf("selectTpl","chkInsertOpt")?(e.fire("saveSnapshot"),e.setData(t,function(){n.hide();var t=e.createRange();t.moveToElementEditStart(e.editable());t.select();setTimeout(function(){e.fire("saveSnapshot")},0)})):(e.insertHtml(t),n.hide())}function r(e){var t=e.data.getTarget(),n=s.equals(t);if(n||s.contains(t)){var r=e.data.getKeystroke(),i=s.getElementsByTag("a"),o;if(i){if(n)o=i.getItem(0);else switch(r){case 40:o=t.getNext();break;case 38:o=t.getPrevious();break;case 13:case 32:t.fire("click")}o&&(o.focus(),e.data.preventDefault())}}}var i=CKEDITOR.plugins.get("templates");CKEDITOR.document.appendStyleSheet(CKEDITOR.getUrl(i.path+"dialogs/templates.css"));var s,i="cke_tpl_list_label_"+CKEDITOR.tools.getNextNumber(),o=e.lang.templates,u=e.config;return{title:e.lang.templates.title,minWidth:CKEDITOR.env.ie?440:400,minHeight:340,contents:[{id:"selectTpl",label:o.title,elements:[{type:"vbox",padding:5,children:[{id:"selectTplText",type:"html",html:"<span>"+o.selectPromptMsg+"</span>"},{id:"templatesList",type:"html",focus:!0,html:'<div class="cke_tpl_list" tabIndex="-1" role="listbox" aria-labelledby="'+i+'"><div class="cke_tpl_loading"><span></span></div></div><span class="cke_voice_label" id="'+i+'">'+o.options+"</span>"},{id:"chkInsertOpt",type:"checkbox",label:o.insertOption,"default":u.templates_replaceContent}]}]}],buttons:[CKEDITOR.dialog.cancelButton],onShow:function(){var e=this.getContentElement("selectTpl","templatesList");s=e.getElement();CKEDITOR.loadTemplates(u.templates_files,function(){var n=(u.templates||"default").split(",");if(n.length){var r=s;r.setHtml("");for(var i=0,l=n.length;i<l;i++)for(var c=CKEDITOR.getTemplates(n[i]),h=c.imagesPath,c=c.templates,p=c.length,d=0;d<p;d++){var v=t(c[d],h);v.setAttribute("aria-posinset",d+1);v.setAttribute("aria-setsize",p);r.append(v)}e.focus()}else s.setHtml('<div class="cke_tpl_empty"><span>'+o.emptyListMsg+"</span></div>")});this._.element.on("keydown",r)},onHide:function(){this._.element.removeListener("keydown",r)}}})})()