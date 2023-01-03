<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <asset:stylesheet src="beta-version/css/bootstrap.min.css"/>
<style>
  /*  background: #222 url('https://images.unsplash.com/photo-1498612753354-772a30629934?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60') center center no-repeat; */

.cover {
    background: #222 url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcToTsDVtOUq-BgK6a7yjOs0WZ_IgxjQL1jekbgl6V3P03V89xM4') center center no-repeat;
    background-size: cover;
    height: 100%;
    text-align: center;
    align-items: center;
    position: relative;
}
body {
    padding: 0;
    margin: 0;
}

html { -webkit-text-size-adjust:none; -ms-text-size-adjust: none;}
@media only screen and (max-device-width: 680px), only screen and (max-width: 680px) {
    *[class="table_width_100"] {
        width: 96% !important;
    }
    *[class="border-right_mob"] {
        border-right: 1px solid #dddddd;
    }
    *[class="mob_100"] {
        width: 100% !important;
    }
     .iage_footer a {
        text-decoration: none;
        color: #929ca8;
    }
      img.mob_display_none {
        width: 0px !important;
        height: 0px !important;
        display: none !important;
    }
      img.mob_width_50 {
        width: 40% !important;
        height: auto !important;
    }
    *[class="mob_center"] {
        text-align: center !important;
    }

}
.table_width_100 {
    width: 680px;
}
</style>
    </head>
    <body>

<div id="mailsub" class="notification" align="center">
<table width="100%"  style="min-width: 320px;">
    <tr><td align="center" >



		<table class="table_width_100" width="100%" style="max-width: 680px; min-width: 300px;">
      
			<tr><td>
			<!-- padding --><div style="height: 80px; line-height: 80px; font-size: 10px;"> </div>
			</td></tr>
			<!--header -->
			<tr><td align="center">
				<!-- padding --><div style="height: 30px; line-height: 30px; font-size: 10px;"> </div>
		  
				<table width="90%" >
					<tr><td align="left"><!--

						Item --><div class="mob_center_bl" style="float: left; display: inline-block; width: 115px;">
						<table class="mob_center" width="115" border="0" cellspacing="0" cellpadding="0" align="left" style="border-collapse: collapse;">
                        <tr><td align="left" valign="middle">
                            <!-- padding --><div style="height: 20px; line-height: 20px; font-size: 10px;"> </div>
                          <table width="115" border="0" cellspacing="0" cellpadding="0" >
                                <tr><td align="left" valign="top" class="mob_center">
                                    <a href="https://absefiling.nic.in/NBA/login/auth" target="_blank">
                             <img src="https://absefiling.nic.in/NBA/assets/letter-head.jpg" width="600"  alt="NBA" border="0" style="display: block;" /></a>
                                </td></tr>
                            </table>
                        </td></tr>
                    </table></div><!-- Item END--><!--[if gte mso 10]>
                    </td>
                    <td align="right">
                <![endif]-->

              </td>
            </tr>
        </table>
        <!-- padding <div style="height: 50px; line-height: 50px; font-size: 10px;"> </div> -->
    </td></tr>
    <!--header END-->

    <!--content 1 -->
    <tr><td align="center">
        <table width="90%" >
     <div style="height: 20px; line-height: 20px; font-size: 10px;"> </div>
         <div class="row">
    <div class="col-lg-6"><p>${emailInstance?.dynamicLetterNumberNbaOUT}</p></div>
    <div class="col-lg-6"><p align="right">Date: <g:formatDate format="dd/MM/yyyy" date="${emailInstance?.sendDate}"/></p></div>
  </div>               
            <tr>
            <td align="justify">
                <div style="line-height: 24px;">
                    <font face="Arial, Helvetica, sans-serif" size="4" color="#57697e" style="font-size: 15px;">
                    <span style="font-family: Arial, Helvetica, sans-serif; font-size: 15px; color: #000000;">
                    
       <br>
       To:              
       <br>               
  <g:if test="${appForm1}">

<g:if test="${appForm1.individualProfiles}">
<g:each in="${appForm1.individualProfiles}" var="indi">
<p style="line-height: 5px;"><span>${indi?.title} ${indi?.firstName} ${indi?.middleName} ${indi?.lastName} &nbsp;</span></p>
<p style="line-height: 5px;"><span>${indi?.address1} ${indi?.address2} ${indi?.address3}</span></p>
<p style="line-height: 5px;"><span>Email:${indi?.email}</span></p>
</g:each>
</g:if>


<g:if test="${appForm1?.companyProfiles}">
<g:each in="${appForm1?.companyProfiles}" var="com">
<p style="line-height: 5px;"><span>${com?.entityName} &nbsp;</span></p>
<p style="line-height: 5px;"><span>${com?.address1} ${com?.address2} ${com?.address3}&nbsp;</span></p>
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

 <br>
 Dear Sir/Madam,
 <br>
 <span style="margin-left: 2em;">Sub: ${emailInstance?.subject} &ndash; reg.</span>
 
 <p>&nbsp;</p>

                    ${raw(emailInstance?.messageBody)}
                     </span></font>
                </div>
                <!-- padding --><div style="height: 40px; line-height: 40px; font-size: 10px;"> </div>
            </td></tr>
			<tr><td align="justify">
                <div style="line-height: 24px;">
                    <font face="Arial, Helvetica, sans-serif" size="4" color="#57697e" style="font-size: 15px;">
                    <span style="font-family: Arial, Helvetica, sans-serif; font-size: 15px; color: #000000;">
					<p>Regards,<br/>E-filing Team,<br/>National Biodiversity Authority
                      </p></span></font>
                </div>
                <!-- padding <div style="height: 40px; line-height: 40px; font-size: 10px;"> </div> -->
            </td></tr>
			 

        </table>
    </td></tr>
    <!--content 1 END-->


    <!--links -->
    <tr><td align="center"  style="border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: #eff2f4;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr><td align="center">
                <!-- padding --><div style="height: 32px; line-height: 32px; font-size: 10px;"> </div>
                <table width="90%" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="justify" valign="middle" style="font-size: 12px; line-height: 22px;">
                        	<font face="Tahoma, Arial, Helvetica, sans-serif" size="2" color="#282f37" style="font-size: 12px;">
                                <span style="font-family: Arial, Helvetica, sans-serif; font-size: 12px; color: red;"> <u><b>Disclaimer :</b></u></span>
								<p style="text-align:justify">This e-mail and its attachments (if any) may contain official Indian Government information. If you are not the intended recipient, please notify the sender immediately and delete this e-mail. Any dissemination or use of this information by a person other than the intended recipient is unauthorized. The responsibility lies with the recipient to check this email and any attachment for the presence of viruses.<br/>
								Please do not reply to this mail as it is a computer generated mail. For further information, please follow the instructions mentioned above.
								</p>
                      </font>
                        </td>
                    </tr>
                </table>
            </td></tr>
            <tr><td><!-- padding --><div style="height: 32px; line-height: 32px; font-size: 10px;"> </div></td></tr>
        </table>
    </td></tr>
    <!--links END-->



    <!--footer -->
    <tr><td  align="center">
        <!-- padding --><div style="height: 60px; line-height: 80px; font-size: 10px;"> </div>

        <table width="100%">
            <tr><td align="center">
                <font face="Arial, Helvetica, sans-serif" size="3" color="#96a5b5" style="font-size: 13px;">
                <span style="font-family: Arial, Helvetica, sans-serif; font-size: 14px; color: #000;">
                    2020 © NBA. ALL Rights Reserved.
                </span></font>
            </td></tr>
        </table>

        <!-- padding --><div style="height: 30px; line-height: 30px; font-size: 10px;"> </div>
    </td></tr>
    <!--footer END-->
    <tr><td>
    <!-- padding --><div style="height: 80px; line-height: 80px; font-size: 10px;"> </div>
    </td></tr>
</table>


</td></tr>
</table>

</div>

<br/>
<br/>



<asset:javascript src="beta-version/js/bootstrap.min.js"/>
<asset:javascript src="beta-version/js/jquery.min.js"/>

</body>
</html>