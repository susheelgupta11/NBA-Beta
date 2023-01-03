<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='sbb' />
<title>NBA</title>
</head>
<body>
<script>
$(document).ready(function () {
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
	<div class="content-wrapper" style="margin-left: 210px;">
		<div class="col-sm-12 paddingleft">
				<div style="width: 50%; height: 30%; float: right;"> 
				<g:link  action="sbbDashboard" class="add_button add-note">cancel</g:link>
				 <g:if test="${message == null || message == ""}">
		        <g:link action="addComment" class="add_button add-note" title="Add field"
				params="${[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}">Add Comment</g:link></g:if>
				</div>
				
<%--				         <div class="pagination">--%>
<%--     <util:remotePaginate controller="dashboard" action="noting" total="${commentCount ?:0}" update="comments-list"--%>
<%--                  max="20" pageSizes="[10:'10 Per Page', 20: '20 Per Page', 50:'50 Per Page',100:'100 Per Page']"/>--%>
<%--          </div>--%>
<%--				--%>
	

		       <div style="width: 50%; height: 30%; float: left;">
		       <g:if test="${message}">
					<div class="alert-box success">${message}</div>	
					</g:if></div>
			                          
			<div id="costum-lft" class="col-sm-12">
				<div class="col-sm-12 rightdiv"
					style="padding-top: 0px; background-color: #daefda; left: 22px;">
					<div>
						<h4 class="text-center" style="margin-bottom: 0px;">
							<b>Noting</b>
						</h4>
					</div>
					<hr style="margin-top: 10px; border-top: 1px solid;" />

					<ul id="comments-list">
						<li>
							<div class="comment-main-level">
							<g:if test="${viewNoteDetails}">
								<g:each in="${viewNoteDetails}" var="noteDetail" status="i">
									<div class="comment-box">
										<div class="comment-head">
											<span>
													<h6><b>${noteDetail?.notedUser}</b></h6>
											</span> 
											<span class="pull-right" style=""> <span> 
											<g:formatDate format="dd/MM/yyyy hh:mm aa" date="${noteDetail?.noteDate}"/>
											</span>

											</span> <span class="comment-content" style="width: 100%;"> ${noteDetail?.comments?.toString().replaceAll("\\<.*?>","")}
											</span>
										</div>
									</div>
								</g:each>
								</g:if>
								<g:else>
								<div class="comment-box">
										<center><h3>The application is in initial stage</h3></center>
									</div>
								</g:else>
							</div>
						</li>
					</ul>
				</div>	
				<div class="pagination">
				<g:paginate total="${commentCount ?:0}" params="${[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"/>
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