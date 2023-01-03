<script>
function hideShowOnEdit(){
	$('#other').hide();
	var value = $('#source').val();
	if(value == 'Others'){
		$('#other').show();
		}
	}
</script>


<g:if test="${formType == 'Form2'}">
	<label class="register-heading col-sm-12">(3) Details of
		biological resources and associated knowledge used in the research </label>
</g:if>
<g:elseif test="${formType == 'Form4'}">
	<div class="form-title">
		<label class="register-heading col-sm-12"> (2) Details of the
			biological material and traditional knowledge accessed </label>
	</div>
</g:elseif>
<g:elseif test="${formType == 'Form3'}">
	<label class="register-heading col-sm-12"> (3) Details of
		biological resources and/ or associated knowledge used in the
		invention </label>
</g:elseif>

<g:formRemote name="biologicalResources" class="form-horizontal"
	role="form" autocomplete="off"
	url="[controller:'applicationManagement',action:'saveEditForm1Part2']"
	update="updateBioResources" onSuccess="ClearAllFields()"
	onComplete="loadPage()">
<input type="hidden" name="csrfPreventionSalt" value="${csrfPreventionSalt}"/>	
	
	<g:if test="${formType == 'Form1'}">
		<div class="form-title col-sm-12 margin-top">
			<label class="register-heading"> (i) Identification
				(scientific name) of biological resources and its traditional use </label>
		</div>
	</g:if>

	<div class="col-sm-12 form-group less-padding">

		<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>
			<span class="col-sm-10">Intend to access <span class="text-danger">*</span> </span></label>
		<div class="col-sm-8">
			<div class=" row form-group ">

				<g:if test="${!bioResourceInst }">
					<span class="col-sm-5"> <input type="radio"
						name="accessIntention" value="Biological Resources" id="tradditional"
						onclick="showhidewithValidation(this)"
						class="istradditional radio col-sm-1"><span
						class="leftflot">&nbsp;Biological Resources</span></span>

					<span class="col-sm-5"> <input type="radio"
						name="accessIntention" value="Associated Knowledge" id="tradditional"
						onclick="showhidewithValidation(this)"
						class="istradditional radio col-sm-1"><span
						class="leftflot">&nbsp;Associated Knowledge</span>
					</span>

					<span class="col-sm-2"> <input type="radio"
						name="accessIntention" value="Both" id="tradditional"
						onclick="showhidewithValidation(this)"
						class="istradditional radio col-sm-1"><span
						class="leftflot">&nbsp;Both</span>
					</span>
				</g:if>
				<g:elseif test="${bioResourceInst?.accessIntention }">
					<g:if test="${bioResourceInst?.accessIntention == 'Biological Resources' }">
						<span class="col-sm-5"> <input type="radio"
							name="accessIntention" checked="checked" value="Biological Resources"
							id="tradditional" onclick="showhidewithValidation(this)"
							class="istradditional radio col-sm-1"><span
							class="leftflot">&nbsp;Biological Resources</span></span>
					</g:if>
					<g:else>
						<span class="col-sm-5"> <input type="radio"
							name="accessIntention" value="Biological Resources" id="tradditional"
							onclick="showhidewithValidation(this)"
							class="istradditional radio col-sm-1"><span
							class="leftflot">&nbsp;Biological Resources</span></span>
					</g:else>

					<g:if test="${bioResourceInst?.accessIntention == 'Associated Knowledge' }">
						<span class="col-sm-5"> <input type="radio"
							name="accessIntention" checked="checked" value="Associated Knowledge"
							id="tradditional" onclick="showhidewithValidation(this)"
							class="istradditional radio col-sm-1"><span
							class="leftflot">&nbsp;Associated Knowledge</span>
						</span>
					</g:if>
					<g:else>
						<span class="col-sm-5"> <input type="radio"
							name="accessIntention" value="Associated Knowledge" id="tradditional"
							onclick="showhidewithValidation(this)"
							class="istradditional radio col-sm-1"><span
							class="leftflot">&nbsp;Associated Knowledge</span>
						</span>
					</g:else>

					<g:if test="${bioResourceInst?.accessIntention == 'Biological Resources & Traditional Knowledge' }">
						<span class="col-sm-2"> <input type="radio"
							name="accessIntention" value="Both" checked="checked"
							id="tradditional" onclick="showhidewithValidation(this)"
							class="istradditional radio col-sm-1"><span
							class="leftflot">&nbsp;Both</span>
						</span>
					</g:if>
					<g:else>
						<span class="col-sm-2"> <input type="radio"
							name="accessIntention" value="Both" id="tradditional"
							onclick="showhidewithValidation(this)"
							class="istradditional radio col-sm-1"><span
							class="leftflot">&nbsp;Both</span>
						</span>
					</g:else>

				</g:elseif>
			</div>
		</div>
	</div>

	<%--	</g:if>--%>
	<div class="col-sm-12 less-padding form-group">
		<%--			<g:if test= "${formType == 'Form1' }">--%>


		<label class="control-label col-sm-4"><span class="col-sm-1">(b)</span><span
			class="col-sm-10"> Nature of biological resources <span class="text-danger">*</span> </span> </label>

		<%--			</g:if>--%>
		<%--			<g:else>--%>
		<%--				<label class="control-label col-sm-4">(a) Nature of--%>
		<%--					biological resources</label>--%>
		<%--			</g:else>--%>

		<div class="col-sm-8">
			<g:each in="${natureOfReources}" var="resource">
				<g:if test="${bioResourceInst.nature == resource }">
					<input type="radio" name="nature" class="Associate controlclass leftflot"
						value="${resource}" checked="checked" />
					&nbsp;${resource}</br>
				</g:if>
				<g:else>
					<input type="radio" name="nature" value="${resource}" />
					${resource}</br>
				</g:else>
			</g:each>
		</div>
	</div>
	<div class="col-sm-12 less-padding form-group">
		<%--			<g:if test= "${formType == 'Form1' }">--%>

		<label class="control-label col-sm-4"><span class="col-sm-1">(c)</span>
			<span class="col-sm-10"> Common Name</span> </label>

		<%--			</g:if>--%>
		<%--			<g:else>--%>
		<%--				<label class="control-label col-sm-4">(b) Common Name</label>--%>
		<%--			</g:else>--%>

		<div class="col-sm-8">
			<input id="foucuscontrol" type="text"
				class="width controlclass Associate" name="commonName"
				value="${bioResourceInst?.commonName }" req1="1">
		</div>
	</div>




	<div class="col-sm-12 less-padding form-group">

		<%--			<g:if test= "${formType == 'Form1' }">--%>

		<label class="control-label col-sm-4"><span class="col-sm-1">(d)</span>
			<span class="col-sm-10"> Scientific Name</span> </label>

		<%--			</g:if>--%>
		<%--			<g:else>--%>
		<%--				<label class="control-label col-sm-4">(c) Scientific Name</label>--%>
		<%--			</g:else>--%>

		<div class="col-sm-8">

			<input type="text" class="width controlclass Associate"
				name="scientificName" value="${bioResourceInst?.scientificName }"
				req1="1" alp1="1">
		</div>
	</div>

	<div class="col-sm-12 less-padding form-group">

		<%--			<g:if test= "${formType == 'Form1' }">--%>

		<label class="control-label col-sm-4"><span class="col-sm-1">(e)</span>
			<span class="col-sm-10"> Part of biological resources </span> </label>

		<%--			</g:if>--%>
		<%--			<g:else>--%>
		<%--				<label class="control-label col-sm-4">(d) Part of biological--%>
		<%--				resources* </label>--%>
		<%--			</g:else>--%>

		<div class="col-sm-8">
			<g:if test="${bioResourceInst?.biologicalResource?.contains('-') }">
				<g:select name="bioResource" id="source" from="${resources}"
					onchange="hideshowother(this,'other')"
					value="${bioResourceInst?.biologicalResource?.split('-')[0] }"
					class="width controlclass Associate dsblcontrol1"
					noSelection="['':'-Select-']" req1="1" />
			</g:if>
			<g:else>
				<g:select name="bioResource" id="source" from="${resources}"
					value="${bioResourceInst?.biologicalResource }"
					onchange="hideshowother(this,'other')"
					class="width controlclass Associate dsblcontrol1"
					noSelection="['':'-Select-']" req1="1" />
			</g:else>
		</div>
	</div>

	<div id="other" class="col-sm-12 form-group less-padding ">

		<g:if test="${bioResourceInst?.biologicalResource?.contains('-') }">
			<label class="control-label col-sm-4 "><span class="col-sm-1">(i)</span>
				<span class="col-sm-10">Please specify <span
					class="text-danger"><b>*</b></span>
			</span> </label>

			<div class="col-sm-8">
				<input type="text" name="pleaseSpecify"
					value="${bioResourceInst?.biologicalResource?.split('-')[1] }"
					class="width " />
			</div>
		</g:if>
		<g:else>
			<label class="control-label col-sm-4 "><span class="col-sm-1">(i)</span>
				<span class="col-sm-10">Please specify <span
					class="text-danger"><b>*</b></span>
			</span> </label>
			<div class="col-sm-8">
				<input type="text" name="pleaseSpecify" value=""
					class="width " />
			</div>
		</g:else>

	</div>



	<g:if test="${formType == 'Form4'}">
		<div class="col-sm-12 form-group">
			
				<label class="control-label col-sm-4">(f) Quantity of the
					biological resource to be transferred<span class="text-danger">*</span> </label>

				<div class="col-sm-2">
					<input type="text" class="width ctrl " name="quantity" req1="1"
						num="1" focusout="checkZeroValue(this)"
						value="${bioResourceInst?.quantity }">
				</div>
				<div class="col-sm-2">
					<g:select name="qtyUnit" from="${quantityList}"
						value="${bioResourceInst?.qtyUnit }"
						class="width ctrl dsblcontrol1" noSelection="['':'-Select-']"
						req1="1" />
				
			</div>
		</div>
		<div class="col-sm-12 form-group">
			
				<label class="control-label col-sm-12">(g) Details of
					associated traditional knowledge proposed to be transferred. </label>
				<div class="col-sm-12">
					<g:textArea class="width ctrl1" txtreq1="1"
						placeHolder="Provide details in 100 words"
						name="traditionalKnowledgeDesc"
						value="${bioResourceInst?.bioResouceTraditionalKnowledge}"></g:textArea>
				</div>
			
		</div>
	</g:if>
	<g:if test="${bioResourceInst?.biologicalResource == "Others" }">
		<div class="col-sm-12 form-group" id="otherSource">
			
				<label class="control-label col-sm-4"> Please specify</label>
				<div class="col-sm-8">
					<input type="text" name="otherSource"
						value="${bioResourceInst?.biologicalResource}" class="width ctrl1">
				</div>
			</div>
		
	</g:if>

	<g:if test="${formType == 'Form1'}">
		<div class="col-sm-12 form-group less-padding" >
			

				<g:if test="${formType == 'Form1' }">
					<label class="control-label col-sm-4"><span class="col-sm-1">(f)</span><span class="col-sm-10"> Quantity of the
						biological resource </spanc></label>
				</g:if>
				<g:else>
					<label class="control-label col-sm-4"><span class="col-sm-1">(e)</span><span class="col-sm-10"> Quantity of the
						biological resource </span></label>
				</g:else>
				<div class="col-sm-3">
					<input type="text" class="width controlclass Associate num"
						name="quantity" value="${bioResourceInst?.quantity }">
				</div>
				<div class="col-sm-3">
					<g:select name="qtyUnit" from="${quantityList}"
						value="${bioResourceInst?.qtyUnit }"
						class="width controlclass Associate dsblcontrol1"
						noSelection="['':'-Select-']" req1="1" />
				</div>
			</div>
		
	</g:if>


	<g:if test="${formType == 'Form1'}">
		<div class="col-sm-12 form-group less-padding">
			
				<label class="control-label col-sm-4"><span class="col-sm-1">(g)</span><span class="col-sm-10"> Time span in which
					the biological resource is proposed to be collected</span></label>
				<div class="col-sm-4">
					<label>From:</label> <input type="text"
						class="controlclass width datePicker" name="fromTime"
						value="${bioResourceInst?.fromTime?.format('dd/MM/yyyy') }"
						id="fromTime" req1="1">
				</div>
				<div class="col-sm-3">
					<label>To:</label> <input type="text"
						class="controlclass width datePicker" name="toTime"
						value="${bioResourceInst?.toTime?.format('dd/MM/yyyy') }"
						id="toTime" req1="1">
				</div>
			</div>
		
	</g:if>
	<g:if test="${formType == 'Form1'}">

		<div class="col-sm-12 form-group less-padding">
				<label class="control-label col-sm-4" for="email"><span class="col-sm-1">(h)</span><span class="col-sm-10">
					Traditional use, if any</span></label>
				<div class="col-sm-8">
					<input type="text" class=" width controlclass"
						name="traditionalUse" value="${bioResourceInst?.traditionalUse }"
						maxlength="50">
				</div>
			</div>
	</g:if>

	<div class="form-group col-sm-12 text-right">


		<g:hiddenField name="bioResourceInstID" value="${bioResourceInst?.id}" />
		<g:hiddenField name="formType" value="${formType}" />
		<g:hiddenField name="appFormID" value="${appFormID}" />
		<input type="Submit" class="btn btn-primary  btnclass" value="Update"></input>
		<input type="button" class="btn btn-primary focusbtn" value="Add More"></input>
	</div>

</g:formRemote>