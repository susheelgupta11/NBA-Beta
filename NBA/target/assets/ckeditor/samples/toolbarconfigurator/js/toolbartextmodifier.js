(function(){function e(e){t.call(this,e);this.hintContainer=this.codeContainer=null}var t=ToolbarConfigurator.AbstractToolbarModifier,n=ToolbarConfigurator.FullToolbarEditor;ToolbarConfigurator.ToolbarTextModifier=e;e.prototype=Object.create(t.prototype);e.prototype._onInit=function(e,n){t.prototype._onInit.call(this,void 0,n);this._createModifier(n?this.actualConfig:void 0);"function"===typeof e&&e(this.mainContainer)};e.prototype._createModifier=function(e){function r(e){var t=s(e);if(null!==t.charsBetween){var n=u.getUnusedButtonsArray(u.actualConfig.toolbar,!0,t.charsBetween),r=e.getCursor(),t=CodeMirror.Pos(r.line,r.ch-t.charsBetween.length),o=e.getTokenAt(r);"{"===e.getTokenAt({line:r.line,ch:o.start}).string&&(n=["name"]);if(0!==n.length)return new i(t,r,n)}}function i(e,t,n){this.from=e;this.to=t;this.list=n;this._handlers=[]}function s(e,t){var n={};n.cur=e.getCursor();n.tok=e.getTokenAt(n.cur);n["char"]=t||n.tok.string.charAt(n.tok.string.length-1);var r=e.getRange(CodeMirror.Pos(n.cur.line,0),n.cur).split("").reverse().join(""),r=r.replace(/(['|"]\w*['|"])/g,"");n.charsBetween=r.match(/(^\w*)(['|"])/);n.charsBetween&&(n.endChar=n.charsBetween[2],n.charsBetween=n.charsBetween[1].split("").reverse().join(""));return n}function o(e){setTimeout(function(){e.state.completionActive||CodeMirror.showHint(e,r,{hintsClass:"toolbar-modifier",completeSingle:!1})},100);return CodeMirror.Pass}var u=this;this._createToolbar();this.toolbarContainer&&this.mainContainer.append(this.toolbarContainer);t.prototype._createModifier.call(this);this._setupActualConfig(e);e=this.actualConfig.toolbar;e=CKEDITOR.tools.isArray(e)?"	config.toolbar = "+("[\n		"+n.map(e,function(e){return t.stringifyJSONintoOneLine(e,{addSpaces:!0,noQuotesOnKey:!0,singleQuotes:!0})}).join(",\n		")+"\n	]")+";":"config.toolbar = [];";e=["CKEDITOR.editorConfig = function( config ) {\n",e,"\n};"].join("");var a=new CKEDITOR.dom.element("div");a.addClass("codemirror-wrapper");this.modifyContainer.append(a);this.codeContainer=CodeMirror(a.$,{mode:{name:"javascript",json:!0},lineNumbers:!1,lineWrapping:!0,viewportMargin:Infinity,value:e,smartIndent:!1,indentWithTabs:!0,indentUnit:4,tabSize:4,theme:"neo",extraKeys:{Left:o,Right:o,"'''":o,"'\"'":o,Backspace:o,Delete:o,"Shift-Tab":"indentLess"}});this.codeContainer.on("endCompletion",function(e,t){var n=s(e);void 0!==t&&e.replaceSelection(n.endChar)});this.codeContainer.on("change",function(){var e=u.codeContainer.getValue(),e=u._evaluateValue(e);null!==e?(u.actualConfig.toolbar=e.toolbar?e.toolbar:u.actualConfig.toolbar,u._fillHintByUnusedElements(),u._refreshEditor(),u.mainContainer.removeClass("invalid")):u.mainContainer.addClass("invalid")});this.hintContainer=new CKEDITOR.dom.element("div");this.hintContainer.addClass("toolbarModifier-hints");this._fillHintByUnusedElements();this.hintContainer.insertBefore(a)};e.prototype._fillHintByUnusedElements=function(){var e=this.getUnusedButtonsArray(this.actualConfig.toolbar,!0),e=this.groupButtonNamesByGroup(e),t=n.map(e,function(e){var t=n.map(e.buttons,function(e){return"<code>"+e+"</code> "}).join("");return["<dt><code>",e.name,"</code></dt><dd>",t,"</dd>"].join("")}).join(" "),r='<dt class="list-header">Toolbar group</dt><dd class="list-header">Unused items</dd>';e.length||(r="<p>All items are in use.</p>");this.codeContainer.refresh();this.hintContainer.setHtml("<h3>Unused toolbar items</h3><dl>"+r+t+"</dl>")};e.prototype.getToolbarGroupByButtonName=function(e){var t=this.fullToolbarEditor.buttonNamesByGroup,n;for(n in t)for(var r=t[n],i=r.length;i--;)if(e===r[i])return n;return null};e.prototype.getUnusedButtonsArray=function(t,r,i){r=!0===r?!0:!1;var s=e.mapToolbarCfgToElementsList(t);t=Object.keys(this.fullToolbarEditor.editorInstance.ui.items);t=n.filter(t,function(e){var t="-"===e;e=void 0===i||0===e.toLowerCase().indexOf(i.toLowerCase());return!t&&e});t=n.filter(t,function(e){return-1==CKEDITOR.tools.indexOf(s,e)});r&&t.sort();return t};e.prototype.groupButtonNamesByGroup=function(e){var t=[],r=JSON.parse(JSON.stringify(this.fullToolbarEditor.buttonNamesByGroup)),i;for(i in r){var s=r[i],s=n.filter(s,function(t){return-1!==CKEDITOR.tools.indexOf(e,t)});s.length&&t.push({name:i,buttons:s})}return t};e.mapToolbarCfgToElementsList=function(e){function t(e){return"-"!==e}for(var r=[],i=e.length,s=0;s<i;s+=1)e[s]&&"string"!==typeof e[s]&&(r=r.concat(n.filter(e[s].items,t)));return r};e.prototype._setupActualConfig=function(e){e=e||this.editorInstance.config;CKEDITOR.tools.isArray(e.toolbar)||(e.toolbarGroups||(e.toolbarGroups=this.fullToolbarEditor.getFullToolbarGroupsConfig(!0)),this._fixGroups(e),e.toolbar=this._mapToolbarGroupsToToolbar(e.toolbarGroups,this.actualConfig.removeButtons),this.actualConfig.toolbar=e.toolbar,this.actualConfig.removeButtons="")};e.prototype._mapToolbarGroupsToToolbar=function(e,t){t=t||this.editorInstance.config.removedBtns;t="string"==typeof t?t.split(","):[];for(var n=e.length;n--;){var r=this._mapToolbarSubgroup(e[n],t);"separator"===e[n].type?e[n]="/":CKEDITOR.tools.isArray(r)&&0===r.length?e.splice(n,1):e[n]="string"==typeof r?r:{name:e[n].name,items:r}}return e};e.prototype._mapToolbarSubgroup=function(e,t){if("string"==typeof e)return e;for(var n=e.groups?e.groups.length:0,r=[],i=0;i<n;i+=1){var s=e.groups[i],s=this.fullToolbarEditor.buttonsByGroup["string"===typeof s?s:s.name]||[],s=this._mapButtonsToButtonsNames(s,t),o=s.length,r=r.concat(s);o&&r.push("-")}"-"==r[r.length-1]&&r.pop();return r};e.prototype._mapButtonsToButtonsNames=function(e,t){for(var n=e.length;n--;){var r=e[n],r="string"===typeof r?r:this.fullToolbarEditor.getCamelCasedButtonName(r.name);-1!==CKEDITOR.tools.indexOf(t,r)?e.splice(n,1):e[n]=r}return e};e.prototype._evaluateValue=function(e){var t;try{var n={};Function("var CKEDITOR = {}; "+e+"; return CKEDITOR;")().editorConfig(n);t=n;for(var r=t.toolbar.length;r--;)t.toolbar[r]||t.toolbar.splice(r,1)}catch(i){t=null}return t};e.prototype.mapToolbarToToolbarGroups=function(e){function t(e,t){e=e.slice();for(var n=t.length;n--;){var r=e.indexOf(t[n]);-1!==r&&e.splice(r,1)}return e}for(var n={},r=[],i=[],r=e.length,s=0;s<r;s++)if("/"===e[s])i.push("/");else{var o=e[s].items,u={};u.name=e[s].name;u.groups=[];for(var a=o.length,f=0;f<a;f++){var l=o[f];if("-"!==l){var c=this.getToolbarGroupByButtonName(l);-1===u.groups.indexOf(c)&&u.groups.push(c);n[c]=n[c]||{};c=n[c].buttons=n[c].buttons||{};c[l]=c[l]||{used:0,origin:u.name};c[l].used++}}i.push(u)}r=function(e,n){var r=[],i;for(i in e)var s=e[i],o=n[i].slice(),r=r.concat(t(o,Object.keys(s.buttons)));return r}(n,this.fullToolbarEditor.buttonNamesByGroup);return{toolbarGroups:i,removeButtons:r.join(",")}};return e})()