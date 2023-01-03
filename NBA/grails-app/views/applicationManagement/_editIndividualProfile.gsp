<%! import org.nba.application.IndividualProfile %>

<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
<g:uploadForm class="form-horizontal" role="form" autocomplete="off"
	action="saveEditedIndividualProfile">
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>

	<div class="col-sm-12 form-group">

		<label class="control-label col-sm-12 register-heading">(i)
			Full Particulars of the Applicant</label>

	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class="col-sm-4"><span class="col-sm-1">(a)</span> <span
			class="col-sm-10">Title</span></label>
		<div class="col-sm-8">
			<g:select id="foucuscontrol" name="title" req1="1"
				class="width controlclass1" value="${individualProfile?.title}"
				from="${IndividualProfile.TitleName.values()}"
				noSelection="['':'-Select title-']" />
		</div>
	</div>




	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(b)</span> <span
			class="col-sm-10">First Name</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="firstName"
				req1="1" alp1="1" value="${individualProfile?.firstName}">
		</div>

	</div>



	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(c) </span><span
			class="col-sm-10">Middle Name</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="middleName"
				alp1="1" value="${individualProfile?.middleName}">
		</div>

	</div>



	<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(d)</span> <span
			class="col-sm-10">Last Name</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="lastName"
				value="${individualProfile?.lastName}" req1="1" alp1="1">
		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> Nationality</span></label>
		<div class="col-sm-8">
			<g:select from="${nationality}" class="width" name="nationality"
				id="nationality" value="${individualProfile?.nationality}" />


		</div>
	</div>

	<g:if test="">
		<div class="col-sm-12 form-group" id="otherNationality">

			<label class="control-label col-sm-4">Specify Nationality</label>
			<div class="col-sm-8">
				<input type="text" class="width" name="otherNationality">

			</div>
		</div>
	</g:if>

	<div class="col-sm-12 form-group">

		<label class="control-label col-sm-12 register-heading">(ii)
			Permanent Address</label>

	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>
			<span class="col-sm-10">Address line1</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="address1"
				value="${individualProfile?.address1}" req1="1">

		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(b)</span>
			<span class="col-sm-10">Address line2</span></label>
		<div class="col-sm-8">
			<input type="text" class="width" name="address2"
				value="${individualProfile?.address2}">

		</div>
	</div>


	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(c)</span>
			<span class="col-sm-10">Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width" name="address3"
				value="${individualProfile?.address3}">

		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(d)</span>
			<span class="col-sm-10">Country</span></label>
		<div class="col-sm-8">

			<g:select name="countryId" from="${listOfCountries}" optionKey="id" optionValue="country"
				id="country" value="${individualProfile?.country?.id}" class="width  country"
				noSelection="['':'-Select-']"
				onchange="${remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId=' + this.value",update: 'updateStates')}" />

		</div>
	</div>



	<div id="updateStates"></div>



	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(f)</span>
			<span class="col-sm-10">City</span></label>
		<div class="col-sm-8">

			<input type="text" class="width controlclass1" name="city"
				value="${individualProfile?.city}" req1="1">


		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"> <span class="col-sm-1">(g)
		</span><span class="col-sm-10">ZIP/Pincode</span></label>
		<div class="col-sm-8">

			<input type="text" class="width controlclass1" name="pincode"
				value="${individualProfile?.pincode}" req1="1">


		</div>
	</div>


	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(h)</span>
			<span class="col-sm-10">Mobile</span></label>
		<div class="col-sm-8">

			<input type="text" class="width controlclass1" name="mobile"
				value="${individualProfile?.mobile}" req1="1">


		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Phone</span></label>
		<div class="col-sm-8">

			<input type="text" class="width controlclass1" name="phone"
				value="${individualProfile?.phone}">

		</div>

	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4" for="email"><span
			class="col-sm-1">(j)</span> <span class="col-sm-10">Email</span></label>
		<div class="col-sm-8">

			<input type="text" class="width controlclass1" name="email"
				value="${individualProfile?.email}" req1="1" email1="1">


		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-5"><span class="col-sm-1">(k)</span>
			<span class="col-sm-10">Attach ID proof copy with Self
				Attestation (Driving License / Goverment ID)</span></label>
		<div class="col-sm-6">

			<g:if test="${individualProfile?.idProof}">
				<g:link controller="applicationManagement" action="showIndividualDc"
					id="${individualProfile?.id}" target="_blank"
					params="[filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}']">
					${individualProfile?.idProofFileName}
				</g:link>
				<input type="file" class="width controlclass1" name="IdProof"
					req1="1" pdf1="1" mb10="1" onchange="validateFile(this)">
			</g:if>
			<g:else>
				<input type="file" class="width controlclass1" name="IdProof"
					req1="1" pdf1="1" mb10="1" onchange="validateFile(this)">

			</g:else>
		</div>

	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-5"><span class="col-sm-1">(l)</span><span
			class="col-sm-10"> Attach the passport copy with Self
				Attestation</span></label>
		<div class="col-sm-6">

			<g:if test="${individualProfile?.passportCopy}">
				<input type="file" class="width controlclass1" name="Passport"
					req1="1" pdf1="1" onchange="validateFile(this)">
				<g:link controller="applicationManagement" action="showIndividualDc"
					id="${individualProfile?.id}" target="_blank"
					params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
					${individualProfile?.passportCopyFileName}
				</g:link>
			</g:if>
			<g:else>
				<input type="file" class="width controlclass1" name="Passport"
					req1="1" pdf1="1" onchange="validateFile(this)">

			</g:else>


		</div>
	</div>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-5"><span class="col-sm-1">(m)</span>
			<span class="col-sm-10">Attach the Authorization letter, if
				necessary</span></label>
		<div class="col-sm-6">

			<g:if test="${individualProfile?.authorizationLetter}">
				<input type="file" class="width controlclass1 " pdf1="1" mb5="1"
					name="AuthorityLetter" onchange="validateFile(this)">
				<g:link controller="applicationManagement" action="showIndividualDc"
					id="${individualProfile?.id}" target="_blank"
					params="[filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}']">
					${individualProfile?.authorizationLetterFileName}
				</g:link>
			</g:if>
			<g:else>
				<input type="file" class="width controlclass1 " pdf1="1" mb5="1"
					name="AuthorityLetter" onchange="validateFile(this)">

			</g:else>
		</div>


	</div>

	<div class="col-sm-12 form-group ">

		<label class="control-label col-sm-12 register-heading">(iii)
			Profile of the Applicant(s)</label>

	</div>

	<div class="col-sm-12 form-group">

		<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>
			<span class="col-sm-10">Profile</span></label>
		<div class="col-sm-8">
			<select class="width controlclass1" name="profile" value= "${individualProfile?.profile}" id="profile"
				req1="1">
				<option value="">Select</option>
				<option value="Scientist">Scientist</option>
				<option value="student">Student</option>
				<option value="researcher">Researcher</option>

				<option value="others">Others</option>
			</select>

		</div>
	</div>


	<div class="col-sm-12 form-group" id="otherProfile">

		<label class="control-label col-sm-4"><span class="col-sm-1">(b)</span>
			<span class="col-sm-10"> Please Specify</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1">
		</div>

	</div>
	<div class="col-sm-12 text-right top_Pad">
		<g:hiddenField name="profileId" value="${individualProfile?.id}" />
		<g:hiddenField name="formType" value="${formType}" />
		<input type="Submit" class="btn btn-primary btncontrolclass1"
			value="Submit"></input> <input type="button"
			class="btn btn-primary focusbtn " value="Add more"></input>
	</div>
	
</g:uploadForm>