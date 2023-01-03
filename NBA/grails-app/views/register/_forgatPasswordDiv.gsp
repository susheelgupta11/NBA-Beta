<g:if test="${isSuccessMsg == true}">
	<div class="form-group col-sm-12" style="text-align: center;">
		<span class="text-success">
			${message}
		</span>
	</div>
</g:if>
<div class="form-group col-sm-12">
	<div class="col-md-6 ">
		<b >Enter old Password:</b><br />
	</div>
	<div class="col-md-6 ">
		<input type="password" name="oldPassword" req="1" autocomplete="off"
			/>
	</div>

</div>
<div class="form-group col-sm-12">
	<div class="col-md-6 ">
		<b >Enter New Password:</b><br />
	</div>
	<div class="col-md-6">
		<input type="password" name="newPassword" class="password" req="1" autocomplete="off" Passfmt="1" whiteSpace="1"
			/>
	</div>
</div>
<div class="form-group col-sm-12">
	<div class="col-md-6 ">
		<b >Enter Confirm Password:</b><br />
	</div>
	<div class="col-md-6"> 
		<input type="password" autocomplete="off" name="confirmPassword" req="1" class="confirmpassword" 
			/>
	</div>
</div>
<div class="col-sm-12 form-group text-center">
	<input type="submit" value="Change"
		class="btn btn-primary ButtonPadding "></input>
		
		<g:link controller="loggedInAs" action="index"
		class="btn btn-primary col-sm-offset-1 ButtonPadding " params='[csrfPreventionSalt:"${csrfPreventionSalt}"]'>Back</g:link>

</div>
