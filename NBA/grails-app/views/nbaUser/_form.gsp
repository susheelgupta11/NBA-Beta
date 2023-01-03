<%@page import="org.nba.user.NbaRole"%>
<%@ page import="org.nba.user.NbaUser"%>
<%@ page import = "java.text.SimpleDateFormat" %>

<style>
/* only used for background overlay not needed for centering */


.shadow {
    margin-top: 50px;
    box-shadow: 0 0 30px #ccc;
    padding:0 15px 0 15px;
}
</style>
			 <div>
		       <g:if test="${message}">
					<div class="alert-box failure">${message}</div>	
				</g:if>
					
			</div>
	
                 <div class="form-group " >
                                <label class="sr-only">Name</label>
                                <input type="text" class="form-control" autocomplete="off"  value="${nbaUserInstance?.name}" placeholder="Your Name" name="name">
                            </div>
							 <div class="form-group">
                                <label class="sr-only">User Name</label>
                                <input type="text" class="form-control" autocomplete="off"  placeholder="Your User Name" onblur="checkName(this)"  name="username" id="usrName"  value="${nbaUserInstance?.username}" required pattern="[0-9a-zA-Z_.-]*" required>
                            <span id="usrerror" style="color: orange"></span>
                            </div>
							 <div class="form-group">
                                <label class="sr-only">Password</label>
                                <input type="text" class="form-control" autocomplete="off"  placeholder="Password" name="password" value="${nbaUserInstance?.password}" required>
                            </div>
							 <div class="form-group">
                                <label class="sr-only">Role</label>
								<g:select id="nbaRole.id" name="nbaRole" from="${roleList}" noSelection="${['': '--Select Role--']}"
              optionValue="authority" optionKey="id" required=""
              value="${nbaUserInstance?.nbaRole?.id}" class="many-to-one form-control"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Email</label>
                                <input type="email" class="form-control" autocomplete="off"  onblur="checkName(this)" placeholder="email@example.com" name="email" value="${nbaUserInstance?.email}" required>
                           <span id="emailerror" style="color: orange"></span>
                            </div>
                             <div class="form-group">
                                <label class="sr-only">Mobile</label>
                                <input type="tel" class="form-control" autocomplete="off"  placeholder="+91-xxxxxxxxx" name="mobile" value="${nbaUserInstance?.mobile}" required>
                            </div>
							 <div class="form-group">
                                <label class="sr-only">Phone</label>
                                <input type="tel" class="form-control" autocomplete="off"  placeholder="011-xxxxxxxx" name="phone" value="${nbaUserInstance?.phone}" required>
                            </div>
                             <div class="form-group">
                                <label class="sr-only">Date of Birth</label>
                                <input  class="form-control"  id="datetimepicker" autocomplete="off"  placeholder="Your date of birth" name="dateOfBirth"  value="${nbaUserInstance?.dateOfBirth}">
                            </div>
  <asset:javascript src="beta-version/js/calander/jquery.datetimepicker.js" />
  
<script type="text/javascript">

$(document).ready(function () {

	$('#datetimepicker').datetimepicker({
        timepicker:true,
        closeOnDateSelect:false,
        closeOnTimeSelect: true,
        initTime: true,
        format: 'd-m-Y',
<%--        minDate: 0,--%>
        roundTime: 'ceil'
  });

});


 function checkName(en){
 var chkVal = en.value;
 var type, err;
  
 if(chkVal.includes("@")){
	 type = "email";
	 err = document.getElementById("emailerror");
	 }else{
		 type = "username"
		 err = document.getElementById("usrerror");
		 }
	 
  
		$.ajax({
			type : 'Post',
			dataType : 'JSON',
			url : '/NBA/nbaUser/checkUserName',

			data : {
				value : chkVal,
				type  : type
			},
			success : function(result) {
       if(result.status == false){ err.innerHTML = type+" "+"already exist"}else{err.innerHTML = ''}
      
			}
		});
	 }

</script>
                          
	


