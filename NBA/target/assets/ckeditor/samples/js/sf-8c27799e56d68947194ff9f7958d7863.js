var SF=function(){function e(e){return(e=e.attributes?e.attributes.getNamedItem("class"):null)?e.value.split(" "):[]}function t(e){var t=document.createAttribute("class");t.value=e.join(" ");return t}var n={attachListener:function(e,t,n){if(e.addEventListener)e.addEventListener(t,n,!1);else if(e.attachEvent)e.attachEvent("on"+t,function(){n.apply(e,arguments)});else throw Error("Could not attach event.")}};n.indexOf=function(){var e=Array.prototype.indexOf;return"function"===e?function(t,n){return e.call(t,n)}:function(e,t){for(var n=e.length,r=0;r<n;r++)if(e[r]===t)return r;return-1}}();n.accept=function(e,t){var r;e.children?(r=e.children,t(e)):"number"===typeof e.length&&(r=e);for(var i=r?r.length||0:0;i--;)n.accept(r[i],t)};n.getByClass=function(){var e=document.getElementsByClassName;return"function"===typeof e?function(t,n){"string"===typeof t&&(n=t,t=document);return e.call(t,n)}:function(e,t){"string"===typeof e&&(t=e,e=document.getElementsByTagName("html")[0]);var r=[];n.accept(e,function(e){n.classList.contains(e,t)&&r.push(e)});return r}}();n.classList={};n.classList.add=function(n,r){var i=e(n);i.push(r);n.attributes.setNamedItem(t(i))};n.classList.remove=function(r,i){var s=e(r,i),o=n.indexOf(s,i);-1!==o&&(s.splice(o,1),r.attributes.setNamedItem(t(s)))};n.classList.contains=function(t,r){return-1!==n.indexOf(e(t),r)};n.classList.toggle=function(e,t){this.contains(e,t)?this.remove(e,t):this.add(e,t)};return n}();"use strict";(function(){function e(e){for(var t in e)delete e[t]}SF.modal=function(t){function n(e){27==e.keyCode&&s.close()}t.modalClass="modal content";t.closeClass="modal-close";t.modalStyles=e;t.closeStyles=e;var r=t.afterCreate,i=t.afterClose;t.afterCreate=function(e){r&&r(e);window.addEventListener("keydown",n)};t.afterClose=function(e){i&&i(e);window.removeEventListener("keydown",n)};var s=(new picoModal(t)).afterCreate(t.afterCreate).afterClose(t.afterClose);return s}})();"use strict";(function(){for(var e=SF.getByClass("toggler"),t=e.length;t--;)SF.attachListener(e[t],"click",function(){var e=SF.classList.contains(this,"icon-toggler-expanded")||SF.classList.contains(this,"icon-toggler-collapsed"),t=document.getElementById(this.getAttribute("data-for"));SF.classList.toggle(this,"collapsed");SF.classList.contains(this,"collapsed")?(SF.classList.add(t,"collapsed"),e&&(SF.classList.remove(this,"icon-toggler-expanded"),SF.classList.add(this,"icon-toggler-collapsed"))):(SF.classList.remove(t,"collapsed"),e&&(SF.classList.remove(this,"icon-toggler-collapsed"),SF.classList.add(this,"icon-toggler-expanded")))})})();"use strict";(function(){for(var e=SF.getByClass("tree-a"),t=e.length;t--;)SF.attachListener(e[t],"click",function(e){e=e.target||e.srcElement;"H2"!==e.nodeName||SF.classList.contains(e,"tree-a-no-sub")||SF.classList.toggle(e,"tree-a-active")})})();(function(e,t){function n(e){return"object"===typeof Node?e instanceof Node:e&&"object"===typeof e&&"number"===typeof e.nodeType}function r(){var e=[];return{watch:e.push.bind(e),trigger:function(t){for(var n=!0,r={preventDefault:function(){n=!1}},i=0;i<e.length;i++)e[i](t,r);return n}}}function i(e){this.elem=e}function s(e,t){return i.div().clazz("pico-overlay").clazz(e("overlayClass","")).stylize({display:"block",position:"fixed",top:"0px",left:"0px",height:"100%",width:"100%",zIndex:1e4}).stylize(e("overlayStyles",{opacity:.5,background:"#000"})).onClick(function(){e("overlayClose",!0)&&t()})}function o(e,t){var n=e("width","auto");"number"===typeof n&&(n=""+n+"px");return i.div().clazz("pico-content").clazz(e("modalClass","")).stylize({display:"block",position:"fixed",zIndex:10001,left:"50%",top:"50px",width:n,"-ms-transform":"translateX(-50%)","-moz-transform":"translateX(-50%)","-webkit-transform":"translateX(-50%)","-o-transform":"translateX(-50%)",transform:"translateX(-50%)"}).stylize(e("modalStyles",{backgroundColor:"white",padding:"20px",borderRadius:"5px"})).html(e("content")).attr("role","dialog").onClick(function(e){(new i(e.target)).anyAncestor(function(e){return/\bpico-close\b/.test(e.elem.className)})&&t()})}function u(e){return function(){return e().elem}}function a(t){function i(e,n){var r=t[e];"function"===typeof r&&(r=r(n));return void 0===r?n:r}function a(){x().hide();S().hide();w.trigger(N)}function l(){y.trigger(N)&&a()}function c(e){return function(){e.apply(this,arguments);return N}}function h(e){if(!E){var t=o(i,l),n=s(i,l),r;r=i("closeButton",!0)?t.child().html(i("closeHtml","&#xD7;")).clazz("pico-close").clazz(i("closeClass")).stylize(i("closeStyles",{borderRadius:"2px",cursor:"pointer",height:"15px",width:"15px",position:"absolute",top:"5px",right:"5px",fontSize:"16px",textAlign:"center",lineHeight:"15px",background:"#CCC"})):void 0;E={modal:t,overlay:n,close:r};v.trigger(N)}return E[e]}if("string"===typeof t||n(t))t={content:t};var v=r(),m=r(),g=r(),y=r(),w=r(),E,S=h.bind(e,"modal"),x=h.bind(e,"overlay"),T=h.bind(e,"close"),N={modalElem:u(S),closeElem:u(T),overlayElem:u(x),show:function(){m.trigger(N)&&(x().show(),T(),S().show(),g.trigger(N));return this},close:c(l),forceClose:c(a),destroy:function(){S=S().destroy();x=x().destroy();T=void 0},options:function(e){t=e},afterCreate:c(v.watch),beforeShow:c(m.watch),afterShow:c(g.watch),beforeClose:c(y.watch),afterClose:c(w.watch)};return N}i.div=function(e){var n=t.createElement("div");(e||t.body).appendChild(n);return new i(n)};i.prototype={child:function(){return i.div(this.elem)},stylize:function(e){e=e||{};"undefined"!==typeof e.opacity&&(e.filter="alpha(opacity="+100*e.opacity+")");for(var t in e)e.hasOwnProperty(t)&&(this.elem.style[t]=e[t]);return this},clazz:function(e){this.elem.className+=" "+e;return this},html:function(e){n(e)?this.elem.appendChild(e):this.elem.innerHTML=e;return this},onClick:function(e){this.elem.addEventListener("click",e);return this},destroy:function(){t.body.removeChild(this.elem)},hide:function(){this.elem.style.display="none"},show:function(){this.elem.style.display="block"},attr:function(e,t){this.elem.setAttribute(e,t);return this},anyAncestor:function(e){for(var t=this.elem;t;){if(e(new i(t)))return!0;t=t.parentNode}return!1}};"function"===typeof e.define&&e.define.amd?e.define(function(){return a}):e.picoModal=a})(window,document)