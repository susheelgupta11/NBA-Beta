<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%--<!DOCTYPE entities [--%>
<%--   <!ENTITY hyphen "&#x02010;">--%>
<%--   <!ENTITY copy "&#x000A9;">--%>
<%--   <!ENTITY nbsp "&#x000A0;">--%>
<%--   <!ENTITY ndash "&#x02013;">--%>
<%--   <!ENTITY auml "&#x000E4;">--%>
<%--   <!ENTITY uuml "&#x000FC;">--%>
<%--   <!ENTITY deg "&#x000B0;">--%>
<%--   <!ENTITY Delta "&#x00394;">--%>
<%--   <!ENTITY minus "&#x02212;">--%>
<%--   <!ENTITY ensp "&#x02002;">--%>
<%--   <!ENTITY szlig "&#223;">--%>
<%--]>--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <title>Letter Head</title>
<%--    <link rel="stylesheet" href="letter.css" />--%>
    <!-- Latest compiled and minified CSS -->
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>--%>

<!-- Optional theme -->
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"/>--%>

<!-- Latest compiled and minified JavaScript -->
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>

<asset:stylesheet src="beta-version/css/bootstrap.min.css"/>
<asset:javascript src="beta-version/js/datatable/bootstrap.min.js"/>
  </head>
 <body>
<div class="container">
  <div class="book">
    <div class="page">
        <div class="subpage">
        
<a href="https://absefiling.nic.in/NBA/login/auth" target="_blank">
<img src="https://absefiling.nic.in/NBA/assets/letter-head.jpg" class="img-responsivess" style="width: 100%; margin-bottom: 0.3em; display: block;" />
</a>
                     
              
  
  <div class="row">
    <div class="col-lg-6"><p>${body?.dynamicLetterNumberNbaOUT}</p></div>
    <div class="col-lg-6"><p align="right">Date: <g:formatDate format="dd/MM/yyyy" date="${body?.sendDate}"/></p></div>
  </div>
<p align="center"> (Only through ABS E-filing Online)</p>
<p>To</p>
<p style="line-height: 5px;">${body?.appNumber}</p>
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
<%--<p style="line-height: 5px;"><span>Senior Technical Director, </span></p>--%>
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
<%--<p style="line-height: 5px;"><span>Senior Technical Director, </span></p>--%>
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

<p>&nbsp;</p>
<p>Dear Sir / Madam,&nbsp;</p>
<p style="margin-left: 2em;">Sub: ${body?.subject} &ndash; reg.</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
${raw(body?.messageBody)}<p>&nbsp;</p>
<p>&nbsp;</p>
 <p style="font-size: 10px;"><i>NBA Reference Only :</i> </p>
<table class="table table-bordered">
  <tbody>
    <tr>
      <th>Sent To:</th>
      <td>${body?.emailId}</td>
      <th>CC to:</th>
      <td>${body?.ccEmailId}</td>
    </tr>
    <tr>
      <th>Created Date:</th>
      <td><g:formatDate format="dd/MM/yyyy" date="${body?.createdDate}"/></td>
      <th>Approved Date:</th>
      <td><g:formatDate format="dd/MM/yyyy" date="${body?.approvedDate}"/></td>
    </tr>
    <tr>
      <th>Created By:</th>
      <td>${body?.createdBy}</td>
      <th>Send By:</th>
      <td>${body?.sendBy}</td>
    </tr>
  </tbody>
</table>
        </div>    
    </div>

</div>
</div>
  </body>

</html>

