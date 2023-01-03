<%! import org.nba.communication.LetterType %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>NBA</title>
</head>
<body>
  <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
       
      </div>
      <g:if test="${letterDetails?.letterType?.ltrType == LetterType.LtrType.TR5_LETTER}">
     <g:if test="${letterDetails}">
	<g:set value="${letterDetails?.dated}" var="dated" />
</g:if>
<g:else>
	<g:set value="${new Date()}" var="dated" />
</g:else>

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
			${letterDetails?.receiptNo}
			
		</div>
		
		<div class="col-sm-6 no-padding reciep-dat">
			Date :
			<g:formatDate format="dd/MM/yyyy" date="${letterDetails?.createdDate}" />
		</div>
	</div>
	<div class="reciv-form">
		<p>
			Received from <input style="width: 60%" name="name"
				type="text" value="${letterDetails?.applicantName}">
			Application Number <input style="width: 16%" name="appNumber"
				type="text" value="${letterDetails?.appNumber}"> 
		</p>
		<p>
			With Letter No <input style="width: 30%" name="letterNo"
				value="${letterDetails?.letterNo}" type="text"> dated
			<g:datePicker name="dated" value="${letterDetails?.dated}"
				noSelection="['':'-Choose-']" precision="day" />
		</p>
		<p>
			The sum of Rupees <input style="width: 20%;  border-color: #ff0000;"
				name="sumOfRupees" onkeyup="convertMoney();"  id="number" value="${letterDetails?.sumOfRupees}"
				type="number"> & In Word <input value="${letterDetails?.moneyInWords}" type="text" id='words' name="moneyInWords" style="color: red; width: 55%;  border-color: #ff0000"></p>
				Ammount Received as:
         <g:radioGroup name="paymentFor" value="${letterDetails?.paymentFor}" 
					 labels="['Applicant Fee','Benefit Sharing']"
					values="['Applicant Fee','Benefit Sharing']">
					<label> <span class="radioSpan"> ${it.radio}
					</span> ${it.label}</label>
				</g:radioGroup>	<br>		
		
				
				Payment type <b> <g:radioGroup
					name="paymentType" value="${letterDetails?.paymentType}"
					id="pay" labels="['in Cash','by Cheque','By Bank Draft',' Wire Transfer','SBI COLLECT']"
					values="['in Cash','by Cheque','By Bank Draft',' Wire Transfer','SBI COLLECT']">
					<label> <span class="radioSpan"> ${it.radio}
					</span> ${it.label}</label>
				</g:radioGroup>
			</b>
	
		<p>
			On account of <input style="width: 91%; border-color: #ff0000;"
				name="accountOf" type="text"
				value="${letterDetails?.accountOF}">
		</p>
		<p>
			In payment of <input style="width: 91%; border-color: #ff0000;"
				name="paymentOf" type="text"
				value="${letterDetails?.paymentOf}">
		</p>
	</div>





      </g:if>
      
      <g:else>
<img src="https://absefiling.nic.in/NBA/assets/letter-head.jpg" class="img-responsivess" style="width: 100%; margin-bottom: 0.3em; display: block;" />
  <div class="row">
    <div class="col-lg-6"><p>${letterDetails?.dynamicLetterNumberNbaOUT}</p></div>
    <div class="col-lg-6"><p align="right">Date: <g:formatDate format="dd/MM/yyyy" date="${letterDetails?.sendDate}"/></p></div>
  </div>
  
  
   <p>&nbsp;</p>
   <br>To:<br>
  <g:if test="${appForm1}">

<g:if test="${appForm1.individualProfiles}">
<g:each in="${appForm1.individualProfiles}" var="indi">
<p style="line-height: 5px;"><span>${indi?.title} ${indi?.firstName} ${indi?.middleName} ${indi?.lastName} &nbsp;</span></p>
<%--<p style="line-height: 5px;"><span>Senior Technical Director, </span></p>--%>
<p style="line-height: 5px;"><span>${indi?.address1} ${indi?.address2} ${indi?.address3}</span></p>
<p style="line-height: 5px;"><span>Email:${indi?.email}</span></p>
</g:each>
</g:if>


<g:if test="${appForm1?.companyProfiles}">
<g:each in="${appForm1?.companyProfiles}" var="com">
<p style="line-height: 5px;"><span>${com?.entityName} &nbsp;</span></p>
<p style="line-height: 5px;"><span>${com?.address1} ${com?.address2} ${com?.address3}</span></p>
<p style="line-height: 5px;"><span>Email:${com?.email}</span></p>
</g:each>
</g:if>

<g:if test="${appForm1?.indianResearcher}">
<g:each in="${appForm1?.indianResearcher}" var="ir">
<p style="line-height: 5px;"><span>${ir?.title ?:''}${ir?.firstName?: ''}${ir?.middleName?:''}${ir?.lastName?:''} &nbsp;</span></p>
<p style="line-height: 5px;"><span>${ir?.designation} </span></p>
<p style="line-height: 5px;"><span>${ir?.address1} ${ir?.address2} ${ir?.address3}</span></p>
<p style="line-height: 5px;"><span>Email:${ir?.email}</span></p>
</g:each>
</g:if>

<g:if test="${appForm1?.depostionOfMicroOrganism}">
<g:each in="${appForm1?.depostionOfMicroOrganism}" var="dm">
<p style="line-height: 5px;"><span>${dm?.nameOfDepositor} &nbsp;</span></p>
<p style="line-height: 5px;"><span>${dm?.address1} ${dm?.address2} ${dm?.address3}</span></p>
<p style="line-height: 5px;"><span>Email:${dm?.email}</span></p>
</g:each>
</g:if>

<g:if test="${appForm1?.indianGovtInst}">
<g:each in="${appForm1?.indianGovtInst}" var="ig">
<p style="line-height: 5px;"><span>${ig?.govtInstName} &nbsp;</span></p>
<p style="line-height: 5px;"><span>${ig?.designation} </span></p>
<p style="line-height: 5px;"><span>${ig?.address1} ${ig?.address2} ${ig?.address3}</span></p>
<p style="line-height: 5px;"><span>Email:${ig?.email}</span></p>
</g:each>
</g:if>
</g:if>
 
<p>Dear Sir / Madam,&nbsp;</p>
<p style="margin-left: 2em;">Sub: ${letterDetails?.subject} &ndash; reg.</p>

<p>&nbsp;</p>
${raw(letterDetails?.messageBody)}<p>&nbsp;</p>
<p>&nbsp;</p>
 <p style="font-size: 10px;"><i>NBA Reference Only :</i> </p>
<table class="table table-bordered">
  <tbody>
    <tr>
      <th>Sent To:</th>
      <td>${letterDetails?.emailId}</td>
      <th>CC to:</th>
      <td>${letterDetails?.ccEmailId}</td>
    </tr>
    <tr>
      <th>Created Date:</th>
      <td><g:formatDate format="dd/MM/yyyy" date="${letterDetails?.createdDate}"/></td>
      <th>Approved Date:</th>
      <td><g:formatDate format="dd/MM/yyyy" date="${letterDetails?.approvedDate}"/></td>
    </tr>
    <tr>
      <th>Created By:</th>
      <td>${letterDetails?.createdBy}</td>
      <th>Send By:</th>
      <td>${letterDetails?.sendBy}</td>
    </tr>
  </tbody>
</table>
<%-- ${letterDetails?.messageBody?.toString().replaceAll("\\<.*?>","").replace("&nbsp;", " ")}      --%>
      
     </g:else>


				<div class="modal-footer">
        <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
      </div>
</body>
</html>