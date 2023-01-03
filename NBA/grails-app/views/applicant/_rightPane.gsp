  <%! import org.nba.application.FormCategory %>
       <div class="col-md-3 abc1" id="sidebar" style="top:0;">
				  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Application</a></li>
    <li><a data-toggle="tab" href="#menu1">Attachment</a></li>
    
  </ul>

  <div class="tab-content">
        <div id="home" class="tab-pane fade in active table-responsive">
	<g:if
															test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
														<g:set value="previewForm1Info" var="dyaction"/>
													
												</g:if> <g:elseif
																	test="${formDetails?.category?.category == FormCategory.Category.Form_2}">
																	<g:set value="previewForm2Info" var="dyaction"/>
													
												</g:elseif> <g:elseif
																	test="${formDetails?.category?.category == FormCategory.Category.Form_3}">
																	<g:set value="previewForm3Info" var="dyaction"/>
													
												</g:elseif> <g:elseif
																	test="${formDetails?.category?.category == FormCategory.Category.Form_4}">
																	<g:set value="previewForm4Info" var="dyaction"/>
												</g:elseif> <g:elseif
																	test="${formDetails?.category?.category == FormCategory.Category.Form_B}">
																	<g:set value="previewFormBInfo" var="dyaction"/>
												</g:elseif> <g:elseif
																	test="${formDetails?.category?.category == FormCategory.Category.Form_C}">
																	<g:set value="previewFormCInfo" var="dyaction"/>											
													</g:elseif>
													
													<g:remoteLink action="${dyaction}"
																controller="FormPreview" title="View Application" id="${formDetails?.id }"
																params='[fromLogin:"true",appFormId:formDetails?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]'
																data-target="#success" data-toggle="modal" update="nin">
																View Application
															</g:remoteLink>
        </div>
        
        	<div id="success" class="modal fade" role="dialog">
<div class="modal-dialog modal-lg">
   <!-- Modal content-->
<div class="modal-content" style="padding:20px;" id="nin">

  <div class="modal-body" >
 
</div>
 </div>
</div>
</div>	
		
        <div id="menu1" class="tab-pane fade table-responsive">
		  <table class="table">
                  <thead class="thead-dark">
                    <tr>
                      <th>S.No</th>
                      <th>Date</th>
                      <th>File Name</th>
                      <th>View</th>
					 
                    </tr>
                  </thead>
                  <tbody>
                  <%int counter = 0 %>
                    <g:if test="${formDetails?.manualUploads}" >
                   <g:each var="dynamic" in="${formDetails?.manualUploads}">
   
   <g:if test="${dynamic?.fileName || dynamic?.fileUrl}">
                <tr style="background: #fff;">
										<td style="font-weight: 600;">${counter = counter+1}</td>
										
										<td style="font-weight: 600;">
										${dynamic?.date}
										
									  </td>
										<td>${dynamic?.fileName}</td>

										<td style="text-align: center !important"><g:link
													controller="manualUpload" action="manualDocShow"  target="_blank"
													params="${[dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
									</tr>
									</g:if>
									
				 <g:elseif test="${dynamic?.dyName || dynamic?.dyUrl}">
                <tr style="background: #fff;">
										<td style="font-weight: 600;">${counter = counter+1}</td>
										
										<td style="font-weight: 600;">
										${dynamic?.letterDate}
										
									  </td>
										<td>${dynamic?.dyName}</td>

										<td style="text-align: center !important"><g:link
													controller="manualUpload" action="manualDocShow"  target="_blank"
													params="${[dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
									</tr>
									</g:elseif>
                           </g:each>
                           </g:if>
                <g:else>
                <tr><td colspan="7">No Attachment found</td></tr>
                </g:else>
         
		  </tbody>
		  </table>
        </div>
      </div>
			</div>
			
		<script>
	$(document).ready(function () {
		$(".toggle-sidebar").click(function () {
			$("#sidebar").toggleClass("collapsed");
			$("#content").toggleClass("col-md-9 col-md-12");
			$("#sidebar").toggleClass("abc1 abc2");
			
			//$(".fa .fa-bars").hide();
			$(".toggle-sidebar").toggleClass(" fa fa-bars fa fa-times");
			//$(".toggle-sidebar").addClass("");
			return false;
		});
	});
</script> 	
			
			
	   