<!DOCTYPE html>
<html>
<head>
<meta name='layout' content='loggedInUser' />

<script type="text/javascript">
$(function(){
	ActiveClass("menu1");		`
});

</script>

<style>
body {
	text-align: center;
}

div#editor {
	margin: auto;
	text-align: left;
}

.active {
	background-color: #337ab7;
}
 .textColor {
 	color: #ffffff;
 }
</style>
<g:javascript>
		var menu1 = "${aboutNBA }"
</g:javascript>
<script>
	$(window).load(function(){
		if(menu1){
			$("#addActiv").addClass("active");
			$("#textColor1").addClass("textColor");
		}
		});
	
	
</script>
<script>
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

<%--    function addActive(){--%>
<%--		$('#addActiv').addClass("active");--%>
<%--	}--%>

	

</script>
</head>

<body>  
<div class="container">
<g:set var="csrfPreventionSalt" value="${session.getAttribute("csrfPreventionSalt") }"/>
	
	<div class="col-sm-2">
		<g:render template="AdminLeftTab" />
		
		

	</div>
	<div class="col-sm-9">
		<g:form controller="manageContent" action="saveAdminEdits">
			
			<div id="froala-editor" >
				<p>
					You can edit the <b>About NBA</b> content of login page from here
				</p>

				<%--        <p>Total characters: <label id="charCount"></label></p>--%>
			</div>

			<div id="editor" class="form-group">
				<g:textArea id='edit' autocomplete="off" name="aboutUs"
					value="${aboutNBA?.aboutNBA }" style="margin-top: 30px;">
				</g:textArea>
			</div>
			<input type="hidden" name="aboutNbaId" value="${aboutNBA?.id}" />
			  <input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
			<input type="submit"
				class="btn col-sm-offset-1 ButtonMargin  btn-primary ProjectInViewMode ButtonPadding"
				value="Save" name="buttonPressed" id="btnSave" />
				
			<button class="btn btn-primary link">
				<g:link controller="loggedInAs" action="inbox" params='[]'>Back</g:link>
			</button>
		</g:form>
	</div>
	</div>
</body>
</html>