(function(e){if("undefined"==typeof e)throw Error("jQuery should be loaded before CKEditor jQuery adapter.");if("undefined"==typeof CKEDITOR)throw Error("CKEditor should be loaded before CKEditor jQuery adapter.");CKEDITOR.config.jqueryOverrideVal="undefined"==typeof CKEDITOR.config.jqueryOverrideVal?!0:CKEDITOR.config.jqueryOverrideVal;e.extend(e.fn,{ckeditorGet:function(){var e=this.eq(0).data("ckeditorInstance");if(!e)throw"CKEditor is not initialized yet, use ckeditor() with a callback.";return e},ckeditor:function(t,n){if(!CKEDITOR.env.isCompatible)throw Error("The environment is incompatible.");if(!e.isFunction(t)){var r=n;n=t;t=r}var i=[];n=n||{};this.each(function(){var r=e(this),s=r.data("ckeditorInstance"),o=r.data("_ckeditorInstanceLock"),u=this,f=new e.Deferred;i.push(f.promise());if(s&&!o)t&&t.apply(s,[this]),f.resolve();else if(o)s.once("instanceReady",function(){setTimeout(function(){s.element?(s.element.$==u&&t&&t.apply(s,[u]),f.resolve()):setTimeout(arguments.callee,100)},0)},null,null,9999);else{if(n.autoUpdateElement||"undefined"==typeof n.autoUpdateElement&&CKEDITOR.config.autoUpdateElement)n.autoUpdateElementJquery=!0;n.autoUpdateElement=!1;r.data("_ckeditorInstanceLock",!0);s=e(this).is("textarea")?CKEDITOR.replace(u,n):CKEDITOR.inline(u,n);r.data("ckeditorInstance",s);s.on("instanceReady",function(n){var i=n.editor;setTimeout(function(){if(i.element){n.removeListener();i.on("dataReady",function(){r.trigger("dataReady.ckeditor",[i])});i.on("setData",function(e){r.trigger("setData.ckeditor",[i,e.data])});i.on("getData",function(e){r.trigger("getData.ckeditor",[i,e.data])},999);i.on("destroy",function(){r.trigger("destroy.ckeditor",[i])});i.on("save",function(){e(u.form).submit();return!1},null,null,20);if(i.config.autoUpdateElementJquery&&r.is("textarea")&&e(u.form).length){var s=function(){r.ckeditor(function(){i.updateElement()})};e(u.form).submit(s);e(u.form).bind("form-pre-serialize",s);r.bind("destroy.ckeditor",function(){e(u.form).unbind("submit",s);e(u.form).unbind("form-pre-serialize",s)})}i.on("destroy",function(){r.removeData("ckeditorInstance")});r.removeData("_ckeditorInstanceLock");r.trigger("instanceReady.ckeditor",[i]);t&&t.apply(i,[u]);f.resolve()}else setTimeout(arguments.callee,100)},0)},null,null,9999)}});var s=new e.Deferred;this.promise=s.promise();e.when.apply(this,i).then(function(){s.resolve()});this.editor=this.eq(0).data("ckeditorInstance");return this}});CKEDITOR.config.jqueryOverrideVal&&(e.fn.val=CKEDITOR.tools.override(e.fn.val,function(t){return function(n){if(arguments.length){var r=this,i=[],s=this.each(function(){var r=e(this),s=r.data("ckeditorInstance");if(r.is("textarea")&&s){var o=new e.Deferred;s.setData(n,function(){o.resolve()});i.push(o.promise());return!0}return t.call(r,n)});if(i.length){var o=new e.Deferred;e.when.apply(this,i).done(function(){o.resolveWith(r)});return o.promise()}return s}var s=e(this).eq(0),u=s.data("ckeditorInstance");return s.is("textarea")&&u?u.getData():t.call(s)}}))})(window.jQuery)