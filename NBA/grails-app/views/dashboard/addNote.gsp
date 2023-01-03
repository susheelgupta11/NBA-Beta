<%! import org.nba.review.AddNote %>
<%! import java.text.SimpleDateFormat%>
<%! import java.util.Date %>
<html lang="en">
<head>
<meta name='layout' content='dashPage' />
<%--<meta charset="utf-8">--%>
<%--  <meta name="robots" content="noindex, nofollow">--%>
<title>Noting</title>

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
<%--				<div class="col-sm-12 rightdiv" style="padding-top:20px;">--%>

<%--					<div style="width: 50%; height: 20%; float: left;">--%>
<%--					<div class="col-sm-7 form-group">--%>
<%--							<span class="col-sm-4"><b>Application Number</b></span>--%>
<%--							<div class="col-sm-8">--%>
<%--								<span>--%>
<%--									${applicationNum}--%>
<%--								</span>--%>
<%--							</div>--%>
<%--						</div>--%>
<%----%>
<%--						<div class="col-sm-7 form-group">--%>
<%--							<span class="col-sm-4"><b>Submitted Date</b></span>--%>
<%--							<div class="col-sm-8">--%>
<%--								<span>--%>
<%--									${reqFormat }--%>
<%--								</span>--%>
<%--							</div>--%>
<%--						</div>--%>


					<div class="col-sm-12 form-group">
						<table class="not-com" style="margin-left: 10px;" >
							<tbody>
								<tr>
									<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>
								</tr>
								<tr>
									<td>
									<div class="adjoined-bottom">
									<div class="grid-container">
									<div class="grid-width-100">
									<div id="editor" class="form-group">
										<g:textArea name="comments" id="editor1" required="required" />
													
									</div>
									</div>
									</div>
									</div>
									</td>
									
									<td style="display: inline-block;">
										<table class="template">
											<tbody>
										
												<tr>
													<th style="background-color: #3c8dbc; color: #fff;">Templates</th>
												</tr>
											</tbody>
										</table>
								<div class="main-tbs">
							<g:render template="commentBox"></g:render>				
                    </div>
				</td>
                </tr>
              </tbody>
            </table>
        
            <g:form controller="dashboard" action="saveNote"
							enctype="multipart/form-data" method="post" onsubmit="return getData()">
		 <g:hiddenField name="applicationInstance" value="${formDetails?.id}"/>
		 <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
		  <g:hiddenField name="linkOfficer" value="${linkOfficer}"/>
			<g:render template="/dashboard/addnotes"></g:render>				

              </g:form>
            </div>
          </div>
     <g:render template="/rightPane/matchdata"></g:render>  
  </div>
</div>
   
</body>
</html>	