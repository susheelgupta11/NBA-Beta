"function"!=typeof Object.create&&function(){var e=function(){};Object.create=function(t){if(1<arguments.length)throw Error("Second argument not supported");if(null===t)throw Error("Cannot set a null [[Prototype]]");if("object"!=typeof t)throw TypeError("Argument must be an object");e.prototype=t;return new e}}();CKEDITOR.plugins.add("toolbarconfiguratorarea",{afterInit:function(e){e.addMode("wysiwyg",function(t){var n=CKEDITOR.dom.element.createFromHtml('<div class="cke_wysiwyg_div cke_reset" hidefocus="true"></div>');e.ui.space("contents").append(n);n=e.editable(n);n.detach=CKEDITOR.tools.override(n.detach,function(e){return function(){e.apply(this,arguments);this.remove()}});e.setData(e.getData(1),t);e.fire("contentDom")});e.dataProcessor.toHtml=function(e){return e};e.dataProcessor.toDataFormat=function(e){return e}}});Object.keys||(Object.keys=function(){var e=Object.prototype.hasOwnProperty,t=!{toString:null}.propertyIsEnumerable("toString"),n="toString toLocaleString valueOf hasOwnProperty isPrototypeOf propertyIsEnumerable constructor".split(" "),r=n.length;return function(i){if("object"!==typeof i&&("function"!==typeof i||null===i))throw new TypeError("Object.keys called on non-object");var s=[],o;for(o in i)e.call(i,o)&&s.push(o);if(t)for(o=0;o<r;o++)e.call(i,n[o])&&s.push(n[o]);return s}}());(function(){function e(e,t){this.cfg=t||{};this.hidden=!1;this.editorId=e;this.fullToolbarEditor=new ToolbarConfigurator.FullToolbarEditor;this.actualConfig=this.originalConfig=this.mainContainer=null;this.isEditableVisible=this.waitForReady=!1;this.toolbarContainer=null;this.toolbarButtons=[]}ToolbarConfigurator.AbstractToolbarModifier=e;e.prototype.setConfig=function(e){this._onInit(void 0,e,!0)};e.prototype.init=function(e){var t=this;this.mainContainer=new CKEDITOR.dom.element("div");if(null!==this.fullToolbarEditor.editorInstance)throw"Only one instance of ToolbarModifier is allowed";this.editorInstance||this._createEditor(!1);this.editorInstance.once("loaded",function(){t.fullToolbarEditor.init(function(){t._onInit(e);if("function"==typeof t.onRefresh)t.onRefresh()},t.editorInstance.config)});return this.mainContainer};e.prototype._onInit=function(e,t){this.originalConfig=this.editorInstance.config;this.actualConfig=t?JSON.parse(t):JSON.parse(JSON.stringify(this.originalConfig));if(!this.actualConfig.toolbarGroups&&!this.actualConfig.toolbar){for(var n=this.actualConfig,r=this.editorInstance.toolbar,i=[],s=r.length,o=0;o<s;o++){var u=r[o];"string"==typeof u?i.push(u):i.push({name:u.name,groups:u.groups?u.groups.slice():[]})}n.toolbarGroups=i}"function"===typeof e&&e(this.mainContainer)};e.prototype._createModifier=function(){this.mainContainer.addClass("unselectable");this.modifyContainer&&this.modifyContainer.remove();this.modifyContainer=new CKEDITOR.dom.element("div");this.modifyContainer.addClass("toolbarModifier");this.mainContainer.append(this.modifyContainer);return this.mainContainer};e.prototype.getEditableArea=function(){return this.editorInstance.container.findOne("#"+this.editorInstance.id+"_contents")};e.prototype._hideEditable=function(){var e=this.getEditableArea();this.isEditableVisible=!1;this.lastEditableAreaHeight=e.getStyle("height");e.setStyle("height","0")};e.prototype._showEditable=function(){this.isEditableVisible=!0;this.getEditableArea().setStyle("height",this.lastEditableAreaHeight||"auto")};e.prototype._toggleEditable=function(){this.isEditableVisible?this._hideEditable():this._showEditable()};e.prototype._refreshEditor=function(){function e(){t.editorInstance.destroy();t._createEditor(!0,t.getActualConfig());t.waitForReady=!1}var t=this,n=this.editorInstance.status;this.waitForReady||("unloaded"==n||"loaded"==n?(this.waitForReady=!0,this.editorInstance.once("instanceReady",function(){e()},this)):e())};e.prototype._createEditor=function(t,n){function r(){}var i=this;this.editorInstance=CKEDITOR.replace(this.editorId);this.editorInstance.on("configLoaded",function(){var t=i.editorInstance.config;n&&CKEDITOR.tools.extend(t,n,!0);e.extendPluginsConfig(t)});this.editorInstance.on("uiSpace",function(e){"top"!=e.data.space&&e.stop()},null,null,-999);this.editorInstance.once("loaded",function(){var e=i.editorInstance.ui.instances,n;for(n in e)e[n]&&(e[n].click=r,e[n].onClick=r);i.isEditableVisible||i._hideEditable();i.currentActive&&i.currentActive.name&&i._highlightGroup(i.currentActive.name);i.hidden?i.hideUI():i.showUI();if(t&&"function"===typeof i.onRefresh)i.onRefresh()})};e.prototype.getActualConfig=function(){return JSON.parse(JSON.stringify(this.actualConfig))};e.prototype._createToolbar=function(){if(this.toolbarButtons.length){this.toolbarContainer=new CKEDITOR.dom.element("div");this.toolbarContainer.addClass("toolbar");for(var e=this.toolbarButtons.length,t=0;t<e;t+=1)this._createToolbarBtn(this.toolbarButtons[t])}};e.prototype._createToolbarBtn=function(e){var t=ToolbarConfigurator.FullToolbarEditor.createButton("string"===typeof e.text?e.text:e.text.inactive,e.cssClass);this.toolbarContainer.append(t);t.data("group",e.group);t.addClass(e.position);t.on("click",function(){e.clickCallback.call(this,t,e)},this);return t};e.prototype._fixGroups=function(e){e=e.toolbarGroups||[];for(var t=e.length,n=0;n<t;n+=1){var r=e[n];"/"==r?(r=e[n]={},r.type="separator",r.name="separator"+CKEDITOR.tools.getNextNumber()):(r.groups=r.groups||[],-1==CKEDITOR.tools.indexOf(r.groups,r.name)&&(this.editorInstance.ui.addToolbarGroup(r.name,r.groups[r.groups.length-1],r.name),r.groups.push(r.name)),this._fixSubgroups(r))}};e.prototype._fixSubgroups=function(e){e=e.groups;for(var t=e.length,n=0;n<t;n+=1){var r=e[n];e[n]={name:r,totalBtns:ToolbarConfigurator.ToolbarModifier.getTotalSubGroupButtonsNumber(r,this.fullToolbarEditor)}}};e.stringifyJSONintoOneLine=function(e,t){t=t||{};var n=JSON.stringify(e,null,""),n=n.replace(/\n/g,"");t.addSpaces&&(n=n.replace(/(\{|:|,|\[|\])/g,function(e){return e+" "}),n=n.replace(/(\])/g,function(e){return" "+e}));t.noQuotesOnKey&&(n=n.replace(/"(\w*)":/g,function(e,t){return t+":"}));t.singleQuotes&&(n=n.replace(/\"/g,"'"));return n};e.prototype.hideUI=function(){this.hidden=!0;this.mainContainer.hide();this.editorInstance.container&&this.editorInstance.container.hide()};e.prototype.showUI=function(){this.hidden=!1;this.mainContainer.show();this.editorInstance.container&&this.editorInstance.container.show()};e.extendPluginsConfig=function(e){var t=e.extraPlugins;e.extraPlugins=(t?t+",":"")+"toolbarconfiguratorarea"}})()