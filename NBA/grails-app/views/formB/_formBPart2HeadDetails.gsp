
<g:form name="supervisorForm" class="form-horizontal"
	role="form" autocomplete="off"
	controller="formB">

	<div class="form-group col-sm-12">
		<label class=" col-sm-12 register-heading">(3) Name of the
			Supervisor or Head of Institution at the place of work in India</label>
	</div>
	<div class="col-sm-12 form-group less-padding" style="margin-left: 2px;">

		<div class="col-sm-12">
			<input type="radio" id="supervisorRadio" name="supervisorOrHoi" onclick="showsupervisorBlock()" value="supervisor">&nbsp;<b>Supervisor at the place of work in India</b>
		</div>
		<div class="col-sm-12">
			<input type="radio" id="hoiRadio" name="supervisorOrHoi" onclick="showHoiBlock()" value="headofinstitution">&nbsp;<b>Head of Institution at the place of work in India</b>
		</div>
		
	</div>
	
	
	<div class="form-group col-sm-12 less-padding supervisorBlock">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Name of the Supervisor<span class="text-danger"><b>*</b></span>
		</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" value="${entity2?.name}" id="name" name="name" req1="1">
		</div>
	</div>
	
	<div class="form-group col-sm-12 less-padding supervisorBlock">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Designation of the Supervisor <span class="text-danger"><b>*</b></span>
		</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" value="${entity2?.supervisorDesignation}" id="supervisorDesignation" name="supervisorDesignation"
				req1="1">
		</div>
	</div>
	
	<div class="form-group col-sm-12 less-padding hoiBlock">
		<label class=" col-sm-4"><span class="col-sm-1">(a)</span><span
			class="col-sm-10"> Name of the Head of Institution<span class="text-danger"><b>*</b></span>
		</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" value="${entity2?.headOfInstName}" id="headOfInstName" name="headOfInstName"
				req1="1">
		</div>
	</div>
	
	<div class="form-group col-sm-12 less-padding hoiBlock">
		<label class=" col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Designation of the Head of Institution <span class="text-danger"><b>*</b></span>
		</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" value="${entity2?.headOfInstDesignation}" id="headOfInstDesignation" name="headOfInstDesignation"
				req1="1">
		</div>
	</div>
	
	
	
	
	<div class="form-group col-sm-12">
		<label class=" col-sm-12 ">(c) Complete address of Institution in India</label>
	</div>
		
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(i)</span><span
			class="col-sm-10"> Address line1<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" req1="1" name="address1"
				value="${entity2?.address1}" >
		</div>
	</div>



	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ii)</span><span
			class="col-sm-10">Address line2 </span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="address2"
				value="${entity2?.address2}">
		</div>
	</div>




	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iii) </span><span
			class="col-sm-10"> Address line3</span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="address3"
				value="${entity2?.address3}">
		</div>
	</div>


	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(iv)</span> <span
			class="col-sm-10"> Country<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
			<input type="text" class="width controlclass1" name="country" req1="1" readonly
				value="India">
		</div>
	</div>
	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(v)</span> <span
			class="col-sm-10"> State<span class="text-danger"><b>*</b></span></span></label>
		<div class="col-sm-8">
				<g:select name="state" from="${listOfStates?.state}" id="state" req1="1"
				class="width controlreq" value="${entity2?.state}"
				noSelection="['':'Select State']" />
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
			class="col-sm-10"> Pincode<span class="text-danger"><b>*</b></span></span></label>

		<div class="col-sm-8">

			<input type="text" class="width controlreq" name="pincode"
				PlaceHolder="Pin Code" req1="1"
				value="${entity2?.pincode}">
		</div>
	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(viii) </span><span
			class="col-sm-10"> Phone</span></label>

		<div class="col-sm-8">

				<input type="text" class="width controlreq" placeholder="Phone No."  mob1="1" num1="1" 
					name="phone"  value="${entity2?.phone}" id="">
		</div>

	</div>

	<div class="form-group col-sm-12 less-padding">
		<label class=" col-sm-4"><span class="col-sm-1">(ix)</span> <span
			class="col-sm-10"> Email<span class="text-danger"><b>*</b></span></span>
		</label>
		<div class="col-sm-8">
			<input type="text" class="width controlreq" name="email"
				value="${entity2?.email}" req1="1" email1="1">
		</div>
	</div>

	
	<div class="col-sm-12 form-group text-right">
		<%--<input type="button" class="btn btn-primary" value="Save"/>
		 --%>
		 <g:hiddenField name="csrfPreventionSalt" value="${csrfPreventionSalt}" />
		 <g:hiddenField name="type" value="supervisor" />
		 <g:hiddenField name="part" value="part2" />
		 <g:hiddenField name="formType" value="${formType}" />
			<g:hiddenField name="appFormId" value="${appForm?.id}" />
		 <g:actionSubmit action="saveFormBEntity" class="btn btn-primary  btncontrol" value="Save"></g:actionSubmit>
	</div>
</g:form>