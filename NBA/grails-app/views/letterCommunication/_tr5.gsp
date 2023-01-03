
<g:if test="${tr5ReceiptInstance}">
	<g:set value="${tr5ReceiptInstance?.dated}" var="dated" />
</g:if>
<g:else>
	<g:set value="${new Date()}" var="dated" />
</g:else>

<%--set email id--%>
<g:if test="${tr5ReceiptInstance}">
<g:set value="${tr5ReceiptInstance?.emailId}" var= "emailId"/>
</g:if>
<g:else>
<g:set value="${formDetails?.submittedBy?.email}" var="emailId"/>
</g:else>

<g:if test="${formDetails?.individualProfiles}">
	<g:each in="${formDetails?.individualProfiles}" var="individualProfile">
		<g:set var="name"
			value="${individualProfile?.title?: ''} ${individualProfile?.firstName?:'' } ${individualProfile?.middleName?:'' } ${individualProfile?.lastName?:'' }"></g:set>
	</g:each>
</g:if>
<g:elseif test="${formDetails?.companyProfiles}">
	<g:each status="k" in="${formDetails?.companyProfiles}" var="company">
		<g:set value="${company?.entityName}" var="name"></g:set>
	</g:each>
</g:elseif>
<g:elseif test="${formDetails?.indianResearcher}">
	<g:each in="${formDetails?.indianResearcher}" var="researcher">
		<g:set var="name"
			value="${researcher?.title ?:''}${researcher?.firstName?: ''}${researcher?.middleName?:''}${researcher?.lastName?:''}"></g:set>
	</g:each>
</g:elseif>
<g:elseif test="${formDetails?.depostionOfMicroOrganism}">
	<g:each in="${formDetails?.depostionOfMicroOrganism}" var="depost">
		<g:set value="${depost?.nameOfDepositor}" var="name"></g:set>
	</g:each>
</g:elseif>
<g:elseif test="${formDetails?.indianGovtInst}">
	<g:each in="${formDetails?.indianGovtInst}" var="govt">
		<g:set value="${govt?.govtInstName}" var="name"></g:set>
	</g:each>
</g:elseif>


<div class="row"
	style="border: 1px dashed #000; padding-top: 25px; padding-left: 20px">
	<div class="row ">
		<div class="col-md-6" style="width: 250px;">
			<div class="row" style="width: 300px;">
				<div class="col-md-3" style="padding-left: 32px">
					<span><b>Send To</b></span>
				</div>
				<div class="col-md-3">
					<input type="text" name="emailId"
						value="${emailId}" id="subfile"  readonly="readonly" onmouseover="showMsg();" onmouseleave="hideMsg();"/>
					
				</div>
			</div>
		</div>
		<script type="text/javascript">
function showMsg(){
	document.getElementById('showing').textContent = "can't edit this field";
}

function hideMsg(){
	document.getElementById('showing').textContent = "";
}

	


		</script>
		
		<div class="col-md-3" style="width: 30px;">
					<span style="margin-left: 50px"><b>cc</b></span>
				</div>
				<div class="col-md-3" style="margin-left: 50px;">
					<g:select name="ccEmailId" from="${ccEmailList?.email}" value="${tr5ReceiptInstance?.ccEmailId}" noSelection="['':'-Choose email for cc-']" required="required"/>
				</div>
	
	
	
<%--		<div class="col-md-6">--%>
<%--			<div class="row">--%>
				<div class="col-md-3" style="width: 30px;">
					<span><b>Subject</b></span>
				</div>
				<div class="col-md-3" style="margin-left: 50px"> 
					<input type="text" value="${tr5ReceiptInstance?.subject}"
						name="subject" style="width: 300px;" autocomplete="off"/>
				</div>
			</div>
	<span id="showing" style="color: red;"></span>
<%--		</div>--%>
<%--	</div>--%>
	<div class="receipt-head">
		<div class="col-sm-4 no-padding">
			<div class="text-left">
				<span>G.A.R. 6 [ See Rule 22(j)]</span> <span>T.R.5[ See Rule
					83]</span>
			</div>
		</div>
		<div class="col-sm-4 no-padding">
			<h2 class="text-center">E-RECEIPT</h2>
		</div>
		<div class="col-sm-4 no-padding">
			<p class="text-right" style=" margin-right: 12px;">Computer Generated</p>
		</div>
	</div>
	<div class="receipt-dates">
		
		<div class="col-sm-6 no-padding reciep-num">
			e-Receipt No :
			<g:if test="${tr5ReceiptInstance == null || tr5ReceiptInstance == ''}">
			${eReceipt}
			</g:if>
			<g:elseif test="tr5ReceiptInstance">
			${tr5ReceiptInstance?.receiptNo}
			</g:elseif>
			
		</div>
		<g:hiddenField name="date" value="${new Date()}" />
		<div class="col-sm-6 no-padding reciep-dat">
			Date :
			<g:formatDate format="dd/MM/yyyy" date="${new Date() }" />
		</div>
	</div>
	<div class="reciv-form">
		<p>
			Received from <input style="width: 60%" name="name"
				type="text" value="${name}">
			Application Number <input style="width: 16%" name="appNumber"
				type="text" value="${formDetails?.appNumber}"> 
		</p>
		<p>
			With Letter No <input style="width: 30%" name="letterNo"
				value="${tr5ReceiptInstance?.letterNo}" type="text"> dated
			<g:datePicker name="dated" value="${dated}"
				noSelection="['':'-Choose-']" precision="day" />
		</p>
		<p>
			The sum of Rupees <input style="width: 20%;  border-color: #ff0000;"
				name="sumOfRupees" onkeyup="convertMoney();"  id="number" value="${tr5ReceiptInstance?.sumOfRupees}"
				type="number"> & In Word <input value="${tr5ReceiptInstance?.moneyInWords}" type="text" id='words' name="moneyInWords" style="color: red; width: 55%;  border-color: #ff0000"></p>
				Ammount Received as:
         <g:radioGroup name="paymentFor" value="${tr5ReceiptInstance?.paymentFor}" 
					 labels="['Applicant Fee','Benefit Sharing']"
					values="['Applicant Fee','Benefit Sharing']">
					<label> <span class="radioSpan"> ${it.radio}
					</span> ${it.label}</label>
				</g:radioGroup>	<br>		
		
				
				Payment type <b> <g:radioGroup
					name="paymentType" value="${tr5ReceiptInstance?.paymentType}"
					id="pay" labels="['in Cash','by Cheque','By Bank Draft',' Wire Transfer','SBI COLLECT']"
					values="['in Cash','by Cheque','By Bank Draft',' Wire Transfer','SBI COLLECT']">
					<label> <span class="radioSpan"> ${it.radio}
					</span> ${it.label}</label>
				</g:radioGroup>
			</b>
	
		<p>
			On account of <input style="width: 91%; border-color: #ff0000;"
				name="accountOf" type="text"
				value="${tr5ReceiptInstance?.accountOF}">
		</p>
		<p>
			In payment of <input style="width: 91%; border-color: #ff0000;"
				name="paymentOf" type="text"
				value="${tr5ReceiptInstance?.paymentOf}">
		</p>
	</div>
</div>
<div class="col-sm-7 form-group" style="margin-top: 30px;">
<%--	<div class="row">--%>
<%--		<div class="col-sm-4 field_wrapper">--%>
<%--			<span><b>Upload File </b> </span>--%>
<%--		</div>--%>
<%--		<div class="col-sm-6 field_wrapper">--%>
<%--			<div class="input-append">--%>
<%--				<input type="file" name="attachments" id="subfile"--%>
<%--					class="input-xlarge" multiple /> <span><b>You can--%>
<%--						choose more than one file</b></span>--%>
<%--			</div>--%>

	<span class="col-sm-3"><b>Upload File/Files </b></span>
		<table>
			<tr>
				<td><div class="input_fields_wrap">
						<input type="button"  class="add_mor" id="chgName" Value="Click here"/>
						<span style="color: red" id="errorMsg"></span>
					</div>
<%--					<div>--%>
<%--						<input type="file" name="files[]" id="subfile"--%>
<%--							class="input-xlarge" onchange="ValidateSingleInput(this);" />--%>
<%--					</div>--%>
					</td>
			</tr>
		</table>

			<g:if test="${tr5ReceiptInstance?.pdfFileAttachments}">
				<table>
					<g:each in="${tr5ReceiptInstance?.pdfFileAttachments}"
						var="attachmentPdf">
						<tr>
							<td><g:link controller="dashboard"
									action="communicationShowPdf" target="_blank"
									params="${[showId:attachmentPdf?.id,csrfPreventionSalt:csrfPreventionSalt] }">
									${attachmentPdf?.pdfName}
								</g:link></td>
							<td><g:link action="deleteCommunicationPdf"
									params="${[deleteId:attachmentPdf?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt] }"
									onclick="return confirm('Are you sure?');">
									<i class="fa fa-trash"></i>
								</g:link></td>
						</tr>
					</g:each>
				</table>
			</g:if>
		</div>
<style>
.add_mor{
    background: #367fa9;
    color: #fff;
    padding: 4px 12px;
    display: inline-block;
    border-radius: 4px;
    border: none;
    text-align: center;
    text-decoration: none;
    font-size: 12px;
    margin: 4px 2px;
    cursor: pointer;
    }
</style>

