<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta name="layout" content="expertMember">
		
		<title>NBA</title>
	</head>
	<style>
/* only used for background overlay not needed for centering */


.shadow {
    margin-top: 50px;
    box-shadow: 0 0 30px #ccc;
    padding:0 15px 0 15px;
}
    </style>
	<body>
	
	<script>
$(document).ready(function () {
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
$( "div.failure" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>

		    
					
	 <div class="content-wrapper">
       <div class="col-sm-12 paddingleft">
      <div id="costum-lft" class="col-sm-12">
      <g:if test="${message}">
				<div class="alert-box success">${message}</div>	
					</g:if>
             <div class="col-sm-12 rightdiv" >
         
      <g:form action="saveRecommDetails" style="padding-right: 4em; margin:2em;" enctype="multipart/form-data" method="POST">
        <div class="col-md-6">
          <div class="form-group">
            <label for="sel1">Name of the Meeting</label>
            
           <g:select class="form-control"  id="meetingName" name="meetingNameReco"  from="${meetingDpDn}" noSelection="['':'Choose a Meeting']"  required="required"/>
          </div>
        </div>

      <div class="col-md-6">
          <div class="form-group">
            <label for="sel2">Number of the Meeting</label>
        
        <g:select class="form-control"  id="meetingNumber" name="meetingNumberReco" from="${recoDetails}" noSelection="['':'Select Meeting Number']"  required="required"/>
<%--           onchange="${remoteFunction(action: 'getApplicationNum',update: 'appliNumber', params: '\'meetingId=\'+this.value')}"--%>
          </div>
        </div>

      <div class="col-md-6">
        <div class="form-group">
          <label for="examplePurpose">Purpose</label><br>
          
           <g:radioGroup name="purposeReco" value="${abc ?.purpose}" 
					 labels="['Placed','Ratified']"
					values="['Placed','Ratified']">
					<label> <span class="radioSpan"> ${it.radio}
					</span> ${it.label}</label>
				</g:radioGroup>	
          

        </div>
      </div>

       <div class="col-md-6">
        <div class="row">
          <div class="col-lg-10 form-group">
            <label for="Application">Select Application</label>      
            
        <select class="form-control"  id="appliNumber" name="appNumber"   required="required" multiple> </select>         
      
          </div>
          <div class="col-lg-2 form-group">
            <label for="add"></label>
            <input type="button" class="btn btn-success pull-right" onclick="myFunction()" value="Add">
          </div>
        </div>
      </div>

          <div class="col-md-6" style="margin-top: -3.2em;">
          <div class="form-group">
            <label for="file">Upload Recommendation</label><br>
          
            <input type="file" name="recoFile" id="file-upload" style="display:block">
          </div>
          
          <div class="form-group">
          <label for="examplePurpose"></label><br>
          
           <g:radioGroup name="checkReco" value="${abc?.checkReco}" 
					 labels="['Recommendation','Not']"
					values="['Recommendation','Not']">
					<label> <span class="radioSpan"> ${it.radio}
					</span> ${it.label}</label>
				</g:radioGroup>	
          

        </div>
          <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
          <g:textField name="selectedApp" id="selectedApp" value="" style="display:none"/>
         <g:submitButton name="Submit" class="btn btn-primary" />
<%--         <g:actionSubmit class="btn btn-danger" value="Not" action="saveRecommDetails" --%>
<%--         controller="expertCommittee" onclick="return addApp()"/>--%>
        </div>
        
        <div class="col-md-6">
          <div class="form-group">
             <label>Selected Applications:</label><br>
            <span id="selectedVal"></span>
          </div>
        </div>
       </g:form>
      </div>
      </div>
      </div>
      </div>
<script>
    function myFunction(){
        var selectedValue = [];
        $.each($("#appliNumber option:selected"), function(){            
            selectedValue.push($(this).val());
        });
        
        document.getElementById("selectedVal").innerHTML = selectedValue.join("<br>");
        document.getElementById("selectedApp").value = selectedValue;
    };

    function addApp(){
    	var s1 = document.getElementById("selectedVal");
    	var s2 = document.getElementById("selectedApp");
    	s2.value = s1.innerHTML;
    	alert(s2.value);
        }
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#meetingNumber").unbind("change").bind("change", function () {
            $.ajax({
                method:'POST',
                dataType:'JSON',
                url:'${request.contextPath}/expertCommittee/getApplicationNum',
                data:{meetingId:$(this).val()},
                success:function (json) {
                    if (json['postcode_required'] == '1') {
                        $('#postcode-required').show();
                    } else {
                        $('#postcode-required').hide();
                    }

                    html = '<option value=""> --- Please Select Application--- </option>';

                    if (json != '') {
                        for (i = 0; i < json.length; i++) {
                            html += '<option value="' + json[i] + '"';

                            if (json[i]['id'] == '') {
                                html += ' selected="selected"';
                            }

                            html += '>' + json[i] + '</option>';
                        }
                    } else {
                        html += '<option value="0" selected="selected"> --- None --- </option>';
                    }

                    $('select[name=\'appNumber\']').html(html);
                }
            });
        });
    });
</script>    
       
      </body>
      </html>