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
<%--          <div class="col-sm-7 form-group"> <span class="col-sm-4"><b>Project Name</b></span>--%>
<%--            <div class="col-sm-8"> <span>${applicationNum}</span> </div>--%>
<%--         --%>
<%--            --%>
<%--          </div>--%>
<%--          <div class="col-sm-7 form-group"> <span class="col-sm-4"><b>Submitted Date</b></span>--%>
<%--            <div class="col-sm-8"> <span>${submittedDate}</span> </div>--%>
<%--          </div>--%>
          <g:form action="saveIprReviewDetails" controller="checklist">
          <table class="table table-bordered customtable" id="tbl_posts">
          <thead>
            <tr class="header">
              <td><b>S.No.</b></td>
              <td colspan="5" class="leftalign " ><b>Details of invention on which IPR is sought</b></td>
            </tr>
            </thead>
            <tbody id="tbl_posts_body">
                 <tr id="rec-1">
              <td style="font-weight:600;"><span class="sn">1</span></td>
              <td style="width:50%!important"><b>Title of invention</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td class="righttd" colspan="3">${formDetails?.titleOfIPR}</td>
            </tr>
           <tr id="rec-2">
			  <td><b><span class="sn">2</span></b></td>
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
              <td style="width:47.4%!important"><b>Whether IP application filed for the present invention</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td class="righttd" colspan="3">
              <g:if test="  ${formDetails?.isIPApplicationFiled == 'true'}">
              Yes
              </g:if>
            <g:else>No</g:else>
              </td>
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
                    <td><b>Patent no. &amp; date if granted</b></td>
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
                    <td>${iprDetls?.patentNo ?:'NA'}  ${iprDetls?.patentDate?.format('dd/MM/yyyy')}</td>
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
              <td style="width:47.4%!important"><b>Any other foreign patent found for the same invention</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td>
                  <g:radio name="foreignPetentChk" value="true" id="yesForeign" onclick="openTable()" />Yes 
                  <g:radio name="foreignPetentChk" value="false" id="noForeign" onclick="openRemark()"/>No         
              <td> If No, Remarks </td>
              <td colspan="2">
              <g:textField name="foreignPatentRemark" id="forePetRmk" value="${iprRemarkInstance?.foreignPatentRemark}"
              style="display: none;" class ="remark"/></td>
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
                    <td><b>Patent no. &amp; date if granted</b></td>
                    <td><b>Remarks</b></td>
                    <td><b><input type="button" onclick="cloneRow();" class="btn btn-primary" value="Add"/></b></td>
                  </tr>
                  
                  <tr id="rowToClone" class="remark">
                    <td ><input type="text" name="serialNumber" style="width:35px;"></td>
                    <td><input type="text" name="countryTerritoryName"></td>
                    <td><input type="text" name="patentApplicationNum"></td>
                    <td><input  id="datetimepicker" autocomplete="off" style="width:134px;" name="datePatent"></td>
                    <td><input type="text" style="width:72px;" name="statusPatent"></td>
                    <td><input type="text" style="width:50px;" name="patentNumAndDateIfGranted"></td>
                    <td><input type="text" style="width:70px;" name="remarksPetent"></td>
                    <td><input type="button" onclick="deleteDynamicRow(this);" id="removeRowBtn" class="btn btn-danger" value="Remove"/></td>
                  </tr>
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
              <td><g:radio name="mtcWithPatentAppChk" onclick="hidePatentMtc()" value="true" id="mtcyes"/>Yes 
              <g:radio name="mtcWithPatentAppChk" id="mtcno" onclick="showPatentMtc()" value="false"/>No</td>
              <td class=""> If No, Remarks </td>
              <td class=""><g:textField name="mtcWithPatentAppRmk" id="mtcRmk" class="remark"  value="${iprRemarkInstance?.mtcWithPatentAppRmk}" style="display:none;"/></td>
            </tr>
            <tr>
              
              <td style="font-weight:600;">7</td>
              <td style="width:50%!important"><b>Bioresource matched with patent</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td><g:radio name="bioresourceMtcChk" id="bioresMtcYes" onclick="bioMtcHide();" value="true"/>Yes
                    <g:radio name="bioresourceMtcChk" value="false" id="bioresMtcNo"  onclick="bioMtcShow();"/>No </td>
                    <td class=""> If No, Remarks </td>
              <td class=""><g:textField class="remark"  name="bioresourceMtcRmk" id="bioMtcRemk" value="${iprRemarkInstance?.bioresourceMtcRmk}" style="display:none;" /></td>
            </tr>
             <tr>
			<td><b>8</b></td>
			<td colspan="8"><b></b>
				<table class="table table-bordered">
            <tr>
                    <td style="font-weight:600;">8A</td>
              <td style="width:47.4%!important"><b>Details of commercialization</b></td>
              <td class="text-center" style="width:1px;"><b>:</b></td>
              <td><g:radio name="dtsCommercializationChk" onclick="dtsCommTable()" value="true"/>
                Applicable
                <g:radio name="dtsCommercializationChk" onclick="dtsCommShow()" value="false"/>
                N/A </td>
              <td class=""> If No, Remarks </td>
              <td class=""><g:textField name="detailsCommercialRmk" class="remark" id="dtsComzation" value="${iprRemarkInstance?.detailsCommercialRmk}" style="display:none"/></td>
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
                  <tr class ="remark">
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
              <td colspan="2"><textarea style="width:100%; display:none;" name="questionRequired"  class="remark"></textarea></td>
			  <td>
	 <a class="btn btn-primary pull-right add-record" data-added="0"><i class="glyphicon glyphicon-plus"></i> Add Questions</a>
			  </td>
			  </tr>
			   <tr style="display:none;">
        <td>
    <table id="sample_table">
      <tr id="">
       <td style="font-weight:600;"><span class="sn"></span></td>
       <td><g:textArea name="quesValues" class="ques" style="width:100%"></g:textArea> </td>
       <td><b>:</b></td>
       <td colspan="2"><g:textArea name="ansValues" class="ans" style="width:100%"></g:textArea></td>
       <td><a class="btn btn-xs delete-record" data-id="0"><span class="btn btn-danger"><i class="fa fa-trash"></i> Remove Row</span></a></td>
     </tr>
   </table>

</td>
</tr>
          </table>
          <div class="col-sm-12 form-group">
            <input type="submit" class="btn btn-primary pull-right" onclick="getCounterValue()" value="Save">
          </div>
          <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
          <g:hiddenField name="formId" value="${formDetails?.id }"/>
          <g:hiddenField name="iprInstance" value="${iprRemarkInstance?.id}"/>
          <g:hiddenField name="counterVal" id="setCounter" value="" />
          </g:form>
          
          
<%----------------- noting part start here------------------- --%>
          
          
<%--						<div class="col-sm-12 form-group">--%>
<%--							<table class="not-com" style="margin-left:10px;">--%>
<%--								<tbody>--%>
<%--									<tr>--%>
<%--				<th style="width: 100%; background-color: #3c8dbc; color: #fff;">Note/Comments</th>--%>
<%----%>
<%----%>
<%--									</tr>--%>
<%--									<tr>--%>
<%--										<td>--%>
<%----%>
<%--													<div id="editor" class="form-group">--%>
<%--													<g:textArea name="comments" id="editor1">--%>
<%--													</g:textArea>--%>
<%--													</div>--%>
<%----%>
<%--											</td>--%>
<%--										<td style="display: inline-block;">--%>
<%--											<table class="template">--%>
<%--												<tbody>--%>
<%--													<tr>--%>
<%--                        <th style="background-color: #3c8dbc; color: #fff;">Templates</th>--%>
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
<%--								   <g:hiddenField name="flag" value="1"/>--%>
<%--								   <g:hiddenField name="iprInstance" value="${iprRemarkInstance?.id}"/>--%>
<%--								<g:hiddenField name="applicationInstance" value="${formDetails?.id}" />--%>
<%--								<g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>--%>
<%--							</g:form>--%>
<%--						</div>--%>
					</div>
                   </div>
        <g:render template="/rightPane/matchdata"></g:render>
			</div>
		</div>

  
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
</script>

</body>
</html>