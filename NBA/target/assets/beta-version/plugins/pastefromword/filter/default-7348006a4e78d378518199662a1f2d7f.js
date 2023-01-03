(function(){function e(){return!1}function t(e,t){var n,r=[];e.filterChildren(t);for(n=e.children.length-1;0<=n;n--)r.unshift(e.children[n]),e.children[n].remove();n=e.attributes;var i=e,s=!0,o;for(o in n)if(s)s=!1;else{var u=new CKEDITOR.htmlParser.element(e.name);u.attributes[o]=n[o];i.add(u);i=u;delete n[o]}for(n=0;n<r.length;n++)i.add(r[n])}var n,r,i,s,o=CKEDITOR.tools,u=["o:p","xml","script","meta","link"],a="v:arc v:curve v:line v:oval v:polyline v:rect v:roundrect v:group".split(" "),f={},l=0;CKEDITOR.plugins.pastefromword={};CKEDITOR.cleanWord=function(c,h){function d(e){(e.attributes["o:gfxdata"]||"v:group"===e.parent.name)&&b.push(e.attributes.id)}var g=Boolean(c.match(/mso-list:\s*l\d+\s+level\d+\s+lfo\d+/)),b=[];CKEDITOR.plugins.clipboard.isCustomDataTypesSupported&&(c=CKEDITOR.plugins.pastefromword.styles.inliner.inline(c).getBody().getHtml());c=c.replace(/<!\[/g,"<!--[").replace(/\]>/g,"]-->");var E=CKEDITOR.htmlParser.fragment.fromHtml(c),S={root:function(e){e.filterChildren(s);CKEDITOR.plugins.pastefromword.lists.cleanup(n.createLists(e))},elementNames:[[/^\?xml:namespace$/,""],[/^v:shapetype/,""],[new RegExp(u.join("|")),""]],elements:{a:function(e){if(e.attributes.name){if("_GoBack"==e.attributes.name){delete e.name;return}if(e.attributes.name.match(/^OLE_LINK\d+$/)){delete e.name;return}}if(e.attributes.href&&e.attributes.href.match(/#.+$/)){var t=e.attributes.href.match(/#(.+)$/)[1];f[t]=e}e.attributes.name&&f[e.attributes.name]&&(e=f[e.attributes.name],e.attributes.href=e.attributes.href.replace(/.*#(.*)$/,"#$1"))},div:function(e){r.createStyleStack(e,s,h)},img:function(e){if(e.parent&&e.parent.attributes){var t=e.parent.attributes;(t=t.style||t.STYLE)&&t.match(/mso\-list:\s?Ignore/)&&(e.attributes["cke-ignored"]=!0)}r.mapStyles(e,{width:function(t){r.setStyle(e,"width",t+"px")},height:function(t){r.setStyle(e,"height",t+"px")}});e.attributes.src&&e.attributes.src.match(/^file:\/\//)&&e.attributes.alt&&e.attributes.alt.match(/^https?:\/\//)&&(e.attributes.src=e.attributes.alt);var t=e.attributes["v:shapes"]?e.attributes["v:shapes"].split(" "):[],n=CKEDITOR.tools.array.every(t,function(e){return-1<b.indexOf(e)});if(t.length&&n)return!1},p:function(e){e.filterChildren(s);if(e.attributes.style&&e.attributes.style.match(/display:\s*none/i))return!1;if(n.thisIsAListItem(h,e))i.isEdgeListItem(h,e)&&i.cleanupEdgeListItem(e),n.convertToFakeListItem(h,e),o.array.reduce(e.children,function(e,t){"p"===t.name&&(0<e&&(new CKEDITOR.htmlParser.element("br")).insertBefore(t),t.replaceWithChildren(),e+=1);return e},0);else{var t=e.getAscendant(function(e){return"ul"==e.name||"ol"==e.name}),u=o.parseCssText(e.attributes.style);t&&!t.attributes["cke-list-level"]&&u["mso-list"]&&u["mso-list"].match(/level/)&&(t.attributes["cke-list-level"]=u["mso-list"].match(/level(\d+)/)[1]);h.config.enterMode==CKEDITOR.ENTER_BR&&(delete e.name,e.add(new CKEDITOR.htmlParser.element("br")))}r.createStyleStack(e,s,h)},pre:function(e){n.thisIsAListItem(h,e)&&n.convertToFakeListItem(h,e);r.createStyleStack(e,s,h)},h1:function(e){n.thisIsAListItem(h,e)&&n.convertToFakeListItem(h,e);r.createStyleStack(e,s,h)},h2:function(e){n.thisIsAListItem(h,e)&&n.convertToFakeListItem(h,e);r.createStyleStack(e,s,h)},h3:function(e){n.thisIsAListItem(h,e)&&n.convertToFakeListItem(h,e);r.createStyleStack(e,s,h)},h4:function(e){n.thisIsAListItem(h,e)&&n.convertToFakeListItem(h,e);r.createStyleStack(e,s,h)},h5:function(e){n.thisIsAListItem(h,e)&&n.convertToFakeListItem(h,e);r.createStyleStack(e,s,h)},h6:function(e){n.thisIsAListItem(h,e)&&n.convertToFakeListItem(h,e);r.createStyleStack(e,s,h)},font:function(e){if(e.getHtml().match(/^\s*$/))return(new CKEDITOR.htmlParser.text(" ")).insertAfter(e),!1;h&&!0===h.config.pasteFromWordRemoveFontStyles&&e.attributes.size&&delete e.attributes.size;CKEDITOR.dtd.tr[e.parent.name]&&CKEDITOR.tools.arrayCompare(CKEDITOR.tools.objectKeys(e.attributes),["class","style"])?r.createStyleStack(e,s,h):t(e,s)},ul:function(e){if(g)return"li"==e.parent.name&&0===o.indexOf(e.parent.children,e)&&r.setStyle(e.parent,"list-style-type","none"),n.dissolveList(e),!1},li:function(e){i.correctLevelShift(e);g&&(e.attributes.style=r.normalizedStyles(e,h),r.pushStylesLower(e))},ol:function(e){if(g)return"li"==e.parent.name&&0===o.indexOf(e.parent.children,e)&&r.setStyle(e.parent,"list-style-type","none"),n.dissolveList(e),!1},span:function(e){e.filterChildren(s);e.attributes.style=r.normalizedStyles(e,h);if(!e.attributes.style||e.attributes.style.match(/^mso\-bookmark:OLE_LINK\d+$/)||e.getHtml().match(/^(\s|&nbsp;)+$/)){for(var t=e.children.length-1;0<=t;t--)e.children[t].insertAfter(e);return!1}e.attributes.style.match(/FONT-FAMILY:\s*Symbol/i)&&e.forEach(function(e){e.value=e.value.replace(/&nbsp;/g,"")},CKEDITOR.NODE_TEXT,!0);r.createStyleStack(e,s,h)},table:function(e){e._tdBorders={};e.filterChildren(s);var t,n=0,i;for(i in e._tdBorders)e._tdBorders[i]>n&&(n=e._tdBorders[i],t=i);r.setStyle(e,"border",t);n=(t=e.parent)&&t.parent;if(t.name&&"div"===t.name&&t.attributes.align&&1===o.objectKeys(t.attributes).length&&1===t.children.length){e.attributes.align=t.attributes.align;i=t.children.splice(0);e.remove();for(e=i.length-1;0<=e;e--)n.add(i[e],t.getIndex());t.remove()}},td:function(e){var t=e.getAscendant("table"),n=t._tdBorders,i=["border","border-top","border-right","border-bottom","border-left"],t=o.parseCssText(t.attributes.style),u=t.background||t.BACKGROUND;u&&r.setStyle(e,"background",u,!0);(t=t["background-color"]||t["BACKGROUND-COLOR"])&&r.setStyle(e,"background-color",t,!0);var t=o.parseCssText(e.attributes.style),a;for(a in t)u=t[a],delete t[a],t[a.toLowerCase()]=u;for(a=0;a<i.length;a++)t[i[a]]&&(u=t[i[a]],n[u]=n[u]?n[u]+1:1);r.createStyleStack(e,s,h,/margin|text\-align|padding|list\-style\-type|width|height|border|white\-space|vertical\-align|background/i)},"v:imagedata":e,"v:shape":function(e){var t=!1;if(null===e.getFirst("v:imagedata"))d(e);else{e.parent.find(function(n){"img"==n.name&&n.attributes&&n.attributes["v:shapes"]==e.attributes.id&&(t=!0)},!0);if(t)return!1;var n="";"v:group"===e.parent.name?d(e):(e.forEach(function(e){e.attributes&&e.attributes.src&&(n=e.attributes.src)},CKEDITOR.NODE_ELEMENT,!0),e.filterChildren(s),e.name="img",e.attributes.src=e.attributes.src||n,delete e.attributes.type)}},style:function(){return!1},object:function(e){return!(!e.attributes||!e.attributes.data)}},attributes:{style:function(e,t){return r.normalizedStyles(t,h)||!1},"class":function(e){e=e.replace(/(el\d+)|(font\d+)|msonormal|msolistparagraph\w*/ig,"");return""===e?!1:e},cellspacing:e,cellpadding:e,border:e,"v:shapes":e,"o:spid":e},comment:function(e){e.match(/\[if.* supportFields.*\]/)&&l++;"[endif]"==e&&(l=0<l?l-1:0);return!1},text:function(e,t){if(l)return"";var n=t.parent&&t.parent.parent;return n&&n.attributes&&n.attributes.style&&n.attributes.style.match(/mso-list:\s*ignore/i)?e.replace(/&nbsp;/g," "):e}};CKEDITOR.tools.array.forEach(a,function(e){S.elements[e]=d});s=new CKEDITOR.htmlParser.filter(S);var T=new CKEDITOR.htmlParser.basicWriter;s.applyTo(E);E.writeHtml(T);return T.getHtml()};CKEDITOR.plugins.pastefromword.styles={setStyle:function(e,t,n,r){var i=o.parseCssText(e.attributes.style);r&&i[t]||(""===n?delete i[t]:i[t]=n,e.attributes.style=CKEDITOR.tools.writeCssText(i))},mapStyles:function(e,t){for(var n in t)if(e.attributes[n]){if("function"===typeof t[n])t[n](e.attributes[n]);else r.setStyle(e,t[n],e.attributes[n]);delete e.attributes[n]}},normalizedStyles:function(e,t){var r="background-color:transparent border-image:none color:windowtext direction:ltr mso- text-indent visibility:visible div:border:none".split(" "),i="font-family font font-size color background-color line-height text-decoration".split(" "),s=function(){for(var e=[],t=0;t<arguments.length;t++)arguments[t]&&e.push(arguments[t]);return-1!==o.indexOf(r,e.join(":"))},u=t&&!0===t.config.pasteFromWordRemoveFontStyles,a=o.parseCssText(e.attributes.style);"cke:li"==e.name&&a["TEXT-INDENT"]&&a.MARGIN&&(e.attributes["cke-indentation"]=n.getElementIndentation(e),a.MARGIN=a.MARGIN.replace(/(([\w\.]+ ){3,3})[\d\.]+(\w+$)/,"$10$3"));for(var f=o.objectKeys(a),l=0;l<f.length;l++){var c=f[l].toLowerCase(),h=a[f[l]],p=CKEDITOR.tools.indexOf;(u&&-1!==p(i,c.toLowerCase())||s(null,c,h)||s(null,c.replace(/\-.*$/,"-"))||s(null,c)||s(e.name,c,h)||s(e.name,c.replace(/\-.*$/,"-"))||s(e.name,c)||s(h))&&delete a[f[l]]}return CKEDITOR.tools.writeCssText(a)},createStyleStack:function(e,t,n,i){var s=[];e.filterChildren(t);for(t=e.children.length-1;0<=t;t--)s.unshift(e.children[t]),e.children[t].remove();r.sortStyles(e);t=o.parseCssText(r.normalizedStyles(e,n));n=e;var u="span"===e.name,a;for(a in t)if(!a.match(i||/margin|text\-align|width|border|padding/i))if(u)u=!1;else{var f=new CKEDITOR.htmlParser.element("span");f.attributes.style=a+":"+t[a];n.add(f);n=f;delete t[a]}CKEDITOR.tools.isEmpty(t)?delete e.attributes.style:e.attributes.style=CKEDITOR.tools.writeCssText(t);for(t=0;t<s.length;t++)n.add(s[t])},sortStyles:function(e){for(var t=["border","border-bottom","font-size","background"],n=o.parseCssText(e.attributes.style),r=o.objectKeys(n),i=[],s=[],u=0;u<r.length;u++)-1!==o.indexOf(t,r[u].toLowerCase())?i.push(r[u]):s.push(r[u]);i.sort(function(e,n){var r=o.indexOf(t,e.toLowerCase()),i=o.indexOf(t,n.toLowerCase());return r-i});r=[].concat(i,s);i={};for(u=0;u<r.length;u++)i[r[u]]=n[r[u]];e.attributes.style=CKEDITOR.tools.writeCssText(i)},pushStylesLower:function(e,t,n){if(!e.attributes.style||0===e.children.length)return!1;t=t||{};var i={"list-style-type":!0,width:!0,height:!0,border:!0,"border-":!0},s=o.parseCssText(e.attributes.style),u;for(u in s)if(!(u.toLowerCase()in i||i[u.toLowerCase().replace(/\-.*$/,"-")]||u.toLowerCase()in t)){for(var a=!1,f=0;f<e.children.length;f++){var l=e.children[f];if(l.type===CKEDITOR.NODE_TEXT&&n){var c=new CKEDITOR.htmlParser.element("span");c.setHtml(l.value);l.replaceWith(c);l=c}l.type===CKEDITOR.NODE_ELEMENT&&(a=!0,r.setStyle(l,u,s[u]))}a&&delete s[u]}e.attributes.style=CKEDITOR.tools.writeCssText(s);return!0},inliner:{filtered:"break-before break-after break-inside page-break page-break-before page-break-after page-break-inside".split(" "),parse:function(e){function t(e){var t=new CKEDITOR.dom.element("style"),n=new CKEDITOR.dom.element("iframe");n.hide();CKEDITOR.document.getBody().append(n);n.$.contentDocument.documentElement.appendChild(t.$);t.$.textContent=e;n.remove();return t.$.sheet}function n(e){var t=e.indexOf("{"),n=e.indexOf("}");return r(e.substring(t+1,n),!0)}var r=CKEDITOR.tools.parseCssText,i=CKEDITOR.plugins.pastefromword.styles.inliner.filter,s=e.is?e.$.sheet:t(e);e=[];var o;if(s)for(s=s.cssRules,o=0;o<s.length;o++)s[o].type===window.CSSRule.STYLE_RULE&&e.push({selector:s[o].selectorText,styles:i(n(s[o].cssText))});return e},filter:function(e){var t=CKEDITOR.plugins.pastefromword.styles.inliner.filtered,n=o.array.indexOf,r={},i;for(i in e)-1===n(t,i)&&(r[i]=e[i]);return r},sort:function(e){return e.sort(function(e){var t=CKEDITOR.tools.array.map(e,function(e){return e.selector});return function(e,n){var r=-1!==(""+e.selector).indexOf(".")?1:0,r=(-1!==(""+n.selector).indexOf(".")?1:0)-r;return 0!==r?r:t.indexOf(n.selector)-t.indexOf(e.selector)}}(e))},inline:function(e){var t=CKEDITOR.plugins.pastefromword.styles.inliner.parse,n=CKEDITOR.plugins.pastefromword.styles.inliner.sort,r=function(e){e=(new DOMParser).parseFromString(e,"text/html");return new CKEDITOR.dom.document(e)}(e);e=r.find("style");n=n(function(e){var n=[],r;for(r=0;r<e.count();r++)n=n.concat(t(e.getItem(r)));return n}(e));CKEDITOR.tools.array.forEach(n,function(e){var t=e.styles;e=r.find(e.selector);var n,i,s;for(s=0;s<e.count();s++)n=e.getItem(s),i=CKEDITOR.tools.parseCssText(n.getAttribute("style")),i=CKEDITOR.tools.extend({},i,t),n.setAttribute("style",CKEDITOR.tools.writeCssText(i))});return r}}};r=CKEDITOR.plugins.pastefromword.styles;CKEDITOR.plugins.pastefromword.lists={thisIsAListItem:function(e,t){return i.isEdgeListItem(e,t)||t.attributes.style&&t.attributes.style.match(/mso\-list:\s?l\d/)&&"li"!==t.parent.name||t.attributes["cke-dissolved"]||t.getHtml().match(/<!\-\-\[if !supportLists]\-\->/)?!0:!1},convertToFakeListItem:function(e,t){i.isDegenerateListItem(e,t)&&i.assignListLevels(e,t);this.getListItemInfo(t);if(!t.attributes["cke-dissolved"]){var r;t.forEach(function(e){!r&&"img"==e.name&&e.attributes["cke-ignored"]&&"*"==e.attributes.alt&&(r="·",e.remove())},CKEDITOR.NODE_ELEMENT);t.forEach(function(e){r||e.value.match(/^ /)||(r=e.value)},CKEDITOR.NODE_TEXT);if("undefined"==typeof r)return;t.attributes["cke-symbol"]=r.replace(/(?: |&nbsp;).*$/,"");n.removeSymbolText(t)}if(t.attributes.style){var s=o.parseCssText(t.attributes.style);s["margin-left"]&&(delete s["margin-left"],t.attributes.style=CKEDITOR.tools.writeCssText(s))}t.name="cke:li"},convertToRealListItems:function(e){var t=[];e.forEach(function(e){"cke:li"==e.name&&(e.name="li",t.push(e))},CKEDITOR.NODE_ELEMENT,!1);return t},removeSymbolText:function(e){var t,n=e.attributes["cke-symbol"];e.forEach(function(r){!t&&-1<r.value.indexOf(n)&&(r.value=r.value.replace(n,""),r.parent.getHtml().match(/^(\s|&nbsp;)*$/)&&(t=r.parent!==e?r.parent:null))},CKEDITOR.NODE_TEXT);t&&t.remove()},setListSymbol:function(e,t,r){r=r||1;var i=o.parseCssText(e.attributes.style);if("ol"==e.name){if(e.attributes.type||i["list-style-type"])return;var s={"[ivx]":"lower-roman","[IVX]":"upper-roman","[a-z]":"lower-alpha","[A-Z]":"upper-alpha","\\d":"decimal"},u;for(u in s)if(n.getSubsectionSymbol(t).match(new RegExp(u))){i["list-style-type"]=s[u];break}e.attributes["cke-list-style-type"]=i["list-style-type"]}else s={"·":"disc",o:"circle","§":"square"},!i["list-style-type"]&&s[t]&&(i["list-style-type"]=s[t]);n.setListSymbol.removeRedundancies(i,r);(e.attributes.style=CKEDITOR.tools.writeCssText(i))||delete e.attributes.style},setListStart:function(e){for(var t=[],r=0,i=0;i<e.children.length;i++)t.push(e.children[i].attributes["cke-symbol"]||"");t[0]||r++;switch(e.attributes["cke-list-style-type"]){case"lower-roman":case"upper-roman":e.attributes.start=n.toArabic(n.getSubsectionSymbol(t[r]))-r;break;case"lower-alpha":case"upper-alpha":e.attributes.start=n.getSubsectionSymbol(t[r]).replace(/\W/g,"").toLowerCase().charCodeAt(0)-96-r;break;case"decimal":e.attributes.start=parseInt(n.getSubsectionSymbol(t[r]),10)-r||1}"1"==e.attributes.start&&delete e.attributes.start;delete e.attributes["cke-list-style-type"]},numbering:{toNumber:function(e,t){function n(e){e=e.toUpperCase();for(var t=1,n=1;0<e.length;n*=26)t+="ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(e.charAt(e.length-1))*n,e=e.substr(0,e.length-1);return t}function r(e){var t=[[1e3,"M"],[900,"CM"],[500,"D"],[400,"CD"],[100,"C"],[90,"XC"],[50,"L"],[40,"XL"],[10,"X"],[9,"IX"],[5,"V"],[4,"IV"],[1,"I"]];e=e.toUpperCase();for(var n=t.length,r=0,i=0;i<n;++i)for(var s=t[i],o=s[1].length;e.substr(0,o)==s[1];e=e.substr(o))r+=s[0];return r}return"decimal"==t?Number(e):"upper-roman"==t||"lower-roman"==t?r(e.toUpperCase()):"lower-alpha"==t||"upper-alpha"==t?n(e):1},getStyle:function(e){e=e.slice(0,1);var t={i:"lower-roman",v:"lower-roman",x:"lower-roman",l:"lower-roman",m:"lower-roman",I:"upper-roman",V:"upper-roman",X:"upper-roman",L:"upper-roman",M:"upper-roman"}[e];t||(t="decimal",e.match(/[a-z]/)&&(t="lower-alpha"),e.match(/[A-Z]/)&&(t="upper-alpha"));return t}},getSubsectionSymbol:function(e){return(e.match(/([\da-zA-Z]+).?$/)||["placeholder","1"])[1]},setListDir:function(e){var t=0,n=0;e.forEach(function(e){"li"==e.name&&("rtl"==(e.attributes.dir||e.attributes.DIR||"").toLowerCase()?n++:t++)},CKEDITOR.ELEMENT_NODE);n>t&&(e.attributes.dir="rtl")},createList:function(e){return(e.attributes["cke-symbol"].match(/([\da-np-zA-NP-Z]).?/)||[])[1]?new CKEDITOR.htmlParser.element("ol"):new CKEDITOR.htmlParser.element("ul")},createLists:function(e){var t,r,i,s=n.convertToRealListItems(e);if(0===s.length)return[];var o=n.groupLists(s);for(e=0;e<o.length;e++){var u=o[e],a=u[0];for(i=0;i<u.length;i++)if(1==u[i].attributes["cke-list-level"]){a=u[i];break}var a=[n.createList(a)],f=a[0],l=[a[0]];f.insertBefore(u[0]);for(i=0;i<u.length;i++){t=u[i];for(r=t.attributes["cke-list-level"];r>a.length;){var c=n.createList(t),h=f.children;0<h.length?h[h.length-1].add(c):(h=new CKEDITOR.htmlParser.element("li",{style:"list-style-type:none"}),h.add(c),f.add(h));a.push(c);l.push(c);f=c;r==a.length&&n.setListSymbol(c,t.attributes["cke-symbol"],r)}for(;r<a.length;)a.pop(),f=a[a.length-1],r==a.length&&n.setListSymbol(f,t.attributes["cke-symbol"],r);t.remove();f.add(t)}a[0].children.length&&(i=a[0].children[0].attributes["cke-symbol"],!i&&1<a[0].children.length&&(i=a[0].children[1].attributes["cke-symbol"]),i&&n.setListSymbol(a[0],i));for(i=0;i<l.length;i++)n.setListStart(l[i]);for(i=0;i<u.length;i++)this.determineListItemValue(u[i])}return s},cleanup:function(e){var t=["cke-list-level","cke-symbol","cke-list-id","cke-indentation","cke-dissolved"],n,r;for(n=0;n<e.length;n++)for(r=0;r<t.length;r++)delete e[n].attributes[t[r]]},determineListItemValue:function(e){if("ol"===e.parent.name){var t=this.calculateValue(e),n=e.attributes["cke-symbol"].match(/[a-z0-9]+/gi),r;n&&(n=n[n.length-1],r=e.parent.attributes["cke-list-style-type"]||this.numbering.getStyle(n),n=this.numbering.toNumber(n,r),n!==t&&(e.attributes.value=n))}},calculateValue:function(e){if(!e.parent)return 1;var t=e.parent;e=e.getIndex();var n=null,r,i,s;for(s=e;0<=s&&null===n;s--)i=t.children[s],i.attributes&&void 0!==i.attributes.value&&(r=s,n=parseInt(i.attributes.value,10));null===n&&(n=void 0!==t.attributes.start?parseInt(t.attributes.start,10):1,r=0);return n+(e-r)},dissolveList:function(e){function t(e){return 50<=e?"l"+t(e-50):40<=e?"xl"+t(e-40):10<=e?"x"+t(e-10):9==e?"ix":5<=e?"v"+t(e-5):4==e?"iv":1<=e?"i"+t(e-1):""}function n(e,t){function n(t,r){return t&&t.parent?e(t.parent)?n(t.parent,r+1):n(t.parent,r):r}return n(t,0)}var i=function(e){return function(t){return t.name==e}},s=function(e){return i("ul")(e)||i("ol")(e)},u=CKEDITOR.tools.array,a=[],f,l;e.forEach(function(e){a.push(e)},CKEDITOR.NODE_ELEMENT,!1);f=u.filter(a,i("li"));var c=u.filter(a,s);u.forEach(c,function(e){var r=e.attributes.type,a=parseInt(e.attributes.start,10)||1,f=n(s,e)+1;r||(r=o.parseCssText(e.attributes.style)["list-style-type"]);u.forEach(u.filter(e.children,i("li")),function(n,i){var s;switch(r){case"disc":s="·";break;case"circle":s="o";break;case"square":s="§";break;case"1":case"decimal":s=a+i+".";break;case"a":case"lower-alpha":s=String.fromCharCode(97+a-1+i)+".";break;case"A":case"upper-alpha":s=String.fromCharCode(65+a-1+i)+".";break;case"i":case"lower-roman":s=t(a+i)+".";break;case"I":case"upper-roman":s=t(a+i).toUpperCase()+".";break;default:s="ul"==e.name?"·":a+i+"."}n.attributes["cke-symbol"]=s;n.attributes["cke-list-level"]=f})});f=u.reduce(f,function(e,t){var n=t.children[0];if(n&&n.name&&n.attributes.style&&n.attributes.style.match(/mso-list:/i)){r.pushStylesLower(t,{"list-style-type":!0,display:!0});var i=o.parseCssText(n.attributes.style,!0);r.setStyle(t,"mso-list",i["mso-list"],!0);r.setStyle(n,"mso-list","");delete t["cke-list-level"];(n=i.display?"display":i.DISPLAY?"DISPLAY":"")&&r.setStyle(t,"display",i[n],!0)}if(1===t.children.length&&s(t.children[0]))return e;t.name="p";t.attributes["cke-dissolved"]=!0;e.push(t);return e},[]);for(l=f.length-1;0<=l;l--)f[l].insertAfter(e);for(l=c.length-1;0<=l;l--)delete c[l].name},groupLists:function(e){var t,r,i=[[e[0]]],s=i[0];r=e[0];r.attributes["cke-indentation"]=r.attributes["cke-indentation"]||n.getElementIndentation(r);for(t=1;t<e.length;t++){r=e[t];var o=e[t-1];r.attributes["cke-indentation"]=r.attributes["cke-indentation"]||n.getElementIndentation(r);r.previous!==o&&(n.chopDiscontinuousLists(s,i),i.push(s=[]));s.push(r)}n.chopDiscontinuousLists(s,i);return i},chopDiscontinuousLists:function(e,t){for(var r={},i=[[]],s,u=0;u<e.length;u++){var a=r[e[u].attributes["cke-list-level"]],f=this.getListItemInfo(e[u]),l,c;a?(c=a.type.match(/alpha/)&&7==a.index?"alpha":c,c="o"==e[u].attributes["cke-symbol"]&&14==a.index?"alpha":c,l=n.getSymbolInfo(e[u].attributes["cke-symbol"],c),f=this.getListItemInfo(e[u]),(a.type!=l.type||s&&f.id!=s.id&&!this.isAListContinuation(e[u]))&&i.push([])):l=n.getSymbolInfo(e[u].attributes["cke-symbol"]);for(s=parseInt(e[u].attributes["cke-list-level"],10)+1;20>s;s++)r[s]&&delete r[s];r[e[u].attributes["cke-list-level"]]=l;i[i.length-1].push(e[u]);s=f}[].splice.apply(t,[].concat([o.indexOf(t,e),1],i))},isAListContinuation:function(e){var t=e;do if((t=t.previous)&&t.type===CKEDITOR.NODE_ELEMENT){if(void 0===t.attributes["cke-list-level"])break;if(t.attributes["cke-list-level"]===e.attributes["cke-list-level"])return t.attributes["cke-list-id"]===e.attributes["cke-list-id"]}while(t);return!1},getElementIndentation:function(e){e=o.parseCssText(e.attributes.style);if(e.margin||e.MARGIN){e.margin=e.margin||e.MARGIN;var t={styles:{margin:e.margin}};CKEDITOR.filter.transformationsTools.splitMarginShorthand(t);e["margin-left"]=t.styles["margin-left"]}return parseInt(o.convertToPx(e["margin-left"]||"0px"),10)},toArabic:function(e){return e.match(/[ivxl]/i)?e.match(/^l/i)?50+n.toArabic(e.slice(1)):e.match(/^lx/i)?40+n.toArabic(e.slice(1)):e.match(/^x/i)?10+n.toArabic(e.slice(1)):e.match(/^ix/i)?9+n.toArabic(e.slice(2)):e.match(/^v/i)?5+n.toArabic(e.slice(1)):e.match(/^iv/i)?4+n.toArabic(e.slice(2)):e.match(/^i/i)?1+n.toArabic(e.slice(1)):n.toArabic(e.slice(1)):0},getSymbolInfo:function(e,t){var r=e.toUpperCase()==e?"upper-":"lower-",i={"·":["disc",-1],o:["circle",-2],"§":["square",-3]};if(e in i||t&&t.match(/(disc|circle|square)/))return{index:i[e][1],type:i[e][0]};if(e.match(/\d/))return{index:e?parseInt(n.getSubsectionSymbol(e),10):0,type:"decimal"};e=e.replace(/\W/g,"").toLowerCase();return!t&&e.match(/[ivxl]+/i)||t&&"alpha"!=t||"roman"==t?{index:n.toArabic(e),type:r+"roman"}:e.match(/[a-z]/i)?{index:e.charCodeAt(0)-97,type:r+"alpha"}:{index:-1,type:"disc"}},getListItemInfo:function(e){if(void 0!==e.attributes["cke-list-id"])return{id:e.attributes["cke-list-id"],level:e.attributes["cke-list-level"]};var t=o.parseCssText(e.attributes.style)["mso-list"],n={id:"0",level:"1"};t&&(t+=" ",n.level=t.match(/level(.+?)\s+/)[1],n.id=t.match(/l(\d+?)\s+/)[1]);e.attributes["cke-list-level"]=void 0!==e.attributes["cke-list-level"]?e.attributes["cke-list-level"]:n.level;e.attributes["cke-list-id"]=n.id;return n}};n=CKEDITOR.plugins.pastefromword.lists;CKEDITOR.plugins.pastefromword.images={extractFromRtf:function(e){var t=[],n=/\{\\pict[\s\S]+?\\bliptag\-?\d+(\\blipupi\-?\d+)?(\{\\\*\\blipuid\s?[\da-fA-F]+)?[\s\}]*?/,r;e=e.match(new RegExp("(?:("+n.source+"))([\\da-fA-F\\s]+)\\}","g"));if(!e)return t;for(var i=0;i<e.length;i++)if(n.test(e[i])){if(-1!==e[i].indexOf("\\pngblip"))r="image/png";else if(-1!==e[i].indexOf("\\jpegblip"))r="image/jpeg";else continue;t.push({hex:r?e[i].replace(n,"").replace(/[^\da-fA-F]/g,""):null,type:r})}return t},extractTagsFromHtml:function(e){for(var t=/<img[^>]+src="([^"]+)[^>]+/g,n=[],r;r=t.exec(e);)n.push(r[1]);return n}};CKEDITOR.plugins.pastefromword.heuristics={isEdgeListItem:function(e,t){if(!CKEDITOR.env.edge||!e.config.pasteFromWord_heuristicsEdgeList)return!1;var n="";t.forEach&&t.forEach(function(e){n+=e.value},CKEDITOR.NODE_TEXT);return n.match(/^(?: |&nbsp;)*\(?[a-zA-Z0-9]+?[\.\)](?: |&nbsp;){2,}/)?!0:i.isDegenerateListItem(e,t)},cleanupEdgeListItem:function(e){var t=!1;e.forEach(function(e){t||(e.value=e.value.replace(/^(?:&nbsp;|[\s])+/,""),e.value.length&&(t=!0))},CKEDITOR.NODE_TEXT)},isDegenerateListItem:function(e,t){return!!t.attributes["cke-list-level"]||t.attributes.style&&!t.attributes.style.match(/mso\-list/)&&!!t.find(function(e){if(e.type==CKEDITOR.NODE_ELEMENT&&t.name.match(/h\d/i)&&e.getHtml().match(/^[a-zA-Z0-9]+?[\.\)]$/))return!0;var n=o.parseCssText(e.attributes&&e.attributes.style,!0);if(!n)return!1;var r=n["font-family"]||"";return(n.font||n["font-size"]||"").match(/7pt/i)&&!!e.previous||r.match(/symbol/i)},!0).length},assignListLevels:function(e,t){if(!t.attributes||void 0===t.attributes["cke-list-level"]){for(var r=[n.getElementIndentation(t)],s=[t],o=[],u=CKEDITOR.tools.array,a=u.map;t.next&&t.next.attributes&&!t.next.attributes["cke-list-level"]&&i.isDegenerateListItem(e,t.next);)t=t.next,r.push(n.getElementIndentation(t)),s.push(t);var f=a(r,function(e,t){return 0===t?0:e-r[t-1]}),l=this.guessIndentationStep(u.filter(r,function(e){return 0!==e})),o=a(r,function(e){return Math.round(e/l)});-1!==u.indexOf(o,0)&&(o=a(o,function(e){return e+1}));u.forEach(s,function(e,t){e.attributes["cke-list-level"]=o[t]});return{indents:r,levels:o,diffs:f}}},guessIndentationStep:function(e){return e.length?Math.min.apply(null,e):null},correctLevelShift:function(e){if(this.isShifted(e)){var t=CKEDITOR.tools.array.filter(e.children,function(e){return"ul"==e.name||"ol"==e.name}),n=CKEDITOR.tools.array.reduce(t,function(e,t){return(t.children&&1==t.children.length&&i.isShifted(t.children[0])?[t]:t.children).concat(e)},[]);CKEDITOR.tools.array.forEach(t,function(e){e.remove()});CKEDITOR.tools.array.forEach(n,function(t){e.add(t)});delete e.name}},isShifted:function(e){return"li"!==e.name?!1:0===CKEDITOR.tools.array.filter(e.children,function(e){return e.name&&("ul"==e.name||"ol"==e.name||"p"==e.name&&0===e.children.length)?!1:!0}).length}};i=CKEDITOR.plugins.pastefromword.heuristics;n.setListSymbol.removeRedundancies=function(e,t){(1===t&&"disc"===e["list-style-type"]||"decimal"===e["list-style-type"])&&delete e["list-style-type"]};CKEDITOR.plugins.pastefromword.createAttributeStack=t;CKEDITOR.config.pasteFromWord_heuristicsEdgeList=!0})()