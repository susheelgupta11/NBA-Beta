CKEDITOR.dialog.add("radio",function(e){return{title:e.lang.forms.checkboxAndRadio.radioTitle,minWidth:350,minHeight:140,onShow:function(){delete this.radioButton;var e=this.getParentEditor().getSelection().getSelectedElement();e&&"input"==e.getName()&&"radio"==e.getAttribute("type")&&(this.radioButton=e,this.setupContent(e))},onOk:function(){var e,t=this.radioButton,n=!t;n&&(e=this.getParentEditor(),t=e.document.createElement("input"),t.setAttribute("type","radio"));n&&e.insertElement(t);this.commitContent({element:t})},contents:[{id:"info",label:e.lang.forms.checkboxAndRadio.radioTitle,title:e.lang.forms.checkboxAndRadio.radioTitle,elements:[{id:"name",type:"text",label:e.lang.common.name,"default":"",accessKey:"N",setup:function(e){this.setValue(e.data("cke-saved-name")||e.getAttribute("name")||"")},commit:function(e){e=e.element;this.getValue()?e.data("cke-saved-name",this.getValue()):(e.data("cke-saved-name",!1),e.removeAttribute("name"))}},{id:"value",type:"text",label:e.lang.forms.checkboxAndRadio.value,"default":"",accessKey:"V",setup:function(e){this.setValue(e.getAttribute("value")||"")},commit:function(e){e=e.element;this.getValue()?e.setAttribute("value",this.getValue()):e.removeAttribute("value")}},{id:"checked",type:"checkbox",label:e.lang.forms.checkboxAndRadio.selected,"default":"",accessKey:"S",value:"checked",setup:function(e){this.setValue(e.getAttribute("checked"))},commit:function(t){var n=t.element;if(CKEDITOR.env.ie){var r=n.getAttribute("checked"),i=!!this.getValue();r!=i&&(r=CKEDITOR.dom.element.createFromHtml('<input type="radio"'+(i?' checked="checked"':"")+"></input>",e.document),n.copyAttributes(r,{type:1,checked:1}),r.replace(n),e.getSelection().selectElement(r),t.element=r)}else this.getValue()?n.setAttribute("checked","checked"):n.removeAttribute("checked")}},{id:"required",type:"checkbox",label:e.lang.forms.checkboxAndRadio.required,"default":"",accessKey:"Q",value:"required",setup:function(e){this.setValue(e.getAttribute("required"))},commit:function(e){e=e.element;this.getValue()?e.setAttribute("required","required"):e.removeAttribute("required")}}]}]}})