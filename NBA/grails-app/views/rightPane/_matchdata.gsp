<%! import org.nba.common.State %>
<%! import org.nba.application.FormCategory %>
 <style>
 .customtable{
	height: auto;
 }
 </style>
 <div id="mySidenav" class="sidenavs">
<div class="window" id="window">
    <div class="window-bar">
        <div>NBA Beta-v1</div>
        <span class="window-close">
            <i class="fa fa-close"></i>
       </span>
<button id="pdffulscrn" title="Expand"><i class="fa fa-expand"></i></button>
<button id="pdfexitscrn" title="Compress"><i class="fa fa-compress"></i></button>
    </div>
    <div class="window-body">
      <div id="example1"></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfobject/2.1.1/pdfobject.js"></script>
      <script>
      function show(p){
    	var file = new File(["lolo"],p);
    	var path =  (window.URL || window.webkitURL).createObjectURL(file);
           PDFObject.embed(path, "#example1");
           }

      </script>
    </div>
 </div>
        <div class="col-sm-12 right-div-menu">
            
          <div class="main-tbs">
           
                <button class="tablink active" onclick="openPage('News', this, 'green')" id="defaultOpen">Application</button>
                <button class="tablink" onclick="openPage('Contact', this, 'blue')">Attachment</button>
                <button class="tablink" onclick="openPage('kms', this, 'blue')">KMS</button>

            

            <div class="col-sm-12 leftdiv">
               <div class="fulscrnbtn">
             <button class="" id="fulcrn" style=" font-size: 1.5em; color: #3cb371;" title="Fullscreen">&#8676;</button>
                <button class="" id="exit" style=" font-size: 1.5em; color: #ff0000; display: none;" title="Exit Fullscreen">&#8677;</button>
              </div>

              <div id="News" class="tabcontent">
          <h2 class="text-center">
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
						Form I
						</g:if>
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_2}">
						Form II
						</g:if>
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_3}">
						Form III
						</g:if>
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_4}">
						Form IV
						</g:if>
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_B}">
						Form B
						</g:if>
					</h2>

					<g:if
						test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
						<center>
							<span class="text-center">(See Rule 14 of Biological
								Diversity Rules, 2004)<br /> Application form for access to the
								Biological Resources and associated traditional knowledge
							</span>
						</center>
					</g:if>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_2 }">
						<center>
							<span class="text-center"> (See Rule 17 of Biological
								Diversity Rules, 2004)<br /> Application for seeking prior
								approval of National Biodiversity Authority for transferring the
								results of research to foreign nationals,companies, NRIs for
								commercial purposes.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_3 }">
						<center>
							<span class="text-center"> (See Rule 18 of Biological
								Diversity Rules, 2004)<br /> Application form for applying for
								Intellectual Property Right.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_4 }">
						<center>
							<span class="text-center"> (See Rule 19 of Biological
								Diversity Rules, 2004)<br /> Application form for third party
								transfer of the accessed biological resources and associated
								traditional knowledge.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_B }">
						<center>
							<span class="text-center"> (See Regulation 13 of the
								Guidelines on Access to biological resources and associated
								knowledge and Benefits Sharing Regulations, 2014) <br>
								Conducting of non-commercial research or research for emergency
								purposes outside India by Indian researcher’s/ Government
								institutions
								
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_C }">
						<center>
							<span class="text-center"> (Deposition of micro-organism
								by Indian scientist / researchers in non-Indian repository for
								claim of novel species.) </span>
						</center>
					</g:elseif>

					<span class="pull-left" style="padding: 10px 0;"><b>Submitted
							On :</b> ${formDetails?.submittedOn}</span> <span class="pull-right"
						style="padding: 10px 0;"><b>Application No :</b> ${formDetails?.appNumber}</span>
					<table class="table table-bordered customtable">
						<g:if test="${formDetails?.individualProfiles}">
							<tr>
								<td colspan="3"><b>Type of Applicant </b></td>
								<td width="35px" class="text-center"><b>:</b></td>
								<td class="righttd">Individual</td>
							</tr>
							<tr class="header">
								<td></td>
								<td colspan="6" class="leftalign "><b>Full Particular
										of Applicant</b></td>
							</tr>
						</g:if>
						<g:elseif test="${formDetails?.companyProfiles}">
							<tr>
								<td colspan="3"><b>Type of Applicant </b></td>
								<td width="35px" class="text-center"><b>:</b></td>
								<td class="righttd" colspan="2">Entity</td>
							</tr>
							<tr class="header">
								<td></td>
								<td colspan="6" class="leftalign "><b>Full Particular
										of Applicant</b></td>
							</tr>

						</g:elseif>
						<g:elseif test="${formDetails?.depostionOfMicroOrganism}">

							<tr class="header">
								<td colspan="6" class="leftalign "><b>Full Particular
										of Depositor</b></td>
							</tr>
						</g:elseif>

						<g:elseif test="${formDetails?.govtInstitutes}">
							<tr class="header">
								<td colspan="6" class="leftalign "><b>Full Particulars
										of Government Institution in India</b></td>
							</tr>

						</g:elseif>

						<g:elseif test="${formDetails?.indianResearcher}">
							<tr>
								<tr class="header">
							<td colspan="6" class="leftalign "><b>Full Particular of Indian Researcher</b>
						
							</td>
						</tr>
						</g:elseif>	
						
						
						<g:if
							test="${formDetails?.category?.category == FormCategory.Category.Form_1 && allDataforMatching?.individualDetailsForMatch?.size()>0}">
							<g:render template="/rightPane/form1ForMatchingData"></g:render>
						</g:if>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_1 && allDataforMatching?.companyDetailsForMatch?.size()>0}">

							<g:render template="/rightPane/form1ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_2 && allDataforMatching?.individualDetailsForMatch?.size()>0}">
						
							<g:render template="/rightPane/form2ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_2 && allDataforMatching?.companyDetailsForMatch?.size()>0}">
							
							<g:render template="/rightPane/form2ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_3 && allDataforMatching?.individualDetailsForMatch?.size()>0}">
							
							<g:render template="/rightPane/form3ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_3 && allDataforMatching?.companyDetailsForMatch?.size()>0}">
							
							<g:render template="/rightPane/form3ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_4 && allDataforMatching?.individualDetailsForMatch?.size()>0}">
							
							<g:render template="/rightPane/form4ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_4 && allDataforMatching?.companyDetailsForMatch?.size()>0}">
							
							<g:render template="/rightPane/form4ForMatchingData"></g:render>
						</g:elseif>
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_B && allDataforMatching?.listOfIndianResearcher?.size() >0}">
							
							<g:render template="/rightPane/formBForMatchingData"></g:render>
						</g:elseif>
						
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_B && allDataforMatching?.listOfIndianGovtInst?.size() >0}">
						
							<g:render template="/rightPane/formBForMatchingData"></g:render>
						</g:elseif>
						
						<g:elseif
							test="${formDetails?.category?.category == FormCategory.Category.Form_C && allDataforMatching?.depostionOfMicroOrganism?.size()>0}">
							
							<g:render template="/rightPane/formCForMatchingData"></g:render>
						</g:elseif>
<%--						<g:render template="/rightPane/bioResourceAndLocationDetails"/>--%>
					</table>
				
			
				
              </div>
              <div id="Contact" class="tabcontent">
            <h2 class="text-center">
							<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
						Form I
						</g:if>
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_2}">
						Form II
						</g:if>
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_3}">
						Form III
						</g:if>
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_4}">
						Form IV
						</g:if>
						<g:if test="${formDetails?.category?.category == FormCategory.Category.Form_B}">
						Form B
						</g:if>
					</h2>
					
					<g:if
						test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
						<center>
							<span class="text-center">(See Rule 14 of Biological
								Diversity Rules, 2004)<br /> Application form for access to the
								Biological Resources and associated traditional knowledge
							</span>
						</center>
					</g:if>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_2 }">
						<center>
							<span class="text-center"> (See Rule 17 of Biological
								Diversity Rules, 2004)<br /> Application for seeking prior
								approval of National Biodiversity Authority for transferring the
								results of research to foreign nationals,companies, NRIs for
								commercial purposes.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_3 }">
						<center>
							<span class="text-center"> (See Rule 18 of Biological
								Diversity Rules, 2004)<br /> Application form for applying for
								Intellectual Property Right.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_4 }">
						<center>
							<span class="text-center"> (See Rule 19 of Biological
								Diversity Rules, 2004)<br /> Application form for third party
								transfer of the accessed biological resources and associated
								traditional knowledge.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_B }">
						<center>
							<span class="text-center"> (See Regulation 13 of the
								Guidelines on Access to biological resources and associated
								knowledge and Benefits Sharing Regulations, 2014) <br>
								Conducting of non-commercial research or research for emergency
								purposes outside India by Indian researcher’s/ Government
								institutions
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_C }">
						<center>
							<span class="text-center"> (Deposition of micro-organism
								by Indian scientist / researchers in non-Indian repository for
								claim of novel species.) </span>
						</center>
					</g:elseif>

					<span class="pull-left" style="padding: 10px 0;"><b>Submitted
							On :</b> ${formDetails?.submittedOn}</span> <span class="pull-right"
						style="padding: 10px 0;"><b>Application No :</b> ${formDetails?.appNumber}</span>
					<table class="table table-bordered customtable">
						<tr class="header">
							<th>S.No</th>
							<th>Date</th>
							<th>Title</th>
							<th>Show</th>
						</tr>
						<%int counter = 0 %>
						<g:if test="${allDataforMatching?.addNoteList}">
						<g:each in="${allDataforMatching?.addNoteList}" var="noteVar"
								status="i">
							<g:if test="${noteVar.pdfFiles}">
								<g:each in="${noteVar.pdfFiles}" var="pdfFle" status="j">
									<tr style="background: #fff;">
										<td style="font-weight: 600;">
											${counter = counter+1}

										</td>
										<g:if test="${pdfFle?.uploadingDate}">
										<td style="font-weight: 600;">
										
									<g:formatDate format="dd/MM/yyyy"
													date="${pdfFle?.uploadingDate}" />
													
										</td>
										</g:if>
										<g:else>
										<td style="font-weight: 600;">NA</td>
										</g:else>
										<td>${pdfFle?.fileName?:'NA'}
<%--										<g:link style="color: #000;" controller="dashboard"--%>
<%--													action="showPdf" target="_blank"--%>
<%--													params="${[showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt] }">--%>
<%--												<i style="color: #e02025; padding-right: 4px;"--%>
<%--														class="fa fa-file-pdf-o"></i>--%>
<%--												${pdfFle?.fileName?:'NA'}--%>
<%--											</g:link>--%>
											</td>
<%--   for download file downloadFile   --%>
										<td style="text-align: center !important"><g:link
													controller="dashboard" action="notingFileShow" target="_blank"
													params="${[showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
									</tr>
								</g:each>
							</g:if>
						</g:each>
						</g:if>
						
          <g:if test="${formDetails?.agendas}">
              <g:each var="dynamic" in="${formDetails?.agendas}">
   
   <g:if test="${dynamic?.agendaPdfName || dynamic?.agendaPdfUrl}">
                <tr style="background: #fff;">
										<td style="font-weight: 600;">${counter = counter+1}</td>
										
										<td style="font-weight: 600;">
										<g:formatDate format="dd-MM-yyyy" date="${dynamic?.sendDate}" />
										
									  </td>
										
										
										<td>${dynamic?.agendaPdfName}</td>

										<td style="text-align: center !important"><g:link
													controller="Agenda" action="dynamicAgendaShowPdf"  target="_blank"
													params="${[dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
									</tr>
									</g:if>
                           </g:each>
                          </g:if>				
   <%-------------------------------------------Manual Upload files-----------------------------------------------------%>
			<g:if test="${formDetails?.manualUploads}">
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
						
  <%--------------------------------------communication format pdf list-----------------------------------------------%>
   <g:if test="${formDetails?.letterCommunications}">
   <g:each var="dynamic" in="${formDetails?.letterCommunications}">
   
            <g:if test="${dynamic?.bodyPdfName || dynamic?.bodyPdfUrl}">
                   <tr style="background: #fff;">
                     <td style="font-weight: 600;">${counter = counter+1}</td>
                     <td style="font-weight: 600;">
										<g:formatDate format="dd-MM-yyyy" date="${dynamic?.approvedDate}" />
									  </td>
										<td>${dynamic?.bodyPdfName}</td>
	
	                        <td style="text-align: center !important"><g:link
													controller="letterCommunication" action="dynamicShowPdf"  target="_blank"
													params="${[dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
                 </tr>
                 </g:if>
                 </g:each>
                 </g:if>
              
                 <%-------------------------------For SBB reply section attachment------------------%>
                 <g:if test="${formDetails?.clientLetters}">
                 <g:each var="replyConsent" in="${formDetails?.clientLetters}">
   
           <g:if test="${replyConsent?.pdfFileAttachments}">
								<g:each in="${replyConsent?.pdfFileAttachments}" var="pdfFle" status="n">
									<tr style="background: #fff;">
										<td style="font-weight: 600;">
											${counter = counter+1}

										</td>
										<g:if test="${pdfFle?.attachedDate}">
										<td style="font-weight: 600;">
										
									<g:formatDate format="dd-MM-yyyy"
													date="${pdfFle?.attachedDate}" />
													
										</td>
										</g:if>
										<g:else>
										<td style="font-weight: 600;">NA</td>
										</g:else>
										<td>${pdfFle?.pdfName?:'NA'}
<%--										<g:link style="color: #000;" controller="dashboard"--%>
<%--													action="communicationShowPdf" target="_blank"--%>
<%--													params="${[showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt] }">--%>
<%--												<i style="color: #e02025; padding-right: 4px;"--%>
<%--														class="fa fa-file-pdf-o"></i>--%>
<%--												${pdfFle?.pdfName?:'NA'}--%>
<%--											</g:link>--%>
											</td>
                     <%----------------------------------		for download file communicaionDownloadFile----------------------%>

										<td style="text-align: center !important"><g:link
													controller="letterCommunication" action="communicationFileShow"  target="_blank"
													params="${[showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
									</tr>
								</g:each>
							</g:if>
                 </g:each>
                 </g:if>
                 
                 
                 
                 
                 
                 <g:if test="${allDataforMatching?.communicationList }">
						<g:each in="${allDataforMatching?.communicationList}" var="commuVar"
								status="l">
							<g:if test="${commuVar?.pdfFileAttachments}">
								<g:each in="${commuVar?.pdfFileAttachments}" var="pdfFle" status="n">
									<tr style="background: #fff;">
										<td style="font-weight: 600;">
											${counter = counter+1}

										</td>
										<g:if test="${pdfFle?.attachedDate}">
										<td style="font-weight: 600;">
										
									<g:formatDate format="dd-MM-yyyy"
													date="${pdfFle?.attachedDate}" />
													
										</td>
										</g:if>
										<g:else>
										<td style="font-weight: 600;">NA</td>
										</g:else>
										<td>${pdfFle?.pdfName?:'NA'}
<%--										<g:link style="color: #000;" controller="dashboard"--%>
<%--													action="communicationShowPdf" target="_blank"--%>
<%--													params="${[showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt] }">--%>
<%--												<i style="color: #e02025; padding-right: 4px;"--%>
<%--														class="fa fa-file-pdf-o"></i>--%>
<%--												${pdfFle?.pdfName?:'NA'}--%>
<%--											</g:link>--%>
											</td>
           <%------------------------------------------		for download file communicaionDownloadFile---------------------------%>

										<td style="text-align: center !important"><g:link
													controller="letterCommunication" action="communicationFileShow"  target="_blank"
													params="${[showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
									</tr>
								</g:each>
							</g:if>
						</g:each>
                  </g:if>
           <%-------------------------------    For periodic report attachment   ---------------------------------------------%>
                   <g:if test="${formDetails?.periodicreports}">
                   <g:each in="${formDetails?.periodicreports}" var="periodicPdf">
                     
                     <g:if test="${periodicPdf?.periodicFiles}">
                    <g:each in="${periodicPdf?.periodicFiles}" var="peri" >
                    <tr style="background: #fff;">
										<td style="font-weight: 600;">
											${counter = counter+1}

										</td>
                    <td style="font-weight: 600;"><g:formatDate format="dd-MM-yyyy" date="${peri?.fileDate}"/></td>
                    <td>${peri?.fileName}</td>
                    <td style="text-align: center !important"><g:link
													controller="Applicant" action="showPublishPdf"  target="_blank"
													params="${[publishId:peri?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
                    
                    </tr>
                    </g:each> 
                     </g:if>  
                   </g:each>
                   </g:if>
                   
        <%-- ...................................    Dynamic periodic report.......................... --%>
  <g:if test="${formDetails?.periodicreports}">
  <g:each in="${formDetails?.periodicreports}" var="dyPdf">
  <g:if test="${dyPdf?.dyFileName || dyPdf?.dyFileURL}">
     <tr style="background: #fff;">
										<td style="font-weight: 600;">
											${counter = counter+1}

										</td>
                    <td style="font-weight: 600;"><g:formatDate format="dd-MM-yyyy" date="${dyPdf?.generateDate}"/></td>
                    <td>${dyPdf?.dyFileName}</td>
                    <td style="text-align: center !important"><g:link
													controller="Applicant" action="showPeriodicDynamicPdf"  target="_blank"
													params="${[showId:dyPdf?.id,csrfPreventionSalt:csrfPreventionSalt]}">
												<i class="fa fa-clone"></i>
											</g:link></td>
                    
                    </tr>
    </g:if>
  
  </g:each>
  </g:if>

                  
				</table>
				</div>
				
				
				<div id="kms" class="tabcontent">
					<h2 class="text-center">Knowledge Management System</h2>
					<g:if
						test="${formDetails?.category?.category == FormCategory.Category.Form_1}">
						<center>
							<span class="text-center">(See Rule 14 of Biological
								Diversity Rules, 2004)<br /> Application form for access to the
								Biological Resources and associated traditional knowledge
							</span>
						</center>
					</g:if>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_2 }">
						<center>
							<span class="text-center"> (See Rule 17 of Biological
								Diversity Rules, 2004)<br /> Application for seeking prior
								approval of National Biodiversity Authority for transferring the
								results of research to foreign nationals,companies, NRIs for
								commercial purposes.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_3 }">
						<center>
							<span class="text-center"> (See Rule 18 of Biological
								Diversity Rules, 2004)<br /> Application form for applying for
								Intellectual Property Right.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_4 }">
						<center>
							<span class="text-center"> (See Rule 19 of Biological
								Diversity Rules, 2004)<br /> Application form for third party
								transfer of the accessed biological resources and associated
								traditional knowledge.
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_B }">
						<center>
							<span class="text-center"> (See Regulation 13 of the
								Guidelines on Access to biological resources and associated
								knowledge and Benefits Sharing Regulations, 2014) <br>
								Conducting of non-commercial research or research for emergency
								purposes outside India by Indian researcher’s/ Government
								institutions
							</span>
						</center>
					</g:elseif>
					<g:elseif
						test="${formDetails?.category?.category == FormCategory.Category.Form_C }">
						<center>
							<span class="text-center"> (Deposition of micro-organism
								by Indian scientist / researchers in non-Indian repository for
								claim of novel species.) </span>
						</center>
					</g:elseif>

					<span class="pull-left" style="padding: 10px 0;"><b>Submitted
							On :</b> ${formDetails?.submittedOn}</span> <span class="pull-right"
						style="padding: 10px 0;"><b>Application No :</b> ${formDetails?.appNumber}</span>
					<table class="table table-bordered customtable">
						<tr class="header">
							<th>S.No</th>
							<th>Title</th>
							<th>Download</th>
						</tr>
						<tbody>
						<g:each in="${dropDnValues?.kmsDetails }" var="kmsd" status="p">
						<tr style="background: #fff;">
						<td>${p+1}</td>
						<td>${kmsd?.fileName }</td>
						<td><g:link action="showKMS" controller="setMstrData" params="${[editId:kmsd?.id] }"><i class="fa fa-download"></i></g:link></td>
						</tr>
						</g:each>
						</tbody>	
					</table>
					
					
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="main"> <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> <span class="openbtn" style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span> </div>

<script>
	initSample();
</script> 
<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script> 
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
<script>
$( document ).ready(function() {
    $(".closebtn").hide();
});
$( document ).ready(function() {
    $(".closebtn").hide();
});
function openNav() {
	  var scroll = $(window).width();	
	
	if (scroll >= 320 && scroll <= 480) {
  document.getElementById("mySidenav").style.width = "310px";
  }
  if (scroll >= 481 && scroll <= 500) {
  document.getElementById("mySidenav").style.width = "470px";
  }
  if (scroll >= 501 && scroll <= 1199) {
  document.getElementById("mySidenav").style.width = "400px";
  }
  if (scroll >= 1200 ) {
  document.getElementById("mySidenav").style.width = "50%";
  }

    $('#mid-frame1').removeClass('col-lg-6');
    $('#mid-frame1').addClass('col-lg-12');

    $('#mid-frame2').removeClass('col-lg-6');
    $('#mid-frame2').addClass('col-lg-12');

  	$(".closebtn").show();
  	$(".openbtn").hide();
  if (scroll >= 992 && scroll <= 1199) {
  document.getElementById("costum-lft").style.width = "360px";
  }
  if (scroll >= 1200 && scroll <= 1380) {
  document.getElementById("costum-lft").style.width = "60%";
  }
  if (scroll >= 1201 && scroll <= 1400) {
  document.getElementById("costum-lft").style.width = "51.8%";
  }
  if (scroll >= 1401 && scroll <= 1600) {
  document.getElementById("costum-lft").style.width = "58%";
  }
  if (scroll >= 1601 && scroll <= 1900) {
  document.getElementById("costum-lft").style.width = "62%";
  }
  if (scroll >= 1901 ) {
  document.getElementById("costum-lft").style.width = "69%";
  }
}
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("costum-lft").style.display = "block";
	document.getElementById("costum-lft").style.width = "100%";

  $('#mid-frame1').removeClass('col-lg-12');
  $('#mid-frame1').addClass('col-lg-6');

  $('#mid-frame2').removeClass('col-lg-12');
  $('#mid-frame2').addClass('col-lg-6');

	$(".closebtn").hide();
	$(".openbtn").show();

  $("#exit").hide();
  $("#fulcrn").show();
}
</script>
<script>
    $(document).ready(function () {
    $('#fulcrn').on('click', function () {
             //document.getElementById("costum-lft").style.display = "none";
             document.getElementById("mySidenav").style.width = "100%";
             $("#fulcrn").hide();
             $("#exit").show();
    });

    $('#exit').on('click', function () {
           //document.getElementById("costum-lft").style.display = "block";
             document.getElementById("mySidenav").style.width = "50%";
             $("#exit").hide();
             $("#fulcrn").show();
    });

    $('#pdffulscrn').on('click', function () {  
           //document.getElementById("costum-lft").style.display = "none";
             document.getElementById("window").style.width = "100%";
              $("#pdffulscrn").hide();
              $("#pdfexitscrn").show();
    });

    $('#pdfexitscrn').on('click', function () {  
           //document.getElementById("costum-lft").style.display = "none";
             document.getElementById("window").style.width = "520px";
              $("#pdfexitscrn").hide();
              $("#pdffulscrn").show();
    });
   
});

</script>

                 
									
	