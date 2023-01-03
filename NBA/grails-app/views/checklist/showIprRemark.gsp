<%@ page contentType="text/html;charset=UTF-8" %>
<%! import org.nba.common.Country %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="dashPage"/>
<title>IPR</title>
<style type="text/css">
.remark{color:blue}
</style>
</head>
<body>

<script>
$(document).ready(function () {
<%--CKEDITOR.replace('editor1');--%>
$( "div.success" ).fadeIn( 300 ).delay( 3000 ).fadeOut( 400 );
});
</script>

  <div class="content-wrapper">
    <div class="col-sm-12 paddingleft">
      <div id="costum-lft" class="col-sm-12">
      <g:if test="${message}">
		<div class="alert-box success">${message}</div>	
		</g:if>
        <div class="col-sm-12 rightdiv">
          <div class="col-sm-7 form-group"> <span class="col-sm-4"><b>Project Name</b></span>
            <div class="col-sm-8"> <span>${formDetails?.appNumber}</span> </div>
          </div>
          <div class="col-sm-7 form-group"> <span class="col-sm-4"><b>Submitted Date</b></span>
            <div class="col-sm-8"> <span>${formDetails?.submittedOn}</span> </div>
          </div>
          <g:form action="saveIprReviewDetails" controller="checklist">
          <table class="table table-bordered customtable" id="tbl_posts">
          <thead>
            <tr class="header">
              <td><b>S.No.</b></td>
              <td colspan="5" class="leftalign"><b>Details of invention on which IPR is sought</b></td>
            </tr>
            </thead>
            <tbody id="tbl_posts_body">
            <tr id="rec-1">
              <td style="font-weight:600;"><span class="sn">1</span></td>
              <td><b>Title of invention</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td class="righttd" colspan="3">${formDetails?.titleOfIPR}</td>
            </tr>
            <tr>
              
                    <td style="font-weight:600;">2</td>
              <td ><b>Abstract of the invention</b></td>
              <td class="text-center"><b>:</b></td>
              <td class="righttd" colspan="3">${formDetails?.abstractOfIPR}</td>
            </tr>
            <tr>
              
                    <td style="font-weight:600;">3</td>
              <td ><b>Details of territories / patent offices where the applicant intends to apply for the present invention</b></td>
              <td class="text-center"><b>:</b></td>
              <td class="righttd" colspan="3">Incorporated / Register in India</td>
            </tr>
            <tr>
			<td><b>4</b></td>
			<td colspan="8"><b></b>
				<table class="table table-bordered">
            <tr>
              <td style="font-weight:600;">4A</td>
              <td style="width:50%!important"><b>Whether IP application filed for the present invention</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td class="righttd" colspan="3"> 
              <g:if test="  ${formDetails?.isIPApplicationFiled == 'true'}">
              Yes
              </g:if>
            <g:else>No</g:else></td>
            </tr>
            <tr>
              <td><b>4B</b></td>
              <td colspan="5"><b>Patent details furnished by applicant</b>
              <table class="table table-bordered">
                  <tr>
                    <td><b>S. no</b></td>
                    <td><b>Country/Territory name</b></td>
                    <td><b>Patent Application No.</b></td>
                    <td><b>Date</b></td>
                    <td><b>Status</b></td>
                    <td><b>Patent no. & date if granted</b></td>
                    <td><b>Specify</b></td>
                    <td><b>Remarks</b></td>
                  </tr>
                  <g:if test="${formDetails?.iprDetails}">
                  <g:each in="${formDetails?.iprDetails}" var="iprDetls" status="i">
                   <tr>
                    <td>${i+1 ?:'NA'}</td>
                    <td>${Country.get(iprDetls?.country)?.country}${country}</td>
                    <td>${iprDetls?.patentApplicationNo ?:'NA'}</td>
                 <td><g:formatDate date="${iprDetls?.patentApplicationDate}" format="dd/MM/yyyy"/></td>
                    <td>${iprDetls?.status ?:'NA'}</td>
                    <td>${iprDetls?.patentNo} -  ${iprDetls?.patentDate?.format('dd/MM/yyyy')}</td>
                    <td>${iprDetls?.reasons ?:'NA'}</td>
                    <td><g:textField name="patentDtsRmk" value="${iprRemarkInstance?.patentDtsRmk}"/></td>
                  </tr>
                  </g:each>
                  </g:if>
                 
                </table></td>
            </tr>
            </table></td>
            </tr>
            <tr>
			<td><b>5</b></td>
			<td colspan="8"><b></b>
				<table class="table table-bordered">
            <tr>
                    <td style="font-weight:600;">5A</td>
              <td style="width:50%!important"><b>Any other foreign patent found for the same invention</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td>
              <g:if test="${iprRemarkInstance?.foreignPetentChk == true}">
                  <g:radio name="foreignPetentChk" value="true" checked="true" id="yesForeign" onclick="openTable()" />Yes 
                  <g:radio name="foreignPetentChk" disabled="true" disabled value="false" id="noForeign" onclick="openRemark()"/>No
              <g:javascript>
                  $(document).ready(function() {openTable();});	
              </g:javascript>
              </g:if>
                   
                  <g:if test="${iprRemarkInstance?.foreignPetentChk == false}">
                  <g:radio name="foreignPetentChk" disabled="true" disabled value="true"  id="yesForeign" onclick="openTable()" />Yes 
                  <g:radio name="foreignPetentChk" value="false" checked="true" id="noForeign" onclick="openRemark()"/>No
              <g:javascript>
                  $(document).ready(function() {openRemark();});	
              </g:javascript>
              </g:if>
                   
              <td class=""> If No, Remarks </td>
              <td><g:textField name="foreignPatentRemark" class="remark" id="forePetRmk" value="${iprRemarkInstance?.foreignPatentRemark}"
              style="display: none;"/></td>
            </tr>
            <tr>
              <td></td>
              <td colspan="5">
              <table class="table table-bordered table-responsive" id="addRow" style="display: none;">
              <tbody id="tableToModify">
                  <tr>
                    <td ><b>S. no</b></td>
                    <td><b>Country/Territory name</b></td>
                    <td><b>Patent Application No.</b></td>
                    <td><b>Date</b></td>
                    <td><b>Status</b></td>
                    <td><b>Patent no. & date if granted</b></td>
                    <td><b>Remarks</b></td>
                    <td colspan=2><b>Actions</b></td>
                  </tr>
                  <g:if test="${iprRemarkInstance?.iprForignPetents}">
                  <g:each in="${iprRemarkInstance?.iprForignPetents}" var="iprForignPetent" status="k">
                  <tr id="delt${k+1}" class="remark">
                    <td ><input type="text" id="seri${k+1}" name="serialNumber" value="${iprForignPetent?.serialNumber}" style="width:35px;"></td>
                    <td><input type="text" id="coun${k+1}" name="countryTerritoryName" value="${iprForignPetent?.countryTerritoryName}"></td>
                    <td><input type="text" id="appi${k+1}" name="patentApplicationNum" value="${iprForignPetent?.patentApplicationNum }"></td>
                    <td><input type="date" id="date${k+1}" style="width:134px;" name="datePatent" value="${iprForignPetent?.datePatent }"></td>
                    <td><input type="text" id="stat${k+1}" style="width:72px;" name="statusPatent" value="${iprForignPetent?.statusPatent }"></td>
                    <td><input type="text" id="gran${k+1}" style="width:50px;" name="patentNumAndDateIfGranted" value="${iprForignPetent?.patentNumAndDateIfGranted }"></td>
                    <td><input type="text" id="remk${k+1}" style="width:70px;" name="remarksPetent" value="${iprForignPetent?.remarksPetent }"></td>
          
                    <td>
                    <input type="button" name="${iprForignPetent?.id}" onclick="updatePetRow(this);" id="updt${k+1}" style="padding-right: 3px;padding-left: 2px;padding-top: 2px; padding-bottom: 2px;" class="btn" value="Update"/></td>
                 <td>  <input type="button" name="${iprForignPetent?.id}" onclick="deletePetentRow(this);" style="padding-right: 3px;padding-left: 2px;padding-top: 2px; padding-bottom: 2px;" id="remo${k+1}" class="btn" value="Remove"/>
                    </td>
                  </tr>
                  </g:each>
                  </g:if>
                  <g:else>
                  <tr id="rowToClone" class="remark">
                    <td ><input type="text" name="serialNumber" style="width:35px;"></td>
                    <td><input type="text" name="countryTerritoryName"></td>
                    <td><input type="text" name="patentApplicationNum"></td>
                    <td><input type="date" style="width:134px;" name="datePatent"></td>
                    <td><input type="text" style="width:72px;" name="statusPatent"></td>
                    <td><input type="text" style="width:50px;" name="patentNumAndDateIfGranted"></td>
                    <td><input type="text" style="width:70px;" name="remarksPetent"></td>
                    <td><input type="button" onclick="deleteDynamicRow(this);" id="removeRowBtn" class="btn" value="Remove"/></td>
                  </tr>
                  </g:else>
                  </tbody>
                </table>
               </td>
          </tr>
          </table></td>
          </tr>
            <tr>
             
             <td style="font-weight:600;">6</td>
              <td style="width:50%!important"><b>Application name matched with patent application</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td class="remark">
              <g:if test="${iprRemarkInstance?.mtcWithPatentAppChk == true}">
              
              <g:radio name = "mtcWithPatentAppChk" checked="true" onclick="hidePatentMtc()" value="true" id="mtcyes"/>Yes 
              <g:radio name='mtcWithPatentAppChk' disabled="true" id="mtcno" onclick="showPatentMtc()" value="false"/>No
              
              <g:javascript>
              $(document).ready(function() {hidePatentMtc();});
              </g:javascript>
              </g:if>
              
              <g:if test="${iprRemarkInstance?.mtcWithPatentAppChk == false}">
              
              <g:radio name="mtcWithPatentAppChk" disabled="true"  onclick="hidePatentMtc()" value="true" id="mtcyes" />Yes 
              <g:radio name="mtcWithPatentAppChk" checked="true" id="mtcno" onclick="showPatentMtc()" value="false"/>No
              
              <g:javascript>
              $(document).ready(function() {showPatentMtc();});
              </g:javascript>
              </g:if>
              </td>
              <td class=""> If No, Remarks </td>
              <td class="remark"><g:textField name="mtcWithPatentAppRmk" id="mtcRmk"  value="${iprRemarkInstance?.mtcWithPatentAppRmk}" style="display:none;"/></td>
            </tr>
            <tr>
              
              <td style="font-weight:600;">7</td>
              <td style="width:50%!important"><b>Bioresource matched with patent</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td>
              
              <g:if test="${iprRemarkInstance?.bioresourceMtcChk == true }">
               <g:radio name="bioresourceMtcChk" checked="true" id="bioresMtcYes" onclick="bioMtcHide();" value="true"/>Yes
               <g:radio name="bioresourceMtcChk" disabled="true" value="false" id="bioresMtcNo"  onclick="bioMtcShow();" />No
              <g:javascript>
               $(document).ready(function() {bioMtcHide();});
              </g:javascript>
              </g:if>
              
               <g:if test="${iprRemarkInstance?.bioresourceMtcChk == false }" >
               <g:radio name="bioresourceMtcChk" disabled="true" id="bioresMtcYes" onclick="bioMtcHide();" value="true" />Yes
               <g:radio name="bioresourceMtcChk" checked="true" value="false" id="bioresMtcNo"  onclick="bioMtcShow();"/>No
              <g:javascript>
               $(document).ready(function() {bioMtcShow();});
              </g:javascript>
              </g:if>
              </td>
                    <td class=""> If No, Remarks </td>
              <td class="remark"><g:textField name="bioresourceMtcRmk"  id="bioMtcRemk" value="${iprRemarkInstance?.bioresourceMtcRmk}" style="display:none;" /></td>
            </tr>
            <tr>
			<td><b>8</b></td>
			<td colspan="8"><b></b>
				<table class="table table-bordered">
            <tr>
                    <td style="font-weight:600;">8A</td>
              <td style="width:50%!important"><b>Details of commercialization</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td>
              <g:if test="${iprRemarkInstance?.dtsCommercializationChk == true}">
              <g:radio name="dtsCommercializationChk" checked="true" onclick="dtsCommTable()" value="true"/>
                Applicable
                <g:radio name="dtsCommercializationChk" disabled="true"  onclick="dtsCommShow()" value="false" />
                N/A 
                <g:javascript>
                $(document).ready(function() {dtsCommTable();});
                </g:javascript>
              </g:if>
              
               <g:if test="${iprRemarkInstance?.dtsCommercializationChk == false}">
              <g:radio name="dtsCommercializationChk" disabled="true"  onclick="dtsCommTable()" value="true"/>
                Applicable
                <g:radio name="dtsCommercializationChk" checked="true" onclick="dtsCommShow()" value="false"/>
                N/A 
                <g:javascript>
                $(document).ready(function() {dtsCommShow();});
                </g:javascript>
              </g:if>
              
              </td>
              <td class=""> If No, Remarks </td>
              <td class="remark"><g:textField name="detailsCommercialRmk" id="dtsComzation" value="${iprRemarkInstance?.detailsCommercialRmk}" style="display:none"/></td>
            </tr>
            <tr>
              <td></td>
              <td colspan="5"><table class="table table-bordered">
              <tbody id="commdtstable" style="display: none;">
                  <tr>
                    <td style="width: 235px;"><b>Country</b></td>
                    <td style="width: 235px;"><b>Financial Year</b></td>
                    <td style="width: 235px;"><b>Amount </b></td>
                    <td style="width: 235px;"><b>Remarks</b></td>
                  </tr>
                  <tr class="remark">
                    <td style="width: 235px;"><g:textField name="country" value="${iprRemarkInstance?.country}"/></td>
                    <td style="width: 235px;"><g:textField name="financialYr" value="${iprRemarkInstance?.financialYr}"/></td>
                    <td style="width: 235px;"><g:textField name="amount" value="${iprRemarkInstance?.amount}"/></td>
                    <td style="width: 235px;"><g:textField name="remarksA" value="${iprRemarkInstance?.remarksA}"/></td>
                  </tr>
                  </tbody>
                </table></td>
            </tr>
            </table></td>
            </tr>
			<tr>
			  <td style="font-weight:600;">9</td>
              <td><b>Question</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td colspan="2">
<%--             <g:textArea style="width:100%;" class="remark" value="${iprRemarkInstance?.questionRequired}" name="questionRequired"/>--%>
              </td>
		<td></td>
	
<%--	  <td><input type="button" class="btn" value="Add Question" onclick="showQuesTable()" /></td>--%>
			  </tr>
			  <g:if test="${iprRemarkInstance?.questionAnswers}">
			  <g:each in="${iprRemarkInstance?.questionAnswers}" var="quesAns" status="i">
			   <tr  id="dele${i+1}">
              <td><b><span class="sn">${i+10}</span></b></td>

              <td colspan="5"><table class="table table-bordered">
			  <tbody>
			  <tr class="remark">
			 
			  <td colspan="3" class="remark"><g:textArea name="questionIPR" id="ques${i+1}" style="width:350px;" class="form-control" value="${quesAns?.question}"></g:textArea></td>
			  <td><b>:</b></td>
			  <td colspan="2" class="remark"><g:textArea name="answerIPR" id="answ${i+1}" style="width:350px;" class="form-control" value="${quesAns?.answer}"></g:textArea></td>
			  <td><input type="button" id="updt${i+1}" name="${quesAns?.id}"  class="btn btn-success" onclick="updateDynIprQues(this)" value="Update" style="margin-top: 8%;"/></td>
			  <td><input type="button" id="remo${i+1}" name="${quesAns?.id}"  class="btn btn-danger" onclick="deleteDynIprRow(this)" value="Remove" style="margin-top: 8%;"/></td>
			  </tr>
			  </tbody>
              </table>
         
			   </g:each>
			  </g:if>
            </tbody>
          </table>
          <div class="col-sm-12 form-group">
            <input type="submit" class="btn btn-primary pull-right"   value="Update">
          <g:link  class="btn btn-primary pull-right" style="margin-right: 12px;" controller="checklist" action="iprChecklist" target="_blank" params="${[id:iprRemarkInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]}">Generate Pdf</g:link>
          
          </div>
          <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
          <g:hiddenField name="formId" value="${formDetails?.id }"/>
          <g:hiddenField name="iprInstance" value="${iprRemarkInstance?.id}"/>
          </g:form>
          
<%--						<div class="col-sm-12 form-group">--%>
<%--							<table class="not-com" style="margin-left:10px;">--%>
<%--								<tbody>--%>
<%--									<tr>--%>
<%--                      <th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%--									</tr>--%>
<%--									<tr>--%>
<%--										<td>--%>
<%--													<div id="editor" class="form-group">--%>
<%--													<g:textArea name="comments" id="editor1">--%>
<%--													</g:textArea>--%>
<%--													</div>--%>
<%--											</td>--%>
<%--										<td style="display: inline-block;">--%>
<%--											<table class="template">--%>
<%--												<tbody>--%>
<%--													<tr>--%>
<%--												 <th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
<%----%>
<%--													</tr>--%>
<%--												</tbody>--%>
<%--											</table>--%>
<%--											<div class="main-tbs">--%>
<%--												<g:render template="/dashboard/commentBox"></g:render>--%>
<%--											</div>--%>
<%--											--%>
<%--										</td>--%>
<%--									</tr>--%>
<%--								</tbody>--%>
<%--							</table>--%>
<%--							<g:form controller="checklist" action="saveIprComment"--%>
<%--								enctype="multipart/form-data" method="post"  onsubmit="return getData()">--%>
<%--								<g:render template="/dashboard/addnotes"></g:render>--%>
<%--								<g:hiddenField name="flag" value="2"/>--%>
<%--								<g:hiddenField name="iprInstance" value="${iprRemarkInstance?.id}"/>--%>
<%--								<g:hiddenField name="applicationInstance" value="${formDetails?.id}" />--%>
<%--								<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>--%>
<%--								--%>
<%--							</g:form>--%>
<%--						</div>--%>
					</div>
                   </div>
        <g:render template="/rightPane/matchdata"></g:render>
			</div>
		</div>
</body>
</html>