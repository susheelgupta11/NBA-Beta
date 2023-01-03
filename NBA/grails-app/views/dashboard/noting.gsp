<!DOCTYPE html>

<html lang="en">

<head>
<meta name='layout' content='dashPage' />
<title>NBA</title>
<style type="text/css">
.dataTables_filter{float:right;}
</style>
</head>
<body>
<script>
$(document).ready(function () {
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>
	<div class="content-wrapper">
		<div class="col-sm-12 paddingleft">
		
				<div style="width: 50%; height: 30%; float: right;"> 
				<g:link  action="dashboard" class="add_button add-note">cancel</g:link>
				
				 <g:if test="${messageNote == null || messageNote == ""}">
		        <g:link action="addNote" class="add_button add-note" title="Add field"
				params="${[instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}">Add Notes</g:link></g:if>
				</div>
	 <g:if test="${messageNote}">
		<div class="alert-box success">${messageNote}</div>	
		</g:if>			
				
			 <div id="costum-lft" class="col-sm-12">
        <div class="col-sm-12 rightdiv" style="padding-top:0px; background-color: #daefda; padding-left: 0.4em;" >
          <div>
            <h4 class="text-center" style="margin-bottom: 0px;"><b>Noting</b></h4>
          </div>
          <hr style="margin-top: 10px; border-top: 1px solid;"/>

      <table class="table" id="notingT">
            <thead style="display: none;">
            <th></th>
            <th></th>
            <th></th>
            </thead>
     <tbody>
      <g:if test="${viewNoteDetails}">
				<g:each in="${viewNoteDetails}" var="noteDetail" status="i">
      <tr>
      <th scope="row"></th>
      <td colspan="2" ><h5 class="comment-name by-author"><b>${noteDetail?.notedUser}</b></h5>
      ${noteDetail?.comments?.toString()?.replaceAll("\\<.*?>","")?.replace("&nbsp;", " ")}</td>
      <td><g:formatDate format="dd/MM/yyyy hh:mm aa" date="${noteDetail?.noteDate}"/></td>
    </tr>
    </g:each>
    </g:if>
    
         </tbody>
            </table>
				</div>	
			</div>
			 <g:render template="/rightPane/matchdata"></g:render>
			</div>
		</div>
</body>
</html>