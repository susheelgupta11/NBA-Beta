<!DOCTYPE html>
<html lang="en">

<head>
<meta name='layout' content='loggedInUser' />

<title>NBA</title>
<script type="text/javascript">
	$(function() {
		$(".next").attr("disabled","disabled");
		Errormessage();
	});
</script>
</head>
<body>
	<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2 text-center form_heading">
			<h3>Know Your Application Form</h3>
		</div>
</div>
		
<%--		<div class="row">--%>
<%--			<h4 class="col-sm-8 col-sm-offset-3">--%>
<%--				<b>Fill up the following details to know your Application--%>
<%--					form</b>--%>
<%--			</h4>--%>
<%--		</div>--%>
		<div class="row">
			<g:form action="savePart1" name="knowYourFormPart1" autocomplete="off">
			<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>
				<div class="col-sm-8 col-sm-offset-2 middle_box">
				<div class="col-sm-12 form-group text-center">
				<span id="errormsg" class="text-danger"></span>
				</div>
				<div class="col-sm-12 form-group">
					<span class="heading_font"><b>I am a/an</b></span> </div> 
					<div class="col-sm-12 form-group ">
					<input type="radio" name="nationality" onclick="Disableknowformbtn(this)"
						value="Indian" class="radio  col-sm-1" /><span class="rbo_font col-sm-11 ">
						Indian Individual(s)</span> </div>
						
						<div class="col-sm-12 form-group">
						<input
						type="radio" name="nationality" onclick="Disableknowformbtn(this)" value="Non-Indian"
						class="radio  col-sm-1" /><span class="rbo_font col-sm-11">Non-Indian Individual(s)</span> </div>
						
						<div class="col-sm-12 form-group">
						<input type="radio" name="nationality" onclick="Disableknowformbtn(this)"
						value="NRI" class="radio  col-sm-1" /><span class="rbo_font col-sm-11">
						NRI Individual(s)</span></div>
						
						<div class="col-sm-12 form-group">
						<input type="radio" name="nationality" onclick="Disableknowformbtn(this)"
						value="Body Corporate1" class="radio  col-sm-1"  /><span class="rbo_font col-sm-11">
						Body corporate, association or organization incorporated or registered in India, which do not have any non-Indian participation in share capital or management</span></div>
						
						<div class="col-sm-12 form-group">
						<input type="radio" name="nationality" onclick="Disableknowformbtn(this)"
						value="Body Corporate2" class="radio col-sm-1" /><span class="rbo_font col-sm-11 ">
						Body corporate, association or organization incorporated or registered in India, having non-Indian participation in share capital or management</span></div>
						
						<div class="col-sm-12 form-group">
						<input type="radio" name="nationality" onclick="Disableknowformbtn(this)"
						value="Body Corporate3" class="radio col-sm-1 " /><span class="rbo_font col-sm-11 ">
						Body corporate, association or organization not incorporated or registered in India</span><br /> <span class="leftflot">&nbsp;</span><br/>
						</div>
						
						<div class="col-sm-12 form-group">
						<input type="radio" name="nationality" onclick="Disableknowformbtn(this)"
						value="Body Corporate4" class="radio col-sm-1 " /><span class="rbo_font col-sm-11 ">
						Indian Government Institution</span><br /> <span class="leftflot">&nbsp;</span><br/>
						</div>
						
						
						
					<div class="col-sm-12 ">
					<g:link controller="loggedInAs" action="decideForm" class="btn btn-primary pull-left" params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Back</g:link>
						<input  type="submit" class="btn btn-primary next pull-right"
							value="Next" />
							
							
						</div>
				</div>
			</g:form>
		</div>
	</div>
</body>
</html>