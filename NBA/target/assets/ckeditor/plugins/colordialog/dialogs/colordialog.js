CKEDITOR.dialog.add("colordialog",function(e){function t(){l.getById(w).removeStyle("background-color");h.getContentElement("picker","selectedColor").setValue("");r()}function n(e){e=e.data.getTarget();var t;"td"==e.getName()&&(t=e.getChild(0).getHtml())&&(r(),p=e,p.setAttribute("aria-selected",!0),p.addClass("cke_colordialog_selected"),h.getContentElement("picker","selectedColor").setValue(t))}function r(){p&&(p.removeClass("cke_colordialog_selected"),p.removeAttribute("aria-selected"),p=null)}function i(e){e=e.replace(/^#/,"");for(var t=0,n=[];2>=t;t++)n[t]=parseInt(e.substr(2*t,2),16);return 165<=.2126*n[0]+.7152*n[1]+.0722*n[2]}function s(e){!e.name&&(e=new CKEDITOR.event(e));var t=!/mouse/.test(e.name),n=e.data.getTarget(),r;"td"==n.getName()&&(r=n.getChild(0).getHtml())&&(o(e),t?v=n:m=n,t&&n.addClass(i(r)?"cke_colordialog_focused_light":"cke_colordialog_focused_dark"),u(r))}function o(e){if(e=!/mouse/.test(e.name)&&v)e.removeClass("cke_colordialog_focused_light"),e.removeClass("cke_colordialog_focused_dark");v||m||u(!1)}function u(e){e?(l.getById(y).setStyle("background-color",e),l.getById(b).setHtml(e)):(l.getById(y).removeStyle("background-color"),l.getById(b).setHtml("&nbsp;"))}function a(t){var r=t.data,i=r.getTarget(),s=r.getKeystroke(),o="rtl"==e.lang.dir;switch(s){case 38:if(t=i.getParent().getPrevious())t=t.getChild([i.getIndex()]),t.focus();r.preventDefault();break;case 40:(t=i.getParent().getNext())&&(t=t.getChild([i.getIndex()]))&&1==t.type&&t.focus();r.preventDefault();break;case 32:case 13:n(t);r.preventDefault();break;case o?37:39:(t=i.getNext())?1==t.type&&(t.focus(),r.preventDefault(!0)):(t=i.getParent().getNext())&&(t=t.getChild([0]))&&1==t.type&&(t.focus(),r.preventDefault(!0));break;case o?39:37:if(t=i.getPrevious())t.focus(),r.preventDefault(!0);else if(t=i.getParent().getPrevious())t=t.getLast(),t.focus(),r.preventDefault(!0)}}var f=CKEDITOR.dom.element,l=CKEDITOR.document,c=e.lang.colordialog,h,p,d={type:"html",html:"&nbsp;"},v,m,g=function(e){return CKEDITOR.tools.getNextId()+"_"+e},y=g("hicolor"),b=g("hicolortext"),w=g("selhicolor"),E;(function(){function e(e,n){for(var i=e;i<e+3;i++){var s=new f(E.$.insertRow(-1));s.setAttribute("role","row");for(var o=n;o<n+3;o++)for(var u=0;6>u;u++)t(s.$,"#"+r[o]+r[u]+r[i])}}function t(e,t){var r=new f(e.insertCell(-1));r.setAttribute("class","ColorCell cke_colordialog_colorcell");r.setAttribute("tabIndex",-1);r.setAttribute("role","gridcell");r.on("keydown",a);r.on("click",n);r.on("focus",s);r.on("blur",o);r.setStyle("background-color",t);var i=g("color_table_cell");r.setAttribute("aria-labelledby",i);r.append(CKEDITOR.dom.element.createFromHtml('<span id="'+i+'" class="cke_voice_label">'+t+"</span>",CKEDITOR.document))}E=CKEDITOR.dom.element.createFromHtml('<table tabIndex="-1" class="cke_colordialog_table" aria-label="'+c.options+'" role="grid" style="border-collapse:separate;" cellspacing="0"><caption class="cke_voice_label">'+c.options+'</caption><tbody role="presentation"></tbody></table>');E.on("mouseover",s);E.on("mouseout",o);var r="00 33 66 99 cc ff".split(" ");e(0,0);e(3,0);e(0,3);e(3,3);var i=new f(E.$.insertRow(-1));i.setAttribute("role","row");t(i.$,"#000000");for(var u=0;16>u;u++){var l=u.toString(16);t(i.$,"#"+l+l+l+l+l+l)}t(i.$,"#ffffff")})();CKEDITOR.document.appendStyleSheet(CKEDITOR.getUrl(CKEDITOR.plugins.get("colordialog").path+"dialogs/colordialog.css"));return{title:c.title,minWidth:360,minHeight:220,onLoad:function(){h=this},onHide:function(){t();v.removeClass("cke_colordialog_focused_light");v.removeClass("cke_colordialog_focused_dark");u(!1);v=null},contents:[{id:"picker",label:c.title,accessKey:"I",elements:[{type:"hbox",padding:0,widths:["70%","10%","30%"],children:[{type:"html",html:"<div></div>",onLoad:function(){CKEDITOR.document.getById(this.domId).append(E)},focus:function(){(v||this.getElement().getElementsByTag("td").getItem(0)).focus()}},d,{type:"vbox",padding:0,widths:["70%","5%","25%"],children:[{type:"html",html:"<span>"+c.highlight+'</span><div id="'+y+'" style="border: 1px solid; height: 74px; width: 74px;"></div><div id="'+b+'">&nbsp;</div><span>'+c.selected+'</span><div id="'+w+'" style="border: 1px solid; height: 20px; width: 74px;"></div>'},{type:"text",label:c.selected,labelStyle:"display:none",id:"selectedColor",style:"width: 76px;margin-top:4px",onChange:function(){try{l.getById(w).setStyle("background-color",this.getValue())}catch(e){t()}}},d,{type:"button",id:"clear",label:c.clear,onClick:t}]}]}]}]}})