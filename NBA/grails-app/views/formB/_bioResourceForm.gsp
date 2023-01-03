


<div class="main-registeration col-sm-12">
	<g:formRemote name="biologicalResources" class="form-horizontal"
		id="biologicalResources" role="form" autocomplete="off"
		url="[controller:'formB',action:'bioResourceSubmit']"
		update="updateBioResourceGrid" onSuccess="ClearAllFields()"
		onComplete="loadPage()">
		<input type="hidden" name="csrfPreventionSalt"
			value="${csrfPreventionSalt}" />

		<div id="bioresouceFormB">
			<div class="form-title col-sm-12 margin-top">
				<label class="register-heading"><span class="leftflot">
						(8)</span><span class="col-sm-11">Details of biological resources
						proposed to be carried along or sent for the research </span></label>
			</div>
<%--			<div class="col-sm-12 form-group less-padding">--%>
<%----%>
<%--				<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>--%>
<%--					<span class="col-sm-10">Intend to access</span></label>--%>
<%--				<div class="col-sm-8">--%>
<%----%>
<%--					<div class=" row form-group less-padding">--%>
<%----%>
<%--						<span class="col-sm-5"> <input type="radio"--%>
<%--							name="accessIntention" value="Biological Resources"--%>
<%--							id="tradditional" onclick="showhidewithValidation(this)"--%>
<%--							class="istradditional radio col-sm-1"><span--%>
<%--							class="leftflot">&nbsp;Biological Resources</span></span> <span--%>
<%--							class="col-sm-5"> <input type="radio"--%>
<%--							name="accessIntention" value="Associated Knowledge"--%>
<%--							id="tradditional" onclick="showhidewithValidation(this)"--%>
<%--							class="istradditional radio col-sm-1"><span--%>
<%--							class="leftflot">&nbsp;Associated Knowledge</span>--%>
<%--						</span> <span class="col-sm-2"> <input type="radio"--%>
<%--							name="accessIntention" value="Both" id="tradditional"--%>
<%--							onclick="showhidewithValidation(this)"--%>
<%--							class="istradditional radio col-sm-1"><span--%>
<%--							class="leftflot">&nbsp;Both</span>--%>
<%--						</span>--%>
<%----%>
<%--					</div>--%>
<%----%>
<%--				</div>--%>
<%--			</div>--%>


					<div class="col-sm-12 form-group less-padding">
			
					<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>
						<span class="col-sm-10">Type of access <span class="text-danger">*</span> </span></label>
					<div class="col-sm-8">
						<div class=" row form-group ">
			
							<g:if test="${!bioResource }">
								<span class="col-sm-6"> <input type="radio"
									name="accessIntention" value="Biological Resources" id="tradditional"
									onclick="showhidewithValidation(this)"
									class="istradditional radio col-sm-1"><span
									class="leftflot">&nbsp;Carried along for the research</span></span>
			
								<span class="col-sm-5"> <input type="radio"
									name="accessIntention" value="Associated Knowledge" id="tradditional"
									onclick="showhidewithValidation(this)"
									class="istradditional radio col-sm-1"><span
									class="leftflot">&nbsp;Sent for the Research</span>
								</span>
			
								<%--<span class="col-sm-2"> <input type="radio"
									name="accessIntention" value="Both" id="tradditional"
									onclick="showhidewithValidation(this)"
									class="istradditional radio col-sm-1"><span
									class="leftflot">&nbsp;Both</span>
								</span>
							--%></g:if>
							<g:elseif test="${bioResource?.accessIntention }">
								<g:if test="${bioResource?.accessIntention == 'Carried along for the research' }">
									<span class="col-sm-6"> <input type="radio"
										name="accessIntention" checked="checked" value="Biological Resources"
										id="tradditional" onclick="showhidewithValidation(this)"
										class="istradditional radio col-sm-1"><span
										class="leftflot">&nbsp;Carried along for the research</span></span>
								</g:if>
								<g:else>
									<span class="col-sm-6"> <input type="radio"
										name="accessIntention" value="Biological Resources" id="tradditional"
										onclick="showhidewithValidation(this)"
										class="istradditional radio col-sm-1"><span
										class="leftflot">&nbsp;Carried along for the research</span></span>
								</g:else>
			
								<g:if test="${bioResource?.accessIntention == 'Sent for the Research' }">
									<span class="col-sm-5"> <input type="radio"
										name="accessIntention" checked="checked" value="Associated Knowledge"
										id="tradditional" onclick="showhidewithValidation(this)"
										class="istradditional radio col-sm-1"><span
										class="leftflot">&nbsp;Sent for the Research</span>
									</span>
								</g:if>
								<g:else>
									<span class="col-sm-5"> <input type="radio"
										name="accessIntention" value="Associated Knowledge" id="tradditional"
										onclick="showhidewithValidation(this)"
										class="istradditional radio col-sm-1"><span
										class="leftflot">&nbsp;Sent for the Research</span>
									</span>
								</g:else>
			
								<%--<g:if test="${bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' }">
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
			
							--%></g:elseif>
						</div>
					</div>
				</div>


			<%--
			--%>
			
			
			<div class="form-title col-sm-12 margin-top">
				<label class="register-heading"><span class="leftflot">
						(i)</span><span class="col-sm-11">Identification (Scientific name) of biological resources. </span></label>
			</div>
			
			
			
			<div class="col-sm-12 form-group less-padding">

				<label class="control-label col-sm-4"><span class="col-sm-1">(a)</span>
					<span class="col-sm-10"> Nature of biological resources</span></label>
				<div class="col-sm-8">
					<g:each in="${natureOfReources}" var="resource">
						<g:if test="${bioResource?.nature == resource }">
							<input type="radio" name="nature" req1="1" onclick="removeReqForMicroorganism()"
								class="Associate controlclass leftflot" value="${resource}"
								checked="checked" />
											&nbsp;${resource}</br>
						</g:if>
						<g:else>
							<input type="radio" name="nature" onclick="removeReqForMicroorganism()" value="${resource}" />
							${resource}</br>
						</g:else>
					</g:each>

				</div>
			</div>
			
			
			<div class="col-sm-12 form-group less-padding">

				<label class="control-label col-sm-4"><span class="col-sm-1">(b)</span>
					<span class="col-sm-10"> Common Name
						
						<span class="text-danger" id="mandatoryAstrik"><b>*</b></span>
						
					</span></label>
				<div class="col-sm-8" >
					<input id="foucuscontrol" type="text" req1="1"
						class="width controlclass Associate commonName" name="commonName"
						value="${bioResource?.commonName }">
				</div>

			</div>




			<div class="col-sm-12 form-group less-padding">

				<label class="control-label col-sm-4"><span class="col-sm-1">(c)</span>
					<span class="col-sm-10"> Scientific Name <span
						class="text-danger"><b>*</b></span>
				</span> </label>
				<div class="col-sm-8">

					<input type="text" class="width controlclass Associate" req1="1"
						name="scientificName" value="${bioResource?.scientificName }"
						alp1="1">

				</div>
			</div>


			
			


			<div class="col-sm-12 form-group less-padding">

				<label class="control-label col-sm-4"><span class="col-sm-1">(d)</span>
					<span class="col-sm-10"> Part of biological resources<span
						class="text-danger"><b>*</b></span>
				</span> </label>
				<div class="col-sm-8">
					<g:if test="${bioResource?.biologicalResource?.contains('-') }">
						<g:select name="bioResource" id="source" from="${resources}"
							onchange="hideshowother(this,'other')"
							value="${bioResource?.biologicalResource?.split('-')[0] }"
							class="width controlclass Associate dsblcontrol1"
							noSelection="['':'-Select-']" req1="1" />
					</g:if>
					<g:else>
						<g:select name="bioResource" id="source" from="${resources}"
							value="${bioResource?.biologicalResource }"
							onchange="hideshowother(this,'other')"
							class="width controlclass Associate dsblcontrol1"
							noSelection="['':'-Select-']" req1="1" />
					</g:else>
				</div>
			</div>
			<div id="other" class="col-sm-12 form-group less-padding ">

				<g:if test="${bioResource?.biologicalResource?.contains('-') }">
					<label class="control-label col-sm-4 "><span
						class="col-sm-1"></span> <span class="col-sm-10">Please
							specify <span class="text-danger"><b></b></span>
					</span> </label>

					<div class="col-sm-8">
						<input type="text" name="pleaseSpecify"
							value="${bioResource?.biologicalResource?.split('-')[1] }"
							class="width " />
					</div>
				</g:if>
				<g:elseif test="${bioResource?.biologicalResource != 'Others' }">
					<label class="control-label col-sm-4 "><span
						class="col-sm-1"></span> <span class="col-sm-10">Please
							specify <span class="text-danger"><b></b></span>
					</span> </label>
					<div class="col-sm-8">
						<input type="text" name="pleaseSpecify" value="" class="width " />
					</div>
				</g:elseif>

			</div>

			<div class="col-sm-12 form-group less-padding">
				<label class="control-label col-sm-4"><span class="col-sm-1">(e)</span>
					<span class="col-sm-10"> Quantity of the biological resource
						<span class="text-danger"><b>*</b></span>
				</span> </label>
				<div class="col-sm-3">
					<input type="text" onfocusout="checkZeroValue(this)" req1="1"
						class="width controlclass Associate num" name="quantity"
						value="${bioResource?.quantity }" />
				</div>
				<div class="col-sm-3">
					<g:select name="qtyUnit" from="${quantityList}"
						value="${bioResource?.qtyUnit }"
						class="width controlclass Associate dsblcontrol1"
						noSelection="['':'-Select-']" />
				</div>

			</div>


			<%--<div class="col-sm-12 form-group less-padding">

				<label class="control-label col-sm-4"><span class="col-sm-1">(g)</span>
					<span class="col-sm-10"> Time span in which the biological
						resource is proposed to be collected <span class="text-danger"><b>*</b></span>
				</span> </label>
				<div class="col-sm-3">
					<label>From:</label> <input type="text"
						class="controlclass  width datePicker fromTime"
						value="${bioResource?.fromTime?.format('dd/MM/yyyy') }"
						name="fromTime">
				</div>
				<div class="col-sm-3">
					<label>To:</label> <input type="text"
						class="controlclass  width datePicker toTime"
						value="${bioResource?.toTime?.format('dd/MM/yyyy') }"
						name="toTime">
				</div>

			</div>
			--%>
			
			<%--<div class="col-sm-12 form-group less-padding">

				<label class="control-label col-sm-4" for="email"><span
					class="col-sm-1">(h)</span> <span class="col-sm-10">
						Traditional use, if any </span> </label>
				<div class="col-sm-8">
					<input type="text" class=" width controlclass " maxword50="1"
						name="traditionalUse" value="${bioResource?.traditionalUse }">
				</div>

			</div>
		--%>
		
		</div>

		<div class="form-group col-sm-12 text-right less-padding">

			<g:hiddenField name="bioResourceId" value="${bioResource?.id}" />
			<g:hiddenField name="appFormId" value="${appForm?.id}" />
			<g:hiddenField name="formType" value="${formType}" />
			<input type="Submit" class="btn btn-primary  btnclass btnctrl"
				value="Save"></input> <input type="button"
				class="btn btn-primary focusbtn " value="Add More"></input>

		</div>

	</g:formRemote>
</div>