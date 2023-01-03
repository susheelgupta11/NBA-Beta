<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="sbb"/>
<title>SBB</title>
</head>
<body>
  	<script>
		$(document).ready(function(){
			CKEDITOR.replace('editor1');
	
		});
	</script>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
				<div class="col-sm-12 rightdiv">
					<div class="col-sm-12">
						<div class="panel panel-default">
							<div class="panel-body message" style="margin-left: 20px;">
								<g:form controller="SBB" action="sendToNBA"
									enctype="multipart/form-data" method="POST">

									<g:render template="/applicant/communicationBox"></g:render>

									<g:actionSubmit value="Send to NBA"
										class="btn btn-primary pull-right" action="sendToNBA" />
								</g:form>
								<g:if test="${message}">
									<span style="color: green; text-shadow: orange;"><b>
											${message}
									</b></span>
								</g:if>

							</div>
						</div>
					</div>
				</div>
			</div>
     <g:render template="rightPannel"></g:render>  
  </div>
</div>
<script>
	(function(e, t, n) {
		var r = e.querySelectorAll("html")[0];
		r.className = r.className.replace(/(^|\s)no-js(\s|$)/, "$1js$2")
	})(document, window, 0);
</script> 
<script>
function openPage(pageName,elmnt,color) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i];
    }
    document.getElementById(pageName).style.display = "block";
    elmnt;
}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();

function openPage1(pageName1,elmnt,color) {
    var i, tabcontent1, tablinks;
    tabcontent1 = document.getElementsByClassName("tabcontent1");
    for (i = 0; i < tabcontent1.length; i++) {
        tabcontent1[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink1");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i];
    }
    document.getElementById(pageName1).style.display = "block";
    elmnt;
}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen1").click();
</script> 

</body>
</html>	