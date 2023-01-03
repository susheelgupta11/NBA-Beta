<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="sbb"/>
<title>SBB</title>
</head>
<body>
<% int j = sbbLetter.size() %>
<script>
$( document ).ready(function() {
	document.getElementById("mySelect").style.display = 'block';
	$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});

</script>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
			 <g:if test="${message}">
			 <div class="alert-box success">${message}</div>	
					    </g:if>
				<table
					class="table table-bordered customtable draft-inner col-sm-12 rightdiv">
					<tr class="header">
						<th>S.No</th>
						
						<th>Form Applied</th>
						<th>App.no</th>
						<th>Subject</th>
						<th>Letter Number</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
					
                  <g:if test="${sbbLetter || ssbConsent}">
					<g:each in="${sbbLetter}" var="commDaitls" status="i">
						<tr style="background: #fff;">
							<td>
								${i+1}
							</td>
							<td>
								${commDaitls?.applicationForm?.category?.category}
							</td>
							<td>
							${commDaitls?.applicationForm?.appNumber}	
							</td>

							<td>
							${commDaitls?.subject}	
							</td>
							<td>
								${commDaitls?.dynamicLetterNumberClientOUT}
							</td>
							<td>
							<g:formatDate format="dd/MM/yyyy" date="${commDaitls?.letterCreateDate}"/>
							
							</td>
						
							<td>
<%--<g:link action="viewCommunication" params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-file-text"></i></g:link>--%>
<%--<modalbox:modalIncludes />--%>
<%----%>
<%--<modalbox:createLink action="viewCommunication" controller="letterCommunication"  width="600" title="Letter Details" --%>
<%--params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-file-text"></i>--%>
<%--</modalbox:createLink>--%>

	            <g:remoteLink action="viewCommunication" controller="letterCommunication" title="Letter Details"
									params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"
									data-target="#success" data-toggle="modal" update="nin">
								    <i class="fa fa-file-text"></i>
				</g:remoteLink>	

							</td>
						</tr>
					</g:each>
				
<%--					<g:if test="${ssbConsent}">--%>
				<g:each in="${ssbConsent}" var="commDaitls">
						<tr style="background: #fff;">
							<td>
								<%= j+1 %>
							</td>
							<%j++ %>
							<td>
								${commDaitls?.applicationForm1?.category?.category}
							</td>
							<td>
							${commDaitls?.applicationForm1?.appNumber}	
							</td>
                          
							<td>
						   ${'Consent Reply '+commDaitls?.appNumber }
							</td>
							<td>
					   	${commDaitls?.dyOutLetterNumber}
							</td>
							<td>
							<g:formatDate format="dd/MM/yyyy" date="${commDaitls?.consentCreatedDate}"/>
							
							</td>
						
							<td>
<%--<g:link action="viewCommunication" params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-file-text"></i></g:link>--%>
<%--<modalbox:modalIncludes />--%>
<%--<modalbox:createLink action="viewCommunication" controller="letterCommunication"  width="600" title="Letter Details" --%>
<%--params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-file-text"></i>--%>
<%--</modalbox:createLink>--%>

                <g:remoteLink action="viewConsent" controller="SBB" title="Letter Details"
									params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"
									data-target="#success" data-toggle="modal" update="nin">
								    <i class="fa fa-file-text"></i>
				</g:remoteLink>	

							</td>		
				</tr>
				</g:each>	
					
<%--					</g:if>--%>
						</g:if>
					<g:else>
					<tr style="background: #fff;"><td colspan="8">No Letter is created</td> </tr>
					</g:else>
				</table>
			<div id="success" class="modal fade" role="dialog">
<div class="modal-dialog modal-lg">
   <!-- Modal content-->
<div class="modal-content" style="padding:20px;" id="nin">
  <div class="modal-body" >
</div>
 </div>
</div>
</div>	</div>
			</div>
		</div>

</body>
</html>