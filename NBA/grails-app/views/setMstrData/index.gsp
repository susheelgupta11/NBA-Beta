<!DOCTYPE html>
<html lang="en">
<head>

<meta name="layout" content="superAdmin">
<title>NBA</title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="content-wrapper usess" >
    <div class="col-sm-12 table-responsive">
    
   <modalbox:modalIncludes />
   
  
   <modalbox:createLink action="create" params="[type:'draft']" title="Add Draft Value!" width="600">
   <input type="submit" value="Add" class="btn btn-primary pull-right" style="margin-bottom: 5px;"/>
</modalbox:createLink>

  <span><b>Draft List</b></span>
        <table class="table table-bordered customtable">
            <thead>
              <tr class="header">
              <th>S.No</th>
              <th style="text-align:left !important;">Title</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
            </thead>

           <g:each in="${setMstrDataInstance}" var="setMstrData" status="i">
				<g:each in="${setMstrData?.draft}" var="dftVal" status="j">
               <tbody>
					<tr>
					<td>${j+1}</td>
					<td>${dftVal}</td>
								

                          <td>
                          <modalbox:modalIncludes />
								<modalbox:createLink action="edit" params="[type:'draft',index:j]" title="Update Draft Value!" width="600">
								<i class="fa fa-edit" style="font-size: 24px;"></i>
								</modalbox:createLink>
                          
                          </td>
                          <td><g:link action="delete" params="[type:'draft',index:j,csrfPreventionSalt:csrfPreventionSalt]"><i class="fa fa-trash-o" style="font-size:24px;color:red"></i></g:link></td>
               
					</tr>
					</tbody>
				</g:each>
			</g:each>
 
          </table>
    </div>
  
  </div>
  
<%--  	<script>--%>
<%--	var countForId = ${setMstrDataInstance?.draft.size()}--%>
<%--		function saveAja() {--%>
<%--			var getval = document.getElementById("svD").value;--%>
<%--			var txtValue = getval.trim();--%>
<%----%>
<%--			var type = "draft"--%>
<%--			--%>
<%--					$.ajax({--%>
<%--						type : 'Post',--%>
<%--						dataType : 'JSON',--%>
<%--						url : '/NBA/setMstrData/save',--%>
<%--						data : {--%>
<%--							txtValue : txtValue,--%>
<%--							type : type--%>
<%--						},--%>
<%----%>
<%--						success : function(result) {--%>
<%----%>
<%--							if (result != '' || result != null) {--%>
<%--								var d = document.getElementById('res');--%>
<%--								d.innerHTML += "<input type='text'  style='margin-bottom:20px; margin-right:2px; margin-left: 6px;' value="+result.addValue+" id='txt"+countForId+"'>";--%>
<%--									--%>
<%--								d.innerHTML += "<input type='button' value='Update'class='btn btn-info btn-lg'  style='padding-right: 2px; padding-left: 2px; padding-bottom: 1px; padding-top: 1px;' id='u1"+countForId+"'>";--%>
<%--									--%>
<%--								d.innerHTML += "<input type='button' value='Delete' class='btn btn-info btn-lg' style='padding-right: 2px; padding-left: 2px; padding-bottom: 1px; padding-top: 1px; margin-left: 23px;' id='d1"+countForId+"'><br >";--%>
<%--							}--%>
<%--						}--%>
<%--					});--%>
<%--		}--%>
<%----%>
<%----%>
<%----%>
<%----%>
<%--		function updatAjx(getId) {--%>
<%--			var index = getId.substring(2);--%>
<%--			var textBxId = "txt" + index--%>
<%--			var txtValue = document.getElementById(textBxId).value;--%>
<%--			--%>
<%--			var type = "draft"--%>
<%--			$.ajax({--%>
<%--				type : 'Post',--%>
<%--				dataType : 'JSON',--%>
<%--				url : '/NBA/setMstrData/update',--%>
<%--				data : {--%>
<%--					txtValue : txtValue,--%>
<%--					type : type,--%>
<%--					index: index--%>
<%--				},--%>
<%----%>
<%--				success : function(result) {--%>
<%--					alert("Uddate Successfully with value::"+result.addValue);--%>
<%--				}--%>
<%--			});--%>
<%--		}--%>
<%----%>
<%--				--%>
<%----%>
<%--		--%>
<%--		function deleteAjx(getId){--%>
<%--			var butId = getId.substring(2);--%>
<%--			var textBxId = "txt" + butId--%>
<%--			var txtValue = document.getElementById(textBxId).value;--%>
<%--			var updButton = "u" + getId.substring(1);--%>
<%--			--%>
<%--			var type = "draft"--%>
<%----%>
<%--				$.ajax({--%>
<%--					type : 'Post',--%>
<%--					dataType : 'JSON',--%>
<%--					url : '/NBA/setMstrData/delete',--%>
<%--					data : {--%>
<%--						txtValue : txtValue,--%>
<%--						type : type,--%>
<%--						index:butId--%>
<%--					},--%>
<%----%>
<%--					success : function(result) {--%>
<%--	              --%>
<%--	                if(result != '' || result != null){--%>
<%--	                	document.getElementById(textBxId).remove();--%>
<%--	                	document.getElementById(updButton).remove();--%>
<%--	                	document.getElementById(getId).remove();--%>
<%--		                }--%>
<%--					}--%>
<%--				});--%>
<%--			}--%>
<%--		--%>
<%--	</script>--%>
  
</body>
</html>
