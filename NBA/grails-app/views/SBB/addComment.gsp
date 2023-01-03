<%! import org.nba.review.AddNote %>
<%! import java.text.SimpleDateFormat%>
<%! import java.util.Date %>
<html lang="en">
<head>
<meta name='layout' content='sbb' />
<meta charset="utf-8">
  <meta name="robots" content="noindex, nofollow">
<title>Comment</title>

</head>
<body>
<script>
$(document).ready(function () {
CKEDITOR.replace('editor1');
$( "div.failure" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
  
	<%--<% SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd") %>--%>
	<%--<%Date parseDate = formatter.parse(submittedDate) %>--%>
	<%--<%SimpleDateFormat requiredFormatter = new SimpleDateFormat("dd/MM/yyyy") %>--%>
	<%--<% def reqFmtdate = requiredFormatter.format(parseDate).toString(); %>--%>

	<g:if test="${submittedDate != '' && submittedDate != null}">
		<g:set var="sdf" value="${new SimpleDateFormat('yyyy-MM-dd')}" />
		<g:set var="sdf1" value="${new SimpleDateFormat('dd/MM/yyyy')}" />
		<g:set var="date" value="${sdf.parse(submittedDate)}" />
		<g:set var="reqFormat" value="${sdf1.format(date)}"></g:set>
	</g:if>


	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
				<div class="col-sm-12 rightdiv" style="padding-top:20px;">

					<div style="width: 50%; height: 20%; float: left;">
						<div>
							<span class="col-sm-4"><b>Project Name</b></span>
							<div class="col-sm-8">
								<span>
									${applicationNum}
								</span>
							</div>
						</div>

						<div>
							<span class="col-sm-4"><b>Submitted Date</b></span>
							<div class="col-sm-8">
								<span>
									${reqFormat }
								</span>
							</div>
						</div>
					</div>
					<div style="width: 50%; height: 20%; float: right;">
                      <g:if test="${message}">
						<div class="alert-box failure">
							${message}
						</div>
						</g:if>
					</div>

					<div class="col-sm-12 form-group">
						<table class="not-com" style="margin-left: 10px;" >
							<tbody>
								<tr>
								
									<td style="width: 100%;" class="comments"><input name=" "
										type="text" placeholder="	Note/Comments" readonly="readonly" ></td>
								</tr>
								<tr>
									<td>
<%--									<div class="adjoined-bottom">--%>
<%--											<div class="grid-container">--%>
<%--												<div class="grid-width-100">--%>
													<div id="editor" class="form-group">
													<g:textArea name="comments" id="editor1" required="required" />
													
													</div>
<%--												</div>--%>
<%--											</div>--%>
<%--										</div>--%>
 
									</td>
									
									<td style="display: inline-block;">
										<table class="template">
											<tbody>
										
												<tr>
													<td><input name=" " type="text"
														placeholder="Templates" readonly="readonly"></td>
												</tr>
											</tbody>
										</table>
								<div class="main-tbs">
							<g:render template="/dashboard/commentBox"></g:render>				
                    </div>
				</td>
                </tr>
              </tbody>
            </table>
        
            <g:form controller="SBB" action="saveComment"
							enctype="multipart/form-data" method="post" onsubmit="return getData()">
		 <g:hiddenField name="applicationInstance" value="${formDetails?.id}"/>
		 <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
			<g:render template="/dashboard/addnotes"></g:render>				

              </g:form>
            </div>
         
        </div>
     </div>
    <g:render template="/SBB/rightPannel"></g:render>  
 </div>  
</div>

	<script>
		initSample();
	</script>

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
document.getElementById("defaultOpen1").click();

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