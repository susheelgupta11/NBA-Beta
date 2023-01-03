<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='main' />

<title>NBA</title>
	<g:javascript>
 		 var data = "${instructions}"
  	</g:javascript>
<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();

		var html = $(data);
		//alert(html)
		$('#instructions').html(html);
	});
</script>
</head>
<body>
	<div class="container">
		<div class="row ">
		<div class="col-sm-10 col-sm-offset-1 text-center form_heading">
			<h3>Instructions to applicants</h3>
			</div>
		</div>



		<div class="row">
			<g:form action="savePart4" name="knowYourFormPart4" autocomplete="off">
			<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<div class="col-sm-10 col-sm-offset-1 middle_box textalign" id="instructions">
					
					<%--<p>As part of its continuous efforts in providing upgraded
						service to its stakeholders, the NBA has introduced online
						submission of application portal, integrated to its website,
						www.nbaindia.org.</p>
					<p>To avail the service, applicants are requested to register
						as user providing a login id (4 to 20 word) with a password having
						4 to 12 word with at least one numeral or special character. Once
						registered, the user can log in and upload any number of
						applications without limit.</p>
					<p>Please keep all the information and scanned copies of the
						mandatory documents, such as, ID/Address Proof, company’s, MoA,
						AoA, shareholding pattern, Power of Attorney and Authorization
						letter ready.</p>
					<p>The following instructions will provide a step-to- step
						guide to fill up the Application Form without errors:</p>

					<span class="col-sm-12 form-group"><span class="leftflot">1.</span> <span class="col-sm-11 notificationwidth">Name of
						applicant(s) and addresses should correspond with the name
						available in the ID/Address proofs submitted. Especially for Form
						III, the name given in the patent application and the name
						provided here should be one and same.</span></span> <span
						class="col-sm-12 form-group"><span class="leftflot">2.</span> <span class="col-sm-11 notificationwidth"> If the contact person
						of the applicant is different from the person authorized to submit
						the application, separate authorization letters shall be provided
						by the applicant.</span></span>
						
						 <span class="col-sm-12 form-group"><span class="leftflot">3.</span>
						 <span class="col-sm-11 notificationwidth">If the biological resources have already been procured by a person
						covered under section 3(2) for undertaking research leading to
						filing of IPR or intended for transfer, such applicant shall
						provide scanned copies of invoices/bills along with approval for
						access granted by NBA.</span></span> 
						
						<span class="col-sm-12 form-group"><span class="leftflot">4.</span>
					 <span class="col-sm-11 notificationwidth">	If Research &amp; Development is undertaken in any national /
						other organization outside the applicant’s institution/company
						based on any agreement or MoU, a copy of such document shall be
						uploaded.</span></span> 
						
						<span class="col-sm-12 form-group"><span class="leftflot">5.</span>  <span class="col-sm-11 notificationwidth">For
						transferring the results of research/ biological resources to a
						person covered under section 3(2), if there exists any
						agreement/MoU between the transferor and the transferee, scanned
						copy of such document shall be uploaded.</span> </span> 
						<span class="col-sm-12 form-group"><span class="leftflot">6.</span> <span class="col-sm-11 notificationwidth"> If the applicants
						have entered into any agreement with any person for
						commercializing the biological resources accessed or IPR obtained,
						copy of such document shall be uploaded.</span></span> 
						
						<span
						class="col-sm-12 form-group"><span class="leftflot">7.</span>  <span class="col-sm-11 notificationwidth">If the procurement of
						the biological resources is done after entering into any benefit
						sharing agreement with the benefit claimers by the applicant, copy
						of such agreement shall be uploaded.</span></span> 
						
						<span
						class="col-sm-12 form-group"><span class="leftflot">8.</span> <span class="col-sm-11 notificationwidth">Details of benefits
						that may likely to arise out of the commercialization of the
						results of research/biological resources transferred to the
						transferor and the transferee shall be separately indicated in the
						application Form at the appropriate columns.</span></span>
						
						<br /> General 
						
						
						<span class="col-sm-12 form-group"><span class="leftflot">1.</span> <span class="col-sm-11 notificationwidth">The inputs provided in
						the application may be saved from time to time and only when the
						applicant is satisfied that complete and correct information has
						been uploaded, the Form may be submitted. Please note that after
						clicking submit button, no revision in the details already
						furnished is possible.</span></span>
						 <span class="col-sm-12 form-group"><span class="leftflot">2.</span> <span class="col-sm-11 notificationwidth">After
						entering all the details, the form can be reviewed before final
						submission.</span> </span>
						
						
						<span class="col-sm-12 form-group"><span class="leftflot">3.</span><span class="col-sm-11 notificationwidth">After
						making final submission, a reference number will be generated and
						the applicants will be directed to payment of fees page, where a
						link is provided to SBI Connect. Using the facility provided, the
						applicant can make payment of application fee through e-payment.</span></span> <span
						class="col-sm-12 form-group"><span class="leftflot">4.</span> <span class="col-sm-11 notificationwidth">After making payment,
						a receipt containing declaration part of the application will
						generate and the applicant shall take a print out of the same,
						sign it at appropriate place and send the hard copy to the
						Secretary, NBA, at the address provided in the site.</span></span>
				--%></div>
				<div class="col-sm-12 text-center">
				<g:link controller="login" action="auth" class="btn btn-primary" params='[]'>Back</g:link>
				</div>
			</g:form>
		</div>
	</div>
</body>
</html>