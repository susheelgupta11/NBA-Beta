<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="layout" content="dashPage" />
<title>NBA</title>
</head>
<body>
 <g:if test="${message}">
			<script>
	      alert("${message}");
			</script>
		</g:if>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
			<div id="costum-lft" class="col-sm-12">
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
					<%int counter = 0 %>
                  <g:if test="${appLetter || ssbConsent}">
					<g:each in="${appLetter}" var="commDaitls" status="i">
						<tr style="background: #fff;">
							<td>
								${counter = counter+1}
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
								${commDaitls?.dynamicLetterNumberNbaIN}
							</td>
							<td>
							<g:formatDate format="dd/MM/yyyy" date="${commDaitls?.letterCreateDate}"/>
							
							</td>
						
							<td>
							
	<modalbox:modalIncludes />

<%--<modalbox:createLink action="viewCommunication" controller="letterCommunication"  width="600" title="Letter Details" --%>
<%--params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-file-text"></i>--%>
<%--</modalbox:createLink>--%>

  <g:remoteLink action="viewCommunication" controller="letterCommunication" title="Letter Details"
									params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"
									data-target="#success" data-toggle="modal" update="nin">
								    <i class="fa fa-file-text"></i>
				</g:remoteLink>								
							
<%--							<g:link action="viewCommunication" params="${[editId:commDaitls?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}"><i class="fa fa-file-text"></i></g:link>--%>
							</td>
						</tr>
					</g:each>
					<g:each in="${ssbConsent}" var="commDaitls">
						<tr style="background: #fff;">
							<td>
								${counter = counter+1}
							</td>
						
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
					</g:if>
					<g:else>
					<tr style="background: #fff;"><td colspan="8">No Letter is received</td> </tr>
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
</div>
			</div>
<%--			<g:render template="/rightPane/matchdata"></g:render>--%>
		</div>
	</div>
</body>
</html>