<!DOCTYPE html>
<html>
<head>
	<meta name='layout' content='loggedInUser' />
  
  <script type="text/javascript">
  function ActiveClass(menu){
		$(".list-group-item").each(function(){
			$(this).removeClass("active");
			});
		$("."+menu).addClass("active");
	}

  $(function(){
	  ActiveClass("menu2");
	  });

  </script>
<style>
</style>
<g:javascript>
		var menu2 = "${latestUpdates }"
</g:javascript>
<script>
	$(window).load(function(){
		if(menu2){
			$("#addActiv1").addClass("active");
			$("#textColor2").addClass("textColor");
		}
		});
	
	
</script>
</head>

<body>

<script type="text/javascript">
    $(document).ready(function () {

        var totalCharacterAllowedInPage = 40;
        var totalCharacterCountInAllEditor = 0;
        CKEDITOR.replace('edit');
        CKEDITOR.replace('edit2');
        $('#edit').on('click change', function () {
            debugger
            $('#edit').ckeditor();

        })
        $('#edit2').on('click change', function () {
            debugger
            $('#edit2').ckeditor();
        })

        CKEDITOR.on('instanceReady', function (ev) {
            getCharacterCount()
            debugger
            document.getElementById(ev.editor.id + '_top').style.display = 'none';
            ev.editor.on('keyUp', function (event) {
                var deleteKey = 46;
                var backspaceKey = 8;
                var keyCode = event.data.keyCode;
                if (keyCode === backspaceKey) {
                    totalCharacterCountInAllEditor--;
                    getCharacterCount();
                    return true;
                }
                if (keyCode === deleteKey) {
                    var str = $(ev.editor.getData()).text();
                    var characterCount = str.length;

                    totalCharacterCountInAllEditor = totalCharacterCountInAllEditor - characterCount;
                    getCharacterCount();
                    return true;
                }
                else {
                    totalCharacterCountInAllEditor = 0;
                    for (var instance in CKEDITOR.instances) {
                        var editor = CKEDITOR.instances[instance]
                        editor.on('paste', function (evt) {
                            // Update the text
                            var addMore = getCharacterCount()
                            if (addMore) {
                                debugger
                                evt.editor.insertText(evt.data.dataValue);
                            } else {
                                alert('can not add more')
                                return addMore
                            }
                        }, editor.element.$);
                    }
                    return getCharacterCount()
                }
            });

            ev.editor.on('focus', function (e) {
                document.getElementById(ev.editor.id + '_top').style.display = 'block';
                getCharacterCount()
            });

        });

        function getCharacterCount() {
            var totalCharacterCount = 0
            for (var instance in CKEDITOR.instances) {
                totalCharacterCount += $(CKEDITOR.instances[instance].getData()).text().length;
            }
            debugger
            $('#charCount').text(totalCharacterCount)
            if (totalCharacterCount >= totalCharacterAllowedInPage) {
                return false;
            } else {
                return true
            }
        }
    });

</script>
<div class="container">
<g:set var="csrfPreventionSalt" value="${session.getAttribute("csrfPreventionSalt") }"/>
<div class="col-sm-2">
<g:render template="AdminLeftTab" />

</div>
<div class="col-sm-9">
<g:form controller="manageContent" action="saveLatestUpdates">
    <input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
    
    <div id="froala-editor" class="text-center">
        <p>You can edit the content of <b>Latest Update</b> from here.</p>

<%--        <p>Total characters: <label id="charCount"></label></p>--%>
    </div>

   <div id="editor" class="form-group">
        <g:textArea id='edit' autocomplete="off" name="latestUpdates" value="${latestUpdates?.latestUpdate }" style="margin-top: 30px;">

        </g:textArea>
   </div>
       <div class="col-sm-12 text-center">
    <input type="hidden" name="latestUpdatesId" value="${latestUpdates?.id}"/>
    <input type="submit" class="btn col-sm-offset-1 ButtonMargin  btn-primary ProjectInViewMode ButtonPadding"
           value="Save" name="buttonPressed" id="btnSave"/>
     <button class= "btn btn-primary link"><g:link controller="loggedInAs" action="inbox" params='[]' >Back</g:link></button>
     </div>      
</g:form>
</div>
</div>
</body>
</html>