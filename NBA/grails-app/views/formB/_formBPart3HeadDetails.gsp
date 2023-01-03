
<g:uploadForm name="fundindAgencyForm" class="form-horizontal"
	role="form" autocomplete="off"
	controller="formB">

	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(5) Details of the Supervisor or Head of Institution or organization who guides the proposed research or recipient of the biological resources</label>
	</div>
		<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-6"><span class="col-sm-1">(a)</span>
			<span class="col-sm-10">Category<span class="text-danger"><b></b></span></span></label>
		<div class="col-sm-12" style="margin-top: 16px; margin-bottom: 16px;">
			
			<g:if test="${!entity2 }">
				<div class="col-sm-12">
					<input type="radio" name="category" onclick="hideAddressProofDiv()" value="contactDetails1">&nbsp;<b>Contact details of the Supervisor of the Institution or Organization who guides the proposed research outside India</b>
				</div>
				<div class="col-sm-12">
					<input type="radio" name="category" onclick="hideAddressProofDiv()" value="contactDetails2">&nbsp;<b>Contact details of the Head of the Institution or Organization who guides the proposed research outside India</b>
				</div>
				<div class="col-sm-12">
					<input type="radio" name="category" onclick="showAddressProofDiv()" value="contactDetails3">&nbsp;<b>Contact details of the recipient of the biological resources outside India</b>
				</div>
			</g:if>
			<g:else>
				
				<g:if test="${entity2?.category == 'contactDetails1' }">
					<div class="col-sm-12">
						<input type="radio" name="category" onclick="hideAddressProofDiv()" value="contactDetails1" checked>&nbsp;<b>Contact details of the Supervisor of the Institution or Organization who guides the proposed research outside India</b>
					</div>
				</g:if>
				<g:else>
					<div class="col-sm-12">
						<input type="radio" name="category" onclick="hideAddressProofDiv()" value="contactDetails1">&nbsp;<b>Contact details of the Supervisor of the Institution or Organization who guides the proposed research outside India</b>
					</div>
				</g:else>
				
				<g:if test="${entity2?.category == 'contactDetails2' }">
					<div class="col-sm-12">
						<input type="radio" name="category" onclick="hideAddressProofDiv()" value="contactDetails2" checked>&nbsp;<b>Contact details of the Head of the Institution or Organization who guides the proposed research outside India</b>
					</div>
				</g:if>
				<g:else>
					<div class="col-sm-12">
						<input type="radio" name="category" onclick="hideAddressProofDiv()" value="contactDetails2">&nbsp;<b>Contact details of the Head of the Institution or Organization who guides the proposed research outside India</b>
					</div>
				</g:else>
				
				<g:if test="${entity2?.category == 'contactDetails3' }">
					<div class="col-sm-12">
						<input type="radio" name="category" onclick="showAddressProofDiv()" value="contactDetails3" checked>&nbsp;<b>Contact details of the recipient of the biological resources outside India</b>
					</div>
				</g:if>
				<g:else>
					<div class="col-sm-12">
						<input type="radio" name="category" onclick="showAddressProofDiv()" value="contactDetails3" >&nbsp;<b>Contact details of the recipient of the biological resources outside India</b>
					</div>
				</g:else>
				
			</g:else>
			
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Name of the Supervisor or Head of
				Institution or recipient outside India<span class="text-danger"><b>*</b></span>
		</span></label>
		
		<div class="col-sm-8">
			<input type="text" class="width controlreq" value="${entity2?.name}" name="name"
				req1="1">
		</div>
	</div>


	<div class="col-sm-12 form-group ">
		<div class="form-group col-sm-12">
			<label class=" col-sm-12 ">(c) Complete address</label>
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10">Address line1<span class="text-danger"><b>*</b></span> </span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" req1="1" name="address1" value="${entity2?.address1}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ii)</span><span
			class="col-sm-10">Address line2 </span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="address2" value="${entity2?.address2}">
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iii) </span><span
			class="col-sm-10"> Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="address3" value="${entity2?.address3}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
	<label class=" col-sm-4"><span class="col-sm-1">(iv)</span> <span
			class="col-sm-10"> Country<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
<%--			<input type="text" class="width ctlwidth" name="country" req1="1" readonly--%>
<%--				value="India">--%>

				<g:select name="countryId" from="${listOfCountries}" optionKey="id"
					optionValue="country" value="${entity2?.country1?.id}"
					class="width controlreq" noSelection="['':'-Select-']"
					req1="1" />


		</div>
		
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(v)</span> <span
			class="col-sm-10"> State/Province <span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
<%--			<g:select name="state" from="${listOfStates?.state}" id="state" req1="1"--%>
<%--				class=" width controlreq" value="${entity2?.state}"--%>
<%--				noSelection="['':'Select State']" />--%>

				<input type="text" class="width controlreq" name="state" req1="1"
					value="${entity2?.state}">

		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vi)</span> <span
			class="col-sm-10"> City<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="city" req1="1"
				value="${entity2?.city}">
		</div>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(vii)</span> <span
			class="col-sm-10"> ZIP<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="pincode" req1="1" value="${entity2?.pincode}">
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii)</span> <span
			class="col-sm-10"> Mobile</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="mobile" mob1="1" num1="1" value="${entity2?.mobile}">
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ix)</span> <span
			class="col-sm-10"> Phone</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="phone" mob1="1" num1="1" value="${entity2?.phone}">
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(x)</span> <span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="email" req1="1" email1="1" value="${entity2?.email}">
		</div>
	</div>
	
	<div class="col-sm-12 form-group less-padding" id="recipientOutsideIndia">

			<label class="control-label col-sm-4" font size="3"><span class="col-sm-1">(xi)</span>
				<span class="col-sm-10">Attach address proof with Self attestation<span class="text-danger"><b>*</b></span> </span></label>
				
			<g:if test="${entity2?.addressproofLetter}">
				<div class="col-sm-2 klm-select">
					<g:select id="foucuscontrol" name="addressproofSelect"
						class="width controlreq addressproofSelect" req1="1"
						value="${entity2?.addressproofSelect }"
						from="${recipientAddressProof }"  />
				</div>

				<div class="col-sm-2 klm-number">
					<input type="text" class="width controlreq addressproofNo" req1="1"
						name="addressproofNo" value="${entity2?.addressproofNo }">
				</div>

				<div class="col-sm-3 klm-fileUpload">

					<input type="file" class="width  controlreq addressproofLetter" name="addressproofLetter" req1="1"
						value="${entity2?.addressproofLetter }">
					<g:link controller="formB"
						action="showUndertakingFile" id="${entity2?.id}"
						target="_blank"
						params='[filename: "addressproofLetter",appFormId:"${appForm?.id }",csrfPreventionSalt:"${csrfPreventionSalt}"]'>
						${entity2?.addressproofLetterFileName}
					</g:link>
				</div>
			</g:if>
			<g:else>

				<div class="col-sm-2 klm-select">
					<g:select id="foucuscontrol" name="addressproofSelect" req1="1"
						class="width controlreq addressproofSelect" value="" from="${recipientAddressProof}"
						 />
				</div>

				<div class="col-sm-2 klm-number">
					<input type="text" class="width controlreq addressproofNo" req1="1"
						name="addressproofNo" placeholder="Address Proof No." value="">
				</div>

				<div class="col-sm-3 klm-fileUpload">

					<input type="file" class="width  controlreq addressproofLetter" pdf1="1" mb5="1" req1="1"
						name="addressproofLetter">
				</div>

			</g:else>
		</div>
	
	
	<div class="col-sm-12 form-group text-right">
		<%--<input type="button" class="btn btn-primary" value="Save"/>
		 --%>
		 <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
		 <g:hiddenField name="type" value="supervisor" />
		 <g:hiddenField name="part" value="part3" />
		 <g:hiddenField name="formType" value="${formType}" />
			<g:hiddenField name="appFormId" value="${appForm?.id}" />
		 <g:actionSubmit action="saveFormBEntity" class="btn btn-primary  btncontrol" value="Save"></g:actionSubmit>
	</div>
</g:uploadForm>