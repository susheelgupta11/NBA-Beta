<g:each in="${listofFormData}" var="profile">
<div class="col-sm-12 form-group less-padding">

		<label class="col-sm-4"><span class="col-sm-1">(a)</span> <span
			class="col-sm-10">Name</span></label>
		<div class="col-sm-8">
			${profile?.title} ${profile?.firstName} ${profile?.middleName} ${profile?.lastName}
		</div>

	</div>
<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Nationality</span></label>
		<div class="col-sm-8">
			${profile?.nationality}

		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(c)</span><span
			class="col-sm-10"> Address</span></label>
		<div class="col-sm-8">
			${profile?.address1}, ${profile?.address2}, ${profile?.address3}


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(d)</span><span
			class="col-sm-10"> City</span></label>
		<div class="col-sm-8">
			 ${profile?.city}
					


		</div>
	</div>
	
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(e)</span><span
			class="col-sm-10"> Country</span></label>
		<div class="col-sm-8">
			${profile?.country?.country}
					


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(f)</span><span
			class="col-sm-10"> Pincode</span></label>
		<div class="col-sm-8">
		${profile?.pincode}
					


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(g)</span><span
			class="col-sm-10"> Mobile</span></label>
		<div class="col-sm-8">
			${profile?.mobile}


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(h)</span><span
			class="col-sm-10"> Phone</span></label>
		<div class="col-sm-8">
			${profile?.phone}


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Email</span></label>
		<div class="col-sm-8">
		${profile?.email}


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(j)</span><span
			class="col-sm-10"> Attached ID proof</span></label>
		<div class="col-sm-8">
			<g:link controller="applicationManagement"
						action="showIndividualDc" id="${profile?.id}" target="_blank"
						params="[filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}']">
						${profile?.idProofFileName}
					</g:link>


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(k)</span><span
			class="col-sm-10"> Attached Passport</span></label>
		<div class="col-sm-8">
			<g:link controller="applicationManagement"
						action="showIndividualDc" id="${profile?.id}" target="_blank"
						params="[filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}']">
						${profile?.passportCopyFileName}
					</g:link>


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(l)</span><span
			class="col-sm-10"> Attached Authorization letter</span></label>
		<div class="col-sm-8">
			<g:link controller="applicationManagement"
						action="showIndividualDc" id="${profile?.id}" target="_blank"
						params="[filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}']">
						${profile?.authorizationLetterFileName}
					</g:link>


		</div>
	</div>
	<div class="col-sm-12 form-group less-padding">

		<label class=" col-sm-4"><span class="col-sm-1">(m)</span><span
			class="col-sm-10"> Profile</span></label>
		<div class="col-sm-8">
			${profile?.profile}


		</div>
	</div>
	</g:each>
	
	